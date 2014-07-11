<%@include file="/html/gatling/header.jsp" %>

<%
	String redirect = ParamUtil.getString(request, "redirect");

%>

<aui:script >

	function <portlet:namespace/>RecupRequestForm()
	{
		var A = AUI();
		A.one('#request').show();
	}

</aui:script> 


<aui:form action="" method="POST" name="formulaire-scenario">
	<aui:fieldset>
		<aui:input type="hidden" name="redirect" value="<%= redirect %>" />

		<aui:input type="text" name="nameScenario" />
		
		<aui:button-row>
			<portlet:renderURL var="addRequestURL">
				<portlet:param name="mvcPath" value="/html/gatling/addRequest.jsp" />
				<portlet:param name="redirect" value="<%= redirect %>" />
				<portlet:param name="p_p_isolated" value="1" />
			</portlet:renderURL>
			<aui:button value="add-request" onClick="<%= renderResponse.getNamespace() + \"RecupRequestForm()\"%>"/>
		</aui:button-row>
		
		<div id="request" class="request" hidden="true">
			<%@include file="/html/gatling/addRequest.jsp" %>
		</div>

	</aui:fieldset>

	<aui:button-row>
		<aui:button type="submit" value="addScenario"/>
		<portlet:renderURL var="homeURL">
			<portlet:param name="mvcPath" value="/html/gatling/view.jsp" />
			<portlet:param name="redirect" value="<%= redirect %>" />
			<portlet:param name="p_p_isolated" value="1" />
		</portlet:renderURL>
		<aui:button type="cancel"  onClick="<%= homeURL.toString() %>" />
	</aui:button-row>
</aui:form>
