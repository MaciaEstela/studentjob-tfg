<%@ include file="/init.jsp" %>

<c:if test="<%= themeDisplay.isSignedIn() %>">
	<script type="text/javascript">
		window.location.href = "/"
	</script>
</c:if>

<script src="https://www.google.com/recaptcha/api.js" async defer></script>

<div class="container register-container">
	<liferay-ui:error key="email-not-valid-uoc" message="errors.email-not-valid-uoc"></liferay-ui:error>
	<liferay-ui:success key="student-registered" message="messages.student-registered"/>
	<liferay-ui:success key="company-registered" message="messages.company-registered"/>
	<liferay-ui:error key="register-invalid-inputs" message="errors.register-invalid-inputs"></liferay-ui:error>
	<liferay-ui:error key="register-invalid-nif" message="errors.register-invalid-nif"></liferay-ui:error>
	<liferay-ui:error key="register-invalid-phone" message="errors.register-invalid-phone"></liferay-ui:error>
	<liferay-ui:error key="register-invalid-captcha" message="errors.register-invalid-captcha"></liferay-ui:error>
	
	<ul class="nav nav-register" id="register-tabs" role="tablist">
		<li class="nav-item" role="presentation">
			<button class="nav-link active" id="student-form-tab-tab" data-toggle="tab" data-target="#student-form-tab" type="button" role="tab" aria-controls="student-form-tab" aria-selected="true">
				<liferay-ui:message key="form.register.student" />
			</button>
		</li>
		<li class="nav-item" role="presentation">
			<button class="nav-link" id="company-form-tab-tab" data-toggle="tab" data-target="#company-form-tab" type="button" role="tab" aria-controls="company-form-tab" aria-selected="false">
				<liferay-ui:message key="form.register.company" />
			</button>
		</li>
	</ul>
	
	<div class="tab-content">
		<div class="tab-pane active" id="student-form-tab" role="tabpanel" aria-labelledby="student-form-tab">
			<%@ include file="/form/studentform.jspf" %>
		</div>
		<div class="tab-pane" id="company-form-tab" role="tabpanel" aria-labelledby="company-form-tab">
			<%@ include file="/form/companyform.jspf" %>
		</div>
	</div>
</div>