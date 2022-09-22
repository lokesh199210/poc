package com.honda.db.handlers;

import com.honda.commom.utils.CommonUtil;
import com.honda.common.beans.ContentRequestBean;
import com.honda.common.beans.DocMetaDataBean;
import com.honda.common.beans.DocRequestBean;
import com.honda.external.db.sb.model.DocMigrationRef;
import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.document.library.kernel.model.DLFileEntryType;
import com.liferay.document.library.kernel.model.DLFolder;
import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.document.library.kernel.service.DLAppLocalService;
import com.liferay.document.library.kernel.service.DLAppService;
import com.liferay.dynamic.data.mapping.kernel.DDMForm;
import com.liferay.dynamic.data.mapping.kernel.DDMFormField;
import com.liferay.dynamic.data.mapping.kernel.DDMFormFieldValue;
import com.liferay.dynamic.data.mapping.kernel.DDMFormValues;
import com.liferay.dynamic.data.mapping.kernel.LocalizedValue;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.util.Validator;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.activation.MimetypesFileTypeMap;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * 
 * Class to handle operation realted to Document and media like add document,
 * fetching document and its detials.
 * 
 * @author Lokesh Sharma
 *
 */
@Component(immediate = true, service = FileEntryHandler.class)
public class FileEntryHandler {
	
	/**
	 * 
	 * @param fileEntry
	 * @return
	 * @throws PortalException 
	 */
	public FileEntry getFileEntry(long fileEntry) throws PortalException {
		return dLAppLocalService.getFileEntry(fileEntry);
	}

	/**
	 * 
	 * This method is to updload document with its provided metadata in Liferay DMS
	 * using Doc_Migration_Ref table to get folder and other details
	 * 
	 * @param request
	 * @param docRequestBean
	 * @return
	 * @throws PortalException
	 */
	public FileEntry uploadDocument(HttpServletRequest request, DocRequestBean docRequestBean,
			DocMigrationRef docMigrationRef) throws PortalException {

		ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFolder.class.getName(), request);

		Group group = groupHandler.getByDivision(docMigrationRef.getContent_type());

		serviceContext.setScopeGroupId(group.getGroupId());

		DLFolder parentFolder = null;

		if (CommonUtil.isSingleLibrary(docMigrationRef.getContent_type())) {
			parentFolder = dlFolderHandler.getDLFolder(serviceContext, docMigrationRef.getLiferay_folder(),
					DLFolderConstants.DEFAULT_PARENT_FOLDER_ID, Boolean.TRUE).get();
		}

		parentFolder = dlFolderHandler.getDLFolder(serviceContext, CommonUtil.getDivsionNameByCode(docMigrationRef.getDivision()),
						Validator.isNotNull(parentFolder) ? parentFolder.getFolderId(): DLFolderConstants.DEFAULT_PARENT_FOLDER_ID,
						Boolean.TRUE).get();

		DLFileEntryType dlFileEntryType = dLFileEntryTypeHandler.getDLFileEntryType(group.getGroupId(),
				docRequestBean.getContentType());

		dlFolderHandler.applyDocumentType(dlFileEntryType, parentFolder);

		serviceContext.setAttribute("fileEntryTypeId", dlFileEntryType.getFileEntryTypeId());

		constructDDMFormValues(dlFileEntryType, docRequestBean.getDocMetaDataBean(), serviceContext);

		addCategoryDetails(serviceContext, docRequestBean);

		return dlAppService.addFileEntry(serviceContext.getScopeGroupId(), parentFolder.getFolderId(),
				docRequestBean.getFileName(), new MimetypesFileTypeMap().getContentType(docRequestBean.getFile()),
				docRequestBean.getTitle(), docRequestBean.getDescription(), null, docRequestBean.getFile(),
				serviceContext);

	}

	/**
	 * 
	 * This method is to populate metadata value to Document type to be applied to
	 * the document being uploaded
	 * 
	 * @param serviceContext
	 * @param dlFileEntryType
	 * @param docMetaDataBean
	 * @return
	 */
	private void constructDDMFormValues(DLFileEntryType dlFileEntryType, DocMetaDataBean docMetaDataBean,
			ServiceContext serviceContext) {

		dlFileEntryType.getDDMStructures().forEach(structure -> {

			DDMForm ddmForm = structure.getDDMForm();
			DDMFormValues ddmFormValues = new DDMFormValues(ddmForm);
			ddmFormValues.setAvailableLocales(ddmForm.getAvailableLocales());
			ddmFormValues.setDefaultLocale(ddmForm.getDefaultLocale());

			List<DDMFormFieldValue> ddmFormFieldValues = new ArrayList<>();

			ddmForm.getDDMFormFields().forEach(ddmFormField -> {
				
				String val = null;
				
				//ddmFormField.setProperty("required", "false");
				
			
					val = Validator.isNotNull(docMetaDataBean) ? docMetaDataBean.getValueByName(ddmFormField.getName())
							: "N/A";	
				
				ddmFormField.getNestedDDMFormFields().forEach(nestedFormField -> {
					String value = docMetaDataBean.getValueByName(nestedFormField.getName());

					/*------------------ Constructing Array in case of drop downs------------------- */
					value = constructSelectTypeVal(value, nestedFormField, docMetaDataBean);

					DDMFormFieldValue ddmFormFieldValue = constructDDMFormValue(nestedFormField, value);
					ddmFormFieldValues.add(ddmFormFieldValue);

				});
					
				/*------------------ Constructing Array in case of drop downs------------------- */
				
				
				val = constructSelectTypeVal(val, ddmFormField, docMetaDataBean);

				DDMFormFieldValue ddmFormFieldValue = constructDDMFormValue(ddmFormField, val);
				ddmFormFieldValues.add(ddmFormFieldValue);
			});
			
			ddmFormValues.setDDMFormFieldValues(ddmFormFieldValues);

			serviceContext.setAttribute(DDMFormValues.class.getName() + StringPool.POUND + structure.getStructureId(),
					ddmFormValues);
		});

	}
	
	/**
	 * 
	 * 
	 * 
	 * @param formField
	 * @param docMetaDataBean
	 * @return
	 */
	private String constructSelectTypeVal(String value,DDMFormField formField,DocMetaDataBean docMetaDataBean) {
		
		if(formField.getProperty("type").equals("select")) {
			formField.setProperty("required", "false");
			value = CommonUtil.convertStringsToArrayList(docMetaDataBean.getValueByName(formField.getName()));
		}else {
			value = Validator.isNotNull(docMetaDataBean) ? docMetaDataBean.getValueByName(formField.getName())
					: "N/A";
		}
		return value;
	}

	/**
	 * 
	 * @param nestedData
	 * @param value
	 * @return
	 */
	private DDMFormFieldValue constructDDMFormValue(DDMFormField nestedData, String value) {
		
		LocalizedValue localizedValue = new LocalizedValue();
		DDMFormFieldValue ddmFormFieldValue = new DDMFormFieldValue();

		ddmFormFieldValue.setName(nestedData.getName());
		localizedValue.addString(Locale.US, "");
		ddmFormFieldValue.setValue(localizedValue);
		localizedValue.addString(Locale.US, value);
		ddmFormFieldValue.setValue(localizedValue);
		return ddmFormFieldValue;
	}

	/**
	 * 
	 * This method is to set categories required into service context which can then
	 * be applied by Liferay.
	 * 
	 * @param serviceContext
	 * @param docRequestBean
	 * @throws PortalException 
	 */
	private void addCategoryDetails(ServiceContext serviceContext, DocRequestBean docRequestBean)
			throws PortalException {

		List<Long> assetCategoryIdList = new ArrayList<Long>();

		AssetCategory assetCategory = null;

		if (Validator.isNotNull(docRequestBean.getDivision())) {
			_log.info("Divsion ->" + docRequestBean.getDivision());
			assetCategory = assetEntryCategoryHandler.getDivisionAssetCategory(serviceContext,docRequestBean.getDivision(),Boolean.TRUE);
			if (Validator.isNotNull(assetCategory))
				assetCategoryIdList.add(assetCategory.getCategoryId());
		}

		if (Validator.isNotNull(docRequestBean.getDepartment())) {
			_log.info("Department ->" + docRequestBean.getDepartment());
			assetCategory = assetEntryCategoryHandler.getDepartmentAssetCategory(serviceContext,docRequestBean.getDepartment(),Boolean.TRUE);
			if (Validator.isNotNull(assetCategory))
				assetCategoryIdList.add(assetCategory.getCategoryId());
		}
		
		if (Validator.isNotNull(docRequestBean.getContentType())) {
			_log.info("Content type ->" + docRequestBean.getContentType());
			assetCategory = assetEntryCategoryHandler.getDocumentTypeAssetCat(serviceContext,docRequestBean.getContentType(),Boolean.TRUE);
			if (Validator.isNotNull(assetCategory))
				assetCategoryIdList.add(assetCategory.getCategoryId());
		}

		long[] assetCategoryIds = new long[assetCategoryIdList.size()];
		assetCategoryIds = assetCategoryIdList.stream().mapToLong(l -> l).toArray();

		serviceContext.setAssetCategoryIds(assetCategoryIds);
	}

	/**
	 * 
	 * @param httpServletRequest
	 * @param contentRequestBean
	 * @return
	 * @throws PortalException
	 */
	public FileEntry uploadContentImage(HttpServletRequest httpServletRequest, ContentRequestBean contentRequestBean)
			throws PortalException {

		ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFolder.class.getName(), httpServletRequest);

		Group group = groupHandler.getByDivision(contentRequestBean.getDivision());

		serviceContext.setScopeGroupId(group.getGroupId());

		DLFolder parentFolder = dlFolderHandler.getDLFolder(serviceContext, contentRequestBean.getFolderName(),
				DLFolderConstants.DEFAULT_PARENT_FOLDER_ID, Boolean.TRUE).get();

		return dlAppService.addFileEntry(serviceContext.getScopeGroupId(), parentFolder.getFolderId(),
				contentRequestBean.getFileName(),
				new MimetypesFileTypeMap().getContentType(contentRequestBean.getFile()), contentRequestBean.getTitle(),
				contentRequestBean.getDescription(), null, contentRequestBean.getFile(), serviceContext);

	}

	@Reference
	private DLAppService dlAppService;

	@Reference
	private DLFileEntryTypeHandler dLFileEntryTypeHandler;
	
	@Reference
	private DLAppLocalService dLAppLocalService;

	@Reference(unbind = "-")
	private DlFolderHandler dlFolderHandler;

	@Reference
	private GroupHandler groupHandler;

	@Reference
	private AssetEntryCategoryHandler assetEntryCategoryHandler;

	private static final Log _log = LogFactoryUtil.getLog(FileEntryHandler.class);

}
