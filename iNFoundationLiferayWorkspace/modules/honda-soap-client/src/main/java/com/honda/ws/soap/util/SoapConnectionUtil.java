package com.honda.ws.soap.util;

import com.honda.ws.soap.connection.SOAPConnectionPool;
import com.liferay.portal.kernel.workflow.WorkflowConstants;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;

import org.osgi.service.component.annotations.Component;

/**
 * @author Vinisha Pathak
 *
 */

@Component(immediate = true)
public class SoapConnectionUtil {
	
	/**
	 * Call service
	 * 
	 * @param serviceEndpoint
	 * @param soapRequestMessage
	 * @return
	 * @throws SOAPException
	 */
	@SuppressWarnings("unused")
	public static SOAPMessage callService(String serviceEndpoint, SOAPMessage soapRequestMessage) throws SOAPException {
		System.out.println("Inside callService method of SoapConnectionUtils class !!");
		System.out.println("Service EndPoint :: " + serviceEndpoint);
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		try {
			soapRequestMessage.writeTo(out);
			
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		
		
		String strMsg = new String(out.toByteArray());
		if (serviceEndpoint == null) {
			throw new SOAPException("Service Endpoint is undefined");
		}

		if (soapRequestMessage == null) {
			throw new SOAPException("Invalid SOAP Request Message");
		}

		SOAPMessage soapResponseMessage =null;
		try {
			
			SOAPConnection soapConnection = SOAPConnectionPool.getInstance().getConnection();
			
			soapResponseMessage = soapConnection.call(soapRequestMessage, serviceEndpoint);
			
			System.out.println("SOAP Web Service has been successfully called !!");
		} 
		catch (SOAPException e) {
			e.printStackTrace();
			throw new SOAPException("Refuse connection to "+ serviceEndpoint);
		}
		
		return soapResponseMessage;
	}
}
