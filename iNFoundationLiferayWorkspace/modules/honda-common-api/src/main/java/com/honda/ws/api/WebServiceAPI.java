package com.honda.ws.api;

import com.honda.ws.bean.RequestHeader;

import java.io.IOException;

/**
 * 
 * @author Lokesh Sharma
 *
 */
public interface WebServiceAPI {

	/**
	 * Create a header object for web service request with required authentication
	 * and other request details.
	 * 
	 * @param userName    The authenticated userName
	 * @param password    The authentication password for given user name
	 * @param contentType The content type for the request header
	 * @return A web service request header
	 */
	public RequestHeader authenticateUser(String userName, String password, String contentType);
	
	/**
	 * Fetch a response from given post web service URL with appropriate request headers and content 
	 * and content.
	 * @param requestURL
	 * @param headers
	 * @param bodyContent
	 * @return
	 * @throws IOException
	 */
	public String invokePost(String requestURL, RequestHeader headers, String bodyContent,String bodyContentType)throws IOException;
	
	/**
	 * Fetch a response from given get web service URL with appropriate request headers and content 
	 * and content.
	 * @param requestURL
	 * @param headers
	 * @param bodyContent
	 * @return
	 * @throws IOException
	 */
	public String invokeGet(String requestURL, RequestHeader headers)throws IOException;
	
	/**
	 * Fetch a response from given get web service URL with appropriate request headers, content and is post or not 
	 * @param requestURL
	 * @param headers
	 * @param content
	 * @param isPost
	 * @return
	 * @throws IOException
	 */
	public String getResponse(String requestURL, RequestHeader headers, String content, boolean isPost)throws IOException;
	
	/**
	 * Fetch a response from given get web service URL with appropriate request headers, content and is post or not with timeout
	 * @param requestURL
	 * @param headers
	 * @param content
	 * @param isPost
	 * @param timeOut
	 * @return
	 * @throws IOException
	 */
	public String getResponse(String requestURL, RequestHeader headers, String content, boolean isPost, int timeOut)throws IOException;

	/**
	 * 
	 * @param requestURL
	 * @param headers
	 * @param isPost
	 * @return
	 * @throws IOException
	 */
	public String getResponse(String requestURL, RequestHeader headers, boolean isPost) throws IOException;
	
}
