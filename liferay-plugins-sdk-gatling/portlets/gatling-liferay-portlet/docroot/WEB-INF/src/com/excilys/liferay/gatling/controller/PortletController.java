package com.excilys.liferay.gatling.controller;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

import com.excilys.liferay.gatling.GatlingPortlet;
import com.excilys.liferay.gatling.service.LinkUsecaseRequestLocalServiceUtil;
import com.excilys.liferay.gatling.service.RecordLocalServiceUtil;
import com.excilys.liferay.gatling.service.UrlRecordLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.util.PortalUtil;

@Controller(value="PortletController")
@RequestMapping("VIEW")
public class PortletController {

	private static final Log LOG = LogFactoryUtil.getLog(GatlingPortlet.class);
	
	@ActionMapping(params="action=removeRecord")
	public String removeRecordRenderRequest(ActionRequest request, ActionResponse response, Model model) throws SystemException, PortalException {
		long recordId = ParamUtil.getLong(request, "recordId");
		RecordLocalServiceUtil.deleteRecord(recordId);
		LinkUsecaseRequestLocalServiceUtil.removeByRecordId(recordId);
		UrlRecordLocalServiceUtil.removeByRecordId(recordId);
		//redirect
		//hack, only work this way ....
		response.setRenderParameter("p_p_state", "pop_up");
		response.setRenderParameter("tabs1", "config-record");
		PortalUtil.copyRequestParameters(request, response);
		return "editScenario";

	}
	
	@ActionMapping(params="action=editRecord")
	public String editRecordRenderRequest(ActionRequest request, ActionResponse response, Model model) throws SystemException, PortalException {
		
		long recordId = ParamUtil.getLong(request, "recordId");
		String name = ParamUtil.getString(request, "recordName");
		RecordLocalServiceUtil.update(recordId, name);
		
		//hack, only work this way ....
		response.setRenderParameter("p_p_state", "pop_up");
		PortalUtil.copyRequestParameters(request, response);
		return "editScenario";
	}
	
	@ActionMapping(params="action=toggleRecord")
	public String toggleRecordRenderRequest(ActionRequest request, ActionResponse response, Model model){
		String recordState = ParamUtil.getString(request, "nextRecordState");
		response.setRenderParameter("recordState", recordState);
		//hack, only work this way ....
		response.setRenderParameter("p_p_state", "pop_up");
		PortalUtil.copyRequestParameters(request, response);
		return "editScenario";

	}
	
	@ActionMapping(params="action=editPortletSample")
	public String editSampleActionRequest(ActionRequest request, ActionResponse response, Model model) throws SystemException, PortalException {
		LOG.debug("editPortletSample");
		long requestId = ParamUtil.getLong(request, "requestId");
		long[] linkUsecaseRequestIds = ParamUtil.getLongValues(request, "idLink");
		double[] usecaseWeight = ParamUtil.getDoubleValues(request, "weightScenarioSample");
		long[] recordIds = ParamUtil.getLongValues(request, "recordId");
		boolean[] areSample = ParamUtil.getBooleanValues(request, "isSample");
		
		if(linkUsecaseRequestIds.length == usecaseWeight.length && usecaseWeight.length == areSample.length) {
			for(int i=0; i<linkUsecaseRequestIds.length;i++) {
				long id = linkUsecaseRequestIds[i];
				double weight = usecaseWeight[i];
				long recordId = recordIds[i];
				boolean isSample = areSample[i];
				LOG.debug(id+" "+requestId+" "+recordId+" "+weight+" "+isSample);
				LinkUsecaseRequestLocalServiceUtil.saveLinkUseCase(id, requestId, recordId, weight, isSample);
			}
		}
		//hack, only work this way ....
		response.setRenderParameter("p_p_state", "pop_up");
		PortalUtil.copyRequestParameters(request, response);
		return "editPortlet";
	}
	
	@ActionMapping(params="action=deleteUseCase")
	public String deleteUseCaseActionRequest(ActionRequest request, ActionResponse response, Model model) throws SystemException, PortalException{
		long useCaseId = ParamUtil.getLong(request,"useCaseId");
		LinkUsecaseRequestLocalServiceUtil.deleteLinkUsecaseRequest(useCaseId);		

		//hack, only work this way ....
		response.setRenderParameter("p_p_state", "pop_up");
		PortalUtil.copyRequestParameters(request, response);
		//redirect
		return "editPortlet";
	}
}