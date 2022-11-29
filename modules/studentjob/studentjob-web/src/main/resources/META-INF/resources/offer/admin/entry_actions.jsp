<%@ include file="/init.jsp"%>

 <c:set var="offer" value="${SEARCH_CONTAINER_RESULT_ROW.object}" />

 <liferay-ui:icon-menu markupView="lexicon">

	<%-- View action.

	<portlet:renderURL var="viewOfferURL">
		<portlet:param name="mvcRenderCommandName"
			value="<%=MVCCommandNames.VIEW_OFFER %>" />
		<portlet:param name="redirect" value="${currentURL}" />
		<portlet:param name="offerId" value="${offer.offerId}" />
	</portlet:renderURL>

	<liferay-ui:icon message="view" url="${viewOfferURL}" />

 	--%>
	<%-- Edit action. --%>

	<portlet:renderURL var="editOfferURL">
		<portlet:param name="mvcRenderCommandName"
			value="<%=MVCCommandNames.EDIT_OFFER_ADMIN %>" />
		<portlet:param name="redirect" value="${currentURL}" />
		<portlet:param name="offerId" value="${offer.offerId}" />
	</portlet:renderURL>

	<liferay-ui:icon message="edit" url="${editOfferURL}" />	

	<%-- Delete action. --%>

	<portlet:actionURL name="<%=MVCCommandNames.DELETE_OFFER_ADMIN %>" var="deleteOfferURL">
		<portlet:param name="redirect" value="${currentURL}" />
		<portlet:param name="offerId" value="${offer.offerId}" />
	</portlet:actionURL>

	<liferay-ui:icon-delete url="${deleteOfferURL}" />

 </liferay-ui:icon-menu>