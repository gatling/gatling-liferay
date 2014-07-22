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

		generateVar(sb, listScenario);
		generateSetUp(sb, listScenario);
	}

	private static void generateSetUp(StringBuilder sb, List<Scenario> listScenario) {

		sb.append("\tsetUp(");

		for (Scenario scenario : listScenario) {
			sb.append("\n\t\t")
			.append(scenario.getName())
			.append(".users(")
			.append(scenario.getUsers_per_seconds())
			.append(").ramp(")
			.append(scenario.getDuration())
			.append(")");
		}

		sb.append(")\n\n");

	}

	static private void generateVar(StringBuilder sb, List<Scenario> listScenario) throws Exception {
		for (Scenario scenario : listScenario) {
			//declare un nouveau scenario
			sb.append("\tval ")
			.append(scenario.getName())
			.append(" = scenario(\"")
			.append(scenario.getName())
			.append("\") ");

			List<Request> listRequest = RequestLocalServiceUtil.findByScenarioId(scenario.getScenario_id());
			for (Request request : listRequest) {
				//if checked in the jsp 
				if(request.getChecked() == true ){
					generateRequest(sb, request, scenario);
				}
			}
			sb.append("\n\n");
		}

	}

	static private void generateRequest(StringBuilder sb, Request request, Scenario scenario) throws Exception {
		
		String site = scenario.getUrl_site();
		if(request.isPrivatePage()){
			//String is a f****** immutable classe ;(
			site = site.replace("/web/", "/group/");
		}
		
		sb.append("\n\t\t.exec( http(\"")
		.append(request.getName())
		.append("\").get(\"")
		.append(site)
		.append(request.getUrl())
		.append("\"))");

	}
}
