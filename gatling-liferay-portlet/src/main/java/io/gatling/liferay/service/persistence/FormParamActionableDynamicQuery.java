package io.gatling.liferay.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import io.gatling.liferay.model.FormParam;
import io.gatling.liferay.service.FormParamLocalServiceUtil;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class FormParamActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public FormParamActionableDynamicQuery() throws SystemException {
        setBaseLocalService(FormParamLocalServiceUtil.getService());
        setClass(FormParam.class);

        setClassLoader(io.gatling.liferay.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("formParamId");
    }
}
