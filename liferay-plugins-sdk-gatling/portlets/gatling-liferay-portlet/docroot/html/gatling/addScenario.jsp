<%@include file="/html/gatling/header.jsp" %>

<%
	//url list send by the controler
	List<String> listUrls = new ArrayList<String>();
	listUrls.add("www.google.fr");
	listUrls.add("www.excilys.com");
	listUrls.add("www.liferay.com");
	Request urlRequest = null;
	if((request.getParameter("urlToAdd") != null)&&(request.getParameter("urlRate") != null)){
		urlRequest =null;
	}
	
	Scenario scenario = null;
	List<Request> listUrlToStress = new ArrayList<Request>();
	int totalRate = 0;
%>

<aui:script>

	function <portlet:namespace/>hideForm(){
		alert("cacher le formulaire ajout scenario");
		var A = AUI();
		A.one('#scenario').hide();		
	}
	
	function <portlet:namespace/>addRequest()
	{
		alert("add request ");
		var A = AUI();		
		var u = A.one('#url');
		var r = A.one('#rate');
		if(u==null){
			console.log("impossible de récupérer l'elmt");
		}
		else{
			console.log("url sellectionnée ");
			}
<!-- 		location.href="addRequest?urlToAdd="+u+"&urlRate="+r;  -->
	}
	
<%-- 	function <portlet:namespace/>addScenario() --%>
<!-- 	{ -->
<!-- 		alert("scenario added");  -->
<%-- 		<portlet:namespace/>hideForm(); --%>
<!-- 	} -->
	
</aui:script>

<aui:model-context bean="<%= scenario %>" model="<%= Scenario.class %>" />
<aui:model-context bean="<%= urlRequest %>" model="<%= Request.class %>" />

<aui:form action="" method="POST" name="formulaire-scenario">
	<aui:fieldset>
	
		
		
		<table>
		<tr> <aui:input type="text" name="nameScenario" /></tr>
		<tr>
			<td>
			<aui:select name="url" class="url" id="url" >
				<aui:option selected="true"> -- </aui:option>
				<c:forEach items="<%= listUrls%>" var="u" varStatus="boucle">
					<aui:option>${u} </aui:option>
				</c:forEach>
		
			</aui:select>
			</td>
			
			<td>
			<aui:input name="rate" id="rate" class="rate">
				<aui:validator name="digits" />
				<aui:validator name="range" > [0,100] </aui:validator>
<%-- 				<aui:validator errorMessage="total-stess-rate-must-be-maximum-100% " name="custom">  --%>
<!-- 					function(val, fieldNode, ruleValue){ -->
<!-- 						totalRate += val; -->
<!-- 						return ( totalRate == 100 ) ; -->
<!-- 					} -->
<%-- 				</aui:validator> --%>
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