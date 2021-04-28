package com.nt.bo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EmployeeBO {
	private int empno;
	private String ename;
	private String job;
	private float sal;
	
}
