package com.honda.obj.mapper.beans;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"bulletinAppliesTo",
"year",
"productLine",
"model",
"keywords",
"startDate",
"endDate",
"mropCalendarModelOrderingHorizon",
"libraryReferenceNumber",
"librarySupersededInfo"
})
@Generated("jsonschema2pojo")
public class SalesMarketingBulletinsBean {

@JsonProperty("bulletinAppliesTo")
private String bulletinAppliesTo;
@JsonProperty("year")
private String year;
@JsonProperty("productLine")
private String productLine;
@JsonProperty("model")
private String model;
@JsonProperty("keywords")
private String keywords;
@JsonProperty("startDate")
private String startDate;
@JsonProperty("endDate")
private String endDate;
@JsonProperty("mropCalendarModelOrderingHorizon")
private String mropCalendarModelOrderingHorizon;
@JsonProperty("libraryReferenceNumber")
private String libraryReferenceNumber;
@JsonProperty("librarySupersededInfo")
private String librarySupersededInfo;

/**
* No args constructor for use in serialization
*
*/
public SalesMarketingBulletinsBean() {
}

/**
*
* @param bulletinAppliesTo
* @param productLine
* @param keywords
* @param year
* @param endDate
* @param libraryReferenceNumber
* @param mropCalendarModelOrderingHorizon
* @param model
* @param librarySupersededInfo
* @param startDate
*/
public SalesMarketingBulletinsBean(String bulletinAppliesTo, String year, String productLine, String model, String keywords, String startDate, String endDate, String mropCalendarModelOrderingHorizon, String libraryReferenceNumber, String librarySupersededInfo) {
super();
this.bulletinAppliesTo = bulletinAppliesTo;
this.year = year;
this.productLine = productLine;
this.model = model;
this.keywords = keywords;
this.startDate = startDate;
this.endDate = endDate;
this.mropCalendarModelOrderingHorizon = mropCalendarModelOrderingHorizon;
this.libraryReferenceNumber = libraryReferenceNumber;
this.librarySupersededInfo = librarySupersededInfo;
}

@JsonProperty("bulletinAppliesTo")
public String getBulletinAppliesTo() {
return bulletinAppliesTo;
}

@JsonProperty("bulletinAppliesTo")
public void setBulletinAppliesTo(String bulletinAppliesTo) {
this.bulletinAppliesTo = bulletinAppliesTo;
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

@JsonProperty("mropCalendarModelOrderingHorizon")
public String getMropCalendarModelOrderingHorizon() {
return mropCalendarModelOrderingHorizon;
}

@JsonProperty("mropCalendarModelOrderingHorizon")
public void setMropCalendarModelOrderingHorizon(String mropCalendarModelOrderingHorizon) {
this.mropCalendarModelOrderingHorizon = mropCalendarModelOrderingHorizon;
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
sb.append(SalesMarketingBulletinsBean.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
sb.append("bulletinAppliesTo");
sb.append('=');
sb.append(((this.bulletinAppliesTo == null)?"<null>":this.bulletinAppliesTo));
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
sb.append("startDate");
sb.append('=');
sb.append(((this.startDate == null)?"<null>":this.startDate));
sb.append(',');
sb.append("endDate");
sb.append('=');
sb.append(((this.endDate == null)?"<null>":this.endDate));
sb.append(',');
sb.append("mropCalendarModelOrderingHorizon");
sb.append('=');
sb.append(((this.mropCalendarModelOrderingHorizon == null)?"<null>":this.mropCalendarModelOrderingHorizon));
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