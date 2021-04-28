package com.nt.service;

import java.util.List;

import com.nt.model.Product;

public interface IProductService {
	public Product fetchProductById(int productId);
	public List<Product> fetchProductsByType(String type1,String type2);
}
