package com.honda.db.handlers;

import com.liferay.dynamic.data.mapping.model.DDMStructure;
import com.liferay.dynamic.data.mapping.service.DDMStructureLocalService;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.NoSuchGroupException;
import com.liferay.portal.kernel.util.Validator;

import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * 
 * @author Lokesh Sharma
 *
 */
@Component(
	immediate = true, 
	service = DDMStructureHandler.class
)
public class DDMStructureHandler {

	public List<DDMStructure> getAllStructures() {
		
        return ddmStructureLocalService.getDDMStructures(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	public DDMStructure getByName(String name) throws NoSuchGroupException {
		
		DynamicQuery dynamicQuery = ddmStructureLocalService.dynamicQuery();
		
		dynamicQuery.add(RestrictionsFactoryUtil.ilike("name", StringPool.PERCENT + name + StringPool.PERCENT));
		
		List<DDMStructure> structure = ddmStructureLocalService.dynamicQuery(dynamicQuery);
		
		if(Validator.isNull(structure) || structure.isEmpty())
			throw new NoSuchGroupException("Invalid division, please check the details entered.");
		
		DDMStructure ddmStructure = structure.stream().findFirst().orElse(null);
		
		if(Validator.isNull(ddmStructure))
			throw new NoSuchGroupException("Invalid division, please check the details entered.");
		
		return ddmStructure;
		
	}
	
	@Reference
	private DDMStructureLocalService ddmStructureLocalService;
}
