package com.honda.db.handlers;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.util.Validator;

import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * 
 * Class to handle all the operations related to Asset Library like showing listing etc.
 * 
 * @author Vinisha Pathak
 *
 */
@Component(
	immediate = true,
	service = AssetLibraryHandler.class
)
public class AssetLibraryHandler {

	public List <Group> getAssetLibraries(HttpServletRequest httpServletRequest) throws PortalException {
		
		System.out.println("In here");
		ServiceContext serviceContext = ServiceContextFactory.getInstance(User.class.getName(), httpServletRequest);
		long companyId = serviceContext.getCompanyId();
		List <Group> groups = groupLocalService.getActiveGroups(companyId, Boolean.TRUE);
		
		if (Validator.isNull(groups) || groups.isEmpty())
			throw new PortalException("No groups found !!");
		
		return (groups.stream().filter(group -> group.getFriendlyURL().contains("/asset-library"))).collect(Collectors.toList());
	}
	
	
	@Reference
	private GroupLocalService groupLocalService;

}
