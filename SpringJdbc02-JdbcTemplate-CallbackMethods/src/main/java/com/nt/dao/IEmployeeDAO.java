package com.nt.dao;

import java.util.List;

import com.nt.bo.EmployeeBO;

public interface IEmployeeDAO {
	public EmployeeBO getEmployeeByNo(int empno);
	public List<EmployeeBO> getEmpsByDesignations(String des1,String des2,String des3);
}
