package com.honda.ws.soap.client;

import com.honda.ws.soap.client.config.ResourceLoader;
import com.honda.ws.soap.client.config.ServiceConfig;
import com.honda.ws.soap.client.util.ServiceResponseCacheUtil;
import com.honda.ws.soap.util.SoapConnectionUtil;
import com.honda.ws.soap.util.SoapMessageUtil;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.transform.TransformerException;

/**
 * @author Vinisha Pathak
 *
 */
public abstract class AbstractSOAPServiceClient {
	/**
	 * @param serviceName
	 * @param serviceEndpoint
	 * @param serviceRequestParams
	 * @param serviceConfigParams
	 * @param cur
	 * @param delta
	 * @param outputFormat
	 * @params operationName 
	 * @return
	 * @throws FileNotFoundException
	 * @throws TransformerException
	 * @throws SOAPException
	 */
	protected String callSoapService(String serviceName, String serviceEndpoint,
			Map<Object, Object> serviceRequestParams, Map<String, String> serviceConfigParams, int cur, int delta,
			String outputFormat, String operationName)
			throws FileNotFoundException, TransformerException, SOAPException {
		
		String result = null;

		if (serviceRequestParams == null) {
			throw new SOAPException("Service request parameters are undefined!");
		}

		// int reqParamsHash = serviceRequestParams.toString().hashCode();
		String actualServiceName = ResourceLoader.getKeyValue(serviceName);
		// String serviceNameKey = actualServiceName + operationName + reqParamsHash;
		String serviceNameKey = operationName;
		
		// Getting cached response first
		String resXML = "";

		try {  
			// Request Generation
			SOAPMessage soapReqMsg = createSOAPRequest(serviceName, serviceRequestParams, operationName);
			System.out.println("SOAP Request Message has been prepared !! ");
			
			if (soapReqMsg == null) {
				throw new SOAPException("Request Packet is empty");
			}

			saveServiceRequestXMLtoFile(serviceNameKey, soapReqMsg); 
			System.out.println("Web Service Request has been saved in file path - Honda - XML - request folder !!");
	
			// Response Generation
			SOAPMessage soapResMsg = SoapConnectionUtil.callService(serviceEndpoint,soapReqMsg);
			System.out.println("SOAP Response Message has been prepared !! ");
		
			if (soapResMsg == null) {
				throw new SOAPException("Unable to load data from service");
			}

			saveServiceResponseXMLtoFile(serviceNameKey, soapResMsg);  
			System.out.println("Web Service Response has been saved in file path - Honda - XML - response folder!!");
			
			resXML = getServiceResponseXMLFromFile(serviceNameKey);  
			System.out.println("Response XML :: " + resXML.toString());
			
			ServiceResponseCacheUtil.setKeyValue(serviceNameKey, resXML);
		} catch (Exception e) {
			resXML = getServiceResponseXMLFromFile(serviceNameKey);
		}
		
		System.out.println("Getting json from the response XML .....");
		result = createSOAPResponse(actualServiceName, serviceConfigParams, resXML, cur, delta, outputFormat, operationName);  
		
		return result;
	}
	
	/**
	 * @param serviceName
	 * @param params
	 * @param operationName
	 * @return
	 * @throws SOAPException
	 */
	private SOAPMessage createSOAPRequest(String serviceName, Map<Object, Object> params, String operationName) throws SOAPException {
		SOAPMessage soapMessage = SoapMessageUtil.createMessageInstance();
		soapMessage = createSOAPRequestImpl(soapMessage, serviceName, params, operationName);
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		try {
			System.out.println("SOAP Request Message has been prepared !!"); 
			soapMessage.writeTo(out);
		} 
		catch (IOException e) {
			e.printStackTrace();
		}

		return soapMessage;
	}
	
	/**
	 * Save soap request to xml file
	 * 
	 * @param serviceName
	 * @param request
	 * @throws SOAPException
	 */
	private void saveServiceRequestXMLtoFile(String serviceName, SOAPMessage request) throws SOAPException {
		FileOutputStream fop = null;

		try {
			StringBuilder baseDirPath = new StringBuilder(ResourceLoader.getKeyValue(ServiceConfig.SAVED_SERVICE_REQUEST_XML_PATH));

			File xmlDir = new File(baseDirPath.toString());
			
			// if file doesnt exists, then create it
			if (!xmlDir.exists()) {
				xmlDir.mkdirs();
			}

			String filePath = baseDirPath.append(serviceName).append((".xml")).toString();
			File xmlFile = new File(filePath);

			// if file doesnt exists, then create it
			if (!xmlFile.exists()) {
				xmlFile.createNewFile();
			}

			fop = new FileOutputStream(xmlFile);
			request.writeTo(fop);
			fop.flush();

		} 
		catch (IOException e) {

		} 
		finally {
			try {
				if (fop != null) {
					fop.close();
				}
			} catch (IOException e) {

			}
		}
	}
	
	/**
	 * Save soap response to xml file
	 * 
	 * @param serviceName
	 * @param response
	 * @throws SOAPException
	 */
	private void saveServiceResponseXMLtoFile(String serviceName, SOAPMessage response) throws SOAPException {
		FileOutputStream fop = null;

		try {
			StringBuilder baseDirPath = new StringBuilder(
					ResourceLoader.getKeyValue(ServiceConfig.SAVED_SERVICE_RESPONSE_XML_PATH));

			File xmlDir = new File(baseDirPath.toString());
			// if file doesnt exists, then create it
			if (!xmlDir.exists()) {
				xmlDir.mkdirs();
			}

			String filePath = baseDirPath.append(serviceName).append((".xml")).toString();

			File xmlFile = new File(filePath);

			// if file doesnt exists, then create it
			if (!xmlFile.exists()) {
				xmlFile.createNewFile();
			}

			fop = new FileOutputStream(xmlFile);
			response.writeTo(fop);
			fop.flush();

		} catch (IOException e) {

		} finally {
			try {
				if (fop != null) {
					fop.close();
				}
			} catch (IOException e) {

			}
		}
	}
	
	/**
	 * Get Service response xml
	 * 
	 * @param serviceName
	 * @return
	 */
	private String getServiceResponseXMLFromFile(String serviceName) {
		StringBuilder result = new StringBuilder();
		BufferedReader br = null;
		FileReader fr = null;
		String currentLine = null;
		
		try {
			StringBuilder baseDirPath = new StringBuilder(ResourceLoader.getKeyValue(ServiceConfig.SAVED_SERVICE_RESPONSE_XML_PATH));
			String filePath = baseDirPath.append(serviceName).append((".xml")).toString();
			fr = new FileReader(filePath);
			br = new BufferedReader(fr);

			while ((currentLine = br.readLine()) != null) {
				result.append(currentLine);
			}

		} catch (IOException e) {

		} finally {
			try {
				if (br != null)
					br.close();
				if (fr != null)
					fr.close();
			} catch (IOException ex) {

			}
		}
		return result.toString();
	}
	
	/**
	 * @param serviceName
	 * @param serviceConfigParams
	 * @param response
	 * @param cur
	 * @param delta
	 * @param outputFormat
	 * @return
	 * @throws FileNotFoundException
	 * @throws TransformerException
	 */
	private String createSOAPResponse(String serviceName, Map<String, String> serviceConfigParams, String response,
			int cur, int delta, String outputFormat, String operationName) throws FileNotFoundException, TransformerException {
		
		return createSOAPResponseImpl(serviceName, serviceConfigParams, response, cur, delta, outputFormat, operationName);
	}
	
	/**
	 * @param soapMessage
	 * @param serviceName
	 * @param params
	 * @param operationName
	 * @return
	 * @throws SOAPException
	 */

	protected abstract SOAPMessage createSOAPRequestImpl(SOAPMessage soapMessage, String serviceName,
			Map<Object, Object> params, String operationName) throws SOAPException;	
	
	/**
	 * @param serviceName
	 * @param serviceConfigParams
	 * @param response
	 * @param cur
	 * @param delta
	 * @param outputFormat
	 * @param operationName
	 * @return
	 * @throws FileNotFoundException
	 * @throws TransformerException
	 */
	protected abstract String createSOAPResponseImpl(String serviceName, Map<String, String> serviceConfigParams,
			String response, int cur, int delta, String outputFormat, String operationName)
			throws FileNotFoundException, TransformerException;
}
