<%@include file="/html/gatling/header.jsp"%>
<c:set var="row" value="${requestScope.SEARCH_CONTAINER_RESULT_ROW}" />
<c:set var="simulation" value="${row.object}" />

<liferay-ui:icon-menu>
	<portlet:renderURL var="editSimulationURL">
		<portlet:param name="page" value="/html/gatling/editSimulation.jsp" />
		<portlet:param name="simulationId"
			value="${simulation.simulation_id }" />
	</portlet:renderURL>
	<liferay-ui:icon image="edit" url="${editSimulationURL}" />
	
 	<portlet:resourceURL var="resourceUrl" >
		<portlet:param name="simulationId" value="${simulation.simulation_id }" />
	</portlet:resourceURL>
	<liferay-ui:icon image="submit" url="${resourceUrl}" message="Generate Simulation"/>

	<portlet:actionURL var="deleteSimulationURL" name="removeSimulation">
		<portlet:param name="simulationId" value="${simulation.simulation_id }" />
	</portlet:actionURL>

	<liferay-ui:icon-delete url="${deleteSimulationURL}" />
	
</liferay-ui:icon-menu>