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

import com.honda.external.db.sb.exception.NoSuchPubAccessMappingRefException;
import com.honda.external.db.sb.model.PubAccessMappingRef;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the pub access mapping ref service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PubAccessMappingRefUtil
 * @generated
 */
@ProviderType
public interface PubAccessMappingRefPersistence
	extends BasePersistence<PubAccessMappingRef> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PubAccessMappingRefUtil} to access the pub access mapping ref persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns the pub access mapping ref where ahmc_app_code = &#63; and division = &#63; or throws a <code>NoSuchPubAccessMappingRefException</code> if it could not be found.
	 *
	 * @param ahmc_app_code the ahmc_app_code
	 * @param division the division
	 * @return the matching pub access mapping ref
	 * @throws NoSuchPubAccessMappingRefException if a matching pub access mapping ref could not be found
	 */
	public PubAccessMappingRef findByahmc_division(
			String ahmc_app_code, String division)
		throws NoSuchPubAccessMappingRefException;

	/**
	 * Returns the pub access mapping ref where ahmc_app_code = &#63; and division = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param ahmc_app_code the ahmc_app_code
	 * @param division the division
	 * @return the matching pub access mapping ref, or <code>null</code> if a matching pub access mapping ref could not be found
	 */
	public PubAccessMappingRef fetchByahmc_division(
		String ahmc_app_code, String division);

	/**
	 * Returns the pub access mapping ref where ahmc_app_code = &#63; and division = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param ahmc_app_code the ahmc_app_code
	 * @param division the division
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching pub access mapping ref, or <code>null</code> if a matching pub access mapping ref could not be found
	 */
	public PubAccessMappingRef fetchByahmc_division(
		String ahmc_app_code, String division, boolean useFinderCache);

	/**
	 * Removes the pub access mapping ref where ahmc_app_code = &#63; and division = &#63; from the database.
	 *
	 * @param ahmc_app_code the ahmc_app_code
	 * @param division the division
	 * @return the pub access mapping ref that was removed
	 */
	public PubAccessMappingRef removeByahmc_division(
			String ahmc_app_code, String division)
		throws NoSuchPubAccessMappingRefException;

	/**
	 * Returns the number of pub access mapping refs where ahmc_app_code = &#63; and division = &#63;.
	 *
	 * @param ahmc_app_code the ahmc_app_code
	 * @param division the division
	 * @return the number of matching pub access mapping refs
	 */
	public int countByahmc_division(String ahmc_app_code, String division);

	/**
	 * Caches the pub access mapping ref in the entity cache if it is enabled.
	 *
	 * @param pubAccessMappingRef the pub access mapping ref
	 */
	public void cacheResult(PubAccessMappingRef pubAccessMappingRef);

	/**
	 * Caches the pub access mapping refs in the entity cache if it is enabled.
	 *
	 * @param pubAccessMappingRefs the pub access mapping refs
	 */
	public void cacheResult(
		java.util.List<PubAccessMappingRef> pubAccessMappingRefs);

	/**
	 * Creates a new pub access mapping ref with the primary key. Does not add the pub access mapping ref to the database.
	 *
	 * @param pub_ref_id the primary key for the new pub access mapping ref
	 * @return the new pub access mapping ref
	 */
	public PubAccessMappingRef create(long pub_ref_id);

	/**
	 * Removes the pub access mapping ref with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param pub_ref_id the primary key of the pub access mapping ref
	 * @return the pub access mapping ref that was removed
	 * @throws NoSuchPubAccessMappingRefException if a pub access mapping ref with the primary key could not be found
	 */
	public PubAccessMappingRef remove(long pub_ref_id)
		throws NoSuchPubAccessMappingRefException;

	public PubAccessMappingRef updateImpl(
		PubAccessMappingRef pubAccessMappingRef);

	/**
	 * Returns the pub access mapping ref with the primary key or throws a <code>NoSuchPubAccessMappingRefException</code> if it could not be found.
	 *
	 * @param pub_ref_id the primary key of the pub access mapping ref
	 * @return the pub access mapping ref
	 * @throws NoSuchPubAccessMappingRefException if a pub access mapping ref with the primary key could not be found
	 */
	public PubAccessMappingRef findByPrimaryKey(long pub_ref_id)
		throws NoSuchPubAccessMappingRefException;

	/**
	 * Returns the pub access mapping ref with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param pub_ref_id the primary key of the pub access mapping ref
	 * @return the pub access mapping ref, or <code>null</code> if a pub access mapping ref with the primary key could not be found
	 */
	public PubAccessMappingRef fetchByPrimaryKey(long pub_ref_id);

	/**
	 * Returns all the pub access mapping refs.
	 *
	 * @return the pub access mapping refs
	 */
	public java.util.List<PubAccessMappingRef> findAll();

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
	public java.util.List<PubAccessMappingRef> findAll(int start, int end);

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
	public java.util.List<PubAccessMappingRef> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PubAccessMappingRef>
			orderByComparator);

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
	public java.util.List<PubAccessMappingRef> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PubAccessMappingRef>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the pub access mapping refs from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of pub access mapping refs.
	 *
	 * @return the number of pub access mapping refs
	 */
	public int countAll();

}