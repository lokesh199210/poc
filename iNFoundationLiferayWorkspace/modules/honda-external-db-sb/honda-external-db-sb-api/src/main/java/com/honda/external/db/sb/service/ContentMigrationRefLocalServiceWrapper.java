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
 * Provides a wrapper for {@link ContentMigrationRefLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ContentMigrationRefLocalService
 * @generated
 */
public class ContentMigrationRefLocalServiceWrapper
	implements ContentMigrationRefLocalService,
			   ServiceWrapper<ContentMigrationRefLocalService> {

	public ContentMigrationRefLocalServiceWrapper(
		ContentMigrationRefLocalService contentMigrationRefLocalService) {

		_contentMigrationRefLocalService = contentMigrationRefLocalService;
	}

	/**
	 * Adds the content migration ref to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ContentMigrationRefLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param contentMigrationRef the content migration ref
	 * @return the content migration ref that was added
	 */
	@Override
	public com.honda.external.db.sb.model.ContentMigrationRef
		addContentMigrationRef(
			com.honda.external.db.sb.model.ContentMigrationRef
				contentMigrationRef) {

		return _contentMigrationRefLocalService.addContentMigrationRef(
			contentMigrationRef);
	}

	/**
	 * Creates a new content migration ref with the primary key. Does not add the content migration ref to the database.
	 *
	 * @param mig_ref_id the primary key for the new content migration ref
	 * @return the new content migration ref
	 */
	@Override
	public com.honda.external.db.sb.model.ContentMigrationRef
		createContentMigrationRef(long mig_ref_id) {

		return _contentMigrationRefLocalService.createContentMigrationRef(
			mig_ref_id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _contentMigrationRefLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deletes the content migration ref from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ContentMigrationRefLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param contentMigrationRef the content migration ref
	 * @return the content migration ref that was removed
	 */
	@Override
	public com.honda.external.db.sb.model.ContentMigrationRef
		deleteContentMigrationRef(
			com.honda.external.db.sb.model.ContentMigrationRef
				contentMigrationRef) {

		return _contentMigrationRefLocalService.deleteContentMigrationRef(
			contentMigrationRef);
	}

	/**
	 * Deletes the content migration ref with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ContentMigrationRefLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param mig_ref_id the primary key of the content migration ref
	 * @return the content migration ref that was removed
	 * @throws PortalException if a content migration ref with the primary key could not be found
	 */
	@Override
	public com.honda.external.db.sb.model.ContentMigrationRef
			deleteContentMigrationRef(long mig_ref_id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _contentMigrationRefLocalService.deleteContentMigrationRef(
			mig_ref_id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _contentMigrationRefLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _contentMigrationRefLocalService.dynamicQuery();
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

		return _contentMigrationRefLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.honda.external.db.sb.model.impl.ContentMigrationRefModelImpl</code>.
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

		return _contentMigrationRefLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.honda.external.db.sb.model.impl.ContentMigrationRefModelImpl</code>.
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

		return _contentMigrationRefLocalService.dynamicQuery(
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

		return _contentMigrationRefLocalService.dynamicQueryCount(dynamicQuery);
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

		return _contentMigrationRefLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.honda.external.db.sb.model.ContentMigrationRef
		fetchContentMigrationRef(long mig_ref_id) {

		return _contentMigrationRefLocalService.fetchContentMigrationRef(
			mig_ref_id);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _contentMigrationRefLocalService.getActionableDynamicQuery();
	}

	/**
	 * @param ahmcAppCode
	 * @param division
	 * @return
	 */
	@Override
	public com.honda.external.db.sb.model.ContentMigrationRef getByAppCode(
		String ahmcAppCode, String division) {

		return _contentMigrationRefLocalService.getByAppCode(
			ahmcAppCode, division);
	}

	/**
	 * @param ahmcAppCode
	 * @param division
	 * @param department
	 * @return
	 */
	@Override
	public com.honda.external.db.sb.model.ContentMigrationRef
		getByAppCodeDivisionNDepart(
			String ahmcAppCode, String division, String department) {

		return _contentMigrationRefLocalService.getByAppCodeDivisionNDepart(
			ahmcAppCode, division, department);
	}

	/**
	 * Returns the content migration ref with the primary key.
	 *
	 * @param mig_ref_id the primary key of the content migration ref
	 * @return the content migration ref
	 * @throws PortalException if a content migration ref with the primary key could not be found
	 */
	@Override
	public com.honda.external.db.sb.model.ContentMigrationRef
			getContentMigrationRef(long mig_ref_id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _contentMigrationRefLocalService.getContentMigrationRef(
			mig_ref_id);
	}

	/**
	 * Returns a range of all the content migration refs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.honda.external.db.sb.model.impl.ContentMigrationRefModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of content migration refs
	 * @param end the upper bound of the range of content migration refs (not inclusive)
	 * @return the range of content migration refs
	 */
	@Override
	public java.util.List<com.honda.external.db.sb.model.ContentMigrationRef>
		getContentMigrationRefs(int start, int end) {

		return _contentMigrationRefLocalService.getContentMigrationRefs(
			start, end);
	}

	/**
	 * Returns the number of content migration refs.
	 *
	 * @return the number of content migration refs
	 */
	@Override
	public int getContentMigrationRefsCount() {
		return _contentMigrationRefLocalService.getContentMigrationRefsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _contentMigrationRefLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _contentMigrationRefLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _contentMigrationRefLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Updates the content migration ref in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ContentMigrationRefLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param contentMigrationRef the content migration ref
	 * @return the content migration ref that was updated
	 */
	@Override
	public com.honda.external.db.sb.model.ContentMigrationRef
		updateContentMigrationRef(
			com.honda.external.db.sb.model.ContentMigrationRef
				contentMigrationRef) {

		return _contentMigrationRefLocalService.updateContentMigrationRef(
			contentMigrationRef);
	}

	@Override
	public ContentMigrationRefLocalService getWrappedService() {
		return _contentMigrationRefLocalService;
	}

	@Override
	public void setWrappedService(
		ContentMigrationRefLocalService contentMigrationRefLocalService) {

		_contentMigrationRefLocalService = contentMigrationRefLocalService;
	}

	private ContentMigrationRefLocalService _contentMigrationRefLocalService;

}