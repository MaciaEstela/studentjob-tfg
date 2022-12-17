<%@ include file="/init.jsp" %>

<div class="studentprofile-detail__header">
	<div class="container">
		<div class="row">
			<div class="studentprofile-detail__main-info col-12">
				<div class="row">
					<div class="col-md-8 col-12 text-center text-md-left">
						<div class="studentprofile-detail__image-wrapper-responsive">
							<img class="studentprofile-detail__image d-block d-md-none position-static" alt="Logo" src="${logo}">
						</div>
						<h1 class="studentprofile-detail__title">
							${studentName}
						</h1>
						<div class="studentprofile-detail__student-name">
							${studentProfile.getTitle(locale)}
						</div>
						<div class="col-12 col-lg-4 my-5 my-lg-0 studentprofile-detail__inscription-wrapper">
							<a href="${downloadCV}" class="studentprofile-detail__inscription-btn">
								Descarregar CV
							</a>
						</div>
					</div>
				</div>
				<div class="studentprofile-detail__info-items row">
					<div class="studentprofile-detail__location col-12 col-lg-3 my-md-0 my-3">
						<i class="icon icon-location-arrow"></i>
						${province}
					</div>
					<div class="studentprofile-detail__website col-12 col-lg-3 my-md-0 my-3">
						<i class="icon icon-laptop"></i>
						<a href="${studentProfile.getPreference()}">${studentProfile.getPreference()}</a>
					</div>
					<div class="studentprofile-detail__email col-12 col-lg-3 my-md-0 my-3">
						<i class="icon icon-inbox"></i>
						<a href="mailto:${studentProfile.getEmail()}">${studentProfile.getEmail()}</a>
					</div>
					
					<%-- Degree field. --%>
					<c:if test="degrees.size() > 0">
					<div class="studentprofile-detail__degrees">
						<span>Estudios universitarios</span>
						<ul class="studentprofile-detail__degrees-list">
							<c:forEach items="${degrees}" var="degree">
								<li class="studentprofile-detail__degrees-item">
									${degree.getName(locale)}
								</li>
							</c:forEach>
						</ul>
					</div>
					</c:if>
				</div>
				<div class="studentprofile-detail__content row">
					<h2 class="studentprofile-detail__resume col-12">
						<liferay-ui:message key="studentjob.studentprofile.resume" />
					</h2>
					<div class="studentprofile-detail__description col-12">
						${studentProfile.getDescription(locale)}
					</div>
				</div>
			</div>
		</div>
	</div>
</div>