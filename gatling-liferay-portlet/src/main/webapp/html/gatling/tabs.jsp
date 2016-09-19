
<%@include file="/html/gatling/header.jsp"%>

<portlet:renderURL var="renderView">
	<portlet:param name="render" value="renderView" />
</portlet:renderURL>

<liferay-ui:tabs names="Scenario Builder,Recorder" value="Recorder" refresh="false" url0="${renderView}">

	<liferay-ui:section>
	</liferay-ui:section>

	<liferay-ui:section>
		<%@ include file="recorderView.jsp"%>
	</liferay-ui:section>

</liferay-ui:tabs>

