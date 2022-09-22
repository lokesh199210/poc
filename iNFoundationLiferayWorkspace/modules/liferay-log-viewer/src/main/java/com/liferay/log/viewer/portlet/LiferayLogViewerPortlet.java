package com.liferay.log.viewer.portlet;

import com.liferay.log.viewer.constants.LiferayLogViewerPortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

/**
 * @author Lokesh Sharma2
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.add-default-resource=true",
		"com.liferay.portlet.display-category=category.hidden",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.header-portlet-javascript=/js/main.js",
		"com.liferay.portlet.layout-cacheable=true",
		"com.liferay.portlet.private-request-attributes=false",
		"com.liferay.portlet.private-session-attributes=false",
		"com.liferay.portlet.render-weight=50",
		"com.liferay.portlet.use-default-template=true",
		"javax.portlet.display-name=Live Logs",
		"javax.portlet.expiration-cache=0",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/jsps/view.jsp",
		"javax.portlet.name=" + LiferayLogViewerPortletKeys.LIFERAYLOGVIEWER,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user",
		"com.liferay.portlet.footer-portlet-javascript=/js/hilitor.js",
		"com.liferay.portlet.footer-portlet-javascript=/js/makeTextFile.js",
		"com.liferay.portlet.footer-portlet-javascript=/js/jquery.scrollTo.min.js",
		"com.liferay.portlet.footer-portlet-javascript=/js/main.js"
	},
	service = Portlet.class
)
public class LiferayLogViewerPortlet extends MVCPortlet {
}