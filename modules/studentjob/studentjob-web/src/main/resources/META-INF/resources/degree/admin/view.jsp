 <%@ include file="/init.jsp" %>

<%
	String instance=renderRequest.getParameter("instanceId");
%>

<div class="container-fluid-1280">

	<%-- Clay management toolbar. --%>

	<clay:management-toolbar
		disabled="${degreeCount eq 0}"
		displayContext="${degreesManagementToolbarDisplayContext}"
		itemsTotal="${degreeCount}"
		searchContainerId="degreeEntries"
		selectable="false"
	/>

	<%-- Search container. --%>
<div class="container">
		<liferay-ui:error key="degree-linked-student" message="errors.degree-linked-student"></liferay-ui:error>
		<liferay-ui:error key="degree-linked-offer" message="errors.degree-linked-offer"></liferay-ui:error>
		<liferay-ui:search-container 
			emptyResultsMessage="studentjob.degree.admin.no-result"
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
</div>
