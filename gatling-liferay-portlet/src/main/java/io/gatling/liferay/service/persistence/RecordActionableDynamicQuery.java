package io.gatling.liferay.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import io.gatling.liferay.model.Record;
import io.gatling.liferay.service.RecordLocalServiceUtil;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class RecordActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public RecordActionableDynamicQuery() throws SystemException {
        setBaseLocalService(RecordLocalServiceUtil.getService());
        setClass(Record.class);

        setClassLoader(io.gatling.liferay.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("recordId");
    }
}
