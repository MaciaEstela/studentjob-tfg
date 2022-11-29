<%@ include file="/init.jsp"%>

 <c:set var="degree" value="${SEARCH_CONTAINER_RESULT_ROW.object}" />

 <liferay-ui:icon-menu markupView="lexicon">

	<%-- View action.

	<portlet:renderURL var="viewDegreeURL">
		<portlet:param name="mvcRenderCommandName"
			value="<%=MVCCommandNames.VIEW_DEGREE %>" />
		<portlet:param name="redirect" value="${currentURL}" />
		<portlet:param name="degreeId" value="${degree.degreeId}" />
	</portlet:renderURL>

	<liferay-ui:icon message="view" url="${viewDegreeURL}" />

 	--%>
	<%-- Edit action. --%>

	<portlet:renderURL var="editDegreeURL">
		<portlet:param name="mvcRenderCommandName"
			value="<%=MVCCommandNames.EDIT_DEGREE_ADMIN %>" />
		<portlet:param name="redirect" value="${currentURL}" />
		<portlet:param name="degreeId" value="${degree.degreeId}" />
	</portlet:renderURL>

	<liferay-ui:icon message="edit" url="${editDegreeURL}" />	

	<%-- Delete action. --%>

	<portlet:actionURL name="<%=MVCCommandNames.DELETE_DEGREE_ADMIN %>" var="deleteDegreeURL">
		<portlet:param name="redirect" value="${currentURL}" />
		<portlet:param name="degreeId" value="${degree.degreeId}" />
	</portlet:actionURL>

	<liferay-ui:icon-delete url="${deleteDegreeURL}" />

 </liferay-ui:icon-menu>