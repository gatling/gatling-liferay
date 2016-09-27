package io.gatling.liferay.controller;

import io.gatling.liferay.NoSuchRecordException;
import io.gatling.liferay.NoSuchSiteMapException;
import io.gatling.liferay.model.ProcessType;
import io.gatling.liferay.model.SiteMap;
import io.gatling.liferay.model.UrlSiteMap;
import io.gatling.liferay.service.ProcessLocalServiceUtil;
import io.gatling.liferay.service.SiteMapLocalServiceUtil;
import io.gatling.liferay.service.UrlSiteMapLocalServiceUtil;
import io.gatling.liferay.service.impl.SiteMapLocalServiceImpl;

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
		
		//TODO: Add a way to add an iteration parameter/functionality so that the user can hit several times a random page!
		//int iterations = Integer.parseInt(request.getParameter("iterations"));
		
		SiteMap siteMap = SiteMapLocalServiceUtil.createSiteMap(name);
		
		long defaultSiteMapId = SiteMapLocalServiceUtil.findByName(SiteMapLocalServiceImpl.DEFAULT_NAME).getSiteMapId();
		List<UrlSiteMap> urldata = UrlSiteMapLocalServiceUtil.findBySiteMapId(defaultSiteMapId);
		for (UrlSiteMap url : urldata) {
			String key = new StringBuilder(url.getGroup()).append("_").append(url.getFriendlyUrl()).toString();
			int weight = Integer.parseInt(request.getParameter(key));
			UrlSiteMapLocalServiceUtil.createUrlSiteMap(siteMap.getSiteMapId(), url.getFriendlyUrl(), url.getGroup(), url.getUrl(), weight);
		}
		
		ProcessLocalServiceUtil.createProcess(name, ProcessType.RANDOMPAGE, siteMap.getSiteMapId());
		
		response.setRenderParameter("render", "renderView");
	}
	
	
	
}
