 <%@ include file="/init.jsp"%>

 <%-- Generate add / edit action URL and set name. --%>

<portlet:actionURL var="companyProfileActionURL" name="<%=MVCCommandNames.EDIT_COMPANYPROFILE_USER %>">
	<portlet:param name="redirect" value="${param.redirect}" />
</portlet:actionURL>

<c:set var="editTitle" value="edit-companyProfile"/>

<div class="container-fluid-1280 edit-companyProfile">

	<h1><liferay-ui:message key="${editTitle}" /></h1>

	<aui:model-context bean="${companyProfile}" model="${companyProfileClass}" />

	<aui:form action="${companyProfileActionURL}" name="fm">

		<aui:input name="companyProfileId" field="companyProfileId" type="hidden" />

		<aui:fieldset-group markupView="lexicon">

			<aui:fieldset>
				<aui:input name="title">
				</aui:input>
				
				<div class="alloy-editor-container">
					<liferay-ui:input-localized
						contents="Descripción"
						xml="${companyProfile.getDescription()}"
						type="editor"
						cssClass="studentjob-ckeditor"
						editorName="ckeditor"
						name="description"
						toolbarSet="studentsimple"
						showSource="false" />
				</div>
				
				<aui:input name="email">
				</aui:input>
				
				<aui:input name="sector">
				</aui:input>
				
				<aui:input name="website">
				</aui:input>
				
				<%-- Region field. --%>
				<aui:select name="region" label="offer.region">
					<c:forEach items="${regions}" var="region">
						<c:choose>
							<c:when test="${region.getRegionId() == companyProfile.getRegionId()}">
								<aui:option selected="true" label="${region.getName()}" value="${region.getRegionCode()}"/>
							</c:when>
							<c:otherwise>
								<aui:option label="${region.getName()}" value="${region.getRegionCode()}"/>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</aui:select>
				
				<%-- SocialMedia field. --%>
				 <%@ include file="/utils/socialMedia.jspf"%>

				<aui:input name="active" type="checkbox" value="${companyProfile.isActive()}"/>
			</aui:fieldset>
		</aui:fieldset-group>

		<%--Buttons. --%>

		<aui:button-row>
			<aui:button cssClass="btn btn-primary" type="submit" />
			<aui:button cssClass="btn btn-secondary" onClick="${param.redirect}" type="cancel" />
		</aui:button-row>
	</aui:form>

</div>

