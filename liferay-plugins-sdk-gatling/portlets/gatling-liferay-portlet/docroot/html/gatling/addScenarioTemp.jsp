<%@include file="/html/gatling/header.jsp" %>

<%
	Request urlRequest = null;
	Scenario scenario = null;
	List<Request> listUrlToStress = new ArrayList<Request>();
%>

<aui:model-context bean="<%= scenario %>" model="<%= Scenario.class %>" />
<aui:model-context bean="<%= urlRequest %>" model="<%= Request.class %>" />

<aui:form action="" method="POST" name="formulaireScenario">
	<aui:fieldset>
		<aui:input type="hidden" name="total"  id="total" value="0" />	
		<table>
		<tr> <aui:input type="text" name="nameScenario" /></tr>
		<tr>
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
				<aui:validator errorMessage="total-stess-rate-must-be-maximum-100% " name="custom"> 
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
					<aui:button type="button" value="Add Request" onClick="<%= renderResponse.getNamespace() + \"addRequest()\"%>"/>
				</aui:button-row>
			</td>
		</tr>
		</table>
	</aui:fieldset>
	
	
	<c:if test="${ listUrlToStress.size() != 0 }">
		<table>
			<c:forEach items="<%= listUrlToStress%>" var="urlToStress" varStatus="boucle">
				<tr> <td>${urlToStress.url} </td> <td>${urlToStress.rate} </td></tr>
			</c:forEach>
		</table>
	</c:if>

	<aui:button-row>
		<aui:button type="submit" value="addScenario" onClick="<%= renderResponse.getNamespace() + \"addScenario()\"%>"/>
		<aui:button type="cancel"  onClick="<%= renderResponse.getNamespace() + \"hideForm()\"%>" />
	</aui:button-row>
</aui:form>
