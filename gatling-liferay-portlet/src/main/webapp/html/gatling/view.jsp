<%-- 
	Copyright 2015 Altendis, Groupe Excilys (www.altendis.fr)
--%>
<%@include file="/html/gatling/header.jsp"%>


<%-- CSS --%>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/view.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/wan-spinner.css">


<%-- COWDE --%>

<%-- Tabs --%>

<liferay-ui:tabs names="Scenario Builder,Recorder" refresh="false">
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

<aui:form action="${saveDefaultSimulation}" method="post">

	<%-- Scenario FieldSet --%>
	<aui:fieldset class="fieldset">
	
		<aui:input name="simulationId" type="hidden" value="${simulationId}" />
		
		<%-- Scenario Title --%>
		<legend class="fieldset-legend">
			<span class="legend">1.Design your scenarios</span>
		</legend>


		<%-- Scenario --%>
		<div class="scenario" >
		
			<div class="scenario-box" >
				<input type="checkbox">
			</div>
			
			<div class="scenario-name" >
				Default Scenario
			</div>
		
			<div class="workflow" >
				<c:forEach items="${processes}" var="process" varStatus="i">
					<div class="action process-font">${process.name}</div>

					<c:if test="${!i.last}" >
						<div class="time-separator-container">
							<div class="time-separator">
								<div class="icon-chevron-right"></div>
							</div>
						</div>
						
						<div class="pause">
								<div class="pause-name process-font">Pause</div>
								<div class="wan-spinner time process-font">
									<a href="javascript:void(0)" class="minus">-</a>
    								<input type="text" class="process-fond" name="<%=renderResponse.getNamespace()%>${process.process_id}" value="${process.pause}"><span class="process-font">s</span>
    								<a href="javascript:void(0)" class="plus">+</a>
								</div>
						</div>
							
						<div class="time-separator-container">
							<div class="time-separator">
								<div class="icon-chevron-right"></div>
							</div>
						</div>
						
					</c:if>
				</c:forEach>
			</div>
			
			<div id ="takeATourAnchor" style="display: inline-block;"></div>
		</div>
		

	</aui:fieldset>


	<%-- Details Fieldset --%>
	<aui:fieldset label="2.Configure your injection profile">
	
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
         <%@ include file="smoothRecorderView.jsp" %>
    </liferay-ui:section>
</liferay-ui:tabs>



<%-- JS --%>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.1.0.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/wan-spinner.js"></script>

<script type="text/javascript">
  $(document).ready(function() {
    var options = {
      maxValue: 99,
      minValue: 0,
      step: 1,
      start: 2,
      plusClick: function(val) {
        console.log(val);
      },
      minusClick: function(val) {
        console.log(val);
      },
      exceptionFun: function(val) {
        console.log("excep: " + val);
      },
      valueChanged: function(val) {
        console.log('change: ' + val);
      }
    }
    $(".time").WanSpinner(options);
  });
</script>



<script type="text/javascript" >
<%@ include file="/js/defaultTourSimulation.js" %>
</script>
