package com.honda.obj.mapper.beans;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.ALWAYS)
@JsonPropertyOrder({ "division", "department", "ahmcAppCode", "assetType" })
@Generated("jsonschema2pojo")
public class RequestBodyBean {

	@JsonProperty("division")
	private String division;
	@JsonProperty("department")
	private String department;
	@JsonProperty("ahmcAppCode")
	private String ahmcAppCode;
	@JsonProperty("assetType")
	private String assetType;

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public RequestBodyBean() {
	}

	/**
	 *
	 * @param division
	 * @param ahmcAppCode
	 * @param department
	 */
	public RequestBodyBean(String division, String department, String ahmcAppCode, String assetType) {
		super();
		this.division = division;
		this.department = department;
		this.ahmcAppCode = ahmcAppCode;
		this.assetType = assetType;
	}

	@JsonProperty("division")
	public String getDivision() {
		return division;
	}

	@JsonProperty("division")
	public void setDivision(String division) {
		this.division = division;
	}

	@JsonProperty("department")
	public String getDepartment() {
		return department;
	}

	@JsonProperty("department")
	public void setDepartment(String department) {
		this.department = department;
	}

	@JsonProperty("ahmcAppCode")
	public String getAhmcAppCode() {
		return ahmcAppCode;
	}

	@JsonProperty("ahmcAppCode")
	public void setAhmcAppCode(String ahmcAppCode) {
		this.ahmcAppCode = ahmcAppCode;
	}
	
	@JsonProperty("assetType")
	public String getAssetType() {
		return assetType;
	}

	@JsonProperty("assetType")
	public void setAssetType(String assetType) {
		this.assetType = assetType;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(RequestBodyBean.class.getName()).append('@')
				.append(Integer.toHexString(System.identityHashCode(this))).append('[');
		sb.append("division");
		sb.append('=');
		sb.append(((this.division == null) ? "<null>" : this.division));
		sb.append(',');
		sb.append("department");
		sb.append('=');
		sb.append(((this.department == null) ? "<null>" : this.department));
		sb.append(',');
		sb.append("ahmcAppCode");
		sb.append('=');
		sb.append(((this.ahmcAppCode == null) ? "<null>" : this.ahmcAppCode));
		sb.append(',');
		sb.append("assetType");
		sb.append('=');
		sb.append(((this.assetType == null) ? "<null>" : this.assetType));
		sb.append(',');
		if (sb.charAt((sb.length() - 1)) == ',') {
			sb.setCharAt((sb.length() - 1), ']');
		} else {
			sb.append(']');
		}
		return sb.toString();
	}

}
