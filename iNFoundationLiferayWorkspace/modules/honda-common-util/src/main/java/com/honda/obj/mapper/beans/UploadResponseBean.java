package com.honda.obj.mapper.beans;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.ALWAYS)
@JsonPropertyOrder({ "statusCode", "errorMsg", "details" })
@Generated("jsonschema2pojo")
public class UploadResponseBean {

	@JsonProperty("statusCode")
	private Integer statusCode;
	@JsonProperty("errorMsg")
	private String errorMsg;
	@JsonProperty("details")
	private Details details;

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public UploadResponseBean() {
	}

	/**
	 *
	 * @param details
	 * @param statusCode
	 * @param errorMsg
	 */
	public UploadResponseBean(Integer statusCode, String errorMsg, Details details) {
		super();
		this.statusCode = statusCode;
		this.errorMsg = errorMsg;
		this.details = details;
	}

	@JsonProperty("statusCode")
	public Integer getStatusCode() {
		return statusCode;
	}

	@JsonProperty("errorMsg")
	public String getErrorMsg() {
		return errorMsg;
	}

	@JsonProperty("details")
	public Details getDetails() {
		return details;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(UploadResponseBean.class.getName()).append('@')
				.append(Integer.toHexString(System.identityHashCode(this))).append('[');
		sb.append("statusCode");
		sb.append('=');
		sb.append(((this.statusCode == null) ? "<null>" : this.statusCode));
		sb.append(',');
		sb.append("errorMsg");
		sb.append('=');
		sb.append(((this.errorMsg == null) ? "<null>" : this.errorMsg));
		sb.append(',');
		sb.append("details");
		sb.append('=');
		sb.append(((this.details == null) ? "<null>" : this.details));
		sb.append(',');
		if (sb.charAt((sb.length() - 1)) == ',') {
			sb.setCharAt((sb.length() - 1), ']');
		} else {
			sb.append(']');
		}
		return sb.toString();
	}

}
