
package com.honda.obj.mapper.beans;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"bulletinNumber",
"_yearModel",
"productLine",
"model",
"year",
"issueDate"
})
@Generated("jsonschema2pojo")
public class SetupInstructionsBean extends INDocumentBean {

@JsonProperty("bulletinNumber")
private String bulletinNumber;
@JsonProperty("_yearModel")
private String yearModel;
@JsonProperty("productLine")
private String productLine;
@JsonProperty("model")
private String model;
@JsonProperty("year")
private String year;
@JsonProperty("issueDate")
private String issueDate;

/**
* No args constructor for use in serialization
*
*/
public SetupInstructionsBean() {
}

/**
*
* @param productLine
* @param year
* @param bulletinNumber
* @param yearModel
* @param model
* @param issueDate
*/
public SetupInstructionsBean(String bulletinNumber, String yearModel, String productLine, String model, String year, String issueDate) {
super();
this.bulletinNumber = bulletinNumber;
this.yearModel = yearModel;
this.productLine = productLine;
this.model = model;
this.year = year;
this.issueDate = issueDate;
}

@JsonProperty("bulletinNumber")
public String getBulletinNumber() {
return bulletinNumber;
}

@JsonProperty("bulletinNumber")
public void setBulletinNumber(String bulletinNumber) {
this.bulletinNumber = bulletinNumber;
}

@JsonProperty("_yearModel")
public String getYearModel() {
return yearModel;
}

@JsonProperty("_yearModel")
public void setYearModel(String yearModel) {
this.yearModel = yearModel;
}

@JsonProperty("productLine")
public String getProductLine() {
return productLine;
}

@JsonProperty("productLine")
public void setProductLine(String productLine) {
this.productLine = productLine;
}

@JsonProperty("model")
public String getModel() {
return model;
}

@JsonProperty("model")
public void setModel(String model) {
this.model = model;
}

@JsonProperty("year")
public String getYear() {
return year;
}

@JsonProperty("year")
public void setYear(String year) {
this.year = year;
}

@JsonProperty("issueDate")
public String getIssueDate() {
return issueDate;
}

@JsonProperty("issueDate")
public void setIssueDate(String issueDate) {
this.issueDate = issueDate;
}
public String getValueByName(String name) {
	switch (name.trim()) {

	case "bulletinNumber":
		return getBulletinNumber();
	case "_yearModel":
		return getYearModel();
	case "productLine":
		return getProductLine();
	case "year":
		return getYear();
	case "model":
		return getModel();
	case "issueDate":
		return getIssueDate();
	
	default:
		return super.getValueByName(name);
	}
}

@Override
public String toString() {
StringBuilder sb = new StringBuilder();
sb.append(SetupInstructionsBean.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
sb.append("bulletinNumber");
sb.append('=');
sb.append(((this.bulletinNumber == null)?"<null>":this.bulletinNumber));
sb.append(',');
sb.append("yearModel");
sb.append('=');
sb.append(((this.yearModel == null)?"<null>":this.yearModel));
sb.append(',');
sb.append("productLine");
sb.append('=');
sb.append(((this.productLine == null)?"<null>":this.productLine));
sb.append(',');
sb.append("model");
sb.append('=');
sb.append(((this.model == null)?"<null>":this.model));
sb.append(',');
sb.append("year");
sb.append('=');
sb.append(((this.year == null)?"<null>":this.year));
sb.append(',');
sb.append("issueDate");
sb.append('=');
sb.append(((this.issueDate == null)?"<null>":this.issueDate));
sb.append(',');
if (sb.charAt((sb.length()- 1)) == ',') {
sb.setCharAt((sb.length()- 1), ']');
} else {
sb.append(']');
}
return sb.toString();
}

}