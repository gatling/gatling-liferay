<%@include file="/html/gatling/header.jsp"%>

<%--session errors --%>
<liferay-ui:error key="scenario-name-required" message="scenario-name-required"/>

<%--This page is called only to add the first scenario --%>
<c:set var="entete">
	<liferay-ui:message key="simulation-edit-form-header" arguments="${simulation.name }" />
</c:set>
<liferay-ui:header title="${entete}"/>

<div class="well well-small">
	<liferay-ui:icon-help message="About this page" ><liferay-ui:message key="create-first-scenario-help" /></liferay-ui:icon-help>
</div>

<portlet:actionURL name="addScenario" var="addScenarioURL">
	<portlet:param name="page" value="/html/gatling/editScenario.jsp" />
	<portlet:param name="first" value="true" />
	<portlet:param name="simulationId" value="${simulation.simulation_id}" />
</portlet:actionURL>
<%--
	Form scenario
 --%>
<%@ include file="/html/gatling/template/formNewScenario.jsp" %>