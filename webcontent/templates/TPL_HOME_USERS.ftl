<div class="studentjob-home-users">
	<div class="studentjob-home-users__wrapper container">
		<div class="row ">
			<div class="studentjob-home-users__students col-6">
				<div class="studentjob-home-users__logo-wrapper"><img alt="" class="studentjob-home-users__logo" src="/o/studentjob-theme/images/icon-home-student.png" /></div>
					<div class="studentjob-home-users__count">${studentsCount}</div>
					
					<#if (TituloEstudiantes.getData())??>
						<div class="studentjob-home-users__role">${TituloEstudiantes.getData()}</div>
					</#if>
					
					<#if (TextoEstudiantes.getData())??>
						<div class="studentjob-home-users__text">
								${TextoEstudiantes.getData()}
						</div>
					</#if>
				</div>
				
				<div class="studentjob-home-users__companies col-6">
					<div class="studentjob-home-users__logo-wrapper"><img alt="" class="studentjob-home-users__logo" src="/o/studentjob-theme/images/icon-home-company.png" /></div>
					<div class="studentjob-home-users__count">${companiesCount}</div>
					<#if (TituloEmpresas.getData())??>
						<div class="studentjob-home-users__role">${TituloEmpresas.getData()}</div>
					</#if>
					<#if (TextoEmpresas.getData())??>
						<div class="studentjob-home-users__text">
								${TextoEmpresas.getData()}
						</div>
					</#if>
				</div>
			</div>
		</div>
</div>