<%@ include file="/init.jsp" %>

<link rel="stylesheet" href="/o/studentjob-theme/css/dataTables.bootstrap4.min.css">
<link rel="stylesheet" href="/o/studentjob-theme/css/bootstrap.css">
<script src="/o/studentjob-theme/js/jquery.dataTables.min.js"></script>
<script src="/o/studentjob-theme/js/dataTables.bootstrap4.min.js"></script>

<div class="container overflow-auto">
	<h1 class="mt-4 mb-4">
		<liferay-ui:message key="studentjob.studentprofile.table.title" arguments="${offerTitle}"/>
	</h1>
	
	<table id="inscriptions" class="table table-striped table-bordered">
		<thead>
			<tr role="row">
				<th><liferay-ui:message key="studentjob.studentprofile.table.name" /></th>
				<th><liferay-ui:message key="studentjob.studentprofile.table.degrees" /></th>
				<th><liferay-ui:message key="studentjob.studentprofile.table.province" /></th>
				<th><liferay-ui:message key="studentjob.studentprofile.table.jobpreference" /></th>
				<th><liferay-ui:message key="studentjob.studentprofile.table.cv" /></th>
				<th><liferay-ui:message key="studentjob.studentprofile.table.email" /></th>
				<th><liferay-ui:message key="studentjob.studentprofile.table.profile" /></th>
			</tr>
		</thead>
		<tbody>
			<c:set var="rowOddEven" value = "odd"/>
			<c:forEach items="${studentProfilesDTO}" var="student" varStatus="loop">
				<c:choose>
					<c:when test = "${loop.index % 2 == 0}">
						<c:set var="rowOddEven" value = "odd"/>
					</c:when>
					<c:otherwise>
						<c:set var="rowOddEven" value = "even"/>
					</c:otherwise>
				</c:choose>
				<tr class="${rowOddEven}">
					<td>${student.getName()} ${student.getSurname()}</td>
					<td>
						<c:forEach items="${student.getDegrees()}" var="degree">
							<p>${degree}</p>
						</c:forEach>
					</td>
					<td>${student.getProvince()}</td>
					<td>${student.getJobPreference()}</td>
					<td><a href="${student.getCvUrl()}"><liferay-ui:message key="studentjob.studentprofile.download-cv" /></a></td>
					<td><a href="mailto:${student.getEmail()}">${student.getEmail()}</a></td>
					<td><a href="/students-list/-/view-student/${student.getStudentProfileId()}"><liferay-ui:message key="studentjob.view-profile" /></a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
</div>

<script type="text/javascript">
AUI().ready('aui-module', function(A){
	<% if (themeDisplay.getLocale().toString().equals("es_ES")) { %>
		$('#inscriptions').DataTable({
			language: {
				"decimal": "",
				"emptyTable": "No hay información",
				"info": "Mostrando _START_ a _END_ de _TOTAL_ Entradas",
				"infoEmpty": "Mostrando 0 to 0 of 0 Entradas",
				"infoFiltered": "(Filtrado de _MAX_ total entradas)",
				"infoPostFix": "",
				"thousands": ",",
				"lengthMenu": "Mostrar _MENU_ Entradas",
				"loadingRecords": "Cargando...",
				"processing": "Procesando...",
				"search": "Buscar:",
				"zeroRecords": "Sin resultados encontrados",
				"paginate": {
					"first": "Primero",
					"last": "Ultimo",
					"next": "Siguiente",
					"previous": "Anterior"
				}
			}
		});
	<% } else if (themeDisplay.getLocale().toString().equals("ca_ES")) { %>
		$('#inscriptions').DataTable({
			language: {
				"decimal": "",
				"emptyTable": "No hi ha informació",
				"info": "Mostrant _START_ a _END_ de _TOTAL_ Entrades",
				"infoEmpty": "Mostrant 0 a 0 ode 0 Entrades",
				"infoFiltered": "(Filtrant de _MAX_ total entrades)",
				"infoPostFix": "",
				"thousands": ",",
				"lengthMenu": "Mostrar _MENU_ Entrades",
				"loadingRecords": "Cargant...",
				"processing": "Procesant...",
				"search": "Buscar:",
				"zeroRecords": "No s'han trobat resultats",
				"paginate": {
					"first": "Primer",
					"last": "Últim",
					"next": "Següent",
					"previous": "Anterior"
				}
			}
		});
	<% } else { %>
		$('#inscriptions').DataTable();
	<% } %>
});
</script>