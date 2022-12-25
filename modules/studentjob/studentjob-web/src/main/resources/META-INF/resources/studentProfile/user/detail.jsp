<%@ include file="/init.jsp" %>

<div class="studentprofile-detail__header">
	<div class="container">
		<div class="row">
				<div class="studentprofile-detail__main-info col-12 pt-5 pb-5">
					<div class="row">
						<div class="studentprofile-detail__image-wrapper col-md-3 col-3">
							<img class="studentprofile-detail__image" alt="Logo" src="${studentProfileDTO.getPortraitUrl()}">
						</div>
						<div class="studentprofile-detail__info-wrapper col-md-6 col-9">
							<h1 class="studentprofile-detail__name">
								${studentProfileDTO.getName()} ${studentProfileDTO.getSurname()}
							</h1>
							<h2 class="studentprofile-detail__title">
								${studentProfileDTO.getTitle()}
							</h2>
							<div class="studentprofile-detail__degrees-wrapper d-flex">
								<c:forEach items="${studentProfileDTO.getDegrees()}" var="degree">
									<div class="studentprofile-detail__degree">
										${degree}
									</div>
								</c:forEach>
							</div>
							<div class="studentprofile-detail__contact-wrapper">
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
						<div class="studentprofile-detail__contact-wrapper col-md-3 col-12">
							<div class="studentprofile-detail__download-cv">
								<a href="${studentProfileDTO.getCvUrl()}" class="btn btn-primary">Descargar CV</a>
							</div>
							<div class="studentprofile-detail__socialmedia">
								
							</div>
						</div>
					</div>
				</div>
				<div class="studentprofile-detail__content row mt-5 mb-4">
					<h2 class="studentprofile-detail__resume col-12">
						<liferay-ui:message key="studentjob.studentprofile.user.description" />
					</h2>
					<div class="studentprofile-detail__description col-12">
						${studentProfileDTO.getDescription()}
					</div>
				</div>
			</div>
		</div>
	</div>
</div>