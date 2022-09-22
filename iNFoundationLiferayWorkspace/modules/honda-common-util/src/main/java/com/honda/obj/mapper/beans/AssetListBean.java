package com.honda.obj.mapper.beans;

import java.util.List;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonPropertyOrder({ "statusCode", "items" })
@Generated("jsonschema2pojo")
public class AssetListBean {

	@JsonProperty("statusCode")
	private Integer statusCode;
	@JsonProperty("items")
	private List<Object> items = null;

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public AssetListBean() {
	}

	/**
	 *
	 * @param items
	 * @param statusCode
	 */
	public AssetListBean(Integer statusCode, List<Object> items) {
		super();
		this.statusCode = statusCode;
		this.items = items;
	}

	@JsonProperty("statusCode")
	public Integer getStatusCode() {
		return statusCode;
	}

	@JsonProperty("statusCode")
	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}

	@JsonProperty("items")
	public List<Object> getItems() {
		return items;
	}

	@JsonProperty("items")
	public void setItems(List<Object> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(AssetListBean.class.getName()).append('@')
				.append(Integer.toHexString(System.identityHashCode(this))).append('[');
		sb.append("statusCode");
		sb.append('=');
		sb.append(((this.statusCode == null) ? "<null>" : this.statusCode));
		sb.append(',');
		sb.append("items");
		sb.append('=');
		sb.append(((this.items == null) ? "<null>" : this.items));
		sb.append(',');
		if (sb.charAt((sb.length() - 1)) == ',') {
			sb.setCharAt((sb.length() - 1), ']');
		} else {
			sb.append(']');
		}
		return sb.toString();
	}

}