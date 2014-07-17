<%@include file="/html/gatling/header.jsp"%>

<%
	ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	Scenario scenario = (Scenario) row.getObject();

	long scenarioId = scenario.getScenario_id();
%>

<liferay-ui:icon-menu>
	<portlet:renderURL var="editScenarioURL">
		<portlet:param name="page" value="/html/gatling/editScenario.jsp" />
		<portlet:param name="scenarioId"
			value="<%=String.valueOf(scenarioId)%>" />
	</portlet:renderURL>

	<liferay-ui:icon image="edit" url="${editScenarioURL}" />

	<portlet:actionURL var="deleteScenarioURL" name="removeScenario">
		<portlet:param name="scenarioId"
			value="<%=String.valueOf(scenarioId)%>" />
	</portlet:actionURL>

	<liferay-ui:icon-delete url="${deleteScenarioURL}" />
</liferay-ui:icon-menu>