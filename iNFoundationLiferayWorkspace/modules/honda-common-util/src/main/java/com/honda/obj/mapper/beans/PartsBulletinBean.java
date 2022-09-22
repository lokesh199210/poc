package com.honda.obj.mapper.beans;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.liferay.petra.string.StringPool;

import javax.annotation.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "bulletinNumber", "year", "productLine", "categories", "partNumbers",
		"issueDate", "_yearModel", "model" })
@Generated("jsonschema2pojo")
public class PartsBulletinBean extends INDocumentBean{

	@JsonProperty("bulletinNumber")
	private String bulletinNumber;
	@JsonProperty("year")
	private String year;
	@JsonProperty("productLine")
	private String productLine;
	@JsonProperty("partNumbers")
	private String partNumbers;
	@JsonProperty("issueDate")
	private String issueDate;
	@JsonProperty("_yearModel")
	private String yearModel;
	@JsonProperty("model")
	private String model;

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public PartsBulletinBean() {
	}

	/**
	 *
	 * @param productLine
	 * @param dealerLevel
	 * @param keywords
	 * @param year
	 * @param libraryReferenceNumber
	 * @param mropCalendarModelOrderingHorizon
	 * @param bulletinNumber
	 * @param partNumbers
	 * @param categories
	 * @param issueDate
	 * @param librarySupersededInfo
	 * @param effectiveDate
	 * @param yearModel
	 * @param model
	 */
	public PartsBulletinBean(String bulletinNumber, String year, String productLine, String categories, String keywords,
			String dealerLevel, String partNumbers, String issueDate, String mropCalendarModelOrderingHorizon,
			String libraryReferenceNumber, String librarySupersededInfo, String effectiveDate, String yearModel,
			String model) {
		super();
		this.bulletinNumber = bulletinNumber;
		this.year = year;
		this.productLine = productLine;
		this.partNumbers = partNumbers;
		this.issueDate = issueDate;
		this.yearModel = yearModel;
		this.model = model;
	}

	@JsonProperty("bulletinNumber")
	public String getBulletinNumber() {
		return bulletinNumber;
	}

	@JsonProperty("bulletinNumber")
	public void setBulletinNumber(String bulletinNumber) {
		this.bulletinNumber = bulletinNumber;
	}

	@JsonProperty("year")
	public String getYear() {
		return year;
	}

	@JsonProperty("year")
	public void setYear(String year) {
		this.year = year;
	}

	@JsonProperty("productLine")
	public String getProductLine() {
		return productLine;
	}

	@JsonProperty("productLine")
	public void setProductLine(String productLine) {
		this.productLine = productLine;
	}

	@JsonProperty("partNumbers")
	public String getPartNumbers() {
		return partNumbers;
	}

	@JsonProperty("partNumbers")
	public void setPartNumbers(String partNumbers) {
		this.partNumbers = partNumbers;
	}

	@JsonProperty("issueDate")
	public String getIssueDate() {
		return issueDate;
	}

	@JsonProperty("issueDate")
	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
	}

	@JsonProperty("_yearModel")
	public String getYearModel() {
		return yearModel;
	}

	@JsonProperty("_yearModel")
	public void setYearModel(String yearModel) {
		this.yearModel = yearModel;
	}

	@JsonProperty("model")
	public String getModel() {
		return model;
	}

	@JsonProperty("model")
	public void setModel(String model) {
		this.model = model;
	}

	public String getValueByName(String name) {
		switch (name.trim()) {

		case "bulletinNumber":
			return getBulletinNumber();
		case "year":
			return getYear();
		case "partNumbers":
			return getPartNumbers();
		case "issueDate":
			return getIssueDate();
		case "productLine":
			return getProductLine();
		case "_yearModel":
			return getYearModel();
		case "model":
			return getModel();
		default:
			return super.getValueByName(name);

		}
	}

}