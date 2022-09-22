package com.honda.rest.builder.app;

import com.honda.rest.builder.constants.RestBuilderConstants;
import com.honda.rest.builder.helper.RestBuilderHelper;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.Collections;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.jaxrs.whiteboard.JaxrsWhiteboardConstants;

/**
 * @author Lokesh Sharma
 */
@Component(property = {
		JaxrsWhiteboardConstants.JAX_RS_APPLICATION_BASE + StringPool.EQUAL	+ RestBuilderConstants.JAX_RS_APPLICATION_BASE_VAL,
		JaxrsWhiteboardConstants.JAX_RS_NAME + StringPool.EQUAL + RestBuilderConstants.JAX_RS_NAME_VAL,
		RestBuilderConstants.AUTH_VERIFIER_GUEST_ALLOWED + StringPool.EQUAL	+ StringPool.FALSE }, service = Application.class)
public class RestApiBuilderApp extends Application {

	@Override
	public Set<Object> getSingletons() {
		return Collections.<Object>singleton(this);
	}

	@POST
	@Path("/get/landing-page-url")
	@Produces(MediaType.APPLICATION_JSON)
	public String getLandingPageURL(@Context HttpServletRequest httpServletRequest,
			@Context HttpServletResponse httpServletResponse) {

		_log.info("Fetching landing page details..");

		return restBuilderHelper.getLandingPageURL(httpServletRequest, httpServletResponse);
	}

	@POST
	@Path("/upload-document")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces(MediaType.APPLICATION_JSON)
	public String uploadDocument(@Context HttpServletRequest httpServletRequest,
			@Context HttpServletResponse httpServletResponse) {

		_log.info("Uploading provided documents with metadata");

		return restBuilderHelper.uploadDocument(httpServletRequest, httpServletResponse);

	}

	@POST
	@Path("/upload-content")
	@Produces(MediaType.APPLICATION_JSON)
	public String createWebContent(@Context HttpServletRequest httpServletRequest,
			@Context HttpServletResponse httpServletResponse) {

		return restBuilderHelper.createWebContent(httpServletRequest, httpServletResponse);

	}

	@POST
	@Path("/get-asset-list")
	@Produces(MediaType.APPLICATION_JSON)
	public String getAssetList(@Context HttpServletRequest httpServletRequest,
			@Context HttpServletResponse httpServletResponse) {

		return restBuilderHelper.getAssetListing(httpServletRequest, httpServletResponse);
	}

	@POST
	@Path("/provision-user")
	@Produces(MediaType.APPLICATION_JSON)
	public String provisionUser(@Context HttpServletRequest httpServletRequest,
			@Context HttpServletResponse httpServletResponse) {

		return restBuilderHelper.provisionUser(httpServletRequest, httpServletResponse);  
	}
	
	@GET
	@Path("/get-publications")
	@Produces(MediaType.APPLICATION_JSON)
	public String getAssetLibraries(@Context HttpServletRequest httpServletRequest,
			@Context HttpServletResponse httpServletResponse) {

		return restBuilderHelper.getAssetLibraries(httpServletRequest, httpServletResponse);
	}
	
	@GET
	@Path("/get-publication-roles")
	@Produces(MediaType.APPLICATION_JSON)
	public String getPublicationRoles(@Context HttpServletRequest httpServletRequest,
			@Context HttpServletResponse httpServletResponse) {

		return restBuilderHelper.getPublicationRoles(httpServletRequest, httpServletResponse);
	}
	
	@GET
	@Path("/get-site-roles")
	@Produces(MediaType.APPLICATION_JSON)
	public String getSiteRoles(@Context HttpServletRequest httpServletRequest,
			@Context HttpServletResponse httpServletResponse) {

		return restBuilderHelper.getSiteRoles(httpServletRequest, httpServletResponse);
	}
	
	@GET
	@Path("/get-sites")
	@Produces(MediaType.APPLICATION_JSON)
	public String getSites(@Context HttpServletRequest httpServletRequest,
			@Context HttpServletResponse httpServletResponse) {

		return restBuilderHelper.getSites(httpServletRequest, httpServletResponse);
	}
	
	@POST
	@Path("/terminate-user")
	@Produces(MediaType.APPLICATION_JSON)
	public String terminateUser(@Context HttpServletRequest httpServletRequest,
			@Context HttpServletResponse httpServletResponse) {

		return restBuilderHelper.terminateUser(httpServletRequest, httpServletResponse);  
	}
	
	@POST
	@Path("/test-es-dq")
	@Produces(MediaType.APPLICATION_JSON)
	public String testElaticDQ(@Context HttpServletRequest httpServletRequest,
			@Context HttpServletResponse httpServletResponse) {

		try {
			return restBuilderHelper.testEsDq();
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "got it"; 
		}
		
	}

	@Reference
	private RestBuilderHelper restBuilderHelper;

	private static final Log _log = LogFactoryUtil.getLog(RestApiBuilderApp.class);

}