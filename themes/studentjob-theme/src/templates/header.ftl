<div id="heading" class="heading">
    <#if has_navigation && is_setup_complete>
        <#include "${full_templates_path}/navigation.ftl" />
    <#else>
        <div aria-level="1" class="site-title" role="heading">
            <a class="${logo_css_class}" href="${site_default_url}" title="<@liferay.language_format arguments="${site_name}" key="go-to-x" />">
                <!-- <img alt="${logo_description}" height="${site_logo_height}" src="${site_logo}" width="${site_logo_width}" /> -->
                <img alt="Studentjob Logo" class="logo" src="${images_folder}/logo-studentjob.png" />
            </a>
        </div>
    </#if>
</div>