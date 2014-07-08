package com.liferay.training;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portlet.expando.model.ExpandoValue;
import com.liferay.portlet.expando.service.ExpandoValueLocalService;
import com.liferay.portlet.expando.service.ExpandoValueLocalServiceWrapper;

public class MyExpandoValueLocalService extends ExpandoValueLocalServiceWrapper {
	/*
	 * (non-Java-doc)
	 * 
	 * @see com.liferay.portlet.expando.service.ExpandoValueLocalServiceWrapper#
	 * ExpandoValueLocalServiceWrapper(ExpandoValueLocalService
	 * expandoValueLocalService)
	 */
	public MyExpandoValueLocalService(
			ExpandoValueLocalService expandoValueLocalService) {
		super(expandoValueLocalService);
	}

	@Override
	public ExpandoValue addValue(long classNameId, long tableId, long columnId,
			long classPK, java.lang.String data) throws PortalException,
			SystemException {
		User user2 = UserLocalServiceUtil.getUserById(classPK);
		String user2Screenname = user2.getScreenName();
		System.out.println("User " + user2Screenname + " is " + data
				+ " in becoming an astronaut.");
		return super.addValue(classNameId, tableId, columnId, classPK, data);
	}

}