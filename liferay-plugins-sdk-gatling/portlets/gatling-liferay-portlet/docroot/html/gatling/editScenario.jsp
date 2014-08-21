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


<portlet:actionURL name="editScenario" var="editScenarioURL"
	windowState="normal" />
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
	AUI().use('aui-base', function(A) {
		
		var lastChecked = null;
		//multiselect
        var checkboxes = A.all(".checkLine");
        checkboxes.each(function() {
        		this.on('click', function(event) {
	                if(!lastChecked) {
	                    lastChecked = this;
	                    return;
	                }
	
	                if(event.shiftKey) {
	                    var start = checkboxes.indexOf(this);
	                    var end = checkboxes.indexOf(lastChecked);
	
	                    checkboxes.slice(Math.min(start,end), Math.max(start,end)+ 1).attr('checked', lastChecked.get("checked"));
	
	                }
	                lastChecked = this;
        		});
        });
		
		A.all('.force-weight-children').each(function() {
		      this.on('click',function(event) {
					var children = this.getData("children").split(',');
					var node = this.ancestor("tr").one(".checkLine");
					var checked=true;
					if(node.get("checked")) {
					 	checked=false;	
					}
					node.set("checked",checked);
					for (var i = 0; i < children.length; i++) {
						selectSubPage(children[i], checked);
					}
					if (A.all(".checkLine:checked").size()==0){
						A.one("#force").set('disabled', true);
						A.one(".forceinput").set('disabled', true);
					}
					else{
						A.one(".forceinput").set('disabled', false);
						A.one("#force").set('disabled', false);
					}
				});
			});
		
		
		A.one("#checkAll").on('click',function(event) {
			var checked=this.get("checked");
			A.all(".checkLine").each(function() {
				this.set("checked", checked);
			});
			
			showWeight();
			if (A.all(".checkLine:checked").size()==0){
				A.one("#force").set('disabled', true);
				A.one(".forceinput").set('disabled', true);
			}
			else{
				A.one(".forceinput").set('disabled', false);
				A.one("#force").set('disabled', false);
			}
		});
			

		A.all(".checkLine").each(function() {
			this.on('click', function(event) {
				if (A.all(".checkLine:checked").size() === A.all(".checkLine").size()) {
					A.one("#checkAll").set("checked", true);
				} else {
					A.one("#checkAll").set("checked", false);
				}
				if (A.all(".checkLine:checked").size()==0){
					A.one("#force").set('disabled', true);
					A.one(".forceinput").set('disabled', true);
				}
				else{
					A.one(".forceinput").set('disabled', false);
					A.one("#force").set('disabled', false);
				}
			});
		});
		if (A.all(".checkLine:checked").size() === A.all(".checkLine").size())
			A.one("#checkAll").set("checked", true);

		
		if (A.all(".checkLine:checked").size()==0){
			A.one("#force").set('disabled', true);
			A.one(".forceinput").set('disabled', true);
		}
		else{
			A.one(".forceinput").set('disabled', false);
			A.one("#force").set('disabled', false);
		}
	});


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
				Y.all(".weight").each(function() {
					if(this.val() != 0.0){
			  			show = false;
					}
				});
			}
			
			else{
				var test = true;
				Y.all(".weight").each(function() {
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
	
	function selectSubPage(page, checked) {
		AUI().use('aui-base', function(A) {
			var node = A.one('.'+page);
			if(node != null) {
				node.one(".checkLine").set("checked",checked);
				var nodeList = node.one(".force-weight-children");
				if(nodeList != null) {
					var children = nodeList.getData("children").split(",");
					for (var i = 0; i < children.length; i++) {
						selectSubPage(children[i], checked);
					}
				}
			}
	    });
	}
	
	function forceWeight()
	{		
		AUI().use('aui-base', function(A) {
			var newVal = A.one('#<portlet:namespace/>forceWeight').val();
			if ((newVal != null) && (!isNaN(newVal))) {
				A.all('.checkLine:checked').each(function() {
					this.ancestor("tr").one(".weight").val(newVal);
				});
				showWeight();
			}
		});
	}
	function showWeight() {
		AUI().use('aui-base', function(A) {
			var totalRate = parseInt(0);
			A.all('.weight').each(function() {
				if (!(this.val() == "" || isNaN(this.val())) && this.val() > 0) {
					totalRate += parseFloat(this.val());
					this.ancestor("tr").removeClass("empty-weight-color");
				}
				else {
					this.val("0.0");
					this.ancestor("tr").addClass("empty-weight-color");
				}
			});

			A.all('.weight').each(function() {
				if (!(this.val() == "" || isNaN(this.val()))) {
					var perc = (this.val() / totalRate) * 100;
					//cas du 0/0
					if (isNaN(perc))
						this.ancestor("tr").one(".percentage").text("0.00 %");
					else
						this.ancestor("tr").one(".percentage").text(perc.toFixed(2) + " %");
				}
			});
		});
	}
	showWeight();
</script>


