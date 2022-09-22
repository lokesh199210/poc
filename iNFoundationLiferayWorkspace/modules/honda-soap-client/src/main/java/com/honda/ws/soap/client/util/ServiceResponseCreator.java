package com.honda.ws.soap.client.util;

import com.honda.ws.soap.client.config.ResourceLoader;
import com.honda.ws.soap.client.config.ServiceConfig;
import com.honda.xml.transform.XMLTransformer;
import com.liferay.petra.string.StringPool;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;

import javax.xml.transform.TransformerException;

import org.json.JSONObject;
import org.json.XML;
import org.osgi.service.component.annotations.Component;

/**
 * @author Vinisha Pathak
 *
 */

@Component(immediate = true)
public class ServiceResponseCreator {
	
	public static String generateNewHTMLResponse(String serviceName, Map<String, String> serviceConfigParams,
			String resXML, int cur, int delta) throws TransformerException, FileNotFoundException {
		if (resXML == null) {
			throw new TransformerException("Service response XML is undefined");
		}

		String pageMode = "";

		XMLTransformer xmlTransformer = new XMLTransformer();
		StringBuilder xslTemplate = new StringBuilder(ResourceLoader.getKeyValue(ServiceConfig.XSL_TEMPLATE_PATH));

		Map<String, String> params = new HashMap<String, String>();
		params.put(ServiceConfig.PARAM_CUR, String.valueOf(cur));
		params.put(ServiceConfig.PARAM_DELTA, String.valueOf(delta));
		params.put(ServiceConfig.PARAM_MESSAGE_ERROR,
				ResourceLoader.getKeyValue(ServiceConfig.MESSAGE_SERVICE_RESPONSE_EMPTY));

		if (serviceConfigParams != null) {
			params.putAll(serviceConfigParams);

			pageMode = serviceConfigParams.get(ServiceConfig.PARAM_PAGE_MODE);
			if (pageMode == null) {
				pageMode = "";
			} else {
				pageMode = "-" + pageMode;
			}
		}

		File xslFile = new File(xslTemplate.append(serviceName).append(pageMode).append(".html.xsl").toString());
		if (!xslFile.exists()) {
			xslTemplate = new StringBuilder(ResourceLoader.getKeyValue(ServiceConfig.XSL_TEMPLATE_PATH));
			xslFile = new File(xslTemplate.append("new.default").append(pageMode).append(".html.xsl").toString());
		}

		return xmlTransformer.transform(new StringReader(resXML), xslFile, params);
	}
	
	public static String generateCSVResponse(String serviceName, String resXML)
			throws FileNotFoundException, TransformerException {
		if (resXML == null) {
			throw new TransformerException("Service response XML is undefined");
		}
		XMLTransformer xmlTransformer = new XMLTransformer();

		StringBuilder xslTemplate = new StringBuilder(ResourceLoader.getKeyValue(ServiceConfig.XSL_TEMPLATE_PATH))
				.append("default.csv.xsl");
		File xslFile = new File(xslTemplate.toString());

		return xmlTransformer.transform(new StringReader(resXML), xslFile, null);
	}

	public static String generateJSONResponseFromRequestStatusTemplate(String serviceName, String resXML, Map<String, String> params)
			throws FileNotFoundException, TransformerException {
	
		if (resXML == null) {
			throw new TransformerException("Service response XML is undefined");
		}
		XMLTransformer xmlTransformer = new XMLTransformer();
	
		StringBuilder xslTemplate = new StringBuilder(ResourceLoader.getKeyValue(ServiceConfig.XSL_TEMPLATE_PATH)).append("get-request-status.json.xsl");
		File xslFile = new File(xslTemplate.toString());
		
		return xmlTransformer.transform(new StringReader(resXML), xslFile, params);
	}
	
	public static String generateJSONResponseFromSearchPeopleTemplate(String serviceName, String resXML, Map<String, String> params)
			throws FileNotFoundException, TransformerException {
	
		if (resXML == null) {
			throw new TransformerException("Service response XML is undefined");
		}
		XMLTransformer xmlTransformer = new XMLTransformer();
	
		StringBuilder xslTemplate = new StringBuilder(ResourceLoader.getKeyValue(ServiceConfig.XSL_TEMPLATE_PATH)).append("search-people.json.xsl");
		File xslFile = new File(xslTemplate.toString());
		
		return xmlTransformer.transform(new StringReader(resXML), xslFile, params);
	}
	
	public static String generateCompleteJSONResponse(String resXML) throws TransformerException {
		
		if (resXML == null) {
			throw new TransformerException("Service response XML is undefined");
		}
		
		String jsonString = StringPool.BLANK;
		JSONObject json = XML.toJSONObject(resXML);   
		jsonString = json.toString(4);  
		
		return jsonString;
	}
}
