package com.nt.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.AbstractApplicationContext;

import com.nt.dao.EmployeeDAOImpl;
import com.nt.dao.IEmployeeDAO;

@SpringBootApplication
@ComponentScan(basePackages = "com.nt.dao")
public class SpringJdbc05JdbcTemplateCurdOperationsDirectMethodsUsingSpringBootApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication
				.run(SpringJdbc05JdbcTemplateCurdOperationsDirectMethodsUsingSpringBootApplication.class, args);
		
		IEmployeeDAO dao = ctx.getBean("empDAO", EmployeeDAOImpl.class);

		System.out.println("Total Employees Count:: " + dao.getEmployeesCount());

		System.out.println("--------------------");
		System.out.println("Employee Name ::" + dao.getEmployeeName(3));

		System.out.println("--------------------");
		System.out.println("Employee Salary ::" + dao.getEmployeeSalary(3));

		System.out.println("--------------------");
		System.out.println("Employee Details ::" + dao.getEmployee(3));

		System.out.println("--------------------");
		System.out.println("Employees Details ::"
				+ dao.getEmployeesByDesignations("Programer Analyst", "System Engineer", "Associate"));

		System.out.println("--------------------");
		System.out.println("All Employees Details ::" + dao.getAllEmployees());

		System.out.println("--------------------");
		System.out.println("Employee Name and Salary ::" + dao.getEmployeesNameAndSalary(1));

		System.out.println("--------------------");
		//System.out.println("Insert Employee ::" + dao.insertEmployee("Kishore", "SI", 30000.0f));

		System.out.println("--------------------------");
		System.out.println("Update Employee Salary:: " + dao.updateEmployeeSalary(1, 36000.0f));

		System.out.println("--------------------------");
		System.out.println("Delete Employee:: " + dao.deleteEmployee(2));

		((AbstractApplicationContext) ctx).close();

	}

}
