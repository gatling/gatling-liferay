<%@include file="/html/gatling/header.jsp"%>

<%
	String instancePortletId = ParamUtil.getString(request, "pagePortletId");
	String instancePortletName = PortletLocalServiceUtil.getPortletById(instancePortletId).getDisplayName();
	System.out.println("portlet id= "+instancePortletId);
%>

<h3><liferay-ui:message key="recorder-for" />: <%= instancePortletName %></h3>


<c:if test='<%= ((instancePortletId != null) &&  (!"0".equals(instancePortletId))) %>'>
	<aui:input name="useCaseRecordName" inlineField="true" ></aui:input>
	<div class="btn-group inline-button">
	    <button class="btn btn-warning"><i class="icon-play"></i> <liferay-ui:message key="record" /></button>
	    <button class="btn" disabled="disabled"><i class="icon-stop"></i> <liferay-ui:message key="stop" /></button>
	</div>
	
	<hr/>
	<div class="well">
		<liferay-portlet:runtime portletName="<%= instancePortletId  %>" />
	</div>
</c:if>
