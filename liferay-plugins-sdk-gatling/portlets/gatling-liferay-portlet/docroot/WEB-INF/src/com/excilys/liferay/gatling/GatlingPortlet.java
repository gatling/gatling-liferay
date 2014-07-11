package com.excilys.liferay.gatling;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.Layout;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.sample.model.Request;
import com.liferay.sample.model.Scenario;
import com.liferay.sample.service.RequestLocalServiceUtil;
import com.liferay.sample.service.ScenarioLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

/**
 * Portlet implementation class GatlingPortlet
 */
public class GatlingPortlet extends MVCPortlet {

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		
		try {		
			int sizeGroups  = GroupLocalServiceUtil.getGroupsCount();

			List<Group> listGroups = GroupLocalServiceUtil.getGroups(0, sizeGroups);
			long groupId = 10184;
			
			List<Layout> listLayouts = LayoutLocalServiceUtil.getLayouts(groupId, false);
			
			renderRequest.setAttribute("listGroup", listGroups);
			renderRequest.setAttribute("listLayout", listLayouts);
			
		} catch (SystemException e) {
			e.printStackTrace();
		}finally {
			super.doView(renderRequest, renderResponse);
		}
	}
	
	
	/**
	 * Adds a new Request to the database
	 * 
	 */
	public void addRequest(ActionRequest request, ActionResponse response)
		throws Exception {

		_log.info("addRequest contrôleur");
		
		ThemeDisplay themeDisplay =
			(ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);

		

		//update request list of scenario
		List<Request> listUrlToStress = (List<Request>) request.getAttribute("listUrlToStress");
		int totalRate = ParamUtil.getInteger(request,"totalRate");
		if(listUrlToStress == null){
			listUrlToStress = new ArrayList<Request>();
		}
				
		totalRate += ParamUtil.getInteger(request, "rate");
		_log.info("totalRate= "+totalRate+ " rate= "+ParamUtil.getInteger(request, "rate"));
		_log.info("url= "+ParamUtil.getString(request, "url"));
		if(totalRate ==100){
			_log.info("total rate = 100 --> create request ");
			//create request
			Request newRequest = RequestLocalServiceUtil.createRequest(0);
			newRequest.setUrl(ParamUtil.getString(request, "url"));
			newRequest.setRate(ParamUtil.getInteger(request, "rate"));
			newRequest = RequestLocalServiceUtil.addRequest(newRequest);
			_log.info("create request ok");
			listUrlToStress.add(newRequest);
		}
		request.setAttribute("listUrlToStress", listUrlToStress);
		request.setAttribute("totalRate", totalRate);
		
		sendRedirect(request, response);
	}
	
	/**
	 * Adds a new Scenario to the database
	 * 
	 */
	public void addScenario(ActionRequest request, ActionResponse response)
		throws Exception {

		_log.info("addScenario contrôleur");
		
		//create scenario
		Scenario scenario = ScenarioLocalServiceUtil.createScenario(0);

		scenario.setName(ParamUtil.getString(request, "name"));
		scenario.setSimulation_id(ParamUtil.getLong(request, "simulation_id"));
		
		scenario = ScenarioLocalServiceUtil.addScenario(scenario);

		//update data in database 
		List<Request> listUrlToStress = (List<Request>) request.getAttribute("listUrlToStress");
		if(listUrlToStress != null){
			for(Request req : listUrlToStress){
				req.setScenario_id(scenario.getScenario_id());
				RequestLocalServiceUtil.updateRequest(req);
			}
		}
		
		sendRedirect(request, response);
	}

	private static Log _log = LogFactoryUtil.getLog(GatlingPortlet.class);

}
