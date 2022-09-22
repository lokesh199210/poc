/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.honda.external.db.sb.service.impl;

import com.honda.external.db.sb.model.PubAccessMappingRef;
import com.honda.external.db.sb.service.base.PubAccessMappingRefLocalServiceBaseImpl;

import com.liferay.portal.aop.AopService;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the pub access mapping ref local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.honda.external.db.sb.service.PubAccessMappingRefLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PubAccessMappingRefLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.honda.external.db.sb.model.PubAccessMappingRef",
	service = AopService.class
)
public class PubAccessMappingRefLocalServiceImpl
	extends PubAccessMappingRefLocalServiceBaseImpl {

	/**
	 * 
	 * @param ahmcAppCode
	 * @param division
	 * @return
	 */
	public PubAccessMappingRef getByAppCode(String ahmc_app_code,String division){
		return pubAccessMappingRefPersistence.fetchByahmc_division(ahmc_app_code, division);
}
	}