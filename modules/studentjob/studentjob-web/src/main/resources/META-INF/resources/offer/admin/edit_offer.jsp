<%@ include file="/init.jsp"%>

<%-- Generate add / edit action URL and set title. --%>

<c:choose>
	<c:when test="${not empty offer}">
		<portlet:actionURL var="offerActionURL" name="<%=MVCCommandNames.EDIT_OFFER_ADMIN %>">
			<portlet:param name="redirect" value="${param.redirect}" />
		</portlet:actionURL>

		<c:set var="editTitle" value="studentjob.offers.edit-title"/>
	</c:when>
	<c:otherwise>
		<portlet:actionURL var="offerActionURL" name="<%=MVCCommandNames.ADD_OFFER_ADMIN %>">
			<portlet:param name="redirect" value="${param.redirect}" />
		</portlet:actionURL>

		<c:set var="editTitle" value="studentjob.offers.create-title"/>
	</c:otherwise>
</c:choose>

 <div class="container-fluid-1280 edit-offer">

	<liferay-ui:error key="invalid-region-id" message="errors.invalid-region-id"></liferay-ui:error>
	<liferay-ui:error key="title-missing-spanish" message="errors.title-missing-spanish"></liferay-ui:error>
	<liferay-ui:error key="description-missing-spanish" message="errors.description-missing-spanish"></liferay-ui:error>
	<liferay-ui:error key="invalid-preference" message="errors.invalid-preference"></liferay-ui:error>
	<liferay-ui:error key="empty-degree" message="errors.empty-degree"></liferay-ui:error>
	<liferay-ui:error key="invalid-degree" message="errors.invalid-degree"></liferay-ui:error>

	<h1><liferay-ui:message key="${editTitle}" /></h1>

	<aui:model-context bean="${offer}" model="${offerClass}" />

	<aui:form action="${offerActionURL}" name="fm">

		<aui:input name="offerId" field="offerId" type="hidden" />

		<aui:fieldset-group markupView="lexicon">

			<aui:fieldset>

				<%-- Title field. --%>

				<aui:input name="title" label="studentjob.offers.form.title" required="true">
				</aui:input>

				<%-- Preference field. --%>
				<aui:select name="preference" label="studentjob.offers.form.preference" required="true">
					<c:forEach items="${preferences}" var="preference">
						<c:choose>
							<c:when test="${offer.getPreference() == preference}">
								<aui:option selected="true" label="${preference}" value="${preference}"/>
							</c:when>
							<c:otherwise>
								<aui:option label="${preference}" value="${preference}"/>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</aui:select>

				<%-- Description field. --%>
				<label class="control-label">
					<liferay-ui:message key="studentjob.offers.form.description" />
				</label>
				<div class="alloy-editor-container" required="true">
					<liferay-ui:input-localized
						xml="${offer.getDescription()}"
						type="editor"
						cssClass="studentjob-ckeditor"
						editorName="ckeditor"
						name="description"
						toolbarSet="studentsimple"
						showSource="false" />
				</div>

				<%-- Region field. --%>
				<aui:select name="region" label="studentjob.offers.form.region" required="true">
					<c:forEach items="${regions}" var="region">
						<c:choose>
							<c:when test="${region.getRegionId() == offer.getRegionId()}">
								<aui:option selected="true" label="${region.getName()}" value="${region.getRegionCode()}"/>
							</c:when>
							<c:otherwise>
								<aui:option label="${region.getName()}" value="${region.getRegionCode()}"/>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</aui:select>
				
				<%-- Degree field. --%>
				<aui:select name="degree" label="studentjob.offers.form.degree" multiple="true" required="true">
					<c:forEach items="${degrees}" var="degree">
						<c:choose>
							<c:when test="${currentOfferDegreesIds.contains(degree.getDegreeId())}">
								<aui:option selected="true" label="${degree.getName(locale)}" value="${degree.getDegreeId()}"/>
							</c:when>
							<c:otherwise>
								<aui:option label="${degree.getName(locale)}" value="${degree.getDegreeId()}"/>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</aui:select>
			</aui:fieldset>
		</aui:fieldset-group>

		<%--Buttons. --%>

		<aui:button-row cssClass="mt-5 d-flex justify-content-center">
			<aui:button cssClass="btn btn-primary" type="submit" />
			<aui:button cssClass="ml-3 btn btn-secondary" onClick="${param.redirect}" type="cancel" />
		</aui:button-row>
	</aui:form>
</div>

<link rel="stylesheet" href="/o/studentjob-theme/css/slimselect.css">
<script src="/o/studentjob-theme/js/slimselect.js"></script>

<script type="text/javascript">
AUI().ready('aui-module', function(A){
	new SlimSelect({
		select: '#<portlet:namespace />degree'
	});
});
</script>