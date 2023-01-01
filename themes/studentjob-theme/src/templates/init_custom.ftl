<#--
This file allows you to override and define new FreeMarker variables.
-->

<#assign nav_css_class = nav_css_class + " navbar navbar-expand-lg" />
<#assign css_class = css_class + " studentjob-body" />

<#if is_signed_in>
    <#assign studentjob_name = user_name/>
    <#if user.getExpandoBridge().getAttribute("userCompany")?has_content>
        <#assign studentjob_name = user.getExpandoBridge().getAttribute("userCompany")/>
	</#if>
</#if>