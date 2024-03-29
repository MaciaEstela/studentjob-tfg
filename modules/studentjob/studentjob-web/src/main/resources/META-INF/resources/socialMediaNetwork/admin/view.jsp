 <%@ include file="/init.jsp" %>

<div class="container-fluid-1280">

	<%-- Clay management toolbar. --%>

	<clay:management-toolbar
		disabled="${socialMediaNetworkCount eq 0}"
		displayContext="${socialMediaNetworksManagementToolbarDisplayContext}"
		itemsTotal="${socialMediaNetworkCount}"
		searchContainerId="socialMediaNetworkEntries"
		selectable="false"
	/>

	<%-- Search container. --%>
	<div class="container">
		<liferay-ui:search-container 
			emptyResultsMessage="studentjob.socialMediaNetwork.admin.no-result"
			id="socialMediaNetworkEntries"
			iteratorURL="${portletURL}" 
			total="${socialMediaNetworkCount}">
	
			<liferay-ui:search-container-results results="${socialMediaNetworks}" />
	
			<liferay-ui:search-container-row
				className="edu.uoc.mestemi.studentjob.model.SocialMediaNetwork"
				modelVar="entry">
	
				<%@ include file="/socialMediaNetwork/admin/entry_search_columns.jspf" %>
	
			</liferay-ui:search-container-row>
	
			<%-- Iterator / Paging --%>
	
			<liferay-ui:search-iterator 
				displayStyle="${socialMediaNetworksManagementToolbarDisplayContext.getDisplayStyle()}"
				markupView="lexicon" 
			/>
		</liferay-ui:search-container>
	</div>
</div>
