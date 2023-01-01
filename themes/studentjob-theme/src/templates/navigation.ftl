<nav aria-label="<@liferay.language key="site-pages" />" class="${nav_css_class}" id="navigation" role="navigation">
	<div aria-level="1" class="site-title w-lg-100" role="heading">
        <a class="${logo_css_class}" href="${site_default_url}" title="<@liferay.language_format arguments="${site_name}" key="go-to-x" />">
            <img alt="Studentjob Logo" class="logo" src="${images_folder}/studentjob-dark.png" />
        </a>
    </div>
	<#if is_signed_in>
		<div class="my-profile dropdown d-lg-none">
			<a class="my-profile__item" type="button" id="dropdownMyProfileResponsive" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
				<div class="my-profile__img-wrapper">
					<img class="my-profile__img" src="${user.getPortraitURL(themeDisplay)}" alt="User logo"/>
				</div>
			</a>
			<div class="dropdown-menu dropdown-menu--responsive" aria-labelledby="dropdownMyProfileResponsive">
				<div class="my-profile__title">
					${studentjob_name}
				</div>
				<#list nav_items as nav_item>
					<#if nav_item.getName() == "my-profile">
						<#list nav_item.getChildren() as nav_child>
							<a href="${nav_child.getURL()}" ${nav_child.getTarget()} class="dropdown-item" role="menuitem">
								${nav_child.getName()}
							</a>
						</#list>
					</#if>
				</#list>
				<a class="dropdown-item my-profile__logout" href="/c/portal/logout">
					<i class="icon icon-signout"></i>
					<@liferay.language key="disconnect" />
				</a>
			</div>
		</div>
	</#if>
	<button class="navbar-toggler collapsed" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
		<div class="navbar-hamburger">
          <span class="line"></span>
          <span class="line"></span>
          <span class="line"></span>
        </div>
	</button>
	<div class="collapse navbar-collapse main-navbar" id="navbarNav">
		<ul role="menubar" class="navbar-nav">
			<#list nav_items as nav_item>
				<#assign
					nav_item_attr_has_popup = ""
					nav_item_attr_dropdown = ""
					nav_item_css_class = " nav-item"
					nav_item_layout = nav_item.getLayout()
					nav_item_link_css_class = " nav-link"
					nav_item_url = nav_item.getURL()
					layoutIcon = ""
				/>

				<#if nav_item.isSelected()>
					<#assign
						nav_item_attr_has_popup = "aria-haspopup='true'"
						nav_item_link_css_class = nav_item_link_css_class + " active"
					/>
				</#if>

				<#if nav_item.hasChildren()>
					<#assign
						nav_item_css_class = nav_item_css_class + " dropdown"
						nav_item_link_css_class = nav_item_link_css_class + " dropdown-toggle"
						nav_item_attr_dropdown = "role='button' data-toggle='dropdown' aria-expanded='false'"
						nav_item_url = "#"
					/>
				</#if>

				<#attempt>
					<#if nav_item.getLayout().getExpandoBridge().hasAttribute("layoutIcon") == true>
						<#assign
							layoutIcon = nav_item.getLayout().getExpandoBridge().getAttribute("layoutIcon")
						/>
					</#if>
				<#recover>
				</#attempt>
				<#if nav_item.getName() != "my-profile">
					<li class="${nav_item_css_class}" id="layout_${nav_item.getLayoutId()}" role="presentation">
						<a ${nav_item_attr_has_popup} ${nav_item_attr_dropdown} class="${nav_item_link_css_class}" href="${nav_item_url}" ${nav_item.getTarget()} role="menuitem">
							<#if layoutIcon != ''>
								<i class="icon ${layoutIcon}"></i>
							</#if>
							<span><@liferay_theme["layout-icon"] layout=nav_item_layout /> ${nav_item.getName()}</span>
						</a>

						<#if nav_item.hasChildren()>
							<div class="dropdown-menu">
								<#list nav_item.getChildren() as nav_child>
									<#assign
										nav_child_css_class = ""
									/>

									<#if nav_item.isSelected()>
										<#assign
											nav_child_css_class = "selected"
										/>
									</#if>
									<a href="${nav_child.getURL()}" ${nav_child.getTarget()} class="dropdown-item ${nav_child_css_class}" role="menuitem">
										${nav_child.getName()}
									</a>
								</#list>
							</div>
						</#if>
					</li>
				</#if>
			</#list>
		</ul>
		<div class="header-lang-selector d-flex justify-content-end">
			 <@liferay_portlet["runtime"]
				instanceId="header-lang"
				portletName="com_liferay_site_navigation_language_web_portlet_SiteNavigationLanguagePortlet"
			/>
		</div> 
		<#if is_signed_in>
			<div class="my-profile dropdown d-none d-lg-block">
				<a class="my-profile__item" type="button" id="dropdownMyProfile" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
					<div class="my-profile__img-wrapper">
						<img class="my-profile__img" src="${user.getPortraitURL(themeDisplay)}" alt="User logo"/>
					</div>
				</a>
				<div class="dropdown-menu" aria-labelledby="dropdownMyProfile">
					<div class="my-profile__title">${studentjob_name}</div>
					<#list nav_items as nav_item>
						<#if nav_item.getName() == "my-profile">
							<#list nav_item.getChildren() as nav_child>
								<a href="${nav_child.getURL()}" ${nav_child.getTarget()} class="dropdown-item" role="menuitem">
									${nav_child.getName()}
								</a>
							</#list>
						</#if>
					</#list>
					<a class="dropdown-item my-profile__logout" href="/c/portal/logout">
						<i class="icon icon-signout"></i>
						<@liferay.language key="disconnect" />
					</a>
				</div>
			</div>
		<#else>
			<div class="log-buttons d-flex justify-content-center pr-md-7 pr-0 pt-5 pt-md-0">
				<a href="/register" class="btn log-buttons__register">
					<@liferay.language key="create-account" />
				</a>
				<a href="/login" class="btn log-buttons__login">
					<@liferay.language key="action.LOGIN" />
				</a>
			</div>
		</#if>
	</div>
</nav>