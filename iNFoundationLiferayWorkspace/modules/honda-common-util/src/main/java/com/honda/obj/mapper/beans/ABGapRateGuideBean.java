package com.honda.obj.mapper.beans;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"group",
"issueDate"
})
@Generated("jsonschema2pojo")
public class ABGapRateGuideBean {

@JsonProperty("group")
private String group;
@JsonProperty("issueDate")
private String issueDate;

/**
* No args constructor for use in serialization
*
*/
public ABGapRateGuideBean() {
}

/**
*
* @param issueDate
* @param group
*/
public ABGapRateGuideBean(String group, String issueDate) {
super();
this.group = group;
this.issueDate = issueDate;
}

@JsonProperty("group")
public String getGroup() {
return group;
}

@JsonProperty("group")
public void setGroup(String group) {
this.group = group;
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

	case "group":
		return getGroup();
		
	case "issueDate":
		return getIssueDate();
	
	
	default:
		return null;
}
}
@Override
public String toString() {
StringBuilder sb = new StringBuilder();
sb.append(ABGapRateGuideBean.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
sb.append("group");
sb.append('=');
sb.append(((this.group == null)?"<null>":this.group));
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