package com.honda.ws.soap.client.util;

import com.honda.ws.soap.client.config.ResourceLoader;
import com.honda.ws.soap.client.config.ServiceConfig;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPFactory;
import javax.xml.soap.SOAPHeader;

import org.osgi.service.component.annotations.Component;

/**
 * @author Vinisha Pathak
 *
 */

@Component(immediate = true)
public class SOAPHeaderCreator {
	/**
	 * Create SOAP request message
	 * 
	 * @param soapBody
	 * @param params
	 * @return
	 * @throws SOAPException
	 */
	public static void createSOAPHeader(SOAPHeader soapHeader, String headerName) throws SOAPException {

		if (soapHeader == null) {
			throw new SOAPException("SOAP header is undefined");
		}
		
		Map<Object, Object> headerParams = new LinkedHashMap<>();
		 
		headerParams.put("messageId","392dd708-34c0-4a94-a593-742bc8dc4f17");
		headerParams.put("siteId","iN New Foundation");
		headerParams.put("businessId","iN New Foundation");
		headerParams.put("collectedTimestamp","2021-10-13T01:51:08.410-05:00");
		
		String paramPrefix = ResourceLoader.getKeyValue(ServiceConfig.SERVICE_REQUEST_HEADER_PARAMETER_PREFIX);
		SOAPElement soapBodyElement = soapHeader.addChildElement(headerName, paramPrefix);
		
		if (headerParams != null) {
			for (Map.Entry<Object, Object> entry : headerParams.entrySet()) {
				SOAPElement soapChildElement = soapBodyElement.addChildElement((String) entry.getKey(), paramPrefix);
				soapChildElement.addTextNode((String) entry.getValue());
			}
		}

	}
}
