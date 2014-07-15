<%@include file="/html/gatling/header.jsp" %>

<%
	String redirect = PortalUtil.getCurrentURL(renderRequest);
	Request urlRequest = null;
	Scenario scenario = null;
	int totalRate = ParamUtil.getInteger(request,"totalRate");
%>

<script type="text/javascript">

	function <portlet:namespace/>forcePoids()
	{		
		AUI().use('aui-base', function(A) {
			var newVal = A.one('#<portlet:namespace/>poidForce').val();
			if(newVal!=null){
				A.all(':input').val(newVal);
			}					
	    });
	}
	
	function <portlet:namespace/>showPoids()
	{		
		AUI().use('aui-base', function(A) {
			A.all('.rate').show();	
			var lst = A.all(':checked');
		
	    });
	}
</script>

<aui:model-context bean="<%= scenario %>" model="<%= Scenario.class %>" />
<aui:model-context bean="<%= urlRequest %>" model="<%= Request.class %>" />
<%-- 				${layout.friendlyURL}"  --%>

<portlet:renderURL var="addScenarioURL"/>
<portlet:actionURL name="addRequest" var="addRequestURL" windowState="normal" />

<aui:form action="<%= addScenarioURL %>" method="POST" name="formulaireScenario">
	<aui:fieldset>
		<aui:input type="hidden" name="total"  id="total" value="<%= totalRate %>" />	
		<aui:input type="text" name="nameScenario" value="${scenarioName}"/>
		<table>		
			<tr><th></th><th>Page</th><th>weight</th> <th>weight(%) <th></tr>
			
			<c:forEach var="layout" items='${ listLayout }'>
				<tr>
					<td> <aui:input type="checkbox" name=""  onChange="<%= renderResponse.getNamespace() + \"showPoids()\"%>"/></td>
					<td>${layout.name} </td>	
					<td>
						<aui:input  name="rate"  class="rate">
							<aui:validator name="required" />
							<aui:validator name="range"> [0,100]</aui:validator>
							<aui:validator errorMessage="total-stess-rate-must-be-100% "
								name="custom"> 
							function(val, fieldNode, ruleValue){
								var total = document.getElementById("<portlet:namespace />total");
								console.log("total= "+total.value);
								return ( (total.value + val) == 100 ) ;
							}
							</aui:validator>
						</aui:input>
					</td>
					
					<td><label>0%</label></td>
				</tr>
			</c:forEach>
		</table>
		<aui:input  type="text" name="poidForce" id="poidForce"> 
			<aui:validator name="required"/>
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
