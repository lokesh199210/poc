package com.honda.search.api;

import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.SearchException;

public interface SearchAPI {

	Hits search(BooleanQuery booleanQuery, long companyId, int start, int end) throws SearchException;

	long searchCount(BooleanQuery booleanQuery, long companyId) throws SearchException;

}
