<%@include file="/html/gatling/header.jsp"%>

<%
	String instancePortletName = ParamUtil.getString(request, "pagePortletId");
%>

<h3>Recorder:  <%= instancePortletName  %> </h3>

<c:if test="<%= (instancePortletName != null) &&  (!instancePortletName.equals("0")) %>">
</c:if>
<liferay-portlet:runtime portletName="<%= instancePortletName  %>" />