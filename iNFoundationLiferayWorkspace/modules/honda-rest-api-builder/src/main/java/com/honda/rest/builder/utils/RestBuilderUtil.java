package com.honda.rest.builder.utils;

import com.honda.obj.mapper.beans.RequestBodyBean;
import com.honda.obj.mapper.beans.UserProvisionBean;
import com.honda.rest.builder.constants.RestBuilderConstants.RestBuilderConstant;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.util.Validator;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

public interface RestBuilderUtil {

	
	static void validateDocumentInputs(HttpServletRequest httpServletRequest,File file) throws PortalException {
		
		if(Validator.isNull(file))
			throw new PortalException("File is mandatory");

		if(Validator.isNull(httpServletRequest.getParameter(RestBuilderConstant.DIVISION_PARAM_KEY.getValue())))
			throw new PortalException("Division is mandatory");
		
		if(Validator.isNull(httpServletRequest.getParameter(RestBuilderConstant.AHMC_APP_CODE_PARAM_KEY.getValue())))
			throw new PortalException("AHMC code is mandatory");
		
		if(Validator.isNull(httpServletRequest.getParameter(RestBuilderConstant.TITLE_PARAM_KEY.getValue())))
			throw new PortalException("Title is mandatory");
	}
	
	static void validateDocumentInputs(HttpServletRequest httpServletRequest) throws PortalException {

		if(Validator.isNull(httpServletRequest.getParameter(RestBuilderConstant.DIVISION_PARAM_KEY.getValue())))
			throw new PortalException("Division is mandatory");
		
		if(Validator.isNull(httpServletRequest.getParameter(RestBuilderConstant.DEPARTMENT_PARAM_KEY.getValue())))
			throw new PortalException("Department is mandatory");
		
		if(Validator.isNull(httpServletRequest.getParameter(RestBuilderConstant.AHMC_APP_CODE_PARAM_KEY.getValue())))
			throw new PortalException("AHMC code is mandatory");
		
		if(Validator.isNull(httpServletRequest.getParameter(RestBuilderConstant.TITLE_PARAM_KEY.getValue())))
			throw new PortalException("Title is mandatory");
	}
	
	static void validateRequestBody(String division,String department,String ahmcAppCode) throws PortalException {
		if(Validator.isNull(division))
			throw new PortalException("Division is mandatory");
		
		if(Validator.isNull(department))
			throw new PortalException("AHMC code is mandatory");
		
		if(Validator.isNull(ahmcAppCode))
			throw new PortalException("Title is mandatory");
	}
	
	static void validateRequestBody(RequestBodyBean requestBodyBean) throws PortalException {
		if(Validator.isNull(requestBodyBean.getDivision()))
			throw new PortalException("Division is mandatory");
		
		if(Validator.isNull(requestBodyBean.getDepartment()))
			throw new PortalException("AHMC code is mandatory");
		
		if(Validator.isNull(requestBodyBean.getAhmcAppCode()))
			throw new PortalException("Title is mandatory");
		
	}
	
	static void validateUserProvisionInputs(UserProvisionBean userProvisionBean) throws PortalException {
		
		if(Validator.isNull(userProvisionBean.getFirstname()))
			throw new PortalException("First Name is mandatory");
		
		if(Validator.isNull(userProvisionBean.getLastname()))
			throw new PortalException("Last Name is mandatory");
		
		if(Validator.isNull(userProvisionBean.getEmailAddress()))
			throw new PortalException("Email Address is mandatory");
		
		if(Validator.isNull(userProvisionBean.getOperation()))
			throw new PortalException("Operation is mandatory");
		
		if(Validator.isNull(userProvisionBean.getDivision()))
			throw new PortalException("Division is mandatory");
		
		if(Validator.isNull(userProvisionBean.getDepartment()))
			throw new PortalException("Department is mandatory");
		
		if(Validator.isNull(userProvisionBean.getEmployeeType()))
			throw new PortalException("Employee Type is mandatory");
		
		if(Validator.isNull(userProvisionBean.getLocation()))
			throw new PortalException("Location is mandatory");
		
		if(Validator.isNull(userProvisionBean.getPublication()))
			throw new PortalException("Publication is mandatory");
	}
	
}
