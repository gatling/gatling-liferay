<%@ include file="/html/portlet/login/init.jsp"%>

<liferay-util:buffer var="html">
	<liferay-util:include
		page="/html/portlet/login/create_account.portal.jsp" />
</liferay-util:buffer>

<liferay-util:buffer var="customHtml">
	<liferay-ui:custom-attribute className="<%= User.class.getName() %>"
		classPK="<%= 0 %>" editable="<%= true %>" label="<%= true %>"
		name="interested-in-becoming-an-astronaut" />
</liferay-util:buffer>

<%!
	public int nthIndexOf(String substr, String str, int n, int fromIndex) {

		if (n < 1) {
			return -1;
		}

		int pos = str.indexOf(substr, fromIndex);
		while (n > 1 && pos != -1) {
			pos = str.indexOf(substr, pos + 1);
			n--;
		}
		return pos;
	}
%>

<%
	int x = html.lastIndexOf("<script type=\"text/javascript\"");
	int y;
	if (x != -1) {
		y = html.indexOf("</script>", x);

		html = html.substring(0, x) + html.substring(y + 9);
	}

	html = html.replace(LanguageUtil.get(pageContext, "save"),
			LanguageUtil.get(pageContext, "create"));

	x = html.indexOf(LanguageUtil.get(pageContext, "email-address"));

	if (x != -1) {
		y = nthIndexOf("</div>", html, 2, x);

		html = html.substring(0, y) + customHtml + html.substring(y);
	}
%>

<%=html%>