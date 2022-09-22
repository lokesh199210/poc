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

package com.honda.external.db.sb.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link PubAccessMappingRefLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see PubAccessMappingRefLocalService
 * @generated
 */
public class PubAccessMappingRefLocalServiceWrapper
	implements PubAccessMappingRefLocalService,
			   ServiceWrapper<PubAccessMappingRefLocalService> {

	public PubAccessMappingRefLocalServiceWrapper(
		PubAccessMappingRefLocalService pubAccessMappingRefLocalService) {

		_pubAccessMappingRefLocalService = pubAccessMappingRefLocalService;
	}

	/**
	 * Adds the pub access mapping ref to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PubAccessMappingRefLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param pubAccessMappingRef the pub access mapping ref
	 * @return the pub access mapping ref that was added
	 */
	@Override
	public com.honda.external.db.sb.model.PubAccessMappingRef
		addPubAccessMappingRef(
			com.honda.external.db.sb.model.PubAccessMappingRef
				pubAccessMappingRef) {

		return _pubAccessMappingRefLocalService.addPubAccessMappingRef(
			pubAccessMappingRef);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _pubAccessMappingRefLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Creates a new pub access mapping ref with the primary key. Does not add the pub access mapping ref to the database.
	 *
	 * @param pub_ref_id the primary key for the new pub access mapping ref
	 * @return the new pub access mapping ref
	 */
	@Override
	public com.honda.external.db.sb.model.PubAccessMappingRef
		createPubAccessMappingRef(long pub_ref_id) {

		return _pubAccessMappingRefLocalService.createPubAccessMappingRef(
			pub_ref_id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _pubAccessMappingRefLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the pub access mapping ref with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PubAccessMappingRefLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param pub_ref_id the primary key of the pub access mapping ref
	 * @return the pub access mapping ref that was removed
	 * @throws PortalException if a pub access mapping ref with the primary key could not be found
	 */
	@Override
	public com.honda.external.db.sb.model.PubAccessMappingRef
			deletePubAccessMappingRef(long pub_ref_id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _pubAccessMappingRefLocalService.deletePubAccessMappingRef(
			pub_ref_id);
	}

	/**
	 * Deletes the pub access mapping ref from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PubAccessMappingRefLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param pubAccessMappingRef the pub access mapping ref
	 * @return the pub access mapping ref that was removed
	 */
	@Override
	public com.honda.external.db.sb.model.PubAccessMappingRef
		deletePubAccessMappingRef(
			com.honda.external.db.sb.model.PubAccessMappingRef
				pubAccessMappingRef) {

		return _pubAccessMappingRefLocalService.deletePubAccessMappingRef(
			pubAccessMappingRef);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _pubAccessMappingRefLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _pubAccessMappingRefLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.honda.external.db.sb.model.impl.PubAccessMappingRefModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _pubAccessMappingRefLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.honda.external.db.sb.model.impl.PubAccessMappingRefModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _pubAccessMappingRefLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _pubAccessMappingRefLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _pubAccessMappingRefLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.honda.external.db.sb.model.PubAccessMappingRef
		fetchPubAccessMappingRef(long pub_ref_id) {

		return _pubAccessMappingRefLocalService.fetchPubAccessMappingRef(
			pub_ref_id);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _pubAccessMappingRefLocalService.getActionableDynamicQuery();
	}

	/**
	 * @param ahmcAppCode
	 * @param division
	 * @return
	 */
	@Override
	public com.honda.external.db.sb.model.PubAccessMappingRef getByAppCode(
		String ahmc_app_code, String division) {

		return _pubAccessMappingRefLocalService.getByAppCode(
			ahmc_app_code, division);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _pubAccessMappingRefLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _pubAccessMappingRefLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _pubAccessMappingRefLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Returns the pub access mapping ref with the primary key.
	 *
	 * @param pub_ref_id the primary key of the pub access mapping ref
	 * @return the pub access mapping ref
	 * @throws PortalException if a pub access mapping ref with the primary key could not be found
	 */
	@Override
	public com.honda.external.db.sb.model.PubAccessMappingRef
			getPubAccessMappingRef(long pub_ref_id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _pubAccessMappingRefLocalService.getPubAccessMappingRef(
			pub_ref_id);
	}

	/**
	 * Returns a range of all the pub access mapping refs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.honda.external.db.sb.model.impl.PubAccessMappingRefModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of pub access mapping refs
	 * @param end the upper bound of the range of pub access mapping refs (not inclusive)
	 * @return the range of pub access mapping refs
	 */
	@Override
	public java.util.List<com.honda.external.db.sb.model.PubAccessMappingRef>
		getPubAccessMappingRefs(int start, int end) {

		return _pubAccessMappingRefLocalService.getPubAccessMappingRefs(
			start, end);
	}

	/**
	 * Returns the number of pub access mapping refs.
	 *
	 * @return the number of pub access mapping refs
	 */
	@Override
	public int getPubAccessMappingRefsCount() {
		return _pubAccessMappingRefLocalService.getPubAccessMappingRefsCount();
	}

	/**
	 * Updates the pub access mapping ref in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PubAccessMappingRefLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param pubAccessMappingRef the pub access mapping ref
	 * @return the pub access mapping ref that was updated
	 */
	@Override
	public com.honda.external.db.sb.model.PubAccessMappingRef
		updatePubAccessMappingRef(
			com.honda.external.db.sb.model.PubAccessMappingRef
				pubAccessMappingRef) {

		return _pubAccessMappingRefLocalService.updatePubAccessMappingRef(
			pubAccessMappingRef);
	}

	@Override
	public PubAccessMappingRefLocalService getWrappedService() {
		return _pubAccessMappingRefLocalService;
	}

	@Override
	public void setWrappedService(
		PubAccessMappingRefLocalService pubAccessMappingRefLocalService) {

		_pubAccessMappingRefLocalService = pubAccessMappingRefLocalService;
	}

	private PubAccessMappingRefLocalService _pubAccessMappingRefLocalService;

}