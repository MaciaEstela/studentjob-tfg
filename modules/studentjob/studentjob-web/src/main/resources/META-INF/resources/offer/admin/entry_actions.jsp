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
	<c:if test = "${offer.status == 0}">
		<portlet:renderURL var="editOfferURL">
			<portlet:param name="mvcRenderCommandName"
				value="<%=MVCCommandNames.EDIT_OFFER_ADMIN %>" />
			<portlet:param name="redirect" value="${currentURL}" />
			<portlet:param name="offerId" value="${offer.offerId}" />
		</portlet:renderURL>
		
		<liferay-ui:icon message="edit" url="${editOfferURL}" />
	</c:if>
		
	
	<%-- Expire action. --%>
	<c:if test = "${offer.status == 0}">
		<portlet:actionURL name="<%=MVCCommandNames.EXPIRE_OFFER_ADMIN %>" var="expireOfferURL">
			<portlet:param name="redirect" value="${currentURL}" />
			<portlet:param name="offerId" value="${offer.offerId}" />
		</portlet:actionURL>
			
		<liferay-ui:icon  message="expire" url="${expireOfferURL}" />
	</c:if>
	
	<%-- View inscriptions render. --%>
	<portlet:renderURL var="viewInscriptionsURL">
		<portlet:param name="mvcRenderCommandName" value="<%=MVCCommandNames.VIEW_INSCRIPTIONS %>" />
		<portlet:param name="redirect" value="${currentURL}" />
		<portlet:param name="offerId" value="${offer.offerId}" />
	</portlet:renderURL>

	<liferay-ui:icon message="studentjob.offers.view-inscriptions" url="${viewInscriptionsURL}" />

	<%-- Delete action. --%>
	<portlet:actionURL name="<%=MVCCommandNames.DELETE_OFFER_ADMIN %>" var="deleteOfferURL">
		<portlet:param name="redirect" value="${currentURL}" />
		<portlet:param name="offerId" value="${offer.offerId}" />
	</portlet:actionURL>

	<liferay-ui:icon-delete url="${deleteOfferURL}" />

 </liferay-ui:icon-menu>