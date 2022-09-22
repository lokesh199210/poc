package com.honda.in.admin.web.portlet;

import com.honda.common.constant.HondaCommonConstants;
import com.honda.in.admin.web.constants.INAdminWebPortletKeys;
import com.honda.in.admin.web.util.AdminWebUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import java.io.IOException;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

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
		"javax.portlet.display-name=IN Admin Web",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/jsps/view.jsp",
		"javax.portlet.name=" + INAdminWebPortletKeys.INADMINWEB,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class INAdminWebPortlet extends MVCPortlet {
		@Override
		public void render(RenderRequest renderRequest, RenderResponse renderResponse)
				throws IOException, PortletException {
			
			AdminWebUtil.fetchMySites(renderRequest);
		  
			super.render(renderRequest, renderResponse);
			
		}


		
	}
	
