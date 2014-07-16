<%@include file="/html/gatling/header.jsp" %>

<portlet:renderURL var="backURL">
	<portlet:param name="page" value="/html/gatling/editSimulation.jsp"/>
	<portlet:param name="simulationId" value="${scenario.simulation_id }"/>		
</portlet:renderURL>
<%--titre de la page --%>
<liferay-ui:header title="${scenario.name }" backURL="${backURL }"/>

<portlet:actionURL name="editScenario"  var="editScenarioURL" windowState="normal"/>
<aui:form action="${editScenarioURL}" method="POST" name="formulaireScenario">
	<aui:fieldset>
		<aui:input type="hidden" name="scenarioId" value='${empty scenario ? "" : scenario.scenario_id }'/>	
		<aui:input type="hidden" name="groupId" value='${scenario.group_id}'/>	
		<table class="table table-striped table-bordered">		
			<tr>
				<th><liferay-ui:message key="scenario-edit-table-header-activate" /></th>
				<th><liferay-ui:message key="scenario-edit-table-header-page" /></th>
				<th><liferay-ui:message key="scenario-edit-table-header-rate" /></th>
				<th><liferay-ui:message key="scenario-edit-table-header-weight" /></th>
			</tr>
			
			<c:forEach var="layout" items='${ listLayout }' varStatus="status">
				<tr>
				<c:choose>
					<c:when test='${listrequest.containsKey(layout.friendlyURL)}'>
						<%--Affichage on connait déjà la request --%>
						<td><aui:input type="checkbox" name="${status.index}" cssClass='activate url${status.index}' checked="true" onChange="showPoids()"/></td>
						<td>${layout.name}</td>	
						<td>
							<aui:input label="" name="rate"  cssClass="poids" value="${listrequest.get(layout.friendlyURL)}" onChange="showPoids()">
								<aui:validator name="number"/>
							</aui:input>
						</td>
						<td><span class='url${status.index} percentage'>0%</span></td>
					</c:when>
					<c:otherwise>
						<%-- Affichage request pas enregistrée --%>
						<td><aui:input type="checkbox" name="${status.index}" cssClass='activate url${status.index}' onChange="showPoids()"/></td>
						<td>${layout.name}</td>	
						<td>
							<aui:input label="" name="rate"  cssClass="poids" 
											onChange="showPoids()">
								<aui:validator name="number"/>
							</aui:input>
						</td>
						<td><span class='url${status.index} percentage'>0%</span></td>
					</c:otherwise>
				</c:choose>
				</tr>
			</c:forEach>
		</table>
		<aui:input  type="text" name="poidForce" id="poidForce" label="scenario-edit-force-rate"> 
			<aui:validator name="number"/>
		</aui:input> 
		<aui:button type="button" value="scenario-edit-force-rate-btn" onClick="forcePoids()"/>
		
	</aui:fieldset>
	<aui:button-row>
		<aui:button type="submit" value="addScenario"/>
		<aui:button type="cancel" href="${backURL}" />
	</aui:button-row>
</aui:form>

<script type="text/javascript">
	function showPoids()
	{		
		AUI().use('aui-base', function(A) {
			var totalRate = parseInt(0);
			A.all('.poids').each(
				function() {
					if(this.ancestor("tr").one(".activate:checked"))
						if(!(this.val() == "" || isNaN(this.val()))) {
							totalRate += parseInt(this.val());	
						}
			});
			var total = totalRate / 100;
			A.all('.poids').each(
				function() {
					if(this.ancestor("tr").one(".activate:checked")) {
						if(!(this.val() == "" || isNaN(this.val()))) {
							var perc = (this.val() / totalRate) * 100;
							this.ancestor("tr").one(".percentage").text(perc.toFixed(2));
						}
					}
					else this.ancestor("tr").one(".percentage").text(0);
			});
	    });
	}
	// Pour afficher les pourcentages si les champs on été remplis (cas edit)
	showPoids();
</script>