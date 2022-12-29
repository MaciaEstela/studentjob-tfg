<#assign roleLocalService = serviceLocator.findService("com.liferay.portal.kernel.service.RoleLocalService")/>
<#assign userLocalService = serviceLocator.findService("com.liferay.portal.kernel.service.UserLocalService")>

<div class="studentjob-home-users">
	<div class="studentjob-home-users__wrapper container">
		<div class="row ">
			<div class="studentjob-home-users__students col-6">
				<div class="studentjob-home-users__logo-wrapper"><img alt="" class="studentjob-home-users__logo" src="/o/studentjob-theme/images/icon-home-student.png" /></div>
					
					<#assign nStudents = 50>
					<#if userLocalService?? && roleLocalService??>
							<#assign studentRoleId = roleLocalService.getRole(20097, "studentRole").getRoleId()>
							<#assign nStudents = userLocalService.getRoleUsersCount(studentRoleId)>
					</#if>
					
					<div class="studentjob-home-users__count">${nStudents}</div>
					
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
					
					<#assign nCompany = 50>
					<#if userLocalService?? && roleLocalService??>
							<#assign companyRoleId = roleLocalService.getRole(20097, "companyRole").getRoleId()>
							<#assign nCompany = userLocalService.getRoleUsersCount(companyRoleId)>
					</#if>
					
					<div class="studentjob-home-users__count">${nCompany}</div>
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