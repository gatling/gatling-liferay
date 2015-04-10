<%-- 
	Copyright 2014 eBusiness Information, Groupe Excilys (www.ebusinessinformation.fr)
--%>
<%@include file="/html/gatling/header.jsp"%>

<c:set var="title"> 
	<liferay-ui:message key="configRecord-title" arguments="${portletGatlingDTO.listRecord.size()}" />
</c:set>

<liferay-ui:header title="${title}" /> 
<!-- view List of records -->


<liferay-ui:search-container emptyResultsMessage="record-list-empty" >
	<%--List of data to display --%>
	<liferay-ui:search-container-results results="${portletGatlingDTO.listRecord }" total="${portletGatlingDTO.listRecord.size() }" />
	<%--for each column --%>
	<liferay-ui:search-container-row className="com.excilys.liferay.gatling.model.Record" keyProperty="recordId" modelVar="record">
		<%-- EditURl --%>
		<portlet:renderURL var="editRecordURL">
			<portlet:param name="render" value="editRecord" />
			<portlet:param name="recordId" value="${record.recordId }" />
			<portlet:param name="recordname" value="${record.name }" />
			<portlet:param name="portletId" value="${portletGatlingDTO.portletId}" />
			<portlet:param name="requestId" value="${requestId }" />
		</portlet:renderURL>
		<liferay-ui:search-container-column-text name="record-edit-table-header-name" value="${record.name}" href="${editRecordURL}" />
	
		<%--delete button --%>
		<liferay-ui:search-container-column-text name="delete" align="center">
			<portlet:actionURL var="deleteRecordURL">
				<portlet:param name="action" value="deleteRecord"/>
				<portlet:param name="recordId" value="${record.recordId }" />
				<portlet:param name="pagePortletId" value="${portletGatlingDTO.portletId}" />
				<portlet:param name="requestId" value="${portletGatlingDTO.requestId}" />
				<portlet:param name="groupId" value="${portletGatlingDTO.groupId }"/>
			</portlet:actionURL>
			<liferay-ui:icon-delete url="${deleteRecordURL}" />
		</liferay-ui:search-container-column-text>
	</liferay-ui:search-container-row>
	<%--iterate and show list of data --%>
	<liferay-ui:search-iterator paginate="false" />
</liferay-ui:search-container>		