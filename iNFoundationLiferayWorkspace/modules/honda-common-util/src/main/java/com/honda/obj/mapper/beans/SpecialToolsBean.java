
package com.honda.obj.mapper.beans;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "bulletinNumber", "issueDate" })
@Generated("jsonschema2pojo")
public class SpecialToolsBean extends INDocumentBean {
	@JsonProperty("bulletinNumber")
	private String bulletinNumber;
	@JsonProperty("issueDate")
	private String issueDate;

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public SpecialToolsBean() {
	}

	/**
	 *
	 * @param productLine
	 * @param year
	 * @param yearModel
	 * @param partNumbers
	 * @param model
	 * @param issueDate
	 */
	public SpecialToolsBean(String bulletinNumber, String issueDate) {
		super();
		this.bulletinNumber = bulletinNumber;
		this.issueDate = issueDate;
	}

	@JsonProperty("bulletinNumber")
	public String getBulletinNumber() {
		return bulletinNumber;
	}

	@JsonProperty("bulletinNumber")
	public void setYearModel(String bulletinNumber) {
		this.bulletinNumber = bulletinNumber;
	}

	@JsonProperty("issueDate")
	public String getIssueDate() {
		return issueDate;
	}

	@JsonProperty("issueDate")
	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
	}

	public String getValueByName(String name) {
		System.out.println(" name :" + name);
		switch (name.trim()) {
		case "bulletinNumber":
			return getBulletinNumber();
		case "issueDate":
			return getIssueDate();
		default:
			return super.getValueByName(name);
		}
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(AccessoryInstallationBean.class.getName()).append('@')
				.append(Integer.toHexString(System.identityHashCode(this))).append('[');
		sb.append("bulletinNumbet");
		sb.append('=');
		sb.append(((this.bulletinNumber == null) ? "<null>" : this.bulletinNumber));
		sb.append(',');
		sb.append("issueDate");
		sb.append('=');
		sb.append(((this.issueDate == null) ? "<null>" : this.issueDate));
		sb.append(',');
		if (sb.charAt((sb.length() - 1)) == ',') {
			sb.setCharAt((sb.length() - 1), ']');
		} else {
			sb.append(']');
		}
		return sb.toString();
	}
}
