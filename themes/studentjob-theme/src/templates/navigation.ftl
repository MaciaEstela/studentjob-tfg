<nav aria-label="<@liferay.language key="site-pages" />" class="${nav_css_class}" id="navigation" role="navigation">
	<div aria-level="1" class="site-title" role="heading">
        <a class="${logo_css_class}" href="${site_default_url}" title="<@liferay.language_format arguments="${site_name}" key="go-to-x" />">
            <img alt="Studentjob Logo" class="logo" src="${images_folder}/studentjob-dark.png" />
        </a>
    </div>
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
				<#if nav_item.getName() != "my-profile">
					<li class="${nav_item_css_class}" id="layout_${nav_item.getLayoutId()}" role="presentation">
						<a ${nav_item_attr_has_popup} ${nav_item_attr_dropdown} class="${nav_item_link_css_class}" href="${nav_item_url}" ${nav_item.getTarget()} role="menuitem">
							<i class="icon icon-desktop"></i>
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
		<div class="my-profile dropdown">
			<a class="my-profile__item"  type="button" id="dropdownMyProfile" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
				<div class="my-profile__img-wrapper">
					<img class="my-profile__img" src="${user.getPortraitURL(themeDisplay)}" alt="User logo"/>
				</div>
				<div class="dropdown-menu" aria-labelledby="dropdownMyProfile">
					<div href="#" class="my-profile__title">${user_name}</div>
					<#list nav_items as nav_item>
						<#if nav_item.getName() == "my-profile">
							<#list nav_item.getChildren() as nav_child>
								<a href="${nav_child.getURL()}" ${nav_child.getTarget()} class="dropdown-item" role="menuitem">
									${nav_child.getName()}
								</a>
							</#list>
						</#if>
					</#list>
					<a class="dropdown-item" href="/c/portal/logout">Cerrar sesión</a>
				</div>
			</a>
		</div>
	</div>
</nav>