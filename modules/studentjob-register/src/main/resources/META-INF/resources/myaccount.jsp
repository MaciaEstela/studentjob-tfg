 <%@ include file="/init.jsp"%>

 <%-- Generate add / edit action URL and set name. --%>

<portlet:actionURL var="editMyAccountActionURL" name="<%=MVCCommandNames.EDIT_MY_ACCOUNT_ACTION %>">
	<portlet:param name="redirect" value="${param.redirect}" />
</portlet:actionURL>

<c:set var="editMyAccount" value="form.myaccount.title"/>

<div class="container-fluid-1280 edit-myaccount">

	<h1><liferay-ui:message key="${editMyAccount}" /></h1>

	<aui:form action="${editMyAccountActionURL}" name="fm">

		<aui:fieldset-group markupView="lexicon">

			<aui:fieldset>
				<div class="row">
					<aui:input name="userId" value="${user.getUserId()}" type="hidden" />
					<aui:input wrapperCssClass="col-md-6 col-12" name="userId2" label="userId" value="${user.getUserId()}" disabled="true" />
					<aui:input wrapperCssClass="col-md-6 col-12" name="screenName" value="${user.getScreenName()}" disabled="true" />
					<c:if test = "${!isStudent}">
						<aui:input wrapperCssClass="col-md-6 col-12" label="form.register.company.company" name="company" value="${user.getExpandoBridge().getAttribute(companyExpando)}" disabled="true" />
						<aui:input wrapperCssClass="col-md-6 col-12" label="form.register.company.nif" name="nif" value="${user.getExpandoBridge().getAttribute(nifExpando)}" disabled="true"/>
					</c:if>
					<aui:input wrapperCssClass="col-md-6 col-12" name="email" value="${user.getEmailAddress()}" />
					<c:if test = "${!isStudent}">
						<aui:input wrapperCssClass="col-md-6 col-12" name="phone" value="${user.getExpandoBridge().getAttribute(phoneExpando)}" />
					</c:if>
					<aui:input wrapperCssClass="col-md-6 col-12" name="name" value="${user.getFirstName()}" />
					<aui:input wrapperCssClass="col-md-6 col-12" name="lastName" value="${user.getLastName()}" />
					
					<div class="col-md-6 col-12 d-flex align-items-center">
						<aui:input label="form.myaccount.profilephoto" wrapperCssClass="w-100 mr-3" type="file" accept="image/*"  name="image" ></aui:input>
						<img width="100px" height="100px" src="${user.getPortraitURL(themeDisplay) }">
					</div>
					
					<c:choose>
						<c:when test="${!isStudent}">
							<aui:input type="checkbox" label="form.register.company.alert" wrapperCssClass="col-12" name="mailOffers" value="${user.getExpandoBridge().getAttribute(mailOffersExpando)}" />	
						</c:when>
						<c:otherwise>
							<aui:input type="checkbox" label="form.register.student.alert" wrapperCssClass="col-12" name="mailOffers" value="${user.getExpandoBridge().getAttribute(mailOffersExpando)}" />
						</c:otherwise>
					</c:choose>
					
				</div>
				
			</aui:fieldset>
		</aui:fieldset-group>

		<%--Buttons. --%>

		<aui:button-row cssClass="mt-5 d-flex justify-content-center">
			<aui:button cssClass="btn btn-primary" type="submit" />
			<aui:button cssClass="ml-3 btn btn-secondary" onClick="${param.redirect}" type="cancel" />
		</aui:button-row>
	</aui:form>
</div>