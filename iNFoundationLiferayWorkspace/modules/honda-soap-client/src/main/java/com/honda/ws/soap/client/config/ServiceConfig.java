package com.honda.ws.soap.client.config;

/**
 * @author Vinisha Pathak
 *
 */
public interface ServiceConfig {
	static final String dev_environment = "dev";
	static final String qa_environment = "qa";
	static final String uat_environment = "uat";
	static final String prod_environment = "prod";
	
	// Service Output Formats
	static final String OUTPUT_FORMAT_HTML = "html";
	static final String OUTPUT_FORMAT_CSV = "csv";
	static final String OUTPUT_FORMAT_JSON = "json";
	static final String OUTPUT_FORMAT_XML = "xml";
	
	// Service response cache expire time
	static final String SERVICE_RESPONSE_CACHE_EXPIRY_TIME = "service.response.cache.expiry.time";
	static final String SERVICE_RESPONSE_CACHE_MAX_SIZE = "service.response.cache.max.size";
	
	// Service Parameters
	static final String SERVICE_REQUEST_PARAMETER_PREFIX = "service.request.parameter.prefix";
	static final String SERVICE_REQUEST_HEADER_PARAMETER_PREFIX = "service.request.header.parameter.prefix";
	
	// Service resource's paths
	static final String XSL_TEMPLATE_PATH = "xsl.template.path";
	static final String XSL_TEMPLATE_NAME = "xsl.template.name";
	static final String SAVED_SERVICE_RESPONSE_XML_PATH = "saved.service.response.xml.path";
	static final String SAVED_SERVICE_REQUEST_XML_PATH = "saved.service.request.xml.path";
	
	// Service params
	static final String PARAM_CUR = "cur";
	static final String PARAM_DELTA = "delta";
	static final String PARAM_MESSAGE_ERROR = "errorMessage";
	static final String PARAM_PAGE_MODE = "pageMode";
	
	// Service messages
	static final String MESSAGE_SERVICE_RESPONSE_EMPTY = "message.service.response.empty";
}