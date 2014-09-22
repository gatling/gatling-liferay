<%@ page import="com.liferay.portal.model.CompanyConstants" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ page import="com.liferay.portal.kernel.util.Validator"%>
<%@ page import="javax.portlet.PortletPreferences"%>
<%@ page import="com.liferay.util.PwdGenerator"%>
<portlet:defineObjects />

<%
	String uploadProgressId = PwdGenerator.getPassword(PwdGenerator.KEY3, 4);
    PortletPreferences prefs = renderRequest.getPreferences();

%>

   

<portlet:actionURL var="uploadURL" name="uploadCase">
    <portlet:param name="jspPage" value="/edit.jsp" />
</portlet:actionURL>
<liferay-ui:success key="success" message=" YEAH. Case uploaded successfully!" />
<%-- <liferay-ui:error key="error" --%>
<%--     message="Sorry, an error prevented the upload. Please try again." /> --%>
<%--     <liferay-ui:upload-progress --%>
<%--     id="<%= uploadProgressId %>" --%>
<%--     message="uploading" --%>
<%--     redirect="<%= editCaseURL %>" --%>
<%--   /> --%>
<%-- <portlet:renderURL var="viewCaseURL"> --%>
<%--     <portlet:param name="jspPage" value="/view2.jsp" /> --%>
<%-- </portlet:renderURL> --%>

<%-- <aui:button onClick="<%=viewCaseURL%>" value="view Uploaded Case" /> --%>

	<aui:button  value="gatling-auth-user" onClick="showAuthForm()" /> 		|		 
	<aui:a id="uploadCsvUser" href="#" onClick="showuploadForm()"><i class="icon-upload"></i> <liferay-ui:message key="upload-auth-csv" /> </aui:a> <liferay-ui:icon-help message="message-help-auth"/>
	
	<div hidden="true" id="uploadForm">
<%-- 		<aui:form action="<%= uploadURL %>" enctype="multipart/form-data" method="post" > --%>
			<aui:input type="hidden" name="upload" id="upload" value="true"/>
			<aui:input type="file" name="fileName" 	 size="75"/>
<%-- 			<input type="submit" value="<liferay-ui:message key="upload" />" onClick="<%= uploadProgressId %>.startProgress(); return true;"/> --%>
<%-- 		</aui:form> --%>
	</div>
	
	<div hidden="true" id="userAuth">
		<c:if test='${ authType.equals("emailAddress") }'>
			<aui:input label="gatling_auth_user-EA" name="login" type="text" required="true"  id="log" /> 
		</c:if>
		<c:if test='${ authType.equals("screenName") }'>
			<aui:input label="gatling_auth_user-SN" name="login" type="text" required="true" id="log" /> 
		</c:if>
		<c:if test='${ authType.equals("userId") }'>
			<aui:input label="gatling_auth_user-ID" name="login" type="text" required="true" id="log" /> 
		</c:if>
		
		<aui:input label="gatling-auth-user-password" name="password" type="password" required="true" id="pass" />
	</div>
	
	<aui:script>
		
		function showAuthForm(){
			AUI().use('aui-base',
			function(A) {
				if(A.one("#userAuth").get('hidden') == true){
					A.one("#userAuth").show();
				}
				else{
					A.one("#userAuth").hide();
				}
			});
		}
		
		function showuploadForm(){
			AUI().use('aui-base',
			function(A) {
				if(A.one("#uploadForm").get('hidden') == true){
					A.one("#uploadForm").show();
					A.one("#<portlet:namespace/>upload").val('true');
				}
				else{
					A.one("#uploadForms").hide();
					A.one("#<portlet:namespace/>upload").val('false');
				}
			});
		}
	
	</aui:script>
	
