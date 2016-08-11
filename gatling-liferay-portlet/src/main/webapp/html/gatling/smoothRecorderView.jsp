<%-- 
	Copyright 2015 Altendis, Groupe Excilys (www.altendis.fr)
--%>
<%@include file="/html/gatling/header.jsp"%>



<%-- Title --%>
<liferay-ui:header title="Recorder"></liferay-ui:header>

<%-- URL of button --%>
<liferay-portlet:actionURL var="toggleRecordURL" name="toggleRecord" windowState="pop_up">
	<liferay-portlet:param name="action" value="toggleRecord" />
	<liferay-portlet:param name="requestId"	value="${portletGatlingDTO.requestId}" />
	<liferay-portlet:param name="groupId" value="${portletGatlingDTO.groupId }" />
	<liferay-portlet:param name="nextRecordState" value="${portletGatlingDTO.nextRecordState}" />
	<liferay-portlet:param name="lineId" value="${portletGatlingDTO.lineId}" />
	<c:choose>
		<c:when test="${portletGatlingDTO.nextRecordState eq 'STOP' }">
			<liferay-portlet:param name="tabs1" value="existing-usecase" />
		</c:when>
		<c:otherwise>
			<liferay-portlet:param name="tabs1" value="record-usecase" />
		</c:otherwise>
	</c:choose>
</liferay-portlet:actionURL>

<div id="portletRecordDiv">
	<iframe id="portletRecordFrame" src="http://localhost:8080/home?doAsGroupId=${groupId}" width="95%" class="popup-focus"></iframe>
</div>