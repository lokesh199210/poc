package com.honda.ws.invokers;

import com.honda.ws.api.WebServiceAPI;
import com.honda.ws.bean.RequestHeader;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.Validator;

import java.io.IOException;
import java.util.Map;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * 
 * @author Lokesh Sharma
 *
 */
@Component(
	immediate = true,
	service = LucidworksIndexWebService.class
)
public class LucidworksIndexWebService {

	/**
	 * 
	 * @param attibuteMap
	 * @throws IOException
	 * @throws PortalException
	 */
	public void indexContent(Map<String,String> attributeMap) throws IOException, PortalException {
		
		RequestHeader headers = webServiceAPI.authenticateUser("LTI-Lokesh Sharma", "Bie1zacr", ContentTypes.APPLICATION_JSON);
		
		if(Validator.isNull(headers))
			throw new PortalException("Unable to autheticate to Lucid works, please check credentials");
		
		parseToJSON(attributeMap);
		
		String response = webServiceAPI.invokePost("http://hnadxlesfps01.amerhonda.com:8764/api/apps/LIFERAY_DEV/index/LIFERAY_DEV",
				headers, jsonObject.toString(), ContentTypes.APPLICATION_JSON);
		
		if(Validator.isNull(response))
			throw new PortalException("Unable to index content to Lucid  works.");
		
	}
	
	/**
	 * 
	 * @param attibuteMap
	 */
	private void parseToJSON(Map<String,String> attibuteMap) {
		
		jsonObject = JSONFactoryUtil.createJSONObject(); 
		attibuteMap.forEach((key,value) -> jsonObject.put(key, value));
		
		_log.info("Json object to be sent to lucid works------>" +jsonObject);
		
	}
	
	@Reference(unbind = "-")
	private WebServiceAPI webServiceAPI ;
	
	private JSONObject jsonObject ;
	
	private static final Log _log = LogFactoryUtil.getLog(LucidworksIndexWebService.class);
}
