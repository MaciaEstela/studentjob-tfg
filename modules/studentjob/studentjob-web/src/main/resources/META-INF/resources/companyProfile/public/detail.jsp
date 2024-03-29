<%@ include file="/init.jsp" %>

<div class="companyprofile-detail__header">
	<div class="container">
		<div class="row">
			<div class="companyprofile-detail__image-wrapper col-md-2">
				<img class="companyprofile-detail__image d-none d-md-block" alt="Logo" src="${logo}">
			</div>
			<div class="companyprofile-detail__main-info col-md-10">
				<div class="row">
					<div class="col-md-8 col-12 text-center text-md-left">
						<div class="companyprofile-detail__image-wrapper-responsive">
							<img class="companyprofile-detail__image d-block d-md-none position-static" alt="Logo" src="${logo}">
						</div>
						<h1 class="companyprofile-detail__company-name">
							${companyName}
						</h1>
						<div class="companyprofile-detail__title">
							${companyProfile.getTitle(locale)}
						</div>
					</div>
					<div class="col-12 col-lg-4 my-5 my-lg-0 companyprofile-detail__inscription-wrapper">
						<a href="/offers?keywords=${companyName}" class="companyprofile-detail__inscription-btn">
							<liferay-ui:message key="studentjob.companyprofile.view-offers" />
						</a>
					</div>
				</div>
				<div class="companyprofile-detail__info-items">
					<div class="companyprofile-detail__sector">
						<i class="icon icon-suitcase"></i>
						${companyProfile.getSector(locale)}
					</div>
					<div class="companyprofile-detail__location">
						<i class="icon icon-location-arrow"></i>
						${province}
					</div>
					<div class="companyprofile-detail__website">
						<i class="icon icon-laptop"></i>
						<a href="${companyProfile.getWebsite()}">${companyProfile.getWebsite()}</a>
					</div>
					<div class="companyprofile-detail__email">
						<i class="icon icon-inbox"></i>
						<a href="mailto:${companyProfile.getEmail()}">${companyProfile.getEmail()}</a>
					</div>
				</div>
				<div class="companyprofile-detail__socialmedia-items">
					<c:forEach items="${socialMediasDTO}" var="socialMediaDTO">
						<c:if test="${!socialMediaDTO.getSocialMediaUrl().isEmpty()}">
							<div class="companyprofile-detail__socialmedia-item">
								<a target="_blank" href="${socialMediaDTO.getSocialMediaUrl()}">
									<img alt="${socialMediaDTO.getName()}" src="${socialMediaDTO.getImageUrl()}"/>
								</a>
							</div>
						</c:if>
					</c:forEach>
				</div>
			</div>
		</div>
	</div>
</div>

<div class="col-12 mt-7 mb-5">
	<div class="container companyprofile-detail ">
		<div class="companyprofile-detail__content row">
			<h2 class="companyprofile-detail__resume col-12">
				<liferay-ui:message key="studentjob.companyprofile.resume" />
			</h2>
			<div class="companyprofile-detail__description col-12">
				${companyProfile.getDescription(locale)}
			</div>
		</div>
	</div>
</div>