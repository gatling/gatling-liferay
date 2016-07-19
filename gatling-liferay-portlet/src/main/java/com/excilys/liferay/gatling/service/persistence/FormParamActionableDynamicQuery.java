package com.excilys.liferay.gatling.service.persistence;

import com.excilys.liferay.gatling.model.FormParam;
import com.excilys.liferay.gatling.service.FormParamLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class FormParamActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public FormParamActionableDynamicQuery() throws SystemException {
        setBaseLocalService(FormParamLocalServiceUtil.getService());
        setClass(FormParam.class);

        setClassLoader(com.excilys.liferay.gatling.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("formParamId");
    }
}
