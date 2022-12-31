<%@ include file="/init.jsp" %>

<portlet:resourceURL id="<%= MVCCommandNames.VALIDATE_RESOURCE_COMMAND %>" var="getValidateUserURL" />

<%
	boolean validated = (Boolean) GetterUtil.getObject(renderRequest.getAttribute("validated"));
%>
<div class="validate-container">
	<c:choose>
		<c:when test="${(validated == false)}">
			<div class="validate-container__header-wrapper--fail">
				<div class="container">
					<h1 class="validate__header--fail text-center text-danger font-weight-bold"><liferay-ui:message key="validate.error.header" /></h1>
				</div>
			</div>
			<div class="container validate__text--fail mt-5 mb-7">
				<p><liferay-ui:message key="validate.error.text1" /></p>
				<p><liferay-ui:message key="validate.error.text2" /> <a href="contact@mestemiuoc.com">contact@mestemiuoc.com</a></p>
			</div>
		</c:when>
		<c:when test="${(validated == true && manualApprovement == false)}">
			<div class="validate-container__header-wrapper--ok">
				<div class="container">
					<h1 class="validate__header--ok text-center text-success font-weight-bold"><liferay-ui:message key="validate.ok.header" /></h1>
				</div>
			</div>
			<div class="container validate__text--ok mt-5 mb-7">
				<p><liferay-ui:message key="validate.ok.text1" /></p>
				<p><liferay-ui:message key="validate.ok.text2" /> <a href="contact@mestemiuoc.com">contact@mestemiuoc.com</a></p>
			</div>
		</c:when>
		<c:otherwise>
			<div class="validate-container__header-wrapper--ok">
				<div class="container">
					<h1 class="validate__header--ok text-center text-success font-weight-bold"><liferay-ui:message key="validate.ok.header-company" /></h1>
				</div>
			</div>
			<div class="container  validate__text--ok mt-5 mb-7">
				<p><liferay-ui:message key="validate.ok.text1-company" /></p>
				<p><liferay-ui:message key="validate.ok.text2" /> <a href="contact@mestemiuoc.com">contact@mestemiuoc.com</a></p>
			</div>
		</c:otherwise>
	</c:choose>
</div>