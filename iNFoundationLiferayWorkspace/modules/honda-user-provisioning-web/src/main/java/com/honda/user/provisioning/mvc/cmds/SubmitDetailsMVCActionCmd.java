package com.honda.user.provisioning.mvc.cmds;

import com.honda.user.provisioning.util.UserProvisioningHelper;
import com.honda.user.provisioning.web.constants.UserProvisioningWebPortletKeys;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Vinisha Pathak
 *
 */
@Component(
	    immediate = true,
	    property = {
	    	"javax.portlet.name=" + UserProvisioningWebPortletKeys.USERPROVISIONINGWEB,
	        "mvc.command.name=userProvisioningAction"
	    },
	    service = MVCActionCommand.class
	)

public class SubmitDetailsMVCActionCmd implements MVCActionCommand {
	
	@Override
	public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {

		_log.info("Inside processAction !!");
		
		try {
			User user = userProvisioningHelper.onboardUser(actionRequest,ParamUtil.getString(actionRequest, "firstName"),
					ParamUtil.getString(actionRequest, "lastName"), ParamUtil.getString(actionRequest, "emailId"));
			_log.info("User has been onboarded successfully with User Id - " +  user.getUserId() + " !!");
			actionResponse.getRenderParameters().setValue("uId", String.valueOf(user.getUserId()));
			actionResponse.getRenderParameters().setValue("jspPage", "/jsps/thankyou.jsp");
		} catch (PortalException e) {
			_log.error(e, e);
			actionRequest.setAttribute("error", e.getMessage());
		}
		
		return false;
	}
	
	@Reference
	private UserProvisioningHelper userProvisioningHelper;
	
	private static final Log _log = LogFactoryUtil.getLog(SubmitDetailsMVCActionCmd.class);

}
