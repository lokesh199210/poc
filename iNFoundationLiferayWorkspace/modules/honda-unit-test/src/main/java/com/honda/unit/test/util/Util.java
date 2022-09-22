package com.honda.unit.test.util;

import com.liferay.portal.kernel.service.UserLocalServiceUtil;

public class Util {

	private Util() {
		
		throw new IllegalStateException("Utility class");
		
	}
	
	public static void addUser() {
		
		UserLocalServiceUtil.createUser(10101);
		
	}
}
