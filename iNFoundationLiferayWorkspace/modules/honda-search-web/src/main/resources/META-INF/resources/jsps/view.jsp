<%@ include file="init.jsp"%>

<c:choose>
	<c:when test="${not empty searchContainer}">
		<liferay-ui:search-container searchContainer="${searchContainer}">
			<liferay-ui:search-container-results>
				<liferay-ui:search-container-row
					className="com.honda.search.web.beans.HondaSearchResultBean"
					modelVar="detail">

					<liferay-ui:search-container-column-text name="Title">
						<a href="${detail.getViewURL()}">${detail.getTitle()}</a>
					</liferay-ui:search-container-column-text>


					<liferay-ui:search-container-column-text name="Description"
						value="${detail.getDescription()}">

					</liferay-ui:search-container-column-text>

				</liferay-ui:search-container-row>
				<liferay-ui:search-iterator displayStyle="list" markupView="lexicon" />

			</liferay-ui:search-container-results>
		</liferay-ui:search-container>
	</c:when>
	<c:otherwise>
		<p>No data found</p>
	</c:otherwise>
</c:choose>