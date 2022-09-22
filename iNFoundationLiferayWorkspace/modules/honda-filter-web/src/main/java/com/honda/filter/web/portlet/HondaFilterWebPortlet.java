package com.honda.filter.web.portlet;

import com.honda.common.constant.HondaCommonConstants;
import com.honda.db.handlers.AssetEntryCategoryHandler;
import com.honda.filter.web.constants.HondaFilterWebPortletKeys;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;

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
		"com.liferay.portlet.footer-portlet-javascript=/js/main.js",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=HondaFilterWeb",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/jsps/view.jsp",
		"javax.portlet.name=" + HondaFilterWebPortletKeys.HONDAFILTERWEB,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class HondaFilterWebPortlet extends MVCPortlet {
	
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {

		try {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(renderRequest);
			renderRequest.setAttribute("documentTypes", assetEntryCategoryHandler.getDocumentTypeAssetCatgories(serviceContext,Boolean.FALSE));
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		super.render(renderRequest, renderResponse);
	}

	@Reference
	private AssetEntryCategoryHandler  assetEntryCategoryHandler;
	
}