package com.amaysim.cart;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ShoppingCartTest {

	ShoppingCart cart;
	ShoppingCartHelper cartHelper;

	@Before
	public void init() {
		cartHelper = new ShoppingCartHelper();
		cart = new ShoppingCart(cartHelper.getFirstMonthPromoPriceRule());
		
	}

	@Test
	public void testScenario1() {
		cart.add(new CartItem(cartHelper.getProducts().get(ProductEnum.UNLIMITED_1GB.getCode()), 3));
		cart.add(new CartItem(cartHelper.getProducts().get(ProductEnum.UNLIMITED_5GB.getCode()), 1));

		Assert.assertEquals(2, cart.getItems().size());
		
		cart.checkout();
		Assert.assertEquals(BigDecimal.valueOf(94.7), cart.getTotalAmount());
	}
	
	@Test
	public void testScenario2() {
		cart.add(new CartItem(cartHelper.getProducts().get(ProductEnum.UNLIMITED_1GB.getCode()), 2));
		cart.add(new CartItem(cartHelper.getProducts().get(ProductEnum.UNLIMITED_5GB.getCode()), 4));

		Assert.assertEquals(2, cart.getItems().size());
		
		cart.checkout();
		Assert.assertEquals(BigDecimal.valueOf(209.4), cart.getTotalAmount());
	}
	
	@Test
	public void testScenario3() {
		cart.add(new CartItem(cartHelper.getProducts().get(ProductEnum.UNLIMITED_1GB.getCode()), 1));
		cart.add(new CartItem(cartHelper.getProducts().get(ProductEnum.UNLIMITED_2GB.getCode()), 2));

		cart.checkout();
		Assert.assertEquals(BigDecimal.valueOf(84.7), cart.getTotalAmount());
		Assert.assertEquals(3, cart.getItems().size());
	}

	@Test
	public void testScenario4() {
		cart.add(new CartItem(cartHelper.getProducts().get(ProductEnum.UNLIMITED_1GB.getCode()), 1));
		cart.add(new CartItem(cartHelper.getProducts().get(ProductEnum.ONE_GB_DATA_PACK.getCode()), 1), "I<3AMAYSIM");

		cart.checkout();
		Assert.assertEquals(BigDecimal.valueOf(31.32), cart.getTotalAmount());
		Assert.assertEquals(2, cart.getItems().size());
	}
	
	

}
