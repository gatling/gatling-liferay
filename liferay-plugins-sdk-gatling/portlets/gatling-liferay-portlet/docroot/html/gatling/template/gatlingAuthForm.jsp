<%@ page import="com.liferay.portal.model.CompanyConstants" %>


	<aui:button  value="gatling-auth-user" onClick="showAuthForm()" /> 		|		 
	<a id="uploadCsvUser" href="#"><i class="icon-upload"></i> <liferay-ui:message key="upload-auth-csv" /> </a> <liferay-ui:icon-help message="message-help-auth"/>
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
				A.one("#userAuth").show();
			});
		}
	
	</aui:script>
	
