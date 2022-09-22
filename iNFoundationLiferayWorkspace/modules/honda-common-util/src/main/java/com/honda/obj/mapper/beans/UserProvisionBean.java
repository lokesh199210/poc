package com.honda.obj.mapper.beans;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.ALWAYS)
@JsonPropertyOrder({"firstName", "lastName", "emailAddress", "operation", "division", "department", "employeeType", "location", "publication"})
@Generated("jsonschema2pojo")
public class UserProvisionBean {

	@JsonProperty("firstName")
	private String firstName;
	@JsonProperty("lastName")
	private String lastName;
	@JsonProperty("emailAddress")
	private String emailAddress;
	@JsonProperty("operation")
	private String operation;
	@JsonProperty("division")
	private String division;
	@JsonProperty("department")
	private String department;
	@JsonProperty("employeeType")
	private String employeeType;
	@JsonProperty("location")
	private String location;
	@JsonProperty("publication")
	private String publication;

	/**
	* No args constructor for use in serialization
	*
	*/
	public UserProvisionBean() {
	}
	
	/**
	*
	* @param division
	* @param firstName
	* @param emailAddress
	* @param operation
	* @param lastName
	* @param department
	* @param employeeType
	* @param location
	* @param publication
	*/
	public UserProvisionBean(String firstName, String lastName, String emailAddress, String operation, String division, String department, String employeeType, String location, String publication) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailAddress = emailAddress;
		this.operation = operation;
		this.division = division;
		this.department = department;
		this.employeeType = employeeType;
		this.location = location;
		this.publication = publication;
	}

	@JsonProperty("firstName")
	public String getFirstname() {
		return firstName;
	}
	
	@JsonProperty("firstName")
	public void setFirstname(String firstName) {
		this.firstName = firstName;
	}
	
	@JsonProperty("lastName")
	public String getLastname() {
		return lastName;
	}

	@JsonProperty("lastName")
	public void setLastname(String lastName) {
		this.lastName = lastName;
	}
	
	@JsonProperty("emailAddress")
	public String getEmailAddress() {
		return emailAddress;
	}

	@JsonProperty("emailAddress")
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
	@JsonProperty("operation")
	public String getOperation() {
		return operation;
	}

	@JsonProperty("operation")
	public void setOperation(String operation) {
		this.operation = operation;
	}
	
	@JsonProperty("division")
	public String getDivision() {
		return division;
	}

	@JsonProperty("division")
	public void setDivision(String division) {
		this.division = division;
	}
	
	@JsonProperty("department")
	public String getDepartment() {
		return department;
	}

	@JsonProperty("department")
	public void setDepartment(String department) {
		this.department = department;
	}
	
	@JsonProperty("employeeType")
	public String getEmployeeType() {
		return employeeType;
	}

	@JsonProperty("employeeType")
	public void setEmployeeType(String employeeType) {
		this.employeeType = employeeType;
	}
	
	@JsonProperty("location")
	public String getLocation() {
		return location;
	}

	@JsonProperty("location")
	public void setLocation(String location) {
		this.location = location;
	}
	
	@JsonProperty("publication")
	public String getPublication() {
		return publication;
	}

	@JsonProperty("publication")
	public void setPublication(String publication) {
		this.publication = publication;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(UserProvisionBean.class.getName()).append('@')
				.append(Integer.toHexString(System.identityHashCode(this))).append('[');
		sb.append("firstName");
		sb.append('=');
		sb.append(((this.firstName == null)?"<null>":this.firstName));
		sb.append(',');
		sb.append("lastName");
		sb.append('=');
		sb.append(((this.lastName == null)?"<null>":this.lastName));
		sb.append(',');
		sb.append("emailAddress");
		sb.append('=');
		sb.append(((this.emailAddress == null)?"<null>":this.emailAddress));
		sb.append(',');
		sb.append("operation");
		sb.append('=');
		sb.append(((this.operation == null)?"<null>":this.operation));
		sb.append(',');
		sb.append("division");
		sb.append('=');
		sb.append(((this.division == null)?"<null>":this.division));
		sb.append(',');
		sb.append("department");
		sb.append('=');
		sb.append(((this.department == null)?"<null>":this.department));
		sb.append(',');
		sb.append("employeeType");
		sb.append('=');
		sb.append(((this.employeeType == null)?"<null>":this.employeeType));
		sb.append(',');
		sb.append("location");
		sb.append('=');
		sb.append(((this.location == null)?"<null>":this.location));
		sb.append(',');
		sb.append("publication");
		sb.append('=');
		sb.append(((this.publication == null)?"<null>":this.publication));
		sb.append(',');
		if (sb.charAt((sb.length() - 1)) == ',') {
			sb.setCharAt((sb.length() - 1), ']');
		} else {
			sb.append(']');
		}
	
		return sb.toString();
	}

}