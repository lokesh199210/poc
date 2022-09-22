package com.honda.db.handlers;

import com.liferay.oauth2.provider.model.OAuth2Application;
import com.liferay.oauth2.provider.service.OAuth2ApplicationLocalService;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * 
 * @author Lokesh Sharma
 *
 */
@Component(
	immediate = true,
	service = OAuth2TokenHandler.class
)
public class OAuth2TokenHandler {

	
	public String getDetailsForAuth() {
		
		DynamicQuery dynamicQuery = oAuth2ApplicationLocalService.dynamicQuery();
		
		dynamicQuery.add(RestrictionsFactoryUtil.eq("name", "Honda Rest"));
		
		OAuth2Application oAuth2Application = (OAuth2Application)oAuth2ApplicationLocalService.dynamicQuery(dynamicQuery).get(0);
		
		return "grant_type" + StringPool.EQUAL + oAuth2Application.getAllowedGrantTypes().toLowerCase() + StringPool.AMPERSAND + "client_id" 
				+ StringPool.EQUAL + oAuth2Application.getClientId() + StringPool.AMPERSAND + "client_secret" + StringPool.EQUAL + oAuth2Application.getClientSecret();
	}
	
	@Reference(unbind = "-")
	private OAuth2ApplicationLocalService oAuth2ApplicationLocalService ;
}
