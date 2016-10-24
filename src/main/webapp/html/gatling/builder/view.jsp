<%--

    Copyright 2011-2016 GatlingCorp (http://gatling.io)

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

    		http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

--%>
<%@include file="/html/gatling/header.jsp"%>


<%-- CSS --%>

<link rel="stylesheet" type="text/css" href="${css}/view.css">
<link rel="stylesheet" type="text/css" href="${css}/wan-spinner.css">
<link rel="stylesheet" type="text/css" href="${css}/drag-and-drop.css">




<%-- COWDE --%>


<%-- Tabs --%>
<portlet:renderURL var="renderRecorderView">
	<portlet:param name="render" value="renderRecorderView" />
</portlet:renderURL>

<portlet:actionURL  var="deleteScenarioURL">
	<portlet:param name="action" value="deleteScenarios" />
</portlet:actionURL>


<liferay-ui:tabs names="Scenario Builder,Recorder" param="tabs" refresh="false" url1="${renderRecorderView}"> 

	<%-- 
		This section represents the builder Page
	 --%>
	<liferay-ui:section>

		<%@include file="/html/gatling/menuButtons.jsp"%>

		<%-- Simulation Form --%>
		<portlet:actionURL var="saveScenariosURL">
			<portlet:param name="action" value="saveScenarios" />
		</portlet:actionURL>
		
		
		<%-- Scenario building block --%>
		<liferay-ui:panel-container extended="true" id="scenarioBlock">
			<liferay-ui:panel id="design-scenario" collapsible="true" defaultState="${panel1State}"  title="section-title1" >
		
				<aui:form action="${saveScenariosURL}"  name="formS" cssClass="form-inline">
					<%-- Scenario FieldSet --%>
					
					<input name="<%=renderResponse.getNamespace()%>JSON" id="JSON" type="hidden" value="notDefined" />
					<input id="COUNTER" type="hidden" value="${counter}"/>
					<aui:input name="scenarioId" id="scenarioId" type="hidden" value="notDefined"/>
					
					
					<%-- Header line --%>
					
					<div class="scenario-header">
						<div class="scenario-box" ></div>
						<div class="scenario-name" ><liferay-ui:message key="scenario-header-name" /></div>
						<div class="workflow" ><liferay-ui:message key="scenario-header-workflow" /></div>
						<div class="scenario-legend">
							<span>
								<liferay-ui:message key="legend-title" />
							</span>
							<span class="cbox blue"></span>
							<span>
								<liferay-ui:message key="legend-defaults" />
							</span>
							<span class="cbox yellow"></span>
							<span>
								<liferay-ui:message key="legend-pauses" />
							</span>
							<span class="cbox red"></span>
							<span>
								<liferay-ui:message key="legend-random" />
							</span>
							<span class="cbox green"></span>
							<span>
								<liferay-ui:message key="legend-recorded" />
							</span>
						</div>
					</div>
					
					<%-- Scenario --%>
					<c:forEach items="${scenarios}" var="scenario" varStatus="s">
						<div class="scenario" id="_sc${scenario.id}" >
						
							<div class="scenario-box" >
								<c:if test="${scenarios.size() > 1}">
								<a href="#" onclick="setScenarioId(${scenario.id}); console.log('<portlet:namespace/>'); $(this).closest('form').submit()" >
										<i class="icon-trash"></i>
								</a>
								</c:if>
							</div>
							
							<div class="scenario-name" >
								<aui:input label="" name="scenario_${scenario.id}name" value="${scenario.name}" inlineField="true" class="inputName">
									<aui:validator name="custom" errorMessage="simulation-name-syntaxe">
											function (val, fieldNode, ruleValue) {
												return /^[\w\s$]+$/.test(val);
											}
									</aui:validator>
								</aui:input>
							</div>
				
							<div class="workflow" id="wf_${s.index}">
							<c:forEach items="${scenario.processes}" var="process" varStatus="i">
								<div class="blockus _p${process.cssClass} _ty${process.type}" id="_box${process.cssId}" draggable="true" ondragstart="drag(event)" ondragend="endDrag(event)">
									<div class="space-container">
											<div class="icon-chevron-right" style="display: inline-block;"></div>
									</div>
									
									<c:choose >
										<c:when test="${process.isPause()}">
										<div class="pause">
											<div class="pause-name process-font">Pause</div>
											<div class="wan-spinner time process-font">
											<a href="javascript:void(0)" class="minus" draggable="false">-</a>
												<input type="text" class="process-fond time-input" name="<%=renderResponse.getNamespace()%>" value="${process.getPause()}"><span class="process-font">s</span>
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
								<div class="space-container endSC" id="endSC_${scenario.id}">
										<div class="icon-chevron-right" style="display: inline-block;"></div>
								</div>
							</div>
							
							</div>
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
				
							<a href="${persistNewScenario}"><span class="icon-plus-sign"></span> <liferay-ui:message key="add-scenario"/></a>
						</div>
					</div>
				
					<%-- Library, not filled with books but with Processes --%>
					<div class="library">
						<div id="trashcan" class="hide-trashcan trashcan" ><div class="icon-remove-sign"></div></div>
						
						<div class="libcontent">
							<h4><liferay-ui:message key="process-library"/></h4>
							
							<div class="btn-group">
							  <a class="btn btn-primary dropdown-toggle" id="add-process" data-toggle="dropdown">
							    <span class="icon-plus-sign"></span>
							    <liferay-ui:message key="add-process"/>
							    <span class="caret"></span>
							  </a>
								<ul class="dropdown-menu pull-right" role="menu" aria-labelledby="dropdownMenu">
									
							      	<li><a tabindex="-1" href="${renderRecorderView}">Record Process</a></li>
							      
							      	<portlet:renderURL var="renderSiteMap">
										<portlet:param name="render" value="renderSiteMap" />
									</portlet:renderURL>
							      	<li><a tabindex="-1" href="${renderSiteMap}">Random Process</a></li>
							    </ul>
							</div>
							
							<%-- Processes --%>
							<div class="libprocesses">
								<c:forEach items="${templates}" var="template" varStatus="i">	
									<div class="blockus template _p${template.cssClass} _ty${template.type}" id ="_box${template.cssId}" draggable="true" ondragstart="drag(event)" ondragend="endDrag(event)">
										<div class="space-container">
											<div class="icon-chevron-right" style="display: inline-block;"></div>
										</div>
									
										<c:choose >
											<c:when test="${template.isPause()}">
												<div class="pause">
													<div class="pause-name process-font">Pause</div>
													<div class="wan-spinner time process-font">
													<a href="javascript:void(0)" class="minus" draggable="false">-</a>
														<input type="text" class="process-fond time-input" name="<%=renderResponse.getNamespace()%>" value="${template.getPause()}"><span class="process-font">s</span>
														<a href="javascript:void(0)" class="plus" draggable="false">+</a>
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
						</div>
						
					</div>
				
					
					<aui:fieldset>
						<aui:button type="submit" value="save-scenarios" id="save-scenarios" style="margin-top: 30px" />
					</aui:fieldset>
				</aui:form>
			</liferay-ui:panel>
		</liferay-ui:panel-container>
		
		
		
		<portlet:actionURL var="saveInjectionProfile">
			<portlet:param name="action" value="saveInjectionProfile" />
		</portlet:actionURL>
		
		
		<liferay-ui:panel-container extended="true" id="injectionBlock">
			<liferay-ui:panel collapsible="true"  extended="true" defaultState="${panel2State}"  title="section-title2" >
			
				<!-- Injection profile block -->
				<aui:form action="${saveInjectionProfile}" method="post">
				
					<%-- Details Fieldset --%>
					
					
						<aui:input name="simulationId" type="hidden" value="${simulationId}" />
						
						<aui:input label="scenario-edit-nb-users-per-second"
							name="numberOfUsers" value="${numberOfUsers}" inlineField="true"
							helpMessage="nbuser-info-help">
							<aui:validator name="required" />
							<aui:validator name="number" />
							<aui:validator name="min">1</aui:validator>
						</aui:input>
						
						<aui:select label="injection-mode" name="injectionMode"
							required="true"  inlineField="true" helpMessage="injection-info-help">
							<c:forEach var="mode" items="${injections}">
								<c:set var="isSelected" scope="request" value="${mode eq currentInjection}" />
								<aui:option label="${mode}"
									value="${mode}" selected="${isSelected}" />
							</c:forEach>
						</aui:select>
				
						<aui:input label="duration-rampUp" name="rampUp" value="${rampUp}"
							inlineField="true" helpMessage="duration-info-help">
							<aui:validator name="required" />
							<aui:validator name="number" />
							<aui:validator name="min">1</aui:validator>
						</aui:input>
						
					
					<aui:fieldset>
						<aui:button type="submit" value="save-injection"/>
					</aui:fieldset>
					
				</aui:form>
			</liferay-ui:panel>
		</liferay-ui:panel-container>
		
		
		<!-- Feeder block -->
		<liferay-ui:panel-container extended="true" id="FeederBlock">
			<liferay-ui:panel collapsible="true" defaultState="${panel3State}"  title="section-title3" >
			 
				<portlet:actionURL var="saveFeeders">
					<portlet:param name="action" value="saveFeeders" />
				</portlet:actionURL>
				
				<aui:form action="${saveFeeders}" method="post">
					<%-- Login Feeder Fieldset --%>
					<aui:input name="simulationId" type="hidden" value="${simulationId}" />
					<aui:input name="feederContent"
						label="write-one-account-and-password-per-line" type="textarea"
						cssClass="textarea-feeder" value="${feederContent}"/>
							
					<aui:fieldset>
						<aui:button type="submit" value="save-feeders" />
					</aui:fieldset>
				</aui:form>
			</liferay-ui:panel>
		</liferay-ui:panel-container>
		
		
		<liferay-ui:panel-container extended="true" id="exportBlock">
			<liferay-ui:panel collapsible="true" defaultState="${panel4State}"  title="section-title4" >
				<portlet:resourceURL id="generateZip" var="resourceUrl" />
				<aui:button type="button" value="export-simulation" id="generateZip" onClick="${resourceUrl}" />
			</liferay-ui:panel>
			
			<%-- Do not remove this comment! --%>
			<!-- ${simulationContent} -->
			
		</liferay-ui:panel-container>
    </liferay-ui:section>
    
    
    
    <%--
    	This section represents the recorder section.
    	It has no content because the recorder tab acts as a link to the recorder page.
     --%>
    <liferay-ui:section></liferay-ui:section>
    
    
    
</liferay-ui:tabs>




<%-- JS --%>

<script type="text/javascript" src="${js}/jquery-3.1.0.min.js"></script>
<script type="text/javascript" src="${js}/bootstrap.min.js"></script>

<script type="text/javascript" >
	<%@ include file="/js/scenario-persistence.js" %>
</script>

<script type="text/javascript" >
	<%@ include file="/js/injectionMode.js" %>
</script>

<script type="text/javascript" src="${js}/wan-spinner.js"></script>
<script type="text/javascript" src="${js}/wan-spinner-launch.js"></script>

<script type="text/javascript" >
	<%@ include file="/js/drag-and-drop.js" %>
</script>

<%-- Must be included this way to use liferay taglibs --%>
<script type="text/javascript" >
	<%@ include file="/js/defaultTourSimulation.js" %>
</script>
