package com.excilys.liferay.gatling.controller;

import com.excilys.liferay.gatling.NoSuchRecordException;
import com.excilys.liferay.gatling.NoSuchSiteMapException;
import com.excilys.liferay.gatling.model.ProcessType;
import com.excilys.liferay.gatling.model.SiteMap;
import com.excilys.liferay.gatling.model.UrlSiteMap;
import com.excilys.liferay.gatling.service.ProcessLocalServiceUtil;
import com.excilys.liferay.gatling.service.SiteMapLocalServiceUtil;
import com.excilys.liferay.gatling.service.UrlSiteMapLocalServiceUtil;
import com.excilys.liferay.gatling.service.impl.SiteMapLocalServiceImpl;
import com.liferay.portal.kernel.exception.SystemException;

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

@Controller(value = "SiteMapController")
@RequestMapping("VIEW")
public class SiteMapController {
	
	@RenderMapping(params = "render=renderSiteMap")
	public String renderRequest(final RenderRequest renderRequest,
			final RenderResponse renderResponse, final Model model) throws SystemException, NoSuchRecordException, NoSuchSiteMapException {
		
		long siteMapId = SiteMapLocalServiceUtil.findByName(SiteMapLocalServiceImpl.DEFAULT_NAME).getSiteMapId();
		List<UrlSiteMap> urldata = UrlSiteMapLocalServiceUtil.findBySiteMapId(siteMapId);
		
		renderRequest.setAttribute("urldata", urldata);
		return "siteMap";
	}
	
	@ActionMapping(params = "action=saveSiteMap")
	public void saveSiteMap(final ActionRequest request, final ActionResponse response, final Model model) throws SystemException, NoSuchRecordException, NoSuchSiteMapException {
		
		String name = request.getParameter("name");
		
		//TODO: Add a way to use this !
		//int iterations = Integer.parseInt(request.getParameter("iterations"));
		
		SiteMap siteMap = SiteMapLocalServiceUtil.createSiteMap(name);
		
		long defaultSiteMapId = SiteMapLocalServiceUtil.findByName(SiteMapLocalServiceImpl.DEFAULT_NAME).getSiteMapId();
		List<UrlSiteMap> urldata = UrlSiteMapLocalServiceUtil.findBySiteMapId(defaultSiteMapId);
		for (UrlSiteMap url : urldata) {
			
			System.out.println(url.getFriendlyUrl());
			
			int weight = Integer.parseInt(request.getParameter(url.getFriendlyUrl()));
			UrlSiteMapLocalServiceUtil.createUrlSiteMap(siteMap.getSiteMapId(), url.getFriendlyUrl(), url.getUrl(), weight);
		}
		
		ProcessLocalServiceUtil.createProcess(name, ProcessType.RANDOMPAGE, siteMap.getSiteMapId());
		
		response.setRenderParameter("render", "renderView");
	}
	
	
	
}
