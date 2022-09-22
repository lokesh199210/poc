package com.honda.rest.builder.api;

import com.honda.obj.mapper.beans.Item;
import com.honda.obj.mapper.beans.UserProvisionBean;
import com.liferay.journal.model.JournalArticle;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.repository.model.FileEntry;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

public interface RestBuilderAPI {

	String fetchPageURL(HttpServletRequest httpServletRequest) throws PortalException;

	FileEntry uploadDocument(HttpServletRequest httpServletRequest) throws PortalException;

	JournalArticle createWebContent(HttpServletRequest httpServletRequest) throws PortalException;

	JSONArray getAssetListing(HttpServletRequest httpServletRequest) throws PortalException;
	
	JSONArray provisionUser(HttpServletRequest httpServletRequest, UserProvisionBean userProvisionBean) throws PortalException;
	
	List<Item> getAssetLibraries(HttpServletRequest httpServletRequest) throws PortalException;
	
	List<Item> getPublicationRoles(HttpServletRequest httpServletRequest) throws PortalException;
	
	List<Item> getSiteRoles(HttpServletRequest httpServletRequest) throws PortalException;
	
	List<Item> getSites(HttpServletRequest httpServletRequest) throws PortalException;
	
	String terminateUser(HttpServletRequest httpServletRequest) throws PortalException;
	
}
