<%@page import="com.liferay.portal.kernel.util.CookieKeys"%>
<%@page import="com.liferay.portal.kernel.util.HttpUtil"%>
<%@include file="/html/gatling/header.jsp"%>

<liferay-portlet:actionURL var="toggleRecordURL" name="toggleRecord" windowState="pop_up" >

	<liferay-portlet:param name="page" value="/html/gatling/popupPortlet/portletConfig.jsp"/>
	<liferay-portlet:param name="tabs1" value="record-usecase"/>
	<liferay-portlet:param name="pagePortletId" value="${portletId }"/>
	<liferay-portlet:param name="groupId" value="${groupId }"/>
	<liferay-portlet:param name="nextRecordState" value="${nextRecordState}"/>
</liferay-portlet:actionURL>

<h3><liferay-ui:message key="recorder-for" />: ${portletName} </h3>

<c:if test='${ portletId != null &&  !"0".equals(portletId) }'>
	<aui:form action="${toggleRecordURL}">
		
		<div class="btn-group" style="z-index: 1202">
			<c:choose>
				<c:when test="${nextRecordState eq 'STOP' }">
				<aui:input name="useCaseRecordName" inlineField="true" disabled="true" ></aui:input> 
				<liferay-util:buffer var="btnRecordText">
					<liferay-ui:message key="stop" /> 
				</liferay-util:buffer>				
			 	<aui:button cssClass="btn btn-warning inline-button" type="submit" value="${btnRecordText}" icon="icon-stop" />
			 	<input id="checkRecording" type="hidden" value="true"/>
				</c:when>
				<c:otherwise>
				<aui:input name="useCaseRecordName" inlineField="true" required="true"></aui:input> 
				<liferay-util:buffer var="btnRecordText">
					<liferay-ui:message key="record" /> 
				</liferay-util:buffer>	
			    <aui:button cssClass="btn btn-warning inline-button" type="submit" value="${btnRecordText }" icon="icon-play"/>
			    <input id="checkRecording" type="hidden" value="false"/>
				</c:otherwise>
			</c:choose>
		</div>
	</aui:form>
	<hr/>
	<liferay-portlet:renderURL var="portletURL" portletName="${ portletId }" windowState="pop_up" doAsGroupId="${ groupId }" />
	<iframe id="portletRecordFrame" src="${portletURL }" width="95%" class="popup-focus" ></iframe>
	
	<c:if test="${nextRecordState eq 'STOP' }">
	<div style="position: fixed; width: 100%; height: 100%; top: 0px; left: 0px; z-index: 1201;" class="yui3-widget-mask"></div>
	</c:if>
	
</c:if>

<script>
AUI().use("aui-base", function(A) {
	A.one(top.document.getElementById('recording')).val(A.one("#checkRecording").val());
	console.log(top.document.getElementById('recording'));
});
</script>
