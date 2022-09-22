package com.honda.ws.soap.client;

import com.honda.ws.soap.client.config.ResourceLoader;
import com.honda.ws.soap.client.config.ServiceConfig;
import com.honda.ws.soap.client.util.SOAPHeaderCreator;
import com.honda.ws.soap.client.util.SOAPMessageCreator;
import com.honda.ws.soap.client.util.ServiceResponseCreator;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;
import javax.xml.transform.TransformerException;

import org.osgi.service.component.annotations.Component;

/**
 * @author Vinisha Pathak
 *
 */

@Component(immediate = true, property = "jaxws=true", enabled = true, service = SOAPServiceClient.class)
@WebService
public class SOAPServiceClient extends AbstractSOAPServiceClient {

	/**
	 * @param serviceName
	 * @param serviceRequestParams
	 * @param outputFormat
	 * @param operationName
	 * @return
	 * @throws TransformerException
	 * @throws SOAPException
	 * @throws IOException
	 */
	@WebMethod
	public String callSoapService(String serviceName, Map<Object, Object> serviceRequestParams,
			String outputFormat, String operationName) throws TransformerException, SOAPException, IOException {
		
		return callSoapService(serviceName, getServiceEndpoint(serviceName), serviceRequestParams, null, 1,
				Integer.MAX_VALUE, outputFormat, operationName);
	}
	
	@Override
	@WebMethod
	protected SOAPMessage createSOAPRequestImpl(SOAPMessage soapMessage, String serviceName,
			Map<Object, Object> params, String operationName) throws SOAPException {  

		SOAPPart soapPart = soapMessage.getSOAPPart();
		SOAPEnvelope envelope = soapPart.getEnvelope();

		// Namespaces declaration
		String declaredNamespaces = getServiceDeclaredNamespaces(serviceName);
		createSOAPMessageDeclaredNamespaces(declaredNamespaces, envelope);  
		
		// SOAP Header
		SOAPHeader soapHeader = envelope.getHeader();
		SOAPHeaderCreator.createSOAPHeader(soapHeader, "hondaHeaderType");
		
		// SOAP Body
		SOAPBody soapBody = envelope.getBody();
		SOAPMessageCreator.createSOAPMessage(soapBody, params, operationName);
		
        soapMessage.getMimeHeaders().addHeader("Authorization","Basic YDdJrp00RAB0ZWciRFpfvg==");

		soapMessage.saveChanges();

		return soapMessage;
	}
	
	@Override
	@WebMethod
	protected String createSOAPResponseImpl(String serviceName, Map<String, String> serviceConfigParams,
			String response, int cur, int delta, String outputFormat, String operationName)
			throws FileNotFoundException, TransformerException {
		if (outputFormat.equalsIgnoreCase(ServiceConfig.OUTPUT_FORMAT_HTML)) {
			return ServiceResponseCreator.generateNewHTMLResponse(serviceName, serviceConfigParams, response.toString(), cur, delta);
		} 
		else if (outputFormat.equalsIgnoreCase(ServiceConfig.OUTPUT_FORMAT_CSV)) {
			return ServiceResponseCreator.generateCSVResponse(serviceName, response.toString());
		} 
		else if (outputFormat.equalsIgnoreCase(ServiceConfig.OUTPUT_FORMAT_JSON)) {
			
			if("getRequestStatus".equalsIgnoreCase(operationName))
				return ServiceResponseCreator.generateJSONResponseFromRequestStatusTemplate(serviceName, response.toString(), serviceConfigParams);
			
			else if("searchPeople".equalsIgnoreCase(operationName))
				return ServiceResponseCreator.generateJSONResponseFromSearchPeopleTemplate(serviceName, response.toString(), serviceConfigParams);
			
			return response.toString();
		} 
		else {
			return response.toString();
		}
	}	
	
	/**
	 * Declared namespaces
	 * 
	 * @return
	 * @throws SOAPException
	 */
	protected void createSOAPMessageDeclaredNamespaces(String propDeclaredNamespaces, SOAPEnvelope envelope)
			throws SOAPException {

		if (propDeclaredNamespaces != null && !propDeclaredNamespaces.isEmpty()) {
			String[] declaredNamespaces = propDeclaredNamespaces.split(",");
			if (declaredNamespaces != null) {
				for (String parDeclaredNamespace : declaredNamespaces) {
					String[] declaredNamespace = parDeclaredNamespace.split("#");
					if (declaredNamespace != null && declaredNamespace.length > 1) {
						envelope.addNamespaceDeclaration(declaredNamespace[0], declaredNamespace[1]);
					}
				}
			}
		}
	}
	
	/**
	 * Get service endpoint
	 * 
	 * @param serviceName
	 * @return
	 */
	@WebMethod
	private String getServiceEndpoint(String serviceName) {
		return ResourceLoader.getKeyValue(serviceName + ".endpoint");
	}
	
	/**
	 * Get declared namespaces
	 * 
	 * @param serviceName
	 * @return
	 */
	@WebMethod
	private String getServiceDeclaredNamespaces(String serviceName) {
		return ResourceLoader.getKeyValue(serviceName + ".declared.namespaces");
	}
}
