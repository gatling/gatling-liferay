<%@include file="/html/gatling/header.jsp"%>

<portlet:renderURL var="backURL">
	<portlet:param name="page" value="/html/gatling/view.jsp"/>
</portlet:renderURL>


<liferay-ui:header title="help_content1" backURL="${backURL}" />










<liferay-ui:message key="help_content2"  />

<ul>
<li><liferay-ui:message key="help_content3"  /></li>
<li><liferay-ui:message key="help_content4"  /></li>
<li><liferay-ui:message key="help_content5"  /></li>
<li><liferay-ui:message key="help_content6"  /></li>
<li><liferay-ui:message key="help_content7"  /></li>
<li><liferay-ui:message key="help_content8"  /></li>
<li><liferay-ui:message key="help_content9"  /></li>
<li><liferay-ui:message key="help_content10"  /></li>
<li><liferay-ui:message key="help_content11"  /></li>
<li><liferay-ui:message key="help_content12"  /></li>
<li><liferay-ui:message key="help_content13"  /></li>
</ul>

<aui:button-row>
		<aui:button type="submit" href="${backURL}" value="help-ret-button-name"/>
</aui:button-row>