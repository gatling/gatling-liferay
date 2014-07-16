<%@include file="/html/gatling/header.jsp" %>

<%
	String redirect = PortalUtil.getCurrentURL(renderRequest);
	Request urlRequest = null;
	Scenario scenario = null;
	long scenarioId = ParamUtil.getLong(request, "scenarioId");

	if (scenarioId > 0) {
		scenario= ScenarioLocalServiceUtil.getScenario(scenarioId);
	}
	int totalRate = ParamUtil.getInteger(request,"totalRate");
%>

<script type="text/javascript">

	function <portlet:namespace/>forcePoids()
	{		
		AUI().use('aui-base', function(A) {
			var newVal = A.one('#<portlet:namespace/>poidForce').val();
			if(newVal!=null){
				A.all(':input:not([disabled])').val(newVal);
			}					
	    });
	}
	
	function <portlet:namespace/>showPoids()
	{		
		AUI().use('aui-base', function(A) {
			var lstSelected =  A.all(':input:not([disabled])');
			var total =0;
			for(var element in lstSelected){
				var total = total + element.val();
			}
			for(var element in lstSelected){
				pourcent = element.val() / total;
				classe = element.id;
				A.one(':label.'+classe).val(pourcent);
			}		
	    });
	}
	
	function <portlet:namespace/>showPoidsCase(elm)
	{		
		AUI().use('aui-base', function(A) {
			var id= elm.class;
			console.log("id= "+id);
// 			A.one('input.'+elm.id).disabled("false");	
	    });
	}
</script>
<aui:model-context bean="<%= scenario %>" model="<%= Scenario.class %>" />
<aui:model-context bean="<%= urlRequest %>" model="<%= Request.class %>" />

<portlet:actionURL name="editScenario"  var="addScenarioURL" windowState="normal"/>

<h2><%= (scenario != null)? scenario.getName(): "New Scenario"  %></h2>
<br/>
<aui:form action="<%= addScenarioURL %>" method="POST" name="formulaireScenario">
	<aui:fieldset>
		<aui:input type="hidden" name="scenarioId" value='<%= scenario == null ? "" : scenarioId %>'/>	
		<aui:input type="hidden" name="groupId" value='<%= renderRequest.getAttribute("groupId") %>'/>	
		<table>		
			<tr><th></th><th>Page</th><th>weight</th> <th>weight(%) <th></tr>
			
			<c:forEach var="layout" items='${ listLayout }' varStatus="status">
				<tr>
					<td> <aui:input type="checkbox" name="${status.index}"   id= "${status.index}" class='${status.index}' onChange='<%= renderResponse.getNamespace() + \"showPoidsCase(this)\" %>'/></td>
					<td>${layout.name} </td>	
					<td>
						<c:choose>
							<c:when test='${listrequest.containsKey(layout.friendlyURL)}'>
								<aui:input  name="rate"  class="poids ${status.index}" disabled="false" value="${listrequest.get(layout.friendlyURL)} " onChange='<%= renderResponse.getNamespace() + \"showPoids()\" %>'>
									<aui:validator name="range"> [0,100]</aui:validator>
								</aui:input>
							</c:when>
							<c:otherwise>
								<aui:input  name="rate"  class="poids ${status.index}"  disabled="true" onChange='<%= renderResponse.getNamespace() + \"showPoids()\" %>'>
									<aui:validator name="range"> [0,100]</aui:validator>
								</aui:input>
							</c:otherwise>
						</c:choose>
						
					</td>
					
					<td><label class='${status.index}'>0%</label></td>
				</tr>
			</c:forEach>
		</table>
		<aui:input  type="text" name="poidForce" id="poidForce"> 
			<aui:validator name="digit"/>
		</aui:input> 
		<aui:button-row>
		<aui:button type="button" value="Forcer le poids" onClick="<%= renderResponse.getNamespace() + \"forcePoids()\"%>"/>
		</aui:button-row>
		
	</aui:fieldset>
	<aui:button-row>
		<aui:button type="submit" value="addScenario"/>
		<portlet:renderURL var="homeURL">
			<portlet:param name="mvcPath" value="/html/gatling/view.jsp" />
			<portlet:param name="redirect" value="<%= redirect %>" />
			<portlet:param name="" value=""/>
			<portlet:param name="p_p_isolated" value="1" />
		</portlet:renderURL>
		<aui:button type="cancel"  onClick="<%= homeURL.toString() %>" />
	</aui:button-row>
</aui:form>
