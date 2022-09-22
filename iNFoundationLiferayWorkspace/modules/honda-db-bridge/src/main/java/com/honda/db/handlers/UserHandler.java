package com.honda.db.handlers;

import com.honda.obj.mapper.beans.UserProvisionBean;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.NoSuchUserException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.util.Validator;

import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
	immediate = true,
	service = UserHandler.class
)
public class UserHandler {

	public User getByEmailAddress(long companyId,String emailAddress) throws PortalException {
		
		return userLocalService.getUserByEmailAddress(companyId, emailAddress);
		
	}
	
	public User getByEmailDefaultCmp(String emailAddress) throws PortalException {
		
		Company company = companyHandler.getByWebId("honda.com");
		
		User user = userLocalService.getUserByEmailAddress(company.getCompanyId(), emailAddress);
		
		if(Validator.isNull(user))
			throw new NoSuchUserException("Unable to find requested user");
		
		return user;
		
	}
	
	public User createUser(ServiceContext serviceContext,String emailAddress,String firstName,String middleName,String lastName) throws PortalException {
		
		long prefixId = 0;
		long suffixId = 0;
		boolean male = true;
		int birthdayMonth = 01;
		int birthdayDay = 01;
		int birthdayYear = 1970;
		String jobTitle = "";
		long[] groupIds = null;
		long[] organizationIds = null;
		long[] roleIds = null;
		long[] userGroupIds = null;
		
		User user = null;
		try {
			user = userLocalService.getUserByEmailAddress(serviceContext.getCompanyId(), emailAddress);
		}
		catch (Exception e) {
			
		}
		
		if(!isEmailValid(emailAddress)) {
			throw new PortalException("email address is not valid !!");
		}
			
		if(Validator.isNotNull(user))
			throw new PortalException("User already exits with the provided email address !!");
		
		return userLocalService.addUserWithWorkflow(serviceContext.getUserId(), serviceContext.getCompanyId(), Boolean.TRUE,StringPool.BLANK, StringPool.BLANK,
				Boolean.TRUE, StringPool.BLANK, emailAddress, serviceContext.getLocale(), firstName, middleName, lastName, prefixId, suffixId,
				male, birthdayMonth, birthdayDay, birthdayYear, jobTitle, groupIds, organizationIds, roleIds,
				userGroupIds, Boolean.FALSE, serviceContext);
	}
	
	public User updateUser(ServiceContext serviceContext,String emailAddress,String firstName,String middleName,String lastName) throws PortalException {
		
		User user = null;
		try {
			user = userLocalService.getUserByEmailAddress(serviceContext.getCompanyId(), emailAddress);
		}
		catch (Exception e) {
		}
		
		if(!isEmailValid(emailAddress)) {
			throw new PortalException("email address is not valid !!");
		}
		
		if(Validator.isNull(user))
			throw new PortalException("User not found with the provided email address !!");
		
		user.setFirstName(firstName);
		user.setLastName(lastName);
		return userLocalService.updateUser(user);	
	}
	
	public JSONArray createOrUpdateUser(HttpServletRequest httpServletRequest, UserProvisionBean userProvisionBean) throws PortalException {
		
		String firstName = userProvisionBean.getFirstname();
		String lastName = userProvisionBean.getLastname();
		String emailAddress = userProvisionBean.getEmailAddress();
		String operation = userProvisionBean.getOperation();
		String division = userProvisionBean.getDivision();
		String department = userProvisionBean.getDepartment();
		String employeeType = userProvisionBean.getEmployeeType();
		String location = userProvisionBean.getLocation();
		String publication = userProvisionBean.getPublication();
		
		ServiceContext serviceContext = ServiceContextFactory.getInstance(User.class.getName(), httpServletRequest);
	
		if (operation.equalsIgnoreCase(("create"))) {
			User user = createUser(serviceContext, emailAddress, firstName, StringPool.BLANK, lastName);
			System.out.println("User has been created successfully with Email Id - " +  user.getEmailAddress() + " !!");
			membershipHandler.assignSiteMembership(serviceContext, user, division, department, employeeType, location);
			membershipHandler.assignAssetLibraryMembership(serviceContext, user, publication);
		}
		else if (operation.equalsIgnoreCase(("update"))) {
			User user = updateUser(serviceContext, emailAddress, firstName, StringPool.BLANK, lastName);	
			System.out.println("User has been updated successfully with Email Id - " +  user.getEmailAddress() + " !!");
			membershipHandler.assignSiteMembership(serviceContext, user, division, department, employeeType, location);
			membershipHandler.assignAssetLibraryMembership(serviceContext, user, publication);
		}
		else 
			return null;
		
		return null;
	}
	
    public boolean isEmailValid(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                            "[a-zA-Z0-9_+&*-]+)*@" +
                            "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                            "A-Z]{2,7}$";
                              
        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
    }
	
	public String terminateUser(HttpServletRequest httpServletRequest,String emailAddress) throws PortalException {
		
		ServiceContext serviceContext = ServiceContextFactory.getInstance(User.class.getName(), httpServletRequest);
		User user = null;
		String message = StringPool.BLANK;
		try {
			user = userLocalService.getUserByEmailAddress(serviceContext.getCompanyId(), emailAddress);
		}
		catch (Exception e) {
		}
		
		if(!isEmailValid(emailAddress)) {
			throw new PortalException("email address is not valid !!");
		}
		
		if(Validator.isNull(user))
			throw new PortalException("User not found with the provided email address !!");
	
		if(user.getStatus() == 0) {
			user.setStatus(5);
			userLocalService.updateUser(user);	
			message = "User with Email Id - " + emailAddress + " deactivated successfully !!";
		}
		else {
			message = "User with Email Id - " + emailAddress + " is already deactivated !!";
		}

		return message;	
	}
	
	@Reference
	private CompanyHandler companyHandler;
	
	@Reference
	private MembershipHandler membershipHandler;
	
	@Reference
	private UserLocalService userLocalService;
}
