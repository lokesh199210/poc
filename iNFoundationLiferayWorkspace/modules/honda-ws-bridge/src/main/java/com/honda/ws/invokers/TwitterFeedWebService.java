package com.honda.ws.invokers;

import com.honda.ws.api.WebServiceAPI;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.io.IOException;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
	immediate = true,
	service = TwitterFeedWebService.class
)
public class TwitterFeedWebService {

	public String getTwitterFeed(String feedURL) throws IOException {
		
		String requestURL = "https://publish.twitter.com/oembed?url=" + feedURL ;
		
		String response = webServiceAPI.invokeGet(requestURL, null);
		
		_log.info("Response ----->" + response);
		
		return response;
		
	}
	
	@Reference
	private WebServiceAPI webServiceAPI ;
	
	private static final Log _log = LogFactoryUtil.getLog(TwitterFeedWebService.class);
}
