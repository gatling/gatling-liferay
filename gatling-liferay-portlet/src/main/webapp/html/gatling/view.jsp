<%-- 
	Copyright 2015 Altendis, Groupe Excilys (www.altendis.fr)
--%>
<%@include file="/html/gatling/header.jsp"%>


<%-- CSS --%>
<style  type="text/css">
		.scenario-box form {
			margin: 0px;
		}
		
</style>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/view.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/wan-spinner.css">
<%-- <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/drag-and-drop.css"> --%>


<%-- COWDE --%>

<%-- Tabs --%>
<portlet:renderURL var="renderRecorderView">
	<portlet:param name="render" value="renderRecorderView" />
</portlet:renderURL>

<portlet:actionURL  var="deleteScenarioURL">
	<portlet:param name="action" value="deleteScenarios" />
</portlet:actionURL>


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
		<i class="icon-share" style="display:none;"></i> <liferay-ui:message key="help-gatling-wiki" />
	</a> 

</div>

<%-- Simulation Form --%>


<div class="main-block">
<portlet:actionURL var="saveScenariosURL">
	<portlet:param name="action" value="saveScenarios" />
</portlet:actionURL>

<aui:form action="${saveScenariosURL}" method="post">
	<%-- Scenario FieldSet --%>
	<aui:fieldset class="fieldset" label="1.Design your scenarios">
	
	<input name="<%=renderResponse.getNamespace()%>JSON" id="JSON" type="hidden" value="notDefined" />
	<input id="COUNTER" type="hidden" value="${counter}"/>
	<aui:input name="scenarioId" id="scenarioId" type="hidden" value="notDefined"/>
	
	<%-- Scenario --%>
	<c:forEach items="${scenarios}" var="scenario" varStatus="s">
		<div class="scenario" id="_sc${scenario.id}" >
		
			<div class="scenario-box" >
				<c:if test="${!s.first}" >
					<a href="#" onclick="setScenarioId(${scenario.id}); $(this).closest('form').submit()" >
							<i class="icon-trash"></i>
					</a>
				</c:if>
			</div>
			
			
			
			<div class="scenario-name" >
					<c:choose >
						<c:when test="${s.first}">
							${scenario.name}
						</c:when>
						<c:otherwise>
							<aui:input label="" name="scenario_${scenario.id}name" value="${scenario.name}" inlineField="true" class="inputName"/>
						</c:otherwise>
					</c:choose>
			</div>

			<div class="workflow" id="wf_${scenario.id}">
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
		<div id="trashcan" class="hide-trashcan trashcan" ><div class="icon-remove-sign"></div></div>
		<h4>Process Library:</h4>
		
		<%-- Processes --%>
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
							<a href="javascript:void(0)" class="minus">-</a>
								<input type="text" class="process-fond time-input" name="<%=renderResponse.getNamespace()%>" value="${template.getPause()}"><span class="process-font">s</span>
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

	</aui:fieldset>
	
	<aui:fieldset>
		<aui:button type="submit" value="Save scenarios" style="margin-top: 30px" />
	</aui:fieldset>
</aui:form>
</div>


<div class="main-block">
<portlet:actionURL var="saveInjectionProfile">
	<portlet:param name="action" value="saveInjectionProfile" />
</portlet:actionURL>


<aui:form action="${saveInjectionProfile}" method="post">

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
				<c:set var="isSelected" scope="request" value="${mode eq currentInjection}" />
				<aui:option label="${mode}"
					value="${mode}" selected="${isSelected}" />
			</c:forEach>
		</aui:select>

		<aui:input label="duration" name="rampUp" value="${rampUp}"
			inlineField="true" helpMessage="duration-info-help">
			<aui:validator name="required" />
			<aui:validator name="number" />
			<aui:validator name="min">1</aui:validator>
		</aui:input>
		
	</aui:fieldset>
	
	<aui:fieldset>
		<aui:button type="submit" value="Save injection profile"/>
	</aui:fieldset>
	
</aui:form>
</div>


<div class="main-block">
<portlet:actionURL var="saveFeeders">
	<portlet:param name="action" value="saveFeeders" />
</portlet:actionURL>

<aui:form action="" method="post">
	<%-- Login Feeder Fieldset --%>
	<aui:fieldset label="3.Specify your feeders">
	
		<aui:input name="feederContent"
			label="write-one-account-and-password-per-line" type="textarea"
			cssClass="textarea-feeder" value="${feederContent}"></aui:input>
			
	</aui:fieldset>
	
	<aui:fieldset>
		<aui:button type="submit" value="Save feeders" />
	</aui:fieldset>
</aui:form>
</div>


<div class="main-block">
<portlet:resourceURL id="generateZip" var="resourceUrl" />

<aui:fieldset label="4.Let's export and run with Gatling">
	<aui:button type="button" value="Export the simulation" id="generateZip" onClick="${resourceUrl}" />
</aui:fieldset>	
</div>
	
    </liferay-ui:section>
    <liferay-ui:section>
    </liferay-ui:section>
</liferay-ui:tabs>

<%-- JS --%>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.1.0.min.js"></script>

<script type="text/javascript">

	persistScenarios();
	
	
	/* Events */
	
	function persistScenarios(){
		console.log("Call persistScenarios()");
		
		
		var json = computesScenariosJSon();
		console.log("scenarios: " + JSON.stringify(json));
			
 		document.getElementById('JSON').value = JSON.stringify(json);
	}
	
	
	function computesScenariosJSon(){
		var scenarios = document.getElementsByClassName("scenario");
		var jsonScenarios = [];
		for(var i = 0; i < scenarios.length; i++){
			jsonScenarios.push(scenarioToJSon(scenarios[i]));
		}
		return jsonScenarios;
	}
	
	
	/* JSON Genertors */	
	
	function scenarioToJSon(scenario) {
		console.log("scenarioToJSON called");
		var nameBlock = scenario.getElementsByClassName("scenario-name")[0];
		var name;
		
		var inputs = nameBlock.getElementsByClassName("field");
		// Distinguish first element "_default_scenario_" from other inputs
		if (inputs.length > 0) {
			name = inputs[0].value;
		}
		else {
			name =nameBlock.innerHTML.trim();
		}
		var id = scenario.id.replace("_sc", "");
		
		var blockuses = scenario.getElementsByClassName("blockus");
		var jsonWorkflow = [];
		
		//length - 1 because the last element is the #endBlock
		for(var i = 0; i < blockuses.length - 1; i++){
			jsonWorkflow.push(blockusToJSon(blockuses[i]));
		}
		
		return {"name": name, "id": id, "processes": jsonWorkflow};
	}
	
	
	function blockusToJSon(blockus) {
		console.log("blockusToJSON called");
		
		var cssId = blockus.id.replace("_box", "");
		var cssClass = getClass(blockus, "_p");
		var type = getClass(blockus, "_ty");
		
		var name;
		var pause;
		if(type==="PAUSE"){
			console.log("Pause condition");
			var pauseBlock = blockus.getElementsByClassName("pause-name")[0];
			name = pauseBlock.innerHTML;
			var s = "#" + blockus.id + " input";
			pause = parseInt( $("#" + blockus.id + " input")[0].value, 10);
		}
		else {
			console.log("else condition");
			var process = blockus.getElementsByClassName("action")[0];
			name = process.innerHTML;
			pause = -1;
		}
		
		return {"name": name, "cssId": cssId, "cssClass": cssClass, "type": type, "pause": pause};
	}

	function getClass(elt, prefix) {
		var classes = elt.className.split(/\s+/);
		var res;
		$.each(classes, function() {
			if(this.includes(prefix)) {
				res = this.replace(prefix, "");
			}
		});
		return res;
	}
	
	// Add a onChanged listeners on all the time inputs (NOTE: +/- buttons are not processed here but in wan-spinner-launch.js)
	$('.time-input').each(function() {
		   var elem = $(this);

		   // Save current value of element
		   elem.data('oldVal', elem.val());

		   // Look for changes in the value
		   elem.bind("propertychange change click keyup input paste", function(event){
		      // If value has changed...
		      if (elem.data('oldVal') != elem.val()) {
		       // Updated stored value
		       elem.data('oldVal', elem.val());

		       // Do action
		       persistScenarios();
		     }
		   });
	});

	function setScenarioId(id) {
		document.getElementById('_gatling_WAR_gatlingliferayportlet_scenarioId').value = id;
		persistScenarios();
	}
	
</script>


<script type="text/javascript" src="${pageContext.request.contextPath}/js/wan-spinner.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/wan-spinner-launch.js"></script>
<%-- <script type="text/javascript" src="${pageContext.request.contextPath}/js/drag-and-drop.js"></script> --%>


<style>

.main-block {
	background: rgba(239, 239, 239, 0.28);
	padding: 20px;
	margin: 20px 0px;
	border-radius: 5px;
	border: solid 1px rgba(0, 0, 0, 0.07);
}

.trashcan {
	opacity:1;
	position: relative;
	display: block;
	font-size: 5em;
	background: #f69a9a;
	float: right;
	height: 113px;
	width: 170px;
	line-height: 110px;
	text-align: center;
	color: whitesmoke;
	transition: opacity 0.5s;
}

.hide-trashcan {
	opacity:0;
}

.library {
	background: rgba(80, 199, 255, 0.3);
	border-radius: 5px;
	padding: 1px 0px 20px 20px;
}

.library .fullTrashcan {
	brackground: green;
}

.library h4 {
	font-weight: initial;
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

.dragged .space-container {
	visibility: hidden;
}

.blockus {
	display: inline-block;
}

.action, .pause {
	cursor: pointer;
	transition: box-shadow 0.5s;
}

.action {
	display: inline-block;
	height: 45px;
	line-height: 45px;
	padding: 0px 20px;
	border-radius: 10px;
}

._tyLOGIN .action, ._tyLOGOUT .action {
	background: rgb(88, 148, 227);
}

._tyRANDOMPAGE .action {
	background: rgb(219, 125, 125);
}

._tyRECORD .action {
	background: rgb(126, 191, 127);
}

.action:hover, .pause:hover {
	box-shadow: 1px 1px 4px #555;
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


<script type="text/javascript">
//Prepares the div array and addActions on all the elements space-container
var cols = document.querySelectorAll('.space-container');
[].forEach.call(cols, function(col) {
	addDragFeature(col);
});

var trash = document.getElementById("trashcan");
console.log("trash:"+ trash.innerHTML);

trash.addEventListener("drop", function(ev) {
    // prevent default action (open as link for some elements)
    ev.preventDefault();
	
	var data = ev.dataTransfer.getData("text");
    // move dragged elem to the selected drop target
    var blockDragged = document.getElementById(data);
    if (!trash.className.includes("hide-trashcan") && !blockDragged.className.includes("template")) {
    	blockDragged.parentNode.removeChild( blockDragged );
        //event.target.appendChild( dragged );
    }
    persistScenarios();
}, false);

trash.addEventListener('dragover', handleDragOver, false);

//The counter
var count = parseInt($("#COUNTER").val(), 10);
console.log("Initial identifier: " + count);

function freshIdentifier() {
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
	
	if (!ev.target.className.includes("template")) {
		//Display the process trashcan
		var trashcan = $("#trashcan");
		trashcan.removeClass("hide-trashcan");
		
		$(ev.target).addClass("dragged");
		setTimeout(function() {
			ev.target.style.display = "none";
		}, 1);
	}
}

function endDrag(ev) {
	$(ev.target).removeClass("dragged");
	ev.target.style.display = "inline-block";
	
	var trashcan = $("#trashcan");
	trashcan.addClass("hide-trashcan");
}

//Function called when the element is dropped
function drop(ev) {
	console.log("Droping in: " + this.id);
	ev.preventDefault();

	endDrag(ev);

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

		// Retrieve the space Container in the fresh dragged Block
		var spaceContainer = blockDragged.childNodes[1];
		addDragFeature(spaceContainer);
	}
	
	if (blockDragged.className.includes("_tyPAUSE")) {
		wanSpinerLaunch();
	}

	// Insert the elements
	workflow.insertBefore(blockDragged, blockTarget);
	
	persistScenarios();
}

//TODO check the use of this fucntion
function handleDragOver(e) {
	if (e.preventDefault) {
		e.preventDefault(); // Necessary. Allows us to drop.
	}
	e.dataTransfer.dropEffect = 'move'; // See the section on the DataTransfer
										// object.
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
