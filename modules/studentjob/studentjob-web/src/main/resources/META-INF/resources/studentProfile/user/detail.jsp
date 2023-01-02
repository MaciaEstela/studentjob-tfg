<%@ include file="/init.jsp" %>

<div class="studentprofile-detail__header">
	<div class="container">
		<div class="row">
				<div class="studentprofile-detail__main-info col-12 pt-5 pb-5">
					<div class="row">
						<div class="studentprofile-detail__image-wrapper col-md-3 col-12">
							<img class="studentprofile-detail__image" alt="Logo" src="${studentProfileDTO.getPortraitUrl()}">
						</div>
						<div class="studentprofile-detail__info-wrapper col-md-6 col-12">
							<h1 class="studentprofile-detail__name mb-3 mt-3">
								${studentProfileDTO.getName()} ${studentProfileDTO.getSurname()}
							</h1>
							<h2 class="studentprofile-detail__title mb-3">
								${studentProfileDTO.getTitle()}
							</h2>
							<div class="studentprofile-detail__degrees-wrapper d-flex mb-3">
								<c:forEach items="${studentProfileDTO.getDegrees()}" var="degree">
									<div class="studentprofile-detail__degree">
										${degree}
									</div>
								</c:forEach>
							</div>
							<div class="studentprofile-detail__contact-info-wrapper d-md-flex">
								<div class="studentprofile-detail__preference">
									<i class="icon icon-laptop"></i>
									${studentProfileDTO.getJobPreference()}
								</div>
								<div class="studentprofile-detail__province">
									<i class="icon icon-location-arrow"></i>
									${studentProfileDTO.getProvince()}
								</div>
								<div class="studentprofile-detail__email">
									<i class="icon icon-inbox"></i>
									<a href="mailto:${studentProfileDTO.getEmail()}">${studentProfileDTO.getEmail()}</a>
								</div>
							</div>
						</div>
						<div class="studentprofile-detail__contact-wrapper col-md-3 col-12 mt-4">
							<div class="studentprofile-detail__download-cv mb-4">
								<a href="${studentProfileDTO.getCvUrl()}" class="btn btn-dark">
									<liferay-ui:message key="studentjob.studentprofile.user.download-cv" />
								</a>
							</div>
							<div class="studentprofile-detail__socialmedia-wrapper">
								<c:forEach items="${socialMediasDTO}" var="socialMediaDTO">
									<c:if test="${!socialMediaDTO.getSocialMediaUrl().isEmpty()}">
										<div class="studentprofile-detail__socialmedia-item">
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
				<div class="studentprofile-detail__content col-12 mt-5 mb-4">
					<h2 class="studentprofile-detail__resume">
						<liferay-ui:message key="studentjob.studentprofile.user.description" />
					</h2>
					<div class="studentprofile-detail__description">
						${studentProfileDTO.getDescription()}
					</div>
				</div>
			</div>
		</div>
	</div>
</div>