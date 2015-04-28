<%-- 
	Copyright 2015 eBusiness Information, Groupe Excilys (www.ebusinessinformation.fr)
--%>
<%@include file="/html/gatling/header.jsp"%>

<portlet:actionURL name="editRecord" var="editRecordURL" windowState="pop_up">
	<portlet:param name="action" value="editRecord"/>
	<portlet:param name="pagePortletId" value="${portletId}" />
	<portlet:param name="requestId" value="${requestId}" />
</portlet:actionURL>

<portlet:renderURL var="backURL" windowState="pop_up" >
	<portlet:param name="render" value="renderPortlet" />
	<portlet:param name="pagePortletId" value="${portletId}" />
	<portlet:param name="requestId" value="${requestId}" />
	<portlet:param name="tabs1" value="config-record" />
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
						<th class="small-column"><liferay-ui:message key="record-url-name" /> </th>
						<th class="small-column"><liferay-ui:message key="record-url-type" /> </th>
					</tr>
				</thead>
		
				<tbody id="bodyEditRecord">
					<c:forEach var="recordURL"	items="${listRecordUrl}">
						<tr>
							<td>
								${recordURL.url}
							</td>
							
							<td>
								${recordURL.type}
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
