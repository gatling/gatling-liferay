<%-- 
	Copyright 2015 Altendis, Groupe Excilys (www.altendis.fr)
--%>
<%@include file="/html/gatling/header.jsp"%>


<style>

.action {
	display: inline-block;
	background: #ffdd99;
	height: 60px;
	line-height: 60px;
	margin: 15px 20px;
	padding: 0px 20px;
	border-radius: 10px;
	text-align: center;
}

.time-separator-container {
	display: inline-block ;
	height: 60px;
	text-align: center;
}

.time-separator {
	vertical-align: middle;
	display: inline-block;
}

</style>


<%-- Title --%>
<liferay-ui:header title="default-simulations"></liferay-ui:header>


<%-- Top Menu --%>
<div class="well well-small">

	<%-- Wiki Gatling Link --%>
	<a target="blank" href='<%=PortletProps.get("gatling-wiki")%>'
		class="label label-warning">
		<i class="icon-share"></i> <liferay-ui:message key="help-gatling-wiki" />
	</a>

	<%-- Advanced View Link --%>
	<portlet:renderURL var="renderAdvancedView">
		<portlet:param name="render" value="renderAdvancedView" />
	</portlet:renderURL>
	<a href="${renderAdvancedView}" id="advancedButon" class="label label-info"> <i
		class="icon-wrench"></i> <liferay-ui:message key="advanced-test-btn"/>
	</a>
	
	<%--Take a tour view link --%>
	<a href="#" class="label label-success" onclick="tourDefaultFirstSimu.start();">
		<i class="icon-list-alt"></i> <liferay-ui:message key="take-a-tour" />
	</a> 

</div>


<%-- NavBar --%>
<div class="navbar">
	<div class="navbar-inner">
		<ul class="nav">
			<li>
				
				<%-- Export Button --%>
				<portlet:resourceURL id="generateZip" var="resourceUrl" />
				<a id="exportToggle" href="${resourceUrl}">
					<i class="icon-print"></i><liferay-ui:message key="simulation-export"/>
				</a>
				
			</li>
		</ul>
	</div>
</div>


<%-- Simulation Form --%>

<portlet:actionURL var="saveDefaultSimulation">
	<portlet:param name="action" value="saveDefaultSimulation" />
</portlet:actionURL>

<aui:form action="${saveDefaultSimulation}" method="post">

	<%-- Scenario FieldSet --%>
	<aui:fieldset class="fieldset">
	
		<aui:input name="simulationId" type="hidden" value="${simulationId}" />
		
		<%-- Submit/Save Button --%>
		<aui:button type="submit" value="save-scenario"
			cssClass="pull-right" />

		<%-- Scenario Title --%>
		<legend class="fieldset-legend">
			<span class="legend">Scenario</span>
		</legend>


		<%-- Scenario --%>
		<div class="scenario" >
		
			<div class="action"><liferay-ui:message key="login"/></div>

			<div class="time-separator-container">
				<div class="time-separator">
					<div class="icon-chevron-right"></div>
					<div class="time">3s</div>
				</div>
			</div>

			<div class="action" id="scenario-flow"><liferay-ui:message key="random-page"/></div>

			<div class="time-separator-container">
				<div class="time-separator">
					<div class="icon-chevron-right"></div>
					<div class="time">3s</div>
				</div>
			</div>

			<div class="action"><liferay-ui:message key="logout"/></div>
		</div>

	</aui:fieldset>


	<%-- Details Fieldset --%>
	<aui:fieldset label="details">
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

		<aui:input label="ramp-over-duration" name="rampUp" value="${rampUp}"
			inlineField="true" helpMessage="duration-info-help">
			<aui:validator name="required" />
			<aui:validator name="number" />
			<aui:validator name="min">1</aui:validator>
		</aui:input>

	</aui:fieldset>

	
	<%-- Login Feeder Fieldset --%>
	<aui:fieldset label="login-feeder">
		<aui:input name="feederContent"
			label="write-one-account-and-password-per-line" type="textarea"
			cssClass="textarea-feeder" value="${feederContent}"></aui:input>

	</aui:fieldset>
	
</aui:form>


<script type="text/javascript">
<%@ include file="/js/defaultTourSimulation.js" %>
</script>
