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

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing PubAccessMappingRef in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class PubAccessMappingRefCacheModel
	implements CacheModel<PubAccessMappingRef>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof PubAccessMappingRefCacheModel)) {
			return false;
		}

		PubAccessMappingRefCacheModel pubAccessMappingRefCacheModel =
			(PubAccessMappingRefCacheModel)object;

		if (pub_ref_id == pubAccessMappingRefCacheModel.pub_ref_id) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, pub_ref_id);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{pub_ref_id=");
		sb.append(pub_ref_id);
		sb.append(", ahmc_app_code=");
		sb.append(ahmc_app_code);
		sb.append(", search_filter=");
		sb.append(search_filter);
		sb.append(", division=");
		sb.append(division);
		sb.append(", department=");
		sb.append(department);
		sb.append(", asset_type=");
		sb.append(asset_type);
		sb.append(", asset_id=");
		sb.append(asset_id);
		sb.append(", publication_name=");
		sb.append(publication_name);
		sb.append(", liferay_folder=");
		sb.append(liferay_folder);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public PubAccessMappingRef toEntityModel() {
		PubAccessMappingRefImpl pubAccessMappingRefImpl =
			new PubAccessMappingRefImpl();

		pubAccessMappingRefImpl.setPub_ref_id(pub_ref_id);

		if (ahmc_app_code == null) {
			pubAccessMappingRefImpl.setAhmc_app_code("");
		}
		else {
			pubAccessMappingRefImpl.setAhmc_app_code(ahmc_app_code);
		}

		if (search_filter == null) {
			pubAccessMappingRefImpl.setSearch_filter("");
		}
		else {
			pubAccessMappingRefImpl.setSearch_filter(search_filter);
		}

		if (division == null) {
			pubAccessMappingRefImpl.setDivision("");
		}
		else {
			pubAccessMappingRefImpl.setDivision(division);
		}

		if (department == null) {
			pubAccessMappingRefImpl.setDepartment("");
		}
		else {
			pubAccessMappingRefImpl.setDepartment(department);
		}

		if (asset_type == null) {
			pubAccessMappingRefImpl.setAsset_type("");
		}
		else {
			pubAccessMappingRefImpl.setAsset_type(asset_type);
		}

		pubAccessMappingRefImpl.setAsset_id(asset_id);

		if (publication_name == null) {
			pubAccessMappingRefImpl.setPublication_name("");
		}
		else {
			pubAccessMappingRefImpl.setPublication_name(publication_name);
		}

		if (liferay_folder == null) {
			pubAccessMappingRefImpl.setLiferay_folder("");
		}
		else {
			pubAccessMappingRefImpl.setLiferay_folder(liferay_folder);
		}

		pubAccessMappingRefImpl.resetOriginalValues();

		return pubAccessMappingRefImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		pub_ref_id = objectInput.readLong();
		ahmc_app_code = objectInput.readUTF();
		search_filter = objectInput.readUTF();
		division = objectInput.readUTF();
		department = objectInput.readUTF();
		asset_type = objectInput.readUTF();

		asset_id = objectInput.readLong();
		publication_name = objectInput.readUTF();
		liferay_folder = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(pub_ref_id);

		if (ahmc_app_code == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ahmc_app_code);
		}

		if (search_filter == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(search_filter);
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

		if (asset_type == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(asset_type);
		}

		objectOutput.writeLong(asset_id);

		if (publication_name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(publication_name);
		}

		if (liferay_folder == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(liferay_folder);
		}
	}

	public long pub_ref_id;
	public String ahmc_app_code;
	public String search_filter;
	public String division;
	public String department;
	public String asset_type;
	public long asset_id;
	public String publication_name;
	public String liferay_folder;

}