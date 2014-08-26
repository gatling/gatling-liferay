<%@include file="/html/gatling/header.jsp"%>

<%
	String instancePortletId = ParamUtil.getString(request, "pagePortletId");
	String instancePortletName = PortletLocalServiceUtil.getPortletById(instancePortletId).getDisplayName();
	System.out.println("portlet id= "+instancePortletId);
%>

<h3><liferay-ui:message key="recorder-for" />: <%= instancePortletName %></h3>

<div class="well well-small">
	<c:if test='<%= ((instancePortletId != null) &&  (!"0".equals(instancePortletId))) %>'>
		<liferay-portlet:runtime portletName="<%= instancePortletId  %>" />
	</c:if>

</div>

