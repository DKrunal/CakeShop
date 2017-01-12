package com.cakeshop.dao;

import java.util.List;

import com.cakeshop.model.Supplier;



public interface SupplierDAO {
	public List<Supplier> getSuppliers();
	public Supplier getSupplierById(String id);
/*	public Supplier isValid(String id, String password);
*/	public boolean save(Supplier supplier);
	public boolean update(Supplier supplier);
	public boolean delete(String id);

}
