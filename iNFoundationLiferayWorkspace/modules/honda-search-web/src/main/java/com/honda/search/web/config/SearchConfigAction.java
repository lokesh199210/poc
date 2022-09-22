package com.honda.search.web.config;

import com.honda.search.web.constants.HondaSearchWebPortletKeys;
import com.liferay.portal.kernel.portlet.ConfigurationAction;
import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;

import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;
import org.osgi.service.component.annotations.Modified;

import aQute.bnd.annotation.metatype.Configurable;

@Component(
    configurationPid = "com.honda.search.web.config.SearchConfig",
    configurationPolicy = ConfigurationPolicy.OPTIONAL,
    immediate = true,
    property = {
        "javax.portlet.name=" + HondaSearchWebPortletKeys.HONDASEARCHWEB
    },
    service = ConfigurationAction.class
)
public class SearchConfigAction extends DefaultConfigurationAction{

	@Override
	public String getJspPath(HttpServletRequest httpServletRequest) {
		
		return "/jsps/config/config.jsp";
	}
	
	@Override
	public void processAction(PortletConfig portletConfig, ActionRequest actionRequest, ActionResponse actionResponse)
			throws Exception {
		
		setPreference(actionRequest, "configuredAssetLibraryId", ParamUtil.getString(actionRequest, "configuredAssetLibraryId"));

		SessionMessages.add(actionRequest, "config-stored");

		SessionMessages.add(actionRequest, portletConfig.getPortletName() + SessionMessages.KEY_SUFFIX_REFRESH_PORTLET);
		
		super.processAction(portletConfig, actionRequest, actionResponse);
	}
	
	@Override
	public void include(PortletConfig portletConfig, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws Exception {
		
		httpServletRequest.setAttribute(SearchConfig.class.getName(), searchConfig);

		super.include(portletConfig, httpServletRequest, httpServletResponse);
	}
	
	@Activate
	@Modified
	protected void activate(Map<Object, Object> properties) {

		searchConfig = Configurable.createConfigurable(SearchConfig.class, properties);
	}

	private volatile SearchConfig searchConfig;
}
