<%@ include file="/init.jsp" %>

<div class="companyProfile-container-wrapper">
	<div class="companyProfile-container-header-wrapper container mb-7 mt-5">
		<h1 class="companyProfile-list-title"><liferay-ui:message key="studentjob.companyProfile.title" /></h1>		
		
		<div class="row companyprofile-cards">
			<c:forEach items="${companyProfilesDTO}" var="companyProfile">
				<%@ include file="/companyProfile/public/card.jspf" %>
			</c:forEach>
		</div>
</div>