<div class="students-cards__item">
	<a class="students-cards__link-wrapper" href="${student.getViewURL()}">
		<div class="students-cards__top">	
			<div class="students-cards__image-wrapper">
				<img alt="${student.getName()} Logo" class="students-cards__image" src="${student.getPortraitUrl()}">
			</div>
			<div class="students-cards__name-wrapper">
				<h2 class="students-cards__name">
					${student.getName()} ${student.getSurname()}
				</h2>
			</div>
		</div>
		<div class="students-cards__subtop">
			<div class="students-cards__title">
				${student.getTitle()}
			</div>
		</div>
		<div class="students-cards__degrees-wrapper">
			<#list student.getDegrees() as degree>
				${degree}
			</#list>
		</div>
		<div class="students-cards__bottom-wrapper">
			<div class="students-cards__top-info-wrapper">
				<span>${student.getJobPreference()}</span> <span>${student.getProvince()}</span>
			</div>
		</div>
	</a>
	
	<div class="students-cards__download-cv-wrapper">
		<a href="${student.getCvUrl()}" class="students-cards__download-cv">
			${downloadCV}
		</a>
	</div>
</div>