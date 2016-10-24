/**
 * Copyright 2011-2016 GatlingCorp (http://gatling.io)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * 		http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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

/**
 * Controller linked to the random process creation view
 */
@Controller(value = "SiteMapController")
@RequestMapping("VIEW")
public class SiteMapViewController {
	
	/**
	 * Prepares the rendering of the random process view.
	 * The view proposes a way to show the sitemap of all sites in the portal.
	 * 
	 * @param renderRequest
	 * @param renderResponse
	 * @param model
	 * @return
	 * @throws SystemException
	 * @throws NoSuchRecordException
	 * @throws NoSuchSiteMapException
	 */
	@RenderMapping(params = "render=renderSiteMap")
	public String renderRequest(final RenderRequest renderRequest,
			final RenderResponse renderResponse, final Model model) throws SystemException, NoSuchRecordException, NoSuchSiteMapException {
		
		long siteMapId = SiteMapLocalServiceUtil.findByName(SiteMapLocalServiceImpl.DEFAULT_NAME).getSiteMapId();
		List<UrlSiteMap> urldata = UrlSiteMapLocalServiceUtil.findBySiteMapId(siteMapId);
		
		renderRequest.setAttribute("urldata", urldata);
		return "siteMap/view";
	}
	
	/**
	 * Creates a new random process based of weight decided by
	 * @param request
	 * @param response
	 * @param model
	 * @throws SystemException
	 * @throws NoSuchRecordException
	 * @throws NoSuchSiteMapException
	 */
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
