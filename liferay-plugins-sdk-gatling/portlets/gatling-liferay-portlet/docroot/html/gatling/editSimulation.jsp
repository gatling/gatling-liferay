<%-- 
	Copyright 2014 eBusiness Information, Groupe Excilys (www.ebusinessinformation.fr)
--%>
<%@include file="/html/gatling/header.jsp"%>
<%--
	header
--%>
<portlet:renderURL var="backURL">
	<portlet:param name="page" value="/html/gatling/view.jsp" />
</portlet:renderURL>

<c:set var="titleHeader">
	<liferay-ui:message key="simulation-edit-header" arguments="${simulation.name}" />
</c:set>
<liferay-ui:header title="${titleHeader}" backURL="${backURL}" />
<%--
	session errors 
--%>
<liferay-ui:error key="scenario-name-required" message="scenario-name-required" />
<liferay-ui:error key="scenario-name-already-used" message="scenario-name-already-used" />
<liferay-ui:error key="scenario-groupid-missing" message="scenario-groupid-missing" />
<liferay-ui:error key="scenario-simulationid-missing" message="scenario-simulationid-missing" />
<liferay-ui:error key="scenario-variable-required" message="scenario-variable-required" />

<%--
	 FAQ link
--%>
<portlet:renderURL var="helpURL" windowState="pop_up">
	<portlet:param name="page" value="/html/gatling/help.jsp" />
</portlet:renderURL>
<div class="well well-small">
	<a target="_blank" href="<%= PortletProps.get("gatling-wiki") %>" class="label label-warning">
		<i class="icon-share"></i> 
		<liferay-ui:message key="help-gatling-wiki" />
	</a> 
	<a href="#" class="label" id="help">
		<i class="icon-question-sign"></i> 
		<liferay-ui:message key="help-how-to-use-portlet" />
	</a> 
	<a href="#" class="toggle label label-info" data-content="help-scenario">
		<i class="icon-info-sign"></i> 
		<liferay-ui:message key="help-what-scenario" />
	</a>
</div>

<div id="help-scenario" class="alert alert-info help-text help-content-hidden">
	<i class="icon-info-sign"></i> <liferay-ui:message key="scenario-explanation" />
</div>

<div class="navbar">
	<div class="navbar-inner">
		<ul class="nav">
			<li>
				<a id="newScenario" href="#"> <i class="icon-plus"></i> <liferay-ui:message key="simulation-edit-btn-add-scenario" /></a>
			</li>
			<li>
				<a id="exportToggle" href="#"><i class="icon-print"></i> <liferay-ui:message key="simulation-list-export-one" /></a>
			</li>
		</ul>
	</div>
</div>
<%--
	Page content
 --%>
<%--Simulation Name --%>
<portlet:actionURL var="editSimulationURL" name="editSimulation" />
<aui:form action="${editSimulationURL}" name="fm_simulation" cssClass="form-inline" inlineLabels="true">
	<aui:input name="simulationId" type="hidden" value="${simulation.simulation_id }" />
	<aui:input label="simulation-edit-name-simulation" name="simulationName" inlineLabel="true" inlineField="true" value="${simulation.name }">
		<aui:validator name="custom" errorMessage="simulation-name-syntaxe">
			function (val, fieldNode, ruleValue) {
				return /^[\w\s]+$/.test(val);
			}
		</aui:validator>
		<aui:validator name="custom" errorMessage="simulation-name-already-used">
		 	function (val, fieldNode, ruleValue) {
				var result = false;
				var list = ${listOfSimulationName};
				if (list.indexOf(val) == -1 || val == "${simulation.name}") {
					result = true;
				}
				return result;
			}
		</aui:validator>
	</aui:input>
	<aui:button type="submit" cssClass="inline-button" />
</aui:form>
<c:if test="${not empty listScenario }">
<c:set var="export" value="true" />
</c:if>
<%--Search container (table) --%>
<liferay-ui:search-container emptyResultsMessage="scenario-list-empty">
	<%--Liste of data to display --%>
	<liferay-ui:search-container-results results="${listScenario }" total="${listScenario.size() }" />
	<%--for each column --%>
	<liferay-ui:search-container-row className="com.excilys.liferay.gatling.model.Scenario" keyProperty="scenario_id" modelVar="scenario">
		<%-- EditURl --%>
		<portlet:renderURL var="editScenarioURL">
			<portlet:param name="page" value="/html/gatling/editScenario.jsp" />
			<portlet:param name="scenarioId" value="${scenario.scenario_id }" />
		</portlet:renderURL>
		<liferay-ui:search-container-column-text name="simulation-edit-table-header-name" value="${scenario.name}" href="${editScenarioURL}" />
		<%--site name --%>
		<liferay-ui:search-container-column-text name="simulation-edit-table-header-site">
			<c:forEach var="site" items="${listGroup}">
				<c:if test="${site.groupId eq scenario.group_id}">
					${site.descriptiveName}
				</c:if>
			</c:forEach>
		</liferay-ui:search-container-column-text>
		<%-- requests --%>
		<liferay-ui:search-container-column-text name="simulation-edit-table-header-requests" value="${MapScenario.get(scenario)[0]}/${MapScenario.get(scenario)[1]}" />
		<%-- duration --%>
		<liferay-ui:search-container-column-text name="simulation-edit-table-header-duration" value="${scenario.duration }" />
		<%-- users --%>
		<liferay-ui:search-container-column-text name="simulation-edit-table-header-users" value="${scenario.getNumberOfUsers() }" />
		<%-- state --%>
		<liferay-ui:search-container-column-text name="simulation-edit-table-header-state">
			<c:choose>
				<c:when test="${MapScenario.get(scenario)[2] == 2}">
					<span class="badge badge-success"><i class=" icon-ok"></i></span> 
					<liferay-ui:icon-help message="message-help-info-state-scenario-success" />
				</c:when>
				<c:when test="${MapScenario.get(scenario)[2] == 1}">
					<span class="badge badge-warning"><i class="icon-pencil"></i></span> 
					<liferay-ui:icon-help message="message-help-info-state-scenario-warning" />
					<c:set var="export" value="false"/>
				</c:when>
				<c:otherwise>
					<span class="badge badge-important"><i class="icon-ban-circle"></i></span> 
					<liferay-ui:icon-help message="message-help-info-state-scenario-important" />
					<c:set var="export" value="false"/>
				</c:otherwise>
			</c:choose>
		</liferay-ui:search-container-column-text>
		<%--delete button --%>
		<liferay-ui:search-container-column-text name="delete" align="center">
			<portlet:actionURL var="deleteScenarioURL" name="removeScenario">
				<portlet:param name="scenarioId" value="${scenario.scenario_id }" />
				<portlet:param name="simulationId" value="${scenario.simulation_id }" />
			</portlet:actionURL>
			<liferay-ui:icon-delete url="${deleteScenarioURL}" />
		</liferay-ui:search-container-column-text>
	</liferay-ui:search-container-row>
	<%--iterate and show list of data --%>
	<liferay-ui:search-iterator paginate="false" />
</liferay-ui:search-container>

<%--redirect to addSimulation --%>
<portlet:actionURL name="addScenario" var="addScenarioURL">
	<portlet:param name="page" value="/html/gatling/editSimulation.jsp" />
	<portlet:param name="simulationId" value="${simulation.simulation_id}" />
</portlet:actionURL>
<%-- Add Form --%>
<div id="newFormScenario" hidden="true">
	<%@include file="/html/gatling/template/formNewScenario.jsp"%>
</div>
<c:if test="${export}">
<%--Export Simulation --%>
<div id="exportModalTemplate" hidden="true">
	<portlet:resourceURL var="resourceUrl" />
	<aui:form action="${resourceUrl}" method="post" name="fmExport">
		<h5><liferay-ui:message key="simulation-list-export" /></h5>
		<aui:input name="export" value="${simulation.simulation_id }" type="hidden" />
		<aui:select label="simulation-list-version-choice" name="gatlingVersion" >
			<%@include file="/html/gatling/template/gatlingVersionOption.jsp" %>
		</aui:select>
	</aui:form>
</div>
</c:if>

<script type="text/javascript">
	AUI().use('aui-base','event','aui-modal', function(A) {
 		var modal = new A.Modal({
			bodyContent : A.one("#newFormScenario").html(),
			centered : true,
			headerContent : "<h3><liferay-ui:message key="simulation-edit-form-header" arguments="${simulation.name}"/></h3>",
			modal : true,
			resizable : false,
			visible : false,
			zIndex : 100
		}).render();
		//Remove the form template (no duplication otherwise it will never validate the pop-up)
		A.one("#newFormScenario").empty();
		
		A.one('#exportToggle').on('click', function() {
			if(A.one("#exportModalTemplate") != null) {
				var modalExport = new A.Modal({
					bodyContent : A.one("#exportModalTemplate").html(),
					centered : true,
					headerContent : '<h3><liferay-ui:message key="simulation-list-export" /></h3>',
					modal : true,
					resizable : false,
					zIndex : 100,
				}).render();
				modalExport.addToolbar(
			    	      [
			    	        {
			    	          label: '<liferay-ui:message key="cancel" />',
			    	          on: {
			    	            click: function() {
			    	            	modalExport.hide();
			    	            }
			    	          }
			    	        },
			    	        {
			    	          label: '<liferay-ui:message key="export" />',
			    	          cssClass : 'btn-info',
			    	          on: {
				    	            click: function() {
				    	            	modalExport.hide();
				    	            	A.one("#<portlet:namespace/>fmExport").submit();
				    	            }
				    	          }
			    	        }
			    	      ]);
			} else {
				alert("<liferay-ui:message key="message-help-info-state-simulation-important" />");
			}
		});
		

		A.one('#newScenario').on('click', function() {
			modal.show();
		});
		
		A.one("#help").on('click', function(A) {
			Liferay.Util.openWindow({
			     dialog : {
			          	modal : true,
			           	constrain : true,
			            cache : true
			        },
			        uri : '${helpURL}',
			        title : '<liferay-ui:message key="help-how-to-use-load-test-portlet"/>'
			  });
		});

		A.all(".toggle").each(function() {
			this.on('click', function(event) {
				var contentId = this.getData("content");
				var texts = A.all(".help-content-display");
				texts.replaceClass("help-content-display", "help-content-hidden");
				var helpText = A.one("#" + contentId);
				if (this.hasClass('help-content-selected')) {
					helpText.replaceClass("help-content-display", "help-content-hidden");
					this.removeClass("help-content-selected");
				} else {
					helpText.replaceClass("help-content-hidden", "help-content-display");
					this.addClass("help-content-selected");
				}
			});
		});
		

	});
</script>
