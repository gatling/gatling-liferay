<%@include file="/html/gatling/header.jsp"%>

<div>
	<liferay-ui:header title="simulation-list-header" ></liferay-ui:header>
	<c:choose>
		<c:when test="${empty listSimulation}">
			<p><liferay-ui:message key="simulation-list-empty"/></p>
		</c:when>
		<c:otherwise>
		<ul>
			<c:forEach items="${listSimulation}" var="simulation">
				<li>
					<portlet:renderURL var="editSimulationURL">
						<portlet:param name="page" value="/html/gatling/editSimulation.jsp"/>
						<portlet:param name="simulationId" value="${simulation.simulation_id }"/>						
					</portlet:renderURL>
					<portlet:actionURL var="removeSimulationURL" name="removeSimulation" windowState="normal">
						<portlet:param name="simulationId" value="${simulation.simulation_id }"/>						
					</portlet:actionURL>
					<c:out value="${simulation.name}"></c:out> 
					<a href="${editSimulationURL}"><i class="icon-wrench"></i></a>
					<a href="${removeSimulationURL }"><i class="icon-trash"></i></a>
				</li>
			</c:forEach>
		</ul>
		</c:otherwise>
	</c:choose>
</div>

<aui:button id="newSimulation" value="simulation-list-btn-add-simulation"></aui:button>

<%--submit to addSimulation --%>
<portlet:actionURL name="addSimulation" var="addSimulationURL" windowState="normal"/>
<%--Formulaire d'ajout --%>
<div id="newFormSimulation" hidden="true">
	<aui:form action="${addSimulationURL}" name="simulation_fm" id="simulation_fm" >
		<aui:input label="simulation-list-form-nom-simulation" name="simulationName">
			<aui:validator name="required"></aui:validator>
		</aui:input>
		<aui:button  type="submit"></aui:button>
	</aui:form>
</div>

<aui:script>
YUI().use(
  'aui-modal',
  function(Y) {
    var modal = new Y.Modal(
      {
        bodyContent: AUI().one("#newFormSimulation").html(),
        centered: true,
        headerContent: '<h3><liferay-ui:message key="simulation-list-form-header" /></h3>',
        modal: true,
        resizable: false,
        visible: false,
        width: 450
      }
    ).render();
    
    Y.one('#newSimulation').on(
      'click',
      function() {
        modal.show();
      }
    );
  }
);
</aui:script>
