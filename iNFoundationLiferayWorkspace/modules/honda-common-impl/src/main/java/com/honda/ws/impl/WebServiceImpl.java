package com.honda.ws.impl;

import com.honda.ws.api.WebServiceAPI;
import com.honda.ws.bean.AuthenticationToken;
import com.honda.ws.bean.RequestHeader;
import com.liferay.portal.kernel.util.Http;
import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.kernel.util.Validator;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.osgi.service.component.annotations.Component;

@Component(
	immediate = true,
	service = WebServiceAPI.class
)
/**
 * 
 * @author Lokesh Sharma
 *
 */
public class WebServiceImpl implements WebServiceAPI {

	private static String charset;
	private String requestContentType;

	static {
		charset = Charset.defaultCharset().name();
	}
		
	@Override
	public RequestHeader authenticateUser(String userName, String password, String contentType) {
		
		AuthenticationToken authToken = new AuthenticationToken(userName, password);
		
		requestContentType = contentType;

		return new RequestHeader(contentType, authToken);
	}

	@Override
	public String invokePost(String requestURL, RequestHeader headers, String content,String bodyContentType) throws IOException {

		HttpPost httpPost = new HttpPost(requestURL);
		StringEntity requestBody = new StringEntity(content);
		requestBody.setContentType(bodyContentType);
		requestBody.setContentEncoding(charset);
		httpPost.setEntity(requestBody);
		
		if(Validator.isNotNull(headers))
			headers.getHeaderProperties().forEach(httpPost::setHeader);
		
		String result = null;
		CloseableHttpClient httpClient = HttpClientBuilder.create().build();
		CloseableHttpResponse response = httpClient.execute(httpPost);
		HttpEntity entity = response.getEntity();
		if (entity != null)
			result = EntityUtils.toString(entity);
		
		return result;	
	}

	@Override
	public String invokeGet(String requestURL, RequestHeader headers) throws IOException {
		
		HttpGet httpGet = new HttpGet(requestURL);
		
		if(Validator.isNotNull(headers))
			headers.getHeaderProperties().forEach(httpGet::setHeader);
		
		String result = null;
		CloseableHttpClient httpClient = HttpClientBuilder.create().build();
		CloseableHttpResponse response = httpClient.execute(httpGet);
		HttpEntity entity = response.getEntity();
		if (entity != null)
			result = EntityUtils.toString(entity);

		return result;	
	}
	
	@Override
	public String getResponse(String requestURL, RequestHeader headers, String content, boolean isPost)
			throws IOException {
		Http.Options httpOptions = getHttpOptions(requestURL, headers.getHeaderProperties());

		httpOptions.setBody(content, requestContentType, charset);

		httpOptions.setPost(isPost);

		return HttpUtil.URLtoString(httpOptions);
	}

	@Override
	public String getResponse(String requestURL, RequestHeader headers, String content, boolean isPost, int timeOut)
			throws IOException {
		Http.Options httpOptions = getHttpOptions(requestURL, headers.getHeaderProperties());

		httpOptions.setBody(content, requestContentType, charset);

		httpOptions.setPost(isPost);
		httpOptions.setTimeout(timeOut);

		return HttpUtil.URLtoString(httpOptions);
	}
	
	@Override
	public String getResponse(String requestURL, RequestHeader headers, boolean isPost) throws IOException {
		Http.Options httpOptions = getHttpOptions(requestURL, headers.getHeaderProperties());

		httpOptions.setPost(isPost);

		return HttpUtil.URLtoString(httpOptions);
	}
	
	private Http.Options getHttpOptions(String requestURL, Map<String, String> headers) {
		Http.Options options = new Http.Options();

		options.setLocation(requestURL);
		options.setHeaders(headers);

		return options;
	}

}
