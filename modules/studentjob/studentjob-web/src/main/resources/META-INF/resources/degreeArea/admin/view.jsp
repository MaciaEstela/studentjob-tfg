 <%@ include file="/init.jsp" %>

<div class="container-fluid-1280">

	<h1>AAAAAAAA <liferay-ui:message key="degreeAreas" /></h1>

	<%-- Clay management toolbar. --%>

	<clay:management-toolbar
		disabled="${degreeAreaCount eq 0}"
		displayContext="${degreeAreasManagementToolbarDisplayContext}"
		itemsTotal="${degreeAreaCount}"
		searchContainerId="degreeAreaEntries"
		selectable="false"
	/>

	<%-- Search container. --%>

	<liferay-ui:search-container 
		emptyResultsMessage="no-degreeAreas"
		id="degreeAreaEntries"
		iteratorURL="${portletURL}" 
		total="${degreeAreaCount}">

		<liferay-ui:search-container-results results="${degreeAreas}" />

		<liferay-ui:search-container-row
			className="edu.uoc.mestemi.studentjob.model.DegreeArea"
			modelVar="entry">

			<%@ include file="/degreeArea/admin/entry_search_columns.jspf" %>

		</liferay-ui:search-container-row>

		<%-- Iterator / Paging --%>

		<liferay-ui:search-iterator 
			displayStyle="${degreeAreasManagementToolbarDisplayContext.getDisplayStyle()}"
			markupView="lexicon" 
		/>
	</liferay-ui:search-container>
	
<!-- 	<c:set var="degreeAreaId" scope="request" value="10" /> -->
<%-- 	<liferay-portlet:runtime portletName="edu_uoc_mestemi_studentjob_web_portlet_StudentjobPortlet_DEGREE_ADMIN" queryString="degreeAreaId=${degreeAreaId}" /> --%>
	
</div>
