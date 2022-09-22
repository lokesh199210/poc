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

import com.honda.external.db.sb.exception.NoSuchContentMigrationRefException;
import com.honda.external.db.sb.model.ContentMigrationRef;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the content migration ref service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ContentMigrationRefUtil
 * @generated
 */
@ProviderType
public interface ContentMigrationRefPersistence
	extends BasePersistence<ContentMigrationRef> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ContentMigrationRefUtil} to access the content migration ref persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns the content migration ref where ahmc_app_code = &#63; and division = &#63; or throws a <code>NoSuchContentMigrationRefException</code> if it could not be found.
	 *
	 * @param ahmc_app_code the ahmc_app_code
	 * @param division the division
	 * @return the matching content migration ref
	 * @throws NoSuchContentMigrationRefException if a matching content migration ref could not be found
	 */
	public ContentMigrationRef findByahmc_division(
			String ahmc_app_code, String division)
		throws NoSuchContentMigrationRefException;

	/**
	 * Returns the content migration ref where ahmc_app_code = &#63; and division = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param ahmc_app_code the ahmc_app_code
	 * @param division the division
	 * @return the matching content migration ref, or <code>null</code> if a matching content migration ref could not be found
	 */
	public ContentMigrationRef fetchByahmc_division(
		String ahmc_app_code, String division);

	/**
	 * Returns the content migration ref where ahmc_app_code = &#63; and division = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param ahmc_app_code the ahmc_app_code
	 * @param division the division
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching content migration ref, or <code>null</code> if a matching content migration ref could not be found
	 */
	public ContentMigrationRef fetchByahmc_division(
		String ahmc_app_code, String division, boolean useFinderCache);

	/**
	 * Removes the content migration ref where ahmc_app_code = &#63; and division = &#63; from the database.
	 *
	 * @param ahmc_app_code the ahmc_app_code
	 * @param division the division
	 * @return the content migration ref that was removed
	 */
	public ContentMigrationRef removeByahmc_division(
			String ahmc_app_code, String division)
		throws NoSuchContentMigrationRefException;

	/**
	 * Returns the number of content migration refs where ahmc_app_code = &#63; and division = &#63;.
	 *
	 * @param ahmc_app_code the ahmc_app_code
	 * @param division the division
	 * @return the number of matching content migration refs
	 */
	public int countByahmc_division(String ahmc_app_code, String division);

	/**
	 * Returns the content migration ref where ahmc_app_code = &#63; and division = &#63; and department = &#63; or throws a <code>NoSuchContentMigrationRefException</code> if it could not be found.
	 *
	 * @param ahmc_app_code the ahmc_app_code
	 * @param division the division
	 * @param department the department
	 * @return the matching content migration ref
	 * @throws NoSuchContentMigrationRefException if a matching content migration ref could not be found
	 */
	public ContentMigrationRef findByahmc_divi_depart(
			String ahmc_app_code, String division, String department)
		throws NoSuchContentMigrationRefException;

	/**
	 * Returns the content migration ref where ahmc_app_code = &#63; and division = &#63; and department = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param ahmc_app_code the ahmc_app_code
	 * @param division the division
	 * @param department the department
	 * @return the matching content migration ref, or <code>null</code> if a matching content migration ref could not be found
	 */
	public ContentMigrationRef fetchByahmc_divi_depart(
		String ahmc_app_code, String division, String department);

	/**
	 * Returns the content migration ref where ahmc_app_code = &#63; and division = &#63; and department = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param ahmc_app_code the ahmc_app_code
	 * @param division the division
	 * @param department the department
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching content migration ref, or <code>null</code> if a matching content migration ref could not be found
	 */
	public ContentMigrationRef fetchByahmc_divi_depart(
		String ahmc_app_code, String division, String department,
		boolean useFinderCache);

	/**
	 * Removes the content migration ref where ahmc_app_code = &#63; and division = &#63; and department = &#63; from the database.
	 *
	 * @param ahmc_app_code the ahmc_app_code
	 * @param division the division
	 * @param department the department
	 * @return the content migration ref that was removed
	 */
	public ContentMigrationRef removeByahmc_divi_depart(
			String ahmc_app_code, String division, String department)
		throws NoSuchContentMigrationRefException;

	/**
	 * Returns the number of content migration refs where ahmc_app_code = &#63; and division = &#63; and department = &#63;.
	 *
	 * @param ahmc_app_code the ahmc_app_code
	 * @param division the division
	 * @param department the department
	 * @return the number of matching content migration refs
	 */
	public int countByahmc_divi_depart(
		String ahmc_app_code, String division, String department);

	/**
	 * Caches the content migration ref in the entity cache if it is enabled.
	 *
	 * @param contentMigrationRef the content migration ref
	 */
	public void cacheResult(ContentMigrationRef contentMigrationRef);

	/**
	 * Caches the content migration refs in the entity cache if it is enabled.
	 *
	 * @param contentMigrationRefs the content migration refs
	 */
	public void cacheResult(
		java.util.List<ContentMigrationRef> contentMigrationRefs);

	/**
	 * Creates a new content migration ref with the primary key. Does not add the content migration ref to the database.
	 *
	 * @param mig_ref_id the primary key for the new content migration ref
	 * @return the new content migration ref
	 */
	public ContentMigrationRef create(long mig_ref_id);

	/**
	 * Removes the content migration ref with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param mig_ref_id the primary key of the content migration ref
	 * @return the content migration ref that was removed
	 * @throws NoSuchContentMigrationRefException if a content migration ref with the primary key could not be found
	 */
	public ContentMigrationRef remove(long mig_ref_id)
		throws NoSuchContentMigrationRefException;

	public ContentMigrationRef updateImpl(
		ContentMigrationRef contentMigrationRef);

	/**
	 * Returns the content migration ref with the primary key or throws a <code>NoSuchContentMigrationRefException</code> if it could not be found.
	 *
	 * @param mig_ref_id the primary key of the content migration ref
	 * @return the content migration ref
	 * @throws NoSuchContentMigrationRefException if a content migration ref with the primary key could not be found
	 */
	public ContentMigrationRef findByPrimaryKey(long mig_ref_id)
		throws NoSuchContentMigrationRefException;

	/**
	 * Returns the content migration ref with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param mig_ref_id the primary key of the content migration ref
	 * @return the content migration ref, or <code>null</code> if a content migration ref with the primary key could not be found
	 */
	public ContentMigrationRef fetchByPrimaryKey(long mig_ref_id);

	/**
	 * Returns all the content migration refs.
	 *
	 * @return the content migration refs
	 */
	public java.util.List<ContentMigrationRef> findAll();

	/**
	 * Returns a range of all the content migration refs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ContentMigrationRefModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of content migration refs
	 * @param end the upper bound of the range of content migration refs (not inclusive)
	 * @return the range of content migration refs
	 */
	public java.util.List<ContentMigrationRef> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the content migration refs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ContentMigrationRefModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of content migration refs
	 * @param end the upper bound of the range of content migration refs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of content migration refs
	 */
	public java.util.List<ContentMigrationRef> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ContentMigrationRef>
			orderByComparator);

	/**
	 * Returns an ordered range of all the content migration refs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ContentMigrationRefModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of content migration refs
	 * @param end the upper bound of the range of content migration refs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of content migration refs
	 */
	public java.util.List<ContentMigrationRef> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ContentMigrationRef>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the content migration refs from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of content migration refs.
	 *
	 * @return the number of content migration refs
	 */
	public int countAll();

}