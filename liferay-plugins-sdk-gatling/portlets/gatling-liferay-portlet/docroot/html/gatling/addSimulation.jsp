<%@page import="com.excilys.liferay.gatling.PageSiteWrapper"%>
<%@include file="/html/gatling/header.jsp" %>

<%
	String redirect = ParamUtil.getString(request, "redirect");
	if(ParamUtil.getString(request,"pageSiteWrapper") != null ){
		System.out.println("wraper pas vide dans addSimulation + "+ParamUtil.getString(request,"pageSiteWrapper"));
	}
	if(request.getAttribute("pageSiteWrapper")  !=null){
		System.out.println("attribut de la requette pas vide");
	}
%>

<c:if test="${ pageSiteWrapper != null }">pageSiteWrapper pas vide dans simulation.jsp </c:if>

<aui:script >

	function <portlet:namespace/>RecupScenarioForm()
	{
		var A = AUI();
		A.one('#scenario').show();
	}

</aui:script> 


<aui:form action="" method="POST" name="formulaire-simulation">
	<aui:fieldset>
		<aui:input type="hidden" name="redirect" value="<%= redirect %>" />

		<aui:input type="text" name="nameSimulation" />
		
		<aui:button-row>
			<portlet:renderURL var="addScenarioURL">
				<portlet:param name="mvcPath" value="/html/gatling/addScenario.jsp" />
				<portlet:param name="redirect" value="<%= redirect %>" />
				<portlet:param name="p_p_isolated" value="1" />
			</portlet:renderURL>
			<aui:button value="add-scenario" onClick="<%= renderResponse.getNamespace() + \"RecupScenarioForm()\"%>"/>
		</aui:button-row>
		
		<div id="scenario" class="scenario" hidden="true">
			<%@include file="/html/gatling/addScenario.jsp" %>
		</div>

	</aui:fieldset>

	<aui:button-row>
		<aui:button type="submit" value="addSimulation"/>
		<portlet:renderURL var="homeURL">
			<portlet:param name="mvcPath" value="/html/gatling/view.jsp" />
			<portlet:param name="redirect" value="<%= redirect %>" />
			<portlet:param name="p_p_isolated" value="1" />
		</portlet:renderURL>
		<aui:button type="cancel"  onClick="<%= homeURL.toString() %>" />
	</aui:button-row>
</aui:form>
