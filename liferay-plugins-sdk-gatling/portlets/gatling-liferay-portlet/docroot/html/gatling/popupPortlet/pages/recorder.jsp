<%@page import="com.liferay.portal.kernel.util.CookieKeys"%>
<%@page import="com.liferay.portal.kernel.util.HttpUtil"%>
<%@include file="/html/gatling/header.jsp"%>

<liferay-portlet:actionURL var="toggleRecordURL" name="toggleRecord" windowState="pop_up" >

	<liferay-portlet:param name="page" value="/html/gatling/popupPortlet/portletConfig.jsp"/>
	<liferay-portlet:param name="tabs1" value="record-usecase"/>
	<liferay-portlet:param name="pagePortletId" value="${portletId }"/>
	<liferay-portlet:param name="nextRecordState" value="${nextRecordState}"/>
</liferay-portlet:actionURL>

<h3><liferay-ui:message key="recorder-for" />: ${portletN} </h3>

<c:if test='${ portletId != null &&  !"0".equals(portletId) }'>
	<aui:input name="useCaseRecordName" inlineField="true" ></aui:input>
	<div class="btn-group inline-button">
		<c:choose>
			<c:when test="${nextRecordState eq 'STOP' }">
		 	<aui:a cssClass="btn btn-warning" href="${toggleRecordURL }"><i class="icon-stop"></i> <liferay-ui:message key="stop" /></aui:a>
			</c:when>
			<c:otherwise>
		    <aui:a cssClass="btn btn-warning" href="${toggleRecordURL }"><i class="icon-play"></i> <liferay-ui:message key="record" /></aui:a>
			</c:otherwise>
		</c:choose>
	</div>
	<hr/>
	<liferay-portlet:renderURL var="portletURL" portletName="${ portletId }" windowState="pop_up" doAsGroupId="${ groupId }" />
	<iframe src="${portletURL }" width="95%" style="min-height: 600px;padding: 10px;padding-right: 0px;"></iframe>
</c:if>
