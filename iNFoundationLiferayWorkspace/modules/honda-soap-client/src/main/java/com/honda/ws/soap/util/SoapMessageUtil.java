package com.honda.ws.soap.util;

import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;

import org.osgi.service.component.annotations.Component;

/**
 * @author Vinisha Pathak
 *
 */

@Component(immediate = true)
public class SoapMessageUtil {
	
	/**
	 * Create SOAPMessage instance
	 * 
	 * @return
	 * @throws SOAPException
	 */
	public static SOAPMessage createMessageInstance() throws SOAPException {
		return MessageFactory.newInstance().createMessage();
	}
}
