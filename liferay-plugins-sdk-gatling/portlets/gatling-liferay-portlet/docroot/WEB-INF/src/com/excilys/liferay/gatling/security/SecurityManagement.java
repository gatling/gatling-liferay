package com.excilys.liferay.gatling.security;

import com.liferay.portal.model.Group;
import com.liferay.portal.model.Portlet;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.BaseControlPanelEntry;

public class SecurityManagement extends BaseControlPanelEntry {

	@Override
	public boolean hasAccessPermission(PermissionChecker arg0, Group arg1,
			Portlet arg2) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isVisible(PermissionChecker arg0, Portlet arg1)
			throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isVisible(Portlet arg0, String arg1, ThemeDisplay arg2)
			throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

}
