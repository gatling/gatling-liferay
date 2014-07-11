package com.excilys.liferay.gatling;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.Layout;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.sample.model.Scenario;
import com.liferay.sample.service.ScenarioLocalServiceUtil;
import com.liferay.sample.service.persistence.ScenarioPersistence;
import com.liferay.util.bridges.mvc.MVCPortlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

/**
 * Portlet implementation class GatlingPortlet
 */
public class GatlingPortlet extends MVCPortlet {

	
	Log l = LogFactoryUtil.getLog("l");
	




	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {


		
		try {
			
			int sizeGroups  = GroupLocalServiceUtil.getGroupsCount();

			List<Group> listGroups = GroupLocalServiceUtil.getGroups(0, sizeGroups);
			long groupId = 10184;
			
			List<Layout> listLayouts = LayoutLocalServiceUtil.getLayouts(groupId, false);
			renderRequest.setAttribute("setGroup", listGroups);
			renderRequest.setAttribute("listLayout", listLayouts);
			

			
			List<Scenario> ls =new ArrayList<Scenario>();
			try {
				ls.addAll(ScenarioLocalServiceUtil.findBySimulationId(1));
				l.info(ls.get(0).getName());
				int sizeLs = ls.size();
				l.info(ls.get(sizeLs-1).getName());
				
			} catch (SystemException e) {
				e.printStackTrace();
			}
			renderRequest.setAttribute("ls", ls);
			
			
		} catch (SystemException e) {
			e.printStackTrace();
		}finally {
			super.doView(renderRequest, renderResponse);
		}
		
		
	}

}
