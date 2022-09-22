<h2>My Sites</h2>

<ul>
	<c:forEach var="site" items="${userSites}">
		<c:if test="${not empty site.getName()&& site.isOrganization()}">
			<li> <a target="_blank" href="/group${site.getFriendlyURL()}">${site.getName()}</a></li>
		</c:if>
	</c:forEach>
</ul>