package com.nt.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.nt.model.Product;

@Repository("prodDao")
public class ProductDAOImpl implements IProductDAO {

	@Autowired
	private NamedParameterJdbcTemplate npjt;

	private static final String GET_PRODUCT_BY_ID = "SELECT * FROM PRODUCT WHERE PID=:id";
	private static final String GET_PRODUCTS_BY_TYPE = "SELECT * FROM PRODUCT WHERE TYPE IN(:type1,:type2)";

	@Override
	public Product getProductById(int productId) {

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", productId);

		Product prod = npjt.queryForObject(GET_PRODUCT_BY_ID, map, new BeanPropertyRowMapper<Product>(Product.class));
		return prod;
	}

	@Override
	public List<Product> getProductsByType(String type1, String type2) {
		MapSqlParameterSource map = new MapSqlParameterSource();
		map.addValue("type1", type1);
		map.addValue("type2", type2);

		List<Product> prodList = npjt.query(GET_PRODUCTS_BY_TYPE, map,
				new RowMapperResultSetExtractor<Product>(new BeanPropertyRowMapper<Product>(Product.class)));

		return prodList;
	}

}
