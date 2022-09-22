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

package com.honda.external.db.sb.model.impl;

import com.honda.external.db.sb.model.PubAccessMappingRef;
import com.honda.external.db.sb.model.PubAccessMappingRefModel;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.ProxyUtil;

import java.io.Serializable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;

import java.sql.Types;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the PubAccessMappingRef service. Represents a row in the &quot;Publication_Access_Mapping_Ref&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>PubAccessMappingRefModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link PubAccessMappingRefImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PubAccessMappingRefImpl
 * @generated
 */
public class PubAccessMappingRefModelImpl
	extends BaseModelImpl<PubAccessMappingRef>
	implements PubAccessMappingRefModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a pub access mapping ref model instance should use the <code>PubAccessMappingRef</code> interface instead.
	 */
	public static final String TABLE_NAME = "Publication_Access_Mapping_Ref";

	public static final Object[][] TABLE_COLUMNS = {
		{"pub_ref_id", Types.BIGINT}, {"ahmc_app_code", Types.VARCHAR},
		{"search_filter", Types.VARCHAR}, {"division", Types.VARCHAR},
		{"department", Types.VARCHAR}, {"asset_type", Types.VARCHAR},
		{"asset_id", Types.BIGINT}, {"publication_name", Types.VARCHAR},
		{"liferay_folder", Types.VARCHAR}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("pub_ref_id", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("ahmc_app_code", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("search_filter", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("division", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("department", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("asset_type", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("asset_id", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("publication_name", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("liferay_folder", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE =
		"create table Publication_Access_Mapping_Ref (pub_ref_id LONG not null primary key,ahmc_app_code VARCHAR(75) null,search_filter VARCHAR(75) null,division VARCHAR(75) null,department VARCHAR(75) null,asset_type VARCHAR(75) null,asset_id LONG,publication_name VARCHAR(75) null,liferay_folder VARCHAR(75) null)";

	public static final String TABLE_SQL_DROP =
		"drop table Publication_Access_Mapping_Ref";

	public static final String ORDER_BY_JPQL =
		" ORDER BY pubAccessMappingRef.pub_ref_id ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY Publication_Access_Mapping_Ref.pub_ref_id ASC";

	public static final String DATA_SOURCE = "extDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long AHMC_APP_CODE_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long DIVISION_COLUMN_BITMASK = 2L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long PUB_REF_ID_COLUMN_BITMASK = 4L;

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setEntityCacheEnabled(boolean entityCacheEnabled) {
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setFinderCacheEnabled(boolean finderCacheEnabled) {
	}

	public PubAccessMappingRefModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _pub_ref_id;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setPub_ref_id(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _pub_ref_id;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return PubAccessMappingRef.class;
	}

	@Override
	public String getModelClassName() {
		return PubAccessMappingRef.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<PubAccessMappingRef, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry<String, Function<PubAccessMappingRef, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<PubAccessMappingRef, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((PubAccessMappingRef)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<PubAccessMappingRef, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<PubAccessMappingRef, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(PubAccessMappingRef)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<PubAccessMappingRef, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<PubAccessMappingRef, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, PubAccessMappingRef>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			PubAccessMappingRef.class.getClassLoader(),
			PubAccessMappingRef.class, ModelWrapper.class);

		try {
			Constructor<PubAccessMappingRef> constructor =
				(Constructor<PubAccessMappingRef>)proxyClass.getConstructor(
					InvocationHandler.class);

			return invocationHandler -> {
				try {
					return constructor.newInstance(invocationHandler);
				}
				catch (ReflectiveOperationException
							reflectiveOperationException) {

					throw new InternalError(reflectiveOperationException);
				}
			};
		}
		catch (NoSuchMethodException noSuchMethodException) {
			throw new InternalError(noSuchMethodException);
		}
	}

	private static final Map<String, Function<PubAccessMappingRef, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<PubAccessMappingRef, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<PubAccessMappingRef, Object>>
			attributeGetterFunctions =
				new LinkedHashMap
					<String, Function<PubAccessMappingRef, Object>>();
		Map<String, BiConsumer<PubAccessMappingRef, ?>>
			attributeSetterBiConsumers =
				new LinkedHashMap<String, BiConsumer<PubAccessMappingRef, ?>>();

		attributeGetterFunctions.put(
			"pub_ref_id", PubAccessMappingRef::getPub_ref_id);
		attributeSetterBiConsumers.put(
			"pub_ref_id",
			(BiConsumer<PubAccessMappingRef, Long>)
				PubAccessMappingRef::setPub_ref_id);
		attributeGetterFunctions.put(
			"ahmc_app_code", PubAccessMappingRef::getAhmc_app_code);
		attributeSetterBiConsumers.put(
			"ahmc_app_code",
			(BiConsumer<PubAccessMappingRef, String>)
				PubAccessMappingRef::setAhmc_app_code);
		attributeGetterFunctions.put(
			"search_filter", PubAccessMappingRef::getSearch_filter);
		attributeSetterBiConsumers.put(
			"search_filter",
			(BiConsumer<PubAccessMappingRef, String>)
				PubAccessMappingRef::setSearch_filter);
		attributeGetterFunctions.put(
			"division", PubAccessMappingRef::getDivision);
		attributeSetterBiConsumers.put(
			"division",
			(BiConsumer<PubAccessMappingRef, String>)
				PubAccessMappingRef::setDivision);
		attributeGetterFunctions.put(
			"department", PubAccessMappingRef::getDepartment);
		attributeSetterBiConsumers.put(
			"department",
			(BiConsumer<PubAccessMappingRef, String>)
				PubAccessMappingRef::setDepartment);
		attributeGetterFunctions.put(
			"asset_type", PubAccessMappingRef::getAsset_type);
		attributeSetterBiConsumers.put(
			"asset_type",
			(BiConsumer<PubAccessMappingRef, String>)
				PubAccessMappingRef::setAsset_type);
		attributeGetterFunctions.put(
			"asset_id", PubAccessMappingRef::getAsset_id);
		attributeSetterBiConsumers.put(
			"asset_id",
			(BiConsumer<PubAccessMappingRef, Long>)
				PubAccessMappingRef::setAsset_id);
		attributeGetterFunctions.put(
			"publication_name", PubAccessMappingRef::getPublication_name);
		attributeSetterBiConsumers.put(
			"publication_name",
			(BiConsumer<PubAccessMappingRef, String>)
				PubAccessMappingRef::setPublication_name);
		attributeGetterFunctions.put(
			"liferay_folder", PubAccessMappingRef::getLiferay_folder);
		attributeSetterBiConsumers.put(
			"liferay_folder",
			(BiConsumer<PubAccessMappingRef, String>)
				PubAccessMappingRef::setLiferay_folder);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@Override
	public long getPub_ref_id() {
		return _pub_ref_id;
	}

	@Override
	public void setPub_ref_id(long pub_ref_id) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_pub_ref_id = pub_ref_id;
	}

	@Override
	public String getAhmc_app_code() {
		if (_ahmc_app_code == null) {
			return "";
		}
		else {
			return _ahmc_app_code;
		}
	}

	@Override
	public void setAhmc_app_code(String ahmc_app_code) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_ahmc_app_code = ahmc_app_code;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalAhmc_app_code() {
		return getColumnOriginalValue("ahmc_app_code");
	}

	@Override
	public String getSearch_filter() {
		if (_search_filter == null) {
			return "";
		}
		else {
			return _search_filter;
		}
	}

	@Override
	public void setSearch_filter(String search_filter) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_search_filter = search_filter;
	}

	@Override
	public String getDivision() {
		if (_division == null) {
			return "";
		}
		else {
			return _division;
		}
	}

	@Override
	public void setDivision(String division) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_division = division;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalDivision() {
		return getColumnOriginalValue("division");
	}

	@Override
	public String getDepartment() {
		if (_department == null) {
			return "";
		}
		else {
			return _department;
		}
	}

	@Override
	public void setDepartment(String department) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_department = department;
	}

	@Override
	public String getAsset_type() {
		if (_asset_type == null) {
			return "";
		}
		else {
			return _asset_type;
		}
	}

	@Override
	public void setAsset_type(String asset_type) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_asset_type = asset_type;
	}

	@Override
	public long getAsset_id() {
		return _asset_id;
	}

	@Override
	public void setAsset_id(long asset_id) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_asset_id = asset_id;
	}

	@Override
	public String getPublication_name() {
		if (_publication_name == null) {
			return "";
		}
		else {
			return _publication_name;
		}
	}

	@Override
	public void setPublication_name(String publication_name) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_publication_name = publication_name;
	}

	@Override
	public String getLiferay_folder() {
		if (_liferay_folder == null) {
			return "";
		}
		else {
			return _liferay_folder;
		}
	}

	@Override
	public void setLiferay_folder(String liferay_folder) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_liferay_folder = liferay_folder;
	}

	public long getColumnBitmask() {
		if (_columnBitmask > 0) {
			return _columnBitmask;
		}

		if ((_columnOriginalValues == null) ||
			(_columnOriginalValues == Collections.EMPTY_MAP)) {

			return 0;
		}

		for (Map.Entry<String, Object> entry :
				_columnOriginalValues.entrySet()) {

			if (entry.getValue() != getColumnValue(entry.getKey())) {
				_columnBitmask |= _columnBitmasks.get(entry.getKey());
			}
		}

		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			0, PubAccessMappingRef.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public PubAccessMappingRef toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, PubAccessMappingRef>
				escapedModelProxyProviderFunction =
					EscapedModelProxyProviderFunctionHolder.
						_escapedModelProxyProviderFunction;

			_escapedModel = escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		PubAccessMappingRefImpl pubAccessMappingRefImpl =
			new PubAccessMappingRefImpl();

		pubAccessMappingRefImpl.setPub_ref_id(getPub_ref_id());
		pubAccessMappingRefImpl.setAhmc_app_code(getAhmc_app_code());
		pubAccessMappingRefImpl.setSearch_filter(getSearch_filter());
		pubAccessMappingRefImpl.setDivision(getDivision());
		pubAccessMappingRefImpl.setDepartment(getDepartment());
		pubAccessMappingRefImpl.setAsset_type(getAsset_type());
		pubAccessMappingRefImpl.setAsset_id(getAsset_id());
		pubAccessMappingRefImpl.setPublication_name(getPublication_name());
		pubAccessMappingRefImpl.setLiferay_folder(getLiferay_folder());

		pubAccessMappingRefImpl.resetOriginalValues();

		return pubAccessMappingRefImpl;
	}

	@Override
	public int compareTo(PubAccessMappingRef pubAccessMappingRef) {
		long primaryKey = pubAccessMappingRef.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof PubAccessMappingRef)) {
			return false;
		}

		PubAccessMappingRef pubAccessMappingRef = (PubAccessMappingRef)object;

		long primaryKey = pubAccessMappingRef.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isEntityCacheEnabled() {
		return true;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isFinderCacheEnabled() {
		return true;
	}

	@Override
	public void resetOriginalValues() {
		_columnOriginalValues = Collections.emptyMap();

		_columnBitmask = 0;
	}

	@Override
	public CacheModel<PubAccessMappingRef> toCacheModel() {
		PubAccessMappingRefCacheModel pubAccessMappingRefCacheModel =
			new PubAccessMappingRefCacheModel();

		pubAccessMappingRefCacheModel.pub_ref_id = getPub_ref_id();

		pubAccessMappingRefCacheModel.ahmc_app_code = getAhmc_app_code();

		String ahmc_app_code = pubAccessMappingRefCacheModel.ahmc_app_code;

		if ((ahmc_app_code != null) && (ahmc_app_code.length() == 0)) {
			pubAccessMappingRefCacheModel.ahmc_app_code = null;
		}

		pubAccessMappingRefCacheModel.search_filter = getSearch_filter();

		String search_filter = pubAccessMappingRefCacheModel.search_filter;

		if ((search_filter != null) && (search_filter.length() == 0)) {
			pubAccessMappingRefCacheModel.search_filter = null;
		}

		pubAccessMappingRefCacheModel.division = getDivision();

		String division = pubAccessMappingRefCacheModel.division;

		if ((division != null) && (division.length() == 0)) {
			pubAccessMappingRefCacheModel.division = null;
		}

		pubAccessMappingRefCacheModel.department = getDepartment();

		String department = pubAccessMappingRefCacheModel.department;

		if ((department != null) && (department.length() == 0)) {
			pubAccessMappingRefCacheModel.department = null;
		}

		pubAccessMappingRefCacheModel.asset_type = getAsset_type();

		String asset_type = pubAccessMappingRefCacheModel.asset_type;

		if ((asset_type != null) && (asset_type.length() == 0)) {
			pubAccessMappingRefCacheModel.asset_type = null;
		}

		pubAccessMappingRefCacheModel.asset_id = getAsset_id();

		pubAccessMappingRefCacheModel.publication_name = getPublication_name();

		String publication_name =
			pubAccessMappingRefCacheModel.publication_name;

		if ((publication_name != null) && (publication_name.length() == 0)) {
			pubAccessMappingRefCacheModel.publication_name = null;
		}

		pubAccessMappingRefCacheModel.liferay_folder = getLiferay_folder();

		String liferay_folder = pubAccessMappingRefCacheModel.liferay_folder;

		if ((liferay_folder != null) && (liferay_folder.length() == 0)) {
			pubAccessMappingRefCacheModel.liferay_folder = null;
		}

		return pubAccessMappingRefCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<PubAccessMappingRef, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(4 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<PubAccessMappingRef, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<PubAccessMappingRef, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((PubAccessMappingRef)this));
			sb.append(", ");
		}

		if (sb.index() > 1) {
			sb.setIndex(sb.index() - 1);
		}

		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		Map<String, Function<PubAccessMappingRef, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<PubAccessMappingRef, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<PubAccessMappingRef, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((PubAccessMappingRef)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, PubAccessMappingRef>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private long _pub_ref_id;
	private String _ahmc_app_code;
	private String _search_filter;
	private String _division;
	private String _department;
	private String _asset_type;
	private long _asset_id;
	private String _publication_name;
	private String _liferay_folder;

	public <T> T getColumnValue(String columnName) {
		Function<PubAccessMappingRef, Object> function =
			_attributeGetterFunctions.get(columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((PubAccessMappingRef)this);
	}

	public <T> T getColumnOriginalValue(String columnName) {
		if (_columnOriginalValues == null) {
			return null;
		}

		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		return (T)_columnOriginalValues.get(columnName);
	}

	private void _setColumnOriginalValues() {
		_columnOriginalValues = new HashMap<String, Object>();

		_columnOriginalValues.put("pub_ref_id", _pub_ref_id);
		_columnOriginalValues.put("ahmc_app_code", _ahmc_app_code);
		_columnOriginalValues.put("search_filter", _search_filter);
		_columnOriginalValues.put("division", _division);
		_columnOriginalValues.put("department", _department);
		_columnOriginalValues.put("asset_type", _asset_type);
		_columnOriginalValues.put("asset_id", _asset_id);
		_columnOriginalValues.put("publication_name", _publication_name);
		_columnOriginalValues.put("liferay_folder", _liferay_folder);
	}

	private transient Map<String, Object> _columnOriginalValues;

	public static long getColumnBitmask(String columnName) {
		return _columnBitmasks.get(columnName);
	}

	private static final Map<String, Long> _columnBitmasks;

	static {
		Map<String, Long> columnBitmasks = new HashMap<>();

		columnBitmasks.put("pub_ref_id", 1L);

		columnBitmasks.put("ahmc_app_code", 2L);

		columnBitmasks.put("search_filter", 4L);

		columnBitmasks.put("division", 8L);

		columnBitmasks.put("department", 16L);

		columnBitmasks.put("asset_type", 32L);

		columnBitmasks.put("asset_id", 64L);

		columnBitmasks.put("publication_name", 128L);

		columnBitmasks.put("liferay_folder", 256L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private PubAccessMappingRef _escapedModel;

}