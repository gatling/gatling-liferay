<%-- 
	Copyright 2011-2014 eBusiness Information, Groupe Excilys (www.ebusinessinformation.fr)
--%>
<%@include file="/html/gatling/header.jsp"%>

<portlet:actionURL name="editRecord" var="editRecordURL"
	windowState="pop_up">
	<portlet:param name="pagePortletId" value="${portletId}" />
	<portlet:param name="requestId" value="${requestId}" />
</portlet:actionURL>

<portlet:renderURL var="backURL" windowState="pop_up" >
	<portlet:param name="page" value="/html/gatling/popupPortlet/portletConfig.jsp" />
	<portlet:param name="pagePortletId" value="${portletId}" />
	<portlet:param name="requestId" value="${requestId}" />
</portlet:renderURL>

<c:set var="title">
	<liferay-ui:message key="editRecord-title" arguments="${recordName}" />
</c:set>

<liferay-ui:header title="${title}" backURL="${backURL}" />

<c:choose>

	<c:when test="${ not empty listRecordUrl}">
		<aui:form action="${editRecordURL}" name="RecordForm" method="POST">
		
			<aui:input name="recordName" type="text" value="${recordName}" label="record-edit-table-header-name"/>
			<aui:input name="recordId" type="hidden" value="${recordId}"/>
			
			<table class="table table-bordered">
				<thead>
					<tr>
						<th class="small-column"> <liferay-ui:message key="record-url-name" /> </th>
						<th class="small-column"><liferay-ui:message key="record-url-type" /> </th>
						<th class="small-column"><liferay-ui:message key="record-url-order" /> </th>
						<th class="small-column">
							<liferay-ui:message	key="scenario-edit-table-header-weight" />
							<liferay-ui:icon-help message="weight-info-help" />
						</th>
						<th class="small-column"><liferay-ui:icon-help message="percent-info-help" /> </th>
						<th class="small-column"><liferay-ui:message key="delete-message" /> </th>
					</tr>
				</thead>
		
				<tbody id="bodyEditRecord">
					<c:forEach var="recordURL"	items="${listRecordUrl}">
						<tr>
							<td >
								${recordURL.url}
							</td>
							
							<td >
								${recordURL.type}
							</td>
							
							<td >
							<aui:input name="order${recordURL.urlRecordId}" label="" value="${recordURL.order}" disabled="true"></aui:input>	 
							</td>
							
							<td class="weight">
								<aui:input name="weightrecordURL" label="" value="??" disabled="true" cssClass="popup_weightPage" onChange="showWeightPopup()" />
							</td>
							<td class='popup_percent' />
		
							<td>
								<portlet:actionURL var="deleteRecordURLURL" name="removeRecordURL">
									<portlet:param name="page" value="/html/gatling/popupPortlet/pages/editRecord.jsp" />
									<portlet:param name="recordURLId" value="${recordURL.urlRecordId}"/>
									<portlet:param name="recordId" value="${recordURL.recordId}"/>
									<portlet:param name="pagePortletId" value="${portletId}" />
									<portlet:param name="requestId" value="${requestId}" />
								</portlet:actionURL>
								<liferay-ui:icon-delete url="${deleteRecordURLURL}" />
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
			<liferay-ui:message key="portlet-edit-record-empty" />
		</div>
	</c:otherwise>
</c:choose>


<script type="text/javascript">	
	
	function showWeightPopup() {
		AUI().use('aui-base', function(A) {
			var totalRate = parseInt(0);
			var listePage = A.all('.popup_weightPage');
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
		});
	}
	showWeightPopup(); 

</script>
