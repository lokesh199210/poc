<%@ include file="init.jsp" %>

<c:choose>
	<c:when test='${portletView eq "documentTypes" }'>
		
		<%@ include file="documentTypes/view.jsp" %>
	
	</c:when>
	<c:when test='${portletView eq "model" }'>
	
		<%@ include file="modelYear/view.jsp" %>
	
	</c:when>
	<c:when test='${portletView eq "sections" }'>
	
		<%@ include file="sections/view.jsp" %>
	
	</c:when>
	<c:otherwise>
		<p>Please config module preferences</p>
	</c:otherwise>


   </c:choose>




