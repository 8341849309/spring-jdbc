package com.nt.service;

import java.util.List;

import com.nt.bo.EmployeeBO;

public interface IEmployeeService {

	public EmployeeBO fetchEmployee(int empno);

	public List<EmployeeBO> fetchEmpsByDesgns(String des1, String des2, String des3);
	
}
