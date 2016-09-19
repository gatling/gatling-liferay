package io.gatling.liferay.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import io.gatling.liferay.model.Login;
import io.gatling.liferay.service.LoginLocalServiceUtil;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class LoginActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public LoginActionableDynamicQuery() throws SystemException {
        setBaseLocalService(LoginLocalServiceUtil.getService());
        setClass(Login.class);

        setClassLoader(io.gatling.liferay.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("userId");
    }
}
