<%-- 
	Copyright 2014 eBusiness Information, Groupe Excilys (www.ebusinessinformation.fr)
--%>
<%@page import="com.liferay.portal.kernel.util.CookieKeys"%>
<%@page import="com.liferay.portal.kernel.util.HttpUtil"%>
<%@include file="/html/gatling/header.jsp"%>

<liferay-portlet:actionURL var="toggleRecordURL" name="toggleRecord" windowState="pop_up">

	<liferay-portlet:param name="action" value="toggleRecord" />
	<liferay-portlet:param name="pagePortletId"	value="${portletGatlingDTO.portletId}" />
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

<c:set var="errorMessage">
	<liferay-ui:message key="record-name-already-used" />
</c:set>

<h3>
	<liferay-ui:message key="recorder-for" />
	: ${portletGatlingDTO.portletName}
</h3>

<c:if
	test='${ portletGatlingDTO.portletId != null &&  !"0".equals(portletGatlingDTO.portletId) }'>
	<aui:form action="${toggleRecordURL}">
		<c:if test="${not empty multipartError }">
			<div class="alert alert-error pull-right" style="margin-right:50px">
				<p>
					<liferay-ui:message key="multipart-error-message" />
				</p>
			</div>
		</c:if>
		<div class="btn-group" style="z-index: 1202">
			<c:choose>
				<c:when test="${portletGatlingDTO.nextRecordState eq 'STOP' }">
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
						<aui:validator name="custom" errorMessage="record-name-already-used">
 					 	function (val, fieldNode, ruleValue) {
							var result = true;
							<c:if test="${not empty portletGatlingDTO.listRecordsNameJS}">
								var list = ${portletGatlingDTO.listRecordsNameJS};
								if (list.indexOf(val) != -1) {
									result = false;
								}
							</c:if>
							return result;
						} 
					</aui:validator>
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
	<hr />
	<liferay-portlet:renderURL var="portletURL"
		portletName="${portletGatlingDTO.portletId }" windowState="pop_up"
		doAsGroupId="${ portletGatlingDTO.groupId }"
		plid="${ portletGatlingDTO.plId }" />
	<iframe id="portletRecordFrame" src="${portletURL }" width="95%"
		class="popup-focus"></iframe>

	<c:if test="${portletGatlingDTO.nextRecordState eq 'STOP' }">
		<div
			style="position: fixed; width: 100%; height: 100%; top: 0px; left: 0px; z-index: 1201;"
			class="yui3-widget-mask"></div>
	</c:if>

</c:if>

<script>
	AUI().use(
			"aui-base",
			function(A) {
				A.one(top.document.getElementById('recording')).val(
						A.one("#checkRecording").val());
				if (A.one(".alert") != null
						&& A.one("#checkRecording").val() === 'true') {
					A.one(".alert").hide();
				}
			});
</script>
