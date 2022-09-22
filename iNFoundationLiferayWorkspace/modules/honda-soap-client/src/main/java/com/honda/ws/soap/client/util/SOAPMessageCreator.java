package com.honda.ws.soap.client.util;

import com.honda.ws.soap.client.config.ResourceLoader;
import com.honda.ws.soap.client.config.ServiceConfig;

import java.util.Map;

import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPException;

import org.osgi.service.component.annotations.Component;

/**
 * @author Vinisha Pathak
 *
 */

@Component(immediate = true)
public class SOAPMessageCreator {
	
	/**
	 * Create SOAP request message
	 * 
	 * @param soapBody
	 * @param params
	 * @return
	 * @throws SOAPException
	 */
	public static SOAPElement createSOAPMessage(SOAPBody soapBody, Map<Object, Object> params,
			String operationName) throws SOAPException {

		if (soapBody == null) {
			throw new SOAPException("SOAP message body is undefined");
		}

		String paramPrefix = ResourceLoader.getKeyValue(ServiceConfig.SERVICE_REQUEST_PARAMETER_PREFIX);
		SOAPElement soapBodyElement = soapBody.addChildElement(operationName, paramPrefix);
		
		if (params != null) {
			for (Map.Entry<Object, Object> entry : params.entrySet()) {
				SOAPElement soapChildElement = soapBodyElement.addChildElement((String) entry.getKey(), paramPrefix);
				soapChildElement.addTextNode((String) entry.getValue());
			}
		}
		
		return soapBodyElement;
	}
}
