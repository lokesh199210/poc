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

import com.honda.external.db.sb.model.DocMigrationRef;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for DocMigrationRef. This utility wraps
 * <code>com.honda.external.db.sb.service.impl.DocMigrationRefLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see DocMigrationRefLocalService
 * @generated
 */
public class DocMigrationRefLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.honda.external.db.sb.service.impl.DocMigrationRefLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the doc migration ref to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DocMigrationRefLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param docMigrationRef the doc migration ref
	 * @return the doc migration ref that was added
	 */
	public static DocMigrationRef addDocMigrationRef(
		DocMigrationRef docMigrationRef) {

		return getService().addDocMigrationRef(docMigrationRef);
	}

	/**
	 * Creates a new doc migration ref with the primary key. Does not add the doc migration ref to the database.
	 *
	 * @param mig_ref_id the primary key for the new doc migration ref
	 * @return the new doc migration ref
	 */
	public static DocMigrationRef createDocMigrationRef(long mig_ref_id) {
		return getService().createDocMigrationRef(mig_ref_id);
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
	 * Deletes the doc migration ref from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DocMigrationRefLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param docMigrationRef the doc migration ref
	 * @return the doc migration ref that was removed
	 */
	public static DocMigrationRef deleteDocMigrationRef(
		DocMigrationRef docMigrationRef) {

		return getService().deleteDocMigrationRef(docMigrationRef);
	}

	/**
	 * Deletes the doc migration ref with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DocMigrationRefLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param mig_ref_id the primary key of the doc migration ref
	 * @return the doc migration ref that was removed
	 * @throws PortalException if a doc migration ref with the primary key could not be found
	 */
	public static DocMigrationRef deleteDocMigrationRef(long mig_ref_id)
		throws PortalException {

		return getService().deleteDocMigrationRef(mig_ref_id);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.honda.external.db.sb.model.impl.DocMigrationRefModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.honda.external.db.sb.model.impl.DocMigrationRefModelImpl</code>.
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

	public static DocMigrationRef fetchDocMigrationRef(long mig_ref_id) {
		return getService().fetchDocMigrationRef(mig_ref_id);
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
	public static DocMigrationRef getByAppCode(
		String ahmcAppCode, String division) {

		return getService().getByAppCode(ahmcAppCode, division);
	}

	/**
	 * @param ahmcAppCode
	 * @param division
	 * @param department
	 * @return
	 */
	public static DocMigrationRef getByAppCodeDivisionNDepart(
		String ahmcAppCode, String division, String department) {

		return getService().getByAppCodeDivisionNDepart(
			ahmcAppCode, division, department);
	}

	/**
	 * Returns the doc migration ref with the primary key.
	 *
	 * @param mig_ref_id the primary key of the doc migration ref
	 * @return the doc migration ref
	 * @throws PortalException if a doc migration ref with the primary key could not be found
	 */
	public static DocMigrationRef getDocMigrationRef(long mig_ref_id)
		throws PortalException {

		return getService().getDocMigrationRef(mig_ref_id);
	}

	/**
	 * Returns a range of all the doc migration refs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.honda.external.db.sb.model.impl.DocMigrationRefModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of doc migration refs
	 * @param end the upper bound of the range of doc migration refs (not inclusive)
	 * @return the range of doc migration refs
	 */
	public static List<DocMigrationRef> getDocMigrationRefs(
		int start, int end) {

		return getService().getDocMigrationRefs(start, end);
	}

	/**
	 * Returns the number of doc migration refs.
	 *
	 * @return the number of doc migration refs
	 */
	public static int getDocMigrationRefsCount() {
		return getService().getDocMigrationRefsCount();
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
	 * Updates the doc migration ref in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DocMigrationRefLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param docMigrationRef the doc migration ref
	 * @return the doc migration ref that was updated
	 */
	public static DocMigrationRef updateDocMigrationRef(
		DocMigrationRef docMigrationRef) {

		return getService().updateDocMigrationRef(docMigrationRef);
	}

	public static DocMigrationRefLocalService getService() {
		return _service;
	}

	private static volatile DocMigrationRefLocalService _service;

}