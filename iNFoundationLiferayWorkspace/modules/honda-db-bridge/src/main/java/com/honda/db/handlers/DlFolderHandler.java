package com.honda.db.handlers;

import com.liferay.document.library.kernel.model.DLFileEntryType;
import com.liferay.document.library.kernel.model.DLFolder;
import com.liferay.document.library.kernel.service.DLAppLocalService;
import com.liferay.document.library.kernel.service.DLFolderLocalService;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.service.ServiceContext;

import java.util.function.Supplier;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * 
 * @author Lokesh Sharma
 *
 */
@Component(
	immediate = true,
	service = DlFolderHandler.class
)
public class DlFolderHandler {

	/**
	 * This method is to get folder by name and parent folder 
	 * 
	 * @param groupId
	 * @param folderName
	 * @param parentFolderId
	 * @return
	 */
	public Supplier<Folder> getFolder(ServiceContext serviceContext, String folderName, long parentFolderId,boolean createIfNotFound) {
		
		return () -> {
			try {
				return dlAppLocalService.getFolder(serviceContext.getScopeGroupId(), parentFolderId, folderName.replace('/', '_'));
			} catch (Exception e) {
				_log.info("No folder found with name "+folderName);
				
				if(createIfNotFound)
					return createFolder(serviceContext, folderName, parentFolderId).get();
				if(_log.isDebugEnabled()){
					_log.error(e, e);
				}
			}
			return null;
		};
		
	}
	
	
	/**
	 * Method to get DLFolder Object
	 * @param groupId
	 * @param folderName
	 * @param parentFolderId
	 * @return
	 */
	public Supplier<DLFolder> getDLFolder(ServiceContext serviceContext, String folderName, long parentFolderId,boolean createIfNotFound) {
		
		return () -> {
			try {
				return dlFolderLocalService.getFolder(serviceContext.getScopeGroupId(), parentFolderId, folderName.replace('/', '_'));
			} catch (Exception e) {
				_log.info("No folder found with name "+folderName);
				
				if(createIfNotFound)
					return createDLFolder(serviceContext, folderName, parentFolderId).get();
				if(_log.isDebugEnabled()){
					_log.error(e, e);
				}
			}
			return null;
		};
		
	}
	
	/**
	 * This folder is to create folder with specified name and parent folder id
	 * @param portletRequest
	 * @param themeDisplay
	 * @param folderName
	 * @param parentFolderId
	 * @return
	 */
	public Supplier<Folder> createFolder(ServiceContext serviceContext,String folderName,long parentFolderId) {
		return () -> {
			try {
				/*
				 * Creating folder if it does't exits
				 */					
				return dlAppLocalService.addFolder(serviceContext.getUserId(), serviceContext.getScopeGroupId(), parentFolderId,
						folderName.replace('/', '_'), "", serviceContext);
			} catch (Exception e) {
				_log.error(e, e);
			}
			return null;
		};
		
	}
	
	/**
	 * This folder is to create folder with specified name and parent folder id
	 * @param portletRequest
	 * @param themeDisplay
	 * @param folderName
	 * @param parentFolderId
	 * @return
	 */
	public Supplier<DLFolder> createDLFolder(ServiceContext serviceContext,String folderName,long parentFolderId) {
		return () -> {
			try {
				/*
				 * Creating folder if it does't exits
				 */					
				return dlFolderLocalService.addFolder(serviceContext.getUserId(), serviceContext.getScopeGroupId(), serviceContext.getScopeGroupId(), Boolean.FALSE,
						parentFolderId, folderName.replace('/', '_'), "", Boolean.FALSE, serviceContext);
						
			} catch (Exception e) {
				_log.error(e, e);
			}
			return null;
		};
	}
	
	/**
	 * 
	 * @param documentType
	 * @param dlFolder
	 */
	public DLFolder applyDocumentType(String documentType,DLFolder dlFolder) {
		
		DLFileEntryType dlFileEntryType = dlFileEntryTypeHandler.getDLFileEntryType(dlFolder.getGroupId(), documentType);
		
		dlFolderLocalService.addDLFileEntryTypeDLFolder(dlFileEntryType.getFileEntryTypeId(), dlFolder);
		
		dlFolder.setRestrictionType(1);
		
		return dlFolderLocalService.updateDLFolder(dlFolder);
	}
	
	/**
	 * 
	 * @param documentType
	 * @param dlFolder
	 */
	public DLFolder applyDocumentType(DLFileEntryType dlFileEntryType,DLFolder dlFolder) {
		
		dlFolderLocalService.addDLFileEntryTypeDLFolder(dlFileEntryType.getFileEntryTypeId(), dlFolder);
		
		dlFolder.setRestrictionType(1);
		
		return dlFolderLocalService.updateDLFolder(dlFolder);
	}
	
	@Reference(unbind="-")
	private DLAppLocalService dlAppLocalService;
	
	@Reference(unbind="-")
	private DLFolderLocalService dlFolderLocalService;
	
	@Reference
	private DLFileEntryTypeHandler dlFileEntryTypeHandler;
	
	private static final Log  _log = LogFactoryUtil.getLog(DlFolderHandler.class);
	
}
