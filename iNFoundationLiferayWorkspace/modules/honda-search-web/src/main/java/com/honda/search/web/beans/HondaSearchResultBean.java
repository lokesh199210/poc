package com.honda.search.web.beans;

public class HondaSearchResultBean {
	
	public HondaSearchResultBean(String title, String description, String viewURL) {
		super();
		this.title = title;
		this.description = description;
		this.viewURL = viewURL;
	}

	public String getTitle() {
		return title;
	}
	
	public String getDescription() {
		return description;
	}
	
	public String getViewURL() {
		return viewURL;
	}
	
	private String title;
	private String description;
	private String viewURL;
}
