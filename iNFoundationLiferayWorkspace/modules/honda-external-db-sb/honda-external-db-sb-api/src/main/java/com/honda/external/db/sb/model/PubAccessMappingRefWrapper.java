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

package com.honda.external.db.sb.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link PubAccessMappingRef}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PubAccessMappingRef
 * @generated
 */
public class PubAccessMappingRefWrapper
	extends BaseModelWrapper<PubAccessMappingRef>
	implements ModelWrapper<PubAccessMappingRef>, PubAccessMappingRef {

	public PubAccessMappingRefWrapper(PubAccessMappingRef pubAccessMappingRef) {
		super(pubAccessMappingRef);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("pub_ref_id", getPub_ref_id());
		attributes.put("ahmc_app_code", getAhmc_app_code());
		attributes.put("search_filter", getSearch_filter());
		attributes.put("division", getDivision());
		attributes.put("department", getDepartment());
		attributes.put("asset_type", getAsset_type());
		attributes.put("asset_id", getAsset_id());
		attributes.put("publication_name", getPublication_name());
		attributes.put("liferay_folder", getLiferay_folder());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long pub_ref_id = (Long)attributes.get("pub_ref_id");

		if (pub_ref_id != null) {
			setPub_ref_id(pub_ref_id);
		}

		String ahmc_app_code = (String)attributes.get("ahmc_app_code");

		if (ahmc_app_code != null) {
			setAhmc_app_code(ahmc_app_code);
		}

		String search_filter = (String)attributes.get("search_filter");

		if (search_filter != null) {
			setSearch_filter(search_filter);
		}

		String division = (String)attributes.get("division");

		if (division != null) {
			setDivision(division);
		}

		String department = (String)attributes.get("department");

		if (department != null) {
			setDepartment(department);
		}

		String asset_type = (String)attributes.get("asset_type");

		if (asset_type != null) {
			setAsset_type(asset_type);
		}

		Long asset_id = (Long)attributes.get("asset_id");

		if (asset_id != null) {
			setAsset_id(asset_id);
		}

		String publication_name = (String)attributes.get("publication_name");

		if (publication_name != null) {
			setPublication_name(publication_name);
		}

		String liferay_folder = (String)attributes.get("liferay_folder");

		if (liferay_folder != null) {
			setLiferay_folder(liferay_folder);
		}
	}

	/**
	 * Returns the ahmc_app_code of this pub access mapping ref.
	 *
	 * @return the ahmc_app_code of this pub access mapping ref
	 */
	@Override
	public String getAhmc_app_code() {
		return model.getAhmc_app_code();
	}

	/**
	 * Returns the asset_id of this pub access mapping ref.
	 *
	 * @return the asset_id of this pub access mapping ref
	 */
	@Override
	public long getAsset_id() {
		return model.getAsset_id();
	}

	/**
	 * Returns the asset_type of this pub access mapping ref.
	 *
	 * @return the asset_type of this pub access mapping ref
	 */
	@Override
	public String getAsset_type() {
		return model.getAsset_type();
	}

	/**
	 * Returns the department of this pub access mapping ref.
	 *
	 * @return the department of this pub access mapping ref
	 */
	@Override
	public String getDepartment() {
		return model.getDepartment();
	}

	/**
	 * Returns the division of this pub access mapping ref.
	 *
	 * @return the division of this pub access mapping ref
	 */
	@Override
	public String getDivision() {
		return model.getDivision();
	}

	/**
	 * Returns the liferay_folder of this pub access mapping ref.
	 *
	 * @return the liferay_folder of this pub access mapping ref
	 */
	@Override
	public String getLiferay_folder() {
		return model.getLiferay_folder();
	}

	/**
	 * Returns the primary key of this pub access mapping ref.
	 *
	 * @return the primary key of this pub access mapping ref
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the pub_ref_id of this pub access mapping ref.
	 *
	 * @return the pub_ref_id of this pub access mapping ref
	 */
	@Override
	public long getPub_ref_id() {
		return model.getPub_ref_id();
	}

	/**
	 * Returns the publication_name of this pub access mapping ref.
	 *
	 * @return the publication_name of this pub access mapping ref
	 */
	@Override
	public String getPublication_name() {
		return model.getPublication_name();
	}

	/**
	 * Returns the search_filter of this pub access mapping ref.
	 *
	 * @return the search_filter of this pub access mapping ref
	 */
	@Override
	public String getSearch_filter() {
		return model.getSearch_filter();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the ahmc_app_code of this pub access mapping ref.
	 *
	 * @param ahmc_app_code the ahmc_app_code of this pub access mapping ref
	 */
	@Override
	public void setAhmc_app_code(String ahmc_app_code) {
		model.setAhmc_app_code(ahmc_app_code);
	}

	/**
	 * Sets the asset_id of this pub access mapping ref.
	 *
	 * @param asset_id the asset_id of this pub access mapping ref
	 */
	@Override
	public void setAsset_id(long asset_id) {
		model.setAsset_id(asset_id);
	}

	/**
	 * Sets the asset_type of this pub access mapping ref.
	 *
	 * @param asset_type the asset_type of this pub access mapping ref
	 */
	@Override
	public void setAsset_type(String asset_type) {
		model.setAsset_type(asset_type);
	}

	/**
	 * Sets the department of this pub access mapping ref.
	 *
	 * @param department the department of this pub access mapping ref
	 */
	@Override
	public void setDepartment(String department) {
		model.setDepartment(department);
	}

	/**
	 * Sets the division of this pub access mapping ref.
	 *
	 * @param division the division of this pub access mapping ref
	 */
	@Override
	public void setDivision(String division) {
		model.setDivision(division);
	}

	/**
	 * Sets the liferay_folder of this pub access mapping ref.
	 *
	 * @param liferay_folder the liferay_folder of this pub access mapping ref
	 */
	@Override
	public void setLiferay_folder(String liferay_folder) {
		model.setLiferay_folder(liferay_folder);
	}

	/**
	 * Sets the primary key of this pub access mapping ref.
	 *
	 * @param primaryKey the primary key of this pub access mapping ref
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the pub_ref_id of this pub access mapping ref.
	 *
	 * @param pub_ref_id the pub_ref_id of this pub access mapping ref
	 */
	@Override
	public void setPub_ref_id(long pub_ref_id) {
		model.setPub_ref_id(pub_ref_id);
	}

	/**
	 * Sets the publication_name of this pub access mapping ref.
	 *
	 * @param publication_name the publication_name of this pub access mapping ref
	 */
	@Override
	public void setPublication_name(String publication_name) {
		model.setPublication_name(publication_name);
	}

	/**
	 * Sets the search_filter of this pub access mapping ref.
	 *
	 * @param search_filter the search_filter of this pub access mapping ref
	 */
	@Override
	public void setSearch_filter(String search_filter) {
		model.setSearch_filter(search_filter);
	}

	@Override
	protected PubAccessMappingRefWrapper wrap(
		PubAccessMappingRef pubAccessMappingRef) {

		return new PubAccessMappingRefWrapper(pubAccessMappingRef);
	}

}