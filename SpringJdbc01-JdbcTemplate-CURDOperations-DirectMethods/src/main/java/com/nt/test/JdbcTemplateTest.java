package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.dao.EmployeeDAOImpl;

public class JdbcTemplateTest {

	public static void main(String[] args) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");

		EmployeeDAOImpl dao = ctx.getBean("empDao", EmployeeDAOImpl.class);
		System.out.println("Total Employees Count:: " + dao.getEmployeesCount());

		System.out.println("--------------------");
		System.out.println("Employee Name ::" + dao.getEmployeeName(3));

		System.out.println("--------------------");
		System.out.println("Employee Salary ::" + dao.getEmployeeSalary(3));

		System.out.println("--------------------");
		System.out.println("Employee Details ::" + dao.getEmployee(3));

		System.out.println("--------------------");
		System.out.println("Employees Details ::" + dao.getEmployeesByDesignations("Programer Analyst", "System Engineer", "Associate"));

		System.out.println("--------------------");
		System.out.println("All Employees Details ::" + dao.getAllEmployees());

		System.out.println("--------------------");
		System.out.println("All Employees Names ::" + dao.getEmployeesNameAndSalary(1));

		((AbstractApplicationContext) ctx).close();
	}

}
