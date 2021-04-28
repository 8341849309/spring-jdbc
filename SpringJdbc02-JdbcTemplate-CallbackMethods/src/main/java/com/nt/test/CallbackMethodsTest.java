package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.service.EmployeeServiceImpl;
import com.nt.service.IEmployeeService;

public class CallbackMethodsTest {

	public static void main(String[] args) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");

		IEmployeeService service = ctx.getBean("empService", EmployeeServiceImpl.class);

		// RowMapper with Inner class
		try {
			System.out.println("Employee Details:: " + service.fetchEmployee(4));
		} catch (Exception e) {
			e.printStackTrace();
		}

		// ResultSetExtractor(I)
		try {
			System.out.println("Employees Details:: ");
			
			service.fetchEmpsByDesgns("SI", "Associate", "").forEach(System.out::println);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		((AbstractApplicationContext) ctx).close();
	}

}
