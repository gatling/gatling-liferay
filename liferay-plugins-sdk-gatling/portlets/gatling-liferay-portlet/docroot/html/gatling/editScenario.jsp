<%@include file="/html/gatling/header.jsp" %>

<portlet:renderURL var="backURL">
	<portlet:param name="page" value="/html/gatling/editSimulation.jsp"/>
	<portlet:param name="simulationId" value="${scenario.simulation_id }"/>		
</portlet:renderURL>

<liferay-ui:header title="${scenario.name } : ${siteName}" backURL="${backURL }"/>

<portlet:actionURL name="editScenario"  var="editScenarioURL" windowState="normal"/>
<aui:form action="${editScenarioURL}" method="POST" name="formulaireScenario">
	<aui:fieldset>
		<aui:input type="hidden" name="scenarioId" value='${empty scenario ? "" : scenario.scenario_id }'/>	
		<aui:input type="hidden" name="groupId" value='${scenario.group_id}'/>	
		<table class="table table-striped table-bordered table-scenario">		
			<tr>
				<th><input type="checkbox" id="checkAll" /> <liferay-ui:message key="scenario-edit-table-header-activate" /></th>
				<th><liferay-ui:message key="scenario-edit-table-header-page" /></th>
				<th><liferay-ui:message key="scenario-edit-table-header-weight" />
					<input type="text" name="poidForce" id="<portlet:namespace/>poidForce" class="margin-left"/>
					<aui:button type="button" value="scenario-edit-force-weight-btn" onClick="<%=renderResponse.getNamespace() +\"forcePoids()\" %>"/>
				</th>
				<th><liferay-ui:message key="scenario-edit-table-header-percentage" /></th>
			</tr>
			
			<c:forEach var="layout" items='${ listPages.keySet() }' varStatus="status">
				<tr>
				
				<!--  Cas ou page existe et requête aussi -->
				<c:if test='${listPages.get(layout)[0] == 1.0}'>
					
					<td>
					<!-- checked ou pas en fonction de la requête -->
					<c:choose>
						<c:when test="${listPages.get(layout)[2] == 1.0}">
							<aui:input type="checkbox" name="${status.index}"  cssClass='activate url${status.index}' checked="true" onChange="showPoids()"/>
						</c:when>
						<c:otherwise>
							<aui:input type="checkbox" name="${status.index}"  cssClass='activate url${status.index}' checked="false" onChange="showPoids()"/>
						</c:otherwise>		
					</c:choose>
					</td>
					
					<td>${layout[0]}</td>	
					
					<td>
						<aui:input label="" name="rate"  cssClass="poids" value="${listPages.get(layout)[1]}" onChange="showPoids()">
							<aui:validator name="number"/>
						</aui:input>
					</td>
					<td><span class='url${status.index} percentage'>0%</span></td>
				</c:if>
				
				<!-- Cas où la page est nouvellement créé -->
				<c:if test='${listPages.get(layout)[0] == 2.0}'>
					<%-- Affichage request pas enregistrée --%>
					<td><aui:input type="checkbox" name="${status.index}" cssClass='activate url${status.index}' onChange="showPoids()"/></td>
					<td><label style="color: green">${layout[0]} (new Page)</label></td>	
					<td>
						<aui:input label="" name="rate"  cssClass="poids" 
										onChange="showPoids()" value="0">
							<aui:validator name="number"/>
						</aui:input>
					</td>
					<td><span class='url${status.index} percentage'>0%</span></td>
				</c:if>
				
				<!-- Cas ou la page a été supprimée -->
				<c:if test='${listPages.get(layout)[0] == 0.0}'>
					<%-- Affichage request pas enregistrée --%>
					<td><aui:input type="checkbox" name="${status.index}" cssClass='activate url${status.index}' onChange="showPoids()"/></td>
					<td><label style="color: red">${layout[0]}</label></td>	
					<td>
						<aui:input label="" name="rate" value="${listPages.get(layout)[1]}"  cssClass="poids" 
										onChange="showPoids()" >
							<aui:validator name="number"/>
						</aui:input>
					</td>
					<td><span class='url${status.index} percentage'>0%</span></td>
				</c:if>
				</tr>
			</c:forEach>
		</table> 
		
	</aui:fieldset>
	<aui:button-row>
		<aui:button type="submit" />
		<aui:button type="cancel" href="${backURL}" />
	</aui:button-row>
</aui:form>



<script type="text/javascript">
	AUI().use('aui-base', function(A) {
		A.one("#checkAll").on('click',function(event) {
			if(this.get('checked')) {
				A.all(".activate").set("checked",true);		
			}
			else {
				A.all(".activate").set("checked",false);
			}
			showPoids();
		});
		
		A.all(".activate").each(function() {
		      this.on('click',function(event) {
				if(this.get('checked')) {
					if(A.all(".activate:checked").size() === A.all(".activate").size())
						A.one("#checkAll").set("checked",true);
				}
				else {
					A.one("#checkAll").set("checked",false);
				}
			});
		});
		if(A.all(".activate:checked").size() === A.all(".activate").size())
			A.one("#checkAll").set("checked",true);
	});
	
	
	
	function <portlet:namespace/>forcePoids()
	{		
		AUI().use('aui-base', function(A) {
			var newVal = A.one('#<portlet:namespace/>poidForce').val();
			if((newVal!=null) && (!isNaN(newVal))){
				A.all('.poids').val(newVal);
				showPoids();
			}				
	    });
	}
	function showPoids()
	{		
		AUI().use('aui-base', function(A) {
			var totalRate = parseInt(0);
			A.all('.poids').each(
				function() {
					if(this.ancestor("tr").one(".activate:checked"))
						if(!(this.val() == "" || isNaN(this.val()))) {
							totalRate += parseFloat(this.val());	
						}
			});
			var total = totalRate / 100;

			A.all('.poids').each(
				function() {
					if(this.ancestor("tr").one(".activate:checked")) {
						if(!(this.val() == "" || isNaN(this.val()))) {
							var perc = (this.val() / totalRate) * 100;
							//cas du 0/0
							if(isNaN(perc))
								this.ancestor("tr").one(".percentage").text("0.00 %");
							else this.ancestor("tr").one(".percentage").text(perc.toFixed(2)+" %");
						}
					}
					else this.ancestor("tr").one(".percentage").text("0.00 %");
			});
	    });
	}
	showPoids();
</script>
