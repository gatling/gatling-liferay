<%-- 
	Copyright 2015 Altendis, Groupe Excilys (www.altendis.fr)
--%>
<%@include file="/html/gatling/header.jsp"%>


<%-- CSS --%>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/view.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/wan-spinner.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/drag-and-drop.css">


<%-- COWDE --%>

<%-- Tabs --%>
<portlet:renderURL var="renderRecorderView">
	<portlet:param name="render" value="renderRecorderView" />
</portlet:renderURL>

<liferay-ui:tabs names="Scenario Builder,Recorder" param="tabs" refresh="false" url1="${renderRecorderView}"> 
<liferay-ui:section>


<%-- Top Menu --%>
<div id="menus">

	<%--Take a tour view link --%>
	<a href="#" class="btn" onclick="tourDefaultFirstSimu.start();">
		<i class="icon-list-alt"></i> <liferay-ui:message key="take-a-tour" />
	</a> 

	<%-- Old Interfae --%>
	<portlet:renderURL var="renderAdvancedView">
		<portlet:param name="render" value="renderAdvancedView" />
	</portlet:renderURL>
	<a href="${renderAdvancedView}" id="advancedButon" class="btn"> <i
		class="icon-wrench"></i> <liferay-ui:message key="advanced-test-btn"/>
	</a>

	<%-- Wiki Gatling Link --%>
	<a target="blank" href='<%=PortletProps.get("gatling-wiki")%>'
		class="btn">
		<i class="icon-share"></i> <liferay-ui:message key="help-gatling-wiki" />
	</a> 

</div>

<%-- Simulation Form --%>

<portlet:actionURL var="saveDefaultSimulation">
	<portlet:param name="action" value="saveDefaultSimulation" />
</portlet:actionURL>

<portlet:actionURL var="saveScenariosURL">
	<portlet:param name="action" value="saveScenarios" />
</portlet:actionURL>

<aui:form action="${saveScenariosURL}" method="post">
	<%-- Scenario FieldSet --%>
	<aui:fieldset class="fieldset">
	
	<input name="<%=renderResponse.getNamespace()%>JSON" id="JSON" type="hidden" value="coucou" />
	<input id="COUNTER" type="hidden" value="${counter}"/>
		
	<%-- Scenario Title --%>
	<legend class="fieldset-legend">
		<span class="legend">1.Design your scenarios</span>
	</legend>


	<%-- Scenario --%>
	<c:forEach items="${scenarios}" var="scenario" varStatus="s">
		<div class="scenario" >
		
			<div class="scenario-box" >
				<input type="checkbox">
			</div>
			
			<div class="scenario-name" >
				${scenario.name}
			</div>

			<div class="workflow" id="wf_${scenario.id}">
			<c:forEach items="${scenario.processes}" var="process" varStatus="i">
				<div class="blockus" id="_box${process.cssId}" draggable="true" ondragstart="drag(event)">
					<div class="space-container">
							<div class="icon-chevron-right" style="display: inline-block;"></div>
					</div>
					
					<c:choose >
						<c:when test="${process.isPause()}">
						<div class="pause">
							<div class="pause-name process-font">Pause</div>
							<div class="wan-spinner time process-font">
							<a href="javascript:void(0)" class="minus" draggable="false">-</a>
								<input type="text" class="process-fond" name="<%=renderResponse.getNamespace()%>" value="${process.getPause()}"><span class="process-font">s</span>
							<a href="javascript:void(0)" class="plus" draggable="false">+</a>
							</div>
						</div>
						</c:when>
						<c:otherwise>
							<div class="action process-font activeprocess">${process.name}</div>
						</c:otherwise>
					</c:choose>
				</div>
				
				</c:forEach>
				<div class="blockus" id="endBlock">
					<div class="space-container" id="endSC">
							<div class="icon-chevron-right" style="display: inline-block;"></div>
					</div>
				</div>
				
			</div>
			<div id ="takeATourAnchor" style="display: inline-block;"></div>
		</div>
	</c:forEach>
	
	<%-- Fresh Scenario Link --%>
	<div class="fresh-scenario">
 		<%-- This box contains nothing: it is a used for placement --%>
		<div class="scenario-box"></div>
		<div class="scenario-name">

			<portlet:actionURL var="persistNewScenario">
				<portlet:param name="action" value="persistNewScenario"/>
			</portlet:actionURL>

			<a href="${persistNewScenario}"><span class="icon-plus-sign"></span> Add a new scenario</a>
		</div>
	</div>

	<%-- Library, not filled with books but with Processes --%>
	<div class="library">
		<h4>Process Library:</h4>
		
		<%-- Processes --%>
		<c:forEach items="${templates}" var="template" varStatus="i">	
			<div class="blockus template" id ="_box${template.cssId}" draggable="true" ondragstart="drag(event)">
				<div class="space-container">
					<div class="icon-chevron-right" style="display: inline-block;"></div>
				</div>
			
				<c:choose >
					<c:when test="${template.isPause()}">
						<div class="pause">
							<div class="pause-name process-font">Pause</div>
							<div class="wan-spinner time process-font">
							<a href="javascript:void(0)" class="minus">-</a>
								<input type="text" class="process-fond" name="<%=renderResponse.getNamespace()%>" value="${template.getPause()}"><span class="process-font">s</span>
								<a href="javascript:void(0)" class="plus">+</a>
							</div>
						</div>
					</c:when>
					<c:otherwise>
						<div class="action process-font activeprocess">${template.name}</div>
					</c:otherwise>
				</c:choose>
		
			</div>
		</c:forEach>
	</div>
	
		<aui:button type="submit" value="Save scenarios" cssClass="pull-left" style="margin-top:7px;" />

	</aui:fieldset>
	</aui:form>


<aui:form action="${saveDefaultSimulation}" method="post">

	<%-- Details Fieldset --%>
	<aui:fieldset label="2.Configure your injection profile">
		<aui:input name="simulationId" type="hidden" value="${simulationId}" />
		
		<aui:input label="scenario-edit-nb-users-per-second"
			name="numberOfUsers" value="${numberOfUsers}" inlineField="true"
			helpMessage="nbuser-info-help">
			<aui:validator name="required" />
			<aui:validator name="number" />
			<aui:validator name="min">1</aui:validator>
		</aui:input>
		
		<aui:select label="injection" name="injectionMode"
			required="true"  inlineField="true" helpMessage="injection-info-help">
			<c:forEach var="mode" items="${injections}">
				<c:set var="isSelected" scope="request"
					value="${mode eq 'ramp Over'}" />
				<aui:option label="${mode}"
					value="${mode}" selected="isSelected" />
			</c:forEach>
		</aui:select>

		<aui:input label="duration" name="rampUp" value="${rampUp}"
			inlineField="true" helpMessage="duration-info-help">
			<aui:validator name="required" />
			<aui:validator name="number" />
			<aui:validator name="min">1</aui:validator>
		</aui:input>
		
	</aui:fieldset>

	
	<%-- Login Feeder Fieldset --%>
	<aui:fieldset label="3.Specify your feeders">
		<aui:input name="feederContent"
			label="write-one-account-and-password-per-line" type="textarea"
			cssClass="textarea-feeder" value="${feederContent}"></aui:input>

	</aui:fieldset>
	
	<%-- Login Feeder Fieldset --%>
	<aui:fieldset label="4.Let's export and run with Gatling">
		<%-- Submit/Save Button --%>
		<aui:button type="submit" value="Save the simulation"
			cssClass="pull-left" />
		<portlet:resourceURL id="generateZip" var="resourceUrl" />
		<aui:button type="button" value="Export the simulation" id="generateZip" onClick="${resourceUrl}" />
	</aui:fieldset>	
</aui:form>




    </liferay-ui:section>
    <liferay-ui:section>
    </liferay-ui:section>
</liferay-ui:tabs>

<%-- JS --%>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.1.0.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/wan-spinner.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/wan-spinner-launch.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/drag-and-drop.js"></script>

<script type="text/javascript">
	var myJson = [{"name":"_default_scenario_","id":3501,"processes":
					[{"name":"Login","cssId":"0","cssClass":"4001","type":"LOGIN","pause":-42},
					 {"name":"Pause","cssId":"1","cssClass":"Pause","type":"PAUSE","pause":5},
					 {"name":"Random Page","cssId":"2","cssClass":"4002","type":"RANDOMPAGE","pause":-42},
					 {"name":"Pause","cssId":"3","cssClass":"Pause","type":"PAUSE","pause":10},
					 {"name":"Pause","cssId":"4","cssClass":"Pause","type":"PAUSE","pause":10},
					 {"name":"Login","cssId":"5","cssClass":"4001","type":"LOGIN","pause":-42},
					 {"name":"Logout","cssId":"6","cssClass":"4003","type":"LOGOUT","pause":-42}]
				}];
	document.getElementById('JSON').value = JSON.stringify(myJson);
</script>


<script type="text/javascript" >
<%@ include file="/js/defaultTourSimulation.js" %>
</script>
