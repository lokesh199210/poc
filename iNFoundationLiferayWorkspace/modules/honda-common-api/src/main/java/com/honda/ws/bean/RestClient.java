package com.honda.ws.bean;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

/**
 * 
 * @author Lokesh Sharma
 *
 */
public class RestClient {

	private RequestHeader headers;
	private RequestParameter parameters;
	private String serviceURL;

	private boolean isConnected;
	private HttpURLConnection connection;
	private String response;

	public RestClient(String url, RequestHeader headers, RequestParameter parameters) {
		setServiceURL(url);
		setRequestHeader(headers);
		setRequestParameter(parameters);
	}

	public void setServiceURL(String url) {
		this.serviceURL = url;
	}

	public void setRequestHeader(RequestHeader headers) {
		this.headers = headers;
	}

	public void setRequestParameter(RequestParameter parameters) {
		this.parameters = parameters;
	}

	public String getResponse() {
		return response;
	}

	public void invoke() throws IOException {
		if (!isConnected) {
			connect();
		}

		connection.setRequestMethod(headers.getRequestMethod());
		for (Map.Entry<String, String> headerProperty : headers.getHeaderProperties().entrySet()) {
			connection.setRequestProperty(headerProperty.getKey(), headerProperty.getValue());
		}

		if (headers.getRequestMethod().equals(RequestMethod.GET.toString()))
			setRequestBody();

		if (connection.getResponseCode() != HttpURLConnection.HTTP_OK)
			throw new IOException("Server responded with code 500");

		readResponse();

		disconnect();
	}

	private boolean connect() throws IOException {
		isConnected = false;

		URL url = new URL(serviceURL);

		connection = (HttpURLConnection) url.openConnection();

		connection.setDoOutput(true);

		isConnected = true;

		return isConnected;
	}

	private void disconnect() {
		if (isConnected)
			connection.disconnect();
	}

	private void setRequestBody() throws IOException {
		String input = parameters.getRequestBody();

		OutputStream bodyOutputStream = connection.getOutputStream();
		bodyOutputStream.write(input.getBytes());
		bodyOutputStream.flush();
		bodyOutputStream.close();
	}

	private void readResponse() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

		StringBuilder output = new StringBuilder();

		int codePoint;
		while ((codePoint = reader.read()) != -1)
			output.append((char) codePoint);

		response = output.toString();
	}

}