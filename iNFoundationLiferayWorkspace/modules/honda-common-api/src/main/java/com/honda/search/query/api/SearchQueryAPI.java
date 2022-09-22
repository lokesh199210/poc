package com.honda.search.query.api;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.ParseException;

public interface SearchQueryAPI {

	BooleanQuery createQuery(long groupId, long companyId, String entityClassName) throws PortalException;

	void createEntityWiseQuery(BooleanQuery query, String entityClassName) throws ParseException;

	void createKeywordQuery(BooleanQuery query, String keyword, String entityClassName) throws ParseException;

	void createDlFolderQuery(BooleanQuery query, long folderId) throws ParseException;

	void createJournalFolderQuery(BooleanQuery query, long folderId) throws ParseException;

	void createStructureQuery(BooleanQuery query, String ddmStructureKey) throws ParseException;

	void createCategoryQuery(BooleanQuery query, String categories) throws ParseException;

	void createMetadataQuery(BooleanQuery query, String keyword, String entityClassName) throws ParseException;

}
