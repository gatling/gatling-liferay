<%-- 
	Copyright 2015 Altendis, Groupe Excilys (www.altendis.fr)
--%>
<%@include file="/html/gatling/header.jsp"%>


<%-- Header --%>

<liferay-ui:header title="Default Simulations"></liferay-ui:header>

<%-- FAQ link --%>
<div class="well well-small">
	<%-- Wiki Gatling Link --%>
	<a target="blank" href='<%=PortletProps.get("gatling-wiki")%>'
		class="label label-warning"> <i class="icon-share"></i> <liferay-ui:message
			key="help-gatling-wiki" />
	</a>

	<%-- Advanced View Link --%>
	<portlet:renderURL var="renderAdvancedView">
		<portlet:param name="render" value="renderAdvancedView" />
	</portlet:renderURL>
	<a href="${renderAdvancedView}" id="advancedButon" class="label label-info"> <i
		class="icon-wrench"></i> Advanced Test Loading
	</a>
	<a href="#" class="label label-success" onclick="tourDefaultFirstSimu.start();">
		<i class="icon-list-alt"></i> 
		<liferay-ui:message key="take-a-tour" />
	</a> 
	<portlet:resourceURL id="generateZip" var="resourceUrl" />


	
</div>

<%-- NavBar --%>
<div class="navbar">
	<div class="navbar-inner">
		<ul class="nav">
			
			<li>
				<portlet:resourceURL id="generateZip" var="resourceUrl" />
				<a id="exportToggle" href="${resourceUrl}"><i
					class="icon-print"></i> Export the simulation</a>
			</li>
		</ul>
	</div>
</div>

<portlet:actionURL var="saveDefaultSimulation">
	<portlet:param name="action" value="saveDefaultSimulation" />
</portlet:actionURL>

<aui:form action="${saveDefaultSimulation}" method="post">
	<aui:fieldset class="fieldset">
		<aui:input name="simulationId" type="hidden" value="${simulationId}" />
		<aui:button type="submit" value="Save the Scenario"
			cssClass="pull-right" />

		<legend class="fieldset-legend">
			<span class="legend">Scenario</span>
		</legend>

		<div class="user-strory" >
			<div class="scenario">Login</div>
			<div class="icon-chevron-right"></div>
			<div class="scenario" id="scenario-flow">Random Page</div>
			<div class="icon-chevron-right"></div>
			<div class="scenario">Logout</div>
		</div>

	</aui:fieldset>


	<%-- Simulation Form --%>
	<aui:fieldset label="Details">
		<aui:select label="simulation-edit-form-sites" name="scenarioGroupId"
			required="true">
			<c:forEach var="group" items="${listGroup}">
				<c:set var="isSelected" scope="request"
					value="${group.groupId eq scenarioGroupId}" />
				<aui:option label="${group.descriptiveName}"
					value="${group.groupId}" selected="isSelected" />
			</c:forEach>
		</aui:select>

		<aui:input label="scenario-edit-nb-users-per-second"
			name="numberOfUsers" value="${numberOfUsers}" inlineField="true"
			helpMessage="nbuser-info-help">
			<aui:validator name="required" />
			<aui:validator name="number" />
			<aui:validator name="min">1</aui:validator>
		</aui:input>

		<aui:input label="Ramp over duration" name="rampUp"
			value="${rampUp}" inlineField="true" helpMessage="duration-info-help">
			<aui:validator name="required" />
			<aui:validator name="number" />
			<aui:validator name="min">1</aui:validator>
		</aui:input>

	</aui:fieldset>

	<aui:fieldset label="Login Feeder">
		<aui:input name="feederContent"
			label="write-one-account-and-password-per-line" type="textarea"
			cssClass="textarea-feeder" value="${feederContent}"></aui:input>

	</aui:fieldset>
</aui:form>

<style>
.scenario {
	display: inline-block;
	background: #ffdd99;
	height: 60px;
	line-height: 60px;
	margin: 15px;
	padding: 0px 20px;
	border-radius: 10px;
	text-align: center;
}
</style>

<script type="text/javascript">
<%@ include file="/js/defaultTourSimulation.js" %>
</script>
