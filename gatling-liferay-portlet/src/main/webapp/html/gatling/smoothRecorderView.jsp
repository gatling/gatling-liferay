<%-- 
	Copyright 2015 Altendis, Groupe Excilys (www.altendis.fr)
--%>
<%@include file="/html/gatling/header.jsp"%>



<%-- Title --%>
<liferay-ui:header title="Recorder"></liferay-ui:header>


<%-- URL of button --%>
<liferay-portlet:actionURL var="toggleRecordURL" name="toggleRecord" windowState="pop_up">
	<liferay-portlet:param name="action" value="toggleRecord2" />
	<liferay-portlet:param name="smoothy" value="true" />
	<liferay-portlet:param name="javax.portlet.action" value="toggleRecord" />
	<liferay-portlet:param name="requestId"	value="${portletGatlingDTO.requestId}" />
	<liferay-portlet:param name="groupId" value="${groupId}" />
	<liferay-portlet:param name="nextRecordState" value="${NEXT_STATE}" />
	<liferay-portlet:param name="lineId" value="${portletGatlingDTO.lineId}" />

</liferay-portlet:actionURL>

	<aui:form action="${toggleRecordURL}">
		<c:if test="${not empty multipartError }">
			<div class="alert alert-error pull-right" style="margin-right:50px">
				<p>
					<liferay-ui:message key="multipart-error-message" />
				</p>
			</div>
		</c:if>
		<div class="btn-group" style="z-index: 1202">
					<aui:input name="useCaseRecordName" inlineField="true">
						<aui:validator name="required" />
					</aui:input>
					<liferay-util:buffer var="btnRecordText">
						<liferay-ui:message key="record" />
					</liferay-util:buffer>
					<aui:button cssClass="btn btn-warning inline-button" type="submit"
						value="${btnRecordText }" icon="icon-play" />
					<input id="checkRecording" type="hidden" value="false" />
		</div>

	</aui:form>

<div id="portletRecordDiv">
	<iframe id="portletRecordFrame" src="http://localhost:8080/home?doAsGroupId=${groupId}" width="95%" class="popup-focus"></iframe>
</div>