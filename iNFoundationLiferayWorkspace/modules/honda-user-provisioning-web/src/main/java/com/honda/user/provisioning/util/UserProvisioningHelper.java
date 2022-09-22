package com.honda.user.provisioning.util;

import com.honda.db.handlers.UserHandler;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;

import javax.portlet.PortletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Vinisha Pathak
 *
 */
@Component(
	immediate = true,
	service = UserProvisioningHelper.class
)
public class UserProvisioningHelper {
	
	public JSONObject getJsonPacketFromNASA() {
		
		_log.info("Inside getJsonPacketFromNASA !!");
		JSONObject obj = JSONFactoryUtil.createJSONObject();
		obj.put("firstName", "John");
		obj.put("lastName", "Magrann");
		obj.put("emailId", "john.magrann@liferay.com");
		obj.put("jobTitle", "Project Manager");
		obj.put("division", "Acura");
		obj.put("department", "Service");
		_log.info("JSON Packet created successfully !!");
		
		return obj;
	}
	
	public User onboardUser(PortletRequest portletRequest, String firstName, String lastName, String emailAddress)
			throws PortalException {
		
		ServiceContext serviceContext = ServiceContextFactory.getInstance(User.class.getName(), portletRequest);
		_log.info("Inside onboardUser !!");
		
		_log.info("Firstname : " + firstName);
		_log.info("Lastname : " + lastName);
		_log.info("Email Id : " + emailAddress);
		
		
		return userHandler.createUser(serviceContext, emailAddress, firstName, StringPool.BLANK, lastName);		
	}
	
	@Reference
	private UserHandler userHandler;
	
	private static final Log _log = LogFactoryUtil.getLog(UserProvisioningHelper.class);
}
