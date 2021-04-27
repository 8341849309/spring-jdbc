package com.nt.dao;

import java.util.List;
import java.util.Map;

public interface IEmployeeDAO {

	public int getEmployeesCount();

	public String getEmployeeName(Integer id);

	public Float getEmployeeSalary(Integer id);

	public Map<String, Object> getEmployee(Integer id);
	
	public Map<String, Object> getEmployeesNameAndSalary(Integer id);
	
	public List<Map<String, Object>> getAllEmployees();

	public List<Map<String, Object>> getEmployeesByDesignations(String des1, String des2, String des3);
}
