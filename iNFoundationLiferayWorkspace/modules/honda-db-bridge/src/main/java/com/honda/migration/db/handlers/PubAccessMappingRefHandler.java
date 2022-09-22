package com.honda.migration.db.handlers;

import com.honda.external.db.sb.model.PubAccessMappingRef;
import com.honda.external.db.sb.service.PubAccessMappingRefLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.util.Validator;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
		immediate = true,
		service = PubAccessMappingRefHandler.class)
public class PubAccessMappingRefHandler {

	
	
	public PubAccessMappingRef getByAppCodeNDiv(String ahmc_App_Code, String division) throws PortalException {
		
		PubAccessMappingRef pubAccessMapping = pubAccessMappingRefLocalService.getByAppCode(ahmc_App_Code, division);

		if (Validator.isNull(pubAccessMapping))
			throw new PortalException("Invalid AHMC App code and divsion mapping");

		return pubAccessMapping;
	}

	
	@Reference
	private PubAccessMappingRefLocalService pubAccessMappingRefLocalService;
}
