
package com.honda.obj.mapper.beans;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"programCode",
"division",
"businessLine",
"programType",
"startDate",
"endDate"
})
@Generated("jsonschema2pojo")
public class DfsFinanceBean extends INDocumentBean {

@JsonProperty("programCode")
private String programCode;
@JsonProperty("division")
private String division;
@JsonProperty("businessLine")
private String businessLine;
@JsonProperty("programType")
private String programType;
@JsonProperty("startDate")
private String startDate;
@JsonProperty("endDate")
private String endDate;

/**
* No args constructor for use in serialization
*
*/
public DfsFinanceBean()  {
}

/**
*
* @param division
* @param programType
* @param programCode
* @param endDate
* @param businessLine
* @param startDate
*/
public DfsFinanceBean(String programCode, String division, String businessLine, String programType, String startDate, String endDate) {
super();
this.programCode = programCode;
this.division = division;
this.businessLine = businessLine;
this.programType = programType;
this.startDate = startDate;
this.endDate = endDate;
}

@JsonProperty("programCode")
public String getProgramCode() {
return programCode;
}

@JsonProperty("programCode")
public void setProgramCode(String programCode) {
this.programCode = programCode;
}

@JsonProperty("division")
public String getDivision() {
return division;
}

@JsonProperty("division")
public void setDivision(String division) {
this.division = division;
}

@JsonProperty("businessLine")
public String getBusinessLine() {
return businessLine;
}

@JsonProperty("businessLine")
public void setBusinessLine(String businessLine) {
this.businessLine = businessLine;
}

@JsonProperty("programType")
public String getProgramType() {
return programType;
}

@JsonProperty("programType")
public void setProgramType(String programType) {
this.programType = programType;
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

	case "programCode":
		return getProgramCode();
	case "division":
		return getDivision();
	case "startDate":
		return getStartDate();
	case "endDate":
		return getEndDate();
	case "businessLine":
		return getBusinessLine();
	case "programType":
		return getProgramType();
	
	default:
		return super.getValueByName(name);
	}
}

@Override
public String toString() {
StringBuilder sb = new StringBuilder();
sb.append(DfsFinanceBean.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
sb.append("programCode");
sb.append('=');
sb.append(((this.programCode == null)?"<null>":this.programCode));
sb.append(',');
sb.append("division");
sb.append('=');
sb.append(((this.division == null)?"<null>":this.division));
sb.append(',');
sb.append("businessLine");
sb.append('=');
sb.append(((this.businessLine == null)?"<null>":this.businessLine));
sb.append(',');
sb.append("programType");
sb.append('=');
sb.append(((this.programType == null)?"<null>":this.programType));
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
