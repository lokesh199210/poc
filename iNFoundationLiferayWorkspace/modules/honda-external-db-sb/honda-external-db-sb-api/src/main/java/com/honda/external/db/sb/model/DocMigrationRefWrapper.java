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
 * This class is a wrapper for {@link DocMigrationRef}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DocMigrationRef
 * @generated
 */
public class DocMigrationRefWrapper
	extends BaseModelWrapper<DocMigrationRef>
	implements DocMigrationRef, ModelWrapper<DocMigrationRef> {

	public DocMigrationRefWrapper(DocMigrationRef docMigrationRef) {
		super(docMigrationRef);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("mig_ref_id", getMig_ref_id());
		attributes.put("ahmc_app_code", getAhmc_app_code());
		attributes.put("content_type", getContent_type());
		attributes.put("division", getDivision());
		attributes.put("department", getDepartment());
		attributes.put("liferay_document_type", getLiferay_document_type());
		attributes.put("liferay_folder", getLiferay_folder());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long mig_ref_id = (Long)attributes.get("mig_ref_id");

		if (mig_ref_id != null) {
			setMig_ref_id(mig_ref_id);
		}

		String ahmc_app_code = (String)attributes.get("ahmc_app_code");

		if (ahmc_app_code != null) {
			setAhmc_app_code(ahmc_app_code);
		}

		String content_type = (String)attributes.get("content_type");

		if (content_type != null) {
			setContent_type(content_type);
		}

		String division = (String)attributes.get("division");

		if (division != null) {
			setDivision(division);
		}

		String department = (String)attributes.get("department");

		if (department != null) {
			setDepartment(department);
		}

		String liferay_document_type = (String)attributes.get(
			"liferay_document_type");

		if (liferay_document_type != null) {
			setLiferay_document_type(liferay_document_type);
		}

		String liferay_folder = (String)attributes.get("liferay_folder");

		if (liferay_folder != null) {
			setLiferay_folder(liferay_folder);
		}
	}

	/**
	 * Returns the ahmc_app_code of this doc migration ref.
	 *
	 * @return the ahmc_app_code of this doc migration ref
	 */
	@Override
	public String getAhmc_app_code() {
		return model.getAhmc_app_code();
	}

	/**
	 * Returns the content_type of this doc migration ref.
	 *
	 * @return the content_type of this doc migration ref
	 */
	@Override
	public String getContent_type() {
		return model.getContent_type();
	}

	/**
	 * Returns the department of this doc migration ref.
	 *
	 * @return the department of this doc migration ref
	 */
	@Override
	public String getDepartment() {
		return model.getDepartment();
	}

	/**
	 * Returns the division of this doc migration ref.
	 *
	 * @return the division of this doc migration ref
	 */
	@Override
	public String getDivision() {
		return model.getDivision();
	}

	/**
	 * Returns the liferay_document_type of this doc migration ref.
	 *
	 * @return the liferay_document_type of this doc migration ref
	 */
	@Override
	public String getLiferay_document_type() {
		return model.getLiferay_document_type();
	}

	/**
	 * Returns the liferay_folder of this doc migration ref.
	 *
	 * @return the liferay_folder of this doc migration ref
	 */
	@Override
	public String getLiferay_folder() {
		return model.getLiferay_folder();
	}

	/**
	 * Returns the mig_ref_id of this doc migration ref.
	 *
	 * @return the mig_ref_id of this doc migration ref
	 */
	@Override
	public long getMig_ref_id() {
		return model.getMig_ref_id();
	}

	/**
	 * Returns the primary key of this doc migration ref.
	 *
	 * @return the primary key of this doc migration ref
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the ahmc_app_code of this doc migration ref.
	 *
	 * @param ahmc_app_code the ahmc_app_code of this doc migration ref
	 */
	@Override
	public void setAhmc_app_code(String ahmc_app_code) {
		model.setAhmc_app_code(ahmc_app_code);
	}

	/**
	 * Sets the content_type of this doc migration ref.
	 *
	 * @param content_type the content_type of this doc migration ref
	 */
	@Override
	public void setContent_type(String content_type) {
		model.setContent_type(content_type);
	}

	/**
	 * Sets the department of this doc migration ref.
	 *
	 * @param department the department of this doc migration ref
	 */
	@Override
	public void setDepartment(String department) {
		model.setDepartment(department);
	}

	/**
	 * Sets the division of this doc migration ref.
	 *
	 * @param division the division of this doc migration ref
	 */
	@Override
	public void setDivision(String division) {
		model.setDivision(division);
	}

	/**
	 * Sets the liferay_document_type of this doc migration ref.
	 *
	 * @param liferay_document_type the liferay_document_type of this doc migration ref
	 */
	@Override
	public void setLiferay_document_type(String liferay_document_type) {
		model.setLiferay_document_type(liferay_document_type);
	}

	/**
	 * Sets the liferay_folder of this doc migration ref.
	 *
	 * @param liferay_folder the liferay_folder of this doc migration ref
	 */
	@Override
	public void setLiferay_folder(String liferay_folder) {
		model.setLiferay_folder(liferay_folder);
	}

	/**
	 * Sets the mig_ref_id of this doc migration ref.
	 *
	 * @param mig_ref_id the mig_ref_id of this doc migration ref
	 */
	@Override
	public void setMig_ref_id(long mig_ref_id) {
		model.setMig_ref_id(mig_ref_id);
	}

	/**
	 * Sets the primary key of this doc migration ref.
	 *
	 * @param primaryKey the primary key of this doc migration ref
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	@Override
	protected DocMigrationRefWrapper wrap(DocMigrationRef docMigrationRef) {
		return new DocMigrationRefWrapper(docMigrationRef);
	}

}