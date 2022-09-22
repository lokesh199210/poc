package com.honda.rest.builder.helper;

import com.honda.commom.utils.CommonUtil;
import com.honda.commom.utils.ObjectMapperUtil;
import com.honda.migration.db.handlers.PubAccessMappingRefHandler;
import com.honda.obj.mapper.beans.Details;
import com.honda.obj.mapper.beans.Item;
import com.honda.obj.mapper.beans.NameIdBean;
import com.honda.obj.mapper.beans.UploadResponseBean;
import com.honda.obj.mapper.beans.UserProvisionBean;
import com.honda.rest.builder.api.RestBuilderAPI;
import com.honda.search.api.SearchAPI;
import com.honda.search.query.api.SearchQueryAPI;
import com.liferay.journal.model.JournalArticle;
import com.liferay.journal.util.JournalConverter;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, service = RestBuilderHelper.class)
/**
 * 
 * @author Lokesh Sharma
 *
 */
public class RestBuilderHelper {

	public String getLandingPageURL(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {

		JSONObject json = JSONFactoryUtil.createJSONObject();
		int status = HttpServletResponse.SC_OK;
		String url = StringPool.BLANK;
		String error = StringPool.BLANK;
		try {

			url = restBuilderAPI.fetchPageURL(httpServletRequest);

			_log.info("Page url " + url);

		} catch (PortalException e) {
			status = HttpServletResponse.SC_BAD_REQUEST;
			error = e.getMessage();
		}

		httpServletResponse.setStatus(status);

		json.put("statusCode", status);

		if (Validator.isNotNull(url))
			json.put("url", url);

		if (Validator.isNotNull(error))
			json.put("errorMsg", error);

		return json.toString();
	}

	/**
	 * 
	 * @param httpServletRequest
	 * @param httpServletResponse
	 * @return
	 */
	public String uploadDocument(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {

		int statusCode = HttpServletResponse.SC_OK;
		String errorMsg = StringPool.BLANK;
		Details docDetails = null;

		try {
			FileEntry fileEntry = restBuilderAPI.uploadDocument(httpServletRequest);
			docDetails = new Details(fileEntry.getFolder().getName(), fileEntry.getTitle(), fileEntry.getVersion(),
					fileEntry.getFileEntryId());
		} catch (PortalException e) {
			statusCode = HttpServletResponse.SC_BAD_REQUEST;
			errorMsg = e.getMessage();
			
			_log.error(e, e);
		}

		httpServletResponse.setStatus(statusCode);

		UploadResponseBean docResponseBean = new UploadResponseBean(statusCode, errorMsg, docDetails);

		return ObjectMapperUtil.parseToJSON(docResponseBean);

	}

	public String createWebContent(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {

		int statusCode = HttpServletResponse.SC_OK;
		String errorMsg = StringPool.BLANK;
		Details docDetails = null;
		try {
			JournalArticle journalArticle = restBuilderAPI.createWebContent(httpServletRequest);
			docDetails = new Details(journalArticle.getFolder().getName(), journalArticle.getTitle(),
					String.valueOf(journalArticle.getVersion()), Long.valueOf(journalArticle.getArticleId()));
		} catch (PortalException e) {
			statusCode = HttpServletResponse.SC_BAD_REQUEST;
			errorMsg = e.getMessage();
		}

		httpServletResponse.setStatus(statusCode);

		UploadResponseBean docResponseBean = new UploadResponseBean(statusCode, errorMsg, docDetails);

		return ObjectMapperUtil.parseToJSON(docResponseBean);

	}

	public String getAssetListing(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		JSONObject json = JSONFactoryUtil.createJSONObject();
		int status = HttpServletResponse.SC_OK;
		String error = StringPool.BLANK;
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		
		try {
			jsonArray = restBuilderAPI.getAssetListing(httpServletRequest);
			json.put("items", jsonArray);
		} catch (Exception e) {
			status = HttpServletResponse.SC_BAD_REQUEST;
			error = e.getMessage();
		}
		
		httpServletResponse.setStatus(status);

		json.put("statusCode", status);

		if (Validator.isNotNull(error))
			json.put("errorMsg", error);

		return json.toString();
	}

	public String provisionUser(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {

		JSONObject json = JSONFactoryUtil.createJSONObject();
		int status = HttpServletResponse.SC_OK;
		String error = StringPool.BLANK;
		
		UserProvisionBean userProvisionBean = null;
		try {
			userProvisionBean = ObjectMapperUtil.parseToBean(CommonUtil.getRequestBodyStr(httpServletRequest),UserProvisionBean.class);
		} 
		catch (Exception e) {
			_log.info("Error occured in parsing json to bean :: " + e.getMessage());
		}
		
		try {
			JSONArray jsonArray = restBuilderAPI.provisionUser(httpServletRequest,userProvisionBean);   
			json.put("items", jsonArray);
		} 
		catch (PortalException e) {
			status = HttpServletResponse.SC_BAD_REQUEST;
			error = e.getMessage();
		}

		httpServletResponse.setStatus(status);

		json.put("statusCode", status);
		
		if (Validator.isNotNull(error))
			json.put("errorMsg", error);

		return json.toString();
	}	
	
	public String getAssetLibraries(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		
		int statusCode = HttpServletResponse.SC_OK;
		String errorMsg = StringPool.BLANK;
		List<Item> items = null;
		
		try {
			items = restBuilderAPI.getAssetLibraries(httpServletRequest);
		} 
		catch (Exception e) {
			statusCode = HttpServletResponse.SC_BAD_REQUEST;
			errorMsg = e.getMessage();
		}
		
		httpServletResponse.setStatus(statusCode);

		NameIdBean nameIdBean = new NameIdBean(items, statusCode, errorMsg);

		return ObjectMapperUtil.parseToJSON(nameIdBean);
	}
	
	public String getPublicationRoles(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		
		int statusCode = HttpServletResponse.SC_OK;
		String errorMsg = StringPool.BLANK;
		List<Item> items = null;
		
		try {
			items = restBuilderAPI.getPublicationRoles(httpServletRequest);
		} 
		catch (Exception e) {
			statusCode = HttpServletResponse.SC_BAD_REQUEST;
			errorMsg = e.getMessage();
		}
		
		httpServletResponse.setStatus(statusCode);

		NameIdBean nameIdBean = new NameIdBean(items, statusCode, errorMsg);

		return ObjectMapperUtil.parseToJSON(nameIdBean);
	}
	
	public String getSiteRoles(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		
		int statusCode = HttpServletResponse.SC_OK;
		String errorMsg = StringPool.BLANK;
		List<Item> items = null;
		
		try {
			items = restBuilderAPI.getSiteRoles(httpServletRequest);
		} 
		catch (Exception e) {
			statusCode = HttpServletResponse.SC_BAD_REQUEST;
			errorMsg = e.getMessage();
		}
		
		httpServletResponse.setStatus(statusCode);

		NameIdBean nameIdBean = new NameIdBean(items, statusCode, errorMsg);

		return ObjectMapperUtil.parseToJSON(nameIdBean);
	}
	
	public String getSites(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		
		int statusCode = HttpServletResponse.SC_OK;
		String errorMsg = StringPool.BLANK;
		List<Item> items = null;
		
		try {
			items = restBuilderAPI.getSites(httpServletRequest);
		} 
		catch (Exception e) {
			statusCode = HttpServletResponse.SC_BAD_REQUEST;
			errorMsg = e.getMessage();
		}
		
		httpServletResponse.setStatus(statusCode);

		NameIdBean nameIdBean = new NameIdBean(items, statusCode, errorMsg);

		return ObjectMapperUtil.parseToJSON(nameIdBean);
	}
	
	public String terminateUser(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {

		JSONObject json = JSONFactoryUtil.createJSONObject();
		int status = HttpServletResponse.SC_OK;
		String error = StringPool.BLANK;
		String message = StringPool.BLANK;
		
		try {
			message = restBuilderAPI.terminateUser(httpServletRequest);
			json.put("message", message);
			_log.info("Message :: " + message);
		} 
		catch (PortalException e) {
			status = HttpServletResponse.SC_BAD_REQUEST;
			error = e.getMessage();
		}

		httpServletResponse.setStatus(status);

		json.put("statusCode", status);
		
		if (Validator.isNotNull(message))
			json.put("message", message);
		
		if (Validator.isNotNull(error))
			json.put("errorMsg", error);

		return json.toString();
	}	
	
	public String testEsDq() throws PortalException {
		
		BooleanQuery booleanQuery = searchQueryAPI.createQuery(46020, PortalUtil.getDefaultCompanyId(), JournalArticle.class.getName());
		
		long count = searchAPI.searchCount(booleanQuery, PortalUtil.getDefaultCompanyId());
		
		return String.valueOf(count);
	}
	
	private static final Log _log = LogFactoryUtil.getLog(RestBuilderHelper.class);

	@Reference
	private RestBuilderAPI restBuilderAPI;

	@Reference
	private JournalConverter journalConverter;
	
	@Reference
	private PubAccessMappingRefHandler pubAccessMappingRefHandler;
	
	@Reference
	private SearchAPI searchAPI;
	
	@Reference
	private SearchQueryAPI searchQueryAPI;

}
