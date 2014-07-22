package com.excilys.liferay.gatling;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.sample.model.Request;
import com.liferay.sample.model.Scenario;
import com.liferay.sample.service.RequestLocalServiceUtil;
import com.liferay.sample.service.ScenarioLocalServiceUtil;

import java.util.List;

public class ScriptGenerator {

	private static Log log = LogFactoryUtil.getLog(GatlingPortlet.class);

	static public void generateImports(StringBuilder sb){

		sb.append("import com.excilys.ebi.gatling.core.Predef._\n")
		.append("import com.excilys.ebi.gatling.http.Predef._\n")
		.append("import com.excilys.ebi.gatling.jdbc.Predef._\n")
		.append("import Headers._\n")
		.append("import akka.util.duration._\n")
		.append("import bootstrap._\n")
		.append("import assertions._\n\n");
	}

	static public void generateClass(StringBuilder sb, Long simulationId) throws Exception {


		
			//list of the scenario
			List<Scenario> listScenario = ScenarioLocalServiceUtil.findBySimulationId(simulationId);

			for (Scenario scenario : listScenario) {
				generateScenario(sb, scenario);

			}
	}
	
	static private void generateScenario(StringBuilder sb, Scenario scenario) throws Exception {
		//declare un nouveau scenario
		sb.append("val ")
		.append(scenario.getName())
		.append(" = scenario(\"")
		.append(scenario.getName())
		.append("\") ");

		List<Request> listRequest = RequestLocalServiceUtil.findByScenarioId(scenario.getScenario_id());
		for (Request request : listRequest) {
			generateRequest(sb, request, scenario);
		}
		sb.append("\n");

		sb.append("setUp(\n\t")
		.append(scenario.getName())
		.append(".users(")
		.append(scenario.getUsers_per_seconds())
		.append(").ramp(")
		.append(scenario.getDuration())
		.append("))\n");
		log.info("generateScenario : " +sb);
		
	}
	
	static private void generateRequest(StringBuilder sb, Request request, Scenario scenario) throws Exception {

		sb.append("\n\t.exec( http(\"")
		.append(request.getUrl())
		.append("\").get(\"")
		.append(scenario.getUrl_site())
		.append(request.getUrl())
		.append("\"))");
	}
}
