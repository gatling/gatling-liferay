<%--

    Copyright 2011-2015 GatlingCorp (http://gatling.io)

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

    		http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

--%>
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