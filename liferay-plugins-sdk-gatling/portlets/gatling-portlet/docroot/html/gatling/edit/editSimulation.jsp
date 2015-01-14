<%-- 
	Copyright 2014 eBusiness Information, Groupe Excilys (www.ebusinessinformation.fr)
--%>
<%@include file="/html/gatling/header.jsp"%>

<div id="myLink">
	<div id="Simulation" class="well well-content pull-left">
		<h4>Simulation Z</h4>
		<hr/>
		<div class="alert alert-info">
			Drag the scenario you want to add on this column
		</div>
		<div id="LZ" style="min-height:50px;border:2px dotted #DDD;">

		</div>
	</div>
	<div id="Scenarios" class="well well-content" style="width: 70%;">
		<a href="#" type="button" class="btn pull-right">Create new scenario</a>
		<h4 class="clearfix">List of existing Scenarios</h4>
		<hr /> 
		<c:forEach begin="1" end="12" var="loop">
		<div data-id="s${loop}" class="thumbnail scenario-item">
			<i class="icon-gear pull-right"></i>
			<div class="dsl-content"> 
				<h5>Scenario ${loop} <small>(website)</small></h5>
				<p class="muted">10/15 Page(s), 100 User(s) for 50 second(s)</p>
			</div>
		</div>
		</c:forEach>
	</div> 
</div> 

<script type="text/javascript">
	
	YUI().use('aui-sortable-layout', function(Y) {
		var DDM = Y.DD.DDM;
		var proxyNode = Y.Node.create('<div class="sortable-layout-proxy"></div>');
		
		new Y.SortableLayout({
			dragNodes : '.draggable',
			dropNodes : '#LZ'
		});
		
		
		var ScenarioItem = function() {
			ScenarioItem.superclass.constructor.apply(this, arguments);
		};

		ScenarioItem.NAME = 'ScenarioItem';
		ScenarioItem.ATTRS = {
			dd : {
				value : false
			},
			delegateConfig : {
				value : {
					nodes : '.scenario-item',
					target : false
				}
			},
	      	proxyNode: {
	          value: proxyNode
	        }
		};
		
		Y.extend(ScenarioItem, Y.SortableLayout, {
			_getAppendNode : function() {
				var instance = this;
				instance.appendNode = DDM.activeDrag.get('node').clone();
				return instance.appendNode;
			}
		});
		

		var scenarioList = new ScenarioItem();

		var livePortlet;
		scenarioList.on('drag:end', function(event) {
			var node = scenarioList.appendNode;
			
			var newPortlet = Y.Node.create('<div id="'+node.getData('id')+'" class="thumbnail draggable"></div>');
			newPortlet.append('<i class="icon-minus-sign pull-right"></i>');
			newPortlet.append(node.one(".dsl-content").html());
			newPortlet.one(".icon-minus-sign").on('click', function(event) {
				this.ancestor(".thumbnail").remove();
			});
			
			var dropConfig = {
				bubbleTargets : this,
				useShim : false
			};
			//Unique
			if(Y.one('#'+ node.getData('id')) != null) {
				Y.one('#'+ node.getData('id')).remove();
			}
			if (scenarioList.appendNode && scenarioList.appendNode.inDoc()) {
				scenarioList.appendNode.replace(newPortlet);
				var livePortlet = Y.one('#'+ node.getData('id'));
				livePortlet.plug(Y.Plugin.Drop, dropConfig);
				livePortlet.drop.set('groups', [ 'portal-layout' ]);
			}
		});
		
	});
</script>