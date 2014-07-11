<%@include file="/html/gatling/header.jsp"%>

<h3>Scenarios Of ${simulation} :</h3>

<c:forEach items="${listScenario}" var="scenario">

	<ul>
		<li>
			<%--redirect to editScenario --%> <portlet:actionURL
				name="editScenario" var="editScenarioURL" windowState="normal">
				<portlet:param name="scenarioId" value="scenario.scenario_id" />

			</portlet:actionURL> <c:out value="${scenario.name}"></c:out> <a
			href="${editSimulationURL}"><i class="icon-wrench"></i></a> <%--<a href="#"><i class="icon-trash"></i></a>--%>
		</li>
	</ul>

</c:forEach>


<aui:button>Add Scenario</aui:button>