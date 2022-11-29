 <%@ include file="/init.jsp" %>

<div class="container-fluid-1280">

	<h1>AAAAAAAA <liferay-ui:message key="offers" /></h1>

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
		emptyResultsMessage="no-offers"
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
