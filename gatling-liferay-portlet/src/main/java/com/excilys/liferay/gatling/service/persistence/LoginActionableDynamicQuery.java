package com.excilys.liferay.gatling.service.persistence;

import com.excilys.liferay.gatling.model.Login;
import com.excilys.liferay.gatling.service.LoginLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class LoginActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public LoginActionableDynamicQuery() throws SystemException {
        setBaseLocalService(LoginLocalServiceUtil.getService());
        setClass(Login.class);

        setClassLoader(com.excilys.liferay.gatling.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("userId");
    }
}
