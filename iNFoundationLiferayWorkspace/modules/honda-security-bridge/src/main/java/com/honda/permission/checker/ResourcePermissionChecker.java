package com.honda.permission.checker;

import com.honda.permission.checker.constants.PermissionCheckerConstants;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.ResourceActionsException;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.PermissionThreadLocal;
import com.liferay.portal.kernel.service.permission.LayoutPermissionUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;

import org.osgi.service.component.annotations.Component;

@Component(
	immediate = true,
	service = ResourcePermissionChecker.class
)
public class ResourcePermissionChecker {
	
	public boolean checkLayoutViewPermission(Layout layout) throws PortalException {
		
		boolean hasPermission = LayoutPermissionUtil.contains(getPermissionChecker(), layout, ActionKeys.VIEW);
		
		if(!hasPermission)
			throw new ResourceActionsException(PermissionCheckerConstants.NO_RESOURCE_PERMISSION_ERROR_MSG.getValue());
		
		return hasPermission;
		
	}
	
	public boolean checkResourcePermission(long groupId,long primaryKey,String resourceName,String actionKey) throws ResourceActionsException {
		
		PermissionChecker permissionChecker = PermissionThreadLocal.getPermissionChecker();
		
		boolean hasPermission = permissionChecker.hasPermission(groupId, resourceName, primaryKey, actionKey);
		
		if(!hasPermission)
			throw new ResourceActionsException(PermissionCheckerConstants.NO_RESOURCE_PERMISSION_ERROR_MSG.getValue());
		
		return hasPermission;
	}

	/**
	 * 
	 * @param themeDisplay
	 * @param primaryKey
	 * @param resourceName
	 * @return
	 * @throws ResourceActionsException
	 * 
	 * @deprecated(version = 1.0.0, Since better utility method added hence deprication, this can be used when used remove from deprication)
	 */
	@Deprecated
	public boolean checkResourcePermission(ThemeDisplay themeDisplay,long primaryKey,String resourceName) throws ResourceActionsException {
		
		PermissionChecker permissionChecker = themeDisplay.getPermissionChecker();
		
		boolean hasPermission = permissionChecker.hasPermission(themeDisplay.getScopeGroupId(), resourceName, primaryKey, ActionKeys.VIEW);
		
		if(!hasPermission)
			throw new ResourceActionsException(PermissionCheckerConstants.NO_RESOURCE_PERMISSION_ERROR_MSG.getValue());
		
		return hasPermission;
		
	}
	
	private PermissionChecker getPermissionChecker() {
		return PermissionThreadLocal.getPermissionChecker();
	}
}
