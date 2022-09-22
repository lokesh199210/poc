package com.honda.db.handlers;

import com.liferay.document.library.kernel.model.DLFileEntryType;
import com.liferay.document.library.kernel.service.DLFileEntryTypeLocalService;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.util.LocaleUtil;

import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
	immediate = true,
	service = DLFileEntryTypeHandler.class
)
public class DLFileEntryTypeHandler {

	/**
	 * 
	 * @param groupId
	 * @param type
	 * @return
	 */
	public DLFileEntryType getDLFileEntryType(long groupId,String type) {
		
		DynamicQuery dq = dlFileEntryTypeLocalService.dynamicQuery();
		
		dq.add(RestrictionsFactoryUtil.eq("groupId", groupId));
		
		List<DLFileEntryType> entryType = dlFileEntryTypeLocalService.dynamicQuery(dq);
		
		return  entryType.stream().filter(obj -> type.equalsIgnoreCase(obj.getName(LocaleUtil.ENGLISH))).findAny().orElse(null);
	}
	
	/**
	 * 
	 * @param type
	 * @return
	 */
	public DLFileEntryType getDLFileEntryType(String type) {
		
		List<DLFileEntryType> entryType = dlFileEntryTypeLocalService.getDLFileEntryTypes(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		
		return  entryType.stream().filter(obj -> type.equalsIgnoreCase(obj.getName(LocaleUtil.ENGLISH))).findAny().orElse(null);
	}
	
	@Reference(unbind="-")
	private DLFileEntryTypeLocalService dlFileEntryTypeLocalService;
}
