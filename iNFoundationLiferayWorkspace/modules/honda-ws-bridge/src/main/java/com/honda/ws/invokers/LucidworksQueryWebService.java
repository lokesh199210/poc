package com.honda.ws.invokers;

import com.honda.ws.api.WebServiceAPI;
import com.honda.ws.bean.RequestHeader;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.Validator;

import java.io.IOException;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
	immediate = true,
	service = LucidworksQueryWebService.class
		
)
public class LucidworksQueryWebService {

	public String fetchContent(String keyword,String facetType) throws IOException, PortalException {
		
		RequestHeader headers = webServiceAPI.authenticateUser("LTI-Lokesh Sharma", "Bie1zacr", ContentTypes.APPLICATION_JSON);
		
		if(Validator.isNull(headers))
			throw new PortalException("Unable to autheticate to Lucid works, please check credentials");
		
		String requestURL = "http://hnadxlesfps01.amerhonda.com:8764/api/apps/LIFERAY_DEV/query/LIFERAY_DEV?q="
				+ (Validator.isNull(keyword) ? StringPool.STAR + StringPool.COLON : keyword);
		
		_log.info("facetType ------------> " + facetType);
		
		if(Validator.isNotNull(facetType))
			requestURL = requestURL + "&fq=content_type_s:("+facetType+")";
		
		requestURL = requestURL +"&rows=10&start=0";
		
		_log.info("Request URL ------->" +requestURL);
		
		String response = webServiceAPI.getResponse(requestURL, headers,Boolean.FALSE);
		
		_log.info("response------->" + response);
		
		if(Validator.isNull(response))
			throw new PortalException("Unable to fetch content to Lucid  works.");
		
		return response;
		
	}
	
	@Reference(unbind = "-")
	private WebServiceAPI webServiceAPI ;
	
	private static final Log _log = LogFactoryUtil.getLog(LucidworksQueryWebService.class);
}
