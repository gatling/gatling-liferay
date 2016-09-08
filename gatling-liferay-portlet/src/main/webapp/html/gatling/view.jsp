<%-- 
	Copyright 2015 Altendis, Groupe Excilys (www.altendis.fr)
--%>
<%@include file="/html/gatling/header.jsp"%>


<%-- CSS --%>
<style type="text/css">

	.library {
		width:100%;
		padding: 8px;
		padding-top:1px;
		background: rgba(0, 174, 255, 0.28);
	}
	
	.workflow .space-container {
		/*  background: red;*/
		display: inline-block;
		width: 20px;
		padding: 0px 10px;
	 	height: 80px;
		vertical-align: middle;
		text-align: center;
		line-height: 80px;
	}
	
	.library .space-container {
		visibility: hidden;
	}
	
	.blockus {
		display:inline-block;
	}

	.extented-space {
		display: inline-block;
		width: 150px;
		height: 80px;
		vertical-align: middle;
		text-align: center;
		line-height: 80px;
 		opacity: 0; 
	}
	.extented-space .icon-chevron-right {
		pointer-events: none;
	}
	
</style>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/view.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/wan-spinner.css">


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
							<a href="javascript:void(0)" class="minus">-</a>
								<input type="text" class="process-fond" name="<%=renderResponse.getNamespace()%>" value="${process.getPause()}"><span class="process-font">s</span>
								<a href="javascript:void(0)" class="plus">+</a>
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


<script type="text/javascript">
	var myJson = {"name":"myScenario42","id":2401,"processes":
					[{"name":"Login","cssId":"0","cssClass":"3001","type":"LOGIN","pause":-42},
					 {"name":"Pause","cssId":"1","cssClass":"Pause","type":"Pause","pause":5},
					 {"name":"Random Page","cssId":"2","cssClass":"3002","type":"RANDOMPAGE","pause":-42},
					 {"name":"Pause","cssId":"3","cssClass":"Pause","type":"Pause","pause":10},
					 {"name":"Logout","cssId":"4","cssClass":"3003","type":"LOGOUT","pause":-42}]
				};
	document.getElementById('JSON').value = JSON.stringify(myJson);
</script>


<!-- JS handling the pause time buttons -->
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

<!-- JS handling the beautiful drag and drop \o/ -->
<script type="text/javascript">
	
	//Prepares the div array and addActions on all the elements space-container
	var cols = document.querySelectorAll('.space-container');
	[].forEach.call(cols, function(col) {
		addDragFeature(col);
	});
	
	var count = parseInt($("#COUNTER").val(), 10);
	console.log("Initial identifier: " + count);
	
	function freshIdentifier(){
		count++;
		console.log("Fresh identifier: " + count);
		return count;
	}

	function addDragFeature(elt) {
		elt.addEventListener('dragenter', handleDragEnter, false);
		elt.addEventListener('dragover', handleDragOver, false);
		elt.addEventListener('dragleave', handleDragLeave, false);
		elt.addEventListener('drop', drop, false);
	}

	//Function called when any draggable element is dragged
	function drag(ev) {
		console.log("Drag->Element:" + ev.target.id + " dragged");
		ev.dataTransfer.setData("text", ev.target.id);
	}

	//Function called when the element is dropped
	function drop(ev) {
		console.log("Droping in: " + this.id);
		//ev.preventDefault();
		
		$(this).removeClass("extented-space");
		$(this).addClass("space-container");
		
		var data = ev.dataTransfer.getData("text");
		console.log("Element: " + data + " dropped");
		
		// Retreives the DOM elements
		var blockTarget = this.parentNode;
		var workflow = blockTarget.parentNode;
		var blockDragged = document.getElementById(data);

		// Removes "template" class if present
		if (blockDragged.className.includes("template")) {
			console.log("cloning...");
			blockDragged = blockDragged.cloneNode(true);
			
			$(blockDragged).removeClass("template");
			$(blockDragged).attr("id", freshIdentifier());

			//Retrieve the space Container in the fresh dragged Block
			var spaceContainer = blockDragged.childNodes[1];
			addDragFeature(spaceContainer);	
		}
		
		// Insert the elements
		workflow.insertBefore(blockDragged, blockTarget);
	}

	//TODO check the use of this fucntion
	function handleDragOver(e) {
		if (e.preventDefault) {
			e.preventDefault(); // Necessary. Allows us to drop.
		}
		e.dataTransfer.dropEffect = 'move'; // See the section on the DataTransfer object.
		return false;
	}

	function handleDragEnter(e) {
 		console.log("Entering in: " + this.id);
 		$(this).removeClass("space-container");
 		$(this).addClass("extented-space");
	}

	function handleDragLeave(e) {
		console.log("Leaving: " + this.id);
		$(this).removeClass("extented-space");
		$(this).addClass("space-container");
	}

</script>

<script type="text/javascript" >
<%@ include file="/js/defaultTourSimulation.js" %>
</script>
