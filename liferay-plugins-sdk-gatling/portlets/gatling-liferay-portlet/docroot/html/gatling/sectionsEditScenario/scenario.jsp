<%-- 
	Copyright 2011-2014 eBusiness Information, Groupe Excilys (www.ebusinessinformation.fr)
--%>
<%@include file="/html/gatling/header.jsp"%>

<aui:fieldset label="scenario">
	<aui:input type="hidden" name="scenarioId" value='${empty scenario ? "" : scenario.scenario_id }' />
	<aui:input type="hidden" name="groupId" value='${scenario.group_id}' />

	<portlet:renderURL var="helpURL" windowState="pop_up">
		<portlet:param name="page" value="/html/gatling/help.jsp" />
	</portlet:renderURL>
	<div class="well well-small">
		<liferay-ui:message key="scenario-edit-help-scenario" /> 
		<a href="#" class="label" id="help">
			<i class="icon-question-sign"></i> 
			<liferay-ui:message key="help-use-scenario" />
		</a> 
	</div>
	
	<table class="table table-bordered table-scenario">
		<tr> 
			<th class="small-column">
				<input type="checkbox" id="checkAll" /> 
				<label for="checkAll" class="inline"><i class='icon-circle-arrow-down'></i></label>
				<%--Force weight button --%>
				<aui:input label="" name="forceWeight" cssClass="forceinput" inlineField="true" />
				<aui:button value="scenario-edit-force-weight-btn" cssClass="inline-button" id="force" onClick="forceWeight();" />
				<liferay-ui:icon-help message="scenario-edit-force-weight"/>
			</th>
			<th><liferay-ui:message key="scenario-edit-table-header-page" /> <liferay-ui:icon-help message="name-info-help"/></th>
			<th><liferay-ui:message key="scenario-edit-table-header-portlet" /></th>
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
			<%-- Add a variable to know if we need to ask the user about upgrading the scenario --%>
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
			<c:set var="url" value="${publicURL}${layout.url}"/>
			<%--
				DISPLAY
			 --%>
			<c:choose>
				<c:when test="${layout.state == 'NEW_REQUEST'}">
					<%-- 
					
					If the layout doesn't exists in db
					
					 --%>
					<tr class="success ${layout.displayLayoutId} ${color }" >
						<%-- Affichage request pas enregistrée --%>
						<td>
							<input type="checkbox" name="${status.index}" class='checkLine' /> 
							<c:if test="${not empty arraySubPage}">
								<i class="icon-minus  show-hide-children" data-children="${arraySubPage }" ></i>
								<i class="force-weight-children  icon-circle-arrow-down margin-left-5" data-children="${arraySubPage }" ></i>
							</c:if> 							
						</td>
						<td>
							<c:if test="${layout.privateLayout}">
								<i class="icon-eye-close"></i>
							</c:if>
							<i class="icon-plus-sign"></i> 
							<a href="${url}" title="${layout.url}" target="_blank" style="margin-left:${layout.numberOfSpace}*10px"> 
								${layout.name}
							</a>
							
							
						</td>
						<td>
							<aui:button cssClass="show-portlet" data-id="${layout.requestId}" value="scenario-edit-stress-portlet-btn"/>
						</td>
						<td>
							<aui:input label="" name="weight${status.index}" cssClass="weight " inlineField="true" onChange="showWeight()"
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
							<input name="delete${layout.requestId}" type="hidden" value="${layout.requestId}" /> 
							<portlet:actionURL var="deleteRequestURL" name="removeRequest">
								<portlet:param name="requestId" value="${layout.requestId}" />
							</portlet:actionURL> <liferay-ui:icon-delete url="${deleteRequestURL}" />
						</td>

						<td>
							<c:if test="${layout.privateLayout}">
								<i class="icon-eye-close"></i>
							</c:if>
							<i class="icon-exclamation-sign"></i> 
							<a href="${url}" title="${layout.url}" target="_blank" style="margin-left:${layout.numberOfSpace*30}px"> 
								${layout.name}
							</a></td>
						<td>

						<td><aui:input label="" name="weight${status.index}" value="${layout.weight}" cssClass="weight deleted" onChange="showWeight()">
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
							<input type="checkbox"  name="${status.index}" class='checkLine'/>
							<c:if test="${not empty arraySubPage}">
								<i class="icon-minus   show-hide-children" data-children="${arraySubPage }" ></i>
								<i class="force-weight-children  icon-circle-arrow-down margin-left-5" data-children="${arraySubPage }" ></i>
							</c:if>
						</td>
						<td>
							<c:if test="${layout.privateLayout}">
								<i class="icon-eye-close"></i>
							</c:if>
							<a href="${url}" title="${layout.url}" target="_blank" style="margin-left:${layout.numberOfSpace*30}px"> 
								${layout.name}
							</a>
						</td>
						<td>
							<aui:button cssClass="show-portlet" data-id="${layout.requestId}" value="scenario-edit-stress-portlet-btn"/>
						</td>

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
<script type="text/javascript">
	AUI().use('aui-base','liferay-portlet-url', function(A) {
		A.all(".show-portlet").each(function() {
			this.on('click', function(A) {
				var id = this.getData('id');
				console.log("showPortlet "+id);
				//Create renderURL
				var renderURL = Liferay.PortletURL.createRenderURL();
				renderURL.setPortletId("gatling_WAR_gatlingliferayportlet");
				renderURL.setParameter("pagePortletId", id);
				renderURL.setParameter("jspPage","/html/gatling/popupPortlet/portletConfig.jsp");
				renderURL.setWindowState("pop_up");
			
				Liferay.Util.openWindow({
			   		dialog : {
			        	modal : true,
			            constrain : true,
			         	destroyOnClose : true,
			            cache : false
			        },
			        title : "Page Y / Portlet X",
			        uri : renderURL.toString()
			   });	
			});
		});
		
		A.one("#help").on('click', function(A) {
			Liferay.Util.openWindow({
			     dialog : {
			          	modal : true,
			           	constrain : true,
			            cache : true
			        },
			        uri : '${helpURL}#use-scenario',
			        title : '<liferay-ui:message key="help-how-to-use-load-test-portlet"/>'
			  });
		});
		
		
		
		A.all('.show-hide-children').each(function() {
		      this.on('click',function(event) {
		    	  var hide = true;
		    	  if(this.hasClass('icon-minus')){
		    		  this.addClass('icon-plus');
			    	  this.removeClass('icon-minus');
		    	  }
		    	  else{
		    		  this.addClass('icon-minus');
			    	  this.removeClass('icon-plus');
			    	  hide = false;
		    	  }
		    	  var children = this.getData("children").split(',');
		    	  
		    	  for (var i = 0; i < children.length; i++) {
		    		var node = A.one('.'+children[i]);
		    			showHideSubPage(children[i], hide);
					}
			});
		});
	});
	
	function showHideSubPage(child, hide) {
		AUI().use('aui-base', function(A) {
			var node = A.one('.'+child);
			if(node != null) {
				node.set("hidden",hide);
				var nodeList = node.one(".show-hide-children");
				if(nodeList != null) {
					var children = nodeList.getData("children").split(",");
					for (var i = 0; i < children.length; i++) {
						showHideSubPage(children[i], hide);
					}
				}
			}
	    });
	}
</script>
