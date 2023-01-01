 <%@ include file="/init.jsp"%>

 <%-- Generate add / edit action URL and set name. --%>

<portlet:actionURL var="studentProfileActionURL" name="<%=MVCCommandNames.EDIT_STUDENTPROFILE_ADMIN_ACTION %>">
	<portlet:param name="redirect" value="${param.redirect}" />
</portlet:actionURL>

<c:set var="editTitle" value="studentjob.studentprofile.admin.edit"/>

<div class="container-fluid-1280 edit-studentProfile">
	<liferay-ui:error key="invalid-region-id" message="errors.invalid-region-id"></liferay-ui:error>
	<liferay-ui:error key="title-missing-spanish" message="errors.title-missing-spanish"></liferay-ui:error>
	<liferay-ui:error key="description-missing-spanish" message="errors.description-missing-spanish"></liferay-ui:error>
	<liferay-ui:error key="invalid-preference" message="errors.invalid-preference"></liferay-ui:error>
	<liferay-ui:error key="empty-degree" message="errors.empty-degree"></liferay-ui:error>
	<liferay-ui:error key="invalid-degree" message="errors.invalid-degree"></liferay-ui:error>
	<liferay-ui:error key="invalid-email" message="errors.invalid-email"></liferay-ui:error>
	
	<h1><liferay-ui:message key="${editTitle}" /></h1>

	<aui:model-context bean="${studentProfile}" model="${studentProfileClass}" />

	<aui:form action="${studentProfileActionURL}" name="fm">

		<aui:input name="studentProfileId" field="studentProfileId" type="hidden" />

		<aui:fieldset-group markupView="lexicon">

			<aui:fieldset>
				<aui:input required="true" label="studentjob.studentprofile.form.title" name="title">
				</aui:input>
				
				<label class="control-label">
					<liferay-ui:message key="studentjob.studentprofile.form.description" />
				</label>
				<div class="alloy-editor-container">
					<liferay-ui:input-localized
						required="true" 
						xml="${studentProfile.getDescription()}"
						type="editor"
						cssClass="studentjob-ckeditor"
						editorName="ckeditor"
						name="description"
						toolbarSet="studentsimple"
						showSource="false" />
				</div>
				
				<aui:input required="true" type="email" label="studentjob.studentprofile.form.email" name="email">
				</aui:input>
				
				<%-- Preference field. --%>
				<aui:select required="true" name="preference" label="studentjob.studentprofile.form.preference">
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
				
				<%-- Region field. --%>
				<aui:select required="true" name="region" label="studentjob.studentprofile.form.region">
					<c:forEach items="${regions}" var="region">
						<c:choose>
							<c:when test="${region.getRegionId() == studentProfile.getRegionId()}">
								<aui:option selected="true" label="${region.getName()}" value="${region.getRegionCode()}"/>
							</c:when>
							<c:otherwise>
								<aui:option label="${region.getName()}" value="${region.getRegionCode()}"/>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</aui:select>
				
				<%-- Degree field. --%>
				<aui:select required="true" name="degree" label="studentjob.studentprofile.form.degree" multiple="true">
					<c:forEach items="${degrees}" var="degree">
						<c:choose>
							<c:when test="${currentStudentProfileDegreesIds.contains(degree.getDegreeId())}">
								<aui:option selected="true" label="${degree.getName(locale)}" value="${degree.getDegreeId()}"/>
							</c:when>
							<c:otherwise>
								<aui:option label="${degree.getName(locale)}" value="${degree.getDegreeId()}"/>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</aui:select>
				
				<%-- SocialMedia field. --%>
				<%@ include file="/utils/socialMedia.jspf"%>
				
				<c:set var="cvRequired" value = "true"/>
				<c:if test="${!cvURL.isEmpty()}">
					<c:set var="cvRequired" value = "false"/>
				</c:if>
				<aui:input required="${cvRequired}" type="file" name="curriculum" label="studentjob.studentprofile.form.cv"></aui:input>
				<c:if test="${!cvURL.isEmpty()}">
					<div class="mb-5">
						<a href="${cvURL}"><liferay-ui:message key="download-file" /></a>
					</div>
				</c:if>
				
				<c:choose>
					<c:when test="${canHide}">
						<aui:input name="active" type="checkbox" label="studentjob.studentprofile.form.active" value="${studentProfile.isActive()}"/>
					</c:when>
					<c:otherwise>
						<p>
							<liferay-ui:message key="studentjob.studentprofile.form.cant-unactive" />
						</p>
					</c:otherwise>
				</c:choose>
				
			</aui:fieldset>
		</aui:fieldset-group>

		<%--Buttons. --%>

		<aui:button-row cssClass="mt-5 d-flex justify-content-center">
			<aui:button cssClass="btn btn-primary" type="submit" />
			<aui:button cssClass="ml-3 btn btn-secondary" onClick="${param.redirect}" type="cancel" />
		</aui:button-row>
	</aui:form>
</div>

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/slim-select/1.21.0/slimselect.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/slim-select/1.21.0/slimselect.js"></script>

<script type="text/javascript">
AUI().ready('aui-module', function(A){
	new SlimSelect({
		select: '#<portlet:namespace />degree'
	});
});
</script>

