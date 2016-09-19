<%-- 
	Copyright 2016 Gatling Corp (www.gatling.io)
--%>
<%@include file="/html/gatling/header.jsp"%>

<liferay-ui:header title="Random Pages Creation"></liferay-ui:header>

<portlet:actionURL var="saveSiteMap" windowState="pop_up">
	<portlet:param name="action" value="saveSiteMap" />
</portlet:actionURL>

<aui:form id="myForm" name="siteMapForm" action="${saveSiteMap}" method="post">

	<aui:input name="name" type="text" label="Name">
		<aui:validator name="required"></aui:validator>
		 <aui:validator name="alphanum" />
	</aui:input>

		<!-- TODO: Add a way to use iterations -->
<%-- 	<aui:input name="iterations" label="Iterations" value="1"> --%>
<%-- 		<aui:validator name="number" /> --%>
<%-- 		<aui:validator name="min">1</aui:validator> --%>
<%-- 	</aui:input> --%>

	<table class="tree table table-striped table-bordered table-hover table-condensed">
		<thead class="table-columns">
			<tr>
				<th>Name</th>
				<th>Url</th>
				<th>Weight</th>
			</tr>
		</thead>
		
		<tbody class="table-data">
			<c:forEach items="${urldata}" var="url">
				<tr>
					<td>${url.friendlyUrl}</td>
					<td>${url.url}</td>
					<td>
						<input type="number" name="<%=renderResponse.getNamespace()%>${url.friendlyUrl}" value="${url.weight}">
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<aui:button type="submit" value="Save the Random Process"/>
	
	
	<portlet:renderURL var="renderView">
		<portlet:param name="render" value="renderView" />
	</portlet:renderURL>
	<a class="btn" href="${renderView}">Cancel</a>
	
</aui:form>






