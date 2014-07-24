<%@include file="/html/gatling/header.jsp"%>
<liferay-ui:error-marker key="errorSection" value="scenario" />

<aui:fieldset>
	<aui:input type="hidden" name="scenarioId" value='${empty scenario ? "" : scenario.scenario_id }' />
	<aui:input type="hidden" name="groupId" value='${scenario.group_id}' />
	<table class="table table-bordered table-scenario">
		<tr>
			<th><input type="checkbox" id="checkAll" /> <liferay-ui:message key="scenario-edit-table-header-activate" /></th>
			<th><liferay-ui:message key="scenario-edit-table-header-page" /></th>
			<th><liferay-ui:message key="scenario-edit-table-header-weight" /> <input type="text" name="poidForce" id="<portlet:namespace/>poidForce"
				class="margin-left" /> <aui:button type="button" value="scenario-edit-force-weight-btn" onClick="<%=renderResponse.getNamespace() +\"forcePoids()\" %>" /></th>
			<th><liferay-ui:message key="scenario-edit-table-header-percentage" /></th>
		</tr>
		<c:if test="${ listPages.size() ==0 }">
			<tr>
				<td><label style="color: green"> <liferay-ui:message key="no-page" />
				</label></td>
			</tr>
		</c:if>
		<%--
		
		FOR EACH
		
		 --%>
		<c:forEach var="layout" items='${ listPages }' varStatus="status">
			<c:choose>
				<c:when test="${layout.state == 'NEW_REQUEST'}">
					<%-- 
					
					If the layout doesn't exists in db
					
					 --%>
					<tr class="success">
						<%-- Affichage request pas enregistrée --%>
						<td><aui:input type="checkbox" name="${status.index}" cssClass='activate' onChange="showPoids()" /></td>
						<td>${layout.showName()}</td>
						<td><aui:input label="" name="weight${status.index}" cssClass="poids ${layout.displayLayoutId}" inlineField="true" onChange="showPoids()"
								value="${layout.weight}">
								<aui:validator name="number" />
							</aui:input> <c:if test="${not empty hierachy[layout.displayLayoutId]}">
								<c:set var="arraySubPage" value="" />
								<c:forEach var="i" items="${hierachy[layout.displayLayoutId]}" varStatus="info">
									<c:set var="arraySubPage" value="${arraySubPage}'${i}'" />
									<c:if test="${not info.last}">
										<c:set var="arraySubPage" value="${arraySubPage}," />
									</c:if>
								</c:forEach>
								<aui:button cssClass="force-weight-childs" data-childs="${arraySubPage}" value="Force-the-weight-to-the-sub-pages" />
							</c:if></td>
						<td><span class='percentage'>0%</span></td>
					</tr>
				</c:when>
				<c:when test="${layout.state == 'OLD_REQUEST'}">
					<%-- 
					
					When the layout is in DB but not in the site
					
					--%>
					<tr class="error">
						<%-- Affichage request pas enregistrée --%>
						<aui:input name="delete${layout.requestId}" type="hidden" value="${layout.requestId}"></aui:input>
						<td><portlet:actionURL var="deleteRequestURL" name="removeRequest">
								<portlet:param name="requestId" value="${layout.requestId}" />
							</portlet:actionURL> <liferay-ui:icon-delete url="${deleteRequestURL}" /></td>
						<td>${layout.showName()}</td>
						<td><aui:input label="" name="weight${layout.requestId}" value="${layout.weight}" cssClass="poids deleted" onChange="showPoids()">
								<aui:validator name="number" />
							</aui:input></td>
						<td><span class='percentage'>0%</span></td>
					</tr>
				</c:when>
				<c:otherwise>
					<%--  
					
					Exists in both
					
					 --%>
					<tr>
						<td>
							<%-- checked ou pas en fonction de la requête --%> <c:choose>
								<c:when test="${layout.checked}">
									<aui:input type="checkbox" name="${status.index}" cssClass='activate url${status.index}' checked="true" onChange="showPoids()" />
								</c:when>
								<c:otherwise>
									<aui:input type="checkbox" name="${status.index}" cssClass='activate url${status.index}' checked="false" onChange="showPoids()" />
								</c:otherwise>
							</c:choose>
						</td>

						<td>${layout.showName()}</td>

						<td><aui:input label="" name="weight${status.index}" cssClass="poids ${layout.displayLayoutId}" inlineField="true" value="${layout.weight}"
								onChange="showPoids()">
								<aui:validator name="number" />
							</aui:input> <c:if test="${not empty hierachy[layout.displayLayoutId]}">
								<%--reset value --%>
								<c:set var="arraySubPage" value="" />
								<c:forEach var="i" items="${hierachy[layout.displayLayoutId]}" varStatus="info">
									<c:set var="arraySubPage" value="${arraySubPage}${i}" />
									<c:if test="${not info.last}">
										<c:set var="arraySubPage" value="${arraySubPage}," />
									</c:if>
								</c:forEach>
								<aui:button cssClass="force-weight-childs" data-childs="${arraySubPage}" value="Force-the-weight-to-the-sub-pages" />
							</c:if></td>
						<td><span class='percentage'>0%</span></td>
					</tr>
				</c:otherwise>
			</c:choose>
			<%--Add a variable to know if we need to ask the user about upgrading its scenario --%>
			<c:if test="${empty confirmUpgrade && (layout.state == 'NEW_REQUEST' || layout.state == 'OLD_REQUEST') }">
				<c:set var="confirmUpgrade" value="confirmUpgrade" />
			</c:if>
		</c:forEach>
		<%--
			END FOR EACH
		 --%>
	</table>
</aui:fieldset>