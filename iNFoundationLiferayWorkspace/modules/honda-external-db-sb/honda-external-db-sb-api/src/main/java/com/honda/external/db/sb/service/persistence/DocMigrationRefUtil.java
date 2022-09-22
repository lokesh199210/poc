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

package com.honda.external.db.sb.service.persistence;

import com.honda.external.db.sb.model.DocMigrationRef;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the doc migration ref service. This utility wraps <code>com.honda.external.db.sb.service.persistence.impl.DocMigrationRefPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DocMigrationRefPersistence
 * @generated
 */
public class DocMigrationRefUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(DocMigrationRef docMigrationRef) {
		getPersistence().clearCache(docMigrationRef);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, DocMigrationRef> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<DocMigrationRef> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<DocMigrationRef> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<DocMigrationRef> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<DocMigrationRef> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static DocMigrationRef update(DocMigrationRef docMigrationRef) {
		return getPersistence().update(docMigrationRef);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static DocMigrationRef update(
		DocMigrationRef docMigrationRef, ServiceContext serviceContext) {

		return getPersistence().update(docMigrationRef, serviceContext);
	}

	/**
	 * Returns the doc migration ref where ahmc_app_code = &#63; and division = &#63; or throws a <code>NoSuchDocMigrationRefException</code> if it could not be found.
	 *
	 * @param ahmc_app_code the ahmc_app_code
	 * @param division the division
	 * @return the matching doc migration ref
	 * @throws NoSuchDocMigrationRefException if a matching doc migration ref could not be found
	 */
	public static DocMigrationRef findByahmc_division(
			String ahmc_app_code, String division)
		throws com.honda.external.db.sb.exception.
			NoSuchDocMigrationRefException {

		return getPersistence().findByahmc_division(ahmc_app_code, division);
	}

	/**
	 * Returns the doc migration ref where ahmc_app_code = &#63; and division = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param ahmc_app_code the ahmc_app_code
	 * @param division the division
	 * @return the matching doc migration ref, or <code>null</code> if a matching doc migration ref could not be found
	 */
	public static DocMigrationRef fetchByahmc_division(
		String ahmc_app_code, String division) {

		return getPersistence().fetchByahmc_division(ahmc_app_code, division);
	}

	/**
	 * Returns the doc migration ref where ahmc_app_code = &#63; and division = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param ahmc_app_code the ahmc_app_code
	 * @param division the division
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching doc migration ref, or <code>null</code> if a matching doc migration ref could not be found
	 */
	public static DocMigrationRef fetchByahmc_division(
		String ahmc_app_code, String division, boolean useFinderCache) {

		return getPersistence().fetchByahmc_division(
			ahmc_app_code, division, useFinderCache);
	}

	/**
	 * Removes the doc migration ref where ahmc_app_code = &#63; and division = &#63; from the database.
	 *
	 * @param ahmc_app_code the ahmc_app_code
	 * @param division the division
	 * @return the doc migration ref that was removed
	 */
	public static DocMigrationRef removeByahmc_division(
			String ahmc_app_code, String division)
		throws com.honda.external.db.sb.exception.
			NoSuchDocMigrationRefException {

		return getPersistence().removeByahmc_division(ahmc_app_code, division);
	}

	/**
	 * Returns the number of doc migration refs where ahmc_app_code = &#63; and division = &#63;.
	 *
	 * @param ahmc_app_code the ahmc_app_code
	 * @param division the division
	 * @return the number of matching doc migration refs
	 */
	public static int countByahmc_division(
		String ahmc_app_code, String division) {

		return getPersistence().countByahmc_division(ahmc_app_code, division);
	}

	/**
	 * Returns the doc migration ref where ahmc_app_code = &#63; and division = &#63; and department = &#63; or throws a <code>NoSuchDocMigrationRefException</code> if it could not be found.
	 *
	 * @param ahmc_app_code the ahmc_app_code
	 * @param division the division
	 * @param department the department
	 * @return the matching doc migration ref
	 * @throws NoSuchDocMigrationRefException if a matching doc migration ref could not be found
	 */
	public static DocMigrationRef findByahmc_divi_depart(
			String ahmc_app_code, String division, String department)
		throws com.honda.external.db.sb.exception.
			NoSuchDocMigrationRefException {

		return getPersistence().findByahmc_divi_depart(
			ahmc_app_code, division, department);
	}

	/**
	 * Returns the doc migration ref where ahmc_app_code = &#63; and division = &#63; and department = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param ahmc_app_code the ahmc_app_code
	 * @param division the division
	 * @param department the department
	 * @return the matching doc migration ref, or <code>null</code> if a matching doc migration ref could not be found
	 */
	public static DocMigrationRef fetchByahmc_divi_depart(
		String ahmc_app_code, String division, String department) {

		return getPersistence().fetchByahmc_divi_depart(
			ahmc_app_code, division, department);
	}

	/**
	 * Returns the doc migration ref where ahmc_app_code = &#63; and division = &#63; and department = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param ahmc_app_code the ahmc_app_code
	 * @param division the division
	 * @param department the department
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching doc migration ref, or <code>null</code> if a matching doc migration ref could not be found
	 */
	public static DocMigrationRef fetchByahmc_divi_depart(
		String ahmc_app_code, String division, String department,
		boolean useFinderCache) {

		return getPersistence().fetchByahmc_divi_depart(
			ahmc_app_code, division, department, useFinderCache);
	}

	/**
	 * Removes the doc migration ref where ahmc_app_code = &#63; and division = &#63; and department = &#63; from the database.
	 *
	 * @param ahmc_app_code the ahmc_app_code
	 * @param division the division
	 * @param department the department
	 * @return the doc migration ref that was removed
	 */
	public static DocMigrationRef removeByahmc_divi_depart(
			String ahmc_app_code, String division, String department)
		throws com.honda.external.db.sb.exception.
			NoSuchDocMigrationRefException {

		return getPersistence().removeByahmc_divi_depart(
			ahmc_app_code, division, department);
	}

	/**
	 * Returns the number of doc migration refs where ahmc_app_code = &#63; and division = &#63; and department = &#63;.
	 *
	 * @param ahmc_app_code the ahmc_app_code
	 * @param division the division
	 * @param department the department
	 * @return the number of matching doc migration refs
	 */
	public static int countByahmc_divi_depart(
		String ahmc_app_code, String division, String department) {

		return getPersistence().countByahmc_divi_depart(
			ahmc_app_code, division, department);
	}

	/**
	 * Caches the doc migration ref in the entity cache if it is enabled.
	 *
	 * @param docMigrationRef the doc migration ref
	 */
	public static void cacheResult(DocMigrationRef docMigrationRef) {
		getPersistence().cacheResult(docMigrationRef);
	}

	/**
	 * Caches the doc migration refs in the entity cache if it is enabled.
	 *
	 * @param docMigrationRefs the doc migration refs
	 */
	public static void cacheResult(List<DocMigrationRef> docMigrationRefs) {
		getPersistence().cacheResult(docMigrationRefs);
	}

	/**
	 * Creates a new doc migration ref with the primary key. Does not add the doc migration ref to the database.
	 *
	 * @param mig_ref_id the primary key for the new doc migration ref
	 * @return the new doc migration ref
	 */
	public static DocMigrationRef create(long mig_ref_id) {
		return getPersistence().create(mig_ref_id);
	}

	/**
	 * Removes the doc migration ref with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param mig_ref_id the primary key of the doc migration ref
	 * @return the doc migration ref that was removed
	 * @throws NoSuchDocMigrationRefException if a doc migration ref with the primary key could not be found
	 */
	public static DocMigrationRef remove(long mig_ref_id)
		throws com.honda.external.db.sb.exception.
			NoSuchDocMigrationRefException {

		return getPersistence().remove(mig_ref_id);
	}

	public static DocMigrationRef updateImpl(DocMigrationRef docMigrationRef) {
		return getPersistence().updateImpl(docMigrationRef);
	}

	/**
	 * Returns the doc migration ref with the primary key or throws a <code>NoSuchDocMigrationRefException</code> if it could not be found.
	 *
	 * @param mig_ref_id the primary key of the doc migration ref
	 * @return the doc migration ref
	 * @throws NoSuchDocMigrationRefException if a doc migration ref with the primary key could not be found
	 */
	public static DocMigrationRef findByPrimaryKey(long mig_ref_id)
		throws com.honda.external.db.sb.exception.
			NoSuchDocMigrationRefException {

		return getPersistence().findByPrimaryKey(mig_ref_id);
	}

	/**
	 * Returns the doc migration ref with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param mig_ref_id the primary key of the doc migration ref
	 * @return the doc migration ref, or <code>null</code> if a doc migration ref with the primary key could not be found
	 */
	public static DocMigrationRef fetchByPrimaryKey(long mig_ref_id) {
		return getPersistence().fetchByPrimaryKey(mig_ref_id);
	}

	/**
	 * Returns all the doc migration refs.
	 *
	 * @return the doc migration refs
	 */
	public static List<DocMigrationRef> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the doc migration refs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DocMigrationRefModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of doc migration refs
	 * @param end the upper bound of the range of doc migration refs (not inclusive)
	 * @return the range of doc migration refs
	 */
	public static List<DocMigrationRef> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the doc migration refs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DocMigrationRefModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of doc migration refs
	 * @param end the upper bound of the range of doc migration refs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of doc migration refs
	 */
	public static List<DocMigrationRef> findAll(
		int start, int end,
		OrderByComparator<DocMigrationRef> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the doc migration refs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DocMigrationRefModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of doc migration refs
	 * @param end the upper bound of the range of doc migration refs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of doc migration refs
	 */
	public static List<DocMigrationRef> findAll(
		int start, int end,
		OrderByComparator<DocMigrationRef> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the doc migration refs from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of doc migration refs.
	 *
	 * @return the number of doc migration refs
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static DocMigrationRefPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<DocMigrationRefPersistence, DocMigrationRefPersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			DocMigrationRefPersistence.class);

		ServiceTracker<DocMigrationRefPersistence, DocMigrationRefPersistence>
			serviceTracker =
				new ServiceTracker
					<DocMigrationRefPersistence, DocMigrationRefPersistence>(
						bundle.getBundleContext(),
						DocMigrationRefPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}