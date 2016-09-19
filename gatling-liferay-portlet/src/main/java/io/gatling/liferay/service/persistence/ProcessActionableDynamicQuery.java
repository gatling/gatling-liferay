package io.gatling.liferay.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import io.gatling.liferay.model.Process;
import io.gatling.liferay.service.ProcessLocalServiceUtil;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class ProcessActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public ProcessActionableDynamicQuery() throws SystemException {
        setBaseLocalService(ProcessLocalServiceUtil.getService());
        setClass(Process.class);

        setClassLoader(io.gatling.liferay.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("process_id");
    }
}
