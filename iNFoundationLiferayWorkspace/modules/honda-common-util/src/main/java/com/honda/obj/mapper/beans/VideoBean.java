package com.honda.obj.mapper.beans;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.liferay.petra.string.StringPool;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "videoValue", "date" })
@Generated("jsonschema2pojo")
public class VideoBean {

	@JsonProperty("videoValue")
	private String videoValue;
	@JsonProperty("date")
	private String date;
	
	private String videoType;

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public VideoBean() {
	}

	/**
	 *
	 * @param date
	 * @param videoValue
	 */
	public VideoBean(String videoValue, String date) {
		super();
		this.videoValue = videoValue;
		this.date = date;
	}

	@JsonProperty("videoValue")
	public String getVideoValue() {
		return videoValue;
	}

	@JsonProperty("videoValue")
	public void setVideoValue(String videoValue) {
		this.videoValue = videoValue;
		this.videoType = "videoId";
	}

	@JsonProperty("date")
	public String getDate() {
		return date;
	}

	@JsonProperty("date")
	public void setDate(String date) {
		this.date = date;
	}
	
	public String getVideoType() {
		return videoType;
	}

	public String getValueByName(String name) {

		switch (name) {

		case "videoValue":

			return getVideoValue();

		case "date":

			return getDate();
			
		case "videoSelection" :
			return getVideoType();

		default:

			return StringPool.BLANK;

		}
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(VideoBean.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this)))
				.append('[');
		sb.append("videoValue");
		sb.append('=');
		sb.append(((this.videoValue == null) ? "<null>" : this.videoValue));
		sb.append(',');
		sb.append("date");
		sb.append('=');
		sb.append(((this.date == null) ? "<null>" : this.date));
		sb.append(',');
		if (sb.charAt((sb.length() - 1)) == ',') {
			sb.setCharAt((sb.length() - 1), ']');
		} else {
			sb.append(']');
		}
		return sb.toString();
	}

}
