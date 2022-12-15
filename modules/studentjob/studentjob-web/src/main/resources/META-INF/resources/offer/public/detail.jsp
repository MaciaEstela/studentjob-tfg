<%@ include file="/init.jsp" %>

 <portlet:renderURL var="viewCompanyProfileURL">
	<portlet:param name="mvcRenderCommandName" value="<%=MVCCommandNames.VIEW_COMPANYPROFILE_PUBLIC %>" />
	<portlet:param name="redirect" value="${currentURL}" />
	<portlet:param name="userId" value="${offer.getUserId()}" />
 </portlet:renderURL>

<portlet:resourceURL id="<%= MVCCommandNames.OFFER_PUBLIC_RESOURCE_COMMAND %>" var="enrollUserURL" >
	<liferay-portlet:param name="cmd" value="<%= MVCCommandNames.OFFER_PUBLIC_RESOURCE_COMMAND_ENROLL %>" />
	<liferay-portlet:param name="offerId" value="${offer.getOfferId()}" />
</portlet:resourceURL>

<div class="col-12 mt-7 mb-5">
	<div class="container offer-detail ">
		<div class="offer-detail__header row">
			<div class="offer-detail__image-wrapper col-12 col-md-1">
				<a href="${viewCompanyProfileURL}">
					<img class="offer-detail__image" alt="Logo" src="${offerDTO.getLogoURL()}">
				</a>
			</div>
			<div class="offer-detail__main-info col-md-6">
				<h1 class="offer-detail__title">
					${offer.getTitle(locale)}
				</h1>
			</div>
			<div class="offer-detail__inscription-wrapper col-12 col-md-5">
				<a href="${enrollUserURL}" class="offer-detail__inscription-btn">
					<liferay-ui:message key="studentjob.offers.enrollment" />
				</a>
			</div>
			<div class="col-12 col-l-5 offer-detail__extra">
				<div class="offer-detail__company-name">
					${offerDTO.getCompany()}
				</div>
				<div class="offer-detail__preference">
					<liferay-ui:message key="studentjob.offers.preference.${offer.getPreference()}" />
				</div>
				<div class="offer-detail__location">
					${province}
				</div>
			</div>
		</div>
		<div class="offer-detail__content row">
			<h2 class="offer-detail__resume col-12">
				<liferay-ui:message key="studentjob.offers.resume" />
			</h2>
			<div class="offer-detail__desired-degrees-wrapper col-12">
				<div class="offer-detail__desired-degree-title">
					<liferay-ui:message key="studentjob.offers.desired-degrees" />
				</div>
				<ul class="offer-detail__desired-degree-list">
					<c:forEach items="${currentOfferDegrees}" var="degree">
						<li class="offer-detail__desired-degree-item">
							<i class="icon icon-ok"></i>
							${degree.getName(locale)}
						</li>
					</c:forEach>
				</ul>
			</div>
			<div class="offer-detail__description col-12">
				${offer.getDescription(locale)}
			</div>
			<div class="offer-detail__time text-right p-4 font-weight-bold col-12">
				${offerDTO.getCreateString()}
			</div>
		</div>
	</div>
</div>