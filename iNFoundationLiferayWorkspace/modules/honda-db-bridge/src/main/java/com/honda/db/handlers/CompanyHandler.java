package com.honda.db.handlers;

import com.liferay.portal.kernel.exception.NoSuchCompanyException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.service.CompanyLocalService;
import com.liferay.portal.kernel.util.Validator;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
	immediate = true,
	service = CompanyHandler.class
)
public class CompanyHandler {

	public Company getByWebId(String webId) throws PortalException {
		
		Company company = companyLocalService.getCompanyByWebId(webId);
		
		if(Validator.isNull(company))
			throw new NoSuchCompanyException("Request company doesn't exits.");
		
		return company;
	}
	
	@Reference
	private CompanyLocalService companyLocalService;
}
