<%@ include file="/init.jsp"%>

 <c:set var="socialMediaNetwork" value="${SEARCH_CONTAINER_RESULT_ROW.object}" />

 <liferay-ui:icon-menu markupView="lexicon">

	<%-- View action.

	<portlet:renderURL var="viewSocialMediaNetworkURL">
		<portlet:param name="mvcRenderCommandName"
			value="<%=MVCCommandNames.VIEW_SOCIALMEDIANETWORK %>" />
		<portlet:param name="redirect" value="${currentURL}" />
		<portlet:param name="socialMediaNetworkId" value="${socialMediaNetwork.socialMediaNetworkId}" />
	</portlet:renderURL>

	<liferay-ui:icon message="view" url="${viewSocialMediaNetworkURL}" />

 	--%>
	<%-- Edit action. --%>

	<portlet:renderURL var="editSocialMediaNetworkURL">
		<portlet:param name="mvcRenderCommandName"
			value="<%=MVCCommandNames.EDIT_SOCIALMEDIANETWORK_ADMIN %>" />
		<portlet:param name="redirect" value="${currentURL}" />
		<portlet:param name="socialMediaNetworkId" value="${socialMediaNetwork.socialMediaNetworkId}" />
	</portlet:renderURL>

	<liferay-ui:icon message="edit" url="${editSocialMediaNetworkURL}" />	

	<%-- Delete action. --%>

	<portlet:actionURL name="<%=MVCCommandNames.DELETE_SOCIALMEDIANETWORK_ADMIN %>" var="deleteSocialMediaNetworkURL">
		<portlet:param name="redirect" value="${currentURL}" />
		<portlet:param name="socialMediaNetworkId" value="${socialMediaNetwork.socialMediaNetworkId}" />
	</portlet:actionURL>

	<liferay-ui:icon-delete url="${deleteSocialMediaNetworkURL}" />

 </liferay-ui:icon-menu>