<%-- 
	Copyright 2015 Altendis, Groupe Excilys (www.altendis.fr)
--%>
<%@include file="/html/gatling/header.jsp"%>

Hello world


<portlet:renderURL var="renderAdvancedView">
	<portlet:param name="render" value="renderAdvancedView" />
</portlet:renderURL>

<liferay-ui:icon image="edit" message="renderAdvancedView"
            url="${renderAdvancedView}" />