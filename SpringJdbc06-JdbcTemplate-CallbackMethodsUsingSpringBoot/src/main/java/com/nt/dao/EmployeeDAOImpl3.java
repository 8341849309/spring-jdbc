package com.nt.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.nt.bo.EmployeeBO;

@Repository("empDao")
public class EmployeeDAOImpl3 implements IEmployeeDAO {

	@Autowired
	private JdbcTemplate jt;

	private static final String GET_EMP_BY_NO = "SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE EMPNO=?";
	private static final String GET_EMPS_BY_DESGS = "SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE JOB IN(?,?,?)";

	@Override
	public EmployeeBO getEmployeeByNo(int empno) {

		/*
		 * While using BeanPropertyRowMapper<>() EmployeeBO variable names and table columns should match
		 */
		EmployeeBO empBo = jt.queryForObject(GET_EMP_BY_NO, 
											new BeanPropertyRowMapper<EmployeeBO>(EmployeeBO.class), 
											empno);

		return empBo;
	}

	@Override
	public List<EmployeeBO> getEmpsByDesignations(String des1, String des2, String des3) {
		List<EmployeeBO> listBo=jt.query(GET_EMPS_BY_DESGS, 
								new RowMapperResultSetExtractor<EmployeeBO>(new BeanPropertyRowMapper<EmployeeBO>(EmployeeBO.class)), 
								des1,des2,des3);
		return listBo;
	}

}