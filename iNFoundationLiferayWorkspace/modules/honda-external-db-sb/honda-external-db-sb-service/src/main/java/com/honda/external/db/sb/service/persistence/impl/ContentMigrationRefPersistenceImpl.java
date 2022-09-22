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

package com.honda.external.db.sb.service.persistence.impl;

import com.honda.external.db.sb.exception.NoSuchContentMigrationRefException;
import com.honda.external.db.sb.model.ContentMigrationRef;
import com.honda.external.db.sb.model.impl.ContentMigrationRefImpl;
import com.honda.external.db.sb.model.impl.ContentMigrationRefModelImpl;
import com.honda.external.db.sb.service.persistence.ContentMigrationRefPersistence;
import com.honda.external.db.sb.service.persistence.impl.constants.HondaPersistenceConstants;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.ArgumentsResolver;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.MapUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import javax.sql.DataSource;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the content migration ref service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = ContentMigrationRefPersistence.class)
public class ContentMigrationRefPersistenceImpl
	extends BasePersistenceImpl<ContentMigrationRef>
	implements ContentMigrationRefPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ContentMigrationRefUtil</code> to access the content migration ref persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ContentMigrationRefImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathFetchByahmc_division;
	private FinderPath _finderPathCountByahmc_division;

	/**
	 * Returns the content migration ref where ahmc_app_code = &#63; and division = &#63; or throws a <code>NoSuchContentMigrationRefException</code> if it could not be found.
	 *
	 * @param ahmc_app_code the ahmc_app_code
	 * @param division the division
	 * @return the matching content migration ref
	 * @throws NoSuchContentMigrationRefException if a matching content migration ref could not be found
	 */
	@Override
	public ContentMigrationRef findByahmc_division(
			String ahmc_app_code, String division)
		throws NoSuchContentMigrationRefException {

		ContentMigrationRef contentMigrationRef = fetchByahmc_division(
			ahmc_app_code, division);

		if (contentMigrationRef == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("ahmc_app_code=");
			sb.append(ahmc_app_code);

			sb.append(", division=");
			sb.append(division);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchContentMigrationRefException(sb.toString());
		}

		return contentMigrationRef;
	}

	/**
	 * Returns the content migration ref where ahmc_app_code = &#63; and division = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param ahmc_app_code the ahmc_app_code
	 * @param division the division
	 * @return the matching content migration ref, or <code>null</code> if a matching content migration ref could not be found
	 */
	@Override
	public ContentMigrationRef fetchByahmc_division(
		String ahmc_app_code, String division) {

		return fetchByahmc_division(ahmc_app_code, division, true);
	}

	/**
	 * Returns the content migration ref where ahmc_app_code = &#63; and division = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param ahmc_app_code the ahmc_app_code
	 * @param division the division
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching content migration ref, or <code>null</code> if a matching content migration ref could not be found
	 */
	@Override
	public ContentMigrationRef fetchByahmc_division(
		String ahmc_app_code, String division, boolean useFinderCache) {

		ahmc_app_code = Objects.toString(ahmc_app_code, "");
		division = Objects.toString(division, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {ahmc_app_code, division};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByahmc_division, finderArgs, this);
		}

		if (result instanceof ContentMigrationRef) {
			ContentMigrationRef contentMigrationRef =
				(ContentMigrationRef)result;

			if (!Objects.equals(
					ahmc_app_code, contentMigrationRef.getAhmc_app_code()) ||
				!Objects.equals(division, contentMigrationRef.getDivision())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_CONTENTMIGRATIONREF_WHERE);

			boolean bindAhmc_app_code = false;

			if (ahmc_app_code.isEmpty()) {
				sb.append(_FINDER_COLUMN_AHMC_DIVISION_AHMC_APP_CODE_3);
			}
			else {
				bindAhmc_app_code = true;

				sb.append(_FINDER_COLUMN_AHMC_DIVISION_AHMC_APP_CODE_2);
			}

			boolean bindDivision = false;

			if (division.isEmpty()) {
				sb.append(_FINDER_COLUMN_AHMC_DIVISION_DIVISION_3);
			}
			else {
				bindDivision = true;

				sb.append(_FINDER_COLUMN_AHMC_DIVISION_DIVISION_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindAhmc_app_code) {
					queryPos.add(ahmc_app_code);
				}

				if (bindDivision) {
					queryPos.add(division);
				}

				List<ContentMigrationRef> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByahmc_division, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {
									ahmc_app_code, division
								};
							}

							_log.warn(
								"ContentMigrationRefPersistenceImpl.fetchByahmc_division(String, String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					ContentMigrationRef contentMigrationRef = list.get(0);

					result = contentMigrationRef;

					cacheResult(contentMigrationRef);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (ContentMigrationRef)result;
		}
	}

	/**
	 * Removes the content migration ref where ahmc_app_code = &#63; and division = &#63; from the database.
	 *
	 * @param ahmc_app_code the ahmc_app_code
	 * @param division the division
	 * @return the content migration ref that was removed
	 */
	@Override
	public ContentMigrationRef removeByahmc_division(
			String ahmc_app_code, String division)
		throws NoSuchContentMigrationRefException {

		ContentMigrationRef contentMigrationRef = findByahmc_division(
			ahmc_app_code, division);

		return remove(contentMigrationRef);
	}

	/**
	 * Returns the number of content migration refs where ahmc_app_code = &#63; and division = &#63;.
	 *
	 * @param ahmc_app_code the ahmc_app_code
	 * @param division the division
	 * @return the number of matching content migration refs
	 */
	@Override
	public int countByahmc_division(String ahmc_app_code, String division) {
		ahmc_app_code = Objects.toString(ahmc_app_code, "");
		division = Objects.toString(division, "");

		FinderPath finderPath = _finderPathCountByahmc_division;

		Object[] finderArgs = new Object[] {ahmc_app_code, division};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_CONTENTMIGRATIONREF_WHERE);

			boolean bindAhmc_app_code = false;

			if (ahmc_app_code.isEmpty()) {
				sb.append(_FINDER_COLUMN_AHMC_DIVISION_AHMC_APP_CODE_3);
			}
			else {
				bindAhmc_app_code = true;

				sb.append(_FINDER_COLUMN_AHMC_DIVISION_AHMC_APP_CODE_2);
			}

			boolean bindDivision = false;

			if (division.isEmpty()) {
				sb.append(_FINDER_COLUMN_AHMC_DIVISION_DIVISION_3);
			}
			else {
				bindDivision = true;

				sb.append(_FINDER_COLUMN_AHMC_DIVISION_DIVISION_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindAhmc_app_code) {
					queryPos.add(ahmc_app_code);
				}

				if (bindDivision) {
					queryPos.add(division);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_AHMC_DIVISION_AHMC_APP_CODE_2 =
		"contentMigrationRef.ahmc_app_code = ? AND ";

	private static final String _FINDER_COLUMN_AHMC_DIVISION_AHMC_APP_CODE_3 =
		"(contentMigrationRef.ahmc_app_code IS NULL OR contentMigrationRef.ahmc_app_code = '') AND ";

	private static final String _FINDER_COLUMN_AHMC_DIVISION_DIVISION_2 =
		"contentMigrationRef.division = ?";

	private static final String _FINDER_COLUMN_AHMC_DIVISION_DIVISION_3 =
		"(contentMigrationRef.division IS NULL OR contentMigrationRef.division = '')";

	private FinderPath _finderPathFetchByahmc_divi_depart;
	private FinderPath _finderPathCountByahmc_divi_depart;

	/**
	 * Returns the content migration ref where ahmc_app_code = &#63; and division = &#63; and department = &#63; or throws a <code>NoSuchContentMigrationRefException</code> if it could not be found.
	 *
	 * @param ahmc_app_code the ahmc_app_code
	 * @param division the division
	 * @param department the department
	 * @return the matching content migration ref
	 * @throws NoSuchContentMigrationRefException if a matching content migration ref could not be found
	 */
	@Override
	public ContentMigrationRef findByahmc_divi_depart(
			String ahmc_app_code, String division, String department)
		throws NoSuchContentMigrationRefException {

		ContentMigrationRef contentMigrationRef = fetchByahmc_divi_depart(
			ahmc_app_code, division, department);

		if (contentMigrationRef == null) {
			StringBundler sb = new StringBundler(8);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("ahmc_app_code=");
			sb.append(ahmc_app_code);

			sb.append(", division=");
			sb.append(division);

			sb.append(", department=");
			sb.append(department);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchContentMigrationRefException(sb.toString());
		}

		return contentMigrationRef;
	}

	/**
	 * Returns the content migration ref where ahmc_app_code = &#63; and division = &#63; and department = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param ahmc_app_code the ahmc_app_code
	 * @param division the division
	 * @param department the department
	 * @return the matching content migration ref, or <code>null</code> if a matching content migration ref could not be found
	 */
	@Override
	public ContentMigrationRef fetchByahmc_divi_depart(
		String ahmc_app_code, String division, String department) {

		return fetchByahmc_divi_depart(
			ahmc_app_code, division, department, true);
	}

	/**
	 * Returns the content migration ref where ahmc_app_code = &#63; and division = &#63; and department = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param ahmc_app_code the ahmc_app_code
	 * @param division the division
	 * @param department the department
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching content migration ref, or <code>null</code> if a matching content migration ref could not be found
	 */
	@Override
	public ContentMigrationRef fetchByahmc_divi_depart(
		String ahmc_app_code, String division, String department,
		boolean useFinderCache) {

		ahmc_app_code = Objects.toString(ahmc_app_code, "");
		division = Objects.toString(division, "");
		department = Objects.toString(department, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {ahmc_app_code, division, department};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByahmc_divi_depart, finderArgs, this);
		}

		if (result instanceof ContentMigrationRef) {
			ContentMigrationRef contentMigrationRef =
				(ContentMigrationRef)result;

			if (!Objects.equals(
					ahmc_app_code, contentMigrationRef.getAhmc_app_code()) ||
				!Objects.equals(division, contentMigrationRef.getDivision()) ||
				!Objects.equals(
					department, contentMigrationRef.getDepartment())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(5);

			sb.append(_SQL_SELECT_CONTENTMIGRATIONREF_WHERE);

			boolean bindAhmc_app_code = false;

			if (ahmc_app_code.isEmpty()) {
				sb.append(_FINDER_COLUMN_AHMC_DIVI_DEPART_AHMC_APP_CODE_3);
			}
			else {
				bindAhmc_app_code = true;

				sb.append(_FINDER_COLUMN_AHMC_DIVI_DEPART_AHMC_APP_CODE_2);
			}

			boolean bindDivision = false;

			if (division.isEmpty()) {
				sb.append(_FINDER_COLUMN_AHMC_DIVI_DEPART_DIVISION_3);
			}
			else {
				bindDivision = true;

				sb.append(_FINDER_COLUMN_AHMC_DIVI_DEPART_DIVISION_2);
			}

			boolean bindDepartment = false;

			if (department.isEmpty()) {
				sb.append(_FINDER_COLUMN_AHMC_DIVI_DEPART_DEPARTMENT_3);
			}
			else {
				bindDepartment = true;

				sb.append(_FINDER_COLUMN_AHMC_DIVI_DEPART_DEPARTMENT_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindAhmc_app_code) {
					queryPos.add(ahmc_app_code);
				}

				if (bindDivision) {
					queryPos.add(division);
				}

				if (bindDepartment) {
					queryPos.add(department);
				}

				List<ContentMigrationRef> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByahmc_divi_depart, finderArgs,
							list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {
									ahmc_app_code, division, department
								};
							}

							_log.warn(
								"ContentMigrationRefPersistenceImpl.fetchByahmc_divi_depart(String, String, String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					ContentMigrationRef contentMigrationRef = list.get(0);

					result = contentMigrationRef;

					cacheResult(contentMigrationRef);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (ContentMigrationRef)result;
		}
	}

	/**
	 * Removes the content migration ref where ahmc_app_code = &#63; and division = &#63; and department = &#63; from the database.
	 *
	 * @param ahmc_app_code the ahmc_app_code
	 * @param division the division
	 * @param department the department
	 * @return the content migration ref that was removed
	 */
	@Override
	public ContentMigrationRef removeByahmc_divi_depart(
			String ahmc_app_code, String division, String department)
		throws NoSuchContentMigrationRefException {

		ContentMigrationRef contentMigrationRef = findByahmc_divi_depart(
			ahmc_app_code, division, department);

		return remove(contentMigrationRef);
	}

	/**
	 * Returns the number of content migration refs where ahmc_app_code = &#63; and division = &#63; and department = &#63;.
	 *
	 * @param ahmc_app_code the ahmc_app_code
	 * @param division the division
	 * @param department the department
	 * @return the number of matching content migration refs
	 */
	@Override
	public int countByahmc_divi_depart(
		String ahmc_app_code, String division, String department) {

		ahmc_app_code = Objects.toString(ahmc_app_code, "");
		division = Objects.toString(division, "");
		department = Objects.toString(department, "");

		FinderPath finderPath = _finderPathCountByahmc_divi_depart;

		Object[] finderArgs = new Object[] {
			ahmc_app_code, division, department
		};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_COUNT_CONTENTMIGRATIONREF_WHERE);

			boolean bindAhmc_app_code = false;

			if (ahmc_app_code.isEmpty()) {
				sb.append(_FINDER_COLUMN_AHMC_DIVI_DEPART_AHMC_APP_CODE_3);
			}
			else {
				bindAhmc_app_code = true;

				sb.append(_FINDER_COLUMN_AHMC_DIVI_DEPART_AHMC_APP_CODE_2);
			}

			boolean bindDivision = false;

			if (division.isEmpty()) {
				sb.append(_FINDER_COLUMN_AHMC_DIVI_DEPART_DIVISION_3);
			}
			else {
				bindDivision = true;

				sb.append(_FINDER_COLUMN_AHMC_DIVI_DEPART_DIVISION_2);
			}

			boolean bindDepartment = false;

			if (department.isEmpty()) {
				sb.append(_FINDER_COLUMN_AHMC_DIVI_DEPART_DEPARTMENT_3);
			}
			else {
				bindDepartment = true;

				sb.append(_FINDER_COLUMN_AHMC_DIVI_DEPART_DEPARTMENT_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindAhmc_app_code) {
					queryPos.add(ahmc_app_code);
				}

				if (bindDivision) {
					queryPos.add(division);
				}

				if (bindDepartment) {
					queryPos.add(department);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String
		_FINDER_COLUMN_AHMC_DIVI_DEPART_AHMC_APP_CODE_2 =
			"contentMigrationRef.ahmc_app_code = ? AND ";

	private static final String
		_FINDER_COLUMN_AHMC_DIVI_DEPART_AHMC_APP_CODE_3 =
			"(contentMigrationRef.ahmc_app_code IS NULL OR contentMigrationRef.ahmc_app_code = '') AND ";

	private static final String _FINDER_COLUMN_AHMC_DIVI_DEPART_DIVISION_2 =
		"contentMigrationRef.division = ? AND ";

	private static final String _FINDER_COLUMN_AHMC_DIVI_DEPART_DIVISION_3 =
		"(contentMigrationRef.division IS NULL OR contentMigrationRef.division = '') AND ";

	private static final String _FINDER_COLUMN_AHMC_DIVI_DEPART_DEPARTMENT_2 =
		"contentMigrationRef.department = ?";

	private static final String _FINDER_COLUMN_AHMC_DIVI_DEPART_DEPARTMENT_3 =
		"(contentMigrationRef.department IS NULL OR contentMigrationRef.department = '')";

	public ContentMigrationRefPersistenceImpl() {
		setModelClass(ContentMigrationRef.class);

		setModelImplClass(ContentMigrationRefImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the content migration ref in the entity cache if it is enabled.
	 *
	 * @param contentMigrationRef the content migration ref
	 */
	@Override
	public void cacheResult(ContentMigrationRef contentMigrationRef) {
		entityCache.putResult(
			ContentMigrationRefImpl.class, contentMigrationRef.getPrimaryKey(),
			contentMigrationRef);

		finderCache.putResult(
			_finderPathFetchByahmc_division,
			new Object[] {
				contentMigrationRef.getAhmc_app_code(),
				contentMigrationRef.getDivision()
			},
			contentMigrationRef);

		finderCache.putResult(
			_finderPathFetchByahmc_divi_depart,
			new Object[] {
				contentMigrationRef.getAhmc_app_code(),
				contentMigrationRef.getDivision(),
				contentMigrationRef.getDepartment()
			},
			contentMigrationRef);
	}

	/**
	 * Caches the content migration refs in the entity cache if it is enabled.
	 *
	 * @param contentMigrationRefs the content migration refs
	 */
	@Override
	public void cacheResult(List<ContentMigrationRef> contentMigrationRefs) {
		for (ContentMigrationRef contentMigrationRef : contentMigrationRefs) {
			if (entityCache.getResult(
					ContentMigrationRefImpl.class,
					contentMigrationRef.getPrimaryKey()) == null) {

				cacheResult(contentMigrationRef);
			}
		}
	}

	/**
	 * Clears the cache for all content migration refs.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ContentMigrationRefImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the content migration ref.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ContentMigrationRef contentMigrationRef) {
		entityCache.removeResult(
			ContentMigrationRefImpl.class, contentMigrationRef);
	}

	@Override
	public void clearCache(List<ContentMigrationRef> contentMigrationRefs) {
		for (ContentMigrationRef contentMigrationRef : contentMigrationRefs) {
			entityCache.removeResult(
				ContentMigrationRefImpl.class, contentMigrationRef);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(ContentMigrationRefImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		ContentMigrationRefModelImpl contentMigrationRefModelImpl) {

		Object[] args = new Object[] {
			contentMigrationRefModelImpl.getAhmc_app_code(),
			contentMigrationRefModelImpl.getDivision()
		};

		finderCache.putResult(
			_finderPathCountByahmc_division, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByahmc_division, args, contentMigrationRefModelImpl,
			false);

		args = new Object[] {
			contentMigrationRefModelImpl.getAhmc_app_code(),
			contentMigrationRefModelImpl.getDivision(),
			contentMigrationRefModelImpl.getDepartment()
		};

		finderCache.putResult(
			_finderPathCountByahmc_divi_depart, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByahmc_divi_depart, args,
			contentMigrationRefModelImpl, false);
	}

	/**
	 * Creates a new content migration ref with the primary key. Does not add the content migration ref to the database.
	 *
	 * @param mig_ref_id the primary key for the new content migration ref
	 * @return the new content migration ref
	 */
	@Override
	public ContentMigrationRef create(long mig_ref_id) {
		ContentMigrationRef contentMigrationRef = new ContentMigrationRefImpl();

		contentMigrationRef.setNew(true);
		contentMigrationRef.setPrimaryKey(mig_ref_id);

		return contentMigrationRef;
	}

	/**
	 * Removes the content migration ref with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param mig_ref_id the primary key of the content migration ref
	 * @return the content migration ref that was removed
	 * @throws NoSuchContentMigrationRefException if a content migration ref with the primary key could not be found
	 */
	@Override
	public ContentMigrationRef remove(long mig_ref_id)
		throws NoSuchContentMigrationRefException {

		return remove((Serializable)mig_ref_id);
	}

	/**
	 * Removes the content migration ref with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the content migration ref
	 * @return the content migration ref that was removed
	 * @throws NoSuchContentMigrationRefException if a content migration ref with the primary key could not be found
	 */
	@Override
	public ContentMigrationRef remove(Serializable primaryKey)
		throws NoSuchContentMigrationRefException {

		Session session = null;

		try {
			session = openSession();

			ContentMigrationRef contentMigrationRef =
				(ContentMigrationRef)session.get(
					ContentMigrationRefImpl.class, primaryKey);

			if (contentMigrationRef == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchContentMigrationRefException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(contentMigrationRef);
		}
		catch (NoSuchContentMigrationRefException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected ContentMigrationRef removeImpl(
		ContentMigrationRef contentMigrationRef) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(contentMigrationRef)) {
				contentMigrationRef = (ContentMigrationRef)session.get(
					ContentMigrationRefImpl.class,
					contentMigrationRef.getPrimaryKeyObj());
			}

			if (contentMigrationRef != null) {
				session.delete(contentMigrationRef);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (contentMigrationRef != null) {
			clearCache(contentMigrationRef);
		}

		return contentMigrationRef;
	}

	@Override
	public ContentMigrationRef updateImpl(
		ContentMigrationRef contentMigrationRef) {

		boolean isNew = contentMigrationRef.isNew();

		if (!(contentMigrationRef instanceof ContentMigrationRefModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(contentMigrationRef.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					contentMigrationRef);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in contentMigrationRef proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom ContentMigrationRef implementation " +
					contentMigrationRef.getClass());
		}

		ContentMigrationRefModelImpl contentMigrationRefModelImpl =
			(ContentMigrationRefModelImpl)contentMigrationRef;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(contentMigrationRef);
			}
			else {
				contentMigrationRef = (ContentMigrationRef)session.merge(
					contentMigrationRef);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			ContentMigrationRefImpl.class, contentMigrationRefModelImpl, false,
			true);

		cacheUniqueFindersCache(contentMigrationRefModelImpl);

		if (isNew) {
			contentMigrationRef.setNew(false);
		}

		contentMigrationRef.resetOriginalValues();

		return contentMigrationRef;
	}

	/**
	 * Returns the content migration ref with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the content migration ref
	 * @return the content migration ref
	 * @throws NoSuchContentMigrationRefException if a content migration ref with the primary key could not be found
	 */
	@Override
	public ContentMigrationRef findByPrimaryKey(Serializable primaryKey)
		throws NoSuchContentMigrationRefException {

		ContentMigrationRef contentMigrationRef = fetchByPrimaryKey(primaryKey);

		if (contentMigrationRef == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchContentMigrationRefException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return contentMigrationRef;
	}

	/**
	 * Returns the content migration ref with the primary key or throws a <code>NoSuchContentMigrationRefException</code> if it could not be found.
	 *
	 * @param mig_ref_id the primary key of the content migration ref
	 * @return the content migration ref
	 * @throws NoSuchContentMigrationRefException if a content migration ref with the primary key could not be found
	 */
	@Override
	public ContentMigrationRef findByPrimaryKey(long mig_ref_id)
		throws NoSuchContentMigrationRefException {

		return findByPrimaryKey((Serializable)mig_ref_id);
	}

	/**
	 * Returns the content migration ref with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param mig_ref_id the primary key of the content migration ref
	 * @return the content migration ref, or <code>null</code> if a content migration ref with the primary key could not be found
	 */
	@Override
	public ContentMigrationRef fetchByPrimaryKey(long mig_ref_id) {
		return fetchByPrimaryKey((Serializable)mig_ref_id);
	}

	/**
	 * Returns all the content migration refs.
	 *
	 * @return the content migration refs
	 */
	@Override
	public List<ContentMigrationRef> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<ContentMigrationRef> findAll(int start, int end) {
		return findAll(start, end, null);
	}

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
	@Override
	public List<ContentMigrationRef> findAll(
		int start, int end,
		OrderByComparator<ContentMigrationRef> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

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
	@Override
	public List<ContentMigrationRef> findAll(
		int start, int end,
		OrderByComparator<ContentMigrationRef> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<ContentMigrationRef> list = null;

		if (useFinderCache) {
			list = (List<ContentMigrationRef>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_CONTENTMIGRATIONREF);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_CONTENTMIGRATIONREF;

				sql = sql.concat(ContentMigrationRefModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<ContentMigrationRef>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the content migration refs from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ContentMigrationRef contentMigrationRef : findAll()) {
			remove(contentMigrationRef);
		}
	}

	/**
	 * Returns the number of content migration refs.
	 *
	 * @return the number of content migration refs
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(
					_SQL_COUNT_CONTENTMIGRATIONREF);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "mig_ref_id";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_CONTENTMIGRATIONREF;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ContentMigrationRefModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the content migration ref persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new ContentMigrationRefModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", ContentMigrationRef.class.getName()));

		_finderPathWithPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathFetchByahmc_division = _createFinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByahmc_division",
			new String[] {String.class.getName(), String.class.getName()},
			new String[] {"ahmc_app_code", "division"}, true);

		_finderPathCountByahmc_division = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByahmc_division",
			new String[] {String.class.getName(), String.class.getName()},
			new String[] {"ahmc_app_code", "division"}, false);

		_finderPathFetchByahmc_divi_depart = _createFinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByahmc_divi_depart",
			new String[] {
				String.class.getName(), String.class.getName(),
				String.class.getName()
			},
			new String[] {"ahmc_app_code", "division", "department"}, true);

		_finderPathCountByahmc_divi_depart = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByahmc_divi_depart",
			new String[] {
				String.class.getName(), String.class.getName(),
				String.class.getName()
			},
			new String[] {"ahmc_app_code", "division", "department"}, false);
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(ContentMigrationRefImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	@Override
	@Reference(
		target = HondaPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = HondaPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = HondaPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	private BundleContext _bundleContext;

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_CONTENTMIGRATIONREF =
		"SELECT contentMigrationRef FROM ContentMigrationRef contentMigrationRef";

	private static final String _SQL_SELECT_CONTENTMIGRATIONREF_WHERE =
		"SELECT contentMigrationRef FROM ContentMigrationRef contentMigrationRef WHERE ";

	private static final String _SQL_COUNT_CONTENTMIGRATIONREF =
		"SELECT COUNT(contentMigrationRef) FROM ContentMigrationRef contentMigrationRef";

	private static final String _SQL_COUNT_CONTENTMIGRATIONREF_WHERE =
		"SELECT COUNT(contentMigrationRef) FROM ContentMigrationRef contentMigrationRef WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "contentMigrationRef.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No ContentMigrationRef exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No ContentMigrationRef exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ContentMigrationRefPersistenceImpl.class);

	private FinderPath _createFinderPath(
		String cacheName, String methodName, String[] params,
		String[] columnNames, boolean baseModelResult) {

		FinderPath finderPath = new FinderPath(
			cacheName, methodName, params, columnNames, baseModelResult);

		if (!cacheName.equals(FINDER_CLASS_NAME_LIST_WITH_PAGINATION)) {
			_serviceRegistrations.add(
				_bundleContext.registerService(
					FinderPath.class, finderPath,
					MapUtil.singletonDictionary("cache.name", cacheName)));
		}

		return finderPath;
	}

	private Set<ServiceRegistration<FinderPath>> _serviceRegistrations =
		new HashSet<>();
	private ServiceRegistration<ArgumentsResolver>
		_argumentsResolverServiceRegistration;

	private static class ContentMigrationRefModelArgumentsResolver
		implements ArgumentsResolver {

		@Override
		public Object[] getArguments(
			FinderPath finderPath, BaseModel<?> baseModel, boolean checkColumn,
			boolean original) {

			String[] columnNames = finderPath.getColumnNames();

			if ((columnNames == null) || (columnNames.length == 0)) {
				if (baseModel.isNew()) {
					return FINDER_ARGS_EMPTY;
				}

				return null;
			}

			ContentMigrationRefModelImpl contentMigrationRefModelImpl =
				(ContentMigrationRefModelImpl)baseModel;

			long columnBitmask =
				contentMigrationRefModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					contentMigrationRefModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						contentMigrationRefModelImpl.getColumnBitmask(
							columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					contentMigrationRefModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			ContentMigrationRefModelImpl contentMigrationRefModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						contentMigrationRefModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = contentMigrationRefModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}