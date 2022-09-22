package com.honda.db.handlers;

import com.honda.commom.utils.CommonUtil;
import com.honda.commom.utils.ObjectMapperUtil;
import com.honda.common.beans.ContentRequestBean;
import com.honda.external.db.sb.model.PubAccessMappingRef;
import com.honda.obj.mapper.beans.ContentImageBean;
import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.dynamic.data.mapping.model.DDMFormField;
import com.liferay.dynamic.data.mapping.model.DDMStructure;
import com.liferay.dynamic.data.mapping.model.LocalizedValue;
import com.liferay.dynamic.data.mapping.model.Value;
import com.liferay.dynamic.data.mapping.storage.DDMFormFieldValue;
import com.liferay.dynamic.data.mapping.storage.DDMFormValues;
import com.liferay.dynamic.data.mapping.storage.Fields;
import com.liferay.dynamic.data.mapping.util.DDMFormValuesToFieldsConverter;
import com.liferay.journal.model.JournalArticle;
import com.liferay.journal.model.JournalFolder;
import com.liferay.journal.service.JournalArticleLocalService;
import com.liferay.journal.util.JournalConverter;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.util.Validator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * 
 * Class to handle operation realted to Web content like add content, fetching
 * content and etc.
 * 
 * @author Lokesh Sharma
 *
 */
@Component(immediate = true, service = JournalArticleHandler.class)
public class JournalArticleHandler {

	/**
	 * 
	 * This method is to create web content with defined structure by fetching
	 * detail from Content_Migration_Ref database table
	 * 
	 * @param request
	 * @param contentRequestBean
	 * @return
	 * @throws PortalException
	 */
	public JournalArticle createJournalArticle(HttpServletRequest httpServletRequest,
			ContentRequestBean contentRequestBean) throws PortalException {

		ServiceContext serviceContext = ServiceContextFactory.getInstance(JournalArticle.class.getName(),
				httpServletRequest);

		Group group = groupHandler.getByDivision(contentRequestBean.getContentType());

		serviceContext.setScopeGroupId(group.getGroupId());

		JournalFolder parentFolder = journalFolderHandler.getFolder(serviceContext, contentRequestBean.getFolderName(),
				DLFolderConstants.DEFAULT_PARENT_FOLDER_ID, Boolean.TRUE).get();

		DDMStructure ddmStructure = dDMStructureHandler.getByName(contentRequestBean.getContentType());

		Map<Locale, String> titleMap = new HashMap<>();

		titleMap.put(Locale.US, contentRequestBean.getTitle());

		FileEntry fileEntry = null;
		if (Validator.isNotNull(contentRequestBean.getFile()))
			try {
				fileEntry = fileEntryHandler.uploadContentImage(httpServletRequest, contentRequestBean);
			} catch (Exception e) {
				_log.info("Unable to upload provided document due to " + e.getMessage());
			}

		Fields ddmFields = ddmFormValuesToFieldsConverter.convert(ddmStructure,
				constructDMMFormValues(ddmStructure, contentRequestBean, fileEntry));

		String content = StringPool.BLANK;
		try {
			content = journalConverter.getContent(ddmStructure, ddmFields, group.getGroupId());
		} catch (Exception e) {
			throw new PortalException("Content is not proper please check input provided");
		}

		addCategoryDetails(contentRequestBean, serviceContext);

		return journalArticleLocalService.addArticle(serviceContext.getUserId(), serviceContext.getScopeGroupId(),
				parentFolder.getFolderId(), titleMap, null, content, ddmStructure.getStructureKey(), StringPool.BLANK,
				serviceContext);
	}
	
	/**
	 * 
	 * This method is to fetch web content with all structure fields data.
	 * 
	 * @param request
	 * @param contentMigrationRef
	 * @return
	 * @throws PortalException
	 */
	public JSONArray fetchDetailedJournalArticles(HttpServletRequest httpServletRequest, PubAccessMappingRef accessMapping)
			throws PortalException {

		ServiceContext serviceContext = ServiceContextFactory.getInstance(JournalArticle.class.getName(), httpServletRequest);

		Group group = groupHandler.getByDivision(accessMapping.getPublication_name());

		serviceContext.setScopeGroupId(group.getGroupId());

		JournalFolder parentFolder = journalFolderHandler.getFolder(serviceContext,
				CommonUtil.getDivsionNameByCode(accessMapping.getDivision()), DLFolderConstants.DEFAULT_PARENT_FOLDER_ID, Boolean.FALSE)
				.get();

		if (Validator.isNull(parentFolder))
			throw new PortalException("No folder found for requested AHMC app code");

		List<JournalArticle> journalArticles = journalArticleLocalService.getArticles(serviceContext.getScopeGroupId(),
				parentFolder.getFolderId(), QueryUtil.ALL_POS, QueryUtil.ALL_POS);

		if (Validator.isNull(journalArticles) || journalArticles.isEmpty())
			throw new PortalException("No articles found for requested AHMC app code");

		JSONArray array = JSONFactoryUtil.createJSONArray();

		journalArticles.forEach(journalArticle -> {
			getMetaDataInfo(httpServletRequest, array, journalArticle);
		});

		return array;
	}

	/**
	 * 
	 * @param httpServletRequest
	 * @param array
	 * @param journalArticle
	 */
	private void getMetaDataInfo(HttpServletRequest httpServletRequest, JSONArray array,
			JournalArticle journalArticle) {
		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
		try {

			journalArticle = journalArticleLocalService.getLatestArticle(journalArticle.getGroupId(),
					journalArticle.getArticleId());

			Fields fields = journalConverter.getDDMFields(journalArticle.getDDMStructure(),
					journalArticle.getContent());

			DDMFormValues ddmFormFieldValues = journalConverter.getDDMFormValues(journalArticle.getDDMStructure(),
					fields);

			ddmFormFieldValues.getDDMFormFieldValues().forEach(curField -> {

				if(curField.getName().equalsIgnoreCase("imageThumbnail") && Validator.isNotNull(curField.getValue().getString(Locale.US))) {
					try {
						JSONObject imageJSON;
						imageJSON = JSONFactoryUtil.createJSONObject(curField.getValue().getString(Locale.US));
						DLFileEntry dlFileEntry = dlFileEntryHandler.getDlFileEntry(imageJSON.getLong("fileEntryId"));
						jsonObject.put("imageThumbnail", dlFileEntryHandler.constructDocumentURL(httpServletRequest, dlFileEntry));
					} catch (Exception e) {
						_log.info("No images referenced in web content");
						jsonObject.put("imageThumbnail", StringPool.BLANK);
					}
				}else {
					
					jsonObject.put(curField.getName(), curField.getValue().getString(Locale.US));
				}
			});
			jsonObject.put("assetType","webContent");
			array.put(jsonObject);
		} catch (PortalException e) {
			_log.error(e, e);
		}
	}

	/**
	 * 
	 * This method is to populate data into structure fields of the web content.
	 * 
	 * @param structure
	 * @param contentRequestBean
	 * @return
	 * @throws PortalException
	 */
	private DDMFormValues constructDMMFormValues(DDMStructure structure, ContentRequestBean contentRequestBean,
			FileEntry fileEntry) throws PortalException {

		DDMFormValues ddmFormValues = new DDMFormValues(structure.getDDMForm());

		List<DDMFormFieldValue> ddmFormFieldValues = new ArrayList<>();

		List<DDMFormField> ddmFormFields = structure.getDDMForm().getDDMFormFields();

		ddmFormFields.forEach(ddmFormField -> {

			String val = StringPool.BLANK;
			if ("title".equalsIgnoreCase(ddmFormField.getName())) {
				val = contentRequestBean.getTitle();
			} else if ("description".equalsIgnoreCase(ddmFormField.getName())) {
				val = contentRequestBean.getDescription();
			} else if ("imageThumbnail".equalsIgnoreCase(ddmFormField.getName())) {
				if(Validator.isNotNull(fileEntry)) {
					ContentImageBean contentImageBean = new ContentImageBean(fileEntry.getFileEntryId(),
							fileEntry.getGroupId(), fileEntry.getTitle(), StringPool.BLANK, fileEntry.getTitle(), "journal",
							fileEntry.getUuid(), fileEntry.getFileEntryId(), "0");
					val = ObjectMapperUtil.parseToJSON(contentImageBean);
				}

			}else {
				val = Validator.isNotNull(contentRequestBean.getContentMetaDateBean())
						? contentRequestBean.getContentMetaDateBean().getValueByName(ddmFormField.getName())
						: StringPool.BLANK;
			}
			Value value = new LocalizedValue(Locale.US);
			DDMFormFieldValue ddmFormFieldValue = new DDMFormFieldValue();
			ddmFormFieldValue.setName(ddmFormField.getName());
			value.addString(Locale.US, val);
			ddmFormFieldValue.setValue(value);
			ddmFormFieldValues.add(ddmFormFieldValue);
		});

		ddmFormValues.setDDMFormFieldValues(ddmFormFieldValues);

		return ddmFormValues;
	}

	/**
	 * 
	 * This method is to set categories required into service context which can then
	 * be applied by Liferay.
	 * 
	 * @param contentRequestBean
	 * @param serviceContext
	 * @throws PortalException 
	 */

	private void addCategoryDetails(ContentRequestBean contentRequestBean, ServiceContext serviceContext)
			throws PortalException {
		List<Long> assetCategoryIdList = new ArrayList<Long>();

		AssetCategory assetCategory = null;

		if (Validator.isNotNull(contentRequestBean.getDivision())) {
			assetCategory = assetEntryCategoryHandler.getDivisionAssetCategory(serviceContext,contentRequestBean.getDivision(),Boolean.TRUE);
			if (Validator.isNotNull(assetCategory))
				assetCategoryIdList.add(assetCategory.getCategoryId());
		}

		if (Validator.isNotNull(contentRequestBean.getDepartment())) {
			assetCategory = assetEntryCategoryHandler.getDepartmentAssetCategory(serviceContext,contentRequestBean.getDepartment(),Boolean.TRUE);
			if (Validator.isNotNull(assetCategory))
				assetCategoryIdList.add(assetCategory.getCategoryId());
		}

		long[] assetCategoryIds = new long[assetCategoryIdList.size()];
		assetCategoryIds = assetCategoryIdList.stream().mapToLong(l -> l).toArray();

		serviceContext.setAssetCategoryIds(assetCategoryIds);
	}
	 

	@Reference
	private GroupHandler groupHandler;

	@Reference
	private DlFolderHandler dlFolderHandler;

	@Reference
	private DDMStructureHandler dDMStructureHandler;

	@Reference
	private JournalArticleLocalService journalArticleLocalService;

	@Reference
	private JournalConverter journalConverter;

	@Reference
	private DDMFormValuesToFieldsConverter ddmFormValuesToFieldsConverter;

	@Reference(unbind = "-")
	private JournalFolderHandler journalFolderHandler;

	@Reference
	private AssetEntryCategoryHandler assetEntryCategoryHandler;

	@Reference
	private FileEntryHandler fileEntryHandler;
	
	@Reference
	private DlFileEntryHandler dlFileEntryHandler;

	private static final Log _log = LogFactoryUtil.getLog(JournalArticleHandler.class);
}
