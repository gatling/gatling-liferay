package com.excilys.liferay.gatling.service.persistence;

import com.excilys.liferay.gatling.model.Request;
import com.excilys.liferay.gatling.service.RequestLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class RequestActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public RequestActionableDynamicQuery() throws SystemException {
        setBaseLocalService(RequestLocalServiceUtil.getService());
        setClass(Request.class);

        setClassLoader(com.excilys.liferay.gatling.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("request_id");
    }
}
