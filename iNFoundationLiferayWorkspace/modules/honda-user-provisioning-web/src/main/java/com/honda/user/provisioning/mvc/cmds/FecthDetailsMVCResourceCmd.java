package com.honda.user.provisioning.mvc.cmds;

import com.honda.user.provisioning.util.UserProvisioningHelper;
import com.honda.user.provisioning.web.constants.UserProvisioningWebPortletKeys;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import java.io.IOException;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Vinisha Pathak
 */
@Component(
	    immediate = true,
	    property = {
	    	"javax.portlet.name=" + UserProvisioningWebPortletKeys.USERPROVISIONINGWEB,
	        "mvc.command.name=userProvisioningResource"
	    },
	    service = MVCResourceCommand.class
	)

public class FecthDetailsMVCResourceCmd implements MVCResourceCommand {
	
	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {
		
		_log.info("Inside serveResource !!");
		String userId = ParamUtil.getString(resourceRequest, "userId");
		_log.info("User Id entered by User : " + userId);
		
		try {
			JSONObject requestObj = userProvisioningHelper.getJsonPacketFromNASA();
			
			resourceResponse.setContentType("application/json");
	        resourceResponse.setCharacterEncoding("UTF-8");
	        resourceResponse.getWriter().write(requestObj.toString());
		}
		catch (IOException e) {
			_log.error(e, e);
		}
		
		return false;
	}
	
	@Reference
	private UserProvisioningHelper userProvisioningHelper;
	
	private static final Log _log = LogFactoryUtil.getLog(FecthDetailsMVCResourceCmd.class);
	
}
