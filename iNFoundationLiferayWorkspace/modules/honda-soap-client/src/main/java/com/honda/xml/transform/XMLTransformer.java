package com.honda.xml.transform;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Map;

import javax.jws.WebMethod;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.osgi.service.component.annotations.Component;

/**
 * @author Vinisha Pathak
 *
 */

@Component(immediate = true)
public class XMLTransformer {

	/**
	 * Creates transform factory instance.
	 */
	private static TransformerFactory transformerFactory = TransformerFactory.newInstance();

	/**
	 * Transform xml file using xsl
	 * 
	 * @param xmlFile
	 * @param xslFile
	 * @param params
	 * @return
	 * @throws TransformerException
	 * @throws FileNotFoundException
	 */
	@WebMethod
	public String transform(StringReader xmlFile, File xslFile, Map<String, String> params)
			throws TransformerException, FileNotFoundException {

		String result = null;
		StringWriter out = null;
		if (xmlFile == null) {
			throw new FileNotFoundException("Unable to find xml file for Transformation");
		}

		if (xslFile == null) {
			throw new FileNotFoundException("Unable to find xsl file for Transformation");
		}

		try {
			Source xmlSource = new StreamSource(xmlFile);
			Source xslSource = new StreamSource(xslFile);
		
			// Creating new/cached transformer instance for the stylesheet
			// template.
			Transformer transformer = transformerFactory.newTransformer(xslSource);
			out = new StringWriter();

			if (params != null) {
				for (Map.Entry<String, String> param : params.entrySet()) {
					transformer.setParameter(param.getKey(), param.getValue());
				}
			}
			// Transforms xml using xsl.
			transformer.transform(xmlSource, new StreamResult(out));
			result = out.toString();
		} catch (Exception e) {
			throw new TransformerException("Unable to Transform xml file", e);
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					throw new TransformerException("Unable to generate output", e);
				}
			}
		}
		return result;
	}
}
