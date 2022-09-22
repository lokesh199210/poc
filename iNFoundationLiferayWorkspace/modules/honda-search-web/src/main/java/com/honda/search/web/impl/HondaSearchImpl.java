package com.honda.search.web.impl;

import com.honda.commom.utils.SearchContainerUtil;
import com.honda.search.web.api.HondaSearchAPI;
import com.honda.search.web.beans.HondaSearchResultBean;
import com.honda.search.web.helper.HondaSearchHelper;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
	immediate = true,
	service = HondaSearchAPI.class
)
public class HondaSearchImpl implements HondaSearchAPI{
	
	@Override
	public void search(RenderRequest renderRequest,RenderResponse renderResponse) throws PortalException{
		
		SearchContainerUtil<HondaSearchResultBean> searchContainerUtil = new SearchContainerUtil<HondaSearchResultBean>(
				renderRequest, renderResponse, "No results found");

		SearchContainer<HondaSearchResultBean> searchContainer = searchContainerUtil.getSearchContainer();
		
		hondaSearchHelper.search(renderRequest,searchContainer);
			
		renderRequest.setAttribute("searchContainer", searchContainer);
		
	}
	
	@Reference
	private HondaSearchHelper hondaSearchHelper;
	
}
