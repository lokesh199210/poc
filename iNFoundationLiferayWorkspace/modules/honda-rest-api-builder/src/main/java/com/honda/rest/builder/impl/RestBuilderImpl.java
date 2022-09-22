package com.honda.rest.builder.impl;

import com.honda.commom.utils.CommonUtil;
import com.honda.commom.utils.ObjectMapperUtil;
import com.honda.common.beans.ContentMetaDateBean;
import com.honda.common.beans.ContentRequestBean;
import com.honda.common.beans.DocMetaDataBean;
import com.honda.common.beans.DocRequestBean;
import com.honda.db.handlers.AssetLibraryHandler;
import com.honda.db.handlers.DlFileEntryHandler;
import com.honda.db.handlers.DlFolderHandler;
import com.honda.db.handlers.FileEntryHandler;
import com.honda.db.handlers.GroupHandler;
import com.honda.db.handlers.JournalArticleHandler;
import com.honda.db.handlers.LayoutHandler;
import com.honda.db.handlers.RoleHandler;
import com.honda.db.handlers.UserHandler;
import com.honda.external.db.sb.model.ContentMigrationRef;
import com.honda.external.db.sb.model.DocMigrationRef;
import com.honda.external.db.sb.model.PubAccessMappingRef;
import com.honda.migration.db.handlers.ContentMigrationRefHandler;
import com.honda.migration.db.handlers.DocMigrationRefHandler;
import com.honda.migration.db.handlers.PubAccessMappingRefHandler;
import com.honda.obj.mapper.beans.Item;
import com.honda.obj.mapper.beans.RequestBodyBean;
import com.honda.obj.mapper.beans.UserProvisionBean;
import com.honda.permission.checker.ResourcePermissionChecker;
import com.honda.rest.builder.api.RestBuilderAPI;
import com.honda.rest.builder.constants.RestBuilderConstants.RestBuilderConstant;
import com.honda.rest.builder.utils.RestBuilderUtil;
import com.honda.ws.invokers.OAuth2TokenWebService;
import com.liferay.journal.model.JournalArticle;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.upload.UploadServletRequest;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
	immediate = true,
	service = RestBuilderAPI.class
)
public class RestBuilderImpl implements RestBuilderAPI{

	@Override
	public String fetchPageURL(HttpServletRequest httpServletRequest) throws PortalException {
		
		JSONObject requestJson = CommonUtil.getJsonFromRequestBody(httpServletRequest);
		
		String division = requestJson.getString(RestBuilderConstant.DIVISION_PARAM_KEY.getValue());
		
		String department = requestJson.getString(RestBuilderConstant.DEPARTMENT_PARAM_KEY.getValue());
		
		if(Validator.isNull(division))
			throw new PortalException("Division is mandatory");
		
		_log.info("Division ----->" + division);
		
		if(Validator.isNull(department))
			throw new PortalException("Department is mandatory");
		
		_log.info("department ----->" + department);
		
		//Fetch user by email address. 
		User dealerUser = userHandler.getByEmailDefaultCmp("dealer@amerhonda.com");
	
		//Fetch the group based on division
		Group grp = groupHandler.getByDivision(division);
		
		//Fetch the layout based on
		
		Layout layout = layoutHandler.getByDivisionNDepartment(department, grp.getGroupId());
		// 	Check permission for page view 
		

		if(permissionChecker.checkLayoutViewPermission(layout))

			return httpServletRequest.getScheme() + "://" +
				httpServletRequest.getServerName() + ":" +  httpServletRequest.getServerPort() +
					"/group"+grp.getFriendlyURL()+layout.getFriendlyURL()+StringPool.QUESTION +
		             "uid"+ StringPool.EQUAL + dealerUser.getUuid();
		
		return StringPool.BLANK;
	}
	
	@Override
	public FileEntry uploadDocument(HttpServletRequest httpServletRequest) throws PortalException {
		
		UploadServletRequest uploadRequest = PortalUtil.getUploadServletRequest(httpServletRequest);
		
		String metaDataStr = httpServletRequest.getParameter(RestBuilderConstant.METADATA_PARAM_KEY.getValue());
		
		File file = uploadRequest.getFile(RestBuilderConstant.FILE_PARAM_KEY.getValue());
		
		RestBuilderUtil.validateDocumentInputs(httpServletRequest, file);
		
		String fileName = uploadRequest.getFileName(RestBuilderConstant.FILE_PARAM_KEY.getValue());
		
		//Get content type and folder namefrom data base
		
		DocMigrationRef docMigrationRef = docMigrationRefHandler.getByAppCodeDiv(
				httpServletRequest.getParameter(RestBuilderConstant.AHMC_APP_CODE_PARAM_KEY.getValue()),
				httpServletRequest.getParameter(RestBuilderConstant.DIVISION_PARAM_KEY.getValue()));
		
		DocMetaDataBean docMetaDataBean = null;
		
		if(Validator.isNotNull(metaDataStr))
			docMetaDataBean = new DocMetaDataBean(docMigrationRef.getLiferay_document_type(),metaDataStr);
		
		DocRequestBean docRequestBean = new DocRequestBean(httpServletRequest.getParameter(RestBuilderConstant.TITLE_PARAM_KEY.getValue()),
				httpServletRequest.getParameter(RestBuilderConstant.DESCRIPTION_PARAM_KEY.getValue()),
				docMigrationRef.getLiferay_document_type(),
				CommonUtil.getDivsionNameByCode(docMigrationRef.getDivision()),docMigrationRef.getDepartment(), fileName, file,
				docMigrationRef.getLiferay_folder(),docMetaDataBean);
		
		
		return fileEntryHandler.uploadDocument(httpServletRequest, docRequestBean,docMigrationRef);
	}
	
	@Override
	public JournalArticle createWebContent(HttpServletRequest httpServletRequest) throws PortalException {
		
		UploadServletRequest uploadRequest = PortalUtil.getUploadServletRequest(httpServletRequest);
		
		String metaDataStr = httpServletRequest.getParameter(RestBuilderConstant.METADATA_PARAM_KEY.getValue());
		
		File file = uploadRequest.getFile(RestBuilderConstant.FILE_PARAM_KEY.getValue());
		
		String fileName = uploadRequest.getFileName(RestBuilderConstant.FILE_PARAM_KEY.getValue());
		
		RestBuilderUtil.validateDocumentInputs(httpServletRequest);
		
		ContentMigrationRef contentMigrationRef = contentMigrationRefHandler.getByAppCodeDiv(
				httpServletRequest.getParameter(RestBuilderConstant.AHMC_APP_CODE_PARAM_KEY.getValue()),
				httpServletRequest.getParameter(RestBuilderConstant.DIVISION_PARAM_KEY.getValue()));
		
		ContentMetaDateBean contentMetaDateBean = null;
		
		if(Validator.isNotNull(metaDataStr))
			contentMetaDateBean = new ContentMetaDateBean(contentMigrationRef.getLiferay_structure(),metaDataStr);
		
		ContentRequestBean contentRequestBean = new ContentRequestBean(
				httpServletRequest.getParameter(RestBuilderConstant.TITLE_PARAM_KEY.getValue()),
				httpServletRequest.getParameter(RestBuilderConstant.DESCRIPTION_PARAM_KEY.getValue()),
				contentMigrationRef.getLiferay_structure(), contentMigrationRef.getDivision(),
				httpServletRequest.getParameter(RestBuilderConstant.DEPARTMENT_PARAM_KEY.getValue()), file, fileName,
				contentMigrationRef.getLiferay_folder(), contentMetaDateBean);
		
		return journalArticleHandler.createJournalArticle(httpServletRequest, contentRequestBean);
		
	}
	
	@Override
	public JSONArray getAssetListing(HttpServletRequest httpServletRequest) throws PortalException {
		RequestBodyBean requestBodyBean = ObjectMapperUtil.parseToBean(CommonUtil.getRequestBodyStr(httpServletRequest),
				RequestBodyBean.class);

		PubAccessMappingRef accessMapping = pubAccessMappingRefHandler.getByAppCodeNDiv(requestBodyBean.getAhmcAppCode().trim(), requestBodyBean.getDivision().trim());
		
		String assetType = accessMapping.getAsset_type();
		
		RestBuilderUtil.validateRequestBody(requestBodyBean);
		
		if("01".equalsIgnoreCase(assetType))
			return getContentListing(httpServletRequest, accessMapping,requestBodyBean);
		
		if("02".equalsIgnoreCase(assetType))
			return getDocumentListing(httpServletRequest, accessMapping,requestBodyBean);
		
		if("03".equalsIgnoreCase(assetType))
			return getMixedContent(httpServletRequest, accessMapping,requestBodyBean);
		
		return null;

	}
	
	@Override
	public JSONArray provisionUser(HttpServletRequest httpServletRequest, UserProvisionBean userProvisionBean) throws PortalException {
		
		RestBuilderUtil.validateUserProvisionInputs(userProvisionBean); 
	
		return userHandler.createOrUpdateUser(httpServletRequest,userProvisionBean);
	}
	
	@Override
	public List<Item> getAssetLibraries(HttpServletRequest httpServletRequest) throws PortalException {
	
		_log.info("Listing of Asset Libraries displayed !!");
		
		List<Group> assetLibraries = assetLibraryHandler.getAssetLibraries(httpServletRequest);
		
		List<Item> items = new ArrayList<>();
		assetLibraries.forEach(assetLibrary -> {
			items.add(new Item(assetLibrary.getGroupKey(), assetLibrary.getGroupId()));
		});
		
		return items;
	}	

	@Override
	public List<Item> getPublicationRoles(HttpServletRequest httpServletRequest) throws PortalException {
	
		_log.info("Listing of Publication roles displayed !!");
		
		List<Role> publicationRoles = roleHandler.getAssetLibraryRoles(httpServletRequest);
		
		List<Item> items = new ArrayList<>();
		publicationRoles.forEach(publicationRole -> {
			items.add(new Item(publicationRole.getName(), publicationRole.getRoleId()));
		});
		
		return items;
	}	
	
	@Override
	public List<Item> getSiteRoles(HttpServletRequest httpServletRequest) throws PortalException {
	
		_log.info("Listing of Site roles displayed !!");
		
		List<Role> siteRoles = roleHandler.getSiteRoles(httpServletRequest);
		
		List<Item> items = new ArrayList<>();
		siteRoles.forEach(siteRole -> {
			items.add(new Item(siteRole.getName(), siteRole.getRoleId()));
		});
		
		return items;
	}	
	
	@Override
	public List<Item> getSites(HttpServletRequest httpServletRequest) throws PortalException {
	
		_log.info("Listing of all Sites displayed !!");
	
		List<Group> sites = groupHandler.getSites();
		
		List<Item> items = new ArrayList<>();
		sites.forEach(site -> {
			items.add(new Item(site.getGroupKey().replace("LFR_ORGANIZATION", StringPool.BLANK), site.getGroupId()));
		});
		
		return items;
	}	
	
	@Override
	public String terminateUser(HttpServletRequest httpServletRequest) throws PortalException {
		
		JSONObject requestJson = CommonUtil.getJsonFromRequestBody(httpServletRequest);
		
		String emailAddress = requestJson.getString(RestBuilderConstant.EMAIL_PARAM_KEY.getValue());
		
		if(Validator.isNull(emailAddress))
			throw new PortalException("Email Address is mandatory");
		
		_log.info("Email Id :: " + emailAddress);
		
		return userHandler.terminateUser(httpServletRequest, emailAddress);
	}	
	
	/**
	 * 
	 * 
	 * @param httpServletRequest
	 * @param accessMapping
	 * @param requestBodyBean
	 * @return
	 * @throws PortalException
	 */
	private JSONArray getContentListing(HttpServletRequest httpServletRequest,PubAccessMappingRef accessMapping,RequestBodyBean requestBodyBean) throws PortalException {
		
		return journalArticleHandler.fetchDetailedJournalArticles(httpServletRequest,accessMapping);

	}
	
	/**
	 * 
	 * @param httpServletRequest
	 * @param accessMapping
	 * @param requestBodyBean
	 * @return
	 * @throws PortalException
	 */
	private JSONArray getDocumentListing(HttpServletRequest httpServletRequest,PubAccessMappingRef accessMapping,RequestBodyBean requestBodyBean) throws PortalException{
		
		return dlFileEntryHandler.fetchDetailedDocuments(httpServletRequest, accessMapping);
		
	}
	
	/**
	 * 
	 * @param httpServletRequest
	 * @param accessMapping
	 * @param requestBodyBean
	 * @return
	 * @throws PortalException
	 */
	private JSONArray getMixedContent(HttpServletRequest httpServletRequest,PubAccessMappingRef accessMapping,RequestBodyBean requestBodyBean) throws PortalException {
		
		JSONArray contentArray = journalArticleHandler.fetchDetailedJournalArticles(httpServletRequest,accessMapping);
		
		JSONArray jsonArray = dlFileEntryHandler.fetchDetailedDocuments(httpServletRequest, accessMapping);
		
		for(int i=0;i<contentArray.length();i++) {
			jsonArray.put(contentArray.getJSONObject(i));
		}
		
		return jsonArray;
	}
	
	private static final Log _log = LogFactoryUtil.getLog(RestBuilderImpl.class);
	
	
	@Reference
	private OAuth2TokenWebService oAuth2TokenWebService;
	
	@Reference
	private UserHandler userHandler;
	
	@Reference
	private GroupHandler groupHandler ;
	
	@Reference
	private LayoutHandler layoutHandler;
	
	@Reference
	private ResourcePermissionChecker permissionChecker;
	
	@Reference
	private FileEntryHandler fileEntryHandler;
	
	@Reference
	private DlFileEntryHandler dlFileEntryHandler;
	
	@Reference
	private DlFolderHandler dlFolderHandler;
	
	@Reference
	private JournalArticleHandler journalArticleHandler;
	
	@Reference
	private DocMigrationRefHandler docMigrationRefHandler ;
	
	@Reference
	private ContentMigrationRefHandler contentMigrationRefHandler;
	
	@Reference
	private PubAccessMappingRefHandler pubAccessMappingRefHandler;
	
	@Reference
	private AssetLibraryHandler assetLibraryHandler;

	@Reference
	private RoleHandler roleHandler;

}
