/**
 * Copyright 2015 Altendis, Groupe Excilys (www.altendis.fr)
 */
package io.gatling.liferay.controller;

import io.gatling.liferay.model.Record;
import io.gatling.liferay.model.AST.ScenarioAST;
import io.gatling.liferay.model.AST.SimulationAST;
import io.gatling.liferay.model.AST.feeder.RecordFileAST;
import io.gatling.liferay.model.AST.process.ProcessAST;
import io.gatling.liferay.model.AST.process.RecorderAST;
import io.gatling.liferay.service.RecordLocalServiceUtil;
import io.gatling.liferay.service.mapper.ASTMapper;
import io.gatling.liferay.util.GatlingUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.HttpHeaders;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.ReadOnlyException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.ValidatorException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;


/**
 * Controller linked to the default view
 */
@Controller(value = "ViewController")
@RequestMapping("VIEW")
public class SmoothRecorderController {

	private static final Log LOG = LogFactoryUtil.getLog(SmoothRecorderController.class);

	@RenderMapping(params = "render=renderRecorderView")
	public String renderRequest(final RenderRequest renderRequest,
			final RenderResponse renderResponse, final Model model) throws SystemException {
		String recordName = ParamUtil.getString(renderRequest,"recordName","doesntWork");
		LOG.debug("render View"+recordName);
		
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		renderRequest.setAttribute("groupId", themeDisplay.getScopeGroupId());
		
		// Check state of recording
		String nextState;
		final String state = renderRequest.getParameter("recordState");
		LOG.debug("current state:"+state );
		if(state != null) {
			if(state.equals("RECORD")) {
				nextState ="STOP";
			} else {
				nextState = "RECORD";
			}
		} else {
			nextState = "RECORD";
		}
		LOG.debug("nextState is "+nextState);
		renderRequest.setAttribute("NEXT_STATE", nextState);
		
		List<Record> records = RecordLocalServiceUtil.getRecords(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		renderRequest.setAttribute("records", records);
		
		return "tabs";
	} 
	
	
	@ActionMapping(params="action=toggleRecord2")
	public void toggleRecordAction(final ActionRequest request, final ActionResponse response, final Model model){
		
		LOG.debug("tgr2");
		
		final String recordState = ParamUtil.getString(request, "nextRecordState");
		LOG.debug("Toggle Record from smooth called");
		response.setRenderParameter("recordState", recordState);
		//hack, only work this way ....
		//response.setRenderParameter("p_p_state", "pop_up");
		PortalUtil.copyRequestParameters(request, response);
		response.setRenderParameter("render", "renderRecorderView");
		//Hide success message for this action

		//request.setAttribute("NEXT_STATE", nextState);
		SessionMessages.add(request, PortalUtil.getPortletId(request)+SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);
	}

	@ResourceMapping(value="generateProcessZip")	
	public void exportZippedProcess(final ResourceRequest request, final ResourceResponse response) throws ValidatorException, ReadOnlyException, IOException, SystemException, PortalException, Exception {
		LOG.debug("\\o/ Generating zip process...");
		String name = ParamUtil.getString(request, "recordName");
		System.out.println("name: " +name);
		
		
		
		response.setContentType("application/zip");
		response.addProperty("Content-Disposition", "attachment; filename = GatlingProcess.zip");
		
		List<SimulationAST> asts = new ArrayList<>();
		SimulationAST ast = createDefaultAST(name);
		asts.add(ast);
		
		GatlingUtil.zipMyEnvironment(response.getPortletOutputStream(), getClass().getClassLoader(), request, asts);
		 		
		response.addProperty(HttpHeaders.CACHE_CONTROL, "max-age=3600, must-revalidate");
		LOG.debug("Zip process generated ...");
	
	}
	
	private static SimulationAST createDefaultAST(String name) throws Exception{
		
		Record record = RecordLocalServiceUtil.findByName(name);
		
		RecordFileAST recordFile = ASTMapper.mapRecordToAST(record);
		
		ProcessAST processAST = new RecorderAST(recordFile);
		
		List<ProcessAST> processList = new ArrayList<>();
		processList.add(processAST);
		
		List<ScenarioAST> scenarios = new ArrayList<>();
		scenarios.add(new ScenarioAST("RecordScenario", 10, "rampUsers", 10, processList));
		
		SimulationAST ast = new SimulationAST(
			"RecordSimulation", 
			scenarios, 
			"unusedURL"
		);
		return ast;
	}
	
	
	
	/**
	 * Takes all the renders without param.
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 * @throws SystemException 
	 */
	@RenderMapping
	public String handleRenderRequest(final RenderRequest request,
			final RenderResponse response, final Model model) throws SystemException {
		return renderRequest(request, response, model);
	}
}
