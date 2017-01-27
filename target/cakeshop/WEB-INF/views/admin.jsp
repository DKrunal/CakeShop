<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page session="true" %>
<ul class="nav navbar-nav collapse navbar-collapse">
							<li class="dropdown"><a href="#">Manage<i class="fa fa-angle-down"></i></a>
                                    <ul role="menu" class="sub-menu">
                                       <li><a href="Supplier">Manage Suppliers</a></li>
								<li><a href="Product">Manage Products</a></li>
								<li><a href="Category">Manage Category</a></li>
                                    </ul>
                                </li> 
                                </ul>
 <c:url value="/logout" var= " logoutUrl"/>
 <form action="${logoutUrl}" method="POST" id ="logoutForm">
 </form>