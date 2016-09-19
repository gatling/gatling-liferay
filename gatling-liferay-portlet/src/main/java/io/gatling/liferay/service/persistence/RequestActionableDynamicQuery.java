package io.gatling.liferay.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import io.gatling.liferay.model.Request;
import io.gatling.liferay.service.RequestLocalServiceUtil;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class RequestActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public RequestActionableDynamicQuery() throws SystemException {
        setBaseLocalService(RequestLocalServiceUtil.getService());
        setClass(Request.class);

        setClassLoader(io.gatling.liferay.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("request_id");
    }
}
