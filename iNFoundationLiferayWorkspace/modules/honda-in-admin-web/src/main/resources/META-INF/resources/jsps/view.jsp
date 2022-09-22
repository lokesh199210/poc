<%@ include file="init.jsp" %>

<c:choose>
	<c:when test='${portletView eq "mySitesView" }'>
		
		<%@ include file="mySites/view.jsp" %>
	
	</c:when>
	<c:when test='${portletView eq "myAssetLibraryView" }'>
	
		<%@ include file="myAssetLibraries/view.jsp" %>
	
	</c:when>
	<c:when test='${portletView eq "myTaskView" }'>
	
		<%@ include file="myTasks/view.jsp" %>
	
	</c:when>
	<c:otherwise>
		<p>Please config module preferences</p>
	</c:otherwise>


   </c:choose>