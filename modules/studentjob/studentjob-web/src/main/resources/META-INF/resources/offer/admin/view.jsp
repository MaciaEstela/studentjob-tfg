 <%@ include file="/init.jsp" %>

<c:choose>
	<c:when test = "${!activeCompany}">
		<h1><liferay-ui:message key="studentjob.offers.inactive-company" /></h1>
	</c:when>
	<c:otherwise>
<div class="container-fluid-1280">
	<h1><liferay-ui:message key="studentjob.offers.admin-title" /></h1>
	<liferay-ui:error key="invalid-region-id" message="errors.invalid-region-id"></liferay-ui:error>
	<liferay-ui:error key="title-missing-spanish" message="errors.title-missing-spanish"></liferay-ui:error>
	<liferay-ui:error key="description-missing-spanish" message="errors.description-missing-spanish"></liferay-ui:error>
	<liferay-ui:error key="invalid-preference" message="errors.invalid-preference"></liferay-ui:error>
	<liferay-ui:error key="empty-degree" message="errors.empty-degree"></liferay-ui:error>
	<liferay-ui:error key="invalid-degree" message="errors.invalid-degree"></liferay-ui:error>
	<liferay-ui:success key="offer-added" message="messages.offer-added"/>
	
	<%-- Clay management toolbar. --%>

	<clay:management-toolbar
		disabled="${offerCount eq 0}"
		displayContext="${offersManagementToolbarDisplayContext}"
		itemsTotal="${offerCount}"
		searchContainerId="offerEntries"
		selectable="false"
	/>

	<%-- Search container. --%>

	<liferay-ui:search-container 
		emptyResultsMessage="studentjob.offers.form.no-offers"
		id="offerEntries"
		iteratorURL="${portletURL}" 
		total="${offerCount}">

		<liferay-ui:search-container-results results="${offers}" />

		<liferay-ui:search-container-row
			className="edu.uoc.mestemi.studentjob.model.Offer"
			modelVar="entry">

			<%@ include file="/offer/admin/entry_search_columns.jspf" %>

		</liferay-ui:search-container-row>

		<%-- Iterator / Paging --%>

		<liferay-ui:search-iterator 
			displayStyle="${offersManagementToolbarDisplayContext.getDisplayStyle()}"
			markupView="lexicon" 
		/>
	</liferay-ui:search-container>
</div>
	</c:otherwise>
</c:choose>
