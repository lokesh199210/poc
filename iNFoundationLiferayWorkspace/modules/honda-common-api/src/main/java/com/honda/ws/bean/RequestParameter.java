package com.honda.ws.bean;


import java.util.HashMap;
import java.util.Map;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

/**
 * 
 * 
 * @author Lokesh Sharma
 *
 */
public class RequestParameter {

	private Map<String, String> parameters;

	public RequestParameter() {
		parameters = new HashMap<>();
	}

	public void addRequestParameter(String name, String value) {
		parameters.put(name, value);
	}

	public final Map<String, String> getRequestParameters() {
		return parameters;
	}

	public String getRequestBody() {
		JSONObject requestBody = JSONFactoryUtil.createJSONObject();

		for (Map.Entry<String, String> entrySet : parameters.entrySet()) {
			requestBody.put(entrySet.getKey(), entrySet.getValue());
		}

		return JSONFactoryUtil.createJSONSerializer().serializeDeep(requestBody);
	}

}
