package com.nt.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.nt.bo.EmployeeBO;

//@Repository("empDao")
public class EmployeeDAOImpl implements IEmployeeDAO {

	@Autowired
	private JdbcTemplate jt;

	private static final String GET_EMP_BY_NO = "SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE EMPNO=?";
	private static final String GET_EMPS_BY_DESGS = "SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE JOB IN(?,?,?)";

	/*
	 * Single Record
	 */
	@Override
	public EmployeeBO getEmployeeByNo(int empno) {

		EmployeeBO bo = jt.queryForObject(GET_EMP_BY_NO, new EmployeeRowMapper(), empno);

		return bo;
	}

	// Nested Inner class
	private static class EmployeeRowMapper implements RowMapper<EmployeeBO> {

		@Override
		public EmployeeBO mapRow(ResultSet rs, int rowNum) throws SQLException {

			EmployeeBO bo = new EmployeeBO();
			bo.setEmpno(rs.getInt(1));
			bo.setEname(rs.getString(2));
			bo.setJob(rs.getString(3));
			bo.setSal(rs.getFloat(4));

			return bo;
		}

	}// Inner class

	/*
	 * Multiple Records
	 */
	@Override
	public List<EmployeeBO> getEmpsByDesignations(String des1, String des2, String des3) {
		List<EmployeeBO> empList = jt.query(GET_EMPS_BY_DESGS, new EmployeeResultSetExtractor(), des1, des2, des3);
		return empList;
	}

	// Nested Inner Class
	private static class EmployeeResultSetExtractor implements ResultSetExtractor<List<EmployeeBO>> {

		@Override
		public List<EmployeeBO> extractData(ResultSet rs) throws SQLException, DataAccessException {
			List<EmployeeBO> listbo = new ArrayList<EmployeeBO>();
			while (rs.next()) {
				EmployeeBO bo = new EmployeeBO();
				bo.setEmpno(rs.getInt(1));
				bo.setEname(rs.getString(2));
				bo.setJob(rs.getString(3));
				bo.setSal(rs.getFloat(4));
				listbo.add(bo);
			}

			return listbo;
		}// inner class

	}
}