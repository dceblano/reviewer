package com.amaysim.cart;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCart  {
	
	public ShoppingCart() {
		
	}
	
	public ShoppingCart(PriceRule priceRule) {
		this.priceRule = priceRule;
	}
	
	private List<CartItem> items;
	
	private PriceRule priceRule;
	
	private BigDecimal discountPct = BigDecimal.ZERO;
	
	public static ShoppingCart newCart(PriceRule priceRule) {
		return new ShoppingCart(priceRule);
	}

	public void add(CartItem cartItem) {
		getItems().add(cartItem);
	}

	public void add(CartItem cartItem, String promoCode) {
		getItems().add(cartItem);
		deriveDiscountFromPromoCode(promoCode);
	}

	public BigDecimal getTotalAmount() {
		BigDecimal amount = BigDecimal.ZERO;
		for (CartItem item : getItems()) {
			amount = amount.add(item.getAmount() != null ? item.getAmount() : 
				BigDecimal.valueOf(item.getQuantity()).multiply(item.getProduct().getPrice()));
		}
		// apply discount if with promo code
		if (discountPct.compareTo(BigDecimal.ZERO) > 0) {
			BigDecimal pctBillable = (BigDecimal.valueOf(100).subtract(discountPct)).divide(BigDecimal.valueOf(100));
			amount = amount.multiply(pctBillable);
		}
		return amount;
	}

	public List<CartItem> getItems() {
		if (items == null) {
			items = new ArrayList<>();
		}
		return items;
	}
	
	public void checkout() {
		
		applyPriceRule(this.priceRule);
		System.out.println("Cart Total: " + getTotalAmount());
		System.out.println("Cart Items: ");
		for (CartItem cartItem : getItems()) {
			System.out.println(cartItem.getQuantity() + " x "
					+ cartItem.getProduct().getName());
		}
//		items = new ArrayList<>();
	}
	
	private void deriveDiscountFromPromoCode(String promoCode) {
		ShoppingCartHelper cartHelper = new ShoppingCartHelper();
		if (cartHelper.getPromoDiscounts().containsKey(promoCode)) {
			discountPct = cartHelper.getPromoDiscounts().get(promoCode);
		}
	}
	
	private void applyPriceRule(PriceRule priceRule) {
		boolean withFreeItem = false;
		List<CartItem> freeItems = new ArrayList<>();
		for (CartItem cartItem : getItems()) {
			Product product = cartItem.getProduct();
			
			PriceRuleDetail priceRuleDetail = priceRule.getDetails().get(product.getCode());
			if (priceRuleDetail != null && cartItem.getQuantity() >= priceRuleDetail.getMinimumQty()) {
				if (priceRuleDetail.getFreebieType().equals(FeebieTypeEnum.DISCOUNT)) {
					product.setPrice(priceRuleDetail.getFreebiePrice());
					cartItem.setAmount(product.getPrice().multiply(BigDecimal.valueOf(cartItem.getQuantity())));
				} else { // FREE_ITEM
					// for same freebie product, no payment for the free quantity of that product
					if (priceRuleDetail.getProduct().getCode().equals(priceRuleDetail.getFreebieProduct().getCode())) {
						long quantityToBeCalculated = cartItem.getQuantity() - priceRuleDetail.getFreebieQty();
						cartItem.setAmount(product.getPrice().multiply(BigDecimal.valueOf(quantityToBeCalculated)));
					} else {
						// free product which is different from the cart item product
						withFreeItem = true;
						CartItem freeItem = new CartItem(priceRuleDetail.getFreebieProduct(), 
								priceRuleDetail.getFreebieQty());
						freeItem.setAmount(BigDecimal.ZERO);
						freeItems.add(freeItem);
					}
				}
			}
		}
		if (withFreeItem) {
			getItems().addAll(freeItems);
		}
	}
	
}
