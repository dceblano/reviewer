package com.amaysim.cart;

enum ProductEnum {

	UNLIMITED_1GB("ult_small"), UNLIMITED_2GB("ult_medium"), UNLIMITED_5GB(
			"ult_large"), ONE_GB_DATA_PACK("1gb");

	private ProductEnum(String code) {
		this.code = code;
	}

	private String code;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}

enum FeebieTypeEnum {

	DISCOUNT, FREE_ITEM,

}
