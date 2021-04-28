package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.bo.EmployeeBO;
import com.nt.dao.IEmployeeDAO;

@Service("empService")
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	private IEmployeeDAO empDAO;

	@Override
	public EmployeeBO fetchEmployee(int empno) {
		EmployeeBO bo = empDAO.getEmployeeByNo(empno);
		return bo;
	}

	@Override
	public List<EmployeeBO> fetchEmpsByDesgns(String des1, String des2, String des3) {
		List<EmployeeBO> listBo=empDAO.getEmpsByDesignations(des1, des2, des3);
		return listBo;
	}

}
