<%-- 
	Copyright 2014 eBusiness Information, Groupe Excilys (www.ebusinessinformation.fr)
--%>
<%@include file="/html/gatling/header.jsp"%>
<ul class="breadcrumb">
	<li><a href="#">Library</a> <span class="divider">/</span></li>
</ul>
<%--
	session errors
--%>
<liferay-ui:error key="simulation-name-required"
	message="simulation-name-required" />
<liferay-ui:error key="simulation-name-already-used"
	message="simulation-name-already-used" />
<liferay-ui:error key="simulation-variable-required"
	message="simulation-variable-required" />
<liferay-ui:error key="simulation-variable-syntaxe"
	message="simulation-variable-syntaxe" />
<%--
	FAQ link
--%>
<portlet:renderURL var="helpURL" windowState="pop_up">
	<portlet:param name="page" value="/html/gatling/help.jsp" />
</portlet:renderURL>
<div class="well well-small">
	<a target="blank" href='#' class="label label-warning"> <i
		class="icon-share"></i> <liferay-ui:message key="help-gatling-wiki" />
	</a> <a href="#" class="label" id="help"> <i
		class="icon-question-sign"></i> <liferay-ui:message
			key="help-how-to-use-portlet" />
	</a> <a href="#" class="label label-success"
		onclick="tourFirstSimu.start();"> <i class="icon-list-alt"></i> <liferay-ui:message
			key="take-a-tour" />
	</a>
</div>

<%-- Tabs --%>
<%
    // Tab value to preselect on page load
    // Default parameter name used by the taglib is "tabs1"
    String currentTab = ParamUtil.getString(request, "tabs1", "simulations");
	String myPage = ParamUtil.getString(request, "page", null);
	String htmlTab = "/html/gatling/tabs/" + currentTab + ".jsp";
	if(myPage != null) {
		htmlTab = "/html/gatling/edit/"+ myPage + ".jsp";
	}
	System.out.println(currentTab +" "+ myPage);
    %>

<!-- This is the link associated to every tab to load the specific page -->
<liferay-portlet:renderURL var="changeTabURL" />

<liferay-ui:tabs names="Simulations,Scenarios,Portlets" tabsValues="simulations,scenarios,portlets" url="<%= changeTabURL %>" value="<%=currentTab%>"/>

<liferay-util:include
	page='<%=htmlTab %>'
	servletContext="<%= application %>" />
