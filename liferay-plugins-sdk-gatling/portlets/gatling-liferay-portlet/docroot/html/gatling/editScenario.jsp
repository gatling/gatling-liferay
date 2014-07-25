<%@include file="/html/gatling/header.jsp"%>
<%--session errors --%>
<liferay-ui:error key="request-weight-required"
	message="request-weight-required" />
<liferay-ui:error key="request-scenarioid-required"
	message="request-scenarioid-required" />

<portlet:renderURL var="backURL">
	<portlet:param name="page" value="/html/gatling/editSimulation.jsp" />
	<portlet:param name="simulationId" value="${scenario.simulation_id }" />
</portlet:renderURL>

<liferay-ui:header title="${scenario.name } : ${siteName}"
	backURL="${backURL }" />

<!-- Affichage du message d'info -->
<div class="well well-small">
	<liferay-ui:icon-help message="About this page">
		<liferay-ui:message key="scenario-edit-help" />
	</liferay-ui:icon-help>
</div>

<portlet:actionURL name="editScenario" var="editScenarioURL" windowState="normal" />
<aui:form action="${editScenarioURL}" method="POST"  name="formulaireScenario" id="formulaireScenario" >
	<liferay-util:buffer var="htmlBottom">
		<aui:button-row>
			<aui:button type="submit" iconAlign="right" onClick="confirmSubmit();return false;"/>
			<aui:button type="cancel" href="${backURL}" iconAlign="right" />
		</aui:button-row>
	</liferay-util:buffer>


	<liferay-ui:form-navigator backURL="${ backURL} "
		categoryNames="${ categoryNames}"
		categorySections="${ categorySections}" formName="formulaireScenario"
		htmlTop="${scenario.name } : ${siteName}" htmlBottom="${htmlBottom} "
		jspPath="/html/gatling/sectionsEditScenario/" showButtons="false" />

</aui:form>
<c:if test="${not empty confirmUpgrade }">
	<aui:input type="hidden" id="confirmUpgrade" value="confirmUpgrade"
		name="confirmUpgrade" />
</c:if>


<%--Upgrade scenario confirmation dialog box --%>
<aui:script use="aui-base,event,aui-modal">
	A.all('.force-weight-childs').each(function() {
		this.on('click',function(event) {
			var childs = this.getData("childs").split(',');
			var value = this.ancestor("td").one("input").val();
			if(!isNaN(value)) {
				for (var i = 0; i < childs.length; i++) {
					changeValueSubPage(childs[i],value);
				}
			}
			showPoids();
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
		
	//check all ? on startup
	if (A.all(".activate:checked").size() === A.all(".activate").size())
		A.one("#checkAll").set("checked", true);

	A.one("#<portlet:namespace />variableScenarioName").val(A.one("#<portlet:namespace />scenarioName").val().replace(/\W/g, ''));
	
	function confirmSubmit() {
 	if(A.all(".activate:checked").size() == 0) {
		var confirmDialog = new A.Modal(
			{
		        bodyContent: 'You have not select any page to activate. Are you sure ?',
		        centered: true,
		        headerContent: '<h3>Empty selection</h3>',
		        modal: true,
		        resizable: false,
		        zIndex: 100
		    }).render();
		    
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
			A.one("#<portlet:namespace />formulaireScenario").submit();
		}	
	}
			  	
	function popUpUpgrade() {
		//if confirm upgrade
  		if(A.one("#<portlet:namespace/>confirmUpgrade") !==null)
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
			    	            	A.one("#<portlet:namespace />formulaireScenario").submit();
			    	            }
			    	          }
		    	        }
		    	      ]
		    	    );
			}
  		else {
  			A.one("#<portlet:namespace />formulaireScenario").submit();
  		}
	}
	
	function changeValueSubPage(page, value) {
		A.one('.'+page).val(value);
		var node = A.one('.'+page).ancestor("td").one("button");
		if(node != null) {
			var childs = node.getData("childs").split(",");
			for (var i = 0; i < childs.length; i++) {
				changeValueSubPage(childs[i], value);
			}
		}
	}
	
	function <portlet:namespace/>forcePoids()
	{		
		var newVal = A.one('#<portlet:namespace/>poidForce').val();
		if ((newVal != null) && (!isNaN(newVal))) {
			A.all('.poids').val(newVal);
			showPoids();
		}
	}
	function showPoids() {
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
	}
	showPoids();
</aui:script>


