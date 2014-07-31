package com.excilys.liferay.gatling.security;

import com.liferay.portal.model.Group;
import com.liferay.portal.model.Portlet;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.BaseControlPanelEntry;

public class SecurityManagement extends BaseControlPanelEntry {

	/**
	 * determine if user has gatling role then he or she can access the portlet
	 */
	@Override
	public boolean hasAccessPermission(PermissionChecker permission, Group group,
			Portlet portlet) throws Exception {
		
//		DynamicQuery dq = DynamicQueryFactoryUtil.forClass(Role.class)
//				.add(PropertyFactoryUtil.forName("name").eq("gatling"));
//		
//		List<Role> roles = RoleLocalServiceUtil.dynamicQuery(dq);
//		Role role = roles.get(0);
//		if(permission.getUser().getRoles().contains(role)){
//			return true;
//		}
//		return false;
		return true;
	}

	@Override
	public boolean isVisible(PermissionChecker permission, Portlet portlet)
			throws Exception {
//		if(hasAccessPermission(permission, null,portlet) ){
//			return true;
//		}
//		return false;
		return true;
	}

	@Override
	public boolean isVisible(Portlet portlet, String arg1, ThemeDisplay themeDisplay)
			throws Exception {
		return true;
	}

}
