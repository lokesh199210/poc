package com.honda.common.beans;

import com.liferay.portal.kernel.util.FileUtil;

import java.io.File;
import java.io.IOException;

public class DocRequestBean {

	public DocRequestBean(String title, String description, String contentType, String division, String fileName,
			byte[] fileBytes,String folderName, DocMetaDataBean docMetaDataBean) throws IOException {

		this.title = title;
		this.description = description;
		this.contentType = contentType;
		this.division = division;
		this.fileName = fileName;
		this.file = FileUtil.createTempFile(fileBytes);
		this.folderName = folderName;
		this.docMetaDataBean = docMetaDataBean;
	}

	public DocRequestBean(String title, String description, String contentType, String division,String department, String fileName,
			File file,String folderName, DocMetaDataBean docMetaDataBean) {

		this.title = title;
		this.description = description;
		this.contentType = contentType;
		this.division = division;
		this.department = department;
		this.fileName = fileName;
		this.file = file;
		this.folderName = folderName;
		this.docMetaDataBean = docMetaDataBean;
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

	public String getFileName() {
		return fileName;
	}

	public File getFile() {
		return file;
	}

	public DocMetaDataBean getDocMetaDataBean() {
		return docMetaDataBean;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
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
	
	private DocMetaDataBean docMetaDataBean;

}
