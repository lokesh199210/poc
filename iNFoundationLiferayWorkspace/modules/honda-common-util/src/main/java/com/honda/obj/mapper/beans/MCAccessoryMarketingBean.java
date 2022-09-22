
package com.honda.obj.mapper.beans;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"dealerLevel",
"issueDate",
"startDate",
"endDate"
})
@Generated("jsonschema2pojo")
public class MCAccessoryMarketingBean extends INDocumentBean{

@JsonProperty("dealerLevel")
private String dealerLevel;
@JsonProperty("issueDate")
private String issueDate;
@JsonProperty("startDate")
private String startDate;
@JsonProperty("endDate")
private String endDate;

/**
* No args constructor for use in serialization
*
*/
public MCAccessoryMarketingBean() {
}

/**
*
* @param dealerLevel
* @param endDate
* @param issueDate
* @param startDate
*/
public MCAccessoryMarketingBean(String dealerLevel, String issueDate, String startDate, String endDate) {
super();
this.dealerLevel = dealerLevel;
this.issueDate = issueDate;
this.startDate = startDate;
this.endDate = endDate;
}

@JsonProperty("dealerLevel")
public String getDealerLevel() {
return dealerLevel;
}

@JsonProperty("dealerLevel")
public void setDealerLevel(String dealerLevel) {
this.dealerLevel = dealerLevel;
}

@JsonProperty("issueDate")
public String getIssueDate() {
return issueDate;
}

@JsonProperty("issueDate")
public void setIssueDate(String issueDate) {
this.issueDate = issueDate;
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
public String getValueByName(String name) {
	switch (name.trim()) {

	case "dealerLevel":
		return getDealerLevel();
	case "issueDate":
		return getIssueDate();
	case "startDate":
		return getStartDate();
	case "endDate":
		return getEndDate();
	
	default:
		return super.getValueByName(name);

	}
}

@Override
public String toString() {
StringBuilder sb = new StringBuilder();
sb.append(MCAccessoryMarketingBean.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
sb.append("dealerLevel");
sb.append('=');
sb.append(((this.dealerLevel == null)?"<null>":this.dealerLevel));
sb.append(',');
sb.append("issueDate");
sb.append('=');
sb.append(((this.issueDate == null)?"<null>":this.issueDate));
sb.append(',');
sb.append("startDate");
sb.append('=');
sb.append(((this.startDate == null)?"<null>":this.startDate));
sb.append(',');
sb.append("endDate");
sb.append('=');
sb.append(((this.endDate == null)?"<null>":this.endDate));
sb.append(',');
if (sb.charAt((sb.length()- 1)) == ',') {
sb.setCharAt((sb.length()- 1), ']');
} else {
sb.append(']');
}
return sb.toString();
}

}