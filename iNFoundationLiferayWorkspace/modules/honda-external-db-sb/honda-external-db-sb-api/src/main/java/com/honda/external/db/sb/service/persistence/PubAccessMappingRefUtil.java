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

import com.honda.external.db.sb.model.PubAccessMappingRef;

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
 * The persistence utility for the pub access mapping ref service. This utility wraps <code>com.honda.external.db.sb.service.persistence.impl.PubAccessMappingRefPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PubAccessMappingRefPersistence
 * @generated
 */
public class PubAccessMappingRefUtil {

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
	public static void clearCache(PubAccessMappingRef pubAccessMappingRef) {
		getPersistence().clearCache(pubAccessMappingRef);
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
	public static Map<Serializable, PubAccessMappingRef> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<PubAccessMappingRef> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<PubAccessMappingRef> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<PubAccessMappingRef> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<PubAccessMappingRef> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static PubAccessMappingRef update(
		PubAccessMappingRef pubAccessMappingRef) {

		return getPersistence().update(pubAccessMappingRef);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static PubAccessMappingRef update(
		PubAccessMappingRef pubAccessMappingRef,
		ServiceContext serviceContext) {

		return getPersistence().update(pubAccessMappingRef, serviceContext);
	}

	/**
	 * Returns the pub access mapping ref where ahmc_app_code = &#63; and division = &#63; or throws a <code>NoSuchPubAccessMappingRefException</code> if it could not be found.
	 *
	 * @param ahmc_app_code the ahmc_app_code
	 * @param division the division
	 * @return the matching pub access mapping ref
	 * @throws NoSuchPubAccessMappingRefException if a matching pub access mapping ref could not be found
	 */
	public static PubAccessMappingRef findByahmc_division(
			String ahmc_app_code, String division)
		throws com.honda.external.db.sb.exception.
			NoSuchPubAccessMappingRefException {

		return getPersistence().findByahmc_division(ahmc_app_code, division);
	}

	/**
	 * Returns the pub access mapping ref where ahmc_app_code = &#63; and division = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param ahmc_app_code the ahmc_app_code
	 * @param division the division
	 * @return the matching pub access mapping ref, or <code>null</code> if a matching pub access mapping ref could not be found
	 */
	public static PubAccessMappingRef fetchByahmc_division(
		String ahmc_app_code, String division) {

		return getPersistence().fetchByahmc_division(ahmc_app_code, division);
	}

	/**
	 * Returns the pub access mapping ref where ahmc_app_code = &#63; and division = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param ahmc_app_code the ahmc_app_code
	 * @param division the division
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching pub access mapping ref, or <code>null</code> if a matching pub access mapping ref could not be found
	 */
	public static PubAccessMappingRef fetchByahmc_division(
		String ahmc_app_code, String division, boolean useFinderCache) {

		return getPersistence().fetchByahmc_division(
			ahmc_app_code, division, useFinderCache);
	}

	/**
	 * Removes the pub access mapping ref where ahmc_app_code = &#63; and division = &#63; from the database.
	 *
	 * @param ahmc_app_code the ahmc_app_code
	 * @param division the division
	 * @return the pub access mapping ref that was removed
	 */
	public static PubAccessMappingRef removeByahmc_division(
			String ahmc_app_code, String division)
		throws com.honda.external.db.sb.exception.
			NoSuchPubAccessMappingRefException {

		return getPersistence().removeByahmc_division(ahmc_app_code, division);
	}

	/**
	 * Returns the number of pub access mapping refs where ahmc_app_code = &#63; and division = &#63;.
	 *
	 * @param ahmc_app_code the ahmc_app_code
	 * @param division the division
	 * @return the number of matching pub access mapping refs
	 */
	public static int countByahmc_division(
		String ahmc_app_code, String division) {

		return getPersistence().countByahmc_division(ahmc_app_code, division);
	}

	/**
	 * Caches the pub access mapping ref in the entity cache if it is enabled.
	 *
	 * @param pubAccessMappingRef the pub access mapping ref
	 */
	public static void cacheResult(PubAccessMappingRef pubAccessMappingRef) {
		getPersistence().cacheResult(pubAccessMappingRef);
	}

	/**
	 * Caches the pub access mapping refs in the entity cache if it is enabled.
	 *
	 * @param pubAccessMappingRefs the pub access mapping refs
	 */
	public static void cacheResult(
		List<PubAccessMappingRef> pubAccessMappingRefs) {

		getPersistence().cacheResult(pubAccessMappingRefs);
	}

	/**
	 * Creates a new pub access mapping ref with the primary key. Does not add the pub access mapping ref to the database.
	 *
	 * @param pub_ref_id the primary key for the new pub access mapping ref
	 * @return the new pub access mapping ref
	 */
	public static PubAccessMappingRef create(long pub_ref_id) {
		return getPersistence().create(pub_ref_id);
	}

	/**
	 * Removes the pub access mapping ref with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param pub_ref_id the primary key of the pub access mapping ref
	 * @return the pub access mapping ref that was removed
	 * @throws NoSuchPubAccessMappingRefException if a pub access mapping ref with the primary key could not be found
	 */
	public static PubAccessMappingRef remove(long pub_ref_id)
		throws com.honda.external.db.sb.exception.
			NoSuchPubAccessMappingRefException {

		return getPersistence().remove(pub_ref_id);
	}

	public static PubAccessMappingRef updateImpl(
		PubAccessMappingRef pubAccessMappingRef) {

		return getPersistence().updateImpl(pubAccessMappingRef);
	}

	/**
	 * Returns the pub access mapping ref with the primary key or throws a <code>NoSuchPubAccessMappingRefException</code> if it could not be found.
	 *
	 * @param pub_ref_id the primary key of the pub access mapping ref
	 * @return the pub access mapping ref
	 * @throws NoSuchPubAccessMappingRefException if a pub access mapping ref with the primary key could not be found
	 */
	public static PubAccessMappingRef findByPrimaryKey(long pub_ref_id)
		throws com.honda.external.db.sb.exception.
			NoSuchPubAccessMappingRefException {

		return getPersistence().findByPrimaryKey(pub_ref_id);
	}

	/**
	 * Returns the pub access mapping ref with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param pub_ref_id the primary key of the pub access mapping ref
	 * @return the pub access mapping ref, or <code>null</code> if a pub access mapping ref with the primary key could not be found
	 */
	public static PubAccessMappingRef fetchByPrimaryKey(long pub_ref_id) {
		return getPersistence().fetchByPrimaryKey(pub_ref_id);
	}

	/**
	 * Returns all the pub access mapping refs.
	 *
	 * @return the pub access mapping refs
	 */
	public static List<PubAccessMappingRef> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the pub access mapping refs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PubAccessMappingRefModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of pub access mapping refs
	 * @param end the upper bound of the range of pub access mapping refs (not inclusive)
	 * @return the range of pub access mapping refs
	 */
	public static List<PubAccessMappingRef> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the pub access mapping refs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PubAccessMappingRefModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of pub access mapping refs
	 * @param end the upper bound of the range of pub access mapping refs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of pub access mapping refs
	 */
	public static List<PubAccessMappingRef> findAll(
		int start, int end,
		OrderByComparator<PubAccessMappingRef> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the pub access mapping refs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PubAccessMappingRefModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of pub access mapping refs
	 * @param end the upper bound of the range of pub access mapping refs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of pub access mapping refs
	 */
	public static List<PubAccessMappingRef> findAll(
		int start, int end,
		OrderByComparator<PubAccessMappingRef> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the pub access mapping refs from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of pub access mapping refs.
	 *
	 * @return the number of pub access mapping refs
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static PubAccessMappingRefPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<PubAccessMappingRefPersistence, PubAccessMappingRefPersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			PubAccessMappingRefPersistence.class);

		ServiceTracker
			<PubAccessMappingRefPersistence, PubAccessMappingRefPersistence>
				serviceTracker =
					new ServiceTracker
						<PubAccessMappingRefPersistence,
						 PubAccessMappingRefPersistence>(
							 bundle.getBundleContext(),
							 PubAccessMappingRefPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}