 <%@ include file="/init.jsp"%>

 <%-- Generate add / edit action URL and set name. --%>

 <c:choose>
	<c:when test="${not empty socialMediaNetwork}">
		<portlet:actionURL var="socialMediaNetworkActionURL" name="<%=MVCCommandNames.EDIT_SOCIALMEDIANETWORK_ADMIN %>">
			<portlet:param name="redirect" value="${param.redirect}" />
		</portlet:actionURL>

		<c:set var="editTitle" value="studentjob.socialMediaNetwork.admin.edit"/>
	</c:when>
	<c:otherwise>
		<portlet:actionURL var="socialMediaNetworkActionURL" name="<%=MVCCommandNames.ADD_SOCIALMEDIANETWORK_ADMIN %>">
			<portlet:param name="redirect" value="${param.redirect}" />
		</portlet:actionURL>

		<c:set var="editTitle" value="studentjob.socialMediaNetwork.admin.create"/>
	</c:otherwise>
 </c:choose>

 <div class="container edit-socialMediaNetwork">

	<h1><liferay-ui:message key="${editTitle}" /></h1>

	<aui:model-context bean="${socialMediaNetwork}" model="${socialMediaNetworkClass}" />

	<aui:form action="${socialMediaNetworkActionURL}" name="fm">

		<aui:input name="socialMediaNetworkId" field="socialMediaNetworkId" type="hidden" />

		<aui:fieldset-group markupView="lexicon">

			<aui:fieldset>

				<%-- Title field. --%>

				<aui:input name="name"></aui:input>
				<aui:input name="baseURL"></aui:input>
				<aui:input label="form.socialmedianetwork.logo" type="file" accept="image/*" name="logo" ></aui:input>
				<c:if test="${!logoUrl.isEmpty()}">
					<img width="50px" height="50px" src="${logoUrl}">
				</c:if>
			</aui:fieldset>
		</aui:fieldset-group>

		<%--Buttons. --%>

		<aui:button-row>
			<aui:button cssClass="btn btn-primary" type="submit" />
			<aui:button cssClass="btn btn-secondary" onClick="${param.redirect}" type="cancel" />
		</aui:button-row>
	</aui:form>

 </div>