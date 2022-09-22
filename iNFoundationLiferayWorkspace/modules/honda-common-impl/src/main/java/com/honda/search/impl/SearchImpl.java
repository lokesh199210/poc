package com.honda.search.impl;

import com.honda.search.api.SearchAPI;
import com.honda.search.query.api.SearchQueryAPI;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.IndexSearcherHelperUtil;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.SortFactoryUtil;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
	immediate = true,
	service = SearchAPI.class
)
public class SearchImpl implements SearchAPI{

	@Override
	public Hits search(BooleanQuery booleanQuery, long companyId,int start,int end) throws SearchException {
		
		return IndexSearcherHelperUtil.search(getSearchContext(companyId, start, end), booleanQuery);
	}
	
	@Override
	public long searchCount(BooleanQuery booleanQuery, long companyId) throws SearchException {
		
		return IndexSearcherHelperUtil.searchCount(getSearchContext(companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS), booleanQuery);
	}
	
	
	/**
	 * This method is to get the search context object, start and end limit of the result set are configured here
	 * @param themeDisplay
	 * @param start
	 * @param end
	 * @return
	 */
	private static SearchContext getSearchContext(long companyId,int start,int end) {
		/*------------ Creating search context object with parameters --------------*/
		SearchContext searchContext = new SearchContext();
		searchContext.setCompanyId(companyId);
		searchContext.setStart(start);
		searchContext.setEnd(end);
		Sort sort = SortFactoryUtil.create(Field.ENTRY_CLASS_NAME, Sort.STRING_TYPE, false);
		searchContext.setSorts(sort);
		
		return searchContext;
	}
	
	@Reference
	private SearchQueryAPI searchQueryAPI;
	
	private static final Log _log = LogFactoryUtil.getLog(SearchImpl.class);
}
