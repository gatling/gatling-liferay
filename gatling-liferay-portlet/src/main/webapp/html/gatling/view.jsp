<%-- 
	Copyright 2015 Altendis, Groupe Excilys (www.altendis.fr)
--%>
<%@include file="/html/gatling/header.jsp"%>


<%-- Header --%>

<liferay-ui:header title="Default Simulations"></liferay-ui:header>

<%-- FAQ link --%> 
<div class="well well-small">
	<%-- Wiki Gatling Link --%>
	<a target="blank" href='<%=PortletProps.get("gatling-wiki") %>' class="label label-warning">
		<i class="icon-share"></i>
		<liferay-ui:message key="help-gatling-wiki" />
	</a> 

	<%-- Advanced View Link --%>
	<portlet:renderURL var="renderAdvancedView">
		<portlet:param name="render" value="renderAdvancedView" />
	</portlet:renderURL>
	<a href="${renderAdvancedView}" class="label label-info">
		<i class="icon-wrench"></i> 
		Advanced Test Loading
	</a> 
	
	<portlet:actionURL var="debugButton1">
		<portlet:param name="action" value="debugYann" />
	</portlet:actionURL>

	<portlet:resourceURL id="generateZip" var="resourceUrl" />

	<a href="${debugButton1}" class="label label-success">
		<i class="icon-heart"></i> 
		Yann
	</a>       
    
	<portlet:actionURL var="debugButton2">
		<portlet:param name="action" value="debugNico" />
	</portlet:actionURL>

	<a href="${debugButton2}" class="label label-danger">
		<i class="icon-fire"></i> 
		Nico
	</a>
	
	
</div>

<%-- NavBar --%>
<div class="navbar">
	<div class="navbar-inner">
		<ul class="nav">
			<li>
				<a id="exportToggle" href="${resourceUrl}"><i class="icon-print"></i> Export the simulation</a>
			</li>
		</ul>
	</div>
</div>

<aui:fieldset class="fieldset">
	<aui:input name="simulationId" type="hidden" value="${simulation.simulation_id }" />
	<aui:button type="submit" value="Save the Scenario" cssClass="pull-right" />

	<legend class="fieldset-legend">
		<span class="legend">Scenario</span>
	</legend>

	<div class="user-strory" >
		<div class="scenario">Login</div>
		<div class="icon-chevron-right"></div>
		<div class="scenario">Random Page</div>
		<div class="icon-chevron-right"></div>
		<div class="scenario">Logout</div>
	</div>
	
</aui:fieldset>


<%-- Simulation Form --%>
<aui:fieldset label="Details">
	<aui:select label="simulation-edit-form-sites" name="Site" required="true">
		<c:forEach var="group" items="${listGroup}">
			<aui:option label="${group.descriptiveName}" value="${group.groupId}" />
		</c:forEach>
	</aui:select>

	<aui:input label="scenario-edit-nb-users-per-second"
		name="scenarioUsers" value="${scenario.numberOfUsers}"
		inlineField="true" helpMessage="nbuser-info-help">
		<aui:validator name="required" />
		<aui:validator name="number" />
		<aui:validator name="min">1</aui:validator>
	</aui:input>

	<aui:input label="scenario-edit-duration" name="Ramp over duration"
		value="${scenario.duration}" inlineField="true"
		helpMessage="duration-info-help">
		<aui:validator name="required" />
		<aui:validator name="number" />
		<aui:validator name="min">1</aui:validator>
	</aui:input>
	
</aui:fieldset>

<aui:fieldset label="Login Feeder">
		<c:choose>
			<c:when test="${not simulation.isFeederAFile }">
				<aui:input name="manualUsers"
					label="write-one-account-and-password-per-line" type="textarea"
					cssClass="textarea-feeder" value="${simulation.feederContent }"></aui:input>
			</c:when>
			
			<c:otherwise>
				<aui:input name="manualUsers"
					label="write-one-account-and-password-per-line" type="textarea"
					cssClass="textarea-feeder" disabled="${simulation.isFeederAFile }"></aui:input>
			</c:otherwise>
		</c:choose>
</aui:fieldset>



<style>

.user-story {
	
}

.scenario {
	display:inline-block;
	background: #ffdd99; 
	height: 60px;
	line-height: 60px;
	margin: 15px;
	padding: 0px 20px;
	border-radius: 10px;
	text-align: center;
}


</style>
            
