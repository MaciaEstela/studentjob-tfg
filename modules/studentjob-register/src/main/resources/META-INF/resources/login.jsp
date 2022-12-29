<%@ include file="/init.jsp" %>

<div class="container login-container">
	<liferay-portlet:actionURL var="userLoginURL" name="<%= MVCCommandNames.ACTION_LOGIN %>">
	</liferay-portlet:actionURL>
	
	<aui:form name="studentuserform" method="post" action="${userLoginURL}">
		<aui:input name="email" type="text" label="form.register.email"/>
		<aui:input name="pwd" type="password" label="form.register.password"/>
		
		<div class="row mt-5">
			<div class="col-12 text-center">
				<button class="btn-submit" type="submit" id="<portlet:namespace />loginButton">
					<liferay-ui:message key="form.register.login" />
				</button>
			</div>
		</div>
	</aui:form>
</div>