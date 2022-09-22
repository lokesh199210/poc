package com.honda.obj.mapper.beans;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "folder", "title", "version", "assetId" })
@Generated("jsonschema2pojo")
public class Details {

	@JsonProperty("folder")
	private String folder;
	@JsonProperty("title")
	private String title;
	@JsonProperty("version")
	private String version;
	@JsonProperty("assetId")
	private long assetId;

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public Details() {
	}

	/**
	 *
	 * @param folder
	 * @param title
	 * @param version
	 * @param assetId
	 */
	public Details(String folder, String title, String version, long assetId) {
		super();
		this.folder = folder;
		this.title = title;
		this.version = version;
		this.assetId = assetId;
	}

	@JsonProperty("folder")
	public String getFolder() {
		return folder;
	}

	@JsonProperty("title")
	public String getTitle() {
		return title;
	}

	@JsonProperty("version")
	public String getVersion() {
		return version;
	}

	@JsonProperty("assetId")
	public long getAssetId() {
		return assetId;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(Details.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this)))
				.append('[');
		sb.append("folder");
		sb.append('=');
		sb.append(((this.folder == null) ? "<null>" : this.folder));
		sb.append(',');
		sb.append("title");
		sb.append('=');
		sb.append(((this.title == null) ? "<null>" : this.title));
		sb.append(',');
		sb.append("version");
		sb.append('=');
		sb.append(((this.version == null) ? "<null>" : this.version));
		sb.append(',');
		sb.append("assetId");
		sb.append('=');
		sb.append(((this.assetId == 0) ? "<null>" : this.assetId));
		sb.append(',');
		if (sb.charAt((sb.length() - 1)) == ',') {
			sb.setCharAt((sb.length() - 1), ']');
		} else {
			sb.append(']');
		}
		return sb.toString();
	}

}
