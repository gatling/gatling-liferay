<%@include file="/html/gatling/header.jsp"%>
<liferay-ui:error-marker key="errorSection" value="scenario" />

<aui:fieldset>
	<aui:input type="hidden" name="scenarioId" value='${empty scenario ? "" : scenario.scenario_id }' />
	<aui:input type="hidden" name="groupId" value='${scenario.group_id}' />
	
	<aui:input label="scenario-edit-force-weight" name="forceWeight" inlineField="true" />
	<aui:button value="scenario-edit-force-weight-btn" cssClass="inline-button" onClick="forceWeight();"/>
	<table class="table table-bordered table-scenario">
		<tr>
			<liferay-util:buffer var="checkAll">
				<i class='icon-circle-arrow-down'></i> <liferay-ui:message key="select-all" />
			</liferay-util:buffer>
			<th><aui:input type="checkbox" name="checkAll" label="${checkAll}" /></th>
			<th><liferay-ui:message key="scenario-edit-table-header-page" /><liferay-ui:icon-help message="name-info-help"/></th>
			<th><liferay-ui:message key="scenario-edit-table-header-weight" /> <liferay-ui:icon-help message="weight-info-help"/></th>
			<th><liferay-ui:icon-help message="percentage-info-help"/></th>
		</tr>
		<c:if test="${ listPages.size() ==0 }">
			<tr>
				<td>
					<label style="color: green"> <liferay-ui:message key="no-page" /></label>
				</td>
			</tr>
		</c:if>
		<%--
		
		FOR EACH Display
		
		 --%>
		<c:forEach var="layout" items='${ listPages }' varStatus="status">
			<%-- Add a variable to know if we need to ask the user about upgrading its scenario --%>
			<c:if test="${empty confirmUpgrade && (layout.state == 'NEW_REQUEST' || layout.state == 'OLD_REQUEST') }">
				<c:set var="confirmUpgrade" value="confirmUpgrade" />
			</c:if>
		 	<%--subpages --%>
		 	<c:set var="arraySubPage"  />
			<c:if test="${not empty hierachy[layout.displayLayoutId]}">
				<c:forEach var="i" items="${hierachy[layout.displayLayoutId]}" varStatus="info">
					<c:set var="arraySubPage" value="${arraySubPage}${i}" />
					<c:if test="${not info.last}">
						<c:set var="arraySubPage" value="${arraySubPage}," />
					</c:if>
				</c:forEach>
			</c:if>
			 <%-- Weight = 0 ? blue line --%>
			<c:set var="color"/>
			<c:if test="${not layout.isUsed() }" >
				<c:set var="color" value="empty-weight-color"/>
			</c:if>
			<%--private or public url --%>
			<c:choose>
				<c:when test="${layout.privateLayout}">
					<c:set var="url" value="${privateURL}${layout.url}"/>
				</c:when>
				<c:otherwise>
					<c:set var="url" value="${publicURL}${layout.url}"/>
				</c:otherwise>
			</c:choose>
			<%--
				DISPLAY
			 --%>
			<c:choose>
				<c:when test="${layout.state == 'NEW_REQUEST'}">
					<%-- 
					
					If the layout doesn't exists in db
					
					 --%>
					<tr class="success ${layout.displayLayoutId} ${color }">
						<%-- Affichage request pas enregistrée --%>
						<td>
							<aui:input type="checkbox" label="" name="${status.index}" cssClass='activate' inlineField="true"/> 
							<c:if test="${not empty arraySubPage}">
								<i class="force-weight-children  icon-circle-arrow-down margin-left-5" data-children="${arraySubPage }" ></i>
							</c:if>
						</td>
						<td><i class="icon-plus-sign"></i> ${layout.showName()}
							<a href="${url}" title="${layout.url}" target="_blank"> 
								<i class="icon-share"></i>
							</a>
						</td>

						<td><aui:input label="" name="weight${status.index}" cssClass="weight " inlineField="true" onChange="showWeight()"
								value="${layout.weight}">
								<aui:validator name="number" />
							</aui:input>
							
						</td>
						<td><span class='percentage'>0.00%</span></td>
					</tr>
				</c:when>
				<c:when test="${layout.state == 'OLD_REQUEST'}">
					<%-- 
					
					When the layout is in DB but not in the site
					
					--%>
					<tr class="error">
						<%-- Affichage request pas enregistrée --%>
						<td>
							<aui:input name="delete${layout.requestId}" type="hidden" value="${layout.requestId}"></aui:input>
						</td>						
						<td>
							<portlet:actionURL var="deleteRequestURL" name="removeRequest">
								<portlet:param name="requestId" value="${layout.requestId}" />
							</portlet:actionURL> <liferay-ui:icon-delete url="${deleteRequestURL}" />
						</td>
						<td><i class="icon-exclamation-sign"></i> <a href="#" title="${layout.url}" target="_blank">${layout.showName()}</a></td>
						<td><aui:input label="" name="weight${layout.requestId}" value="${layout.weight}" cssClass="weight deleted" onChange="showWeight()">
								<aui:validator name="number" />
							</aui:input></td>
						<td><span class='percentage'>0.00%</span></td>
					</tr>
				</c:when>
				<c:otherwise>
					<%--  
					
					Exists in both
					
					 --%>
					<tr class="${layout.displayLayoutId} ${color}">
						<td>
							<aui:input type="checkbox" label="" name="${status.index}" cssClass='activate' inlineField="true"/>
							<c:if test="${not empty arraySubPage}">
								<i class="force-weight-children  icon-circle-arrow-down margin-left-5" data-children="${arraySubPage }" ></i>
							</c:if>
						</td>
						<td>${layout.showName()}<a href="${url}" title="${layout.url}" target="_blank" > <i class="icon-share"></i></a></td>

						<td><aui:input label="" name="weight${status.index}" cssClass="weight" inlineField="true" value="${layout.weight}"
								onChange="showWeight()">
								<aui:validator name="number" />
							</aui:input>
						</td>
						<td><span class='percentage'>0.00%</span></td>
					</tr>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		<%--
			END FOR EACH
		 --%>
	</table>
</aui:fieldset>