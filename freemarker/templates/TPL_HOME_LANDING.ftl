<div class="studentjob-home">
		<div class="studentjob-home__wrapper">
				<div class="container">
						<div class="studentjob-home__container-wrapper row">
								<div class="studentjob-home__left col-12 col-lg-6">
										<#if (Titulo.getData())??>
												<h1 class="studentjob-home__main-header">${Titulo.getData()}</h1>
										</#if>
								</div>
								<div class="studentjob-home__right col-12 col-lg-6">
										<div class="studentjob-home__img-1-wrapper">
												<#if (EnlaceImagenIzq.getData())??>
														<img role="presentation" alt="" class="studentjob-home__img-1" src="${EnlaceImagenIzq.getData()}" />
												</#if>
										</div>
										<div class="studentjob-home__img-2-wrapper">
												<#if (EnlaceImagenDer.getData())??>
														<img role="presentation" alt="" class="studentjob-home__img-2 studentjob-home__floating-image" src="${EnlaceImagenDer.getData()}" />
												</#if>
										</div>
								</div>
								<div class="studentjob-home__buttons col-12 row m-0 mt-5">
										<div class="studentjob-home__btn-1-wrapper col-12 col-xl-6 mb-5">
												<a class="studentjob-home__btn-1" href="${EnlaceRegistro.getData()}">${TextoRegistro.getData()}</a>
										</div>		
										<div class="studentjob-home__btn-2-wrapper col-12 col-md-6">
												<a class="studentjob-home__btn-2" href="${EnlaceLogin.getData()}">${TextoLogin.getData()}</a>
										</div>
								</div>
								<div class="studentjob-home__terms col-12">
										<#if TextosDisclaimer.getSiblings()?has_content>
											<#list TextosDisclaimer.getSiblings() as cur_TextosDisclaimer>
												<#if (cur_TextosDisclaimer.getData())??>
													<p>${cur_TextosDisclaimer.getData()}</p>
												</#if>
											</#list>
										</#if>
								</div>
						</div>
				</div>
		</div>
</div>