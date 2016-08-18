package com.excilys.liferay.gatling.service.base;

import com.excilys.liferay.gatling.service.LinkProcessRecordLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class LinkProcessRecordLocalServiceClpInvoker {
    private String _methodName0;
    private String[] _methodParameterTypes0;
    private String _methodName1;
    private String[] _methodParameterTypes1;
    private String _methodName2;
    private String[] _methodParameterTypes2;
    private String _methodName3;
    private String[] _methodParameterTypes3;
    private String _methodName4;
    private String[] _methodParameterTypes4;
    private String _methodName5;
    private String[] _methodParameterTypes5;
    private String _methodName6;
    private String[] _methodParameterTypes6;
    private String _methodName7;
    private String[] _methodParameterTypes7;
    private String _methodName8;
    private String[] _methodParameterTypes8;
    private String _methodName9;
    private String[] _methodParameterTypes9;
    private String _methodName10;
    private String[] _methodParameterTypes10;
    private String _methodName11;
    private String[] _methodParameterTypes11;
    private String _methodName12;
    private String[] _methodParameterTypes12;
    private String _methodName13;
    private String[] _methodParameterTypes13;
    private String _methodName14;
    private String[] _methodParameterTypes14;
    private String _methodName15;
    private String[] _methodParameterTypes15;
    private String _methodName64;
    private String[] _methodParameterTypes64;
    private String _methodName65;
    private String[] _methodParameterTypes65;
    private String _methodName70;
    private String[] _methodParameterTypes70;
    private String _methodName71;
    private String[] _methodParameterTypes71;

    public LinkProcessRecordLocalServiceClpInvoker() {
        _methodName0 = "addLinkProcessRecord";

        _methodParameterTypes0 = new String[] {
                "com.excilys.liferay.gatling.model.LinkProcessRecord"
            };

        _methodName1 = "createLinkProcessRecord";

        _methodParameterTypes1 = new String[] { "long" };

        _methodName2 = "deleteLinkProcessRecord";

        _methodParameterTypes2 = new String[] { "long" };

        _methodName3 = "deleteLinkProcessRecord";

        _methodParameterTypes3 = new String[] {
                "com.excilys.liferay.gatling.model.LinkProcessRecord"
            };

        _methodName4 = "dynamicQuery";

        _methodParameterTypes4 = new String[] {  };

        _methodName5 = "dynamicQuery";

        _methodParameterTypes5 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery"
            };

        _methodName6 = "dynamicQuery";

        _methodParameterTypes6 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int"
            };

        _methodName7 = "dynamicQuery";

        _methodParameterTypes7 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };

        _methodName8 = "dynamicQueryCount";

        _methodParameterTypes8 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery"
            };

        _methodName9 = "dynamicQueryCount";

        _methodParameterTypes9 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery",
                "com.liferay.portal.kernel.dao.orm.Projection"
            };

        _methodName10 = "fetchLinkProcessRecord";

        _methodParameterTypes10 = new String[] { "long" };

        _methodName11 = "getLinkProcessRecord";

        _methodParameterTypes11 = new String[] { "long" };

        _methodName12 = "getPersistedModel";

        _methodParameterTypes12 = new String[] { "java.io.Serializable" };

        _methodName13 = "getLinkProcessRecords";

        _methodParameterTypes13 = new String[] { "int", "int" };

        _methodName14 = "getLinkProcessRecordsCount";

        _methodParameterTypes14 = new String[] {  };

        _methodName15 = "updateLinkProcessRecord";

        _methodParameterTypes15 = new String[] {
                "com.excilys.liferay.gatling.model.LinkProcessRecord"
            };

        _methodName64 = "getBeanIdentifier";

        _methodParameterTypes64 = new String[] {  };

        _methodName65 = "setBeanIdentifier";

        _methodParameterTypes65 = new String[] { "java.lang.String" };

        _methodName70 = "findProcessFromRecordId";

        _methodParameterTypes70 = new String[] { "long" };

        _methodName71 = "findRecordFromProcessId";

        _methodParameterTypes71 = new String[] { "long" };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName0.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
            return LinkProcessRecordLocalServiceUtil.addLinkProcessRecord((com.excilys.liferay.gatling.model.LinkProcessRecord) arguments[0]);
        }

        if (_methodName1.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
            return LinkProcessRecordLocalServiceUtil.createLinkProcessRecord(((Long) arguments[0]).longValue());
        }

        if (_methodName2.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
            return LinkProcessRecordLocalServiceUtil.deleteLinkProcessRecord(((Long) arguments[0]).longValue());
        }

        if (_methodName3.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
            return LinkProcessRecordLocalServiceUtil.deleteLinkProcessRecord((com.excilys.liferay.gatling.model.LinkProcessRecord) arguments[0]);
        }

        if (_methodName4.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
            return LinkProcessRecordLocalServiceUtil.dynamicQuery();
        }

        if (_methodName5.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
            return LinkProcessRecordLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0]);
        }

        if (_methodName6.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
            return LinkProcessRecordLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue());
        }

        if (_methodName7.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
            return LinkProcessRecordLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue(),
                (com.liferay.portal.kernel.util.OrderByComparator) arguments[3]);
        }

        if (_methodName8.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
            return LinkProcessRecordLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0]);
        }

        if (_methodName9.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
            return LinkProcessRecordLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                (com.liferay.portal.kernel.dao.orm.Projection) arguments[1]);
        }

        if (_methodName10.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
            return LinkProcessRecordLocalServiceUtil.fetchLinkProcessRecord(((Long) arguments[0]).longValue());
        }

        if (_methodName11.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
            return LinkProcessRecordLocalServiceUtil.getLinkProcessRecord(((Long) arguments[0]).longValue());
        }

        if (_methodName12.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
            return LinkProcessRecordLocalServiceUtil.getPersistedModel((java.io.Serializable) arguments[0]);
        }

        if (_methodName13.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
            return LinkProcessRecordLocalServiceUtil.getLinkProcessRecords(((Integer) arguments[0]).intValue(),
                ((Integer) arguments[1]).intValue());
        }

        if (_methodName14.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
            return LinkProcessRecordLocalServiceUtil.getLinkProcessRecordsCount();
        }

        if (_methodName15.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
            return LinkProcessRecordLocalServiceUtil.updateLinkProcessRecord((com.excilys.liferay.gatling.model.LinkProcessRecord) arguments[0]);
        }

        if (_methodName64.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes64, parameterTypes)) {
            return LinkProcessRecordLocalServiceUtil.getBeanIdentifier();
        }

        if (_methodName65.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes65, parameterTypes)) {
            LinkProcessRecordLocalServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);

            return null;
        }

        if (_methodName70.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes70, parameterTypes)) {
            return LinkProcessRecordLocalServiceUtil.findProcessFromRecordId(((Long) arguments[0]).longValue());
        }

        if (_methodName71.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes71, parameterTypes)) {
            return LinkProcessRecordLocalServiceUtil.findRecordFromProcessId(((Long) arguments[0]).longValue());
        }

        throw new UnsupportedOperationException();
    }
}
