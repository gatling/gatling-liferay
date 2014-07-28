<%@include file="/html/gatling/header.jsp"%>

<c:set var="row" value="${requestScope.WebKeys.SEARCH_CONTAINER_RESULT_ROW}" />
<c:set var="scenario" value="${row.object}" />
<liferay-ui:icon-menu>
	<portlet:renderURL var="editScenarioURL">
		<portlet:param name="page" value="/html/gatling/editScenario.jsp" />
		<portlet:param name="scenarioId"
			value="${scenario.scenario_id }" />
	</portlet:renderURL>

	<liferay-ui:icon image="edit" url="${editScenarioURL}" />

	<portlet:actionURL var="deleteScenarioURL" name="removeScenario">
		<portlet:param name="scenarioId" value="${scenario.scenario_id }" />
		<portlet:param name="simulationId" value="${scenario.simulation_id }" />
	</portlet:actionURL>
	<liferay-ui:icon-delete url="${deleteScenarioURL}" />
</liferay-ui:icon-menu>