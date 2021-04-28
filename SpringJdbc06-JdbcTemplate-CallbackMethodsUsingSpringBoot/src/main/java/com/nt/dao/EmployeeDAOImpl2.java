package com.nt.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.nt.bo.EmployeeBO;

//@Repository("empDao")
public class EmployeeDAOImpl2 implements IEmployeeDAO {

	@Autowired
	private JdbcTemplate jt;

	private static final String GET_EMP_BY_NO = "SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE EMPNO=?";
	private static final String GET_EMPS_BY_DESGS = "SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE JOB IN(?,?,?)";

	@Override
	public EmployeeBO getEmployeeByNo(int empno) {

		EmployeeBO empBo = jt.queryForObject(GET_EMP_BY_NO, (rs, rowNum) -> {
			EmployeeBO bo = new EmployeeBO();
			bo.setEmpno(rs.getInt(1));
			bo.setEname(rs.getString(2));
			bo.setJob(rs.getString(3));
			bo.setSal(rs.getFloat(4));

			return bo;
		}, empno);

		return empBo;
	}

	@Override
	public List<EmployeeBO> getEmpsByDesignations(String des1, String des2, String des3) {
		List<EmployeeBO> listBo = jt.query(GET_EMPS_BY_DESGS, rs -> {
			List<EmployeeBO> list = new ArrayList<>();
			while (rs.next()) {
				EmployeeBO bo = new EmployeeBO();
				bo.setEmpno(rs.getInt(1));
				bo.setEname(rs.getString(2));
				bo.setJob(rs.getString(3));
				bo.setSal(rs.getFloat(4));
				list.add(bo);
			}
			return list;
		}, des1, des2, des3);
		return listBo;
	}

}