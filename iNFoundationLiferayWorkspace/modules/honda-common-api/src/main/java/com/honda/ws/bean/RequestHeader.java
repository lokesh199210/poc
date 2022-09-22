package com.honda.ws.bean;

import java.util.HashMap;
import java.util.Map;

import com.liferay.portal.kernel.servlet.HttpHeaders;

/**
 * 
 * 
 * @author Lokesh Sharma
 *
 */
public class RequestHeader {

	private RequestMethod requestMethod;
	private Map<String, String> headerProperties;

	public RequestHeader(RequestMethod requestMethod, String applicationType, AuthenticationToken authToken) {
		headerProperties = new HashMap<>();
		setRequestMethod(requestMethod);
		setRequestApplicationType(applicationType);
		setAuthorizationToken(authToken);
	}

	public RequestHeader(String applicationType, AuthenticationToken authToken) {
		headerProperties = new HashMap<>();
		setRequestApplicationType(applicationType);
		setAuthorizationToken(authToken);
	}
	
	public void setRequestMethod(RequestMethod requestMethod) {
		this.requestMethod = requestMethod;
	}

	public String getRequestMethod() {
		return requestMethod.toString();
	}

	public void setRequestApplicationType(String applicationType) {
		addHeaderProperty(HttpHeaders.CONTENT_TYPE, applicationType);
	}

	public void setAuthorizationToken(AuthenticationToken authToken) {
		addHeaderProperty(HttpHeaders.AUTHORIZATION, authToken.getAuthenticationString());
	}

	public void addHeaderProperty(String name, String value) {
		headerProperties.put(name, value);
	}

	public final Map<String, String> getHeaderProperties() {
		return headerProperties;
	}

}
