package com.honda.search.web.portlet;

import com.honda.common.constant.HondaCommonConstants;
import com.honda.search.web.api.HondaSearchAPI;
import com.honda.search.web.constants.HondaSearchWebPortletKeys;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import java.io.IOException;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Lokesh Sharma2
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=" + HondaCommonConstants.APPLICATION_CATEGORY,
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=HondaSearchWeb",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/jsps/view.jsp",
		"javax.portlet.name=" + HondaSearchWebPortletKeys.HONDASEARCHWEB,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class HondaSearchWebPortlet extends MVCPortlet {
	
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		
		try {
			hondaSearchAPI.search(renderRequest, renderResponse);
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		super.render(renderRequest, renderResponse);
	}
	
	@Reference
	private HondaSearchAPI hondaSearchAPI;
}