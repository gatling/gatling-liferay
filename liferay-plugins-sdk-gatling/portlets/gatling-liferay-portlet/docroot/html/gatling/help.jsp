<%-- 
	Copyright 2011-2014 eBusiness Information, Groupe Excilys (www.ebusinessinformation.fr)
--%>
<%@include file="/html/gatling/header.jsp"%>

<portlet:renderURL var="backURL">
	<portlet:param name="page" value="/html/gatling/view.jsp" />
</portlet:renderURL>
<c:set var="labelUrl" ><liferay-ui:message key="simulation-list-header" /></c:set>
<liferay-ui:header title="help-how-to-use-load-test-portlet" backURL="${backURL}" backLabel="${labelUrl}"/>

<div class="well well-small">
	<a href="#portlet" class="label"><liferay-ui:message key="help-how-to-use-portlet" /></a>
	<a href="#use-scenario" class="label"><liferay-ui:message key="help-use-scenario" /></a>
	<a href="#simulation" class="label"><liferay-ui:message key="help-what-simulation" /></a>
	<a href="#scenario" class="label"><liferay-ui:message key="help-what-scenario" /></a>
	<a href="#gatling" class="label"><liferay-ui:message key="help-more-gatling" /></a>
	<a href="#faq" class="label"><liferay-ui:message key="help-faq" /></a>
</div>
<div>
	<p><liferay-ui:message key="help-description"/></p>
	<fieldset>
		<legend id="portlet"><liferay-ui:message key="help-how-to-use-portlet" /></legend>
		<p><liferay-ui:message key="help-content-intro" /></p>
		<dl>
			<dt><liferay-ui:message key="help-content-step1" /><dt>
			<dd><liferay-ui:message key="help-content-step1-def" /></dd> 
			<dt><liferay-ui:message key="help-content-step2" /></dt>
			<dd><liferay-ui:message key="help-content-step2-def" /></dd> 
			<dt><liferay-ui:message key="help-content-step3" /></dt>
			<dd><liferay-ui:message key="help-content-step3-def" /></dd> 
			<dt><liferay-ui:message key="help-content-step4" /></dt>
			<dd><liferay-ui:message key="help-content-step4-def" /></dd> 
			<dt><liferay-ui:message key="help-content-step5" /></dt>
			<dd><liferay-ui:message key="help-content-step5-def" /></dd> 
		</dl>
	</fieldset>
	<fieldset>
		<legend id="use-scenario"><liferay-ui:message key="help-use-scenario" /></legend>
		<p><liferay-ui:message key="help-use-scenario-info" /></p>
		<p><liferay-ui:message key="help-use-scenario-empty" /></p>
		<p><liferay-ui:message key="help-use-scenario-colors" /></p>
		<ul>
			<li><liferay-ui:message key="help-use-scenario-green" /></li>
			<li><liferay-ui:message key="help-use-scenario-red" /></li>
		</ul>
		<p><liferay-ui:message key="help-use-scenario-save" /></p>
	</fieldset>
	<fieldset>
		<legend id="simulation"><liferay-ui:message key="help-what-simulation" /></legend>
		<p><liferay-ui:message key="simulation-explanation" /></p>
	</fieldset>
	<fieldset>
		<legend id="scenario"><liferay-ui:message key="help-what-scenario" /></legend>
		<p><liferay-ui:message key="scenario-explanation" /></p>
	</fieldset>
	<fieldset>
		<legend id="gatling"><liferay-ui:message key="help-more-gatling" /></legend>
		<p><liferay-ui:message key="help-gatling-intro" /></p>
		<p><liferay-ui:message key="help-gatling-download" /></p>
		<p><liferay-ui:message key="help-gatling-website"/> : <a target="_blank" href='<%= PortletProps.get("gatling-website") %>'><%= PortletProps.get("gatling-website") %></a></p>
		<p><liferay-ui:message key="help-gatling-github"/> : <a target="blank" href='<%= PortletProps.get("gatling-github") %>'><%= PortletProps.get("gatling-github") %></a></p>
		<p><liferay-ui:message key="help-gatling-wiki"/> : <a target="blank" href='<%= PortletProps.get("gatling-wiki") %>'><%= PortletProps.get("gatling-wiki") %></a></p>
	</fieldset>
	<fieldset>
		<legend id="faq"><liferay-ui:message key="help-faq"/></legend>
		
		<dl>
			<dt><liferay-ui:message key="help-faq-export-simulation" /></dt>
			<dd><liferay-ui:message key="help-faq-export-simulation-answer" /><span class="badge badge-success"><i class="icon-ok"></i></span></dd>
			
			<dt><liferay-ui:message key="help-faq-scenario-colors" /></dt>
			<dd><liferay-ui:message key="help-faq-scenario-colors-answer" /></dd>
			
			<dt><liferay-ui:message key="help-faq-scenario-weight" /></dt>
			<dd><liferay-ui:message key="help-faq-scenario-weight-answer" /></dd>
		</dl>
	</fieldset>
</div>