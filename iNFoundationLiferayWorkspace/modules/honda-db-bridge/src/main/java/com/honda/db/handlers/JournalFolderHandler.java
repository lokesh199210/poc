package com.honda.db.handlers;

import com.liferay.journal.model.JournalFolder;
import com.liferay.journal.service.JournalFolderLocalService;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.Validator;

import java.util.function.Supplier;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
	immediate = true,
	service = JournalFolderHandler.class
)
public class JournalFolderHandler {

	/**
	 * This method is to get folder by name and parent folder 
	 * 
	 * @param groupId
	 * @param folderName
	 * @param parentFolderId
	 * @return
	 */
	public Supplier<JournalFolder> getFolder(ServiceContext serviceContext, String folderName, long parentFolderId,boolean createIfNotFound) {
		
		return () -> {
			try {
				JournalFolder journalFolder = journalFolderLocalService.getFolders(serviceContext.getScopeGroupId(), parentFolderId).stream()
						.filter(folder -> folderName.equalsIgnoreCase(folder.getName())).findAny().orElse(null);
				if(Validator.isNull(journalFolder))
					throw new NullPointerException();
				
				return journalFolder;
			}catch (Exception e) {
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
	 * This folder is to create folder with specified name and parent folder id
	 * @param portletRequest
	 * @param themeDisplay
	 * @param folderName
	 * @param parentFolderId
	 * @return
	 */
	public Supplier<JournalFolder> createFolder(ServiceContext serviceContext,String folderName,long parentFolderId) {
		return () -> {
			try {
				/*
				 * Creating folder if it does't exits
				 */					
				return journalFolderLocalService.addFolder(serviceContext.getUserId(), serviceContext.getScopeGroupId(), parentFolderId,
						folderName.replace('/', '_'), "", serviceContext);
			} catch (Exception e) {
				_log.error(e, e);
			}
			return null;
		};
		
	}
	
	@Reference
	private JournalFolderLocalService journalFolderLocalService;
	
	private static final Log  _log = LogFactoryUtil.getLog(DlFolderHandler.class);
}
