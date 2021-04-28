package com.nt.dao;

import java.util.List;

import com.nt.model.Product;

public interface IProductDAO {
	public Product getProductById(int productId);
	public List<Product> getProductsByType(String type1,String type2);
}
