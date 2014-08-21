<%-- 
	Copyright 2011-2014 eBusiness Information, Groupe Excilys (www.ebusinessinformation.fr)
--%>
<%@include file="/html/gatling/header.jsp"%>

<%
// Tab value to preselect on page load
// Default parameter name used by the taglib is "tabs1"
String currentTab = ParamUtil.getString(request, "tabs1", "sample");
%>

<!-- This is the link associated to every tab to load the specific page -->
<liferay-portlet:renderURL var="changeTabURL">
	<liferay-portlet:param name="" value=""/>
</liferay-portlet:renderURL>
<liferay-ui:tabs names="Sample, Recorder"
				refresh="false">
	<liferay-ui:section>
		<liferay-util:include page="/html/gatling/popupPortlet/pages/sample.jsp" servletContext="<%=this.getServletContext() %>"/>
	</liferay-ui:section>
	<liferay-ui:section>
		<liferay-util:include page="/html/gatling/popupPortlet/pages/recorder.jsp" servletContext="<%=this.getServletContext() %>"/>
	</liferay-ui:section>
</liferay-ui:tabs>