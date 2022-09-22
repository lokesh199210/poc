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

import com.honda.external.db.sb.model.ContentMigrationRef;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing ContentMigrationRef in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ContentMigrationRefCacheModel
	implements CacheModel<ContentMigrationRef>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ContentMigrationRefCacheModel)) {
			return false;
		}

		ContentMigrationRefCacheModel contentMigrationRefCacheModel =
			(ContentMigrationRefCacheModel)object;

		if (mig_ref_id == contentMigrationRefCacheModel.mig_ref_id) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, mig_ref_id);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{mig_ref_id=");
		sb.append(mig_ref_id);
		sb.append(", ahmc_app_code=");
		sb.append(ahmc_app_code);
		sb.append(", content_type=");
		sb.append(content_type);
		sb.append(", division=");
		sb.append(division);
		sb.append(", department=");
		sb.append(department);
		sb.append(", liferay_structure=");
		sb.append(liferay_structure);
		sb.append(", liferay_folder=");
		sb.append(liferay_folder);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ContentMigrationRef toEntityModel() {
		ContentMigrationRefImpl contentMigrationRefImpl =
			new ContentMigrationRefImpl();

		contentMigrationRefImpl.setMig_ref_id(mig_ref_id);

		if (ahmc_app_code == null) {
			contentMigrationRefImpl.setAhmc_app_code("");
		}
		else {
			contentMigrationRefImpl.setAhmc_app_code(ahmc_app_code);
		}

		if (content_type == null) {
			contentMigrationRefImpl.setContent_type("");
		}
		else {
			contentMigrationRefImpl.setContent_type(content_type);
		}

		if (division == null) {
			contentMigrationRefImpl.setDivision("");
		}
		else {
			contentMigrationRefImpl.setDivision(division);
		}

		if (department == null) {
			contentMigrationRefImpl.setDepartment("");
		}
		else {
			contentMigrationRefImpl.setDepartment(department);
		}

		if (liferay_structure == null) {
			contentMigrationRefImpl.setLiferay_structure("");
		}
		else {
			contentMigrationRefImpl.setLiferay_structure(liferay_structure);
		}

		if (liferay_folder == null) {
			contentMigrationRefImpl.setLiferay_folder("");
		}
		else {
			contentMigrationRefImpl.setLiferay_folder(liferay_folder);
		}

		contentMigrationRefImpl.resetOriginalValues();

		return contentMigrationRefImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		mig_ref_id = objectInput.readLong();
		ahmc_app_code = objectInput.readUTF();
		content_type = objectInput.readUTF();
		division = objectInput.readUTF();
		department = objectInput.readUTF();
		liferay_structure = objectInput.readUTF();
		liferay_folder = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(mig_ref_id);

		if (ahmc_app_code == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ahmc_app_code);
		}

		if (content_type == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(content_type);
		}

		if (division == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(division);
		}

		if (department == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(department);
		}

		if (liferay_structure == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(liferay_structure);
		}

		if (liferay_folder == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(liferay_folder);
		}
	}

	public long mig_ref_id;
	public String ahmc_app_code;
	public String content_type;
	public String division;
	public String department;
	public String liferay_structure;
	public String liferay_folder;

}