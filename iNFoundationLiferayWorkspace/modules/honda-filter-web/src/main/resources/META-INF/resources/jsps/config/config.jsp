
<%@ include file="../init.jsp" %>

<liferay-portlet:actionURL portletConfiguration="<%= true %>"
	var="configurationActionURL" />

<liferay-portlet:renderURL portletConfiguration="<%= true %>"
	var="configurationRenderURL" />

<aui:form action="<%= configurationActionURL %>" method="post" name="fm">

	<aui:input name="<%= Constants.CMD %>" type="hidden"
		value="<%= Constants.UPDATE %>" />

	<aui:input name="redirect" type="hidden"
		value="<%= configurationRenderURL %>" />

	<aui:fieldset>
		<aui:select name="portletView" label="Select portlet view" value="${portletView}">
			<aui:option value="">---Select portlet mode---</aui:option>
			<aui:option value="documentTypes">Document Types</aui:option>
			<aui:option value="model">Model</aui:option>
			<aui:option value="sections">Sections</aui:option>
		</aui:select>

	</aui:fieldset>
	<aui:button-row>
		<aui:button type="submit"></aui:button>
	</aui:button-row>
</aui:form>