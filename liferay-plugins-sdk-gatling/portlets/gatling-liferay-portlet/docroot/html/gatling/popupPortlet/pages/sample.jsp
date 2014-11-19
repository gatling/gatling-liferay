<%-- 
	Copyright 2014 eBusiness Information, Groupe Excilys (www.ebusinessinformation.fr)
--%>
<%@include file="/html/gatling/header.jsp"%>

<portlet:actionURL name="editPortletSample" var="editPortletSampleURL"
	windowState="pop_up">
	<portlet:param name="pagePortletId" value="${portletGatlingDTO.portletId}" />
	<portlet:param name="requestId" value="${portletGatlingDTO.requestId}" />
	<portlet:param name="lineId" value="${portletGatlingDTO.lineId}" />
</portlet:actionURL>

<div class="well well-small">
	<liferay-ui:message key="portlet-edit-sample-details" />
</div>
<c:if test="${not empty multipartError }">
	<div class="alert alert-error pull-right" style="margin-right:50px">
		<p>
			<liferay-ui:message key="multipart-error-message" />
		</p>
	</div>
</c:if>
<c:choose>
	<c:when
		test="${not empty portletGatlingDTO.availableScript && not empty portletGatlingDTO.availableScript[0] 
				&& not empty portletGatlingDTO.availableScript[0][0] && portletGatlingDTO.availableScript[0][0] != ' ' }">
		<aui:form action="" name="addSample" id="addSample">


			<aui:select inlineField="true" label="portlet-edit-sample-select" name="Sample Script" required="true" id="selectScript">
				
				<!-- Get the list of the different sample scripts available for the Portlet. The list is stored in a class named ListScript (package mustache) -->
				<c:forEach var="script" items="${portletGatlingDTO.availableScript}">
					<aui:option label="${script[0]}" value="${script[2]},${script[1]}" />
				</c:forEach>
			</aui:select>

			<aui:button id="add" onClick="addLine()"
				value="portlet-edit-sample-add" cssClass="inline-button" />

		</aui:form>
		


		<aui:form action="${editPortletSampleURL}" name="formPortletSample" method="POST">
			<table class="table table-bordered table-scenario">
				<thead>
					<tr>
						<th><liferay-ui:message key="portlet-edit-sample-name" /></th>
						<th class="small-column"><liferay-ui:message key="scenario-edit-table-header-weight" /> 
							<liferay-ui:icon-help message="weight-info-help" />
						</th>
						<th class="small-column">
							<liferay-ui:icon-help message="percent-info-help" />
						</th>
						<th class="small-column">
							<liferay-ui:message	key="delete-message" />
						</th>
					</tr>
				</thead>

				<tbody id="bodyEditScript">

 					<c:forEach var="linkUsecaseRequest"	items="${portletGatlingDTO.linkDTO}">
						<tr>
							<aui:input name="idLink" type="hidden" ignoreRequestValue="true" value="${linkUsecaseRequest.linkId}"/>
							<aui:input name="recordId" type="hidden" ignoreRequestValue="true" value="${linkUsecaseRequest.recordId}"/>
							<aui:input name="isSample" type="hidden" ignoreRequestValue="true" value="${linkUsecaseRequest.sample}"/>
							<td class="text" title="${linkUsecaseRequest.recordId}" >
								${linkUsecaseRequest.name}
							</td>
							<td class="weight">
								<aui:input name="weightScenarioSample" ignoreRequestValue="true" label="" type="text"  value="${linkUsecaseRequest.weight}" cssClass="popup_weightPage" onChange="showWeightPopup()" />
							</td>
							<td class='popup_percent' />

							<td>
								<portlet:actionURL var="deleteLinkUseCaseURL" name="removeLinkUseCase">
									<portlet:param name="useCaseId" value="${linkUsecaseRequest.linkId}"/>
									<portlet:param name="pagePortletId" value="${portletGatlingDTO.portletId}" />
									<portlet:param name="requestId" value="${portletGatlingDTO.requestId}" />
									<portlet:param name="lineId" value="${portletGatlingDTO.lineId}" />
								</portlet:actionURL>
								<aui:a href="${deleteLinkUseCaseURL }">
									<liferay-ui:icon image="delete" />
								</aui:a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>

			<aui:button type="submit" id="submitPopupSample" />
		</aui:form>

	</c:when>

	<c:otherwise>
		<div class="alert">
			<liferay-ui:message key="portlet-edit-sample-empty" />
		</div>
	</c:otherwise>
</c:choose>

<div hidden="true">
	<table>
		<tbody id="toPaste">
			<tr class="empty-weight-color">
				<aui:input name="idLink" type="hidden" value="0"/>
				<aui:input name="recordId" type="hidden" />
				<aui:input name="isSample" type="hidden" value="true" />
				<td class="text" title="">
				</td>
				<td class="weight">
					<aui:input name="weightScenarioSample" label="" ignoreRequestValue="true" value="0.0" cssClass="popup_weightPage" onChange="showWeightPopup()"></aui:input>
				</td>
				<td class='popup_percent'>
				0.00 %
				</td>
				<td>
					<aui:a href="#" onClick="removeLine(this);">
						<liferay-ui:icon image="delete" />
					</aui:a>
				</td>
			</tr>
		</tbody>
	</table>
</div>

<script type="text/javascript">	
	AUI().use("aui-base", function(A) {
		var elmt = A.one("button[type='submit']");
		if (elmt != null){
			elmt.on('click', function(event) {
				var info = A.one(top.document.getElementById('${portletGatlingDTO.lineId}')).one(".info-config");
				if(A.one("#bodyEditScript").all("tr").size() > 0) {
					info.text("<liferay-ui:message key='portlet-configuration-ok' />");
				} else {
					info.text("<liferay-ui:message key='portlet-configuration-ko' />");
				}
			});
		}
	});


	function addLine() {
		AUI().use('aui-base', 'aui-node-base', function(A){
			var idSelect = "<portlet:namespace/>selectScript";
			var label = document.getElementById(idSelect)[document.getElementById(idSelect).selectedIndex].textContent;
			var value = document.getElementById(idSelect).value.split(',')[1];
			var canAdd = true;
			A.one("#bodyEditScript").all('.text').each(function(node) {
				canAdd = canAdd && node.get('title') != value;
			});
			
			if(canAdd && label != null && label != "" && label != " "){			
				var value = document.getElementById(idSelect).value.split(',');				
				var one = A.one('#toPaste').html();
				var html = A.Node.create(one);
				//set name of script
				html.one('.text').html(label);
				html.one('.text').set('title',value[1]); //sampleId
				//Set hidden input
				html.one('#<portlet:namespace/>recordId').val(value[1]);
				html.one('#<portlet:namespace/>isSample').val(value[0]);
				//Append
				html.appendTo('#bodyEditScript');	
			}
		
		});
	}
	
	function removeLine(line) {
		AUI().one(line).ancestor("tr").remove();
	}
	
	
	function showWeightPopup() {
		AUI().use('aui-base', function(A) {
			var totalRate = parseInt(0);
			var body =  A.one("#bodyEditScript");
			if(body != null){
				var listePage = body.all('.popup_weightPage');
				listePage.each(function() {
					if (!(this.val() == "" || isNaN(this.val())) && this.val() > 0) {
						totalRate += parseFloat(this.val());
					} else {
						this.val("0.0");
						this.ancestor("tr").addClass("empty-weight-color");
					}
				});

				listePage.each(function() {
					if (!(this.val() == "" || isNaN(this.val()))) {
						var perc = (this.val() / totalRate) * 100;
						//cas du 0/0
						if (isNaN(perc))
							this.ancestor("tr").one(".popup_percent").text(	"0.00 %");
						else
							this.ancestor("tr").one(".popup_percent").text(	perc.toFixed(2) + " %");
					}
				});
			}
		});
	}
	showWeightPopup();

</script>