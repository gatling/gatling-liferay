<%-- 
	Copyright 2014 eBusiness Information, Groupe Excilys (www.ebusinessinformation.fr)
--%>
<%@include file="/html/gatling/header.jsp"%>

<%
	// Tab value to preselect on page load
	// Default parameter name used by the taglib is "tabs1"
	String currentTab = ParamUtil.getString(request, "tabs1",
			"existing-usecase");
%>
<!-- This is the link associated to every tab to load the specific page -->
<liferay-ui:tabs names='existing-usecase,record-usecase,config-record' refresh="false" 
	value="<%=currentTab%>">
	<liferay-ui:section>
		<liferay-util:include
			page="/html/gatling/popupPortlet/pages/sample.jsp"
			servletContext="<%=this.getServletContext()%>" />
	</liferay-ui:section>
	<liferay-ui:section>
		<liferay-util:include
			page="/html/gatling/popupPortlet/pages/recorder.jsp"
			servletContext="<%=this.getServletContext()%>" />
	</liferay-ui:section>
	<liferay-ui:section>
		<liferay-util:include
			page="/html/gatling/popupPortlet/pages/configRecord.jsp"
			servletContext="<%=this.getServletContext()%>" />
	</liferay-ui:section>
</liferay-ui:tabs>
