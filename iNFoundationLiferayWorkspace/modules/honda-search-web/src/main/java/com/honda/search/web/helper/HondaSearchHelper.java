package com.honda.search.web.helper;

import com.honda.db.handlers.AssetEntryCategoryHandler;
import com.honda.db.handlers.DDMStructureHandler;
import com.honda.db.handlers.DlFileEntryHandler;
import com.honda.db.handlers.DlFolderHandler;
import com.honda.db.handlers.GroupHandler;
import com.honda.search.api.SearchAPI;
import com.honda.search.query.api.SearchQueryAPI;
import com.honda.search.web.beans.HondaSearchResultBean;
import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.journal.model.JournalArticle;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.ParseException;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
	immediate = true,
	service = HondaSearchHelper.class
)
public class HondaSearchHelper {

	/**
	 * 
	 * 
	 * @param portletRequest
	 * @param themeDisplay
	 * @param searchContainer
	 * @throws PortalException
	 */
	public void search(PortletRequest portletRequest,SearchContainer<HondaSearchResultBean> searchContainer) throws PortalException {
		
		Group assetLibraryGroup = groupHandler.getById(getConfiguredAssetLibraryId(portletRequest));
		
		ServiceContext serviceContext = ServiceContextFactory.getInstance(portletRequest);
		
		Group currentGroup = serviceContext.getScopeGroup();
		
		serviceContext.setScopeGroupId(assetLibraryGroup.getGroupId());
		
		BooleanQuery booleanQuery = searchQueryAPI.createQuery(assetLibraryGroup.getGroupId(), serviceContext.getCompanyId(),DLFileEntry.class.getName());
		
		getCategoryList(serviceContext, assetLibraryGroup, currentGroup).forEach(category ->{
			try {
				searchQueryAPI.createCategoryQuery(booleanQuery, category);
			} catch (ParseException e) {
				_log.info("Unable to put category query..");
			}
		});
		
		String mtaKeyword = GetterUtil.getString(PortalUtil
				.getOriginalServletRequest(PortalUtil.getHttpServletRequest(portletRequest)).getParameter("mta"));
		
		System.out.println("query----------------------------->" + mtaKeyword);
		
		if(Validator.isNotNull(mtaKeyword))
			searchQueryAPI.createMetadataQuery(booleanQuery, mtaKeyword, DLFileEntry.class.getName());
		
		String query = GetterUtil.getString(PortalUtil
				.getOriginalServletRequest(PortalUtil.getHttpServletRequest(portletRequest)).getParameter("q"));
		
		System.out.println("query----------------------------->" + query);
		
		if(Validator.isNotNull(query))
			searchQueryAPI.createKeywordQuery(booleanQuery, query, DLFileEntry.class.getName());
		
		Hits hits = searchAPI.search(booleanQuery, serviceContext.getCompanyId(), searchContainer.getStart(), searchContainer.getEnd());
		
		long count = searchAPI.searchCount(booleanQuery, serviceContext.getCompanyId());
		searchContainer.setResults(processDocument(portletRequest, hits));
		searchContainer.setTotal((int)count);
		
		
	}
	
	/**
	 * 
	 * @param portletRequest
	 * @param hits
	 * @return
	 */
	private List<HondaSearchResultBean> processDocument(PortletRequest portletRequest,Hits hits){
		
		List<HondaSearchResultBean> searchResultBeansList = new ArrayList<>();
		
		for(Document doc : hits.getDocs()) {
			
			try {
				
				if(doc.get(Field.ENTRY_CLASS_NAME).equalsIgnoreCase(JournalArticle.class.getName())) {
					
				}else if(doc.get(Field.ENTRY_CLASS_NAME).equalsIgnoreCase(DLFileEntry.class.getName())) {
					
					DLFileEntry dlFileEntry = dlFileEntryHandler.getDlFileEntry(GetterUtil.getLong(doc.get(Field.ENTRY_CLASS_PK)));
					
					searchResultBeansList.add(new HondaSearchResultBean(dlFileEntry.getTitle().replaceAll("\\.[^.]*$", ""),
							dlFileEntry.getDescription(), dlFileEntryHandler.constructDocumentURL(
							PortalUtil.getHttpServletRequest(portletRequest), dlFileEntry)));
					
				}
			}catch (Exception e) {
				_log.error(e, e);
			}
			
		}
		
		return searchResultBeansList;
		
	}
	
	/**
	 * 
	 * @param portletRequest
	 * @return
	 */
	private long getConfiguredAssetLibraryId(PortletRequest portletRequest) {
		
		return Long.valueOf(portletRequest.getPreferences().getValue("configuredAssetLibraryId", StringPool.BLANK));
	}
	
	/**
	 * 
	 * @param themeDisplay
	 * @param assetLibraryGroup
	 * @param currentGroup
	 * @return
	 * @throws PortalException 
	 */
	private List<String> getCategoryList(ServiceContext serviceContext,Group assetLibraryGroup,Group currentGroup) throws PortalException{
		
		List<String> catergoryList = new ArrayList<>();
		
		AssetCategory documentTypeCat = assetEntryCategoryHandler.getDocumentTypeAssetCat(serviceContext,
				assetLibraryGroup.getName(serviceContext.getLocale()), Boolean.FALSE);
		if(Validator.isNotNull(documentTypeCat))
			catergoryList.add(String.valueOf(documentTypeCat.getCategoryId()));
		
		/*
		 * AssetCategory divisionCat =
		 * assetEntryCategoryHandler.getDivisionAssetCategory(serviceContext,
		 * currentGroup.getName(serviceContext.getLocale()).replace("Honda",
		 * StringPool.BLANK).trim(), Boolean.FALSE);
		 * if(Validator.isNotNull(divisionCat))
		 * catergoryList.add(String.valueOf(divisionCat.getCategoryId()));
		 */
		
		return catergoryList;
	}
	
	@Reference
	private GroupHandler groupHandler;
	
	@Reference
	private DlFolderHandler dlFolderHandler;
	
	@Reference
	private DDMStructureHandler ddmStructureHandler;
	
	@Reference
	private SearchQueryAPI searchQueryAPI;
	
	@Reference
	private AssetEntryCategoryHandler assetEntryCategoryHandler;
	
	@Reference
	private DlFileEntryHandler dlFileEntryHandler;
	
	@Reference
	private SearchAPI searchAPI;
	
	private static final Log _log = LogFactoryUtil.getLog(HondaSearchHelper.class);
}
