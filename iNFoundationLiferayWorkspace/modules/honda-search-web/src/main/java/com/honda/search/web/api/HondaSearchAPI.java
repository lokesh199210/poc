package com.honda.search.web.api;

import com.liferay.portal.kernel.exception.PortalException;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

public interface HondaSearchAPI {

	void search(RenderRequest renderRequest, RenderResponse renderResponse) throws PortalException;

}
