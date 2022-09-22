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
 * Provides a wrapper for {@link DocMigrationRefLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see DocMigrationRefLocalService
 * @generated
 */
public class DocMigrationRefLocalServiceWrapper
	implements DocMigrationRefLocalService,
			   ServiceWrapper<DocMigrationRefLocalService> {

	public DocMigrationRefLocalServiceWrapper(
		DocMigrationRefLocalService docMigrationRefLocalService) {

		_docMigrationRefLocalService = docMigrationRefLocalService;
	}

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
	@Override
	public com.honda.external.db.sb.model.DocMigrationRef addDocMigrationRef(
		com.honda.external.db.sb.model.DocMigrationRef docMigrationRef) {

		return _docMigrationRefLocalService.addDocMigrationRef(docMigrationRef);
	}

	/**
	 * Creates a new doc migration ref with the primary key. Does not add the doc migration ref to the database.
	 *
	 * @param mig_ref_id the primary key for the new doc migration ref
	 * @return the new doc migration ref
	 */
	@Override
	public com.honda.external.db.sb.model.DocMigrationRef createDocMigrationRef(
		long mig_ref_id) {

		return _docMigrationRefLocalService.createDocMigrationRef(mig_ref_id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _docMigrationRefLocalService.createPersistedModel(primaryKeyObj);
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
	@Override
	public com.honda.external.db.sb.model.DocMigrationRef deleteDocMigrationRef(
		com.honda.external.db.sb.model.DocMigrationRef docMigrationRef) {

		return _docMigrationRefLocalService.deleteDocMigrationRef(
			docMigrationRef);
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
	@Override
	public com.honda.external.db.sb.model.DocMigrationRef deleteDocMigrationRef(
			long mig_ref_id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _docMigrationRefLocalService.deleteDocMigrationRef(mig_ref_id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _docMigrationRefLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _docMigrationRefLocalService.dynamicQuery();
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

		return _docMigrationRefLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _docMigrationRefLocalService.dynamicQuery(
			dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _docMigrationRefLocalService.dynamicQuery(
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

		return _docMigrationRefLocalService.dynamicQueryCount(dynamicQuery);
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

		return _docMigrationRefLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.honda.external.db.sb.model.DocMigrationRef fetchDocMigrationRef(
		long mig_ref_id) {

		return _docMigrationRefLocalService.fetchDocMigrationRef(mig_ref_id);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _docMigrationRefLocalService.getActionableDynamicQuery();
	}

	/**
	 * @param ahmcAppCode
	 * @param division
	 * @return
	 */
	@Override
	public com.honda.external.db.sb.model.DocMigrationRef getByAppCode(
		String ahmcAppCode, String division) {

		return _docMigrationRefLocalService.getByAppCode(ahmcAppCode, division);
	}

	/**
	 * @param ahmcAppCode
	 * @param division
	 * @param department
	 * @return
	 */
	@Override
	public com.honda.external.db.sb.model.DocMigrationRef
		getByAppCodeDivisionNDepart(
			String ahmcAppCode, String division, String department) {

		return _docMigrationRefLocalService.getByAppCodeDivisionNDepart(
			ahmcAppCode, division, department);
	}

	/**
	 * Returns the doc migration ref with the primary key.
	 *
	 * @param mig_ref_id the primary key of the doc migration ref
	 * @return the doc migration ref
	 * @throws PortalException if a doc migration ref with the primary key could not be found
	 */
	@Override
	public com.honda.external.db.sb.model.DocMigrationRef getDocMigrationRef(
			long mig_ref_id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _docMigrationRefLocalService.getDocMigrationRef(mig_ref_id);
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
	@Override
	public java.util.List<com.honda.external.db.sb.model.DocMigrationRef>
		getDocMigrationRefs(int start, int end) {

		return _docMigrationRefLocalService.getDocMigrationRefs(start, end);
	}

	/**
	 * Returns the number of doc migration refs.
	 *
	 * @return the number of doc migration refs
	 */
	@Override
	public int getDocMigrationRefsCount() {
		return _docMigrationRefLocalService.getDocMigrationRefsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _docMigrationRefLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _docMigrationRefLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _docMigrationRefLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public com.honda.external.db.sb.model.DocMigrationRef updateDocMigrationRef(
		com.honda.external.db.sb.model.DocMigrationRef docMigrationRef) {

		return _docMigrationRefLocalService.updateDocMigrationRef(
			docMigrationRef);
	}

	@Override
	public DocMigrationRefLocalService getWrappedService() {
		return _docMigrationRefLocalService;
	}

	@Override
	public void setWrappedService(
		DocMigrationRefLocalService docMigrationRefLocalService) {

		_docMigrationRefLocalService = docMigrationRefLocalService;
	}

	private DocMigrationRefLocalService _docMigrationRefLocalService;

}