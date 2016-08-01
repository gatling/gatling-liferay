<%-- 
	Copyright 2015 Altendis, Groupe Excilys (www.altendis.fr)
--%>
<%@include file="/html/gatling/header.jsp"%>

<%--
	session errors
--%>
<liferay-ui:error key="simulation-name-required" message="simulation-name-required" />
<liferay-ui:error key="simulation-name-already-used" message="simulation-name-already-used" />
<liferay-ui:error key="simulation-variable-required" message="simulation-variable-required" />
<liferay-ui:error key="simulation-variable-syntaxe" message="simulation-variable-syntaxe" />
<%--
	Header
 --%>

<liferay-ui:header title="simulation-list-header"></liferay-ui:header>

<%--
	FAQ link
--%> 
<div class="well well-small">
	<a target="blank" href='<%=PortletProps.get("gatling-wiki") %>' class="label label-warning">
		<i class="icon-share"></i>
		<liferay-ui:message key="help-gatling-wiki" />
	</a> 
	
	<%-- Default View Link --%>
	<portlet:renderURL var="renderView">
		<portlet:param name="render" value="renderView" />
	</portlet:renderURL>
	<a href="${renderView}" class="label label-info"> <i
		class="icon-wrench"></i> Default Test Loading
	</a>
	
	<a href="#" class="label label-success" onclick="tourFirstSimu.start();">
		<i class="icon-list-alt"></i> 
		<liferay-ui:message key="take-a-tour" />
	</a> 
</div>

<%-- If user has permission --%>
<%--NavBar --%>
<div class="navbar">
	<div class="navbar-inner">
		<ul class="nav">
			<li>
				<a id="newSimulation" href="#"> <i class="icon-plus"></i> <liferay-ui:message key="simulation-list-btn-add-simulation" /></a>
			</li>
			<c:if test="${not empty listSimulations}">
			<li>
				<a id="exportToggle" href="#"><i class="icon-print"></i> <liferay-ui:message key="simulation-list-export" /></a>
			</li>
			</c:if>
		</ul>
	</div>
</div>

<portlet:resourceURL id="manyScripts" var="resourceUrl" />
<aui:form action="${resourceUrl}" method="post" name="fmExport"   >
	<aui:input type="hidden" name="gatlingVersion"/>
	<aui:input type="hidden" name="login"/>
	<aui:input type="hidden" name="password"/>
	<aui:input type="hidden" class="upfile"  name="fileName" />
	<aui:input type="hidden" name="upload" id="upload" value="true"/>
	<%--
		Search container (table) 
	--%>
	<liferay-ui:search-container emptyResultsMessage="simulation-list-empty" >
		<%--List of data to display --%>
		<liferay-ui:search-container-results	results="${listSimulations}"	total="${listSimulations.size() }"/>
		<%--for each  column --%>
		<liferay-ui:search-container-row className="com.excilys.liferay.gatling.model.Simulation" keyProperty="simulation_id" modelVar="simulation">
			<%-- checkbox --%>
			<liferay-ui:search-container-column-text>
				<c:choose>
				<c:when test="${MapSimulations.get(simulation)[1] == 2}">
					<input type="checkbox" class="checkLine"
						name="<portlet:namespace/>export" id="<portlet:namespace/>checkAll"
						value="${simulation.simulation_id}" />
				</c:when>
				<c:otherwise>
					<input type="checkbox" class="checkLine" disabled="disabled"/>
					<liferay-ui:icon-help message="message-help-info-state-simulation-important"/>
				</c:otherwise>
				</c:choose>
			</liferay-ui:search-container-column-text>
			<%--edit url --%>
			<portlet:renderURL var="editSimulationURL">
				<portlet:param name="render" value="renderSimulation" />
				<portlet:param name="simulationId" value="${simulation.simulation_id}" />
			</portlet:renderURL>
			<liferay-ui:search-container-column-text name="simulation-list-table-header-name" value="${simulation.name }" href="${editSimulationURL}" />
			<%-- number of scenario --%>
			<liferay-ui:search-container-column-text name="simulation-list-table-header-scenarionb" value="${MapSimulations.get(simulation)[0] }" />
			<%--status --%>
			<liferay-ui:search-container-column-text name="simulation-list-table-header-state">
				<c:choose>
					<c:when test="${MapSimulations.get(simulation)[1] == 2}">
						<span class="badge badge-success"><i class="icon-ok"></i></span> 
						<liferay-ui:icon-help message="message-help-info-state-simulation-success"/>
					</c:when>
					<c:when test="${MapSimulations.get(simulation)[1] == 1}">
						<span class="badge badge-warning"><i class="icon-pencil"></i></span> 
						<liferay-ui:icon-help message="message-help-info-state-simulation-warning"/>
					</c:when>
					<c:otherwise>
						<span class="badge badge-important"><i class="icon-ban-circle"></i> </span>
						<liferay-ui:icon-help message="message-help-info-state-simulation-important"/>
					</c:otherwise>
				</c:choose>
			</liferay-ui:search-container-column-text>
			<%--delete button --%>
			<liferay-ui:search-container-column-text name="delete" >
			<portlet:actionURL var="deleteSimulationURL">
				<portlet:param name="action" value="deleteSimulation"/>
				<portlet:param name="simulationId" value="${simulation.simulation_id }" />
			</portlet:actionURL>
	
			<liferay-ui:icon-delete url="${deleteSimulationURL}" />
			</liferay-ui:search-container-column-text>
		</liferay-ui:search-container-row>
		<%--iterate and display the list --%>
		<liferay-ui:search-iterator paginate="false" />
	</liferay-ui:search-container>
</aui:form>

<%--popup hidden : submit to addSimulation --%>
<portlet:actionURL var="addSimulationURL">
	<portlet:param name="action" value="addSimulation"/>
</portlet:actionURL>
<%-- add simulation form --%>
<div id="newFormSimulation" hidden="true">
	<aui:form action="${addSimulationURL}" name="fm" method="post">
		<div class="well well-small">
			<liferay-ui:message key="create-simulation-help" />
		</div>
		<aui:input label="simulation-list-form-name-simulation" name="simulationName">
			<aui:validator name="required" />
			<aui:validator name="custom" errorMessage="simulation-name-syntaxe">
				function (val, fieldNode, ruleValue) {
					return /^[\w\s]+$/.test(val);
				}
			</aui:validator>
			<aui:validator name="custom" errorMessage="simulation-name-already-used">
			 	function (val, fieldNode, ruleValue) {
					var result = true;
					<c:if test="${not empty listOfSimulationName}"> 
						var list = ${listOfSimulationName};
						if (list.indexOf(val) != -1) {
							result = false;
						}
					</c:if>
					return result;
				}
			</aui:validator>
		</aui:input>
		<aui:button type="submit"  />
	</aui:form>
</div>

<script type="text/javascript">
	AUI().use('aui-modal', 'aui-base', 'event', function(A) {
		var modal = new A.Modal({
			bodyContent : A.one("#newFormSimulation").html(),
			centered : true,
			headerContent : '<h3><liferay-ui:message key="simulation-list-form-header" /></h3>',
			modal : true,
			resizable : false,
			visible : false,
			zIndex : 100,
		}).render();
		//Remove the form template (no duplication otherwise it will never validate the pop-up)
		A.one("#newFormSimulation").empty();

		A.one('#newSimulation').on('click', function() {
			modal.show();
		});
		
		A.all('#exportToggle').on('click', function() {
			if(A.all(".checkLine:checked").size() > 0) {	
				A.one("#<portlet:namespace/>fmExport").submit();
			} else {
				alert("<liferay-ui:message key='no-selected-simulation' />");
			}
		});
	
		/*
		 * Multi select
		 */
		var lastChecked = null;
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
        
	});
</script>

<script type="text/javascript">
<%@ include file="/js/tourSimulation.js" %>
</script>

