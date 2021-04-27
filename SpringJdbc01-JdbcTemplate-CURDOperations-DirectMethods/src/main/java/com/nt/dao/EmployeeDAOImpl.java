package com.nt.dao;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

public class EmployeeDAOImpl implements IEmployeeDAO {

	private JdbcTemplate jt;

	private static final String GET_EMPS_COUNT = "SELECT COUNT(*) FROM EMP";
	private static final String GET_EMP_NAME = "SELECT ENAME FROM EMP WHERE EMPNO=?";
	private static final String GET_EMP_SALARY = "SELECT SAL FROM EMP WHERE EMPNO=?";
	private static final String GET_EMP_DETAILS = "SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE EMPNO=?";
	private static final String GET_EMPS_DETAILS_BY_DESGS = "SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE JOB IN(?,?,?)";
	private static final String GET_ALL_EMPS = "SELECT EMPNO,ENAME,JOB,SAL FROM EMP";
	private static final String GET_EMP_NAME_SALARY = "SELECT ENAME,SAL FROM EMP WHERE EMPNO=?";

	public EmployeeDAOImpl(JdbcTemplate jt) {
		this.jt = jt;
	}

	public int getEmployeesCount() {
		int count = jt.queryForObject(GET_EMPS_COUNT, Integer.class);
		return count;
	}

	public String getEmployeeName(Integer id) {
		String ename = jt.queryForObject(GET_EMP_NAME, String.class, id);
		return ename;
	}

	public Float getEmployeeSalary(Integer id) {
		Float salary = jt.queryForObject(GET_EMP_SALARY, Float.class, id);
		return salary;
	}

	// Keys are Col names and Values are Values
	public Map<String, Object> getEmployee(Integer id) {
		Map<String, Object> empDetails = jt.queryForMap(GET_EMP_DETAILS, id);
		System.out.println(empDetails.get("ENAME"));
		return empDetails;
	}

	public List<Map<String, Object>> getEmployeesByDesignations(String des1, String des2, String des3) {

		return jt.queryForList(GET_EMPS_DETAILS_BY_DESGS, des1, des2, des3);
	}

	public List<Map<String, Object>> getAllEmployees() {

		return jt.queryForList(GET_ALL_EMPS);
	}

	public Map<String, Object> getEmployeesNameAndSalary(Integer id) {

		return jt.queryForMap(GET_EMP_NAME_SALARY, id);
	}

}