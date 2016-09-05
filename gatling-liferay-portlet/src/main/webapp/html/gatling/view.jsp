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
	
	.chevron {
		margin-left:10px;
		margin-right:10px;
	}
	
	.space-container {
		/*  background: red;*/
		width: 20px;
		padding: 0px 10px;
		display: inline-block ;
	 	height: 80px;
		vertical-align: middle;
		text-align: center;
		line-height: 80px;
	}
	
	.blockus {
		display:inline-block;
	}

	.extented-space {
		width: 200px;
	}
	
	.template .space-container {
		opacity: 0;
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

<aui:form action="${saveDefaultSimulation}" method="post">

	<%-- Scenario FieldSet --%>
	<aui:fieldset class="fieldset">
	
		<aui:input name="simulationId" type="hidden" value="${simulationId}" />
		
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
				Default Scenario
			</div>

			<div class="workflow" >
				<c:forEach items="${scenario.processes}" var="process" varStatus="i">
				<div class="blockus" id ="${'ba_'}${process.id}_${i.index}" draggable="true" ondragstart="drag(event)">
					<div class="space-container" id="${'a_'}${process.id}_${i.index}">
							<div class="icon-chevron-right" style="display: inline-block;"></div>
					</div>
					
					<c:choose >
						<c:when test="${process.isPause()}">
							<div class="pause"  id ="${'pa_'}${process.id}_${i.index}">
							<div class="pause-name process-font">Pause</div>
							<div class="wan-spinner time process-font">
							<a href="javascript:void(0)" class="minus">-</a>
								<input type="text" class="process-fond" name="<%=renderResponse.getNamespace()%>" value="${process.getPause()}"><span class="process-font">s</span>
								<a href="javascript:void(0)" class="plus">+</a>
							</div>
						</div>
						</c:when>
						<c:otherwise>
							<div class="action process-font activeprocess" id ="${'p_'}${process.id}_${i.index}">${process.name}</div>
						</c:otherwise>
					</c:choose>
				</div>
				
				</c:forEach>
				<div class="blockus" id ="endBlock">
					<div class="space-container" id="endSC">
							<div class="icon-chevron-right" style="display: inline-block;"></div>
					</div>
				</div>
				
			</div>
			<%--TODO if s is first put anchor --%> 
			<div id ="takeATourAnchor" style="display: inline-block;"></div>
		</div>
		</c:forEach>		

	<%-- Library, not filled with books but with Processes --%>
	<div class="library">
		<h4>Process Library:</h4>
		<c:forEach items="${templates}" var="template" varStatus="i">
			<div class="blockus template" id ="${'template_'}${template.id}_${i.index}" draggable="true" ondragstart="drag(event)">
					<div class="space-container invisiblePowaaa" id="${'a_template_'}${template.id}_${i.index}">
							<div class="icon-chevron-right" style="display: inline-block;"></div>
					</div>
					<div class="action process-font activeprocess" id ="${'p_template_'}${templateid}_${i.index}">${template.name}</div>
			</div>
		</c:forEach>
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

<script type="text/javascript">
	//Document preparation
	//******************************************************************************
	
	//Prepares the div array and addActions on all the elements space-container
	var cols = document.querySelectorAll('.space-container');
	[].forEach.call(cols, function(col) {
	//col.addEventListener('dragstart', handleDragStart, false);
	col.addEventListener('dragenter', handleDragEnter, false);
	col.addEventListener('dragover', handleDragOver, false);
	col.addEventListener('dragleave', handleDragLeave, false);
	col.addEventListener('drop', drop, false);
	});
	
	//Drag and drop functions
	//******************************************************************************
	
	//Function called when the element is dragged
	function drag(ev) {
	  console.log("Drag->Element:"+ev.target.id+ " dragged");
	  ev.dataTransfer.setData("text", ev.target.id);
	}
	
	//Function called when the element is dropped
	function drop(ev) {
	
	  ev.preventDefault();
	  var data = ev.dataTransfer.getData("text");
	  console.log("Element: "+data+" dropped");
	  resizeDiv(ev.target);
	
	  // Retreives the DOM elements
	  var chevronEl = document.getElementById(ev.target.id);
	  var blockTarget = chevronEl.parentNode;
	  var workflow = document.getElementsByClassName("workflow")[0];
	  var blockDragged = document.getElementById(data);
	
	  // Removes "template" class if present
	  if (blockDragged.className.includes("template")) {
	    console.log("cloning...");
	    blockDragged = blockDragged.cloneNode(true);
	    $(blockDragged).removeClass("template");
	  }
	
	  // Insert the elements
	  workflow.insertBefore(blockDragged, blockTarget);
	
	  //ev.target.appendChild(document.getElementById(data));
	
	}
	
	
	//TODO check the use of this fucntion
	function handleDragOver(e) {
	
	if (e.preventDefault) {
	  e.preventDefault(); // Necessary. Allows us to drop.
	}
	
	e.dataTransfer.dropEffect = 'move';  // See the section on the DataTransfer object.
	
	return false;
	}
	
	var timeDiv = null;
	function handleDragEnter(e) {
	console.log("enter");
	
	var targetElement = e.currentTarget;
	$(targetElement).addClass("extented-space");
	
	// Removes the content
	timeSep = targetElement.getElementsByClassName("icon-chevron-right");
	if (timeSep.length >0) { //Hack: sometimes content is not refreshed fast enougth
	  timeDiv = timeSep[0];
	  targetElement.removeChild(timeSep[0]);
	}
	
	this.classList.add('over');
	}
	
	function handleDragLeave(e) {
	console.log("leave");
	var block = e.currentTarget;
	resizeDiv(block);
	this.classList.remove('over');  // this / e.target is previous target element.
	}
	
	//******************************************************************************
	//Content handling functions
	function resizeDiv(e) {
	// Set back block size and content
	$(e).removeClass("extented-space");
	e.appendChild(timeDiv);
	}
</script>

<script type="text/javascript" >
<%@ include file="/js/defaultTourSimulation.js" %>
</script>
