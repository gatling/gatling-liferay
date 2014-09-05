<%-- 
	Copyright 2011-2014 eBusiness Information, Groupe Excilys (www.ebusinessinformation.fr)
--%>
<%@include file="/html/gatling/header.jsp"%>

<h1>${listRecord.size() } <liferay-ui:message key="records-word" /></h1>

<!-- view List of records -->

<liferay-ui:search-container emptyResultsMessage="record-list-empty">
	<%--Liste of data to display --%>
	<liferay-ui:search-container-results results="${listRecord }" total="${listRecord.size() }" />
	<%--for each column --%>
	<liferay-ui:search-container-row className="com.excilys.liferay.gatling.model.Record" keyProperty="recordId" modelVar="record">
		<%-- EditURl --%>
		<portlet:renderURL var="editRecordURL">
			<portlet:param name="page" value="/html/gatling/popupPortlet/pages/editRecord.jsp" />
			<portlet:param name="recordId" value="${record.recordId }" />
		</portlet:renderURL>
		<liferay-ui:search-container-column-text name="record-edit-table-header-name" value="${record.name}" href="${editRecordURL}" />
	
		<%--delete button --%>
		<liferay-ui:search-container-column-text name="delete" align="center">
			<portlet:actionURL var="deleteRecordURL" name="removeRecord">
				<portlet:param name="recordId" value="${record.recordId }" />
				<portlet:param name="pagePortletId" value="${portletId}" />
				<portlet:param name="requestId" value="${requestId}" />
				<portlet:param name="groupId" value="${groupId }"/>
			</portlet:actionURL>
			<liferay-ui:icon-delete url="${deleteRecordURL}" />
		</liferay-ui:search-container-column-text>
	</liferay-ui:search-container-row>
	<%--iterate and show list of data --%>
	<liferay-ui:search-iterator paginate="false" />
</liferay-ui:search-container>		