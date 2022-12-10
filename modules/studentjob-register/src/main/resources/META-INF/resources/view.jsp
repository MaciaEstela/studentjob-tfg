<%@ include file="/init.jsp" %>

<liferay-portlet:actionURL var="addStudentUserURL" name="<%= MVCCommandNames.ACTION_REGISTER %>">
	<liferay-portlet:param name="registerType" value="<%=StudentjobRegisterConstants.USER_STUDENT%>"/>
</liferay-portlet:actionURL>

<liferay-portlet:actionURL var="addCompanyUserURL" name="<%=MVCCommandNames.ACTION_REGISTER%>">
	<liferay-portlet:param name="registerType" value="<%=StudentjobRegisterConstants.USER_COMPANY%>"/>
</liferay-portlet:actionURL>

<div class="container register-container">
	<ul class="nav nav-register" id="register-tabs" role="tablist">
		<li class="nav-item" role="presentation">
			<button class="nav-link active" id="student-form-tab-tab" data-toggle="tab" data-target="#student-form-tab" type="button" role="tab" aria-controls="student-form-tab" aria-selected="true">Estudiante</button>
		</li>
		<li class="nav-item" role="presentation">
			<button class="nav-link" id="company-form-tab-tab" data-toggle="tab" data-target="#company-form-tab" type="button" role="tab" aria-controls="company-form-tab" aria-selected="false">Empresa</button>
		</li>
	</ul>
	
	<div class="tab-content">
		<div class="tab-pane active" id="student-form-tab" role="tabpanel" aria-labelledby="home-tab">
			<aui:form name="studentuserform" method="post" action="${addStudentUserURL}">
				<aui:input name="studentName" type="text" label="form.register.name"/>
				<aui:input name="studentSurname" type="text" label="form.register.surname"/>
				<aui:input name="studentEmail" type="text" value="@uoc.edu" label="form.register.email"/>
				<aui:input name="studentPassword" type="password" label="form.register.password"/>
				<aui:input name="studentRepeatPassword" type="password" label="form.register.repeat-password"/>
				<aui:input name="studentOfferAlerts" type="checkbox" wrapperCssClass="control-label" label="form.register.student.alert"/>
				
				<div class="row mt-5">
					<div class="col-12 text-center">
						<button class="btn-submit" type="submit" id="<portlet:namespace />submitButtonStudent">
							<liferay-ui:message key="form.register.signup" />
						</button>
					</div>
				</div>
			</aui:form>
		</div>
		<div class="tab-pane" id="company-form-tab" role="tabpanel" aria-labelledby="profile-tab">
			<aui:form name="companyuserform" method="post" action="${addCompanyUserURL}">
				<aui:input name="selectedService" type="hidden" value="${selectedService}" />
				
				<aui:input name="companyNif" type="text" label="form.register.company.nif"/>
				<aui:input name="companyName" type="text" label="form.register.name"/>
				<aui:input name="companySurname" type="text" label="form.register.surname"/>
				<aui:input name="companyCompany" type="text" label="form.register.company.company"/>
				<aui:input name="companyPhone" type="text" label="form.register.phone"/>
				<aui:input name="companyEmail" type="text" label="form.register.email"/>
				<aui:input name="companyPassword" type="password" label="form.register.password"/>
				<aui:input name="companyRepeatPassword" type="password" label="form.register.repeat-password"/>
				<aui:input name="companyOfferAlerts" type="checkbox" wrapperCssClass="control-label" label="form.register.company.alert"/>
				
				<div class="row mt-5">
					<div class="col-12 text-center">
						<button class="btn-submit" type="submit" id="<portlet:namespace />submitButtonCompany">
							<liferay-ui:message key="form.register.signup" />
						</button>
					</div>
				</div>
			</aui:form>
		</div>
	</div>
</div>