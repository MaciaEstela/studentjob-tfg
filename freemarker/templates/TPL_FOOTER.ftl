<div class="footer-content pt-5">
	<div class="footer-content__wrapper container">
		<div class="row">
			<div class="col-12 col-md-4 mb-5 mb-md-0">
				<a href="/">
					<img alt="Studentjob Logo" class="logo" width="200" src="/o/studentjob-theme/images/studentjob-dark.png">
				</a>
			</div>
			<div class="col-12 col-md-4">
				<#if (Columna1.Columna1_Titulo.getData())??>
					<span class="footer-content__col-title">${Columna1.Columna1_Titulo.getData()}</span>
					<#if Columna1.Columna1_Campos_Enlace.getSiblings()?has_content>
						<ul class="footer-content__list">
							<#list Columna1.Columna1_Campos_Enlace.getSiblings() as cur_enlace>
								<#assign target = "_self">
								<#if getterUtil.getBoolean(cur_enlace.Columna1_Enlace_Externo.getData())>
										<#assign target = "_blank">
								</#if>
								<li>
									<a class="footer-content__list-link" target="${target}" href="${cur_enlace.Columna1_Enlace_URL.getData()}">
										${cur_enlace.Columna1_Enlace_Texto.getData()}
									</a>
								</li>
							</#list>
						</ul>
					</#if>
				</#if>
			</div>
			<div class="col-12 col-md-4">
				<#if (Columna2.Columna2_Titulo.getData())??>
					<span class="footer-content__col-title">${Columna2.Columna2_Titulo.getData()}</span>
					<#if Columna2.Columna2_Campos_Enlace.getSiblings()?has_content>
						<ul class="footer-content__list">
							<#list Columna2.Columna2_Campos_Enlace.getSiblings() as cur_enlace>
								<#assign target = "_self">
								<#if getterUtil.getBoolean(cur_enlace.Columna2_Enlace_Externo.getData())>
										<#assign target = "_blank">
								</#if>
								<li>
									<a class="footer-content__list-link" target="${target}" href="${cur_enlace.Columna2_Enlace_URL.getData()}">
										${cur_enlace.Columna2_Enlace_Texto.getData()}
									</a>
								</li>
							</#list>
						</ul>
					</#if>
				</#if>
			</div>
		</div>
	</div>
</div>