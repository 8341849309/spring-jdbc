package com.nt.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("empDAO")
public class EmployeeDAOImpl implements IEmployeeDAO {

	@Autowired
	private JdbcTemplate jt;

	private static final String GET_EMPS_COUNT = "SELECT COUNT(*) FROM EMP";
	private static final String GET_EMP_NAME = "SELECT ENAME FROM EMP WHERE EMPNO=?";
	private static final String GET_EMP_SALARY = "SELECT SAL FROM EMP WHERE EMPNO=?";
	private static final String GET_EMP_DETAILS = "SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE EMPNO=?";
	private static final String GET_EMPS_DETAILS_BY_DESGS = "SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE JOB IN(?,?,?)";
	private static final String GET_ALL_EMPS = "SELECT EMPNO,ENAME,JOB,SAL FROM EMP";
	private static final String GET_EMP_NAME_SALARY = "SELECT ENAME,SAL FROM EMP WHERE EMPNO=?";
	private static final String INSERT_EMP_QUERY = "INSERT INTO EMP(EMPNO,ENAME,JOB,SAL) VALUES(SEQUENCE1.NEXTVAL,?,?,?)";
	private static final String UPDATE_EMP_SALARY = "UPDATE EMP SET SAL=? WHERE EMPNO=?";
	private static final String DELETE_EMP_BY_EMPNO = "DELETE FROM EMP WHERE EMPNO=?";

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

	public Integer insertEmployee(String ename, String job, Float sal) {
		int count = jt.update(INSERT_EMP_QUERY, ename, job, sal);
		return count;
	}

	public int updateEmployeeSalary(int id, Float newSal) {
		int count = jt.update(UPDATE_EMP_SALARY, newSal, id);
		return count;
	}

	public int deleteEmployee(int id) {
		int count = jt.update(DELETE_EMP_BY_EMPNO, id);
		return count;
	}

}