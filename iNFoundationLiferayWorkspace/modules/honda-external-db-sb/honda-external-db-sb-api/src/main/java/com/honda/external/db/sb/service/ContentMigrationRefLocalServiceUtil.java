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

import com.honda.external.db.sb.model.ContentMigrationRef;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for ContentMigrationRef. This utility wraps
 * <code>com.honda.external.db.sb.service.impl.ContentMigrationRefLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see ContentMigrationRefLocalService
 * @generated
 */
public class ContentMigrationRefLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.honda.external.db.sb.service.impl.ContentMigrationRefLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

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
	public static ContentMigrationRef addContentMigrationRef(
		ContentMigrationRef contentMigrationRef) {

		return getService().addContentMigrationRef(contentMigrationRef);
	}

	/**
	 * Creates a new content migration ref with the primary key. Does not add the content migration ref to the database.
	 *
	 * @param mig_ref_id the primary key for the new content migration ref
	 * @return the new content migration ref
	 */
	public static ContentMigrationRef createContentMigrationRef(
		long mig_ref_id) {

		return getService().createContentMigrationRef(mig_ref_id);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel createPersistedModel(
			Serializable primaryKeyObj)
		throws PortalException {

		return getService().createPersistedModel(primaryKeyObj);
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
	public static ContentMigrationRef deleteContentMigrationRef(
		ContentMigrationRef contentMigrationRef) {

		return getService().deleteContentMigrationRef(contentMigrationRef);
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
	public static ContentMigrationRef deleteContentMigrationRef(long mig_ref_id)
		throws PortalException {

		return getService().deleteContentMigrationRef(mig_ref_id);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
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
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static ContentMigrationRef fetchContentMigrationRef(
		long mig_ref_id) {

		return getService().fetchContentMigrationRef(mig_ref_id);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * @param ahmcAppCode
	 * @param division
	 * @return
	 */
	public static ContentMigrationRef getByAppCode(
		String ahmcAppCode, String division) {

		return getService().getByAppCode(ahmcAppCode, division);
	}

	/**
	 * @param ahmcAppCode
	 * @param division
	 * @param department
	 * @return
	 */
	public static ContentMigrationRef getByAppCodeDivisionNDepart(
		String ahmcAppCode, String division, String department) {

		return getService().getByAppCodeDivisionNDepart(
			ahmcAppCode, division, department);
	}

	/**
	 * Returns the content migration ref with the primary key.
	 *
	 * @param mig_ref_id the primary key of the content migration ref
	 * @return the content migration ref
	 * @throws PortalException if a content migration ref with the primary key could not be found
	 */
	public static ContentMigrationRef getContentMigrationRef(long mig_ref_id)
		throws PortalException {

		return getService().getContentMigrationRef(mig_ref_id);
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
	public static List<ContentMigrationRef> getContentMigrationRefs(
		int start, int end) {

		return getService().getContentMigrationRefs(start, end);
	}

	/**
	 * Returns the number of content migration refs.
	 *
	 * @return the number of content migration refs
	 */
	public static int getContentMigrationRefsCount() {
		return getService().getContentMigrationRefsCount();
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return getService().getPersistedModel(primaryKeyObj);
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
	public static ContentMigrationRef updateContentMigrationRef(
		ContentMigrationRef contentMigrationRef) {

		return getService().updateContentMigrationRef(contentMigrationRef);
	}

	public static ContentMigrationRefLocalService getService() {
		return _service;
	}

	private static volatile ContentMigrationRefLocalService _service;

}