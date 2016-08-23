package com.amaysim.cart;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class PriceRule {
	
	private String priceRuleCode;
	
	private Date startDate;
	
	private Date endDate;
	
	private Map<String, PriceRuleDetail> details;
	
	public void addPriceRuleDetails(PriceRuleDetail detail) {
		getDetails().put(detail.getProduct().getCode(), detail);
	}
	
	public void removePriceRuleDetail(PriceRuleDetail detail) {
		details.remove(detail);
	}

	public String getPriceRuleCode() {
		return priceRuleCode;
	}

	public void setPriceRuleCode(String priceRuleCode) {
		this.priceRuleCode = priceRuleCode;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	public Map<String, PriceRuleDetail> getDetails() {
		if (details == null) {
			details = new HashMap<>();
		}
		return details;
	}

	public void setDetails(Map<String, PriceRuleDetail> details) {
		this.details = details;
	}


}
