package com.honda.obj.mapper.beans;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.liferay.petra.string.StringPool;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "keywordsearch", "effectiveDate", "comments", "libraryReferenceNumber", "librarySupersededInfo",
		"divisionCode" })
@Generated("jsonschema2pojo")
public class INDocumentBean {

	@JsonProperty("keywordsearch")
	private String keywordsearch;
	@JsonProperty("effectiveDate")
	private String effectiveDate;
	@JsonProperty("comments")
	private String comments;
	@JsonProperty("libraryReferenceNumber")
	private String libraryReferenceNumber;
	@JsonProperty("librarySupersededInfo")
	private String librarySupersededInfo;

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public INDocumentBean() {
	}

	/**
	 *
	 * @param divisionCode
	 * @param comments
	 * @param keywords
	 * @param libraryReferenceNumber
	 * @param librarySupersededInfo
	 * @param effectiveDate
	 */
	public INDocumentBean(String keywordsearch, String effectiveDate, String comments, String libraryReferenceNumber,
			String librarySupersededInfo) {
		super();
		this.keywordsearch = keywordsearch;
		this.effectiveDate = effectiveDate;
		this.comments = comments;
		this.libraryReferenceNumber = libraryReferenceNumber;
		this.librarySupersededInfo = librarySupersededInfo;
	}

	@JsonProperty("keywordsearch")
	public String getKeywords() {
		return keywordsearch;
	}

	@JsonProperty("keywordsearch")
	public void setKeywords(String keywords) {
		this.keywordsearch = keywords;
	}

	@JsonProperty("effectiveDate")
	public String getEffectiveDate() {
		return effectiveDate;
	}

	@JsonProperty("effectiveDate")
	public void setEffectiveDate(String effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	@JsonProperty("comments")
	public String getComments() {
		return comments;
	}

	@JsonProperty("comments")
	public void setComments(String comments) {
		this.comments = comments;
	}

	@JsonProperty("libraryReferenceNumber")
	public String getLibraryReferenceNumber() {
		return libraryReferenceNumber;
	}

	@JsonProperty("libraryReferenceNumber")
	public void setLibraryReferenceNumber(String libraryReferenceNumber) {
		this.libraryReferenceNumber = libraryReferenceNumber;
	}

	@JsonProperty("librarySupersededInfo")
	public String getLibrarySupersededInfo() {
		return librarySupersededInfo;
	}

	@JsonProperty("librarySupersededInfo")
	public void setLibrarySupersededInfo(String librarySupersededInfo) {
		this.librarySupersededInfo = librarySupersededInfo;
	}

	public String getValueByName(String name) {
		
		switch(name.trim()) {
			case "libraryReferenceNumber":
				return getLibraryReferenceNumber();
			
			case "librarySupersededInfo":
				return getLibrarySupersededInfo();
			
			case "keywordsearch" :
				
				return getKeywords();
			case "comments" :
				
				return getComments();
			case "effectiveDate" :
				
				return getEffectiveDate();
			default :
				return StringPool.BLANK;
		
		}
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(INDocumentBean.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this)))
				.append('[');
		sb.append("keywords");
		sb.append('=');
		sb.append(((this.keywordsearch == null) ? "<null>" : this.keywordsearch));
		sb.append(',');
		sb.append("effectiveDate");
		sb.append('=');
		sb.append(((this.effectiveDate == null) ? "<null>" : this.effectiveDate));
		sb.append(',');
		sb.append("comments");
		sb.append('=');
		sb.append(((this.comments == null) ? "<null>" : this.comments));
		sb.append(',');
		sb.append("libraryReferenceNumber");
		sb.append('=');
		sb.append(((this.libraryReferenceNumber == null) ? "<null>" : this.libraryReferenceNumber));
		sb.append(',');
		sb.append("librarySupersededInfo");
		sb.append('=');
		sb.append(((this.librarySupersededInfo == null) ? "<null>" : this.librarySupersededInfo));
		sb.append(',');
		if (sb.charAt((sb.length() - 1)) == ',') {
			sb.setCharAt((sb.length() - 1), ']');
		} else {
			sb.append(']');
		}
		return sb.toString();
	}

}
