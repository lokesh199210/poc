package com.honda.db.handlers;

import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.util.Validator;

/**
 * 
 * Class to handle Roles related operation like fetching Site roles, Asset Library roles etc.
 * 
 * @author Vinisha Pathak
 *
 */
@Component(
	immediate = true,
	service = RoleHandler.class
)
public class RoleHandler {
	
	public List<Role> getAssetLibraryRoles(HttpServletRequest httpServletRequest) throws PortalException {
		
		ServiceContext serviceContext = ServiceContextFactory.getInstance(User.class.getName(), httpServletRequest);
		long companyId = serviceContext.getCompanyId();
		List <Role> roles = roleLocalService.getRoles(companyId);
		
		if (Validator.isNull(roles) || roles.isEmpty())
			throw new PortalException("No roles found !!");
		
		return (roles.stream().filter(role -> role.getName().startsWith("Asset Library"))).collect(Collectors.toList());
	}		
	
	public List<Role> getSiteRoles(HttpServletRequest httpServletRequest) throws PortalException {
		
		ServiceContext serviceContext = ServiceContextFactory.getInstance(User.class.getName(), httpServletRequest);
		long companyId = serviceContext.getCompanyId();
		List <Role> roles = roleLocalService.getRoles(companyId);
		
		if (Validator.isNull(roles) || roles.isEmpty())
			throw new PortalException("No roles found !!");
		
		return (roles.stream().filter(role -> role.getName().startsWith("Site"))).collect(Collectors.toList());
	}
	
	@Reference
	private RoleLocalService roleLocalService;

}
