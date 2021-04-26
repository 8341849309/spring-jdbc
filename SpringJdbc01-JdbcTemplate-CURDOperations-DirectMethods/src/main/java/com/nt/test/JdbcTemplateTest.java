package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.dao.EmployeeDAOImpl;

public class JdbcTemplateTest {

	public static void main(String[] args) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		
		EmployeeDAOImpl dao=ctx.getBean("empDao",EmployeeDAOImpl.class);
		System.out.println(dao.getEmployeesCount());

	}

}
