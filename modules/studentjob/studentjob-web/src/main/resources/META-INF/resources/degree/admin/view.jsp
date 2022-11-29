 <%@ include file="/init.jsp" %>

<%
	String instance=renderRequest.getParameter("instanceId");
%>

<div class="container-fluid-1280">

	<h1>AAAAAAAasA <liferay-ui:message key="degrees" /></h1>

	<%-- Clay management toolbar. --%>

	<clay:management-toolbar
		disabled="${degreeCount eq 0}"
		displayContext="${degreesManagementToolbarDisplayContext}"
		itemsTotal="${degreeCount}"
		searchContainerId="degreeEntries"
		selectable="false"
	/>

	<%-- Search container. --%>

	<liferay-ui:search-container 
		emptyResultsMessage="no-degrees"
		id="degreeEntries"
		iteratorURL="${portletURL}" 
		total="${degreeCount}">

		<liferay-ui:search-container-results results="${degrees}" />

		<liferay-ui:search-container-row
			className="edu.uoc.mestemi.studentjob.model.Degree"
			modelVar="entry">

			<%@ include file="/degree/admin/entry_search_columns.jspf" %>

		</liferay-ui:search-container-row>

		<%-- Iterator / Paging --%>

		<liferay-ui:search-iterator 
			displayStyle="${degreesManagementToolbarDisplayContext.getDisplayStyle()}"
			markupView="lexicon" 
		/>
	</liferay-ui:search-container>
</div>
