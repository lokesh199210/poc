package com.honda.obj.mapper.beans;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"programType",
"loanType",
"bulletinType",
"year",
"productLine",
"model",
"keywords",
"publishDate",
"startDate",
"endDate",
"libraryReferenceNumber",
"librarySupersededInfo"
})
@Generated("jsonschema2pojo")
public class HFSBulletinsBean {

@JsonProperty("programType")
private String programType;
@JsonProperty("loanType")
private String loanType;
@JsonProperty("bulletinType")
private String bulletinType;
@JsonProperty("year")
private String year;
@JsonProperty("productLine")
private String productLine;
@JsonProperty("model")
private String model;
@JsonProperty("keywords")
private String keywords;
@JsonProperty("publishDate")
private String publishDate;
@JsonProperty("startDate")
private String startDate;
@JsonProperty("endDate")
private String endDate;
@JsonProperty("libraryReferenceNumber")
private String libraryReferenceNumber;
@JsonProperty("librarySupersededInfo")
private String librarySupersededInfo;

/**
* No args constructor for use in serialization
*
*/
public HFSBulletinsBean() {
}

/**
*
* @param productLine
* @param programType
* @param loanType
* @param keywords
* @param year
* @param endDate
* @param libraryReferenceNumber
* @param publishDate
* @param model
* @param librarySupersededInfo
* @param startDate
* @param bulletinType
*/
public HFSBulletinsBean(String programType, String loanType, String bulletinType, String year, String productLine, String model, String keywords, String publishDate, String startDate, String endDate, String libraryReferenceNumber, String librarySupersededInfo) {
super();
this.programType = programType;
this.loanType = loanType;
this.bulletinType = bulletinType;
this.year = year;
this.productLine = productLine;
this.model = model;
this.keywords = keywords;
this.publishDate = publishDate;
this.startDate = startDate;
this.endDate = endDate;
this.libraryReferenceNumber = libraryReferenceNumber;
this.librarySupersededInfo = librarySupersededInfo;
}

@JsonProperty("programType")
public String getProgramType() {
return programType;
}

@JsonProperty("programType")
public void setProgramType(String programType) {
this.programType = programType;
}

@JsonProperty("loanType")
public String getLoanType() {
return loanType;
}

@JsonProperty("loanType")
public void setLoanType(String loanType) {
this.loanType = loanType;
}

@JsonProperty("bulletinType")
public String getBulletinType() {
return bulletinType;
}

@JsonProperty("bulletinType")
public void setBulletinType(String bulletinType) {
this.bulletinType = bulletinType;
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

@JsonProperty("keywords")
public String getKeywords() {
return keywords;
}

@JsonProperty("keywords")
public void setKeywords(String keywords) {
this.keywords = keywords;
}

@JsonProperty("publishDate")
public String getPublishDate() {
return publishDate;
}

@JsonProperty("publishDate")
public void setPublishDate(String publishDate) {
this.publishDate = publishDate;
}

@JsonProperty("startDate")
public String getStartDate() {
return startDate;
}

@JsonProperty("startDate")
public void setStartDate(String startDate) {
this.startDate = startDate;
}

@JsonProperty("endDate")
public String getEndDate() {
return endDate;
}

@JsonProperty("endDate")
public void setEndDate(String endDate) {
this.endDate = endDate;
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

@Override
public String toString() {
StringBuilder sb = new StringBuilder();
sb.append(HFSBulletinsBean.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
sb.append("programType");
sb.append('=');
sb.append(((this.programType == null)?"<null>":this.programType));
sb.append(',');
sb.append("loanType");
sb.append('=');
sb.append(((this.loanType == null)?"<null>":this.loanType));
sb.append(',');
sb.append("bulletinType");
sb.append('=');
sb.append(((this.bulletinType == null)?"<null>":this.bulletinType));
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
sb.append("keywords");
sb.append('=');
sb.append(((this.keywords == null)?"<null>":this.keywords));
sb.append(',');
sb.append("publishDate");
sb.append('=');
sb.append(((this.publishDate == null)?"<null>":this.publishDate));
sb.append(',');
sb.append("startDate");
sb.append('=');
sb.append(((this.startDate == null)?"<null>":this.startDate));
sb.append(',');
sb.append("endDate");
sb.append('=');
sb.append(((this.endDate == null)?"<null>":this.endDate));
sb.append(',');
sb.append("libraryReferenceNumber");
sb.append('=');
sb.append(((this.libraryReferenceNumber == null)?"<null>":this.libraryReferenceNumber));
sb.append(',');
sb.append("librarySupersededInfo");
sb.append('=');
sb.append(((this.librarySupersededInfo == null)?"<null>":this.librarySupersededInfo));
sb.append(',');
if (sb.charAt((sb.length()- 1)) == ',') {
sb.setCharAt((sb.length()- 1), ']');
} else {
sb.append(']');
}
return sb.toString();
}

}