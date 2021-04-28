package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.dao.IProductDAO;
import com.nt.model.Product;

@Service("prodService")
public class ProductServiceImpl implements IProductService {

	@Autowired
	private IProductDAO prodDao;

	@Override
	public Product fetchProductById(int productId) {
		Product prod = prodDao.getProductById(productId);
		return prod;
	}

	@Override
	public List<Product> fetchProductsByType(String type1, String type2) {
		List<Product> prodList = prodDao.getProductsByType(type1, type2);
		return prodList;
	}

}
