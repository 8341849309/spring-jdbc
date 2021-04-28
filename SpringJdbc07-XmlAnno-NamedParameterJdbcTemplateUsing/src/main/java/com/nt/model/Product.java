package com.nt.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Product {
	private int pid;
	private String pname;
	private int quantity;
	private float base_Price;
	private float MRP;
	private String type;
	private String status;
}
