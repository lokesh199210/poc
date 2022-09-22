
package com.honda.obj.mapper.beans;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"productLine",
"system",
"_productLineModelYearServiceCategoryServiceSubCategorySystemComponentDTC",
"year",
"bulletinNumber",
"componentDTC",
"model",
"issueDate",
"serviceSubCategory",
"serviceCategory",
"campaignExpirationDate"
})
@Generated("jsonschema2pojo")
public class ServiceBulletinsBean extends INDocumentBean {

@JsonProperty("productLine")
private String productLine;
@JsonProperty("system")
private String system;
@JsonProperty("_productLineModelYearServiceCategoryServiceSubCategorySystemComponentDTC")
private String productLineModelYearServiceCategoryServiceSubCategorySystemComponentDTC;
@JsonProperty("year")
private String year;
@JsonProperty("bulletinNumber")
private String bulletinNumber;
@JsonProperty("componentDTC")
private String componentDTC;
@JsonProperty("model")
private String model;
@JsonProperty("issueDate")
private String issueDate;
@JsonProperty("serviceSubCategory")
private String serviceSubCategory;
@JsonProperty("serviceCategory")
private String serviceCategory;
@JsonProperty("campaignExpirationDate")
private String campaignExpirationDate;

/**
* No args constructor for use in serialization
*
*/
public ServiceBulletinsBean() {
}

/**
*
* @param productLine
* @param system
* @param productLineModelYearServiceCategoryServiceSubCategorySystemComponentDTC
* @param year
* @param bulletinNumber
* @param componentDTC
* @param model
* @param issueDate
* @param serviceSubCategory
* @param serviceCategory
* @param campaignExpirationDate
*/
public ServiceBulletinsBean(String productLine, String system, String productLineModelYearServiceCategoryServiceSubCategorySystemComponentDTC, String year, String bulletinNumber, String componentDTC, String model, String issueDate, String serviceSubCategory, String serviceCategory, String campaignExpirationDate) {
super();
this.productLine = productLine;
this.system = system;
this.productLineModelYearServiceCategoryServiceSubCategorySystemComponentDTC = productLineModelYearServiceCategoryServiceSubCategorySystemComponentDTC;
this.year = year;
this.bulletinNumber = bulletinNumber;
this.componentDTC = componentDTC;
this.model = model;
this.issueDate = issueDate;
this.serviceSubCategory = serviceSubCategory;
this.serviceCategory = serviceCategory;
this.campaignExpirationDate = campaignExpirationDate;
}

@JsonProperty("productLine")
public String getProductLine() {
return productLine;
}

@JsonProperty("productLine")
public void setProductLine(String productLine) {
this.productLine = productLine;
}

@JsonProperty("system")
public String getSystem() {
return system;
}

@JsonProperty("system")
public void setSystem(String system) {
this.system = system;
}

@JsonProperty("_productLineModelYearServiceCategoryServiceSubCategorySystemComponentDTC")
public String getProductLineModelYearServiceCategoryServiceSubCategorySystemComponentDTC() {
return productLineModelYearServiceCategoryServiceSubCategorySystemComponentDTC;
}

@JsonProperty("_productLineModelYearServiceCategoryServiceSubCategorySystemComponentDTC")
public void setProductLineModelYearServiceCategoryServiceSubCategorySystemComponentDTC(String productLineModelYearServiceCategoryServiceSubCategorySystemComponentDTC) {
this.productLineModelYearServiceCategoryServiceSubCategorySystemComponentDTC = productLineModelYearServiceCategoryServiceSubCategorySystemComponentDTC;
}

@JsonProperty("year")
public String getYear() {
return year;
}

@JsonProperty("year")
public void setYear(String year) {
this.year = year;
}

@JsonProperty("bulletinNumber")
public String getBulletinNumber() {
return bulletinNumber;
}

@JsonProperty("bulletinNumber")
public void setBulletinNumber(String bulletinNumber) {
this.bulletinNumber = bulletinNumber;
}

@JsonProperty("componentDTC")
public String getComponentDTC() {
return componentDTC;
}

@JsonProperty("componentDTC")
public void setComponentDTC(String componentDTC) {
this.componentDTC = componentDTC;
}

@JsonProperty("model")
public String getModel() {
return model;
}

@JsonProperty("model")
public void setModel(String model) {
this.model = model;
}

@JsonProperty("issueDate")
public String getIssueDate() {
return issueDate;
}

@JsonProperty("issueDate")
public void setIssueDate(String issueDate) {
this.issueDate = issueDate;
}

@JsonProperty("serviceSubCategory")
public String getServiceSubCategory() {
return serviceSubCategory;
}

@JsonProperty("serviceSubCategory")
public void setServiceSubCategory(String serviceSubCategory) {
this.serviceSubCategory = serviceSubCategory;
}

@JsonProperty("serviceCategory")
public String getServiceCategory() {
return serviceCategory;
}

@JsonProperty("serviceCategory")
public void setServiceCategory(String serviceCategory) {
this.serviceCategory = serviceCategory;
}

@JsonProperty("campaignExpirationDate")
public String getCampaignExpirationDate() {
return campaignExpirationDate;
}

@JsonProperty("campaignExpirationDate")
public void setCampaignExpirationDate(String campaignExpirationDate) {
this.campaignExpirationDate = campaignExpirationDate;
}
public String getValueByName(String name) {
	switch (name.trim()) {

	case "bulletinNumber":
		return getBulletinNumber();
	case "year":
		return getYear();
	case "serviceSubCategory":
		return getServiceSubCategory();
	case "issueDate":
		return getIssueDate();
	case "productLine":
		return getProductLine();
	case "serviceCategory":
		return getServiceCategory();
	case "system":
		return getSystem();
	case "model":
		return getModel();
	case "componentDTC":
		return getComponentDTC();	
	case "campaignExpirationDate":
		return getCampaignExpirationDate();
	case "_productLineModelYearServiceCategoryServiceSubCategorySystemComponentDTC":
		return getProductLineModelYearServiceCategoryServiceSubCategorySystemComponentDTC();
		
	default:
		return super.getValueByName(name);

	}
}


@Override
public String toString() {
StringBuilder sb = new StringBuilder();
sb.append(ServiceBulletinsBean.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
sb.append("productLine");
sb.append('=');
sb.append(((this.productLine == null)?"<null>":this.productLine));
sb.append(',');
sb.append("system");
sb.append('=');
sb.append(((this.system == null)?"<null>":this.system));
sb.append(',');
sb.append("productLineModelYearServiceCategoryServiceSubCategorySystemComponentDTC");
sb.append('=');
sb.append(((this.productLineModelYearServiceCategoryServiceSubCategorySystemComponentDTC == null)?"<null>":this.productLineModelYearServiceCategoryServiceSubCategorySystemComponentDTC));
sb.append(',');
sb.append("year");
sb.append('=');
sb.append(((this.year == null)?"<null>":this.year));
sb.append(',');
sb.append("bulletinNumber");
sb.append('=');
sb.append(((this.bulletinNumber == null)?"<null>":this.bulletinNumber));
sb.append(',');
sb.append("componentDTC");
sb.append('=');
sb.append(((this.componentDTC == null)?"<null>":this.componentDTC));
sb.append(',');
sb.append("model");
sb.append('=');
sb.append(((this.model == null)?"<null>":this.model));
sb.append(',');
sb.append("issueDate");
sb.append('=');
sb.append(((this.issueDate == null)?"<null>":this.issueDate));
sb.append(',');
sb.append("serviceSubCategory");
sb.append('=');
sb.append(((this.serviceSubCategory == null)?"<null>":this.serviceSubCategory));
sb.append(',');
sb.append("serviceCategory");
sb.append('=');
sb.append(((this.serviceCategory == null)?"<null>":this.serviceCategory));
sb.append(',');
sb.append("campaignExpirationDate");
sb.append('=');
sb.append(((this.campaignExpirationDate == null)?"<null>":this.campaignExpirationDate));
sb.append(',');
if (sb.charAt((sb.length()- 1)) == ',') {
sb.setCharAt((sb.length()- 1), ']');
} else {
sb.append(']');
}
return sb.toString();
}

}