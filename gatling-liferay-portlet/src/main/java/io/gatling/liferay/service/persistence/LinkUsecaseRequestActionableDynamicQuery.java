package io.gatling.liferay.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import io.gatling.liferay.model.LinkUsecaseRequest;
import io.gatling.liferay.service.LinkUsecaseRequestLocalServiceUtil;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class LinkUsecaseRequestActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public LinkUsecaseRequestActionableDynamicQuery() throws SystemException {
        setBaseLocalService(LinkUsecaseRequestLocalServiceUtil.getService());
        setClass(LinkUsecaseRequest.class);

        setClassLoader(io.gatling.liferay.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("linkUsecaseRequestId");
    }
}
