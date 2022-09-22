package com.honda.obj.mapper.beans;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "name", "id" })
@Generated("jsonschema2pojo")
public class Item {

	@JsonProperty("name")
	private String name;
	@JsonProperty("id")
	private Long id;

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public Item() {
	}

	/**
	 *
	 * @param name
	 * @param id
	 */
	public Item(String name, Long id) {
		super();
		this.name = name;
		this.id = id;
	}

	@JsonProperty("name")
	public String getName() {
		return name;
	}

	@JsonProperty("name")
	public void setName(String name) {
		this.name = name;
	}

	@JsonProperty("id")
	public Long getId() {
		return id;
	}

	@JsonProperty("id")
	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(Item.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this)))
				.append('[');
		sb.append("name");
		sb.append('=');
		sb.append(((this.name == null) ? "<null>" : this.name));
		sb.append(',');
		sb.append("id");
		sb.append('=');
		sb.append(((this.id == null) ? "<null>" : this.id));
		sb.append(',');
		if (sb.charAt((sb.length() - 1)) == ',') {
			sb.setCharAt((sb.length() - 1), ']');
		} else {
			sb.append(']');
		}
		return sb.toString();
	}

}
