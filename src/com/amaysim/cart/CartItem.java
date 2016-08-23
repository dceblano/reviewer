package com.amaysim.cart;

import java.io.Serializable;
import java.math.BigDecimal;

public class CartItem implements Serializable {
	
	public CartItem() {
		
	}
	
	public CartItem(Product product, long quantity) {
		this.product = product;
		this.quantity = quantity;
	}
	
	private static final long serialVersionUID = -8747586011818075832L;

	private Product product;
	
	private long quantity;
	
	private BigDecimal amount;

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}
	
	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

}
