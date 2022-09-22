
package com.honda.obj.mapper.beans;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"dealerStates"
})
@Generated("jsonschema2pojo")
public class MGAPRateGuideBean {

@JsonProperty("dealerStates")
private String dealerStates;

/**
* No args constructor for use in serialization
*
*/
public MGAPRateGuideBean() {
}

/**
*
* @param dealerStates
*/
public MGAPRateGuideBean(String dealerStates) {
super();
this.dealerStates = dealerStates;
}

@JsonProperty("dealerStates")
public String getDealerStates() {
return dealerStates;
}

@JsonProperty("dealerStates")
public void setDealerStates(String dealerStates) {
this.dealerStates = dealerStates;
}
public String getValueByName(String name) {
	switch (name.trim()) {

	case "dealerStates":
		return getDealerStates();
	
	
	default:
		return null;
}
}

@Override
public String toString() {
StringBuilder sb = new StringBuilder();
sb.append(MGAPRateGuideBean.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
sb.append("dealerStates");
sb.append('=');
sb.append(((this.dealerStates == null)?"<null>":this.dealerStates));
sb.append(',');
if (sb.charAt((sb.length()- 1)) == ',') {
sb.setCharAt((sb.length()- 1), ']');
} else {
sb.append(']');
}
return sb.toString();
}

}
