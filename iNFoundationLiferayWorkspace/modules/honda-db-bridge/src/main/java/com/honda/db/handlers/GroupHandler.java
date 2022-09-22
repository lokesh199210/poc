package com.honda.db.handlers;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.NoSuchGroupException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.util.Validator;

import java.util.List;
import java.util.stream.Collectors;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * 
 * Class to handle Group related operation like fetching group by name, default group etc.
 * 
 * @author Lokesh Sharma
 *
 */
@Component(
	immediate = true,
	service = GroupHandler.class
)
public class GroupHandler {
	
	/**
	 * 
	 * Method to get Group by primary key
	 * 
	 * @param groupId
	 * @return
	 * @throws PortalException
	 */
	public Group getById(long groupId) throws PortalException {
		
		return groupLocalService.getGroup(groupId);
	}

	/**
	 * 
	 * Method to get Group by division - Division (Honda) is equvalent to Site inside Liferay
	 * 
	 * @param division
	 * @return
	 * @throws NoSuchGroupException
	 */
	public Group getByDivision(String division) throws NoSuchGroupException {
		
		DynamicQuery dynamicQuery = groupLocalService.dynamicQuery();
		
		dynamicQuery.add(RestrictionsFactoryUtil.ilike("name", StringPool.PERCENT + division + StringPool.PERCENT));
		
		List<Group> groups = groupLocalService.dynamicQuery(dynamicQuery);
		
		if(Validator.isNull(groups) || groups.isEmpty())
			throw new NoSuchGroupException("No mapping publication found for requested AHMC app code");
		
		Group group = groups.stream().findFirst().orElse(null);
		
		if(Validator.isNull(group))
			throw new NoSuchGroupException("No mapping publication found for requested AHMC app code");
		
		return group;
		
	}
	
	/**
	 * 
	 * Method to get Group by division - Division (Honda) is equvalent to Site inside Liferay
	 * 
	 * @param division
	 * @return
	 * @throws NoSuchGroupException
	 */
	public Group getAssetLibrary(String assetLibrary) throws NoSuchGroupException {
		
		DynamicQuery dynamicQuery = groupLocalService.dynamicQuery();
		
		dynamicQuery.add(RestrictionsFactoryUtil.ilike("groupKey", StringPool.PERCENT + assetLibrary +StringPool.PERCENT));
		
		List<Group> groups = groupLocalService.dynamicQuery(dynamicQuery);
		
		if(Validator.isNull(groups) || groups.isEmpty())
			throw new NoSuchGroupException("No mapping publication found for requested AHMC app code");
		
		Group group = groups.stream().findFirst().orElse(null);
		
		if(Validator.isNull(group))
			throw new NoSuchGroupException("No mapping publication found for requested AHMC app code");
		
		return group;
		
	}
	
	/**
	 * 
	 * Method to get Honda Global Site created inside Liferay
	 * 
	 * @return
	 * @throws NoSuchGroupException
	 */
	public Group getHondalGlobalGrp() throws NoSuchGroupException {
		
		DynamicQuery dynamicQuery = groupLocalService.dynamicQuery();
		
		dynamicQuery.add(RestrictionsFactoryUtil.ilike("name", StringPool.PERCENT + "Honda Global" + StringPool.PERCENT));
		
		List<Group> groups = groupLocalService.dynamicQuery(dynamicQuery);
		
		if(Validator.isNull(groups) || groups.isEmpty())
			throw new NoSuchGroupException("Invalid division, please check the details entered.");
		
		Group group = groups.stream().findFirst().orElse(null);
		
		if(Validator.isNull(group))
			throw new NoSuchGroupException("Invalid division, please check the details entered.");
		
		return group;
		
	}
	
	/**
	 * 
	 * Method to get Honda Global Site created inside Liferay
	 * 
	 * @return
	 * @throws NoSuchGroupException
	 */
	public Group getLiferayGlobalGrp() throws NoSuchGroupException {
		
		DynamicQuery dynamicQuery = groupLocalService.dynamicQuery();
		
		dynamicQuery.add(RestrictionsFactoryUtil.ilike("name", StringPool.PERCENT + "Global" + StringPool.PERCENT));
		
		List<Group> groups = groupLocalService.dynamicQuery(dynamicQuery);
		
		if(Validator.isNull(groups) || groups.isEmpty())
			throw new NoSuchGroupException("Invalid division, please check the details entered.");
		
		Group group = groups.stream().findFirst().orElse(null);
		
		if(Validator.isNull(group))
			throw new NoSuchGroupException("Invalid division, please check the details entered.");
		
		return group;
		
	}
	
	public List <Group> getSites() throws NoSuchGroupException {
		
		DynamicQuery dynamicQuery = groupLocalService.dynamicQuery();
		
		dynamicQuery.add(RestrictionsFactoryUtil.eq("site", true));

		List<Group> groups = groupLocalService.dynamicQuery(dynamicQuery);
		
		if (Validator.isNull(groups) || groups.isEmpty())
			throw new NoSuchGroupException("No groups found !!");
		
		return (groups.stream().filter(gp -> gp.getGroupKey().contains("LFR_ORGANIZATION"))).collect(Collectors.toList());
	}
	
	@Reference
	private GroupLocalService groupLocalService;
}
