<%-- 
	Copyright 2014 eBusiness Information, Groupe Excilys (www.ebusinessinformation.fr)
--%>
<%@include file="/html/gatling/header.jsp"%>

<liferay-ui:panel-container accordion="true" extended="true">
	<liferay-ui:panel title="add-a-feeder" cssClass="accordion-group">
		<div class="text-center">
			<aui:field-wrapper name="option" label="you-can-add-a-list-of-users" >
				<div id="uploadFeeder" class="inline-feeder">
					<aui:input name="option" type="radio" value="content2"
						label="upload-my-file" />
					<hr>
					<div id="content1">
					<aui:input name="fileUsers" label="upload-your-feeder" type="file"></aui:input>
					</div>
				</div>
				<div id="manualFeeder" class="inline-feeder">
					<aui:input name="option" type="radio" value="content1"
						label="manual-entry" />
						<hr>
					<div id="content2">
					<aui:input name="manualUsers"
						label="write-one-account-and-password-per-line" type="textarea" cssClass="textarea-feeder"></aui:input>
					</div>
				</div>
			</aui:field-wrapper>
		</div>
	</liferay-ui:panel>
</liferay-ui:panel-container>

<script type="text/javascript">
AUI().use('aui-base', function(A) {
	A.all("input[type='radio']").each(function() {
		this.on('click', function(event) {
			console.log(this.val());
			//remove masks
			A.all(".inline-feeder :input").attr('disabled', false);
			//add mask
			A.one("#"+this.val()+" :input").attr('disabled', true);
		});
	});
});
</script>