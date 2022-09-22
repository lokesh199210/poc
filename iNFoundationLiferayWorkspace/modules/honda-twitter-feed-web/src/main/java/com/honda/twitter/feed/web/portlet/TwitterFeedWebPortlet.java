package com.honda.twitter.feed.web.portlet;

import com.honda.common.constant.HondaCommonConstants;
import com.honda.twitter.feed.web.constants.TwitterFeedWebPortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

/**
 * @author Lokesh Sharma2
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=" + HondaCommonConstants.APPLICATION_CATEGORY,
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=TwitterFeedWeb",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/jsps/view.jsp",
		"javax.portlet.name=" + TwitterFeedWebPortletKeys.TWITTERFEEDWEB,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class TwitterFeedWebPortlet extends MVCPortlet {
}