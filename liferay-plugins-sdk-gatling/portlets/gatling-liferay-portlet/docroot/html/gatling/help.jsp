<%@include file="/html/gatling/header.jsp"%>

<liferay-ui:message key="help_content"  />



<portlet:renderURL var="backURL">
	<portlet:param name="page" value="/html/gatling/view.jsp"/>
</portlet:renderURL>
<aui:button-row>
		<aui:button type="submit" href="${backURL}" value="help-ret-button-name"/>
</aui:button-row>