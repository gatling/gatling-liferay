<%@include file="/html/gatling/header.jsp"%>

<%--session errors --%>
<liferay-ui:error key="request-weight-required" message="request-weight-required" />
<liferay-ui:error key="request-scenarioid-required" message="request-scenarioid-required" />

<portlet:renderURL var="backURL">
	<portlet:param name="page" value="/html/gatling/editSimulation.jsp" />
	<portlet:param name="simulationId" value="${scenario.simulation_id }" />
</portlet:renderURL>

<liferay-ui:header title="${scenario.name } : ${siteName}" backURL="${backURL }" />

<!-- Affichage du message d'info -->
<div class="well well-small">
	<liferay-ui:icon-help message="About this page" ><liferay-ui:message key="scenario-edit-help" /></liferay-ui:icon-help>
</div>

<portlet:actionURL name="editScenario" var="editScenarioURL" windowState="normal" />
<aui:form action="${editScenarioURL}" method="POST" name="formulaireScenario" id="formulaireScenario">
	<aui:button-row cssClass="pull-right">
		<aui:button type="submit" onClick="confirmSubmit();return false;" iconAlign="right"/>
		<aui:button type="cancel" href="${backURL}" iconAlign="right"/>
	</aui:button-row>

	<div id="myTab">
		<ul class="nav nav-tabs">
			<li class="active"><a href="#tab-1"><liferay-ui:message key="scenario" /></a></li>
			<li><a href="#tab-2"><liferay-ui:message key="scenario-edit-details" /></a></li>
		</ul>
	
		<div class="tab-content">	
			<div id="tab-1">
				<aui:fieldset>
					<aui:input type="hidden" name="scenarioId" value='${empty scenario ? "" : scenario.scenario_id }'/>	
					<aui:input type="hidden" name="groupId" value='${scenario.group_id}'/>	
					<table class="table table-bordered table-scenario">		
						<tr>
							<th><input type="checkbox" id="checkAll" /> <liferay-ui:message key="scenario-edit-table-header-activate" /></th>
							<th><liferay-ui:message key="scenario-edit-table-header-page" /></th>
							<th><liferay-ui:message key="scenario-edit-table-header-weight" />
							<input type="text" name="poidForce" id="<portlet:namespace/>poidForce" class="margin-left"/>
								<aui:button type="button" value="scenario-edit-force-weight-btn" onClick="<%=renderResponse.getNamespace() +\"forcePoids()\" %>"/>
							</th>
							<th><liferay-ui:message key="scenario-edit-table-header-percentage" /></th>
						</tr>
						<c:if test="${ listPages.size() ==0 }">
							<tr><td><label style="color: green"> <liferay-ui:message key="no-page" /> </label></td> </tr>
						</c:if>
						<c:forEach var="layout" items='${ listPages }' varStatus="status">
						<c:choose>
							<c:when test="${layout.state == 'NEW_REQUEST'}">
							<%-- Cas où la page est nouvellement créé --%>
							<tr class="success">
								<%-- Affichage request pas enregistrée --%>
								<td><aui:input type="checkbox" name="${status.index}" cssClass='activate' onChange="showPoids()" /></td>
								<td>${layout.showName()}</td>	
								<td>
									<aui:input label="" name="weight${status.index}"  cssClass="poids ${layout.displayLayoutId}" inlineField="true"
													onChange="showPoids()" value="${layout.weight}">
										<aui:validator name="number"/>
									</aui:input> 
									<c:if test="${not empty hierachy[layout.displayLayoutId]}">
										<c:set var="arraySubPage" value="" />
										<c:forEach var="i" items="${hierachy[layout.displayLayoutId]}" varStatus="info">
											<c:set var="arraySubPage" value="${arraySubPage}'${i}'" />
											<c:if test="${not info.last}">
												<c:set var="arraySubPage" value="${arraySubPage}," />
											</c:if>
										</c:forEach>
										<aui:button cssClass="force-weight-childs" data-childs="${arraySubPage}" value="Force-the-weight-to-the-sub-pages"/>
									</c:if>
								</td>
								<td><span class='percentage'>0%</span></td>
							</tr>
							</c:when>
							<c:when test="${layout.state == 'OLD_REQUEST'}">
							<%-- Cas ou la page a été supprimée --%>
							<tr class="error">
								<%-- Affichage request pas enregistrée --%>
								<aui:input name="delete${layout.requestId}" type="hidden" value="${layout.requestId}"></aui:input>
								<td>
									<portlet:actionURL var="deleteRequestURL" name="removeRequest">
											<portlet:param name="requestId" value="${layout.requestId}" />
									</portlet:actionURL>
									<liferay-ui:icon-delete url="${deleteRequestURL}" /> 
								</td>
								<td>${layout.showName()}</td>	
								<td>
									<aui:input label=""  name="weight${layout.requestId}" value="${layout.weight}"  cssClass="poids deleted" 
													onChange="showPoids()" >
										<aui:validator name="number"/>
									</aui:input>
								</td>
								<td><span class='percentage'>0%</span></td>
							</tr>	
							</c:when>
							<c:otherwise>
							<%--  Cas ou page existe et requête aussi --%>
							<tr>
								<td>
								<%-- checked ou pas en fonction de la requête --%>
								<c:choose>
									<c:when test="${layout.checked}">
										<aui:input type="checkbox" name="${status.index}"  cssClass='activate url${status.index}' checked="true" onChange="showPoids()"/>
									</c:when>
									<c:otherwise>
										<aui:input type="checkbox" name="${status.index}"  cssClass='activate url${status.index}' checked="false" onChange="showPoids()"/>
									</c:otherwise>		
								</c:choose>
								</td>
								
								<td>${layout.showName()}</td>
								
								<td>
									<aui:input label="" name="weight${status.index}"  cssClass="poids ${layout.displayLayoutId}" inlineField="true"
									 value="${layout.weight}" onChange="showPoids()">
										<aui:validator name="number"/>
									</aui:input>
									<c:if test="${not empty hierachy[layout.displayLayoutId]}">
										<%--reset value --%>
										<c:set var="arraySubPage" value="" />
										<c:forEach var="i" items="${hierachy[layout.displayLayoutId]}" varStatus="info">
											<c:set var="arraySubPage" value="${arraySubPage}${i}" />
											<c:if test="${not info.last}">
												<c:set var="arraySubPage" value="${arraySubPage}," />
											</c:if>
										</c:forEach>
										<aui:button cssClass="force-weight-childs" data-childs="${arraySubPage}" value="Force-the-weight-to-the-sub-pages"/>
									</c:if>
								</td>
								<td><span class='percentage'>0%</span></td>
							</tr>
							</c:otherwise>
						</c:choose>
						<%--Add a variable to know if we need to ask the user about upgrading its scenario --%>
						<c:if test="${empty confirmUpgrade && (layout.state == 'NEW_REQUEST' || layout.state == 'OLD_REQUEST') }">
							<c:set var="confirmUpgrade" value="confirmUpgrade"/>
						</c:if>
						</c:forEach>
					</table> 
				</aui:fieldset>
			</div>
			<%-- 
			
			=== Tab details === 
			
			--%>
			<div id="tab-2" class="tab-pane">
				<!-- redirect to editScenarioDetails -->
				<portlet:actionURL name="editScenarioDetails" var="editScenarioDetailsURL">
					<portlet:param name="scenarioId" value="${scenario.scenario_id}" />
				</portlet:actionURL>
				<div id="details">
					<h3>
						<liferay-ui:message key="scenario-edit-details" />
					</h3>
	
					<aui:input label="scenario-edit-nb-users-per-second" name="scenarioUsers" value="${scenario.users_per_seconds}">
						<aui:validator name="number"></aui:validator>
					</aui:input>
	
					<aui:input label="scenario-edit-duration" name="scenarioDuration" value="${scenario.duration}">
						<aui:validator name="number"></aui:validator>
					</aui:input>
				</div>
			</div>
		</div>
	</div>
</aui:form>
<c:if test="${not empty confirmUpgrade }">
<aui:input type="hidden" id="confirmUpgrade" value="confirmUpgrade" name="confirmUpgrade"/>
</c:if>


<%--Upgrade scenario confirmation dialog box --%>
<script type="text/javascript">
	function confirmSubmit() {
		AUI().use(
			  	'aui-base',
			 	'aui-modal',
			 	function(Y) {
			  		if(Y.all(".activate:checked").size() == 0) {
			  			var confirmDialog = new Y.Modal(
							      {
							        bodyContent: 'You have not select any page to activate. Are you sure ?',
							        centered: true,
							        headerContent: '<h3>Empty selection</h3>',
							        modal: true,
							        resizable: false,
							        zIndex: 100
							      }
							    ).render();
							    
							    confirmDialog.addToolbar(
							    	      [
							    	        {
							    	          label: 'No',
							    	          on: {
							    	            click: function() {
							    	            	confirmDialog.hide();
							    	            }
							    	          }
							    	        },
							    	        {
							    	          label: 'Yes',
							    	          on: {
								    	            click: function() {
								    	            	confirmDialog.hide();
								    	            	popUpUpgrade();
								    	            }
								    	          }
							    	        }
							    	      ]);
			  			} else {
			  				Y.one("#<portlet:namespace />formulaireScenario").submit();
			  			}
			  	});	
	}
			  	
	function popUpUpgrade() {
		AUI().use(
			  	'aui-base',
			 	'aui-modal',
			 	function(Y) {
					//if confirm upgrade
			  		if(Y.one("#<portlet:namespace/>confirmUpgrade") !==null)
					{
					    var confirmUpgradeDialog = new Y.Modal(
					      {
					        bodyContent: 'This will upgrade your scenario\'s schema to the last version of your site',
					        centered: true,
					        headerContent: '<h3>Upgrade Scenario</h3>',
					        modal: true,
					        resizable: false,
					        zIndex: 100
					      }
					    ).render();
					    
					    confirmUpgradeDialog.addToolbar(
					    	      [
					    	        {
					    	          label: 'Cancel',
					    	          on: {
					    	            click: function() {
					    	            	confirmUpgradeDialog.hide();
					    	            }
					    	          }
					    	        },
					    	        {
					    	          label: 'Upgrade',
					    	          on: {
						    	            click: function() {
						    	            	Y.one("#<portlet:namespace />formulaireScenario").submit();
						    	            }
						    	          }
					    	        }
					    	      ]
					    	    );
						}
			  		else {
			  			Y.one("#<portlet:namespace />formulaireScenario").submit();
			  		}
			  	});
	}

	YUI().use(
		  'aui-tabview',
		  function(A) {
		    new A.TabView(
		      {
		        srcNode: '#myTab'
		      }
		    ).render();
		  }
	);


	AUI().use('aui-base', function(A) {
		A.all('.force-weight-childs').each(function() {
		      this.on('click',function(event) {
					var childs = this.getData("childs").split(',');
					var value = this.ancestor("td").one("input").val();
					if(!isNaN(value)) {
						for (var i = 0; i < childs.length; i++) {
							changeValueSubPage(childs[i],value);
						}
					}
				});
			});
		
		
		A.one("#checkAll").on('click',function(event) {
			var allCheck = this.get('checked');
			A.all(".activate").each(function() {
				this.set("checked",allCheck);	
				this.ancestor("label").one("input").val(allCheck);
			});
			
			showPoids();
		});
			

		A.all(".activate").each(function() {
			this.on('click', function(event) {
				if (this.get('checked')) {
					if (A.all(".activate:checked").size() === A.all(".activate").size())
						A.one("#checkAll").set("checked", true);
				} else {
					A.one("#checkAll").set("checked", false);
				}
			});
		});
		if (A.all(".activate:checked").size() === A.all(".activate").size())
			A.one("#checkAll").set("checked", true);
	});

	
	function changeValueSubPage(page, value) {
		AUI().use('aui-base', function(A) {
			var i = '.'+page;
			A.one('.'+page).val(value);
			var node = A.one('.'+page).ancestor("td").one("button");
			if(node != null) {
				var childs = node.getData("childs").split(",");
				for (var i = 0; i < childs.length; i++) {
					changeValueSubPage(childs[i], value);
				}
			}
	    });
	}
	
	function <portlet:namespace/>forcePoids()
	{		
		AUI().use('aui-base', function(A) {
			var newVal = A.one('#<portlet:namespace/>poidForce').val();
			if ((newVal != null) && (!isNaN(newVal))) {
				A.all('.poids').val(newVal);
				showPoids();
			}
		});
	}
	function showPoids() {
		AUI().use('aui-base', function(A) {
			var totalRate = parseInt(0);
			A.all('.poids').each(function() {
				if (this.ancestor("tr").one(".activate:checked"))
					if (!(this.val() == "" || isNaN(this.val()))) {
						totalRate += parseFloat(this.val());
					}
			});
			var total = totalRate / 100;

			A.all('.poids').each(function() {
				if (this.ancestor("tr").one(".activate:checked")) {
					if (!(this.val() == "" || isNaN(this.val()))) {
						var perc = (this.val() / totalRate) * 100;
						//cas du 0/0
						if (isNaN(perc))
							this.ancestor("tr").one(".percentage").text("0.00 %");
						else
							this.ancestor("tr").one(".percentage").text(perc.toFixed(2) + " %");
					}
				} else
					this.ancestor("tr").one(".percentage").text("0.00 %");
			});
		});
	}
	showPoids();
</script>


