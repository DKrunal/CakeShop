package com.cakeshop.CartController;



import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cakeshop.dao.BillingDAO;
import com.cakeshop.dao.CartDAO;
import com.cakeshop.dao.CategoryDAO;
import com.cakeshop.dao.PaymentDAO;
import com.cakeshop.dao.ProductDAO;
import com.cakeshop.dao.UserDAO;
import com.cakeshop.model.Billing;
import com.cakeshop.model.Cart;
import com.cakeshop.model.Category;
import com.cakeshop.model.Payment;
import com.cakeshop.model.Product;

@Controller
public class CartController {
	private static final Logger log = LoggerFactory.getLogger(CartController.class);
	@Autowired
	private Cart cart;

	@Autowired
	private CartDAO cartDAO;

	@Autowired
	private CategoryDAO categoryDAO;

	@Autowired
	private ProductDAO productDAO;

	@Autowired
	private Product product;

	@Autowired
	UserDAO userDAO;
	
	@Autowired
	Payment payment;
	
	@Autowired
	BillingDAO billingDAO;
	
	@Autowired
	PaymentDAO paymentDAO;

	@Autowired
	Billing billing;
	
	@Autowired
	HttpSession session;
	
	@RequestMapping(value = "/MyCart", method = RequestMethod.GET)
	public String myCart(Model model, Principal principal, HttpSession session) 
	{
		log.debug("My Cart called.");
log.info("loggedIn user"+principal.getName());
		try 
		{
			log.info("active user"+principal.getName());
			String name = principal.getName();
			model.addAttribute("cart", new Cart());
			model.addAttribute("cartList", this.cartDAO.userCartList(name));
			model.addAttribute("category", new Category());
			model.addAttribute("categoryList", this.categoryDAO.getCategory());
			model.addAttribute("displayCart", "true");

			int i;
			int sum = 0;
			int n = cartDAO.userCartList(name).size();
			
			log.info("Size of cart "+n);
			for (i = 0; i < n; i++) 
			{
				sum = sum + cartDAO.userCartList(name).get(i).getPrice();
			}
			log.info("Sum of Cart "+sum);
			session.setAttribute("cartSize",n);
			log.info("cartsize"+n);
			model.addAttribute("sum", sum);
		} 
		
		catch (Exception ex) 
		{
			ex.printStackTrace();
			log.info("Error in cart"+ex.getMessage());
			model.addAttribute("errorMessage", "Your Cart is Empty Please Add The Products");
			return "error";
		}
		return "index";
	}

	@RequestMapping(value = "MyCart_add-{id}", method = RequestMethod.GET)
	public String addToCart(@PathVariable("id") String id, HttpServletRequest request, Principal principal,Model model, HttpSession session) 
	{
		log.info("Cart add function called.");
		try 
		{

			Product product = productDAO.getProductById(id);
			Cart cart = new Cart();
			cart.setPrice(product.getPrice());
			cart.setProduct_id(product.getProduct_id());
			cart.setProduct_name(product.getName());
			cart.setQuantity(1);
			cart.setMail_id(principal.getName());
			cart.setStatus("Added to Cart");

			cartDAO.addCart(cart);
			
			int stock = product.getStock()-1;
			product.setStock(stock);
			productDAO.saveOrUpdate(product);
		
			int n=0;
			try {
				n = cartDAO.userCartList(principal.getName()).size();
			} catch (Exception e) 
			{
				log.info("Error");
			}
			session.setAttribute("cartSize",n);
			log.info("cartsize"+n);
		}
		catch (Exception e) 
		{
			log.info("Error");
		}
		return "redirect:/MyProduct-{id}";
	}
	
	@RequestMapping(value="/MyProduct-{id}")
	public String viewProduct(@PathVariable("id") String id, Model model)
	{
		log.info("Get Product initiated");
		model.addAttribute("selectedProduct", this.productDAO.getProductById(id));
		
		return "redirect:/user_products";
	}
	@RequestMapping(value = "buy_now-{id}", method = RequestMethod.GET)
	public String buyNow(@PathVariable("id") String id, HttpServletRequest request, Principal principal,Model model, HttpSession session) 
	{
		log.info("Cart add function called.");
		try 
		{

			Product product = productDAO.getProductById(id);
			Cart cart = new Cart();
			cart.setPrice(product.getPrice());
			cart.setProduct_id(product.getProduct_id());
			cart.setProduct_name(product.getName());
			cart.setQuantity(1);
			cart.setMail_id(principal.getName());
			cart.setStatus("Added to Cart");

			cartDAO.addCart(cart);
			
			int stock = product.getStock() - 1;
			product.setStock(stock);
			productDAO.saveOrUpdate(product);
		
			int n=0;
			try {
				n = cartDAO.userCartList(principal.getName()).size();
			} catch (Exception e) 
			{
				log.info("Error");
			}
			session.setAttribute("cartSize",n);
			
			log.info("cartsize"+n);
		}
		catch (Exception e) 
		{
			log.info("Error");
		}
		return "redirect:/MyCart";
	}

	@RequestMapping(value = "/PurchaseNow", method = RequestMethod.GET)
	public String checkout(Model model, Principal principal) 
	{
		log.info("Checkout Called.");
		int i;
		int s = 0;
		int n = cartDAO.userCartList(principal.getName()).size();
		log.info("Size of Checkout Cart"+n);
		for (i = 0; i < n; i++) 
		{
			s = s + cartDAO.userCartList(principal.getName()).get(i).getPrice();
		}
		model.addAttribute("sum", s);
		model.addAttribute("cart", new Cart());
		model.addAttribute("cartList", this.cartDAO.userCartList(principal.getName()));

		return "redirect:/checkout";
	}

	@RequestMapping("/cart_delete-{id}")
	public String deleteCart(@PathVariable("id") int cartId, Model model, Principal principal, HttpSession session)
	{
		log.info("Cart Delete function called.");
		cart = cartDAO.getByIdCart(cartId);
		product = productDAO.getProductById(cart.getProduct_id());
		
		cartDAO.deleteCart(cartId);
		
		int stock = product.getStock() + 1;
		product.setStock(stock);
		productDAO.saveOrUpdate(product);
		
		int n=0;
		try {
			n = cartDAO.userCartList(principal.getName()).size();
		} catch (Exception e) {
			log.info("Error");
		}
		session.setAttribute("cartSize",n);
		return "redirect:/MyCart";
	}

	@RequestMapping("/payment")
	public ModelAndView getPayment(Model model)
	{
		log.info("Payment Initiated");
		ModelAndView mv = new ModelAndView("payment-new");
		mv.addObject("payment", new Payment());
			
		try
			{
			payment = paymentDAO.getPaymentInfo(session.getAttribute("user_email").toString());
			if(payment.getF_name() != null)
				{
					mv.addObject("payment", payment);
				}
			else
				{
					mv.addObject("payment", new Payment());
				}
			}
		catch(Exception e)
			{
				log.info("New USer");
			}
			return mv;
	}
	
	@RequestMapping("/billing")
	public ModelAndView getBilling(Model model)
	{
		log.info("Billing Initiated");
		ModelAndView mv = new ModelAndView("billing_page");
		mv.addObject("billing", new Billing());
		try 
		{
			billing = billingDAO.getBilling(session.getAttribute("user_email").toString());
			if(billing.getName() != null)
				{
					mv.addObject("billing", billing);
				}
			else
				{
					mv.addObject("billing", new Billing());
				}
		}
		catch (Exception e) 
		{
			log.info("New User Detected");
		}
		return mv;
	}
	 @RequestMapping("/backToHome")
	 public String backToHome(Principal principal){
	 	 log.debug("Starting of the method backToHome"+principal.getName());
	 	 
	 	 cartDAO.deleteAllCartItem(principal.getName());
	 	
	 		return "redirect:/";
	 	}
	
}
