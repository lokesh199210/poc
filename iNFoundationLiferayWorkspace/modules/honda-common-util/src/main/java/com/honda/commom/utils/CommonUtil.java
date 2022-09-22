package com.honda.commom.utils;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

public interface CommonUtil {

	/**
	 * 
	 * 
	 * 
	 * @param httpServletRequest
	 * @return
	 */
	static JSONObject getJsonFromRequestBody(HttpServletRequest httpServletRequest) {

			try (InputStream inputStream = httpServletRequest.getInputStream();
					BufferedReader reader =  new BufferedReader(new InputStreamReader(inputStream))){
					String body = reader.lines().reduce(StringPool.BLANK,
							(accumulator, actual) -> accumulator + actual);
					return JSONFactoryUtil.createJSONObject(body);
			} catch (IOException | JSONException e) {
				_log.error(e, e);
			}
		
		return null;
	}
	
	/**
	 * 
	 * @param httpServletRequest
	 * @return
	 */
	static String getRequestBodyStr(HttpServletRequest httpServletRequest) {

			try (InputStream inputStream = httpServletRequest.getInputStream();
					BufferedReader reader =  new BufferedReader(new InputStreamReader(inputStream))){
					String body = reader.lines().reduce(StringPool.BLANK,
							(accumulator, actual) -> accumulator + actual);
					return body;
			} catch (IOException e) {
				_log.error(e, e);
			}
		
		return null;
	}
	
	/**
	 * Method to get division name based on division code
	 * 
	 * 
	 * @param division
	 * @return
	 */
	static String getDivsionNameByCode(String division) {
		switch(division) {
		
		case "M" :
			
			return "Motorcycle";
		case "A" :
			
			return "Auto";
			
		case "B" :
			
			return "Acura";	
			
		case "P" :
			
			return "Power Equipment";
			
		case "L" :
			
			return "Export";
			
		case "U" :
			
			return "Marine";
			
		default :
				return StringPool.BLANK;
		
		}
	}
	
	/**
	 * 
	 * This method is to check the docuemnt type is present in list in order to apply common metadata set
	 * 
	 * @param documentType
	 * @return
	 */
	static boolean checkDocumentType(String documentType) {
		
		List<String> documentTypes = new ArrayList<>();
		
		documentTypes.add("Diagnostic Tools Current Software Versions");
		documentTypes.add("Style Guide");
		documentTypes.add("eBrochure");
		documentTypes.add("Vehicle Pricing");
		documentTypes.add("VSC Error Codes");
		documentTypes.add("Operating Training Guide - PARTS");
		documentTypes.add("Electronic Archiving (EA) Certification");
		documentTypes.add("Over the Air (OTA) Resources");
		documentTypes.add("Licensed Products");
		documentTypes.add("Facility Management - Forms");
		documentTypes.add("Facility Management - Contacts");
		documentTypes.add("Campaign Status Change Form");
		documentTypes.add("Vehicle Remarketing - VIPS User Guide");
		documentTypes.add("Dealer Standard Accounting Manual");
		documentTypes.add("GAP - Error codes");
		documentTypes.add("Dealership Financial Statement Check-Up");
		documentTypes.add("Survey Integrity Policy");
		documentTypes.add("AcuraLink Next Gen Resources");
		documentTypes.add("Dealer Direct");
		documentTypes.add("Business Management Operating Guidelines");
		documentTypes.add("READS");
		
		
		return documentTypes.contains(documentType);
		
	}
	
	/**
	 * 
	 * @param contentType
	 * @return
	 */
	static boolean isSingleLibrary(String contentType) {
		List<String> contentTypes = new ArrayList<>();
		
		contentTypes.add("Licensed Products");
		contentTypes.add("Vehicle Pricing");
		contentTypes.add("MC Accessory Marketing");
		
		return contentTypes.contains(contentType);
	}
	
	/**
	 * 
	 * @param log
	 * @param msg
	 */
	static void writeDebugLogs(Log log,String msg) {
		
		if(log.isDebugEnabled())
			log.debug(msg);
	}
	
	/**
	 * 
	 * @param log
	 * @param msg
	 */
	static void writeInfoLogs(Log log,String msg) {
		
		if(log.isInfoEnabled())
			log.info(msg);
	}
	
	static String convertStringsToArrayList(String value) {

		String[] elements = value.split(",");

		List<String> fixedLenghtList = Arrays.asList(elements);

		ArrayList<String> listOfValues = new ArrayList<String>(fixedLenghtList);

		value = listOfValues.toString();
		return value;
	}
	
	static String convertArrayListToString(String string) {
		
		String commaSeparatedlist = string.toString();
		if(commaSeparatedlist.startsWith("[") && commaSeparatedlist.endsWith("]"))
		{
		commaSeparatedlist = commaSeparatedlist.replace("[", "").replace("]", "").replace(" ", "");

		System.out.println(commaSeparatedlist);
		}
		return commaSeparatedlist;

	}
	
	
	static final Log _log = LogFactoryUtil.getLog(CommonUtil.class);
}
