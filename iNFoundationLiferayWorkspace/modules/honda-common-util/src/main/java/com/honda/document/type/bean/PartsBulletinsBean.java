package com.honda.document.type.bean;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.liferay.petra.string.StringPool;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonPropertyOrder({ "keywordsearch", "bulletinnumber", "issuedate" })
@Generated("jsonschema2pojo")
public class PartsBulletinsBean {

	@JsonProperty("keywordsearch")
	private String keywordsearch;
	@JsonProperty("bulletinnumber")
	private String bulletinnumber;
	@JsonProperty("issuedate")
	private String issuedate;

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public PartsBulletinsBean() {
	}

	/**
	 *
	 * @param keywordsearch
	 * @param bulletinnumber
	 * @param issuedate
	 */
	public PartsBulletinsBean(String keywordsearch, String bulletinnumber, String issuedate) {
		super();
		this.keywordsearch = keywordsearch;
		this.bulletinnumber = bulletinnumber;
		this.issuedate = issuedate;
	}

	@JsonProperty("keywordsearch")
	public String getKeywordsearch() {
		return keywordsearch;
	}

	@JsonProperty("keywordsearch")
	public void setKeywordsearch(String keywordsearch) {
		this.keywordsearch = keywordsearch;
	}

	@JsonProperty("bulletinnumber")
	public String getBulletinnumber() {
		return bulletinnumber;
	}

	@JsonProperty("bulletinnumber")
	public void setBulletinnumber(String bulletinnumber) {
		this.bulletinnumber = bulletinnumber;
	}

	@JsonProperty("issuedate")
	public String getIssuedate() {
		return issuedate;
	}

	@JsonProperty("issuedate")
	public void setIssuedate(String issuedate) {
		this.issuedate = issuedate;
	}
	
	public String getValueByName(String name) {
		switch(name.trim()) {
			case "keywordsearch":
				return getKeywordsearch();
			
			case "bulletinnumber":
				return getBulletinnumber();
			case "issuedate":
				return getIssuedate();
			default :
				return StringPool.BLANK;
		
		}
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(PartsBulletinsBean.class.getName()).append('@')
				.append(Integer.toHexString(System.identityHashCode(this))).append('[');
		sb.append("keywordsearch");
		sb.append('=');
		sb.append(((this.keywordsearch == null) ? "<null>" : this.keywordsearch));
		sb.append(',');
		sb.append("bulletinnumber");
		sb.append('=');
		sb.append(((this.bulletinnumber == null) ? "<null>" : this.bulletinnumber));
		sb.append(',');
		sb.append("issuedate");
		sb.append('=');
		sb.append(((this.issuedate == null) ? "<null>" : this.issuedate));
		sb.append(',');
		if (sb.charAt((sb.length() - 1)) == ',') {
			sb.setCharAt((sb.length() - 1), ']');
		} else {
			sb.append(']');
		}
		return sb.toString();
	}

}