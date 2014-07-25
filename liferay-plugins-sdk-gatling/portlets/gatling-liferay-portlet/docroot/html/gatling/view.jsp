<%@include file="/html/gatling/header.jsp"%>

<%-- <% --%>
<!-- // 	boolean hasAddPermission = permissionChecker.hasPermission( -->
<!-- // 	scopeGroupId, "com.excilys.liferay.gatling.model.Simulation", -->
<!-- // 	scopeGroupId, "ADD_SIMULATION"); -->
<!-- // 		boolean hasConfigurePermission = permissionChecker.hasPermission( -->
<!-- // 	scopeGroupId, "com.excilys.liferay.gatling.model.Simulation", scopeGroupId, -->
<!-- // 	ActionKeys.PERMISSIONS); -->
		
<!-- // 		hasAddPermission = hasConfigurePermission = true; -->
<%-- %> --%>


<%--
	session errors
--%>
<liferay-ui:error key="simulation-name-required"
	message="simulation-name-required" />
<liferay-ui:error key="simulation-name-already-used"
	message="simulation-name-already-used" />
<liferay-ui:error key="simulation-variable-required"
	message="simulation-variable-required" />
<liferay-ui:error key="simulation-variable-syntaxe"
	message="simulation-variable-syntaxe" />
<%--
	Header
 --%>

<liferay-ui:header title="simulation-list-header"></liferay-ui:header>

<%--
	lien vers la FAQ 
--%>
<portlet:renderURL var="helpURL">
	<portlet:param name="page" value="/html/gatling/help.jsp" />
</portlet:renderURL>
<div class="well well-small">
	<a target="blank"
		href="https://github.com/excilys/gatling/wiki/Getting-Started"> <span
		class="label label-warning"><liferay-ui:message
				key="help-faq-gatling" /></span>
	</a> <a href="${helpURL}"> <span class="label"><liferay-ui:message
				key="help-how-to-use-portlet" /></span>
	</a> <a href="#" class="toggle" data-content="help-simulation"> <span
		class="label label-info"><liferay-ui:message
				key="help-what-simulation" /></span>
	</a>
</div>

<div id="help-simulation"
	class="alert alert-info help-text help-content-hidden">
	<liferay-ui:message key="simulation-explanation" />
</div>
<%--
	Search container (tableau) 
--%>
<liferay-ui:search-container emptyResultsMessage="simulation-list-empty">
	<%--Liste sur laquelle on travail --%>
	<liferay-ui:search-container-results results="${listSimulation }"
		total="${listSimulation.size() }" />
	<%--itération des colonnes --%>
	<liferay-ui:search-container-row
		className="com.excilys.liferay.gatling.model.Simulation"
		keyProperty="simulation_id" modelVar="simulation">
		<portlet:renderURL var="editSimulationURL">
			<portlet:param name="page" value="/html/gatling/editSimulation.jsp" />
			<portlet:param name="simulationId"
				value="${simulation.simulation_id }" />
		</portlet:renderURL>
		<%--un champs texte --%>
		<liferay-ui:search-container-column-text
			name="simulation-list-table-header-name" value="${simulation.name }"
			href="${editSimulationURL}" />
		<liferay-ui:search-container-column-text
			name="simulation-list-table-header-scenarionb" value="${MapSimulation.get(simulation)[0] }" />
		<liferay-ui:search-container-column-text
			name="simulation-list-table-header-state" > 
			<c:choose>
				<c:when test="${MapSimulation.get(simulation)[1] == 2}">
					<span class="label label-success"> <liferay-ui:message key="message-success-state-simulation"/></span><liferay-ui:icon-help message="message-help-info-state-simulation-success"/>
				</c:when>
				<c:when test="${MapSimulation.get(simulation)[1] == 1}">
					<span class="label label-warning"><liferay-ui:message key="message-warning-state-simulation"/></span><liferay-ui:icon-help message="message-help-info-state-simulation-warning"/>
				</c:when>
				<c:otherwise>
					<span class="label label-important"><liferay-ui:message key="message-important-state-simulation"/></span> <liferay-ui:icon-help message="message-help-info-state-simulation-important"/>
				</c:otherwise>
			</c:choose>
		</liferay-ui:search-container-column-text>
			
		<%--menu action --%>
		<liferay-ui:search-container-column-jsp align="right"
			path="/html/gatling/simulation_actions.jsp" />
	</liferay-ui:search-container-row>
	<%--itere et affiche la liste --%>
	<liferay-ui:search-iterator paginate="false" />
</liferay-ui:search-container>
<%-- If user has permission --%>
<%-- <c:if test="<%=hasAddPermission%>"> --%>
	<aui:button id="newSimulation"
		value="simulation-list-btn-add-simulation"></aui:button>
<%-- </c:if> --%>
<%--submit to addSimulation --%>
<portlet:actionURL name="addSimulation" var="addSimulationURL"
	windowState="normal" />
<%-- add simulation form --%>
<div id="newFormSimulation" >
	<aui:form action="${addSimulationURL}" name="fm" >
		<div class="well well-small">
			<p>
				<liferay-ui:icon-help message="About this page">
					<liferay-ui:message key="create-simulation-help" />
				</liferay-ui:icon-help>
			</p>
		</div>
		<aui:input label="simulation-list-form-name-simulation"
			name="simulationName">
			<aui:validator name="required" />
			<aui:validator name="alphanum" />
			<aui:validator name="custom" errorMessage="simulation-name-already-used">
			 		function (val, fieldNode, ruleValue) {
					var result = false;
					var list = ${listOfSimulationName};
					if (list.indexOf(val) == -1) {
						result = true;
					}
					return result;
				}
			</aui:validator>
		</aui:input>
		<aui:input label="simulation-list-form-variable-name"
			name="variableName" prefix="simulation"
			readonly="readonly">
		</aui:input>
		<aui:button type="submit"></aui:button>
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

		A.one("#<portlet:namespace />simulationName").on("keyup", function(e) {
			A.one("#<portlet:namespace />variableName").val(this.val().replace(/\W/g, ''));
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
