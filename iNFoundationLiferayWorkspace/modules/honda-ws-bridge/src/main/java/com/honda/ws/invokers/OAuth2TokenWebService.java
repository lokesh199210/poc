package com.honda.ws.invokers;

import com.honda.db.handlers.OAuth2TokenHandler;
import com.honda.ws.api.WebServiceAPI;
import com.honda.ws.bean.RequestHeader;
import com.liferay.portal.kernel.util.ContentTypes;

import java.io.IOException;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * 
 * @author Lokesh Sharma
 *
 */
@Component(
	immediate = true,
	service = OAuth2TokenWebService.class
)
public class OAuth2TokenWebService {
	
	
	public String fetchAuthToken(String serviceURL,String authUserName,String authPassword) throws IOException {
		
		RequestHeader requestHeader = webServiceAPI.authenticateUser(authUserName, authPassword,
					ContentTypes.APPLICATION_X_WWW_FORM_URLENCODED);
			
		return webServiceAPI.invokePost(serviceURL, requestHeader,createRequestBody(),ContentTypes.APPLICATION_X_WWW_FORM_URLENCODED);
			
	}
	
	private String createRequestBody() {
		
		return tokenDbHandler.getDetailsForAuth();	
		
	}
	
	
	@Reference(unbind = "-")
	private WebServiceAPI webServiceAPI ;
	
	@Reference(unbind = "-")
	private OAuth2TokenHandler tokenDbHandler ;
	
}
