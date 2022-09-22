package com.honda.obj.mapper.beans;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "classPK", "groupId", "name", "alt", "title", "type", "uuid", "fileEntryId", "resourcePrimKey" })
@Generated("jsonschema2pojo")
public class ContentImageBean {

	@JsonProperty("classPK")
	private Long classPK;
	@JsonProperty("groupId")
	private Long groupId;
	@JsonProperty("name")
	private String name;
	@JsonProperty("alt")
	private String alt;
	@JsonProperty("title")
	private String title;
	@JsonProperty("type")
	private String type;
	@JsonProperty("uuid")
	private String uuid;
	@JsonProperty("fileEntryId")
	private Long fileEntryId;
	@JsonProperty("resourcePrimKey")
	private String resourcePrimKey;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public ContentImageBean() {
	}

	/**
	 *
	 * @param classPK
	 * @param groupId
	 * @param name
	 * @param alt
	 * @param title
	 * @param type
	 * @param uuid
	 * @param fileEntryId
	 * @param resourcePrimKey
	 */
	public ContentImageBean(Long classPK, Long groupId, String name, String alt, String title, String type,
			String uuid, Long fileEntryId, String resourcePrimKey) {
		super();
		this.classPK = classPK;
		this.groupId = groupId;
		this.name = name;
		this.alt = alt;
		this.title = title;
		this.type = type;
		this.uuid = uuid;
		this.fileEntryId = fileEntryId;
		this.resourcePrimKey = resourcePrimKey;
	}

	@JsonProperty("classPK")
	public Long getClassPK() {
		return classPK;
	}

	@JsonProperty("classPK")
	public void setClassPK(Long classPK) {
		this.classPK = classPK;
	}

	@JsonProperty("groupId")
	public Long getGroupId() {
		return groupId;
	}

	@JsonProperty("groupId")
	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}

	@JsonProperty("name")
	public String getName() {
		return name;
	}

	@JsonProperty("name")
	public void setName(String name) {
		this.name = name;
	}

	@JsonProperty("alt")
	public String getAlt() {
		return alt;
	}

	@JsonProperty("alt")
	public void setAlt(String alt) {
		this.alt = alt;
	}

	@JsonProperty("title")
	public String getTitle() {
		return title;
	}

	@JsonProperty("title")
	public void setTitle(String title) {
		this.title = title;
	}

	@JsonProperty("type")
	public String getType() {
		return type;
	}

	@JsonProperty("type")
	public void setType(String type) {
		this.type = type;
	}

	@JsonProperty("uuid")
	public String getUuid() {
		return uuid;
	}

	@JsonProperty("uuid")
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	@JsonProperty("fileEntryId")
	public Long getFileEntryId() {
		return fileEntryId;
	}

	@JsonProperty("fileEntryId")
	public void setFileEntryId(Long fileEntryId) {
		this.fileEntryId = fileEntryId;
	}

	@JsonProperty("resourcePrimKey")
	public String getResourcePrimKey() {
		return resourcePrimKey;
	}

	@JsonProperty("resourcePrimKey")
	public void setResourcePrimKey(String resourcePrimKey) {
		this.resourcePrimKey = resourcePrimKey;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(ContentImageBean.class.getName()).append('@')
				.append(Integer.toHexString(System.identityHashCode(this))).append('[');
		sb.append("classPK");
		sb.append('=');
		sb.append(((this.classPK == null) ? "<null>" : this.classPK));
		sb.append(',');
		sb.append("groupId");
		sb.append('=');
		sb.append(((this.groupId == null) ? "<null>" : this.groupId));
		sb.append(',');
		sb.append("name");
		sb.append('=');
		sb.append(((this.name == null) ? "<null>" : this.name));
		sb.append(',');
		sb.append("alt");
		sb.append('=');
		sb.append(((this.alt == null) ? "<null>" : this.alt));
		sb.append(',');
		sb.append("title");
		sb.append('=');
		sb.append(((this.title == null) ? "<null>" : this.title));
		sb.append(',');
		sb.append("type");
		sb.append('=');
		sb.append(((this.type == null) ? "<null>" : this.type));
		sb.append(',');
		sb.append("uuid");
		sb.append('=');
		sb.append(((this.uuid == null) ? "<null>" : this.uuid));
		sb.append(',');
		sb.append("fileEntryId");
		sb.append('=');
		sb.append(((this.fileEntryId == null) ? "<null>" : this.fileEntryId));
		sb.append(',');
		sb.append("resourcePrimKey");
		sb.append('=');
		sb.append(((this.resourcePrimKey == null) ? "<null>" : this.resourcePrimKey));
		sb.append(',');
		sb.append("additionalProperties");
		sb.append('=');
		sb.append(((this.additionalProperties == null) ? "<null>" : this.additionalProperties));
		sb.append(',');
		if (sb.charAt((sb.length() - 1)) == ',') {
			sb.setCharAt((sb.length() - 1), ']');
		} else {
			sb.append(']');
		}
		return sb.toString();
	}

}