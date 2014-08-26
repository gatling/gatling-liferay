<%@include file="/html/gatling/header.jsp"%>

<c:if test="${empty simulationsList }">
	<h3><liferay-ui:message key="no-exists-simulation-message"/></h3>
</c:if>