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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class PubAccessMappingRefSoap implements Serializable {

	public static PubAccessMappingRefSoap toSoapModel(
		PubAccessMappingRef model) {

		PubAccessMappingRefSoap soapModel = new PubAccessMappingRefSoap();

		soapModel.setPub_ref_id(model.getPub_ref_id());
		soapModel.setAhmc_app_code(model.getAhmc_app_code());
		soapModel.setSearch_filter(model.getSearch_filter());
		soapModel.setDivision(model.getDivision());
		soapModel.setDepartment(model.getDepartment());
		soapModel.setAsset_type(model.getAsset_type());
		soapModel.setAsset_id(model.getAsset_id());
		soapModel.setPublication_name(model.getPublication_name());
		soapModel.setLiferay_folder(model.getLiferay_folder());

		return soapModel;
	}

	public static PubAccessMappingRefSoap[] toSoapModels(
		PubAccessMappingRef[] models) {

		PubAccessMappingRefSoap[] soapModels =
			new PubAccessMappingRefSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PubAccessMappingRefSoap[][] toSoapModels(
		PubAccessMappingRef[][] models) {

		PubAccessMappingRefSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new PubAccessMappingRefSoap[models.length][models[0].length];
		}
		else {
			soapModels = new PubAccessMappingRefSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PubAccessMappingRefSoap[] toSoapModels(
		List<PubAccessMappingRef> models) {

		List<PubAccessMappingRefSoap> soapModels =
			new ArrayList<PubAccessMappingRefSoap>(models.size());

		for (PubAccessMappingRef model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new PubAccessMappingRefSoap[soapModels.size()]);
	}

	public PubAccessMappingRefSoap() {
	}

	public long getPrimaryKey() {
		return _pub_ref_id;
	}

	public void setPrimaryKey(long pk) {
		setPub_ref_id(pk);
	}

	public long getPub_ref_id() {
		return _pub_ref_id;
	}

	public void setPub_ref_id(long pub_ref_id) {
		_pub_ref_id = pub_ref_id;
	}

	public String getAhmc_app_code() {
		return _ahmc_app_code;
	}

	public void setAhmc_app_code(String ahmc_app_code) {
		_ahmc_app_code = ahmc_app_code;
	}

	public String getSearch_filter() {
		return _search_filter;
	}

	public void setSearch_filter(String search_filter) {
		_search_filter = search_filter;
	}

	public String getDivision() {
		return _division;
	}

	public void setDivision(String division) {
		_division = division;
	}

	public String getDepartment() {
		return _department;
	}

	public void setDepartment(String department) {
		_department = department;
	}

	public String getAsset_type() {
		return _asset_type;
	}

	public void setAsset_type(String asset_type) {
		_asset_type = asset_type;
	}

	public long getAsset_id() {
		return _asset_id;
	}

	public void setAsset_id(long asset_id) {
		_asset_id = asset_id;
	}

	public String getPublication_name() {
		return _publication_name;
	}

	public void setPublication_name(String publication_name) {
		_publication_name = publication_name;
	}

	public String getLiferay_folder() {
		return _liferay_folder;
	}

	public void setLiferay_folder(String liferay_folder) {
		_liferay_folder = liferay_folder;
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

}