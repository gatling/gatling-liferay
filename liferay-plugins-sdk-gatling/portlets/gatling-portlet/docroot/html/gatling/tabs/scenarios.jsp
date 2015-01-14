<%@include file="/html/gatling/header.jsp"%>

<div class="navbar">
	<div class="navbar-inner">
		<ul class="nav">
			<li><a id="" href="#"> <i class="icon-plus"></i>
					Add Scenario</a></li>
			<portlet:renderURL var="testURL">
				<portlet:param name="page" value="editScenario" />
				<portlet:param name="tabs1" value="scenarios" />
			</portlet:renderURL> 
			<li><a href="${testURL }">Test Scenario</a></li>
		</ul>
	</div>
</div>