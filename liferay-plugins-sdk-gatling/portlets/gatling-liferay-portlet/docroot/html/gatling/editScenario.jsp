<%-- 
	Copyright 2011-2014 eBusiness Information, Groupe Excilys (www.ebusinessinformation.fr)
--%>
<%@include file="/html/gatling/header.jsp"%>
<%--
	Header
 --%>
<portlet:renderURL var="backURL">
	<portlet:param name="page" value="/html/gatling/editSimulation.jsp" />
	<portlet:param name="simulationId" value="${scenario.simulation_id }" />
</portlet:renderURL>
<c:set var="titleHeader">
	<liferay-ui:message key="scenario-edit" arguments="${headerList}" />
</c:set>
<liferay-ui:header title="${titleHeader}" backURL="${backURL }" />
<%--
	session errors
 --%>
<liferay-ui:error key="request-weight-required"
	message="request-weight-required" />
<liferay-ui:error key="request-scenarioid-required"
	message="request-scenarioid-required" />


<portlet:actionURL name="editScenario" var="editScenarioURL" windowState="normal" />
<aui:form action="${editScenarioURL}" method="POST" name="formulaireScenario">
	<div class="well well-small">
		<liferay-ui:icon-help message="About this page">
			<liferay-ui:message key="scenario-edit-help" />
		</liferay-ui:icon-help>
	</div>
	<div class="pull-right">
		<aui:button type="submit" iconAlign="right" onClick="confirmSubmit();return false;" />
		<aui:button type="cancel" href="${backURL}" iconAlign="right" />
	</div>
	<div class="clearfix"></div>


	<%@include file="/html/gatling/sectionsEditScenario/details.jsp" %>
	<%@include file="/html/gatling/sectionsEditScenario/scenario.jsp" %> 
	

</aui:form>
<c:if test="${not empty confirmUpgrade }">
	<aui:input type="hidden" id="confirmUpgrade" value="confirmUpgrade" name="confirmUpgrade" />
</c:if>

<%--Upgrade scenario confirmation dialog box --%>
<script type="text/javascript">
		
	function confirmSubmit() {
		AUI().use('aui-base',
			function(Y) {
			var message = "";
			var show = false;
			// Check details
			if( !validateNumber(Y.one("#<portlet:namespace />scenarioDuration").val()) 
					|| !validateNumber(Y.one("#<portlet:namespace />scenarioUsers").val()) ) {
				message += "<li><liferay-ui:message key='scenario-edit-empty-details' /></li>";
				show = true;
			}

			//if confirm upgrade
	  		if(Y.one("#<portlet:namespace/>confirmUpgrade") !==null) {
	  			// Add message
	  			message += "<li><liferay-ui:message key='scenario-edit-upgrade'/></li>";
	  			show = true;
			}
			
			//If all weight == 0.0 = no request for scenario
			if(!show){
				show = true;
				message += "<li><liferay-ui:message key='scenario-edit-weight-null'/></li>";
				Y.all(".weightPage").each(function() {
					if(this.val() != 0.0){
			  			show = false;
					}
				});
			}
			
			else{
				var test = true;
				Y.all(".weightPage").each(function() {
					if(this.val() != 0.0){
						test = false;
					}
				});
				if(test){
					message += "<li><liferay-ui:message key='scenario-edit-weight-null'/></li>";
				}
			}
	  		
			if(show) {
				// Create popup
				createModal(message);
			} else {
				Y.one("#<portlet:namespace/>formulaireScenario").submit();
			}
		});
		return false;
	}
	
	function validateNumber(val) {
		return  !isNaN(val) && val > 0;
	}
	
	function createModal(message) {
		AUI().use(
			  	'aui-base',
			 	'aui-modal',
			 	function(Y) {
		  			var confirmDialog = new Y.Modal(
						      {
						        bodyContent: '<liferay-ui:message key="scenario-edit-warning-text" /><ul>'+message+'</ul>',
						        centered: true,
						        headerContent: '<h3><liferay-ui:message key="scenario-edit-warning-submit" /></h3>',
						        modal: true,
						        resizable: false,
						        zIndex: 100
						      }
						    ).render();
						    
						    confirmDialog.addToolbar(
						    	      [
						    	        {
						    	          label: '<liferay-ui:message key="cancel" />',
						    	          on: {
						    	            click: function() {
						    	            	confirmDialog.hide();
						    	            }
						    	          }
						    	        },
						    	        {
						    	          label: '<liferay-ui:message key="submit-anyway" />',
						    	          cssClass : "btn-warning",
						    	          on: {
							    	            click: function() {
							    	            	confirmDialog.hide();
							    	            	Y.one("#<portlet:namespace/>formulaireScenario").submit();
							    	            }
							    	          }
						    	        }
						    	      ]);
			  	});	
	}
</script>
<script type="text/javascript">
<%@ include file="/js/tourEditScenario.js" %>
</script>
