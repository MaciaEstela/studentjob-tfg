<%@ include file="/init.jsp" %>

<portlet:resourceURL id="<%= MVCCommandNames.OFFER_PUBLIC_RESOURCE_COMMAND %>" var="updateOffersURL" >
	<liferay-portlet:param name="cmd" value="<%= MVCCommandNames.OFFER_PUBLIC_RESOURCE_COMMAND_GET_OFFERS %>" />
</portlet:resourceURL>

<portlet:resourceURL id="<%= MVCCommandNames.OFFER_PUBLIC_RESOURCE_COMMAND %>" var="getOffersAuxDataURL" >
	<liferay-portlet:param name="cmd" value="<%= MVCCommandNames.OFFER_PUBLIC_RESOURCE_COMMAND_AUX_DATA %>" />
</portlet:resourceURL>

<div class="offers-container-wrapper">
	<div class="offers-container-header-wrapper container mb-7">
		<h1 class="offers-list-title"><liferay-ui:message key="studentjob.offers.title" /></h1>
	
		<div class="offer-search offers-search-container row mt-5">
			<i class="icon icon-search"></i>
			<aui:input name="keywords" wrapperCssClass="col-12 col-md-3" type="text" label="studentjob.keywords"/>
			
			<%-- Region field. --%>
			<aui:select name="region" wrapperCssClass="col-12 col-md-3"  label="studentjob.region">
				<aui:option label="studentjob.entire-spain" value=""/>
				<c:forEach items="${regions}" var="region">
					<aui:option label="${region.getName()}" value="${region.getRegionCode()}"/>
				</c:forEach>
			</aui:select>
			
				
			<%-- Degree field. --%>
			<aui:select name="degree" wrapperCssClass="col-12 col-md-3"  label="studentjob.degree">
				<aui:option label="studentjob.all-degrees" value=""/>
				<c:forEach items="${degrees}" var="degree">
					<aui:option label="${degree.getName(locale)}" value="${degree.getDegreeId()}"/>
				</c:forEach>
			</aui:select>
			
			<%-- Preference field. --%>
			<aui:select name="preference" wrapperCssClass="col-12 col-md-3"  label="studentjob.preference">
				<aui:option label="studentjob.indifferent" value=""/>
				<c:forEach items="${preferences}" var="preference">
					<aui:option label="studentjob.preference.${preference}" value="${preference}"/>
				</c:forEach>
			</aui:select>
			
			<div class="offers-count-wrapper col-12">
				<span><span id="<portlet:namespace />offer-count">${offerCount}</span> <liferay-ui:message key="studentjob.offers.total" /></span>
			</div>
		</div>
	</div>
</div>
	
<div class="container">
	<div style="display: none;" id="<portlet:namespace />spinnerloading" class="spinner loading"></div>
	
	<div class="offers-cards" id="<portlet:namespace />offers-list">
		<c:forEach items="${offersDTO}" var="offer">
			<%@ include file="/offer/user/card.jspf" %>
		</c:forEach>
	</div>
	<div id="<portlet:namespace />offers-cards-bottom"></div>
</div>


<script type="text/javascript">
	AUI().ready('aui-module', function(A){
		let offset = <%=StudentjobConstants.OFFERS_OFFSET%>;
		let start = <%=StudentjobConstants.OFFERS_OFFSET%>;
		
		let offerCount = ${offerCount}
		
		let keywordsInput = document.getElementById('<portlet:namespace />keywords')
		let regionInput = document.getElementById('<portlet:namespace />region')
		let degreeInput = document.getElementById('<portlet:namespace />degree')
		let preferenceInput = document.getElementById('<portlet:namespace />preference')
		let spinnerElement = document.getElementById('<portlet:namespace />spinnerloading')
		let offersList = document.getElementById('<portlet:namespace />offers-list');
		let offerCountElement = document.getElementById('<portlet:namespace />offer-count');
		let footerElement = document.getElementById('footer');
		
		let scrollListening = true;
		
		let newestOfferId = ${newestOfferId}
		
		console.log("newestOfferId " + newestOfferId)
		console.log("start " + start)
		console.log("offset " + offset)
		
		let keywords = keywordsInput.value
		let region = regionInput.value
		let degree = degreeInput.value
		let preference = preferenceInput.value
		
		var keywordsChange = function (event) {
			if (!event.key || event.key === "Enter" ) {
				if (event.target.value != keywords){
					keywords = event.target.value;
					resetOffers()
				}
			}
		};
		
		var regionChange = function (event) {
			if (event.target.value != region){
				region = event.target.value;
				resetOffers()
			}
		};
		
		var degreeChange = function (event) {
			if (event.target.value != degree){
				degree = event.target.value;
				resetOffers()
			}
		};
		
		var preferenceChange = function (event) {
			if (event.target.value != preference){
				preference = event.target.value;
				resetOffers()
			}
		};
		
		keywordsInput.addEventListener('keyup', keywordsChange);
		keywordsInput.addEventListener('focusout', keywordsChange);
		regionInput.addEventListener('change', regionChange);
		degreeInput.addEventListener('change', degreeChange);
		preferenceInput.addEventListener('change', preferenceChange);
		
		
		function resetOffers(){
			start = 0;
			scrollListening = true;
			spinnerElement.style.display = "block";
			offersList.innerHTML = "";
			reloadOffersResource();
		}
		
		function reloadOffersResource(){
			scrollListening = false;
			AUI().use('aui-io-request', function(A){
				A.io.request('${updateOffersURL}', {
					method: 'post',
					data: {
						<portlet:namespace />keywords: keywordsInput.value,
						<portlet:namespace />degree: degreeInput.value,
						<portlet:namespace />preference: preferenceInput.value,
						<portlet:namespace />region: regionInput.value,
						<portlet:namespace />offset: offset,
						<portlet:namespace />start: start,
						<portlet:namespace />newestOfferId: newestOfferId,
					},
					on: {
						success: function() {
							if (this.get('responseData') && this.get('responseData') !== ""){
								offersList.insertAdjacentHTML('beforeend', this.get('responseData'));
								updateOffersAuxData();
								scrollListening = true;
							}
							spinnerElement.style.display = "none";
						}
					}
				});
			});
		}
		
		function updateOffersAuxData(){
			scrollListening = false;
			AUI().use('aui-io-request', function(A){
				A.io.request('${getOffersAuxDataURL}', {
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
								console.log(data);
								newestOfferId = data.newestOfferId;
								offerCount = data.offerCount;
								start = start + offset;
								offerCountElement.textContent = offerCount;
								
								console.log(offerCountElement)
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
				reloadOffersResource();
			}
		};
		
		window.addEventListener("scroll", scrollListener);
	});
</script>