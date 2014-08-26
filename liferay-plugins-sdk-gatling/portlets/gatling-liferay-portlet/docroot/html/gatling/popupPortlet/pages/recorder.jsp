<%@include file="/html/gatling/header.jsp"%>

<%
	String instancePortletId = ParamUtil.getString(request, "pagePortletId");
	String instancePortletName = PortletLocalServiceUtil.getPortletById(instancePortletId).getDisplayName();
	System.out.println("portlet id= "+instancePortletId);
%>

<h3><liferay-ui:message key="recorder-for" />: <%= instancePortletName %></h3>


<c:if test='<%= ((instancePortletId != null) &&  (!"0".equals(instancePortletId))) %>'>
	<aui:input name="portletRecordName" inlineField="true" ></aui:input>
	<div class="btn-group inline-button">
	    <button class="btn"><i class="icon-play"></i> Record</button>
	    <button class="btn"><i class="icon-stop"></i> Stop</button>
	</div>
	
	<hr/>
	<div class="well">
		<liferay-portlet:runtime portletName="<%= instancePortletId  %>" />
	</div>
</c:if>
