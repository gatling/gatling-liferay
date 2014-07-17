<%@include file="/html/gatling/header.jsp"%>

<%
	ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	Simulation simulation = (Simulation) row.getObject();

	long simulationId = simulation.getSimulation_id();

	String redirect = PortalUtil.getCurrentURL(renderRequest);
%>

<liferay-ui:icon-menu>
	<portlet:renderURL var="editSimulationURL">
		<portlet:param name="page" value="/html/gatling/editSimulation.jsp" />
		<portlet:param name="simulationId"
			value="<%=String.valueOf(simulationId)%>" />
	</portlet:renderURL>

	<liferay-ui:icon image="edit" url="${editSimulationURL}" />

	<portlet:actionURL var="deleteSimulationURL" name="removeSimulation">
		<portlet:param name="simulationId"
			value="<%=String.valueOf(simulationId)%>" />
	</portlet:actionURL>

	<liferay-ui:icon-delete url="${deleteSimulationURL}" />
</liferay-ui:icon-menu>