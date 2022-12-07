<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib prefix="aui" uri="http://liferay.com/tld/aui" %>
<%@ taglib prefix="clay" uri="http://liferay.com/tld/clay" %>
<%@ taglib prefix="liferay-item-selector" uri="http://liferay.com/tld/item-selector" %>
<%@ taglib prefix="liferay-frontend" uri="http://liferay.com/tld/frontend" %>
<%@ taglib prefix="liferay-portlet" uri="http://liferay.com/tld/portlet" %>
<%@ taglib prefix="liferay-theme" uri="http://liferay.com/tld/theme" %>
<%@ taglib prefix="liferay-ui" uri="http://liferay.com/tld/ui" %>


<%@ page import="java.util.Date"%>
<%@ page import="javax.portlet.WindowState"%>

<%@ page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@ page import="com.liferay.portal.kernel.util.HtmlUtil"%>

<%@ page import="edu.uoc.mestemi.studentjob.web.constants.StudentjobPortletKeys"%>
<%@ page import="edu.uoc.mestemi.studentjob.web.constants.MVCCommandNames"%>
<%@ page import="edu.uoc.mestemi.studentjob.web.constants.StudentjobConstants"%>

<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="com.liferay.portal.kernel.model.Region" %>
<%@ page import="java.util.Locale" %>

<%@ page import="edu.uoc.mestemi.studentjob.model.SocialMedia"%>
<%@ page import="edu.uoc.mestemi.studentjob.model.SocialMediaNetwork"%>
<%@ page import="edu.uoc.mestemi.studentjob.model.UserEnrollOffer"%>
<%@ page import="edu.uoc.mestemi.studentjob.model.Degree"%>
<%@ page import="edu.uoc.mestemi.studentjob.model.DegreeArea"%>
<%@ page import="edu.uoc.mestemi.studentjob.model.StudentProfile"%>
<%@ page import="edu.uoc.mestemi.studentjob.model.CompanyProfile"%>
<%@ page import="edu.uoc.mestemi.studentjob.model.Offer"%>
<%@ page import="edu.uoc.mestemi.studentjob.web.util.SocialMediaFormDTO"%>


<liferay-frontend:defineObjects />
<liferay-theme:defineObjects />
<portlet:defineObjects />