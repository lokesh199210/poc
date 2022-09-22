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

import com.honda.external.db.sb.exception.NoSuchPubAccessMappingRefException;
import com.honda.external.db.sb.model.PubAccessMappingRef;
import com.honda.external.db.sb.model.impl.PubAccessMappingRefImpl;
import com.honda.external.db.sb.model.impl.PubAccessMappingRefModelImpl;
import com.honda.external.db.sb.service.persistence.PubAccessMappingRefPersistence;
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
 * The persistence implementation for the pub access mapping ref service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = PubAccessMappingRefPersistence.class)
public class PubAccessMappingRefPersistenceImpl
	extends BasePersistenceImpl<PubAccessMappingRef>
	implements PubAccessMappingRefPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>PubAccessMappingRefUtil</code> to access the pub access mapping ref persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		PubAccessMappingRefImpl.class.getName();

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
	 * Returns the pub access mapping ref where ahmc_app_code = &#63; and division = &#63; or throws a <code>NoSuchPubAccessMappingRefException</code> if it could not be found.
	 *
	 * @param ahmc_app_code the ahmc_app_code
	 * @param division the division
	 * @return the matching pub access mapping ref
	 * @throws NoSuchPubAccessMappingRefException if a matching pub access mapping ref could not be found
	 */
	@Override
	public PubAccessMappingRef findByahmc_division(
			String ahmc_app_code, String division)
		throws NoSuchPubAccessMappingRefException {

		PubAccessMappingRef pubAccessMappingRef = fetchByahmc_division(
			ahmc_app_code, division);

		if (pubAccessMappingRef == null) {
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

			throw new NoSuchPubAccessMappingRefException(sb.toString());
		}

		return pubAccessMappingRef;
	}

	/**
	 * Returns the pub access mapping ref where ahmc_app_code = &#63; and division = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param ahmc_app_code the ahmc_app_code
	 * @param division the division
	 * @return the matching pub access mapping ref, or <code>null</code> if a matching pub access mapping ref could not be found
	 */
	@Override
	public PubAccessMappingRef fetchByahmc_division(
		String ahmc_app_code, String division) {

		return fetchByahmc_division(ahmc_app_code, division, true);
	}

	/**
	 * Returns the pub access mapping ref where ahmc_app_code = &#63; and division = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param ahmc_app_code the ahmc_app_code
	 * @param division the division
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching pub access mapping ref, or <code>null</code> if a matching pub access mapping ref could not be found
	 */
	@Override
	public PubAccessMappingRef fetchByahmc_division(
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

		if (result instanceof PubAccessMappingRef) {
			PubAccessMappingRef pubAccessMappingRef =
				(PubAccessMappingRef)result;

			if (!Objects.equals(
					ahmc_app_code, pubAccessMappingRef.getAhmc_app_code()) ||
				!Objects.equals(division, pubAccessMappingRef.getDivision())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_PUBACCESSMAPPINGREF_WHERE);

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

				List<PubAccessMappingRef> list = query.list();

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
								"PubAccessMappingRefPersistenceImpl.fetchByahmc_division(String, String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					PubAccessMappingRef pubAccessMappingRef = list.get(0);

					result = pubAccessMappingRef;

					cacheResult(pubAccessMappingRef);
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
			return (PubAccessMappingRef)result;
		}
	}

	/**
	 * Removes the pub access mapping ref where ahmc_app_code = &#63; and division = &#63; from the database.
	 *
	 * @param ahmc_app_code the ahmc_app_code
	 * @param division the division
	 * @return the pub access mapping ref that was removed
	 */
	@Override
	public PubAccessMappingRef removeByahmc_division(
			String ahmc_app_code, String division)
		throws NoSuchPubAccessMappingRefException {

		PubAccessMappingRef pubAccessMappingRef = findByahmc_division(
			ahmc_app_code, division);

		return remove(pubAccessMappingRef);
	}

	/**
	 * Returns the number of pub access mapping refs where ahmc_app_code = &#63; and division = &#63;.
	 *
	 * @param ahmc_app_code the ahmc_app_code
	 * @param division the division
	 * @return the number of matching pub access mapping refs
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

			sb.append(_SQL_COUNT_PUBACCESSMAPPINGREF_WHERE);

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
		"pubAccessMappingRef.ahmc_app_code = ? AND ";

	private static final String _FINDER_COLUMN_AHMC_DIVISION_AHMC_APP_CODE_3 =
		"(pubAccessMappingRef.ahmc_app_code IS NULL OR pubAccessMappingRef.ahmc_app_code = '') AND ";

	private static final String _FINDER_COLUMN_AHMC_DIVISION_DIVISION_2 =
		"pubAccessMappingRef.division = ?";

	private static final String _FINDER_COLUMN_AHMC_DIVISION_DIVISION_3 =
		"(pubAccessMappingRef.division IS NULL OR pubAccessMappingRef.division = '')";

	public PubAccessMappingRefPersistenceImpl() {
		setModelClass(PubAccessMappingRef.class);

		setModelImplClass(PubAccessMappingRefImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the pub access mapping ref in the entity cache if it is enabled.
	 *
	 * @param pubAccessMappingRef the pub access mapping ref
	 */
	@Override
	public void cacheResult(PubAccessMappingRef pubAccessMappingRef) {
		entityCache.putResult(
			PubAccessMappingRefImpl.class, pubAccessMappingRef.getPrimaryKey(),
			pubAccessMappingRef);

		finderCache.putResult(
			_finderPathFetchByahmc_division,
			new Object[] {
				pubAccessMappingRef.getAhmc_app_code(),
				pubAccessMappingRef.getDivision()
			},
			pubAccessMappingRef);
	}

	/**
	 * Caches the pub access mapping refs in the entity cache if it is enabled.
	 *
	 * @param pubAccessMappingRefs the pub access mapping refs
	 */
	@Override
	public void cacheResult(List<PubAccessMappingRef> pubAccessMappingRefs) {
		for (PubAccessMappingRef pubAccessMappingRef : pubAccessMappingRefs) {
			if (entityCache.getResult(
					PubAccessMappingRefImpl.class,
					pubAccessMappingRef.getPrimaryKey()) == null) {

				cacheResult(pubAccessMappingRef);
			}
		}
	}

	/**
	 * Clears the cache for all pub access mapping refs.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(PubAccessMappingRefImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the pub access mapping ref.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(PubAccessMappingRef pubAccessMappingRef) {
		entityCache.removeResult(
			PubAccessMappingRefImpl.class, pubAccessMappingRef);
	}

	@Override
	public void clearCache(List<PubAccessMappingRef> pubAccessMappingRefs) {
		for (PubAccessMappingRef pubAccessMappingRef : pubAccessMappingRefs) {
			entityCache.removeResult(
				PubAccessMappingRefImpl.class, pubAccessMappingRef);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(PubAccessMappingRefImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		PubAccessMappingRefModelImpl pubAccessMappingRefModelImpl) {

		Object[] args = new Object[] {
			pubAccessMappingRefModelImpl.getAhmc_app_code(),
			pubAccessMappingRefModelImpl.getDivision()
		};

		finderCache.putResult(
			_finderPathCountByahmc_division, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByahmc_division, args, pubAccessMappingRefModelImpl,
			false);
	}

	/**
	 * Creates a new pub access mapping ref with the primary key. Does not add the pub access mapping ref to the database.
	 *
	 * @param pub_ref_id the primary key for the new pub access mapping ref
	 * @return the new pub access mapping ref
	 */
	@Override
	public PubAccessMappingRef create(long pub_ref_id) {
		PubAccessMappingRef pubAccessMappingRef = new PubAccessMappingRefImpl();

		pubAccessMappingRef.setNew(true);
		pubAccessMappingRef.setPrimaryKey(pub_ref_id);

		return pubAccessMappingRef;
	}

	/**
	 * Removes the pub access mapping ref with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param pub_ref_id the primary key of the pub access mapping ref
	 * @return the pub access mapping ref that was removed
	 * @throws NoSuchPubAccessMappingRefException if a pub access mapping ref with the primary key could not be found
	 */
	@Override
	public PubAccessMappingRef remove(long pub_ref_id)
		throws NoSuchPubAccessMappingRefException {

		return remove((Serializable)pub_ref_id);
	}

	/**
	 * Removes the pub access mapping ref with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the pub access mapping ref
	 * @return the pub access mapping ref that was removed
	 * @throws NoSuchPubAccessMappingRefException if a pub access mapping ref with the primary key could not be found
	 */
	@Override
	public PubAccessMappingRef remove(Serializable primaryKey)
		throws NoSuchPubAccessMappingRefException {

		Session session = null;

		try {
			session = openSession();

			PubAccessMappingRef pubAccessMappingRef =
				(PubAccessMappingRef)session.get(
					PubAccessMappingRefImpl.class, primaryKey);

			if (pubAccessMappingRef == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPubAccessMappingRefException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(pubAccessMappingRef);
		}
		catch (NoSuchPubAccessMappingRefException noSuchEntityException) {
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
	protected PubAccessMappingRef removeImpl(
		PubAccessMappingRef pubAccessMappingRef) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(pubAccessMappingRef)) {
				pubAccessMappingRef = (PubAccessMappingRef)session.get(
					PubAccessMappingRefImpl.class,
					pubAccessMappingRef.getPrimaryKeyObj());
			}

			if (pubAccessMappingRef != null) {
				session.delete(pubAccessMappingRef);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (pubAccessMappingRef != null) {
			clearCache(pubAccessMappingRef);
		}

		return pubAccessMappingRef;
	}

	@Override
	public PubAccessMappingRef updateImpl(
		PubAccessMappingRef pubAccessMappingRef) {

		boolean isNew = pubAccessMappingRef.isNew();

		if (!(pubAccessMappingRef instanceof PubAccessMappingRefModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(pubAccessMappingRef.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					pubAccessMappingRef);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in pubAccessMappingRef proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom PubAccessMappingRef implementation " +
					pubAccessMappingRef.getClass());
		}

		PubAccessMappingRefModelImpl pubAccessMappingRefModelImpl =
			(PubAccessMappingRefModelImpl)pubAccessMappingRef;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(pubAccessMappingRef);
			}
			else {
				pubAccessMappingRef = (PubAccessMappingRef)session.merge(
					pubAccessMappingRef);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			PubAccessMappingRefImpl.class, pubAccessMappingRefModelImpl, false,
			true);

		cacheUniqueFindersCache(pubAccessMappingRefModelImpl);

		if (isNew) {
			pubAccessMappingRef.setNew(false);
		}

		pubAccessMappingRef.resetOriginalValues();

		return pubAccessMappingRef;
	}

	/**
	 * Returns the pub access mapping ref with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the pub access mapping ref
	 * @return the pub access mapping ref
	 * @throws NoSuchPubAccessMappingRefException if a pub access mapping ref with the primary key could not be found
	 */
	@Override
	public PubAccessMappingRef findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPubAccessMappingRefException {

		PubAccessMappingRef pubAccessMappingRef = fetchByPrimaryKey(primaryKey);

		if (pubAccessMappingRef == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPubAccessMappingRefException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return pubAccessMappingRef;
	}

	/**
	 * Returns the pub access mapping ref with the primary key or throws a <code>NoSuchPubAccessMappingRefException</code> if it could not be found.
	 *
	 * @param pub_ref_id the primary key of the pub access mapping ref
	 * @return the pub access mapping ref
	 * @throws NoSuchPubAccessMappingRefException if a pub access mapping ref with the primary key could not be found
	 */
	@Override
	public PubAccessMappingRef findByPrimaryKey(long pub_ref_id)
		throws NoSuchPubAccessMappingRefException {

		return findByPrimaryKey((Serializable)pub_ref_id);
	}

	/**
	 * Returns the pub access mapping ref with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param pub_ref_id the primary key of the pub access mapping ref
	 * @return the pub access mapping ref, or <code>null</code> if a pub access mapping ref with the primary key could not be found
	 */
	@Override
	public PubAccessMappingRef fetchByPrimaryKey(long pub_ref_id) {
		return fetchByPrimaryKey((Serializable)pub_ref_id);
	}

	/**
	 * Returns all the pub access mapping refs.
	 *
	 * @return the pub access mapping refs
	 */
	@Override
	public List<PubAccessMappingRef> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<PubAccessMappingRef> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<PubAccessMappingRef> findAll(
		int start, int end,
		OrderByComparator<PubAccessMappingRef> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<PubAccessMappingRef> findAll(
		int start, int end,
		OrderByComparator<PubAccessMappingRef> orderByComparator,
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

		List<PubAccessMappingRef> list = null;

		if (useFinderCache) {
			list = (List<PubAccessMappingRef>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_PUBACCESSMAPPINGREF);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_PUBACCESSMAPPINGREF;

				sql = sql.concat(PubAccessMappingRefModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<PubAccessMappingRef>)QueryUtil.list(
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
	 * Removes all the pub access mapping refs from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (PubAccessMappingRef pubAccessMappingRef : findAll()) {
			remove(pubAccessMappingRef);
		}
	}

	/**
	 * Returns the number of pub access mapping refs.
	 *
	 * @return the number of pub access mapping refs
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
					_SQL_COUNT_PUBACCESSMAPPINGREF);

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
		return "pub_ref_id";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_PUBACCESSMAPPINGREF;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return PubAccessMappingRefModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the pub access mapping ref persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new PubAccessMappingRefModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", PubAccessMappingRef.class.getName()));

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
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(PubAccessMappingRefImpl.class.getName());

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

	private static final String _SQL_SELECT_PUBACCESSMAPPINGREF =
		"SELECT pubAccessMappingRef FROM PubAccessMappingRef pubAccessMappingRef";

	private static final String _SQL_SELECT_PUBACCESSMAPPINGREF_WHERE =
		"SELECT pubAccessMappingRef FROM PubAccessMappingRef pubAccessMappingRef WHERE ";

	private static final String _SQL_COUNT_PUBACCESSMAPPINGREF =
		"SELECT COUNT(pubAccessMappingRef) FROM PubAccessMappingRef pubAccessMappingRef";

	private static final String _SQL_COUNT_PUBACCESSMAPPINGREF_WHERE =
		"SELECT COUNT(pubAccessMappingRef) FROM PubAccessMappingRef pubAccessMappingRef WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "pubAccessMappingRef.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No PubAccessMappingRef exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No PubAccessMappingRef exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		PubAccessMappingRefPersistenceImpl.class);

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

	private static class PubAccessMappingRefModelArgumentsResolver
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

			PubAccessMappingRefModelImpl pubAccessMappingRefModelImpl =
				(PubAccessMappingRefModelImpl)baseModel;

			long columnBitmask =
				pubAccessMappingRefModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					pubAccessMappingRefModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						pubAccessMappingRefModelImpl.getColumnBitmask(
							columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					pubAccessMappingRefModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			PubAccessMappingRefModelImpl pubAccessMappingRefModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						pubAccessMappingRefModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = pubAccessMappingRefModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}