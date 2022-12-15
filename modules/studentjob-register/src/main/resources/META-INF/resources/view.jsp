<%@ include file="/init.jsp" %>

<div class="container register-container">
	<ul class="nav nav-register" id="register-tabs" role="tablist">
		<li class="nav-item" role="presentation">
			<button class="nav-link active" id="student-form-tab-tab" data-toggle="tab" data-target="#student-form-tab" type="button" role="tab" aria-controls="student-form-tab" aria-selected="true">Estudiante</button>
		</li>
		<li class="nav-item" role="presentation">
			<button class="nav-link" id="company-form-tab-tab" data-toggle="tab" data-target="#company-form-tab" type="button" role="tab" aria-controls="company-form-tab" aria-selected="false">Empresa</button>
		</li>
	</ul>
	
	<div class="tab-content">
		<div class="tab-pane active" id="student-form-tab" role="tabpanel" aria-labelledby="student-form-tab">
			<%@ include file="/form/studentform.jspf" %>
		</div>
		<div class="tab-pane" id="company-form-tab" role="tabpanel" aria-labelledby="company-form-tab">
			<%@ include file="/form/companyform.jspf" %>
		</div>
	</div>
</div>