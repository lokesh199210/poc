package com.honda.obj.mapper.beans;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"_yearModel",
"year",
"productLine",
"model",
"partNumbers",
"issueDate"
})
@Generated("jsonschema2pojo")
public class AccessoryInstallationBean extends INDocumentBean {

@JsonProperty("_yearModel")
private String yearModel;
@JsonProperty("year")
private String year;
@JsonProperty("productLine")
private String productLine;
@JsonProperty("model")
private String model;
@JsonProperty("partNumbers")
private String partNumbers;
@JsonProperty("issueDate")
private String issueDate;

/**
* No args constructor for use in serialization
*
*/
public AccessoryInstallationBean() {
}

/**
*
* @param productLine
* @param year
* @param yearModel
* @param partNumbers
* @param model
* @param issueDate
*/
public AccessoryInstallationBean(String yearModel, String year, String productLine, String model, String partNumbers, String issueDate) {
super();
this.yearModel = yearModel;
this.year = year;
this.productLine = productLine;
this.model = model;
this.partNumbers = partNumbers;
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

@JsonProperty("model")
public String getModel() {
return model;
}

@JsonProperty("model")
public void setModel(String model) {
this.model = model;
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

public String getValueByName(String name) {
	System.out.println(" name :"+name);
	switch (name.trim()) {
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


@Override
public String toString() {
StringBuilder sb = new StringBuilder();
sb.append(AccessoryInstallationBean.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
sb.append("yearModel");
sb.append('=');
sb.append(((this.yearModel == null)?"<null>":this.yearModel));
sb.append(',');
sb.append("year");
sb.append('=');
sb.append(((this.year == null)?"<null>":this.year));
sb.append(',');
sb.append("productLine");
sb.append('=');
sb.append(((this.productLine == null)?"<null>":this.productLine));
sb.append(',');
sb.append("model");
sb.append('=');
sb.append(((this.model == null)?"<null>":this.model));
sb.append(',');
sb.append("partNumbers");
sb.append('=');
sb.append(((this.partNumbers == null)?"<null>":this.partNumbers));
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