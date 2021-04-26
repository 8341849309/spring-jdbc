package com.nt.dao;

import org.springframework.jdbc.core.JdbcTemplate;

public class EmployeeDAOImpl implements IEmployeeDAO {

	private JdbcTemplate jt;

	private static final String GET_EMPS_COUNT = "SELECT COUNT(*) FROM ACTOR";

	public EmployeeDAOImpl(JdbcTemplate jt) {
		this.jt = jt;
	}

	public int getEmployeesCount() {
		int count = jt.queryForObject(GET_EMPS_COUNT, Integer.class);
		return count;
	}

}