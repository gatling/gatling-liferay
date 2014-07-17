<%@include file="/html/gatling/header.jsp"%>

<%--This page is called only to add the first scenario --%>
<c:set var="entete"><liferay-ui:message key="simulation-edit-form-header" /></c:set>
<liferay-ui:header title="${entete}"/>

<portlet:actionURL name="addFirstScenario" var="addScenarioURL">
	<portlet:param name="page" value="/html/gatling/editScenario.jsp" />
	<portlet:param name="simulationId" value="${simulation.simulation_id}" />
</portlet:actionURL>
<aui:form action="${addScenarioURL}" name="scenario_fm" id="scenario_fm">
	<aui:input label="simulation-edit-form-nom-scenario" name="scenarioName">
		<aui:validator name="required"></aui:validator>
	</aui:input>
	<aui:fieldset>
		<aui:select label="simulation-edit-form-sites" name="sites" showEmptyOption="true" >
			<c:forEach var="group" items="${listGroup}">
				<aui:option label="${group.name}" value="${group.groupId}" />
			</c:forEach>
		</aui:select>
	</aui:fieldset>

	<aui:button name="ajouter-scenario" type="submit"></aui:button>
</aui:form>