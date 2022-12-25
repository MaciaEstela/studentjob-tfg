<%@ include file="/init.jsp" %>

<div class="my-inscriptions-container-wrapper">
	<div class="my-inscriptions-container-header-wrapper container mb-7 mt-5">
		<h1 class="my-inscriptions-list-title"><liferay-ui:message key="studentjob.myinscriptions.title" /></h1>		
		
		<div class="row my-inscriptions-cards">
			<c:forEach items="${myInscriptionsDTO}" var="myInscription">
				<%@ include file="/myInscriptions/public/card.jspf" %>
			</c:forEach>
		</div>
</div>

<script type="text/javascript">
		function cancelInscription(inscriptionURL, itemURL){
			AUI().use('aui-io-request', function(A){
				A.io.request(inscriptionURL, {
					method: 'post',
					on: {
						success: function() {
							console.log("responseData")
							console.log(this.get('responseData'))
							if (this.get('responseData') && this.get('responseData') == "ok"){
								document.getElementById(itemURL).style.cursor = "initial";
								document.getElementById(itemURL).text = "Has eliminado tu inscripción a esta oferta";
								document.getElementById(itemURL).removeAttribute("href");
							} else {
								console.log("Error on removing enrollment");
							}
						}
					}
				});
			});
		}
</script>