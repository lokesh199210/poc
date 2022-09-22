package com.honda.commom.utils;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.portlet.PortletURL;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceResponse;

/**
 * 
 * @author Lokesh Sharma
 *
 * @param <R>
 */
public class SearchContainerUtil<R>{
	
	
	public SearchContainerUtil(PortletRequest portletRequest,PortletResponse portletResponse,String emptyMessage) {
		getSearchContainer(portletRequest, portletResponse,emptyMessage);
	}
	
	public SearchContainer<R> getSearchContainer() {
		return searchContainer;
	}
	
	/**
	 * This method initializes the search container with different configuration like sort order , type etc.
	 * To change any of those this method can be modified.
	 * 
	 * @param renderRequest
	 * @param renderResponse
	 * @return
	 */
	private void getSearchContainer(PortletRequest portletRequest,PortletResponse portletResponse,String emptyMessage) { 
		
		PortletURL iteratorURL = null;
		
		if(portletResponse instanceof RenderResponse) {
			iteratorURL = ((RenderResponse)portletResponse).createRenderURL();
		}else if(portletResponse instanceof ResourceResponse) {
			iteratorURL = ((ResourceResponse)portletResponse).createRenderURL();
		}
		/*
		 * Setting the current tab so that while performing any search operation tab
		 * value is maintained
		 */
		/*-------------- Creating search container object ------------------*/
		searchContainer =  new SearchContainer<>(portletRequest, null, null,SearchContainer.DEFAULT_CUR_PARAM,
				ParamUtil.getInteger(portletRequest, SearchContainer.DEFAULT_DELTA_PARAM, 20), iteratorURL, null,emptyMessage);
		
	}
	
	private SearchContainer<R> searchContainer;

}