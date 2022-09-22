package com.honda.search.query.impl;

import com.honda.search.query.api.SearchQueryAPI;
import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.journal.model.JournalArticle;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.search.BooleanClauseOccur;
import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.ParseException;
import com.liferay.portal.kernel.search.generic.BooleanQueryImpl;
import com.liferay.portal.kernel.util.Validator;

import org.osgi.service.component.annotations.Component;

@Component(
	immediate = true,
	service = SearchQueryAPI.class
		
)
public class SearchQueryImpl implements SearchQueryAPI{

	@Override
	public BooleanQuery createQuery(long groupId, long companyId, String entityClassName) throws PortalException {

		BooleanQuery query = new BooleanQueryImpl();
		query.addRequiredTerm(Field.ENTRY_CLASS_NAME, entityClassName);
		query.addRequiredTerm(Field.SCOPE_GROUP_ID, groupId);
		query.addRequiredTerm(Field.COMPANY_ID, companyId);
		
		return query;
		
	}
	
	/**
	 * This method adds entity wise params to query
	 * @param query
	 * @param entityClassName
	 * @param structures
	 * @throws ParseException
	 */
	@Override
	public void createEntityWiseQuery(BooleanQuery query,String entityClassName) throws ParseException {
		if(JournalArticle.class.getName().equalsIgnoreCase(entityClassName)) {
			/*
			 * For Journal Article entity only in order to fetch only the latest version of
			 * the document below properties are set in the query.
			 */
			query.addRequiredTerm("head", Boolean.TRUE);
			query.addRequiredTerm("latest", Boolean.TRUE);
		}else if(Layout.class.getName().equalsIgnoreCase(entityClassName)) {
			/*-------------- For layout to fetch public layouts and layouts that are not hidden ------------*/
		}else if(DLFileEntry.class.getName().equalsIgnoreCase(entityClassName)) {
		}
	}

	@Override
	public void createDlFolderQuery(BooleanQuery query,long folderId) throws ParseException {
		/* Search query to be written for keyword search folder Id */
		BooleanQuery folderQuery = new BooleanQueryImpl();
		folderQuery.addTerm(Field.FOLDER_ID, folderId);
		
		query.add(folderQuery, BooleanClauseOccur.MUST);
	}
	
	@Override
	public void createJournalFolderQuery(BooleanQuery query,long folderId) throws ParseException {
		/* Search query to be written for keyword search folder Id */
		BooleanQuery folderQuery = new BooleanQueryImpl();
		folderQuery.addTerm(Field.FOLDER_ID, 40045);
		
		query.add(folderQuery, BooleanClauseOccur.MUST);
	}

	@Override
	public void createKeywordQuery(BooleanQuery query,String keyword,String entityClassName) throws ParseException {
		if(Validator.isNotNull(keyword)) {
			/* Search query to be written for keyword search on desired field */
			BooleanQuery keywordQuery = new BooleanQueryImpl();
			keywordQuery.addTerm(Field.TITLE, keyword,true,BooleanClauseOccur.SHOULD);
			keywordQuery.addTerm("content_en_US",keyword,true,BooleanClauseOccur.SHOULD);
			keywordQuery.addTerm("ddmContent", keyword);
			query.add(keywordQuery, BooleanClauseOccur.MUST);
		}
	}
	
	@Override
	public void createMetadataQuery(BooleanQuery query,String keyword,String entityClassName) throws ParseException {
		if(Validator.isNotNull(keyword)) {
			/* Search query to be written for keyword search on desired field */
			BooleanQuery keywordQuery = new BooleanQueryImpl();
			keywordQuery.addTerm("ddmContent", keyword);
			query.add(keywordQuery, BooleanClauseOccur.MUST);
		}
	}

	@Override
	public void createStructureQuery(BooleanQuery query,String ddmStructureKey) throws ParseException {
		BooleanQuery structureQuery = new BooleanQueryImpl();
		
		structureQuery.add(structureQuery.addExactTerm("ddmStructureKey", ddmStructureKey), BooleanClauseOccur.SHOULD);
		
		query.add(structureQuery, BooleanClauseOccur.MUST);
	}
	
	@Override
	public void createCategoryQuery(BooleanQuery query,String categories) throws ParseException {
		
		BooleanQuery categoryQuery = new BooleanQueryImpl();
		
		categoryQuery.addTerm(Field.ASSET_CATEGORY_IDS, categories);
		
		query.add(categoryQuery, BooleanClauseOccur.MUST);
	}
	
	private static final Log _log = LogFactoryUtil.getLog(SearchQueryImpl.class);
}
