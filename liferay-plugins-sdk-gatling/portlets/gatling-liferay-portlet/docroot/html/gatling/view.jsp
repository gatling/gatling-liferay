<%@include file="/html/gatling/header.jsp"%>

<div>
	<h3>Liste des scénarios enregistrés</h3>
	<c:choose>
		<c:when test="${empty listScenario  }">
			<p>Il n'y a pas de scénarios enregistrés !</p>
		</c:when>
		<c:otherwise>
			<c:forEach items="${listScenario}" var="scenario">
				<ol>
					<li><c:out value="${scenario}"></c:out> <a href="#"><i
							class="icon-wrench"></i></a></li>
				</ol>
			</c:forEach>
		</c:otherwise>
	</c:choose>
</div>
<hr>
<aui:button id="newSimulation" value="Ajouter Simulation"></aui:button>
<div id="divNewSimulation" hidden="true">
	<h5>Nouvelle simulation</h5>
	<portlet:actionURL name="addSimulation" var="addSimulationURL" windowState="normal" />
	<aui:form post="${addSimulationURL }" name="simulation_fm" id="simulation_fm">
		<aui:input label="nom-simulation" name="simulationName">
			<aui:validator name="required"></aui:validator>
		</aui:input>
		<aui:button name="ajouter-simulation" type="submit"></aui:button>
	</aui:form>
</div>

<aui:script use="aui-base">
	A.one("#newSimulation").on('click', function() {
		A.one("#divNewSimulation").show();
		this.set('disabled', true);
		this.ancestor('.aui-button').addClass('aui-button-disabled');
	});

</aui:script>