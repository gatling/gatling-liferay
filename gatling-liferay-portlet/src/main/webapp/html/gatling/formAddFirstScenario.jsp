<%-- 
	Copyright 2014 eBusiness Information, Groupe Excilys (www.ebusinessinformation.fr)
--%>
<%@include file="/html/gatling/header.jsp"%>

<%--session errors --%>
<liferay-ui:error key="scenario-name-required" message="scenario-name-required"/>

<%--This page is called only to add the first scenario --%>
<c:set var="entete">
	<liferay-ui:message key="simulation-edit-form-header" arguments="${simulation.name }" />
</c:set>
<liferay-ui:header title="${entete}"/>

<div class="well well-small">
	<liferay-ui:message key="create-first-scenario-help" />
</div>

<portlet:actionURL var="addScenarioURL">
	<portlet:param name="action" value="addScenario" />
	<portlet:param name="first" value="true" />
	<portlet:param name="simulationId" value="${simulation.simulation_id}" />
</portlet:actionURL>
<%--
	Form scenario
 --%>
<c:set var="listOfScenarioName" value="[]"/>
<%@ include file="/html/gatling/template/formNewScenario.jsp" %>

<script type="text/javascript">
<%@ include file="/js/tourFirstScenario.js" %>
</script>