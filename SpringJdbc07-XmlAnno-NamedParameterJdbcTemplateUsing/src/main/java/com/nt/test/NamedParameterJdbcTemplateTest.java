package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.service.ProductServiceImpl;

public class NamedParameterJdbcTemplateTest {

	public static void main(String[] args) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");

		ProductServiceImpl prod = ctx.getBean("prodService", ProductServiceImpl.class);
		System.out.println(prod.fetchProductById(1));

		System.out.println("--------------------------------");

		prod.fetchProductsByType("Pant", "Shirt").forEach(System.out::println);

		((AbstractApplicationContext) ctx).close();

	}
}
