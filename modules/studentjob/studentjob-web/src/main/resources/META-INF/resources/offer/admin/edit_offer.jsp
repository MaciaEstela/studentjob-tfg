 <%@ include file="/init.jsp"%>

 <%-- Generate add / edit action URL and set title. --%>

 <c:choose>
	<c:when test="${not empty offer}">
		<portlet:actionURL var="offerActionURL" name="<%=MVCCommandNames.EDIT_OFFER_ADMIN %>">
			<portlet:param name="redirect" value="${param.redirect}" />
		</portlet:actionURL>

		<c:set var="editTitle" value="edit-offer"/>
	</c:when>
	<c:otherwise>
		<portlet:actionURL var="offerActionURL" name="<%=MVCCommandNames.ADD_OFFER_ADMIN %>">
			<portlet:param name="redirect" value="${param.redirect}" />
		</portlet:actionURL>

		<c:set var="editTitle" value="add-offer"/>
	</c:otherwise>
 </c:choose>

 <div class="container-fluid-1280 edit-offer">

	<h1><liferay-ui:message key="${editTitle}" /></h1>

	<aui:model-context bean="${offer}" model="${offerClass}" />

	<aui:form action="${offerActionURL}" name="fm">

		<aui:input name="offerId" field="offerId" type="hidden" />

		<aui:fieldset-group markupView="lexicon">

			<aui:fieldset>

				<%-- Title field. --%>

				<aui:input name="title">

				</aui:input>

				<%-- Preference field. --%>
				<aui:select name="preference" label="offer.region">
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

				<%-- Description field. --%>
				<div class="alloy-editor-container">
					<liferay-ui:input-localized
						contents="Descripción"
						label="Descripción"
						xml="${offer.getDescription()}"
						type="editor"
						cssClass="studentjob-ckeditor"
						editorName="ckeditor"
						name="description"
						toolbarSet="studentsimple"
						showSource="false" />
				</div>

				<%-- Region field. --%>
				<aui:select name="region" label="offer.region">
					<c:forEach items="${regions}" var="region">
						<c:choose>
							<c:when test="${region.getRegionId() == offer.getRegionId()}">
								<aui:option selected="true" label="${region.getName()}" value="${region.getRegionCode()}"/>
							</c:when>
							<c:otherwise>
								<aui:option label="${region.getName()}" value="${region.getRegionCode()}"/>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</aui:select>
				
				<%-- Degree field. --%>
				<aui:select name="degree" label="offer.degree" multiple="true">
					<c:forEach items="${degrees}" var="degree">
						<c:choose>
							<c:when test="${currentOfferDegreesIds.contains(degree.getDegreeId())}">
								<aui:option selected="true" label="${degree.getName(locale)}" value="${degree.getDegreeId()}"/>
							</c:when>
							<c:otherwise>
								<aui:option label="${degree.getName(locale)}" value="${degree.getDegreeId()}"/>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</aui:select>
			</aui:fieldset>
		</aui:fieldset-group>

		<%--Buttons. --%>

		<aui:button-row>
			<aui:button cssClass="btn btn-primary" type="submit" />
			<aui:button cssClass="btn btn-secondary" onClick="${param.redirect}" type="cancel" />
		</aui:button-row>
	</aui:form>

 </div>