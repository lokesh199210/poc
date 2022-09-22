package com.honda.common.beans;

import java.io.File;

public class ContentRequestBean {

	public ContentRequestBean(String title,String description, String contentType, String division,String department,
			File file, String fileName,String folderName, ContentMetaDateBean contentMetaDateBean) {
		
		this.description = description;
		this.title = title;
		this.contentType = contentType;
		this.division = division;
		this.department = department;
		this.fileName = fileName;
		this.file = file;
		this.folderName = folderName;
		this.contentMetaDateBean = contentMetaDateBean;
	}
	
	public String getDescription() {
		return description;
	}

	public String getTitle() {
		return title;
	}

	public String getContentType() {
		return contentType;
	}

	public String getDivision() {
		return division;
	}
	
	public String getDepartment() {
		return department;
	}

	public ContentMetaDateBean getContentMetaDateBean() {
		return contentMetaDateBean;
	}
	
	public String getFileName() {
		return fileName;
	}

	public File getFile() {
		return file;
	}
	public String getFolderName() {
		return folderName;
	}

	private String description;

	private String title;

	private String contentType;

	private String division;
	
	private String department;
	
	private String fileName;

	private File file;
	
	private String folderName;
	
	private ContentMetaDateBean contentMetaDateBean;
	

}
