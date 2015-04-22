package com.excilys.liferay.gatling.service.persistence;

import com.excilys.liferay.gatling.model.LinkUsecaseRequest;
import com.excilys.liferay.gatling.service.LinkUsecaseRequestLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class LinkUsecaseRequestActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public LinkUsecaseRequestActionableDynamicQuery() throws SystemException {
        setBaseLocalService(LinkUsecaseRequestLocalServiceUtil.getService());
        setClass(LinkUsecaseRequest.class);

        setClassLoader(com.excilys.liferay.gatling.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("linkUsecaseRequestId");
    }
}
