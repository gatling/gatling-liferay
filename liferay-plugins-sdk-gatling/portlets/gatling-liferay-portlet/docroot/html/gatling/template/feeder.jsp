<%-- 
	Copyright 2014 eBusiness Information, Groupe Excilys (www.ebusinessinformation.fr)
--%>
<%@include file="/html/gatling/header.jsp"%>


<liferay-ui:panel-container accordion="true" extended="true">
	<liferay-ui:panel title="add-a-feeder" cssClass="accordion-group">
		<portlet:actionURL var="feederURL" name="editFeeder" />
		<aui:form action="${feederURL}" >
			<aui:input name="simulationId" type="hidden"
				value="${simulation.simulation_id }" />
			<aui:button type="submit" value="save-my-feeder"
				cssClass="pull-right" />
			<div class="text-center">
				<aui:field-wrapper name="option" label="you-can-add-a-list-of-users">
					<div id="uploadFeeder" class="inline-feeder">
						<aui:input name="option" type="radio" value="content2"
							label="use-my-file" checked="${simulation.isFeederAFile }" />
						<hr>
						<div id="content1">
						<c:choose>
						<c:when test="${simulation.isFeederAFile }">
							<aui:input name="fileUsers" label="name-your-feeder" type="text" value="${simulation.feederContent }"></aui:input>
						</c:when>
						<c:otherwise>
							<aui:input name="fileUsers" label="name-your-feeder" type="text" disabled="${not simulation.isFeederAFile }"></aui:input>
						</c:otherwise>
						</c:choose>
						</div>
					</div>
					<div id="manualFeeder" class="inline-feeder">
						<aui:input name="option" type="radio" value="content1"
							label="manual-entry" checked="${not simulation.isFeederAFile }" />
						<hr>
						<div id="content2">
							
						<c:choose>
						<c:when test="${not simulation.isFeederAFile }">
							<aui:input name="manualUsers"
								label="write-one-account-and-password-per-line" type="textarea"
								cssClass="textarea-feeder" value="${simulation.feederContent }"></aui:input>
						</c:when>
						<c:otherwise>
							<aui:input name="manualUsers"
								label="write-one-account-and-password-per-line" type="textarea"
								cssClass="textarea-feeder" disabled="${simulation.isFeederAFile }"></aui:input>
						</c:otherwise>
						</c:choose>
						</div>
					</div>
				</aui:field-wrapper>
			</div>
		</aui:form>
	</liferay-ui:panel>
</liferay-ui:panel-container>


<script type="text/javascript">
	AUI().use('aui-base', function(A) {
		A.all("input[type='radio']").each(function() {
			this.on('click', function(event) {
				//remove all disable
				A.all(".inline-feeder :input").attr('disabled', false);
				//add disable
				A.one("#" + this.val() + " :input").attr('disabled', true);
			});
		});
	});
</script>