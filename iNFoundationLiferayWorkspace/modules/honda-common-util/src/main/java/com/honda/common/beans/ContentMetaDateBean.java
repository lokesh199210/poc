package com.honda.common.beans;

import com.honda.commom.utils.ObjectMapperUtil;
import com.honda.obj.mapper.beans.VideoBean;

public class ContentMetaDateBean {
	
	public ContentMetaDateBean(String contentType,String metaDataJSON) {
		super();
		this.metaDataJSON = metaDataJSON;
		this.contentType = contentType;
		setObject();
	}

	public String getMetaDataJSON() {
		return metaDataJSON;
	}
	
	public String getContentType() {
		return contentType;
	}
	
	private void setObject() {
		
		switch (contentType.trim()) {

		case "Story":

			object = ObjectMapperUtil.parseToBean(metaDataJSON, VideoBean.class);
			break;

		case "Video":

			object = ObjectMapperUtil.parseToBean(metaDataJSON, VideoBean.class);
			break;

		default:

			break;

		}
	}

	public String getValueByName(String name) {

		switch (contentType.trim()) {

		case "Story":

			return ((VideoBean)object).getValueByName(name);

		case "Video":

			return ((VideoBean)object).getValueByName(name);

		default:

			return "";

		}
	}

	private String metaDataJSON;
	
	private String contentType;
	
	private Object object ;

}
