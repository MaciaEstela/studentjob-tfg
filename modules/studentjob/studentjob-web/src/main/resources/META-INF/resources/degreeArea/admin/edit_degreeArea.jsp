 <%@ include file="/init.jsp"%>

 <%-- Generate add / edit action URL and set name. --%>

 <c:choose>
	<c:when test="${not empty degreeArea}">
		<portlet:actionURL var="degreeAreaActionURL" name="<%=MVCCommandNames.EDIT_DEGREEAREA_ADMIN %>">
			<portlet:param name="redirect" value="${param.redirect}" />
		</portlet:actionURL>

		<c:set var="editTitle" value="edit-degreeArea"/>
	</c:when>
	<c:otherwise>
		<portlet:actionURL var="degreeAreaActionURL" name="<%=MVCCommandNames.ADD_DEGREEAREA_ADMIN %>">
			<portlet:param name="redirect" value="${param.redirect}" />
		</portlet:actionURL>

		<c:set var="editTitle" value="add-degreeArea"/>
	</c:otherwise>
 </c:choose>

 <div class="container-fluid-1280 edit-degreeArea">

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

		<aui:button-row>
			<aui:button cssClass="btn btn-primary" type="submit" />
			<aui:button cssClass="btn btn-secondary" onClick="${param.redirect}" type="cancel" />
		</aui:button-row>
	</aui:form>

 </div>