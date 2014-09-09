<%-- 
	Copyright 2014 eBusiness Information, Groupe Excilys (www.ebusinessinformation.fr)
--%>
<%@include file="/html/gatling/header.jsp"%>

<aui:fieldset label="scenario">
	<aui:input type="hidden" name="scenarioId"
		value='${empty scenario ? "" : scenario.scenario_id }' />
	<aui:input type="hidden" name="groupId" value='${scenario.group_id}' />

	<portlet:renderURL var="helpURL" windowState="pop_up">
		<portlet:param name="page" value="/html/gatling/help.jsp" />
	</portlet:renderURL>
	<div class="well well-small">
		<liferay-ui:message key="scenario-edit-help-scenario" />
		<a href="#help" class="label" id="help"> <i class="icon-question-sign"></i>
			<liferay-ui:message key="help-use-scenario" />
		</a>
	</div>

	<table class="table table-bordered table-scenario">
		<thead>
		<tr>
			<th class="small-column"><input type="checkbox" id="checkAll" />
				<label for="checkAll" class="inline"><i class='icon-circle-arrow-down'></i></label>
				<aui:input label="" name="forceWeight" cssClass="forceinput" inlineField="true" />
				<%--Force weight button --%>
				<aui:button value="scenario-edit-force-weight-btn" cssClass="inline-button" id="force" onClick="forceWeight();" /> 
				<liferay-ui:icon-help message="scenario-edit-force-weight" /></th>
			<th ><liferay-ui:message key="scenario-edit-table-header-page" />
				<liferay-ui:icon-help message="name-info-help" /></th>
			<th class="small-column"><liferay-ui:message key="scenario-edit-table-header-portlet" /></th>
			<th class="small-column"><liferay-ui:message key="scenario-edit-table-header-weight" />
				<liferay-ui:icon-help message="weight-info-help" /></th>
			<th class="small-column"><liferay-ui:icon-help message="percent-info-help" /></th>
		</tr>
		</thead>
		<c:if test="${ listPages.size() ==0 }">
			<tr>
				<td><label style="color: green"> <liferay-ui:message key="no-page" /></label></td>
			</tr>
		</c:if>
		<%--
		
		FOR EACH Display
		
		 --%>
		<tbody>
		<c:forEach var="layout" items='${ listPages }' varStatus="status">
			<%-- Add a variable to know if we need to ask the user about upgrading the scenario --%>
			<c:if test="${empty confirmUpgrade && !layout.portlet && layout.state != 'DEFAULT' }">
				<c:set var="confirmUpgrade" value="confirmUpgrade" />
			</c:if>
			<%--subpages --%>
			<c:set var="arraySubPage" />
			<c:if test="${not empty layout.subNodes}">
				<c:forEach var="i" items="${layout.subNodes}" varStatus="info">
					<c:set var="arraySubPage" value="${arraySubPage}${i}" />
					<c:if test="${not info.last}">
						<c:set var="arraySubPage" value="${arraySubPage}," />
					</c:if>
				</c:forEach>
			</c:if>
			<%--Portlets --%>
			<c:set var="portletList" />
			
			<c:if test="${not empty layout.pagePortlet}">
				<c:set var="pageName" value="${layout.name}" />
				<c:set var="parentRequestId" value="${layout.requestId}"/>
				<c:forEach var="i" items="${layout.pagePortlet}" varStatus="info">
					<c:set var="portletList" value="${portletList}${i}" />
					<c:if test="${not info.last}">
						<c:set var="portletList" value="${portletList}," />
					</c:if>
				</c:forEach>
			</c:if>
			<%-- Weight = 0 ? blue line --%>
			<c:set var="color" />
			<c:if test="${not layout.isUsed() }">
				<c:set var="color" value="empty-weight-color" />
			</c:if>
			<c:choose>
				<c:when test="${ layout.privateItem}">
					<c:set var="url" value="${privateURL}${layout.url}" />
				</c:when>
				<c:otherwise>
					<c:set var="url" value="${publicURL}${layout.url}" />
				</c:otherwise>
			</c:choose>
			<%--
				DISPLAY
			 --%>
			<c:choose>
				<%--
				
					If it is a portlet
				
				 --%>
				<c:when test="${layout.portlet }">
					<tr id="${layout.displayId}" class="${color }" data-parent="${layout.parentDisplayId }"
						hidden="true">
						<td><input type="checkbox" name="${status.index}"
							class='checkLine' /></td>
						<td><i class="icon-th-large"></i>
							<a href="#" class="portlet-popup" style="margin-left:${(layout.depth-1)*30}px" data-requestId="${layout.requestId }"
								data-portlet="${layout.name}" data-page="${pageName}" data-groupId="${scenario.group_id}" 
								data-portletId="${layout.portletId}" data-parent="${parentRequestId}" data-plId="${layout.parentDisplayId}" > 
								 ${layout.name}  <i class="icon-wrench"></i>
							</a>
						</td>
						<td class="info-config muted">
							<c:choose>
							<c:when test="${layout.portletConfigured }">
								<liferay-ui:message key='portlet-configuration-ok' />
							</c:when>
							<c:otherwise>
								<liferay-ui:message key='portlet-configuration-ko' />
							</c:otherwise>
							</c:choose>
						
						</td>
						<td><aui:input label="" name="portlet${status.index}"
								cssClass="weight-portlet " inlineField="true" onChange="showWeightPortlet()"
								value="${layout.weight}">
								<aui:validator name="number" />
							</aui:input></td>
						<td><span style="margin-left:${(layout.depth)*15}px" class='percent'>0.00%</span></td>
					</tr>
				</c:when>
				<%-- 
					
					If the layout doesn't exist in db
					
				 --%>
				<c:when test="${layout.state == 'NEW_REQUEST'}">
					<tr id="${layout.displayId}" class="success ${color }">
						<%-- Affichage request pas enregistrée --%>
						<td><input type="checkbox" name="${status.index}"
							class='checkLine' /> <c:if test="${not empty arraySubPage}">
								<i class="icon-minus show-hide-children" data-children="${arraySubPage }"></i>
								<i class="force-weight-children icon-circle-arrow-down margin-left-5" data-children="${arraySubPage }"></i>
							</c:if></td>
						<td><c:if test="${layout.privateItem}">
								<i class="icon-eye-close"></i>
							</c:if>
							<i class="icon-plus-sign"></i> 
								<a href="${url}"
								title="${layout.url}" target="_blank"
								style="margin-left:${layout.depth*30}px"> ${layout.name} </a>
							</td>
						<td>
							<c:if test="${not empty portletList}">
								<aui:button cssClass="show-portlet"
									data-portlets="${portletList}"
									value="scenario-edit-stress-portlet-btn-show" />
							</c:if>
						</td>
						<td><aui:input label="" name="weight${status.index}"
								cssClass="weightPage " inlineField="true" onChange="showWeight()"
								value="${layout.weight}">
								<aui:validator name="number" />
							</aui:input>
						</td>
						<td><span class='percent'>0.00%</span></td>
					</tr>
				</c:when>
				<%-- 
				
				When the layout is in DB but not in the site
				
				--%>
				<c:when test="${layout.state == 'OLD_REQUEST'}">
					<tr class="error">
						<%-- Affichage request pas enregistrée --%>
						<td>
							<portlet:actionURL
								var="deleteRequestURL" name="removeRequest">
								<portlet:param name="requestId" value="${layout.requestId}" />
								<portlet:param name="scenarioId" value="${scenario.scenario_id}" />
							</portlet:actionURL> 
							<liferay-ui:icon-delete url="${deleteRequestURL}" />
						</td>

						<td><c:if test="${layout.privateItem}">
								<i class="icon-eye-close"></i>
							</c:if> 
							<i class="icon-exclamation-sign"></i> 
							<a href="${url}" title="${layout.url}" target="_blank" style="margin-left:${layout.depth*30}px"> ${layout.name} </a>
						</td>
						<td></td>
						<td><aui:input label="" name="weight${status.index}"
								value="${layout.weight}" cssClass="weightPage deleted"
								onChange="showWeight()">
								<aui:validator name="number" />
							</aui:input></td>
						<td><span class='percent'>0.00%</span></td>
					</tr>
				</c:when>
				<%--  
					
					Exists in both
					
				 --%>
				<c:otherwise>
					<tr id="${layout.displayId}" class="${color}">
						<td><input type="checkbox" name="${status.index}"
							class='checkLine' /> <c:if test="${not empty arraySubPage}">
								<i class="icon-minus   show-hide-children"
									data-children="${arraySubPage }"></i>
								<i class="force-weight-children  icon-circle-arrow-down margin-left-5"
									data-children="${arraySubPage }"></i>
							</c:if>
						</td>
						<td><c:if test="${layout.privateItem}">
								<i class="icon-eye-close"></i>
							</c:if> <a href="${url}" title="${layout.url}" target="_blank" style="margin-left:${layout.depth*30}px"> ${layout.name} </a>
						</td>
						<td><c:if test="${not empty portletList}">
								<aui:button cssClass="show-portlet" data-portlets="${portletList}"
									value="scenario-edit-stress-portlet-btn-show" />
							</c:if>
						</td>
						<td><aui:input label="" name="weight${status.index}"
								cssClass="weightPage" inlineField="true" value="${layout.weight}"
								onChange="showWeight()">
								<aui:validator name="number" />
							</aui:input></td>
						<td><span class='percent'>0.00%</span></td>
					</tr>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		</tbody>
		<%--
			END FOR EACH
		 --%>
	</table>
		<input id="recording" value="false" type="hidden"/>
</aui:fieldset>

<script type="text/javascript">
	AUI().use('aui-base','liferay-portlet-url','liferay-util-window', function(A) {
		var lastChecked = null;
		//multiselect
        var checkboxes = A.all(".checkLine");
        checkboxes.each(function() {
        		this.on('click', function(event) {
	                if(!lastChecked) {
	                    lastChecked = this;
	                    return;
	                }
	
	                if(event.shiftKey) {
	                    var start = checkboxes.indexOf(this);
	                    var end = checkboxes.indexOf(lastChecked);
	
	                    checkboxes.slice(Math.min(start,end), Math.max(start,end)+ 1).attr('checked', lastChecked.get("checked"));
	
	                }
	                lastChecked = this;
        		});
        });
		
		A.one("#checkAll").on('click',function(event) {
			var checked=this.get("checked");
			A.all(".checkLine").each(function() {
				this.set("checked", checked);
			});
			
			showWeight();
			if (A.all(".checkLine:checked").size()==0){
				A.one("#force").set('disabled', true);
				A.one(".forceinput").set('disabled', true);
			}
			else{
				A.one(".forceinput").set('disabled', false);
				A.one("#force").set('disabled', false);
			}
		});
			

		A.all(".checkLine").each(function() {
			this.on('click', function(event) {
				if (A.all(".checkLine:checked").size() === A.all(".checkLine").size()) {
					A.one("#checkAll").set("checked", true);
				} else {
					A.one("#checkAll").set("checked", false);
				}
				if (A.all(".checkLine:checked").size()==0){
					A.one("#force").set('disabled', true);
					A.one(".forceinput").set('disabled', true);
				}
				else{
					A.one(".forceinput").set('disabled', false);
					A.one("#force").set('disabled', false);
				}
			});
		});
		
		A.all(".show-portlet").each(function() {
			this.on('click', function(event) {
				this.toggleClass('toggled');
				if(this.hasClass('toggled')) {
					this.text('<liferay-ui:message key="scenario-edit-stress-portlet-btn-hide"/>');
				} else {
					this.text('<liferay-ui:message key="scenario-edit-stress-portlet-btn-show"/>');
				}
				var portlets = this.getData("portlets").split(',');
				for (var i = 0; i < portlets.length; i++) {
					var line = A.one("#"+portlets[i]);
					if(line.get('hidden')) {
						line.set('hidden', false);
					} else {
						line.set('hidden', true);
					}
				}
			});
		});
		
		A.all(".portlet-popup").each(function() {
			this.on('click' , function(event) {
				var portletId =this.getData("portletId");
				var pageName = this.getData("page");
				var portletName = this.getData("portlet");
				var groupId = this.getData("groupId");
				var plId = this.getData("plId");
				var requestId = this.getData("requestId");
				var lineId = this.ancestor("tr").get("id");
				//Create renderURL
				var renderURL = Liferay.PortletURL.createRenderURL();
				renderURL.setPortletId("gatling_WAR_gatlingliferayportlet");
				renderURL.setParameter("pagePortletId", portletId);
				renderURL.setParameter("groupId", groupId);
				renderURL.setParameter("plId", plId);
				renderURL.setParameter("requestId", requestId);
				renderURL.setParameter("lineId", lineId);
				renderURL.setParameter("page","/html/gatling/popupPortlet/portletConfig.jsp");
				renderURL.setWindowState("pop_up");
			
				
				var popupPortlet = Liferay.Util.openWindow({
			   		dialog : {
			        	modal : true,
			            cache : false,
			            draggable: false,
			            resizable: false,
			            closeOnEscape: false,
			         	destroyOnClose : true,
			         	width:'100%',
			         	height:'100%',
			            toolbars: {
			            	footer: [
			            	           {
			            	             label: 'Close portlet configuration',
			            	             cssClass : "btn-info",
			            	             on: {
			            	               click: function() {
			            	            	  checkAndHidePopup();
			            	               }
			            	             }
			            	           }
			            	         ]
		           			}
				        },
			        id : "<portlet:namespace/>pop_up_portlet",
			        title : "Page: "+pageName+" / Portlet: "+portletName,
			        uri : renderURL.toString()
			   	});

				
			});
		});
		
		function checkAndHidePopup() {
			var recording = (A.one("#recording").val().toLowerCase() === 'true');
			if(recording) {
				alert("<liferay-ui:message key='use-case-recording-alert' />");
			} else {
				var dialog = Liferay.Util.getWindow("<portlet:namespace/>pop_up_portlet");
				dialog.destroy();
			}
		}
		
		if (A.all(".checkLine:checked").size() === A.all(".checkLine").size())
			A.one("#checkAll").set("checked", true);

		
		if (A.all(".checkLine:checked").size()==0){
			A.one("#force").set('disabled', true);
			A.one(".forceinput").set('disabled', true);
		}
		else{
			A.one(".forceinput").set('disabled', false);
			A.one("#force").set('disabled', false);
		}
		
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
		
		A.all('.force-weight-children').each(function() {
		      this.on('click',function(event) {
					var children = this.getData("children").split(',');
					var node = this.ancestor("tr").one(".checkLine");
					var checked=true;
					if(node.get("checked")) {
					 	checked=false;	
					}
					node.set("checked",checked);
					for (var i = 0; i < children.length; i++) {
						selectSubPage(children[i], checked);
					}
					if (A.all(".checkLine:checked").size()==0){
						A.one("#force").set('disabled', true);
						A.one(".forceinput").set('disabled', true);
					}
					else{
						A.one(".forceinput").set('disabled', false);
						A.one("#force").set('disabled', false);
					}
			});
		});
	
		function selectSubPage(page, checked) {
			AUI().use('aui-base', function(A) {
				var node = A.one('#'+page);
				if(node != null) {
					node.one(".checkLine").set("checked",checked);
					var nodeList = node.one(".force-weight-children");
					if(nodeList != null) {
						var children = nodeList.getData("children").split(",");
						for (var i = 0; i < children.length; i++) {
							selectSubPage(children[i], checked);
						}
					}
				}
		    });
		}
		
		A.all('.show-hide-children').each(function() {
		     this.on('click',function(event) {
	    	 	var hide = true;
		    	if(this.hasClass('icon-minus')){
		    		this.addClass('icon-plus');
			    	this.removeClass('icon-minus');
		    	} else{
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
			var node = A.one('#'+child);
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
	 
	
	function forceWeight()
	{		
		AUI().use('aui-base', function(A) {
			var newVal = A.one('#<portlet:namespace/>forceWeight').val();
			if ((newVal != null) && (!isNaN(newVal))) {
				A.all('.checkLine:checked').each(function() {
					this.ancestor("tr").one(".field").val(newVal);
				});
				showWeight();
			}
		});
	}
	
	function showWeightPortlet() {
		AUI().use('aui-base', function(A) {
			var total = {};
			var listPortlet = A.all('.weight-portlet');
			listPortlet.each(function() {
				var parentId = this.ancestor("tr").getData("parent");
				//now calculate for portlet
				var weightPortlet = this.val();
				if (!(weightPortlet == "" || isNaN(weightPortlet)) && weightPortlet > 0) {
					if(total[parentId] === undefined) {
						total[parentId] = 0;
					}
					var newVal = total[parentId] + parseFloat(weightPortlet);
					total[parentId] = newVal;
					this.ancestor("tr").removeClass("empty-weight-color");
				}
				else {
					this.val("0.0");
					this.ancestor("tr").addClass("empty-weight-color");
				}
			});
			
			listPortlet.each(function() {
				var weightPortlet = this.val();
				if (!(weightPortlet == "" || isNaN(weightPortlet))) {
					var parentId = this.ancestor("tr").getData("parent");
					var perc = (weightPortlet / total[parentId]) * 100;
					//cas du 0/0
					if (isNaN(perc))
						this.ancestor("tr").one(".percent").text("0.00 %");
					else
						this.ancestor("tr").one(".percent").text(perc.toFixed(2) + " %");
				}
			});
		});
	}
	
	
	function showWeight() {
		AUI().use('aui-base', function(A) {
			var totalRate = parseInt(0);
			var listePage = A.all('.weightPage');
			listePage.each(function() {
				if (!(this.val() == "" || isNaN(this.val())) && this.val() > 0) {
					totalRate += parseFloat(this.val());
					this.ancestor("tr").removeClass("empty-weight-color");
				}
				else {
					this.val("0.0");
					this.ancestor("tr").addClass("empty-weight-color");
				}
			});

			listePage.each(function() {
				if (!(this.val() == "" || isNaN(this.val()))) {
					var perc = (this.val() / totalRate) * 100;
					
					//cas du 0/0
					if (isNaN(perc))
						this.ancestor("tr").one(".percent").text("0.00 %");
					else
						this.ancestor("tr").one(".percent").text(perc.toFixed(2) + " %");
					
					if(this.ancestor("tr").one(".show-portlet") != null) {					
						var readonly = false;
						var listPortlets = this.ancestor("tr").one(".show-portlet").getData("portlets").split(",");

						if(isNaN(perc) || perc <= 0) {
							readonly = true;
						}
						for (var i = 0; i < listPortlets.length; i++) {
							var portletId = listPortlets[i];
							if(readonly)
								A.one("#"+portletId).one(".weight-portlet").setAttribute("readonly");
							else A.one("#"+portletId).one(".weight-portlet").removeAttribute("readonly");
						}
					}
				}
			});
		});
		showWeightPortlet();
	}
	showWeight();
</script>
