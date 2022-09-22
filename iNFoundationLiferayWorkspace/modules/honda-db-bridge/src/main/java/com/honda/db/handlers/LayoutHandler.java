package com.honda.db.handlers;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.NoSuchLayoutException;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.service.LayoutLocalService;
import com.liferay.portal.kernel.util.Validator;

import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
	immediate = true,
	service = LayoutHandler.class
)
public class LayoutHandler {

	public Layout getByDivisionNDepartment(String department,long divisionId) throws NoSuchLayoutException {
		
		DynamicQuery dynamicQuery = layoutLocalService.dynamicQuery();
		
		Criterion criterion = RestrictionsFactoryUtil.ilike("name", StringPool.PERCENT + department + StringPool.PERCENT);
		
		dynamicQuery.add(RestrictionsFactoryUtil.and(criterion, RestrictionsFactoryUtil.eq("groupId", divisionId)));
		
		List<Layout> layouts = layoutLocalService.dynamicQuery(dynamicQuery);
		
		if(Validator.isNull(layouts) || layouts.isEmpty())
			throw new NoSuchLayoutException("Invalid department, please check the details entered.");
		
		Layout layout = layouts.stream().findFirst().orElse(null);
		
		if(Validator.isNull(layout))
			throw new NoSuchLayoutException("Invalid department, please check the details entered.");
		
		return layout;
	}
	
	@Reference
	private LayoutLocalService layoutLocalService;
}
