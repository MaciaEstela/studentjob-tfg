 <%@ include file="/init.jsp"%>

 <%-- Generate add / edit action URL and set name. --%>

 <c:choose>
	<c:when test="${not empty degreeArea}">
		<portlet:actionURL var="degreeAreaActionURL" name="<%=MVCCommandNames.EDIT_DEGREEAREA_ADMIN %>">
			<portlet:param name="redirect" value="${param.redirect}" />
		</portlet:actionURL>

		<c:set var="editTitle" value="studentjob.degreeArea.admin.edit"/>
	</c:when>
	<c:otherwise>
		<portlet:actionURL var="degreeAreaActionURL" name="<%=MVCCommandNames.ADD_DEGREEAREA_ADMIN %>">
			<portlet:param name="redirect" value="${param.redirect}" />
		</portlet:actionURL>

		<c:set var="editTitle" value="studentjob.degreeArea.admin.create"/>
	</c:otherwise>
 </c:choose>

 <div class="container edit-degreeArea mt-4">
	<liferay-ui:error key="title-missing-spanish" message="errors.title-missing-spanish"></liferay-ui:error>
	
	<h1><liferay-ui:message key="${editTitle}" /></h1>

	<aui:model-context bean="${degreeArea}" model="${degreeAreaClass}" />

	<aui:form action="${degreeAreaActionURL}" name="fm">

		<aui:input name="degreeAreaId" field="degreeAreaId" type="hidden" />

		<aui:fieldset-group markupView="lexicon">

			<aui:fieldset>

				<%-- Title field. --%>

				<aui:input name="name">

				</aui:input>

			</aui:fieldset>
		</aui:fieldset-group>

		<%--Buttons. --%>

		<aui:button-row cssClass="mt-5">
			<aui:button cssClass="btn btn-primary" type="submit" />
			<aui:button cssClass="btn btn-secondary" onClick="${param.redirect}" type="cancel" />
		</aui:button-row>
	</aui:form>

 </div>