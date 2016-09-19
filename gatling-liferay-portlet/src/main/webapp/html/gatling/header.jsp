<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %> 
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>

<%@ page import="com.liferay.portal.kernel.template.TemplateHandler" %>
<%@ page import="com.liferay.portal.kernel.template.TemplateHandlerRegistryUtil" %>
<%@ page import="com.liferay.portal.kernel.exception.PortalException" %>
<%@ page import="com.liferay.portal.kernel.exception.SystemException" %>
<%@ page import="com.liferay.portal.kernel.util.Constants" %>
<%@ page import="com.liferay.portal.kernel.util.StringPool" %>
<%@ page import="com.liferay.portal.kernel.dao.search.ResultRow" %>
<%@ page import="com.liferay.portal.kernel.util.GetterUtil" %>
<%@ page import="com.liferay.portal.kernel.util.HtmlUtil" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="com.liferay.portal.kernel.util.WebKeys" %>
<%@ page import="com.liferay.portal.model.Group"%>
<%@ page import="com.liferay.portal.theme.ThemeDisplay" %>
<%@ page import="com.liferay.portal.util.PortalUtil" %>

<%@ page import="io.gatling.liferay.model.Request"%>
<%@ page import="io.gatling.liferay.model.Scenario"%>
<%@ page import="io.gatling.liferay.model.Simulation"%>
<%@ page import="io.gatling.liferay.mustache.ListScript"%>
<%@ page import="io.gatling.liferay.service.RequestLocalServiceUtil"%>
<%@ page import="io.gatling.liferay.service.ScenarioLocalServiceUtil"%>
<%@ page import="io.gatling.liferay.service.SimulationLocalServiceUtil"%>
<%@ page import="com.liferay.util.portlet.PortletProps" %>
<%@ page import="com.liferay.portal.service.PortletLocalServiceUtil" %>

<liferay-theme:defineObjects />

<portlet:defineObjects /> 