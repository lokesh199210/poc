package com.honda.permission.checker.constants;

public enum PermissionCheckerConstants{

	NO_RESOURCE_PERMISSION_ERROR_MSG("User does't have permission to view the requested resource");

	PermissionCheckerConstants(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	private String value;
}
