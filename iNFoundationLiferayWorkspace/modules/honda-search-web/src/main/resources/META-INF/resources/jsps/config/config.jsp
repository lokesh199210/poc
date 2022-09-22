

<%@ include file="../init.jsp" %>

<liferay-portlet:actionURL portletConfiguration="<%= true %>"
	var="configurationActionURL" />

<liferay-portlet:renderURL portletConfiguration="<%= true %>"
	var="configurationRenderURL" />
	
<%
List <Group> groups = GroupLocalServiceUtil.getActiveGroups(themeDisplay.getCompanyId(), Boolean.TRUE);


groups =  (groups.stream().filter(group -> group.getFriendlyURL().contains("/asset-library"))).collect(Collectors.toList());

%>

<c:set var="publications" value="<%=groups%>"/>

<aui:form action="<%= configurationActionURL %>" method="post" name="fm">

	<aui:input name="<%= Constants.CMD %>" type="hidden"
		value="<%= Constants.UPDATE %>" />

	<aui:input name="redirect" type="hidden"
		value="<%= configurationRenderURL %>" />

	<aui:fieldset>
		<aui:select name="configuredAssetLibraryId" label="Select asset library" value="${configuredAssetLibraryId}">
			<aui:option value="">---Select publication---</aui:option>
			 <c:forEach var="publication" items="${publications}">
				<aui:option value="${publication.getGroupId()}">${publication.getName(locale)}</aui:option>
			 </c:forEach>
		</aui:select>

	</aui:fieldset>
	<aui:button-row>
		<aui:button type="submit"></aui:button>
	</aui:button-row>
</aui:form>