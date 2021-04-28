package com.nt.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.AbstractApplicationContext;

import com.nt.service.EmployeeServiceImpl;
import com.nt.service.IEmployeeService;

@SpringBootApplication
@ComponentScan(basePackages = "com.nt")
public class SpringJdbc06JdbcTemplateCallbackMethodsUsingSpringBootApplication {

	public static void main(String[] args) {

		ApplicationContext ctx = SpringApplication
				.run(SpringJdbc06JdbcTemplateCallbackMethodsUsingSpringBootApplication.class, args);

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
