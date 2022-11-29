<%@ include file="/init.jsp"%>

 <c:set var="degreeArea" value="${SEARCH_CONTAINER_RESULT_ROW.object}" />

 <liferay-ui:icon-menu markupView="lexicon">

	<%-- View action.

	<portlet:renderURL var="viewDegreeAreaURL">
		<portlet:param name="mvcRenderCommandName"
			value="<%=MVCCommandNames.VIEW_DEGREEAREA %>" />
		<portlet:param name="redirect" value="${currentURL}" />
		<portlet:param name="degreeAreaId" value="${degreeArea.degreeAreaId}" />
	</portlet:renderURL>

	<liferay-ui:icon message="view" url="${viewDegreeAreaURL}" />

 	--%>
	<%-- Edit action. --%>

	<portlet:renderURL var="editDegreeAreaURL">
		<portlet:param name="mvcRenderCommandName"
			value="<%=MVCCommandNames.EDIT_DEGREEAREA_ADMIN %>" />
		<portlet:param name="redirect" value="${currentURL}" />
		<portlet:param name="degreeAreaId" value="${degreeArea.degreeAreaId}" />
	</portlet:renderURL>

	<liferay-ui:icon message="edit" url="${editDegreeAreaURL}" />	

	<%-- Delete action. --%>

	<portlet:actionURL name="<%=MVCCommandNames.DELETE_DEGREEAREA_ADMIN %>" var="deleteDegreeAreaURL">
		<portlet:param name="redirect" value="${currentURL}" />
		<portlet:param name="degreeAreaId" value="${degreeArea.degreeAreaId}" />
	</portlet:actionURL>

	<liferay-ui:icon-delete url="${deleteDegreeAreaURL}" />

 </liferay-ui:icon-menu>