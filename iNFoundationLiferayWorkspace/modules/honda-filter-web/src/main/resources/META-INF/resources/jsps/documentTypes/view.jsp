<h2>Document Types</h2>

<c:forEach var="documentType" items="${documentTypes}">
	<input type="checkbox" name="${documentType.getCategoryId()}" value="${documentType.getCategoryId()}" onclick="applyCategoryFilter('${documentType.getCategoryId()}');">
  	<label for="${documentType.getCategoryId()}"> ${documentType.getName()}</label><br>
</c:forEach>