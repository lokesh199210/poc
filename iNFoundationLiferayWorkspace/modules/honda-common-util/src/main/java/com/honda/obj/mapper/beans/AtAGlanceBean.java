
package com.honda.obj.mapper.beans;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"dealerLevel",
"keywords",
"issueDate",
"libraryReferenceNumber",
"librarySupersededInfo",
"effectiveDate",
"expirationDate"
})
@Generated("jsonschema2pojo")
public class AtAGlanceBean {

@JsonProperty("dealerLevel")
private String dealerLevel;
@JsonProperty("keywords")
private String keywords;
@JsonProperty("issueDate")
private String issueDate;
@JsonProperty("libraryReferenceNumber")
private String libraryReferenceNumber;
@JsonProperty("librarySupersededInfo")
private String librarySupersededInfo;
@JsonProperty("effectiveDate")
private String effectiveDate;
@JsonProperty("expirationDate")
private String expirationDate;

/**
* No args constructor for use in serialization
*
*/
public AtAGlanceBean() {
}

/**
*
* @param dealerLevel
* @param keywords
* @param libraryReferenceNumber
* @param issueDate
* @param librarySupersededInfo
* @param effectiveDate
* @param expirationDate
*/
public AtAGlanceBean(String dealerLevel, String keywords, String issueDate, String libraryReferenceNumber, String librarySupersededInfo, String effectiveDate, String expirationDate) {
super();
this.dealerLevel = dealerLevel;
this.keywords = keywords;
this.issueDate = issueDate;
this.libraryReferenceNumber = libraryReferenceNumber;
this.librarySupersededInfo = librarySupersededInfo;
this.effectiveDate = effectiveDate;
this.expirationDate = expirationDate;
}

@JsonProperty("dealerLevel")
public String getDealerLevel() {
return dealerLevel;
}

@JsonProperty("dealerLevel")
public void setDealerLevel(String dealerLevel) {
this.dealerLevel = dealerLevel;
}

@JsonProperty("keywords")
public String getKeywords() {
return keywords;
}

@JsonProperty("keywords")
public void setKeywords(String keywords) {
this.keywords = keywords;
}

@JsonProperty("issueDate")
public String getIssueDate() {
return issueDate;
}

@JsonProperty("issueDate")
public void setIssueDate(String issueDate) {
this.issueDate = issueDate;
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

@JsonProperty("effectiveDate")
public String getEffectiveDate() {
return effectiveDate;
}

@JsonProperty("effectiveDate")
public void setEffectiveDate(String effectiveDate) {
this.effectiveDate = effectiveDate;
}

@JsonProperty("expirationDate")
public String getExpirationDate() {
return expirationDate;
}

@JsonProperty("expirationDate")
public void setExpirationDate(String expirationDate) {
this.expirationDate = expirationDate;
}

}