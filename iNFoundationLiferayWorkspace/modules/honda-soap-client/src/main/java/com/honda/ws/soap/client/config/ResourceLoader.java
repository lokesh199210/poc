package com.honda.ws.soap.client.config;

import java.util.ResourceBundle;

import javax.jws.WebMethod;

import org.osgi.service.component.annotations.Component;

/**
 * @author Vinisha Pathak
 *
 */

@Component(immediate = true)
public class ResourceLoader {
	
	/**
	 * Initiating resource bundle
	 */
	static final ResourceBundle nodeConfigBundle = ResourceBundle.getBundle("content/node-services-url-config");

	/**
	 * Get value of key from resource bundle
	 * 
	 * @param key
	 * @return
	 */
	@WebMethod
	public static String getKeyValue(String key) {
		ResourceBundle servicesConfigBundle = null;
		//String environment = System.getenv("CURRENT_ENVIRONMENT");
		String environment = "local";
		System.out.println("Environment :: " + environment);
		if(environment.isEmpty()){
			environment ="qa";
		}
		switch (environment) {
		case ServiceConfig.qa_environment:
			servicesConfigBundle = ResourceBundle.getBundle("content/services-config_qa_uat");
			break;
		case ServiceConfig.uat_environment:
			servicesConfigBundle = ResourceBundle.getBundle("content/services-config_qa_uat");
			break;
		case ServiceConfig.prod_environment:
			servicesConfigBundle = ResourceBundle.getBundle("content/services-config_prod");
			break;
		default:
			servicesConfigBundle = ResourceBundle.getBundle("content/services-config");

		}
		return servicesConfigBundle.getString(key);
	}	
}
