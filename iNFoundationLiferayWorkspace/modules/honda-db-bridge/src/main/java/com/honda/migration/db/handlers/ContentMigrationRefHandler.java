package com.honda.migration.db.handlers;

import com.honda.external.db.sb.model.ContentMigrationRef;
import com.honda.external.db.sb.service.ContentMigrationRefLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.util.Validator;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
	immediate = true,
	service = ContentMigrationRefHandler.class
)
public class ContentMigrationRefHandler {

	/**
	 * 
	 * @param ahmcAppCode
	 * @param division
	 * @param department
	 * @return
	 * @throws PortalException 
	 */
	public ContentMigrationRef getByAppCodeDivNDep(String ahmcAppCode,String division,String department) throws PortalException {
		
		ContentMigrationRef contentMigrationRef = contentMigrationRefLocalService.getByAppCodeDivisionNDepart(ahmcAppCode, division, department);
		
		if(Validator.isNull(contentMigrationRef))
			throw new PortalException("Invalid AHMC App code and divsion mapping");
		
		return contentMigrationRef;
		
	}
	
	/**
	 * 
	 * @param ahmcAppCode
	 * @param division
	 * @return
	 * @throws PortalException 
	 */
	public ContentMigrationRef getByAppCodeDiv(String ahmcAppCode,String division) throws PortalException {

		ContentMigrationRef contentMigrationRef = contentMigrationRefLocalService.getByAppCode(ahmcAppCode, division);
		
		if(Validator.isNull(contentMigrationRef))
			throw new PortalException("Invalid AHMC App code and divsion mapping");
		
		return contentMigrationRef;
	}
	
	@Reference
	private ContentMigrationRefLocalService contentMigrationRefLocalService;
}
