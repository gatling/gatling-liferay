package com.excilys.liferay.gatling;

public class TemplateMustache {

	public final static String RC4 = "import io.gatling.core.Predef._\n" + 
			"import io.gatling.http.Predef._\n" + 
			"import scala.concurrent.duration._\n" + 
			"\n" + 
			"/**\n" + 
			" * Gatling 2.0RC4 Script generated for Liferay by the plugin\n" + 
			" * \"Load Test with Gatling\"\n" + 
			" */\n" + 
			" \n" + 
			" {{#initiate}} {{/initiate}}\n" + 
			"\n" + 
			"class {{simuName}} extends Simulation {\n" + 
			"  \n" + 
			"\n" + 
			"/**\n" + 
			" * List of the differents requests that are stressed their inner portlets\n" + 
			" */   \n" + 
			"{{#mustacheScenario}}\n" + 
			"{{#mustacheRequests}}\n" + 
			"{{^regular}}\n" + 
			"{{#mustachePortlet}}\n" + 
			"{{#recorderGet}}\n" + 
			"    val {{name}} = \n" + 
			"{{#listGet}}\n" + 
			"      {{^beginning}}.{{/beginning}}exec( http(\"{{nameN}}\").get(\"{{url}}\"))\n" + 
			"      .pause(2)\n" + 
			"{{/listGet}}\n" + 
			"{{/recorderGet}}\n" + 
			"\n" + 
			"{{#messageBoard}}\n" + 
			"    val {{nameVariable}} = exec(http(\"{{nameVariable}}\")\n" + 
			"                          .get(\"{{url}}\")\n" + 
			"                          .check(regex(\"\"\"cell first\"> <a href=\"([^\"]+)\">\"\"\").find(0).saveAs(\"url\")))\n" + 
			"                        .pause(1)\n" + 
			"                        .exec(http(\"Select\")\n" + 
			"                          .get(\"${url}\")\n" + 
			"                          .check(status.is(200)))\n" + 
			"                        .pause(1)\n" + 
			"{{/messageBoard}}\n" + 
			"\n" + 
			"{{#assetPublisher}}\n" + 
			"	val {{nameVariable}} = exec(http(\"{{nameVariable}}\")\n" + 
			"                          .get(\"{{url}}\")\n" + 
			"                          .check(regex(\"\"\"asset first\"> <a href=\"([^\"]+)\">\"\"\").find(0).saveAs(\"url\")))\n" + 
			"                        .pause(1)\n" + 
			"                        .exec(http(\"Select\")\n" + 
			"                          .get(\"${url}\")\n" + 
			"                          .check(status.is(200)))\n" + 
			"                        .pause(1)\n" + 
			"{{/assetPublisher}}\n" + 
			"\n" + 
			"{{#wikiDisplay}}  \n" + 
			"    val {{nameVariable}} = exec(http(\"{{nameVariable}}\")\n" + 
			"                          .get(\"{{url}}\"))\n" + 
			"                        .pause(1)\n" + 
			"                        .exec(http(\"Recent Changes\")\n" + 
			"                          .get(\"http://localhost:8080/web/ste3/wiki2?p_p_id={{plid}}&p_p_lifecycle=0&p_p_state=normal&p_p_mode=view&p_p_col_id={{column}}&p_p_col_count=1&_{{plid}}_nodeName=Main&_{{plid}}_struts_action=%2Fwiki_display%2Fview_recent_changes\")\n" + 
			"                          .check(status.is(200)))\n" + 
			"                        .exec(http(\"View All Pages\")\n" + 
			"                          .get(\"http://localhost:8080/web/ste3/wiki2?p_p_id={{plid}}&p_p_lifecycle=0&p_p_state=normal&p_p_mode=view&p_p_col_id={{column}}&p_p_col_count=1&_{{plid}}_nodeName=Main&_{{plid}}_struts_action=%2Fwiki_display%2Fview_all_pages\")\n" + 
			"                          .check(status.is(200)))\n" + 
			"                        .pause(1)\n" + 
			"{{/wikiDisplay}}\n" + 
			"\n" + 
			"    /* script for {{name}} */\n" + 
			"    \n" + 
			"    val {{name}} = randomSwitch(\n" + 
			"{{#scripts}}\n" + 
			"      {{pourcentage}} -> exec({{nameVariable}}){{^last}},{{/last}}\n" + 
			"{{/scripts}}\n" + 
			"        )\n" + 
			"\n" + 
			"\n" + 
			"\n" + 
			"{{/mustachePortlet}}\n" + 
			"  object {{requestName}} {\n" + 
			"    val Entrance = exec( http(\"{{requestName}}\").get(\"{{url}}\") ) \n" + 
			"      .pause(1)\n" + 
			"      .randomSwitch(  /*list of the portlets with their weight*/\n" + 
			"{{#mustachePortlet}}\n" + 
			"         {{pourcentage}} -> exec({{name}}){{^last}},{{/last}}         \n" + 
			"{{/mustachePortlet}}\n" + 
			"      )\n" + 
			"  }\n" + 
			"{{/regular}}\n" + 
			"{{/mustacheRequests}}\n" + 
			"{{/mustacheScenario}}\n" + 
			"  \n" + 
			"  \n" + 
			"  \n" + 
			"}\n" + 
			"";
		
}
