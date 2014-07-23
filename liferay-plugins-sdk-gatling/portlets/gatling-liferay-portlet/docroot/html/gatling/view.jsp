<%@include file="/html/gatling/header.jsp"%>

<liferay-ui:header title="simulation-list-header"></liferay-ui:header>

<%--
	lien vers la FAQ 
--%>
<div class="well well-small">
	<a target="blank" href="https://github.com/excilys/gatling/wiki/Getting-Started">
		<span class="label label-warning"><liferay-ui:message key="help-faq-gatling"/></span>
	</a>
	<a target="blank" href="#">
	<span class="label"><liferay-ui:message key="help-how-to-use-portlet"/></span>
	</a>
	<a target="blank" href="#">
	<span class="label label-info"><liferay-ui:message key="help-what-simulation"/></span>
	</a>
</div>
<%--
	session errors
--%>
<liferay-ui:error key="simulation-name-required"
	message="simulation-name-required" />
<%--
	Search container (tableau) 
--%>
<liferay-ui:search-container emptyResultsMessage="simulation-list-empty">
	<%--Liste sur laquelle on travail --%>
	<liferay-ui:search-container-results results="${listSimulation }"
		total="${listSimulation.size() }" />
	<%--itération des colonnes --%>
	<liferay-ui:search-container-row
		className="com.liferay.sample.model.Simulation"
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
		<%--menu action --%>
		<liferay-ui:search-container-column-jsp align="right"
			path="/html/gatling/simulation_actions.jsp" />
	</liferay-ui:search-container-row>
	<%--itere et affiche la liste --%>
	<liferay-ui:search-iterator />
</liferay-ui:search-container>

<aui:button id="newSimulation"
	value="simulation-list-btn-add-simulation"></aui:button>

<%--submit to addSimulation --%>
<portlet:actionURL name="addSimulation" var="addSimulationURL"
	windowState="normal" />
<%--Formulaire d'ajout --%>
<div id="newFormSimulation" hidden="true">
	<liferay-ui:icon-help message="About this page" ><liferay-ui:message key="create-simulation-help" /></liferay-ui:icon-help>
	<aui:form action="${addSimulationURL}" name="simulation_fm"
		id="simulation_fm">
		<aui:input label="simulation-list-form-nom-simulation" name="simulationName" id="simulationName">
			<aui:validator name="required"></aui:validator>
			<aui:validator name="alphanum"></aui:validator>
			
		</aui:input>
		<aui:input label="simulation-list-form-variable-name" name="variableName" id="variableName" prefix="simulation" readonly="readonly">
			<aui:validator name="required"></aui:validator>
		</aui:input>
		<aui:button type="submit"></aui:button>
	</aui:form>
</div>

<script type="text/javascript">
YUI().use(
  'aui-modal',
  function(Y) {
    var modal = new Y.Modal(
      {
        bodyContent: AUI().one("#newFormSimulation").html(),
        centered: true,
        headerContent: '<h3><liferay-ui:message key="simulation-list-form-header" /></h3>',
        modal: true,
        resizable: false,
        visible: false,
        zIndex: 100,
        width: 450
      }
    ).render();
    
    Y.one('#newSimulation').on(
      'click',
      function() {
        modal.show();
      }
    );
  }
);

AUI().use(
	'aui-base',
	'event',
	function(A) {
		A.one("#<portlet:namespace />simulationName").on("keyup", function(e) {
			A.one("#<portlet:namespace />variableName").val(this.val().replace(/\W/g, ''));
		});
	}
);
</script>
