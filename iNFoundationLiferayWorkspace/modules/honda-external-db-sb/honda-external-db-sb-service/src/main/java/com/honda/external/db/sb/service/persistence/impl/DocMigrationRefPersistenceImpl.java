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

import com.honda.external.db.sb.exception.NoSuchDocMigrationRefException;
import com.honda.external.db.sb.model.DocMigrationRef;
import com.honda.external.db.sb.model.impl.DocMigrationRefImpl;
import com.honda.external.db.sb.model.impl.DocMigrationRefModelImpl;
import com.honda.external.db.sb.service.persistence.DocMigrationRefPersistence;
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
 * The persistence implementation for the doc migration ref service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = DocMigrationRefPersistence.class)
public class DocMigrationRefPersistenceImpl
	extends BasePersistenceImpl<DocMigrationRef>
	implements DocMigrationRefPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>DocMigrationRefUtil</code> to access the doc migration ref persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		DocMigrationRefImpl.class.getName();

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
	 * Returns the doc migration ref where ahmc_app_code = &#63; and division = &#63; or throws a <code>NoSuchDocMigrationRefException</code> if it could not be found.
	 *
	 * @param ahmc_app_code the ahmc_app_code
	 * @param division the division
	 * @return the matching doc migration ref
	 * @throws NoSuchDocMigrationRefException if a matching doc migration ref could not be found
	 */
	@Override
	public DocMigrationRef findByahmc_division(
			String ahmc_app_code, String division)
		throws NoSuchDocMigrationRefException {

		DocMigrationRef docMigrationRef = fetchByahmc_division(
			ahmc_app_code, division);

		if (docMigrationRef == null) {
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

			throw new NoSuchDocMigrationRefException(sb.toString());
		}

		return docMigrationRef;
	}

	/**
	 * Returns the doc migration ref where ahmc_app_code = &#63; and division = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param ahmc_app_code the ahmc_app_code
	 * @param division the division
	 * @return the matching doc migration ref, or <code>null</code> if a matching doc migration ref could not be found
	 */
	@Override
	public DocMigrationRef fetchByahmc_division(
		String ahmc_app_code, String division) {

		return fetchByahmc_division(ahmc_app_code, division, true);
	}

	/**
	 * Returns the doc migration ref where ahmc_app_code = &#63; and division = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param ahmc_app_code the ahmc_app_code
	 * @param division the division
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching doc migration ref, or <code>null</code> if a matching doc migration ref could not be found
	 */
	@Override
	public DocMigrationRef fetchByahmc_division(
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

		if (result instanceof DocMigrationRef) {
			DocMigrationRef docMigrationRef = (DocMigrationRef)result;

			if (!Objects.equals(
					ahmc_app_code, docMigrationRef.getAhmc_app_code()) ||
				!Objects.equals(division, docMigrationRef.getDivision())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_DOCMIGRATIONREF_WHERE);

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

				List<DocMigrationRef> list = query.list();

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
								"DocMigrationRefPersistenceImpl.fetchByahmc_division(String, String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					DocMigrationRef docMigrationRef = list.get(0);

					result = docMigrationRef;

					cacheResult(docMigrationRef);
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
			return (DocMigrationRef)result;
		}
	}

	/**
	 * Removes the doc migration ref where ahmc_app_code = &#63; and division = &#63; from the database.
	 *
	 * @param ahmc_app_code the ahmc_app_code
	 * @param division the division
	 * @return the doc migration ref that was removed
	 */
	@Override
	public DocMigrationRef removeByahmc_division(
			String ahmc_app_code, String division)
		throws NoSuchDocMigrationRefException {

		DocMigrationRef docMigrationRef = findByahmc_division(
			ahmc_app_code, division);

		return remove(docMigrationRef);
	}

	/**
	 * Returns the number of doc migration refs where ahmc_app_code = &#63; and division = &#63;.
	 *
	 * @param ahmc_app_code the ahmc_app_code
	 * @param division the division
	 * @return the number of matching doc migration refs
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

			sb.append(_SQL_COUNT_DOCMIGRATIONREF_WHERE);

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
		"docMigrationRef.ahmc_app_code = ? AND ";

	private static final String _FINDER_COLUMN_AHMC_DIVISION_AHMC_APP_CODE_3 =
		"(docMigrationRef.ahmc_app_code IS NULL OR docMigrationRef.ahmc_app_code = '') AND ";

	private static final String _FINDER_COLUMN_AHMC_DIVISION_DIVISION_2 =
		"docMigrationRef.division = ?";

	private static final String _FINDER_COLUMN_AHMC_DIVISION_DIVISION_3 =
		"(docMigrationRef.division IS NULL OR docMigrationRef.division = '')";

	private FinderPath _finderPathFetchByahmc_divi_depart;
	private FinderPath _finderPathCountByahmc_divi_depart;

	/**
	 * Returns the doc migration ref where ahmc_app_code = &#63; and division = &#63; and department = &#63; or throws a <code>NoSuchDocMigrationRefException</code> if it could not be found.
	 *
	 * @param ahmc_app_code the ahmc_app_code
	 * @param division the division
	 * @param department the department
	 * @return the matching doc migration ref
	 * @throws NoSuchDocMigrationRefException if a matching doc migration ref could not be found
	 */
	@Override
	public DocMigrationRef findByahmc_divi_depart(
			String ahmc_app_code, String division, String department)
		throws NoSuchDocMigrationRefException {

		DocMigrationRef docMigrationRef = fetchByahmc_divi_depart(
			ahmc_app_code, division, department);

		if (docMigrationRef == null) {
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

			throw new NoSuchDocMigrationRefException(sb.toString());
		}

		return docMigrationRef;
	}

	/**
	 * Returns the doc migration ref where ahmc_app_code = &#63; and division = &#63; and department = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param ahmc_app_code the ahmc_app_code
	 * @param division the division
	 * @param department the department
	 * @return the matching doc migration ref, or <code>null</code> if a matching doc migration ref could not be found
	 */
	@Override
	public DocMigrationRef fetchByahmc_divi_depart(
		String ahmc_app_code, String division, String department) {

		return fetchByahmc_divi_depart(
			ahmc_app_code, division, department, true);
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
	@Override
	public DocMigrationRef fetchByahmc_divi_depart(
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

		if (result instanceof DocMigrationRef) {
			DocMigrationRef docMigrationRef = (DocMigrationRef)result;

			if (!Objects.equals(
					ahmc_app_code, docMigrationRef.getAhmc_app_code()) ||
				!Objects.equals(division, docMigrationRef.getDivision()) ||
				!Objects.equals(department, docMigrationRef.getDepartment())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(5);

			sb.append(_SQL_SELECT_DOCMIGRATIONREF_WHERE);

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

				List<DocMigrationRef> list = query.list();

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
								"DocMigrationRefPersistenceImpl.fetchByahmc_divi_depart(String, String, String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					DocMigrationRef docMigrationRef = list.get(0);

					result = docMigrationRef;

					cacheResult(docMigrationRef);
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
			return (DocMigrationRef)result;
		}
	}

	/**
	 * Removes the doc migration ref where ahmc_app_code = &#63; and division = &#63; and department = &#63; from the database.
	 *
	 * @param ahmc_app_code the ahmc_app_code
	 * @param division the division
	 * @param department the department
	 * @return the doc migration ref that was removed
	 */
	@Override
	public DocMigrationRef removeByahmc_divi_depart(
			String ahmc_app_code, String division, String department)
		throws NoSuchDocMigrationRefException {

		DocMigrationRef docMigrationRef = findByahmc_divi_depart(
			ahmc_app_code, division, department);

		return remove(docMigrationRef);
	}

	/**
	 * Returns the number of doc migration refs where ahmc_app_code = &#63; and division = &#63; and department = &#63;.
	 *
	 * @param ahmc_app_code the ahmc_app_code
	 * @param division the division
	 * @param department the department
	 * @return the number of matching doc migration refs
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

			sb.append(_SQL_COUNT_DOCMIGRATIONREF_WHERE);

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
			"docMigrationRef.ahmc_app_code = ? AND ";

	private static final String
		_FINDER_COLUMN_AHMC_DIVI_DEPART_AHMC_APP_CODE_3 =
			"(docMigrationRef.ahmc_app_code IS NULL OR docMigrationRef.ahmc_app_code = '') AND ";

	private static final String _FINDER_COLUMN_AHMC_DIVI_DEPART_DIVISION_2 =
		"docMigrationRef.division = ? AND ";

	private static final String _FINDER_COLUMN_AHMC_DIVI_DEPART_DIVISION_3 =
		"(docMigrationRef.division IS NULL OR docMigrationRef.division = '') AND ";

	private static final String _FINDER_COLUMN_AHMC_DIVI_DEPART_DEPARTMENT_2 =
		"docMigrationRef.department = ?";

	private static final String _FINDER_COLUMN_AHMC_DIVI_DEPART_DEPARTMENT_3 =
		"(docMigrationRef.department IS NULL OR docMigrationRef.department = '')";

	public DocMigrationRefPersistenceImpl() {
		setModelClass(DocMigrationRef.class);

		setModelImplClass(DocMigrationRefImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the doc migration ref in the entity cache if it is enabled.
	 *
	 * @param docMigrationRef the doc migration ref
	 */
	@Override
	public void cacheResult(DocMigrationRef docMigrationRef) {
		entityCache.putResult(
			DocMigrationRefImpl.class, docMigrationRef.getPrimaryKey(),
			docMigrationRef);

		finderCache.putResult(
			_finderPathFetchByahmc_division,
			new Object[] {
				docMigrationRef.getAhmc_app_code(),
				docMigrationRef.getDivision()
			},
			docMigrationRef);

		finderCache.putResult(
			_finderPathFetchByahmc_divi_depart,
			new Object[] {
				docMigrationRef.getAhmc_app_code(),
				docMigrationRef.getDivision(), docMigrationRef.getDepartment()
			},
			docMigrationRef);
	}

	/**
	 * Caches the doc migration refs in the entity cache if it is enabled.
	 *
	 * @param docMigrationRefs the doc migration refs
	 */
	@Override
	public void cacheResult(List<DocMigrationRef> docMigrationRefs) {
		for (DocMigrationRef docMigrationRef : docMigrationRefs) {
			if (entityCache.getResult(
					DocMigrationRefImpl.class,
					docMigrationRef.getPrimaryKey()) == null) {

				cacheResult(docMigrationRef);
			}
		}
	}

	/**
	 * Clears the cache for all doc migration refs.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(DocMigrationRefImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the doc migration ref.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(DocMigrationRef docMigrationRef) {
		entityCache.removeResult(DocMigrationRefImpl.class, docMigrationRef);
	}

	@Override
	public void clearCache(List<DocMigrationRef> docMigrationRefs) {
		for (DocMigrationRef docMigrationRef : docMigrationRefs) {
			entityCache.removeResult(
				DocMigrationRefImpl.class, docMigrationRef);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(DocMigrationRefImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		DocMigrationRefModelImpl docMigrationRefModelImpl) {

		Object[] args = new Object[] {
			docMigrationRefModelImpl.getAhmc_app_code(),
			docMigrationRefModelImpl.getDivision()
		};

		finderCache.putResult(
			_finderPathCountByahmc_division, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByahmc_division, args, docMigrationRefModelImpl,
			false);

		args = new Object[] {
			docMigrationRefModelImpl.getAhmc_app_code(),
			docMigrationRefModelImpl.getDivision(),
			docMigrationRefModelImpl.getDepartment()
		};

		finderCache.putResult(
			_finderPathCountByahmc_divi_depart, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByahmc_divi_depart, args, docMigrationRefModelImpl,
			false);
	}

	/**
	 * Creates a new doc migration ref with the primary key. Does not add the doc migration ref to the database.
	 *
	 * @param mig_ref_id the primary key for the new doc migration ref
	 * @return the new doc migration ref
	 */
	@Override
	public DocMigrationRef create(long mig_ref_id) {
		DocMigrationRef docMigrationRef = new DocMigrationRefImpl();

		docMigrationRef.setNew(true);
		docMigrationRef.setPrimaryKey(mig_ref_id);

		return docMigrationRef;
	}

	/**
	 * Removes the doc migration ref with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param mig_ref_id the primary key of the doc migration ref
	 * @return the doc migration ref that was removed
	 * @throws NoSuchDocMigrationRefException if a doc migration ref with the primary key could not be found
	 */
	@Override
	public DocMigrationRef remove(long mig_ref_id)
		throws NoSuchDocMigrationRefException {

		return remove((Serializable)mig_ref_id);
	}

	/**
	 * Removes the doc migration ref with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the doc migration ref
	 * @return the doc migration ref that was removed
	 * @throws NoSuchDocMigrationRefException if a doc migration ref with the primary key could not be found
	 */
	@Override
	public DocMigrationRef remove(Serializable primaryKey)
		throws NoSuchDocMigrationRefException {

		Session session = null;

		try {
			session = openSession();

			DocMigrationRef docMigrationRef = (DocMigrationRef)session.get(
				DocMigrationRefImpl.class, primaryKey);

			if (docMigrationRef == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDocMigrationRefException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(docMigrationRef);
		}
		catch (NoSuchDocMigrationRefException noSuchEntityException) {
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
	protected DocMigrationRef removeImpl(DocMigrationRef docMigrationRef) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(docMigrationRef)) {
				docMigrationRef = (DocMigrationRef)session.get(
					DocMigrationRefImpl.class,
					docMigrationRef.getPrimaryKeyObj());
			}

			if (docMigrationRef != null) {
				session.delete(docMigrationRef);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (docMigrationRef != null) {
			clearCache(docMigrationRef);
		}

		return docMigrationRef;
	}

	@Override
	public DocMigrationRef updateImpl(DocMigrationRef docMigrationRef) {
		boolean isNew = docMigrationRef.isNew();

		if (!(docMigrationRef instanceof DocMigrationRefModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(docMigrationRef.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					docMigrationRef);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in docMigrationRef proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom DocMigrationRef implementation " +
					docMigrationRef.getClass());
		}

		DocMigrationRefModelImpl docMigrationRefModelImpl =
			(DocMigrationRefModelImpl)docMigrationRef;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(docMigrationRef);
			}
			else {
				docMigrationRef = (DocMigrationRef)session.merge(
					docMigrationRef);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			DocMigrationRefImpl.class, docMigrationRefModelImpl, false, true);

		cacheUniqueFindersCache(docMigrationRefModelImpl);

		if (isNew) {
			docMigrationRef.setNew(false);
		}

		docMigrationRef.resetOriginalValues();

		return docMigrationRef;
	}

	/**
	 * Returns the doc migration ref with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the doc migration ref
	 * @return the doc migration ref
	 * @throws NoSuchDocMigrationRefException if a doc migration ref with the primary key could not be found
	 */
	@Override
	public DocMigrationRef findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDocMigrationRefException {

		DocMigrationRef docMigrationRef = fetchByPrimaryKey(primaryKey);

		if (docMigrationRef == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDocMigrationRefException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return docMigrationRef;
	}

	/**
	 * Returns the doc migration ref with the primary key or throws a <code>NoSuchDocMigrationRefException</code> if it could not be found.
	 *
	 * @param mig_ref_id the primary key of the doc migration ref
	 * @return the doc migration ref
	 * @throws NoSuchDocMigrationRefException if a doc migration ref with the primary key could not be found
	 */
	@Override
	public DocMigrationRef findByPrimaryKey(long mig_ref_id)
		throws NoSuchDocMigrationRefException {

		return findByPrimaryKey((Serializable)mig_ref_id);
	}

	/**
	 * Returns the doc migration ref with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param mig_ref_id the primary key of the doc migration ref
	 * @return the doc migration ref, or <code>null</code> if a doc migration ref with the primary key could not be found
	 */
	@Override
	public DocMigrationRef fetchByPrimaryKey(long mig_ref_id) {
		return fetchByPrimaryKey((Serializable)mig_ref_id);
	}

	/**
	 * Returns all the doc migration refs.
	 *
	 * @return the doc migration refs
	 */
	@Override
	public List<DocMigrationRef> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<DocMigrationRef> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<DocMigrationRef> findAll(
		int start, int end,
		OrderByComparator<DocMigrationRef> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<DocMigrationRef> findAll(
		int start, int end,
		OrderByComparator<DocMigrationRef> orderByComparator,
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

		List<DocMigrationRef> list = null;

		if (useFinderCache) {
			list = (List<DocMigrationRef>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_DOCMIGRATIONREF);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_DOCMIGRATIONREF;

				sql = sql.concat(DocMigrationRefModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<DocMigrationRef>)QueryUtil.list(
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
	 * Removes all the doc migration refs from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (DocMigrationRef docMigrationRef : findAll()) {
			remove(docMigrationRef);
		}
	}

	/**
	 * Returns the number of doc migration refs.
	 *
	 * @return the number of doc migration refs
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_DOCMIGRATIONREF);

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
		return _SQL_SELECT_DOCMIGRATIONREF;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return DocMigrationRefModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the doc migration ref persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new DocMigrationRefModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", DocMigrationRef.class.getName()));

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
		entityCache.removeCache(DocMigrationRefImpl.class.getName());

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

	private static final String _SQL_SELECT_DOCMIGRATIONREF =
		"SELECT docMigrationRef FROM DocMigrationRef docMigrationRef";

	private static final String _SQL_SELECT_DOCMIGRATIONREF_WHERE =
		"SELECT docMigrationRef FROM DocMigrationRef docMigrationRef WHERE ";

	private static final String _SQL_COUNT_DOCMIGRATIONREF =
		"SELECT COUNT(docMigrationRef) FROM DocMigrationRef docMigrationRef";

	private static final String _SQL_COUNT_DOCMIGRATIONREF_WHERE =
		"SELECT COUNT(docMigrationRef) FROM DocMigrationRef docMigrationRef WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "docMigrationRef.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No DocMigrationRef exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No DocMigrationRef exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		DocMigrationRefPersistenceImpl.class);

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

	private static class DocMigrationRefModelArgumentsResolver
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

			DocMigrationRefModelImpl docMigrationRefModelImpl =
				(DocMigrationRefModelImpl)baseModel;

			long columnBitmask = docMigrationRefModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					docMigrationRefModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						docMigrationRefModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					docMigrationRefModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			DocMigrationRefModelImpl docMigrationRefModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						docMigrationRefModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = docMigrationRefModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}