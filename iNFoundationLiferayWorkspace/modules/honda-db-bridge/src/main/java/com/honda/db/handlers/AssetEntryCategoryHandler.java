package com.honda.db.handlers;

import com.liferay.asset.entry.rel.service.AssetEntryAssetCategoryRelLocalService;
import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.model.AssetVocabulary;
import com.liferay.asset.kernel.service.AssetCategoryLocalService;
import com.liferay.asset.kernel.service.AssetEntryLocalService;
import com.liferay.asset.kernel.service.AssetVocabularyLocalService;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.Validator;

import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * 
 * Class to handle asset category related operation like adding category, fetching category etc 
 * 
 * @author Lokesh Sharma
 *
 */
@Component(
	immediate = true,
	service = AssetEntryCategoryHandler.class
)
public class AssetEntryCategoryHandler {
	
	/**
	 * 
	 * Method to fetch asset vocabulary by name
	 * 
	 * @param vocabularyName
	 * @return
	 * @throws PortalException 
	 */
	public AssetVocabulary getAssetVocabulary(ServiceContext serviceContext,String vocabularyName,boolean createIfNotFound) throws PortalException {
		
		Group hondaGlobalGrp = groupHandler.getLiferayGlobalGrp();
		
		AssetVocabulary assetVocabulary = assetVocabularyLocalService.fetchGroupVocabulary(hondaGlobalGrp.getGroupId(), vocabularyName);
		
		if(Validator.isNull(assetVocabulary) && createIfNotFound)
			assetVocabulary = addAssetVocabulary(serviceContext, vocabularyName);
		
		return assetVocabulary;
	}
	
	/**
	 * 
	 * This method create asset vocabulary on Liferay global scope
	 * 
	 * @param serviceContext
	 * @param vocabularyName
	 * @return
	 * @throws PortalException
	 */
	public AssetVocabulary addAssetVocabulary(ServiceContext serviceContext, String vocabularyName) throws PortalException {
		
		Group lRGlobalGrp = groupHandler.getLiferayGlobalGrp();
		
		return assetVocabularyLocalService.addVocabulary(serviceContext.getUserId(),lRGlobalGrp.getGroupId() , vocabularyName, serviceContext);
		
	}
	
	/**
	 * 
	 * Method to fetch asset category by its name.
	 * 
	 * @param vocabularyName
	 * @param categoryName
	 * @return
	 * @throws PortalException 
	 */
	public AssetCategory getAssetCategory(ServiceContext serviceContext,String vocabularyName, String categoryName,boolean createIfNotFound) throws PortalException {
		
		AssetVocabulary assetVocabulary = getAssetVocabulary(serviceContext,vocabularyName,createIfNotFound);
		
		AssetCategory assetCategory = assetCategoryLocalService.fetchCategory(assetVocabulary.getGroupId(), 0, categoryName, assetVocabulary.getVocabularyId());
		
		if(Validator.isNull(assetCategory) && createIfNotFound)
			assetCategory = addAssetCategory(serviceContext, assetVocabulary, categoryName);
			
		return assetCategory;
		
	}
	
	/**
	 * 
	 * This method create asset category on Liferay global scope
	 * 
	 * @param serviceContext
	 * @param assetVocabulary
	 * @param categoryName
	 * @return
	 * @throws PortalException
	 */
	public AssetCategory addAssetCategory(ServiceContext serviceContext, AssetVocabulary assetVocabulary,String categoryName) throws PortalException {
		
		return assetCategoryLocalService.addCategory(assetVocabulary.getUserId(), assetVocabulary.getGroupId(),
				categoryName, assetVocabulary.getVocabularyId(), serviceContext);
	}

	/**
	 * 
	 * Method to fetch asset category under Division category.
	 * 
	 * @param categoryName
	 * @return
	 * @throws PortalException 
	 */
	public AssetCategory getDivisionAssetCategory(ServiceContext serviceContext,String categoryName,boolean createIfNotFound) throws PortalException {
		
		AssetVocabulary assetVocabulary = getAssetVocabulary(serviceContext,"Division",createIfNotFound);
		
		return assetCategoryLocalService.fetchCategory(assetVocabulary.getGroupId(), 0, categoryName, assetVocabulary.getVocabularyId());
	}
	
	/**
	 * 
	 * Method to fetch asset category under Departments category.
	 * 
	 * @param categoryName
	 * @return
	 * @throws PortalException 
	 */
	public AssetCategory getDepartmentAssetCategory(ServiceContext serviceContext,String categoryName,boolean createIfNotFound) throws PortalException {
		
		AssetVocabulary assetVocabulary = getAssetVocabulary(serviceContext,"Departments",createIfNotFound);
		
		return assetCategoryLocalService.fetchCategory(assetVocabulary.getGroupId(), 0, categoryName, assetVocabulary.getVocabularyId());
	}
	
	/**
	 * 
	 *  Method to fetch asset category under Document Types category.
	 * 
	 * @param categoryName
	 * @return
	 * @throws PortalException 
	 */
	public AssetCategory getDocumentTypeAssetCat(ServiceContext serviceContext,String categoryName,boolean createIfNotFound) throws PortalException {
		
		AssetVocabulary assetVocabulary = getAssetVocabulary(serviceContext,"Document Types",createIfNotFound);
		
		return assetCategoryLocalService.fetchCategory(assetVocabulary.getGroupId(), 0, categoryName, assetVocabulary.getVocabularyId());
	}
	
	/**
	 * 
	 * @return
	 * @throws PortalException 
	 */
	public List<AssetCategory> getDocumentTypeAssetCatgories(ServiceContext serviceContext,boolean createIfNotFound) throws PortalException {
		
		AssetVocabulary assetVocabulary = getAssetVocabulary(serviceContext,"Document Types",createIfNotFound);
		
		return assetCategoryLocalService.getVocabularyCategories(assetVocabulary.getVocabularyId(), QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}
	
	/**
	 * 
	 * This method is to assign required category on the proided entity Like document, web content etc
	 * 
	 * @param vocabularyName
	 * @param categoryName
	 * @param entityClassName
	 * @param resourcePriKey
	 * @throws PortalException 
	 */
	public void addAssetCategory(ServiceContext serviceContext, String vocabularyName, String categoryName,
			String entityClassName, long resourcePriKey) throws PortalException {
		
		AssetCategory assetCategory = getAssetCategory(serviceContext,vocabularyName, categoryName,Boolean.FALSE);
		
		AssetEntry assetEntry = assetEntryLocalService.fetchEntry(entityClassName, resourcePriKey);
		
		assetCategoryLocalService.addAssetEntryAssetCategory(assetEntry.getEntryId(), assetCategory);
		
	}
	
	
	@Reference
	private AssetEntryLocalService assetEntryLocalService;
	
	@Reference
	private AssetVocabularyLocalService assetVocabularyLocalService;
	
	@Reference
	private AssetCategoryLocalService assetCategoryLocalService;
	
	@Reference
	private AssetEntryAssetCategoryRelLocalService assetEntryAssetCategoryRelLocalService;
	
	@Reference
	private GroupHandler groupHandler;
}
