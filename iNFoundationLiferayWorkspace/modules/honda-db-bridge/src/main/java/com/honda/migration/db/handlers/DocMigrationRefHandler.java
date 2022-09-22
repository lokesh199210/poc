package com.honda.migration.db.handlers;

import com.honda.external.db.sb.model.DocMigrationRef;
import com.honda.external.db.sb.service.DocMigrationRefLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.util.Validator;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
	immediate = true,
	service = DocMigrationRefHandler.class
)
public class DocMigrationRefHandler {

	/**
	 * 
	 * @param ahmcAppCode
	 * @param division
	 * @param department
	 * @return
	 * @throws PortalException 
	 */
	public DocMigrationRef getByAppCodeDivNDep(String ahmcAppCode,String division,String department) throws PortalException {
		
		DocMigrationRef docMigrationRef = docMigrationRefLocalService.getByAppCodeDivisionNDepart(ahmcAppCode, division, department);
		
		if(Validator.isNull(docMigrationRef))
			throw new PortalException("Invalid AHMC App code and divsion mapping");
		
		return docMigrationRef;
		
	}
	
	/**
	 * 
	 * @param ahmcAppCode
	 * @param division
	 * @return
	 * @throws PortalException 
	 */
	public DocMigrationRef getByAppCodeDiv(String ahmcAppCode,String division) throws PortalException {

		DocMigrationRef docMigrationRef = docMigrationRefLocalService.getByAppCode(ahmcAppCode, division);
		
		if(Validator.isNull(docMigrationRef))
			throw new PortalException("Invalid AHMC App code and divsion mapping");
		
		return docMigrationRef;
	}
	
	@Reference
	private DocMigrationRefLocalService docMigrationRefLocalService;
}
