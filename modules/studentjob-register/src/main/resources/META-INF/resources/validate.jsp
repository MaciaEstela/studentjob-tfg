<%@ include file="/init.jsp" %>

<portlet:resourceURL id="<%= MVCCommandNames.VALIDATE_RESOURCE_COMMAND %>" var="getValidateUserURL" />

<%
	boolean validated = (Boolean) GetterUtil.getObject(renderRequest.getAttribute("validated"));
%>

<c:choose>
	<c:when test="${(validated == false)}">
		<p>No se ha podido validar su cuenta</p>
	</c:when>
	<c:otherwise>
		<p>Se ha validado su cuenta</p>
	</c:otherwise>
</c:choose>