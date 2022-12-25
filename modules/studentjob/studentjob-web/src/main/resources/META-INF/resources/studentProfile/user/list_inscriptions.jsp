<%@ include file="/init.jsp" %>

<div class="container">
	<div class="students-cards" id="<portlet:namespace />students-list">
		<c:forEach items="${studentProfilesDTO}" var="student">
			<%@ include file="/studentProfile/user/card.jspf" %>
		</c:forEach>
	</div>
</div>