<%@ include file="/init.jsp" %>
<head>
	<link rel="stylesheet" href="/o/studentjob-theme/css/slimselect.css">
	<script src="/o/studentjob-theme/js/slimselect.js"></script>
</head>

<div class="container-fluid-1280">

	<%-- Clay management toolbar. --%>

	<clay:management-toolbar
		disabled="${degreeAreaCount eq 0}"
		displayContext="${degreeAreasManagementToolbarDisplayContext}"
		itemsTotal="${degreeAreaCount}"
		searchContainerId="degreeAreaEntries"
		selectable="false"
	/>

	<%-- Search container. --%>

<div class="container">
	<liferay-ui:error key="degreearea-has-degree" message="errors.degreearea-has-degree"></liferay-ui:error>

	<liferay-ui:search-container 
		emptyResultsMessage="studentjob.degreeArea.admin.no-result"
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
</div>
