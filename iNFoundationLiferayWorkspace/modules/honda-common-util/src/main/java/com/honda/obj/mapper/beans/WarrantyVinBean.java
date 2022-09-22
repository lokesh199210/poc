package com.honda.obj.mapper.beans;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"bulletinNumber",
"productLine",
"issueDate"
})
@Generated("jsonschema2pojo")
public class WarrantyVinBean extends INDocumentBean{

@JsonProperty("bulletinNumber")
private String bulletinNumber;
@JsonProperty("productLine")
private String productLine;
@JsonProperty("issueDate")
private String issueDate;

/**
* No args constructor for use in serialization
*
*/
public WarrantyVinBean() {
}

/**
*
* @param productLine
* @param bulletinNumber
* @param issueDate
*/
public WarrantyVinBean(String bulletinNumber, String productLine, String issueDate) {
super();
this.bulletinNumber = bulletinNumber;
this.productLine = productLine;
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

@JsonProperty("productLine")
public String getProductLine() {
return productLine;
}

@JsonProperty("productLine")
public void setProductLine(String productLine) {
this.productLine = productLine;
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
	case "issueDate":
		return getIssueDate();
	
	case "productLine":
		return getProductLine();
	
	default:
		return super.getValueByName(name);

	}
}


@Override
public String toString() {
StringBuilder sb = new StringBuilder();
sb.append(WarrantyVinBean.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
sb.append("bulletinNumber");
sb.append('=');
sb.append(((this.bulletinNumber == null)?"<null>":this.bulletinNumber));
sb.append(',');
sb.append("productLine");
sb.append('=');
sb.append(((this.productLine == null)?"<null>":this.productLine));
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