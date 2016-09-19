<%-- 
	Copyright 2016 Gatling Corp (www.gatling.io)
--%>
<%@include file="/html/gatling/header.jsp"%>


<style>
	#exportToggle {
		margin-right: 20px;
	}	
</style>


<%-- Title --%>
<liferay-ui:header title="Recorder"></liferay-ui:header>


<%-- URL of button --%>
<liferay-portlet:actionURL var="toggleRecordURL" name="toggleRecord" >
	<liferay-portlet:param name="action" value="toggleRecord2" />
	<liferay-portlet:param name="smoothy" value="true" />
	<liferay-portlet:param name="javax.portlet.action" value="toggleRecord" />
	<liferay-portlet:param name="requestId"	value="${portletGatlingDTO.requestId}" />
	<liferay-portlet:param name="groupId" value="${groupId}" />
	<liferay-portlet:param name="nextRecordState" value="${NEXT_STATE}" />
	<liferay-portlet:param name="lineId" value="${portletGatlingDTO.lineId}" />

</liferay-portlet:actionURL>

<portlet:resourceURL id="generateProcessZip" var="resourceUrl" >
</portlet:resourceURL>

<aui:form action="${resourceUrl}" style="float: right">
	
	<a id="exportToggle" onClick="$(this).closest('form').submit()" >
		<i class="icon-print"></i> <liferay-ui:message key="simulation-export-record"/>
	</a>
	
	<aui:select name="recordName" label="" inlineField="true">
		<c:forEach items="${records}" var="record" varStatus="loop">
			<aui:option selected="${loop.last}" value="${record.name}">${record.name}</aui:option>
		</c:forEach>
	</aui:select>
	
</aui:form>

				
<aui:form action="${toggleRecordURL}">
	<c:if test="${not empty multipartError }">
		<div class="alert alert-error pull-right" style="margin-right:50px">
			<p>
				<liferay-ui:message key="multipart-error-message" />
			</p>
		</div>
	</c:if>
	<div class="btn-group">
	<c:choose>
			<c:when test="${NEXT_STATE eq 'STOP' }">
			<aui:input name="useCaseRecordName" inlineField="true"
					readonly="true" />
				<liferay-util:buffer var="btnRecordText">
					<liferay-ui:message key="stop" />
				</liferay-util:buffer>
				<aui:button cssClass="btn btn-warning inline-button" type="submit"
					value="${btnRecordText}" icon="icon-stop" />
				<input id="checkRecording" type="hidden" value="true" />
			</c:when>
			
			<c:otherwise>
				<aui:input name="useCaseRecordName" inlineField="true">
						<aui:validator name="required" />
					</aui:input>
					<liferay-util:buffer var="btnRecordText">
						<liferay-ui:message key="record" />
					</liferay-util:buffer>
					<aui:button cssClass="btn btn-warning inline-button" type="submit"
						value="${btnRecordText }" icon="icon-play" />
					<input id="checkRecording" type="hidden" value="false" />
			</c:otherwise>
	</c:choose>
				
	</div>

</aui:form>

<div id="portletRecordDiv">
	<iframe id="portletRecordFrame" src="/home?doAsGroupId=${groupId}" width="95%" ></iframe>
</div>


<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.1.0.min.js"></script>


