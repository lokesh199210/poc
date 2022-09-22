package com.honda.commom.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.io.IOException;

public interface ObjectMapperUtil {

	/**
	 * Method used for Parse Bean data to JSON.
	 * 
	 * @param beanObject For Add JSON to Attribute
	 * @return String JSON Data.
	 */
	static String parseToJSON(Object beanObject) {
		String jsonData = "";
		try {
			jsonData = objectMapper.writeValueAsString(beanObject);
		} catch (JsonProcessingException exception) {
			log.info("Error While Parsing From Bean to JSON: " + exception.getMessage());
		}
		return jsonData;
	}

	/**
	 *
	 * @param json
	 * @param type
	 * @param <T>
	 * @return
	 */
	static <T> T parseToBean(String json, Class<T> type) {
		T t = null;
		try {
			t = objectMapper.readValue(json, type);
		} catch (IOException exception) {
			log.info("Error While Parsing From JSON to Bean: " + exception.getMessage());
		}
		return t;
	}

	final Log log = LogFactoryUtil.getLog(ObjectMapperUtil.class);
	final ObjectMapper objectMapper = new ObjectMapper();
}
