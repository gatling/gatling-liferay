<%@include file="/html/gatling/header.jsp"%>

<%
	String instancePortletName = ParamUtil.getString(request, "pagePortletId");
%>

<h3>Recorder:  <%= instancePortletName  %> </h3>


<liferay-portlet:runtime portletName="<%= instancePortletName  %>" />