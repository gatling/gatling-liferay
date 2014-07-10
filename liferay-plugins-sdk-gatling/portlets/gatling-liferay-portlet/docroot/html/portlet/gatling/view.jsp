<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>

<portlet:defineObjects />

This is the
<b>Vulcan Portlet</b>
portlet in View mode.

<%@ include file="/html/portlet/init.jsp"%>

<aui:row>

	<aui:fieldset column="<%=true%>">
		<aui:select name="Sites">
			<aui:option value="" />
		
 			<c:forEach var="page" items="${pageSiteWrapper}">
				
				<aui:option label="${page.label}" value="${page.value}" />

			</c:forEach>
		
		</aui:select>
	</aui:fieldset>

</aui:row>

