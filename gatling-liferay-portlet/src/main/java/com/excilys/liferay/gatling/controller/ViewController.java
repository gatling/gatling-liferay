package com.excilys.liferay.gatling.controller;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.portlet.ReadOnlyException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.ValidatorException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;

import com.excilys.liferay.gatling.model.Simulation;
import com.excilys.liferay.gatling.mustache.ScriptGeneratorGatling;
import com.excilys.liferay.gatling.service.ScenarioLocalServiceUtil;
import com.excilys.liferay.gatling.service.SimulationLocalServiceUtil;
import com.excilys.liferay.gatling.util.ControllerUtil;
import com.excilys.liferay.gatling.util.GatlingUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.HttpHeaders;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.util.PortalUtil;
import com.samskivert.mustache.Mustache;

/**
 * This controller handle the default jsp 
 * 
 * @author pif
 *
 */
@Controller(value="ViewController")
@RequestMapping("VIEW")
public class ViewController {

	private static final Log LOG = LogFactoryUtil.getLog(ViewController.class);

	/**
	 * Allow the user to download the different scripts Gatling he selected on the left column.
	 * 
	 * @param request
	 * @param response
	 * @throws ValidatorException
	 * @throws ReadOnlyException
	 * @throws IOException
	 * @throws SystemException
	 * @throws PortalException
	 * @throws Exception
	 */
	@ResourceMapping(value="manyScripts")	
	public void serveManyScript(final ResourceRequest request, final ResourceResponse response) throws ValidatorException, ReadOnlyException, IOException, SystemException, PortalException, Exception {
		String template = "/templateGatling2.0.X.mustache";
		//create and export only one file with scenario script for this simulation id
		Simulation simulation = null;
		final Date date = new Date();		
		final long[] simulationsIds = ParamUtil.getLongValues(request, "export");
		response.setContentType("application/zip");
		response.addProperty("Content-Disposition", "attachment; filename = GatlingSimulations" + date.getTime() + ".zip");
		final ZipOutputStream zipOutputStream = new ZipOutputStream(response.getPortletOutputStream());
		for (final long id : simulationsIds) {
			if (id  > 0) {
				simulation = SimulationLocalServiceUtil.getSimulation(id);
				zipOutputStream.putNextEntry(new ZipEntry("Simulation" + simulation.getName() + date.getTime() + ".scala"));
				final String currentPath = request.getPortletSession().getPortletContext().getRealPath("/WEB-INF/classes") + template;
				final String tmp = Mustache.compiler().compile(new FileReader(currentPath)).execute(new ScriptGeneratorGatling(id,PortalUtil.getPortalURL(request)));
				zipOutputStream.write(tmp.getBytes());
				zipOutputStream.closeEntry();
			}
		}
		zipOutputStream.close();
		response.addProperty(HttpHeaders.CACHE_CONTROL, "max-age=3600, must-revalidate");
		LOG.debug("Zip generated ...");
	}

	/**
	 * Returns the default view with a map of the simulations linked to a list of int
	 * first int contains the number of scenario link to the simulation; 
	 * second int give the state of the simulation (empty, incomplete, complete); 
	 * thrid says if the site linked to the simulation contains private pages. Returns a list of the simulation names
	 * to checked existing names in front (JavaScript validation).
	 * 
	 * @param renderRequest
	 * @param renderResponse
	 * @param model
	 * @return 
	 */
	@RenderMapping(params="render=renderView")
	public String renderRequest(final RenderRequest renderRequest,final RenderResponse renderResponse,final Model model) throws SystemException {
		List<Simulation> simulationList = new ArrayList<Simulation>();
		final Map<Simulation, Integer[]> simulationMap = new HashMap<Simulation, Integer[]>();
		simulationList = SimulationLocalServiceUtil.getSimulations(0, SimulationLocalServiceUtil.getSimulationsCount());
		for (final Simulation simulation : simulationList) {
			final Integer[] simulationInfos = new Integer[3];
			simulationInfos[0] = ScenarioLocalServiceUtil.countBySimulationId(simulation.getSimulation_id());
			simulationInfos[1] = ControllerUtil.simulationState(simulation);
			simulationInfos[2] = SimulationLocalServiceUtil.containsPrivatePage(simulation.getSimulation_id()) ? 1 : 0;
			simulationMap.put(simulation, simulationInfos);
		}
		final String JSListName = GatlingUtil.createJSListOfSimulationName(simulationList);
		final javax.portlet.PortletPreferences prefs = renderRequest.getPreferences();
		String gatlingVersionString;
		gatlingVersionString = prefs.getValue("gatlingVersion", null);

		renderRequest.setAttribute("gatlingVersion", gatlingVersionString);
		renderRequest.setAttribute("listOfSimulationName", JSListName);
		renderRequest.setAttribute("listSimulations", simulationList);
		renderRequest.setAttribute("MapSimulations", simulationMap);
		return "view";
	}
	
	/**
	 * Takes all the renders without param.
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RenderMapping
	public String handleRenderRequest(final RenderRequest request,final RenderResponse response,final Model model) throws SystemException {
		return renderRequest(request, response, model);
	}	
}