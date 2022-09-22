package com.honda.db.handlers;

import com.honda.commom.utils.CommonUtil;
import com.honda.external.db.sb.model.PubAccessMappingRef;
import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.model.DLFileEntryType;
import com.liferay.document.library.kernel.model.DLFileVersion;
import com.liferay.document.library.kernel.model.DLFolder;
import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.document.library.kernel.service.DLFileEntryLocalService;
import com.liferay.document.library.kernel.service.DLFileVersionService;
import com.liferay.dynamic.data.mapping.kernel.DDMFormFieldValue;
import com.liferay.dynamic.data.mapping.kernel.DDMFormValues;
import com.liferay.journal.model.JournalArticle;
import com.liferay.petra.string.StringBundler;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.URLCodec;
import com.liferay.portal.kernel.util.Validator;

import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * 
 * This class io to handler operation on Document and media like adding, fetching documents.
 * 
 * @author Lokesh Sharma
 *
 */
@Component(
	immediate = true,
	service = DlFileEntryHandler.class
)
public class DlFileEntryHandler {
	
	/**
	 * 
	 * To fetch details of the document based on primary key
	 * 
	 * @param fileEntryId
	 * @return
	 * @throws PortalException
	 */
	public DLFileEntry getDlFileEntry(long fileEntryId) throws PortalException {
		
		DLFileEntry dlFileEntry = dlFileEntryLocalService.getDLFileEntry(fileEntryId);
		
		return dlFileEntry;
		
	}
	
	/**
	 * 
	 * Method used to fetch document details based on requested parameter ,uses Doc_Migration_Ref table to get folder and other details
	 * 
	 * @param request
	 * @param docMigrationRef
	 * @return
	 * @throws PortalException
	 */
	public JSONArray fetchDetailedDocuments(HttpServletRequest request,PubAccessMappingRef accessMapping) throws PortalException {
		
		ServiceContext serviceContext = ServiceContextFactory.getInstance(JournalArticle.class.getName(),request);
		
		Group group = groupHandler.getByDivision(accessMapping.getPublication_name());
		
		serviceContext.setScopeGroupId(group.getGroupId());
		
		DLFolder parentFolder = null;
		
		if(CommonUtil.isSingleLibrary(accessMapping.getPublication_name())) {
			parentFolder = dlFolderHandler.getDLFolder(serviceContext, accessMapping.getLiferay_folder(),
					DLFolderConstants.DEFAULT_PARENT_FOLDER_ID, Boolean.FALSE).get();
			
			if(Validator.isNull(parentFolder))
				throw new PortalException("No folder found for requested AHMC app code");
			
		}
		
		parentFolder = dlFolderHandler.getDLFolder(serviceContext, CommonUtil.getDivsionNameByCode(accessMapping.getDivision()),
				Validator.isNotNull(parentFolder)?parentFolder.getFolderId():DLFolderConstants.DEFAULT_PARENT_FOLDER_ID,Boolean.FALSE).get();
		
		if(Validator.isNull(parentFolder))
			throw new PortalException("No folder found for requested AHMC app code");
		
		List<DLFileEntry> dlFileEntries = dlFileEntryLocalService.getFileEntries(serviceContext.getScopeGroupId(), parentFolder.getFolderId());
		
		if(Validator.isNull(dlFileEntries) || dlFileEntries.isEmpty())
			throw new PortalException("No documents found for requested AHMC app code");

		JSONArray array = JSONFactoryUtil.createJSONArray();
		
		dlFileEntries.forEach( dlFileEntry -> {

			getMetaDataInfo(request, array, dlFileEntry);
		});
		
		return array;
		
	}

	/**
	 * 
	 * Method to construct the document URL which can be used to access the document
	 * 
	 * @param httpServletRequest
	 * @param dlFileVersion
	 * @return
	 * @throws PortalException
	 */
	public String constructDocumentURL(HttpServletRequest httpServletRequest,DLFileEntry dlFileEntry) throws PortalException {

		StringBundler sb = new StringBundler(15);

		sb.append(PortalUtil.getPathContext());
		sb.append(httpServletRequest.getScheme() + "://" + // "http" + "://
				httpServletRequest.getServerName() + // "myhost"
				":" + // ":"
				httpServletRequest.getServerPort());
		sb.append("/documents/");
		sb.append(dlFileEntry.getRepositoryId());
		sb.append(StringPool.SLASH);
		sb.append(dlFileEntry.getFolderId());
		sb.append(StringPool.SLASH);

		String fileName = dlFileEntry.getFileName();

		sb.append(URLCodec.encodeURL(HtmlUtil.unescape(fileName)));

		sb.append(StringPool.SLASH);
		sb.append(URLCodec.encodeURL(dlFileEntry.getUuid()));

		sb.append("?version=");
		sb.append(dlFileEntry.getVersion());
		sb.append("&t=");

		Date modifiedDate = dlFileEntry.getModifiedDate();

		sb.append(modifiedDate.getTime());

		_log.info("previewURL---------------------------> " + sb.toString());
		
		return sb.toString();

	}
	
	/**
	 * 
	 * @param request
	 * @param array
	 * @param dlFileEntry
	 */
	private void getMetaDataInfo(HttpServletRequest request, JSONArray array, DLFileEntry dlFileEntry) {
		try {
			JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
			DLFileVersion dlFileVersion = dLFileVersionService.getLatestFileVersion(dlFileEntry.getFileEntryId());

			try {
				Map<String, DDMFormValues> ddmFormValuesMap = dlFileEntry
						.getDDMFormValuesMap(dlFileVersion.getFileVersionId());
				DLFileEntryType dlFileEntryType = dlFileVersion.getDLFileEntryType();

				dlFileEntryType.getDDMStructures().forEach(structure -> {
					DDMFormValues ddmFormValues = ddmFormValuesMap.get(structure.getStructureKey());

					List<DDMFormFieldValue> ddmFormFieldValues = ddmFormValues.getDDMFormFieldValues();
					for (DDMFormFieldValue curField : ddmFormFieldValues) {

						jsonObject.put(curField.getName(), curField.getValue().getString(Locale.US));
						
						

					}
				});

			} catch (Exception e) {
				_log.info("Not metadata set found..");
			}
			jsonObject.put("title", dlFileVersion.getTitle());
			jsonObject.put("description", dlFileVersion.getDescription());
			jsonObject.put("url", constructDocumentURL(request, dlFileEntry));

			jsonObject.put("assetType", "document");
			array.put(jsonObject);
		} catch (Exception e) {
			_log.error(e, e);
		}
	}

	@Reference(unbind="-")
	private DlFolderHandler dlFolderHandler;
	
	@Reference(unbind = "-")
	private DLFileEntryLocalService dlFileEntryLocalService;
	
	@Reference
	private DLFileVersionService dLFileVersionService ;
	
	@Reference
	private GroupHandler groupHandler;
	
	
	private static final Log _log = LogFactoryUtil.getLog(DlFileEntryHandler.class);
}
