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
            

<div align="right">

<portlet:actionURL var="debugButton1">
	<portlet:param name="action" value="debugYann" />
</portlet:actionURL>

<portlet:resourceURL id="manyScriptsY" var="resourceUrl" />

<liferay-ui:icon iconCssClass="icon-film" message="debugYann"
            url="${resourceUrl}" />      
      
            
<portlet:actionURL var="debugButton2">
	<portlet:param name="action" value="debugNico" />
</portlet:actionURL>

<liferay-ui:icon image="add" message="debugNico"
            url="${debugButton2}" />   
            
 </div>
            
