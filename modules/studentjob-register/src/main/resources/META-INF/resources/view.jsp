<%@ include file="/init.jsp" %>

<liferay-portlet:actionURL var="addStudentUserURL" name="<%= MVCCommandNames.ACTION_REGISTER %>">
	<liferay-portlet:param name="registerType" value="<%=StudentjobConstants.USER_STUDENT%>"/>
</liferay-portlet:actionURL>

<liferay-portlet:actionURL var="addCompanyUserURL" name="<%=MVCCommandNames.ACTION_REGISTER%>">
	<liferay-portlet:param name="registerType" value="<%=StudentjobConstants.USER_COMPANY%>"/>
</liferay-portlet:actionURL>

<h1>Company</h1>
<aui:form name="companyuserform" method="post" action="${addCompanyUserURL}">
	<aui:input name="selectedService" type="hidden" value="${selectedService}" />
	
	<aui:input name="companyNif" type="text" />
	<aui:input name="companyName" type="text" />
	<aui:input name="companySurname" type="text" />
	<aui:input name="companyCompany" type="text" />
	<aui:input name="companyPhone" type="text" />
	<aui:input name="companyEmail" type="text" />
	<aui:input name="companyPassword" type="password" />
	<aui:input name="companyRepeatPassword" type="password" />
	<aui:input name="companyOfferAlerts" type="checkbox" />
	
	
	<div class="row">
		<div class="d-flex col-sm-6 col-md-4 col-lg-3 mx-auto">
			<button class="u-btn u-btn-login-primary" type="submit" id="<portlet:namespace />submitButton">
				Register
			</button>
		</div>
	</div>
</aui:form>

<h1>Student</h1>
<aui:form name="studentuserform" method="post" action="${addStudentUserURL}">
	<aui:input name="studentName" type="text" />
	<aui:input name="studentSurname" type="text" />
	<aui:input name="studentEmail" type="text" value="@uoc.edu"/>
	<aui:input name="studentPassword" type="password" />
	<aui:input name="studentRepeatPassword" type="password"/>
	<aui:input name="studentOfferAlerts" type="checkbox" />
	
	<div class="row">
		<div class="d-flex col-sm-6 col-md-4 col-lg-3 mx-auto">
			<button class="u-btn u-btn-login-primary" type="submit" id="<portlet:namespace />submitButton">
				Register
			</button>
		</div>
	</div>
</aui:form>
