 <%@ include file="/init.jsp"%>

 <%-- Generate add / edit action URL and set name. --%>

<portlet:actionURL var="companyProfileActionURL" name="<%=MVCCommandNames.EDIT_COMPANYPROFILE_ADMIN_ACTION %>">
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
				<aui:input label="studentjob.companyprofile.form.title" name="title">
				</aui:input>
				
				<aui:input label="studentjob.companyprofile.form.email" name="email">
				</aui:input>
				
				<aui:input label="studentjob.companyprofile.form.sector" name="sector">
				</aui:input>
				
				<aui:input label="studentjob.companyprofile.form.website" name="website">
				</aui:input>
				
				<label class="control-label">
					<liferay-ui:message key="studentjob.companyprofile.form.description" />
				</label>
				<div class="alloy-editor-container">
					<liferay-ui:input-localized
						xml="${companyProfile.getDescription()}"
						type="editor"
						cssClass="studentjob-ckeditor"
						editorName="ckeditor"
						name="description"
						toolbarSet="studentsimple"
						showSource="false" />
				</div>
				
				<%-- Region field. --%>
				<aui:select name="region" label="studentjob.companyprofile.form.region">
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

				<aui:input name="active" label="studentjob.companyprofile.form.active" type="checkbox" value="${companyProfile.isActive()}"/>
			</aui:fieldset>
		</aui:fieldset-group>

		<%--Buttons. --%>

		<aui:button-row cssClass="mt-5 d-flex justify-content-center">
			<aui:button cssClass="btn btn-primary" type="submit" />
			<aui:button cssClass="ml-3 btn btn-secondary" onClick="${param.redirect}" type="cancel" />
		</aui:button-row>
	</aui:form>

</div>

