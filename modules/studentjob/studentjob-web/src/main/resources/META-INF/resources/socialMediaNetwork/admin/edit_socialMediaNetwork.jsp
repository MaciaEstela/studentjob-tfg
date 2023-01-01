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

 <div class="container edit-socialMediaNetwork mt-4">

	<liferay-ui:error key="invalid-website" message="errors.invalid-website"></liferay-ui:error>
	<liferay-ui:error key="invalid-attached-file" message="errors.invalid-attached-file"></liferay-ui:error>

	<h1><liferay-ui:message key="${editTitle}" /></h1>

	<aui:model-context bean="${socialMediaNetwork}" model="${socialMediaNetworkClass}" />

	<aui:form action="${socialMediaNetworkActionURL}" name="fm">

		<aui:input name="socialMediaNetworkId" field="socialMediaNetworkId" type="hidden" />

		<aui:fieldset-group markupView="lexicon">

			<aui:fieldset>

				<%-- Title field. --%>

				<aui:input required="true" name="name"></aui:input>
				<aui:input required="true" label="studentjob.socialMediaNetwork.admin.url" name="baseURL"></aui:input>
				
				<c:set var="cvRequired" value = "true"/>
				<c:if test="${!logoUrl.isEmpty()}">
					<c:set var="cvRequired" value = "false"/>
				</c:if>
				<aui:input required="${cvRequired}" label="studentjob.socialMediaNetwork.admin.logo" type="file" accept="image/*" name="logo" ></aui:input>
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