package com.honda.ws.invokers;

import com.honda.ws.api.WebServiceAPI;

import java.io.IOException;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
	immediate = true,
	service = KalturaVideoWebService.class
		
)
public class KalturaVideoWebService {

	public String getKalturaVideoDetails(String videoId) throws IOException {
		
		String requestURL ="http://staging.media.services.honda.com/GetVideoDetails.ashx?partnerID=2053502&entryname="+videoId+"&ReturnType=JSON";
		
		String response = webServiceAPI.invokeGet(requestURL, null);
		
		return response;
		
	}
	
	@Reference
	private WebServiceAPI webServiceAPI;
}
