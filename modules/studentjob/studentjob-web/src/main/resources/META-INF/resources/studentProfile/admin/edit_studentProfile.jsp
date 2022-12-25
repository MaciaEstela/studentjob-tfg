 <%@ include file="/init.jsp"%>

 <%-- Generate add / edit action URL and set name. --%>

<portlet:actionURL var="studentProfileActionURL" name="<%=MVCCommandNames.EDIT_STUDENTPROFILE_ADMIN_ACTION %>">
	<portlet:param name="redirect" value="${param.redirect}" />
</portlet:actionURL>

<c:set var="editTitle" value="studentjob.studentprofile.admin.edit"/>

<div class="container-fluid-1280 edit-studentProfile">

	<h1><liferay-ui:message key="${editTitle}" /></h1>

	<aui:model-context bean="${studentProfile}" model="${studentProfileClass}" />

	<aui:form action="${studentProfileActionURL}" name="fm">

		<aui:input name="studentProfileId" field="studentProfileId" type="hidden" />

		<aui:fieldset-group markupView="lexicon">

			<aui:fieldset>
				<aui:input label="studentjob.studentprofile.form.title" name="title">
				</aui:input>
				
				<label class="control-label">
					<liferay-ui:message key="studentjob.studentprofile.form.description" />
				</label>
				<div class="alloy-editor-container">
					<liferay-ui:input-localized
						xml="${studentProfile.getDescription()}"
						type="editor"
						cssClass="studentjob-ckeditor"
						editorName="ckeditor"
						name="description"
						toolbarSet="studentsimple"
						showSource="false" />
				</div>
				
				<aui:input label="studentjob.studentprofile.form.email" name="email">
				</aui:input>
				
				<%-- Preference field. --%>
				<aui:select name="preference" label="studentjob.studentprofile.form.preference">
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
				<aui:select name="region" label="studentjob.studentprofile.form.region">
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
				<aui:select name="degree" label="studentjob.studentprofile.form.degree" multiple="true">
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

				<aui:input type="file" name="curriculum" label="studentjob.studentprofile.form.cv"></aui:input>
				<aui:input name="active" type="checkbox" label="studentjob.studentprofile.form.active" value="${studentProfile.isActive()}"/>
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
