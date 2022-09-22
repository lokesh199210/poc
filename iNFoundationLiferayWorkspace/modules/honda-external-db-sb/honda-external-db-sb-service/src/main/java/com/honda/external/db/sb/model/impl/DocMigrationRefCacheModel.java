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

import com.honda.external.db.sb.model.DocMigrationRef;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing DocMigrationRef in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class DocMigrationRefCacheModel
	implements CacheModel<DocMigrationRef>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof DocMigrationRefCacheModel)) {
			return false;
		}

		DocMigrationRefCacheModel docMigrationRefCacheModel =
			(DocMigrationRefCacheModel)object;

		if (mig_ref_id == docMigrationRefCacheModel.mig_ref_id) {
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
		sb.append(", liferay_document_type=");
		sb.append(liferay_document_type);
		sb.append(", liferay_folder=");
		sb.append(liferay_folder);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public DocMigrationRef toEntityModel() {
		DocMigrationRefImpl docMigrationRefImpl = new DocMigrationRefImpl();

		docMigrationRefImpl.setMig_ref_id(mig_ref_id);

		if (ahmc_app_code == null) {
			docMigrationRefImpl.setAhmc_app_code("");
		}
		else {
			docMigrationRefImpl.setAhmc_app_code(ahmc_app_code);
		}

		if (content_type == null) {
			docMigrationRefImpl.setContent_type("");
		}
		else {
			docMigrationRefImpl.setContent_type(content_type);
		}

		if (division == null) {
			docMigrationRefImpl.setDivision("");
		}
		else {
			docMigrationRefImpl.setDivision(division);
		}

		if (department == null) {
			docMigrationRefImpl.setDepartment("");
		}
		else {
			docMigrationRefImpl.setDepartment(department);
		}

		if (liferay_document_type == null) {
			docMigrationRefImpl.setLiferay_document_type("");
		}
		else {
			docMigrationRefImpl.setLiferay_document_type(liferay_document_type);
		}

		if (liferay_folder == null) {
			docMigrationRefImpl.setLiferay_folder("");
		}
		else {
			docMigrationRefImpl.setLiferay_folder(liferay_folder);
		}

		docMigrationRefImpl.resetOriginalValues();

		return docMigrationRefImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		mig_ref_id = objectInput.readLong();
		ahmc_app_code = objectInput.readUTF();
		content_type = objectInput.readUTF();
		division = objectInput.readUTF();
		department = objectInput.readUTF();
		liferay_document_type = objectInput.readUTF();
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

		if (liferay_document_type == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(liferay_document_type);
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
	public String liferay_document_type;
	public String liferay_folder;

}