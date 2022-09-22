package com.honda.auto.login.handler.constants;

public enum ConstantsKeys {

	DEALER_USER_EMAIL_ADDRESS("dealer@amerhonda.com"),
	
	DEALER_USER_PASS_KEY("honda123#"),
	
	JSESSIONID_COOKIE_KEY("JSESSIONID");
	
	ConstantsKeys(String value){
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}

	private String value ;
}
