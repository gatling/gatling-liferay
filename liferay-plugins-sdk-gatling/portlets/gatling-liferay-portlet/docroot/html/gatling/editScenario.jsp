<%@include file="/html/gatling/header.jsp" %>

<%
	String redirect = PortalUtil.getCurrentURL(renderRequest);
	Request urlRequest = null;
	Scenario scenario = null;
	int totalRate = ParamUtil.getInteger(request,"totalRate");
%>

<aui:model-context bean="<%= scenario %>" model="<%= Scenario.class %>" />
<aui:model-context bean="<%= urlRequest %>" model="<%= Request.class %>" />


<portlet:renderURL var="addScenarioURL"/>
<portlet:actionURL name="addRequest" var="addRequestURL" windowState="normal" />

<aui:form action="<%= addScenarioURL %>" method="POST" name="formulaireScenario">
	<aui:fieldset>
		<aui:input type="hidden" name="total"  id="total" value="<%= totalRate %>" />	
		<table>
		<tr> <aui:input type="text" name="nameScenario" /></tr>
		<tr>
			
			<aui:form action="" method="POST" name="formulaireRequest">
				<td>
					<aui:select name="url" id="url">
						<aui:option selected=""> -- </aui:option>
						<c:forEach var="layout" items='${ listLayout }'>
						
							<aui:option label="${layout.name}" value="${layout.friendlyURL}" />
		
						</c:forEach>
					</aui:select>
				</td>

				<td>			
				<aui:input name="rate" id="rate" class="rate" >
					<aui:validator name="required"/>
					<aui:validator name="range"> [0,100]</aui:validator>
					<aui:validator errorMessage="total-stess-rate-must-be-100% " name="custom"> 
						function(val, fieldNode, ruleValue){
						var total = document.getElementById("<portlet:namespace />total")
							console.log("total= "+total.value);
							return ( (total.value + val) == 100 ) ;
						}
					</aui:validator>
				</aui:input> 
	
				</td>
			
				<td>
					<aui:button-row>					
						<aui:button type="button" value="Add Request" onClick="<%= addRequestURL%>"/>
					</aui:button-row>
				</td>
			</aui:form>
		</tr>
		</table>
	</aui:fieldset>
	
	
	<c:if test="${ listUrlToStress.size() != 0 }">
		<table>
			<c:forEach items="${ listUrlToStress }" var="urlToStress" varStatus="boucle">
				<tr> <td>${urlToStress.url} </td> <td>${urlToStress.rate} </td></tr>
			</c:forEach>
		</table>
	</c:if>

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
