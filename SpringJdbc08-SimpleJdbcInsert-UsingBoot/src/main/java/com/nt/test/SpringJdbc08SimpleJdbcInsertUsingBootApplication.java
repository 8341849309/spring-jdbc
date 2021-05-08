package com.nt.test;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import com.nt.dao.ActorDAOImpl;
import com.nt.dao.IActorDAO;
import com.nt.entity.Actor;

@SpringBootApplication
@ComponentScan(basePackages = "com.nt")
public class SpringJdbc08SimpleJdbcInsertUsingBootApplication {

	@Autowired
	private DataSource ds;
	
	@Bean
	public SimpleJdbcInsert createSjInsert() {
		return new SimpleJdbcInsert(ds);
	}
	
	public static void main(String[] args) {
		
		ApplicationContext ctx = SpringApplication.run(SpringJdbc08SimpleJdbcInsertUsingBootApplication.class, args);

		
		
		IActorDAO dao=ctx.getBean("actorRepo",ActorDAOImpl.class);
		
		System.out.println(dao.insert(new Actor(4, "MANJUNADH", "PNR", 10000000.0f)));
		
		((ConfigurableApplicationContext) ctx).close();
		
	}

}
