<%@ include file="/html/portlet/users_admin/init.jsp" %>
<%
User selUser = (User)request.getAttribute("user.selUser");
%>

<aui:fieldset>
	<div class="ctrl-holder">
		<liferay-ui:custom-attribute
			className="com.liferay.portal.model.User"
			classPK="<%= (selUser != null) ? selUser.getUserId() : 0 %>"
			editable="<%= true %>"
			label="<%= true %>"
			name="interested-in-becoming-an-astronaut"
		/>
	</div>
	<div class="ctrl-holder">
		<liferay-ui:custom-attribute
			className="com.liferay.portal.model.User"
			classPK="<%= (selUser != null) ? selUser.getUserId() : 0 %>"
			editable="<%= true %>"
			label="<%= true %>"
			name="comments-astronauts"
		/>
	</div>

</aui:fieldset>