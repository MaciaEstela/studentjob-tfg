 <%@ include file="/init.jsp"%>

 <%-- Generate add / edit action URL and set name. --%>

 <c:choose>
	<c:when test="${not empty degree}">
		<portlet:actionURL var="degreeActionURL" name="<%=MVCCommandNames.EDIT_DEGREE_ADMIN %>">
			<portlet:param name="redirect" value="${param.redirect}" />
		</portlet:actionURL>

		<c:set var="editTitle" value="studentjob.degree.admin.edit"/>
	</c:when>
	<c:otherwise>
		<portlet:actionURL var="degreeActionURL" name="<%=MVCCommandNames.ADD_DEGREE_ADMIN %>">
			<portlet:param name="redirect" value="${param.redirect}" />
		</portlet:actionURL>

		<c:set var="editTitle" value="studentjob.degree.admin.create"/>
	</c:otherwise>
 </c:choose>

 <div class="container edit-degree mt-4">
	<liferay-ui:error key="invalid-degreeArea" message="errors.invalid-degreeArea"></liferay-ui:error>
	<liferay-ui:error key="empty-degreeArea" message="errors.empty-degreeArea"></liferay-ui:error>
	<liferay-ui:error key="title-missing-spanish" message="errors.title-missing-spanish"></liferay-ui:error>

	<h1><liferay-ui:message key="${editTitle}" /></h1>

	<aui:model-context bean="${degree}" model="${degreeClass}" />

	<aui:form action="${degreeActionURL}" name="fm">

		<aui:input name="degreeId" field="degreeId" type="hidden" />

		<aui:fieldset-group markupView="lexicon">

			<aui:fieldset>

				<%-- Title field. --%>

				<aui:input required="true"name="name"></aui:input>

				<%-- Degree field. --%>
				<aui:select required="true" label="studentjob.degree.degreeArea" name="degreeArea" multiple="true">
					<c:forEach items="${degreeAreas}" var="degreeArea">
						<c:choose>
							<c:when test="${currentDegreeAreasDegreeIds.contains(degreeArea.getDegreeAreaId())}">
								<aui:option selected="true" label="${degreeArea.getName(locale)}" value="${degreeArea.getDegreeAreaId()}"/>
							</c:when>
							<c:otherwise>
								<aui:option label="${degreeArea.getName(locale)}" value="${degreeArea.getDegreeAreaId()}"/>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</aui:select>

			</aui:fieldset>
		</aui:fieldset-group>

		<%--Buttons. --%>

		<aui:button-row>
			<aui:button cssClass="btn btn-primary" type="submit" />
			<aui:button cssClass="btn btn-secondary" onClick="${param.redirect}" type="cancel" />
		</aui:button-row>
	</aui:form>

 </div>
 
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/slim-select/1.21.0/slimselect.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/slim-select/1.21.0/slimselect.js"></script>

<script type="text/javascript">
AUI().ready('aui-module', function(A){
	new SlimSelect({
		select: '#<portlet:namespace />degreeArea'
	});
});
</script>