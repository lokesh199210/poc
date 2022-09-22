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
public class DocMigrationRefSoap implements Serializable {

	public static DocMigrationRefSoap toSoapModel(DocMigrationRef model) {
		DocMigrationRefSoap soapModel = new DocMigrationRefSoap();

		soapModel.setMig_ref_id(model.getMig_ref_id());
		soapModel.setAhmc_app_code(model.getAhmc_app_code());
		soapModel.setContent_type(model.getContent_type());
		soapModel.setDivision(model.getDivision());
		soapModel.setDepartment(model.getDepartment());
		soapModel.setLiferay_document_type(model.getLiferay_document_type());
		soapModel.setLiferay_folder(model.getLiferay_folder());

		return soapModel;
	}

	public static DocMigrationRefSoap[] toSoapModels(DocMigrationRef[] models) {
		DocMigrationRefSoap[] soapModels =
			new DocMigrationRefSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static DocMigrationRefSoap[][] toSoapModels(
		DocMigrationRef[][] models) {

		DocMigrationRefSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new DocMigrationRefSoap[models.length][models[0].length];
		}
		else {
			soapModels = new DocMigrationRefSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static DocMigrationRefSoap[] toSoapModels(
		List<DocMigrationRef> models) {

		List<DocMigrationRefSoap> soapModels =
			new ArrayList<DocMigrationRefSoap>(models.size());

		for (DocMigrationRef model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new DocMigrationRefSoap[soapModels.size()]);
	}

	public DocMigrationRefSoap() {
	}

	public long getPrimaryKey() {
		return _mig_ref_id;
	}

	public void setPrimaryKey(long pk) {
		setMig_ref_id(pk);
	}

	public long getMig_ref_id() {
		return _mig_ref_id;
	}

	public void setMig_ref_id(long mig_ref_id) {
		_mig_ref_id = mig_ref_id;
	}

	public String getAhmc_app_code() {
		return _ahmc_app_code;
	}

	public void setAhmc_app_code(String ahmc_app_code) {
		_ahmc_app_code = ahmc_app_code;
	}

	public String getContent_type() {
		return _content_type;
	}

	public void setContent_type(String content_type) {
		_content_type = content_type;
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

	public String getLiferay_document_type() {
		return _liferay_document_type;
	}

	public void setLiferay_document_type(String liferay_document_type) {
		_liferay_document_type = liferay_document_type;
	}

	public String getLiferay_folder() {
		return _liferay_folder;
	}

	public void setLiferay_folder(String liferay_folder) {
		_liferay_folder = liferay_folder;
	}

	private long _mig_ref_id;
	private String _ahmc_app_code;
	private String _content_type;
	private String _division;
	private String _department;
	private String _liferay_document_type;
	private String _liferay_folder;

}