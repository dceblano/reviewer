package com.amaysim.cart;

import java.io.Serializable;
import java.math.BigDecimal;

public class Product implements Serializable {
	
	public Product() {
		
	}
	
	public Product(String code, String name, BigDecimal price) {
		this.code = code;
		this.name = name;
		this.price = price;
	}

	private static final long serialVersionUID = -5666958437889415778L;

	private String code;

	private String name;
	
	private BigDecimal price;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

}
