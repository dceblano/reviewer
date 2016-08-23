package com.amaysim.cart;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ShoppingCartHelper {

	public PriceRule getFirstMonthPromoPriceRule() {
		PriceRule priceRule = new PriceRule();
		priceRule.setPriceRuleCode("First Month Promo");
		priceRule.setStartDate(new Date());
		priceRule.setEndDate(addOneMonthToDate(new Date()));
		
		Map<String, Product> products = getProducts();
		Product unli1GB = products.get(ProductEnum.UNLIMITED_1GB.getCode());
		Product unli2GB = products.get(ProductEnum.UNLIMITED_2GB.getCode());
		Product unli5GB = products.get(ProductEnum.UNLIMITED_5GB.getCode());
		Product oneGBDataPack = products.get(ProductEnum.ONE_GB_DATA_PACK.getCode());
		
		PriceRuleDetail unli1GBPromo = new PriceRuleDetail(priceRule.getPriceRuleCode(), unli1GB, 
				3, FeebieTypeEnum.FREE_ITEM, unli1GB, 1, BigDecimal.ZERO);
		PriceRuleDetail unli5GBPromo = new PriceRuleDetail(priceRule.getPriceRuleCode(), unli5GB, 
				4, FeebieTypeEnum.DISCOUNT, unli5GB, 0, BigDecimal.valueOf(39.9));
		PriceRuleDetail unli2GBPromo = new PriceRuleDetail(priceRule.getPriceRuleCode(), unli2GB, 
				1, FeebieTypeEnum.FREE_ITEM, oneGBDataPack, 1, BigDecimal.ZERO);
		
		priceRule.addPriceRuleDetails(unli1GBPromo);
		priceRule.addPriceRuleDetails(unli5GBPromo);
		priceRule.addPriceRuleDetails(unli2GBPromo);
		
		return priceRule;
	}
	
	public PriceRule getRegularPriceRule() {
		PriceRule priceRule = new PriceRule();
		priceRule.setPriceRuleCode("First Month Promo");
		priceRule.setStartDate(new Date());
		priceRule.setEndDate(addOneMonthToDate(new Date()));
		return priceRule;
	}
	
	public Date addOneMonthToDate(Date date)
	{
	    Calendar cal = Calendar.getInstance();
	    cal.setTime(date);
	    cal.add(Calendar.MONTH, 1);
	    return cal.getTime();
	}

	/*
	 * Data can be stored in database tables or Rule Engine in real-life setup.   
	 */
	public Map<String, Product> getProducts() {
		Map<String, Product> products = new HashMap<>();
		Product p1 = new Product(ProductEnum.UNLIMITED_1GB.getCode(),
				"Unlimited 1GB", BigDecimal.valueOf(24.9));
		Product p2 = new Product(ProductEnum.UNLIMITED_2GB.getCode(),
				"Unlimited 2GB", BigDecimal.valueOf(29.9));
		Product p3 = new Product(ProductEnum.UNLIMITED_5GB.getCode(),
				"Unlimited 5GB", BigDecimal.valueOf(44.9));
		Product p4 = new Product(ProductEnum.ONE_GB_DATA_PACK.getCode(),
				"1 GB Data-pack", BigDecimal.valueOf(9.9));
		products.put(p1.getCode(), p1);
		products.put(p2.getCode(), p2);
		products.put(p3.getCode(), p3);
		products.put(p4.getCode(), p4);
		return products;
	}
	
	/*
	 * Data can be stored in database tables or Rule Engine in real-life setup.   
	 */
	public Map<String, BigDecimal> getPromoDiscounts() {
		Map<String, BigDecimal> promos = new HashMap<>();
		promos.put("I<3AMAYSIM", BigDecimal.TEN);
		promos.put("RIO_OLYMPICS", BigDecimal.valueOf(5));
		return promos;
	}

}
