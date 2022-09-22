package com.honda.obj.mapper.beans;

import java.util.List;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.ALWAYS)
@JsonPropertyOrder({ "items", "statusCode", "errorMsg" })
@Generated("jsonschema2pojo")
public class NameIdBean {

	@JsonProperty("items")
	private List<Item> items = null;
	@JsonProperty("statusCode")
	private int statusCode;
	@JsonProperty("errorMsg")
	private String errorMsg;

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public NameIdBean() {
	}

	/**
	 *
	 * @param items
	 * @param statusCode
	 * @param errorMsg
	 */
	public NameIdBean(List<Item> items, int statusCode, String errorMsg) {
		super();
		this.items = items;
		this.statusCode = statusCode;
		this.errorMsg = errorMsg;
	}

	@JsonProperty("items")
	public List<Item> getItems() {
		return items;
	}

	@JsonProperty("items")
	public void setItems(List<Item> items) {
		this.items = items;
	}

	@JsonProperty("statusCode")
	public int getStatusCode() {
		return statusCode;
	}

	@JsonProperty("statusCode")
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	@JsonProperty("errorMsg")
	public String getErrorMsg() {
		return errorMsg;
	}

	@JsonProperty("errorMsg")
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(NameIdBean.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this)))
				.append('[');
		sb.append("items");
		sb.append('=');
		sb.append(((this.items == null) ? "<null>" : this.items));
		sb.append(',');
		sb.append("statusCode");
		sb.append('=');
		sb.append(((this.statusCode == 0) ? "<null>" : this.statusCode));
		sb.append(',');
		sb.append("errorMsg");
		sb.append('=');
		sb.append(((this.errorMsg == null) ? "<null>" : this.errorMsg));
		sb.append(',');
		if (sb.charAt((sb.length() - 1)) == ',') {
			sb.setCharAt((sb.length() - 1), ']');
		} else {
			sb.append(']');
		}
		return sb.toString();
	}

}