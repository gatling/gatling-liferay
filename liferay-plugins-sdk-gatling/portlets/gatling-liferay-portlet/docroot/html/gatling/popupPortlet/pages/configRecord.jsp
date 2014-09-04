<%-- 
	Copyright 2011-2014 eBusiness Information, Groupe Excilys (www.ebusinessinformation.fr)
--%>
<%@include file="/html/gatling/header.jsp"%>

<h1>${listRecord.size() } records</h1>
<!-- view List of records -->

<liferay-ui:search-container emptyResultsMessage="record-list-empty">
	<%--Liste of data to display --%>
	<liferay-ui:search-container-results results="${listRecord }" total="${listRecord.size() }" />
	<%--for each column --%>
	<liferay-ui:search-container-row className="com.excilys.liferay.gatling.model.Record" keyProperty="recordId" modelVar="record">
		<%-- EditURl --%>
		<portlet:renderURL var="editRecordURL">
			<portlet:param name="page" value="/html/gatling/editRecord.jsp" />
			<portlet:param name="recordId" value="${record.recordId }" />
		</portlet:renderURL>
		<liferay-ui:search-container-column-text name="record-edit-table-header-name" value="${record.name}" href="${editRecordURL}" />
		<%--delete button --%>
		<liferay-ui:search-container-column-text name="delete" align="center">
			<portlet:actionURL var="deleteRecordURL" name="removeRecord">
				<portlet:param name="recordId" value="${scenario.scenario_id }" />
			</portlet:actionURL>
			<liferay-ui:icon-delete url="${deleteRecordURL}" />
		</liferay-ui:search-container-column-text>
	</liferay-ui:search-container-row>
	<%--iterate and show list of data --%>
	<liferay-ui:search-iterator paginate="false" />
</liferay-ui:search-container>		

<!-- <table> -->
<!-- 	<thead> -->
<!-- 		<tr> -->
<%-- 			<th> <liferay-ui:message key="portlet-edit-sample-name" /> </th> --%>
<%-- 			<th class="small-column"> <liferay-ui:message	key="delete-message" /> </th> --%>
<!-- 		</tr> -->
<!-- 	</thead> -->
	
<!-- 	<tbody> -->
<%-- 		<c:forEach var="record"	items="${recordList}"> --%>
<!-- 			<tr> -->
<%-- 				<td class="text" title="${record.name}" >${record.name}</td> --%>
<!-- 				<td> -->
<%-- 					<portlet:actionURL var="deleteRecordURL" name="removeRecord"> --%>
<%-- 						<portlet:param name="recordId" value="${record.recordId }" /> --%>
<%-- 					</portlet:actionURL> --%>
<%-- 					<liferay-ui:icon-delete url="${deleteRecordURL}" /> --%>
<!-- 				</td> -->
<!-- 			</tr> -->
<%-- 		</c:forEach> --%>
<!-- 	</tbody> -->
<!-- </table> -->