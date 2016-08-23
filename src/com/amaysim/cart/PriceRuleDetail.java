package com.amaysim.cart;

import java.math.BigDecimal;

public class PriceRuleDetail {

	public PriceRuleDetail() {

	}

	public PriceRuleDetail(String priceRuleCode, Product product, int minimumQty,
			FeebieTypeEnum freebieType, Product freebieProduct, int freebieQty,
			BigDecimal freebiePrice) {
		this.priceRuleCode = priceRuleCode;
		this.product = product;
		this.minimumQty = minimumQty;
		this.freebieType = freebieType;
		this.freebieProduct = freebieProduct;
		this.freebieQty = freebieQty;
		this.freebiePrice = freebiePrice;
	}

	private String priceRuleCode;

	private Product product;

	private int minimumQty;

	private FeebieTypeEnum freebieType;

	private Product freebieProduct;

	private int freebieQty;

	private BigDecimal freebiePrice;

	public String getPriceRuleCode() {
		return priceRuleCode;
	}

	public void setPriceRuleCode(String priceRuleCode) {
		this.priceRuleCode = priceRuleCode;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getMinimumQty() {
		return minimumQty;
	}

	public void setMinimumQty(int minimumQty) {
		this.minimumQty = minimumQty;
	}

	public FeebieTypeEnum getFreebieType() {
		return freebieType;
	}

	public void setFreebieType(FeebieTypeEnum freebieType) {
		this.freebieType = freebieType;
	}

	public Product getFreebieProduct() {
		return freebieProduct;
	}

	public void setFreebieProduct(Product freebieProduct) {
		this.freebieProduct = freebieProduct;
	}
	
	public int getFreebieQty() {
		return freebieQty;
	}

	public void setFreebieQty(int freebieQty) {
		this.freebieQty = freebieQty;
	}

	public BigDecimal getFreebiePrice() {
		return freebiePrice;
	}

	public void setFreebiePrice(BigDecimal freebiePrice) {
		this.freebiePrice = freebiePrice;
	}
}
