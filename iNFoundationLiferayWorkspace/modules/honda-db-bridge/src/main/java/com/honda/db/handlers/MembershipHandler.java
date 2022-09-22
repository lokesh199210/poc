package com.honda.db.handlers;

import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.OrganizationLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.util.Validator;

/**
 * 
 * Class to handle Memberships related operation like assigning membership of Site, Asset Library etc.
 * 
 * @author Vinisha Pathak
 *
 */
@Component(
	immediate = true,
	service = MembershipHandler.class
)
public class MembershipHandler {

	public User assignSiteMembership(ServiceContext serviceContext, User userObj, String division, String department, String employeeType, String location) 
			throws PortalException {
		
		userObj.getExpandoBridge().setAttribute("Department", department);
		userObj.getExpandoBridge().setAttribute("Division", division);
		userObj.getExpandoBridge().setAttribute("EmployeeType", employeeType);
		userObj.getExpandoBridge().setAttribute("Location", location);
		_log.info("Custom Atttributes set for this User !!");
		
		long userId = userObj.getUserId();
		
		Organization org = null;
		org = organizationLocalService.getOrganization(serviceContext.getCompanyId(), division);
		long orgId = org.getOrganizationId();
		
		if(!organizationLocalService.hasUserOrganizations(userId)) {
			_log.info("No record of organization found for this User, hence adding " + division);
			userLocalService.addOrganizationUser(orgId, userId);
			_log.info("Membership of " + division + " assigned successfully for Email Id - " +  userObj.getEmailAddress() + " !!");
		}
		else {
			List <Organization> orgs = organizationLocalService.getUserOrganizations(userId, -1, -1);
			_log.info("Size of Organization list : " + orgs.size());
			
			if (Validator.isNull(orgs) || orgs.isEmpty())
				throw new PortalException("No Organizations for this User found !!");
			
			int count = 0;
			for (Organization organization : orgs) {
				if(division.equalsIgnoreCase(organization.getName())) 
					count ++;
			}
			
			if(count > 0) {
				_log.info("Membership of " + division + " is already assigned to this User !!");
			}
			else {
				userLocalService.addOrganizationUser(orgId, userId);
				_log.info("Membership of " + division + " appended successfully for Email Id - " +  userObj.getEmailAddress() + " !!");
			}
		}
		
		return userObj;
	}
	
	public User assignAssetLibraryMembership(ServiceContext serviceContext, User userObj, String publication) throws PortalException {
		
		long companyId = serviceContext.getCompanyId();
		long userId = userObj.getUserId();
		   
		Group grp = null;
		grp = groupLocalService.fetchGroup(companyId, publication);
		long grpId = grp.getGroupId();
		
		if(!userLocalService.hasGroupUser(grpId, userId)) {
			userLocalService.addGroupUser(grpId, userId);
			_log.info("Asset Library Membership of " + publication + " assigned successfully for Email Id - " +  userObj.getEmailAddress() + " !!");
		}
		else {
			_log.info("Asset Library Membership of " + publication + " is already assigned to this User !!");
		}
		
		return userObj;
	}
	
	@Reference
	private UserLocalService userLocalService;
	
	@Reference
	private OrganizationLocalService organizationLocalService;
	
	@Reference
	private GroupLocalService groupLocalService;

	private static final Log _log = LogFactoryUtil.getLog(MembershipHandler.class);
}
