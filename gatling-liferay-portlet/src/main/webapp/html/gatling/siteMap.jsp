<%-- 
	Copyright 2016 Gatling Corp (www.gatling.io)
--%>
<%@include file="/html/gatling/header.jsp"%>


<%@include file="/html/gatling/menuButtons.jsp"%>

<liferay-ui:header title="random-title"></liferay-ui:header>

<portlet:actionURL var="saveSiteMap" windowState="pop_up">
	<portlet:param name="action" value="saveSiteMap" />
</portlet:actionURL>

<aui:form id="myForm" name="siteMapForm" action="${saveSiteMap}" method="post">

	<aui:input name="name" type="text" label="random-name">
		<aui:validator name="required"></aui:validator>
		 <aui:validator name="alphanum" />
	</aui:input>

	<table class="tree table table-striped table-bordered table-hover table-condensed">
		<thead class="table-columns">
			<tr>
				<th id="page-header"><liferay-ui:message key="random-pageName" /></th>
				<th><liferay-ui:message key="random-url" /></th>
				<th id="weight-header"><liferay-ui:message key="random-weight" /></th>
				<th><liferay-ui:message key="random-percent" /></th>
			</tr>
		</thead>
		
		<tbody class="table-data">
			<c:forEach items="${urldata}" var="url">
				<tr>
					<td>${url.friendlyUrl}</td>
					<td>${url.url}</td>
					<td>
						<input type="number" name="<%=renderResponse.getNamespace()%>${url.friendlyUrl}" value="${url.weight}" onChange="showWeight()" class="weightPage">
					</td>
					<td><span class='percent'>0.00%</span></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<aui:button type="submit" value="random-save"/>
	
	
	<portlet:renderURL var="renderView">
		<portlet:param name="render" value="renderView" />
	</portlet:renderURL>
	<a class="btn" href="${renderView}"><liferay-ui:message key="random-cancel" /></a>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.1.0.min.js"></script>

<script type="text/javascript">
	function showWeight() {
		var totalRate = parseInt(0);
		var allWeights = $(".weightPage");
		
		// Get the weight total
		allWeights.each(function() {
			if (!(this.value == "" || isNaN(this.value)) && this.value > 0) {
				totalRate += parseFloat(this.value);
			}
			else {
				this.value = "0";
			}
			
		});
		
		// Set the percent value according to the total
		allWeights.each(function() {
			var percentDisplay = $(this).parent().next();
			var percentValue = "0.00%";
			
			if (!(this.value == "" || isNaN(this.value)) && this.value > 0) {
				percentValue = ( (this.value / totalRate) * 100 ).toFixed(2) + " %";
			}
			percentDisplay.text(percentValue);
			
		});
	}
	showWeight();
</script>
</aui:form>

<%-- Must be included this way to use liferay taglibs --%>
<script type="text/javascript" >
	<%@ include file="/js/randomTour.js" %>
</script>





