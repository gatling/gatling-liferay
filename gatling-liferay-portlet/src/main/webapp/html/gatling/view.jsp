<%-- 
	Copyright 2015 Altendis, Groupe Excilys (www.altendis.fr)
--%>
<%@include file="/html/gatling/header.jsp"%>

Hello world


<portlet:renderURL var="seeOldPortlet">
<portlet:param name="render" value="seeOldPortlet" />
</portlet:renderURL>

<liferay-ui:icon image="edit" message="seeOldStuff"
            url="<%= seeOldPortlet%>" />