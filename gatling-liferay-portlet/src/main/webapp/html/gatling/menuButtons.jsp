
<%@include file="/html/gatling/header.jsp"%>

<link rel="stylesheet" type="text/css" href="${css}/menuButtons.css">

<%-- Top Menu --%>
<div id="menus">

	<%-- Take a tour view link --%>
	<%--
		The jsp that includes this file needs to include js code in which a
		shepherd object named takeATour define the take a tour interactions.
	 --%>
	<a href="#" class="btn" onclick="takeATour.start();">
		<i class="icon-list-alt"></i> <liferay-ui:message key="take-a-tour" />
	</a> 

	<%-- Wiki Gatling Link --%>
	<a target="blank" href='<%=PortletProps.get("gatling-wiki")%>'
		class="btn">
		<i class="icon-book"></i> <liferay-ui:message key="help-gatling-wiki" />
	</a> 

</div>