<%@ include file="init.jsp" %>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>

<div style="text-align:center">
	<h2> Thankyou for you Request </h2>
	<h3> User has been onboarded !! </h3>
</div>
<div style="text-align:center">
	<input type="button" class="" id="editUser" value="Edit User" onclick="editUser();">
</div>


<script>
function editUser() {
	console.log("Inside editUser method !!");

	var userId = <%=ParamUtil.getString(request, "uId")%>
	console.log("User Id received is " + userId);
	
	var portalURL = '<%=themeDisplay.getPortalURL()%>';
	
	var url = portalURL+'/group/control_panel/manage?p_p_id=com_liferay_users_admin_web_portlet_UsersAdminPortlet&p_p_lifecycle=0&p_p_state=maximized&p_p_mode=view&_com_liferay_users_admin_web_portlet_UsersAdminPortlet_p_u_i_d='+userId+'&_com_liferay_users_admin_web_portlet_UsersAdminPortlet_mvcRenderCommandName=%2Fusers_admin%2Fedit_user';
	window.location.href = url;
}
</script>

