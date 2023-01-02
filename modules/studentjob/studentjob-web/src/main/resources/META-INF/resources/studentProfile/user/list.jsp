<%@ include file="/init.jsp" %>

<portlet:resourceURL id="<%= MVCCommandNames.STUDENTPROFILE_PUBLIC_RESOURCE_COMMAND %>" var="updateStudentsURL" >
	<liferay-portlet:param name="cmd" value="<%= MVCCommandNames.STUDENTPROFILE_PUBLIC_RESOURCE_COMMAND_GET_STUDENTS %>" />
</portlet:resourceURL>

<portlet:resourceURL id="<%= MVCCommandNames.STUDENTPROFILE_PUBLIC_RESOURCE_COMMAND %>" var="getStudentsAuxDataURL" >
	<liferay-portlet:param name="cmd" value="<%= MVCCommandNames.STUDENTPROFILE_PUBLIC_RESOURCE_COMMAND_AUX_DATA %>" />
</portlet:resourceURL>

<div class="students-container-wrapper">
	<div class="students-container-header-wrapper container mb-7">
		<h1 class="students-list-title"><liferay-ui:message key="studentjob.students.title" /></h1>
	
		<div class="students-search students-search-container row mt-5">
			<i class="icon icon-search"></i>
			<aui:input name="keywords" wrapperCssClass="col-12 col-md-3" type="text" label="studentjob.keywords"/>
			
			<%-- Degree field. --%>
			<aui:select name="degree" wrapperCssClass="col-12 col-md-3"  label="studentjob.degree">
				<aui:option label="studentjob.all-degrees" value=""/>
				<c:forEach items="${degrees}" var="degree">
					<aui:option label="${degree.getName(locale)}" value="${degree.getDegreeId()}"/>
				</c:forEach>
			</aui:select>
			
			<%-- Region field. --%>
			<aui:select name="region" wrapperCssClass="col-12 col-md-3"  label="studentjob.region">
				<aui:option label="studentjob.entire-spain" value=""/>
				<c:forEach items="${regions}" var="region">
					<aui:option label="${region.getName()}" value="${region.getRegionCode()}"/>
				</c:forEach>
			</aui:select>
			
			
			<%-- Preference field. --%>
			<aui:select name="preference" wrapperCssClass="col-12 col-md-3"  label="studentjob.preference">
				<aui:option label="studentjob.indifferent" value=""/>
				<c:forEach items="${preferences}" var="preference">
					<aui:option label="studentjob.preference.${preference}" value="${preference}"/>
				</c:forEach>
			</aui:select>
			
			<div class="students-count-wrapper col-12">
				<span><span id="<portlet:namespace />students-count">${studentProfileCount}</span> <liferay-ui:message key="studentjob.students.total" /></span>
			</div>
		</div>
	</div>
</div>
	
<div class="container">
	<div style="display: none;" id="<portlet:namespace />spinnerloading" class="spinner loading"></div>
	
	<div class="students-cards mb-4" id="<portlet:namespace />students-list">
		<c:forEach items="${studentProfilesDTO}" var="student">
			<%@ include file="/studentProfile/user/card.jspf" %>
		</c:forEach>
	</div>
	<div id="<portlet:namespace />no-results" class="students__no-results-wrapper w-100 text-center" style="display: none;">
		<h2 class="students-list text-danger">
			<liferay-ui:message key="studentjob.students.no-result" />
		</h1>
		<img src="/o/studentjob-theme/images/no-results.png" class="students__no-results-img floating-large mt-5"/>
	</div>
	<div id="<portlet:namespace />students-cards-bottom"></div>
</div>


<script type="text/javascript">
	AUI().ready('aui-module', function(A){		
		let offset = <%=StudentjobConstants.STUDENTS_OFFSET%>;
		let start = <%=StudentjobConstants.STUDENTS_OFFSET%>;
		
		let studentCount = ${studentProfileCount}
		
		let keywordsInput = document.getElementById('<portlet:namespace />keywords')
		let regionInput = document.getElementById('<portlet:namespace />region')
		let degreeInput = document.getElementById('<portlet:namespace />degree')
		let preferenceInput = document.getElementById('<portlet:namespace />preference')
		let spinnerElement = document.getElementById('<portlet:namespace />spinnerloading')
		let studentsList = document.getElementById('<portlet:namespace />students-list');
		let studentCountElement = document.getElementById('<portlet:namespace />students-count');
		let footerElement = document.getElementById('footer');
		let noResultsElement = document.getElementById('<portlet:namespace />no-results');
		
		let scrollListening = true;
		
		let newestStudentProfileId = ${newestStudentProfileId}
		
		let keywords = keywordsInput.value
		let region = regionInput.value
		let degree = degreeInput.value
		let preference = preferenceInput.value
		
		var keywordsChange = function (event) {
			if (!event.key || event.key === "Enter" ) {
				if (event.target.value != keywords){
					keywords = event.target.value;
					resetStudents()
				}
			}
		};
		
		var regionChange = function (event) {
			if (event.target.value != region){
				region = event.target.value;
				resetStudents()
			}
		};
		
		var degreeChange = function (event) {
			if (event.target.value != degree){
				degree = event.target.value;
				resetStudents()
			}
		};
		
		var preferenceChange = function (event) {
			if (event.target.value != preference){
				preference = event.target.value;
				resetStudents()
			}
		};
		
		keywordsInput.addEventListener('keyup', keywordsChange);
		keywordsInput.addEventListener('focusout', keywordsChange);
		regionInput.addEventListener('change', regionChange);
		degreeInput.addEventListener('change', degreeChange);
		preferenceInput.addEventListener('change', preferenceChange);
		
		
		function resetStudents(){
			start = 0;
			scrollListening = true;
			spinnerElement.style.display = "block";
			studentsList.innerHTML = "";
			reloadStudentsResource();
			newestStudentProfileId = 0;
		}
		
		function reloadStudentsResource(){
			scrollListening = false;
			AUI().use('aui-io-request', function(A){
				A.io.request('${updateStudentsURL}', {
					method: 'post',
					data: {
						<portlet:namespace />keywords: keywordsInput.value,
						<portlet:namespace />degree: degreeInput.value,
						<portlet:namespace />preference: preferenceInput.value,
						<portlet:namespace />region: regionInput.value,
						<portlet:namespace />offset: offset,
						<portlet:namespace />start: start,
						<portlet:namespace />newestStudentProfileId: 22,
					},
					on: {
						success: function() {
							if (this.get('responseData') && this.get('responseData') !== ""){
								studentsList.insertAdjacentHTML('beforeend', this.get('responseData'));
								updateStudentsAuxData();
								scrollListening = true;
							}
							checkStudentsList();
							spinnerElement.style.display = "none";
						}
					}
				});
			});
		}
		
		function updateStudentsAuxData(){
			scrollListening = false;
			AUI().use('aui-io-request', function(A){
				A.io.request('${getStudentsAuxDataURL}', {
					method: 'post',
					data: {
						<portlet:namespace />keywords: keywordsInput.value,
						<portlet:namespace />degree: degreeInput.value,
						<portlet:namespace />preference: preferenceInput.value,
						<portlet:namespace />region: regionInput.value,
					},
					on: {
						success: function() {
							if (this.get('responseData') && this.get('responseData') !== ""){
								var data = JSON.parse(this.get('responseData'));
								newestStudentProfileId = data.newestStudentProfileId;
								studentCount = data.studentProfileCount;
								start = start + offset;
								studentCountElement.textContent = studentCount;
								
								scrollListening = true;
							}
						}
					}
				});
			});
		}
		
		var scrollListener = function (event) {
			
			var scrollHeight = document.documentElement.scrollHeight;
			var scrollTop = document.documentElement.scrollTop;
			var clientHeight = document.documentElement.clientHeight;
			let footerHeight = footerElement.offsetHeight;
			
			if((scrollTop + clientHeight) > (scrollHeight - footerHeight - 100) && scrollListening){
				reloadStudentsResource();
			}
		};
		
		function checkStudentsList(){
			if (document.querySelectorAll('.students-cards__item').length == 0){
				noResultsElement.style.display = "block";
				studentCount = 0;
				studentCountElement.textContent = studentCount;
			} else {
				noResultsElement.style.display = "none";
			}
		}
		
		checkStudentsList();
		window.addEventListener("scroll", scrollListener);
	});
</script>