package com.honda.in.admin.web.util;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.List;

import javax.portlet.RenderRequest;

public interface AdminWebUtil {

	/**
	 * 
	 * @param renderRequest
	 */
	static void fetchMySites(RenderRequest renderRequest) {
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		try {
			List<Group> userSites = themeDisplay.getUser().getMySiteGroups();
			renderRequest.setAttribute("userSites", userSites);
		} catch (PortalException e) {
			e.printStackTrace();
		}
	}
	
	


}
