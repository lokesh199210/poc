<%@page import="com.liferay.petra.string.StringPool"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="java.util.stream.Collectors"%>
<%@page import="com.liferay.portal.kernel.model.Group"%>
<%@page import="com.liferay.portal.kernel.service.GroupLocalServiceUtil"%>
<%@page import="com.honda.db.handlers.AssetLibraryHandler"%>
<%@page import="java.util.List"%>

<liferay-theme:defineObjects />

<portlet:defineObjects />

<c:set var="configuredAssetLibraryId" value="<%=portletPreferences.getValue("configuredAssetLibraryId", StringPool.BLANK) %>"/>

