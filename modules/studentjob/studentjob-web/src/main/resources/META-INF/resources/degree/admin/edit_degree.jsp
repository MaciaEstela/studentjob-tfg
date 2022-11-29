 <%@ include file="/init.jsp"%>

 <%-- Generate add / edit action URL and set name. --%>

 <c:choose>
	<c:when test="${not empty degree}">
		<portlet:actionURL var="degreeActionURL" name="<%=MVCCommandNames.EDIT_DEGREE_ADMIN %>">
			<portlet:param name="redirect" value="${param.redirect}" />
		</portlet:actionURL>

		<c:set var="editTitle" value="edit-degree"/>
	</c:when>
	<c:otherwise>
		<portlet:actionURL var="degreeActionURL" name="<%=MVCCommandNames.ADD_DEGREE_ADMIN %>">
			<portlet:param name="redirect" value="${param.redirect}" />
		</portlet:actionURL>

		<c:set var="editTitle" value="add-degree"/>
	</c:otherwise>
 </c:choose>

 <div class="container-fluid-1280 edit-degree">

	<h1><liferay-ui:message key="${editTitle}" /></h1>

	<aui:model-context bean="${degree}" model="${degreeClass}" />

	<aui:form action="${degreeActionURL}" name="fm">

		<aui:input name="degreeId" field="degreeId" type="hidden" />

		<aui:fieldset-group markupView="lexicon">

			<aui:fieldset>

				<%-- Title field. --%>

				<aui:input name="name">

				</aui:input>

				<%-- Degree field. --%>
				<aui:select name="degreeArea" label="offer.degreeArea" multiple="true">
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