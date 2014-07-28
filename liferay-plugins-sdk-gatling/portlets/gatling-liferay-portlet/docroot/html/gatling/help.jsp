<%@include file="/html/gatling/header.jsp"%>

<portlet:renderURL var="backURL">
	<portlet:param name="page" value="/html/gatling/view.jsp" />
</portlet:renderURL>


<liferay-ui:header title="help_content1" backURL="${backURL}" />

<div class="well well-small">
	<a href="#portlet" class="label"><liferay-ui:message key="help-how-to-use-portlet" /></a>
	<a href="#simulation" class="label"><liferay-ui:message key="help-what-simulation" /></a>
	<a href="#scenario" class="label"><liferay-ui:message key="help-what-scenario" /></a>
	<a href="#gatling" class="label"><liferay-ui:message key="help-more-gatling" /></a>
</div>
	<p><liferay-ui:message key="help-description"/></p>
	
	<h4 id="portlet"><liferay-ui:message key="help-how-to-use-portlet" /></h4>
	<liferay-ui:message key="help_content2" />
	<ol>
		<li><liferay-ui:message key="help_content3" /></li>
		<li><liferay-ui:message key="help_content4" /></li>
		<li><liferay-ui:message key="help_content5" /></li>
		<li><liferay-ui:message key="help_content6" /></li>
		<li><liferay-ui:message key="help_content7" /></li>
		<li><liferay-ui:message key="help_content8" /></li>
		<li><liferay-ui:message key="help_content9" /></li>
		<li><liferay-ui:message key="help_content10" /></li>
		<li><liferay-ui:message key="help_content11" /></li>
		<li><liferay-ui:message key="help_content12" /></li>
		<li><liferay-ui:message key="help_content13" /></li>
	</ol>
	<h4 id="simulation"><liferay-ui:message key="help-what-simulation" /></h4>
	<p><liferay-ui:message key="simulation-explanation" /></p>
	<h4 id="scenario"><liferay-ui:message key="help-what-scenario" /></h4>
	<p><liferay-ui:message key="scenario-explanation" /></p>
	<h4 id="gatling"><liferay-ui:message key="help-more-gatling" /></h4>
	<p><liferay-ui:message key="help-gatling-website"/> : <a target="_blank" href="http://gatling-tool.org/">http://gatling-tool.org/</a></p>
	<p><liferay-ui:message key="help-gatling-github"/> : <a target="blank" href="https://github.com/excilys/gatling/">https://github.com/excilys/gatling/</a></p>
	<p><liferay-ui:message key="help-gatling-wiki"/> : <a target="blank" href="https://github.com/excilys/gatling/wiki/Getting-Started">https://github.com/excilys/gatling/wiki/Getting-Started</a></p>

