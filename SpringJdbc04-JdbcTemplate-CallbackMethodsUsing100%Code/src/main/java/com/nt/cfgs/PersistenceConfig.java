package com.nt.cfgs;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@ComponentScan(basePackages = "com.nt.dao")
public class PersistenceConfig {

	@Bean(name = "hkDs")
	public DataSource createHikariDataSource() {
		HikariDataSource hkDs=new HikariDataSource();
		hkDs.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:xe");
		hkDs.setUsername("root");
		hkDs.setPassword("root");
		hkDs.setIdleTimeout(30000);
		hkDs.setMaximumPoolSize(20);
		return hkDs;
	}
	
	@Bean("jt")
	public JdbcTemplate createJdbcTemplate() {
		JdbcTemplate jt=new JdbcTemplate();
		jt.setDataSource(createHikariDataSource());
		return jt;
	}
	
}
