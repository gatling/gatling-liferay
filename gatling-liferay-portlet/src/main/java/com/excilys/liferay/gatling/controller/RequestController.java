package com.excilys.liferay.gatling.controller;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

import com.excilys.liferay.gatling.model.UrlRecord;
import com.excilys.liferay.gatling.service.RequestLocalServiceUtil;
import com.excilys.liferay.gatling.service.UrlRecordLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;

@Controller(value="RequestController")
@RequestMapping("VIEW")
public class RequestController {

	private static final Log LOG = LogFactoryUtil.getLog(RequestController.class);

	@RenderMapping(params="render=renderRequest")
	public String editRequestRenderRequest(final RenderRequest renderRequest, final RenderResponse renderResponse, final Model model) throws SystemException {
		//Get the list of UrlRecord that corresponds to the recordId, if requested
		final long  recordId = ParamUtil.getLong(renderRequest, "recordId");
		final String recordName = ParamUtil.getString(renderRequest, "recordname");
		List<UrlRecord> listRecordUrl = new ArrayList<UrlRecord>();

		listRecordUrl = UrlRecordLocalServiceUtil.findByRecordId(recordId);

		if(LOG.isInfoEnabled()) {
			LOG.info("portlet id "+ParamUtil.getString(renderRequest, "portletId"));
		}
		renderRequest.setAttribute("listRecordUrl", listRecordUrl);
		renderRequest.setAttribute("recordName", recordName);
		renderRequest.setAttribute("recordId", recordId);
		renderRequest.setAttribute("portletId", ParamUtil.getString(renderRequest, "portletId"));
		renderRequest.setAttribute("requestId", ParamUtil.getString(renderRequest, "requestId"));

		return "editScenario";
	}

	@ActionMapping(params="action=deleteRequest")
	public void deleteRequestAction(final ActionRequest request, final ActionResponse response, final Model model) throws SystemException, PortalException {

		final long requestId = Long.parseLong(request.getParameter("requestId"));
		RequestLocalServiceUtil.deleteRequest(requestId);
		LOG.debug("request deleted successfully ");
		response.setRenderParameter("scenarioId", request.getParameter("scenarioId"));
		response.setRenderParameter("render" ,"renderRequest");
	}
}