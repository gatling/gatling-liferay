package com.excilys.liferay.gatling.security;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.Portlet;
import com.liferay.portal.model.Role;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.BaseControlPanelEntry;

import java.util.List;

public class SecurityManagement extends BaseControlPanelEntry {

	@Override
	public boolean hasAccessPermission(PermissionChecker permission, Group group,
			Portlet portlet) throws Exception {
		long userId = portlet.getUserId();
		long companyId= portlet.getCompanyId();
		DynamicQuery dq = DynamicQueryFactoryUtil.forClass(Role.class)
				.add(PropertyFactoryUtil.forName("name").eq("gatling"));
		
		List<Role> roles = RoleLocalServiceUtil.dynamicQuery(dq);
		Role role = roles.get(0);
		if(permission.getUser().getRoles().contains(role)){
			return true;
		}
		return false;
	}

	@Override
	public boolean isVisible(PermissionChecker permission, Portlet portlet)
			throws Exception {
		if(hasAccessPermission(permission, null,portlet) ){
			return true;
		}
		return false;

	}

	@Override
	public boolean isVisible(Portlet portlet, String arg1, ThemeDisplay themeDisplay)
			throws Exception {
		return false;
	}

}
