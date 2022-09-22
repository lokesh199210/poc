package com.honda.ws.bean;

import java.util.Base64;

/**
 * 
 * @author Lokesh Sharma
 *
 */
public class AuthenticationToken {

	private String userName;
	private String password;
	private String authenticationString;

	public AuthenticationToken(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}

	public static AuthenticationToken create(String userName, String password) {
		return new AuthenticationToken(userName, password);
	}

	public String getUserName() {
		return userName;
	}
	
	public String getPassword() {
		return password;
	}

	private void generateAuthenticationString() {
		authenticationString = userName + ":" + password;
	}

	public String getAuthenticationString() {
		generateAuthenticationString();
		return "Basic " + encodeAuthenticationString();
	}

	private String encodeAuthenticationString() {
		return Base64.getEncoder().encodeToString(authenticationString.getBytes());
	}

}