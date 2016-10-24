/**
 * Copyright 2011-2015 GatlingCorp (http://gatling.io)
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
package io.gatling.liferay.util;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Company;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.Layout;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.RenderRequest;

/**
 * This class regroups helpfull functions used to interact
 * with your Liferay Portal.
 */
public class LiferayUtil {


	/**
	 * Retrieve list of active sites present in the portal.
	 * @return The site list
	 */
	@SuppressWarnings("unchecked")
	public static List<Group> getListOfSites() {
		/* get sites list */
		DynamicQuery dq = DynamicQueryFactoryUtil.forClass(Group.class)
				.add(PropertyFactoryUtil.forName("type").eq(1)) // 1 -> site
				.add(PropertyFactoryUtil.forName("site").eq(true))
				.add(PropertyFactoryUtil.forName("active").eq(true));

		List<Group> listGroups = new ArrayList<Group>();
		try {
			listGroups = (List<Group>) GroupLocalServiceUtil.dynamicQuery(dq);
		} catch (SystemException e) {
			throw new RuntimeException(e.getMessage());
		}

		return listGroups;
	}

	/**
	 * Get the friendlyUrl of the given site.
	 * @param themeDisplay The portal theme display needed to retrieve site
	 * 		informations
	 * @param layout The layout corresponding to the desired site
	 * @return The friendlyUrl of the site
	 * @throws SystemException If an error occured in the services
	 */
	public static String getGroupFriendlyURL(ThemeDisplay themeDisplay, Layout layout) throws SystemException {
		StringBuilder sb  = new StringBuilder();
		String currentFriendlyURL = GroupLocalServiceUtil.fetchGroup(layout.getGroupId()).getIconURL(themeDisplay);
	    sb.append(currentFriendlyURL.split("/")[0]);
	    sb.append("//").append(currentFriendlyURL.split("/")[2]).append("/web").append(GroupLocalServiceUtil.fetchGroup(layout.getGroupId()).getFriendlyURL()).append(layout.getFriendlyURL());
		return sb.toString();
	}
	
	public static String getAuthType(RenderRequest request)
			throws SystemException {
		final ThemeDisplay themeDisplay = (ThemeDisplay) request
				.getAttribute(WebKeys.THEME_DISPLAY);
		Company company = themeDisplay.getCompany();
		return company.getAuthType();
	}
	
	

	/**
	 * Combines all the private (true) and public (false) layouts, the returned list represents the sipe map.
	 * @param groupId The site identifier
	 * @return The layout corresponding to the site
	 * @throws SystemException If an error occurs in the Layout Services
	 */
	public static List<Layout> getSiteMap(long groupId) throws SystemException {
		// NOTE get scenario group id -> scenario.getGroup_id();
		List<Layout> layouts = new ArrayList<>();
		layouts.addAll(LayoutLocalServiceUtil.getLayouts(groupId, true, 0));
		layouts.addAll(LayoutLocalServiceUtil.getLayouts(groupId, false, 0));		
		return layouts;
	
	}

}
