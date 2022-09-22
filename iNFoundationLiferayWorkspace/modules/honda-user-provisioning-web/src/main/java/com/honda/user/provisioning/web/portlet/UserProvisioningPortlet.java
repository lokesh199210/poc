package com.honda.user.provisioning.web.portlet;

import com.honda.common.constant.HondaCommonConstants;
import com.honda.user.provisioning.web.constants.UserProvisioningWebPortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

/**
 * @author Vinisha Pathak
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=" + HondaCommonConstants.APPLICATION_CATEGORY,
		"com.liferay.portlet.header-portlet-css=/css/common.css",
		"com.liferay.portlet.header-portlet-javascript=/js/common.js",
		"com.liferay.portlet.instanceable=false",
		"javax.portlet.display-name=UserProvisioningWeb",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/jsps/view.jsp",
		"javax.portlet.name=" + UserProvisioningWebPortletKeys.USERPROVISIONINGWEB,
		"javax.portlet.resource-bundle=content.Language",
		"com.liferay.portlet.requires-namespaced-parameters=false",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class UserProvisioningPortlet extends MVCPortlet {
	
	
}