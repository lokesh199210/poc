package com.honda.ws.soap.client.test;

import com.honda.ws.soap.client.SOAPServiceClient;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Vinisha Pathak
 *
 */
public class TestService {

	public static void main(String[] args) {
		
		String action = "";
		 
		if("getRequestStatus".equalsIgnoreCase(action)) 
			getRequestStatus();
		 
		if("searchPeople".equalsIgnoreCase(action)) 
			searchPeople();
		
		try {
			http_client();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void http_client() throws Exception {
        System.out.println("Invoke service using direct HTTP call with Basic Auth");
        String payload =
            "<SOAP-ENV:Envelope xmlns:SOAP-ENV=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:head=\"http://www.honda.com/global/1.0/header/\" xmlns:ns=\"http://hondaweb.com/nasa/2009/11\">\r\n" + 
            "   <SOAP-ENV:Header>\r\n" + 
            "      <head:hondaHeaderType>\r\n" + 
            "         <head:messageId>392dd708-34c0-4a94-a593-742bc8dc4f17</head:messageId>\r\n" + 
            "         <head:siteId>iN New Foundation</head:siteId>\r\n" + 
            "         <head:businessId>iN New Foundation</head:businessId>\r\n" + 
            "         <head:collectedTimestamp>2021-10-13T01:51:08.410-05:00</head:collectedTimestamp>\r\n" + 
            "      </head:hondaHeaderType>\r\n" + 
            "   </SOAP-ENV:Header>\r\n" + 
            "   <SOAP-ENV:Body>\r\n" + 
            "      <ns:searchPeople>\r\n" + 
            "         <ns:applicaitonId>392dd708-34c0-4a94-a593-742bc8dc4f17</ns:applicaitonId>\r\n" + 
            "         <ns:filter>(honda_guid =\"VAC58653\")</ns:filter>\r\n" + 
            "         <ns:responseDetail>3</ns:responseDetail>\r\n" + 
            "         <ns:page>1</ns:page>\r\n" + 
            "         <ns:pageSize>100</ns:pageSize>\r\n" + 
            "      </ns:searchPeople>\r\n" + 
            "   </SOAP-ENV:Body>\r\n" + 
            "</SOAP-ENV:Envelope>"; 

        httpPost("https://ws-dev.hondaweb.com:443/SOAP/nasa/ApplicationAdministrationSvc/", payload,
                 "username:password");				 
    }
 private static String httpPost(String destUrl, String postData,
                                   String authStr) throws Exception {
        URL url = new URL(destUrl);
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        if (conn == null) {
            return null;
        }
        conn.setRequestProperty("Content-Type", "text/xml; charset=UTF-8");
        conn.setDoOutput(true);
        conn.setDoInput(true);
        conn.setUseCaches(false);
        conn.setFollowRedirects(true);
        conn.setAllowUserInteraction(false);
        conn.setRequestMethod("POST"); 

        byte[] authBytes = authStr.getBytes("UTF-8");
        conn.setRequestProperty("Authorization", "Basic YDdJrp00RAB0ZWciRFpfvg==");
 

        System.out.println("post data size:" + postData.length());
 

        OutputStream out = conn.getOutputStream();
        OutputStreamWriter writer = new OutputStreamWriter(out, "UTF-8");
        writer.write(postData);
        writer.close();
        out.close();

        System.out.println("connection status: " + conn.getResponseCode() +
                           "; connection response: " +
                           conn.getResponseMessage());

        InputStream in = conn.getInputStream();
        InputStreamReader iReader = new InputStreamReader(in);
        BufferedReader bReader = new BufferedReader(iReader);

        String line;
        String response = "";
        System.out.println("==================Service response: ================ ");
        while ((line = bReader.readLine()) != null) {
            System.out.println(line);
            response += line;
        }
        iReader.close();
        bReader.close();
        in.close();
        conn.disconnect();
 

        return response;
    }

	private static void getRequestStatus() {
		System.out.println("Inside getRequestStatus() method !!");
		Map<Object, Object> params = new LinkedHashMap<>();
		params.put("applicaitonId","1234");
		params.put("requestId","5678");
		
		try {
			SOAPServiceClient serviceClient  = new SOAPServiceClient(); 
			String jsonResponse  = serviceClient.callSoapService("service.nasa.administration.services", params, "json","getRequestStatus");
			System.out.println("JSON Response ::::: " + jsonResponse.toString());
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void searchPeople() {
		System.out.println("Inside searchPeople() method !!");
		Map<Object, Object> params = new LinkedHashMap<>();
		params.put("applicaitonId","392dd708-34c0-4a94-a593-742bc8dc4f17");
		params.put("filter","(honda_guid =\"VAC58653\")");
		params.put("responseDetail", "3");
		params.put("page", "1");
		params.put("pageSize", "100");
		
		try {
			SOAPServiceClient serviceClient  = new SOAPServiceClient(); 
			String jsonResponse  = serviceClient.callSoapService("service.nasa.administration.services", params, "json","searchPeople");
			
			System.out.println("JSON Response ::::: " + jsonResponse.toString());
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
