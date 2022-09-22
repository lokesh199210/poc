package com.honda.obj.mapper.beans;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.annotation.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "divisionCode" })
@Generated("jsonschema2pojo")
public class DivionCodeBean extends INDocumentBean{

	@JsonProperty("divisionCode")
	private String divisionCode;

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public DivionCodeBean() {
	}

	/**
	 *
	 * @param divisionCode
	 */
	public DivionCodeBean(String divisionCode) {
		super();
		this.divisionCode = divisionCode;
	}

	@JsonProperty("divisionCode")
	public String getDivisionCode() {
		return divisionCode;
	}

	@JsonProperty("divisionCode")
	public void setDivisionCode(String divisionCode) {
		this.divisionCode = divisionCode;
	}
	
	public String getValueByName(String name) {
		if("divisionCode".equalsIgnoreCase(name.trim())){
				return getDivisionCode();
		}else {
			return super.getValueByName(name);
		}
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(DivionCodeBean.class.getName()).append('@')
				.append(Integer.toHexString(System.identityHashCode(this))).append('[');
		sb.append("divisionCode");
		sb.append('=');
		sb.append(((this.divisionCode == null) ? "<null>" : this.divisionCode));
		sb.append(',');
		if (sb.charAt((sb.length() - 1)) == ',') {
			sb.setCharAt((sb.length() - 1), ']');
		} else {
			sb.append(']');
		}
		return sb.toString();
	}

}
