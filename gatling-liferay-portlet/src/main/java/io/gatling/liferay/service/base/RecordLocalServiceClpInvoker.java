package io.gatling.liferay.service.base;

import io.gatling.liferay.service.RecordLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class RecordLocalServiceClpInvoker {
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
    private String _methodName76;
    private String[] _methodParameterTypes76;
    private String _methodName77;
    private String[] _methodParameterTypes77;
    private String _methodName82;
    private String[] _methodParameterTypes82;
    private String _methodName83;
    private String[] _methodParameterTypes83;
    private String _methodName84;
    private String[] _methodParameterTypes84;
    private String _methodName85;
    private String[] _methodParameterTypes85;
    private String _methodName86;
    private String[] _methodParameterTypes86;
    private String _methodName87;
    private String[] _methodParameterTypes87;

    public RecordLocalServiceClpInvoker() {
        _methodName0 = "addRecord";

        _methodParameterTypes0 = new String[] { "io.gatling.liferay.model.Record" };

        _methodName1 = "createRecord";

        _methodParameterTypes1 = new String[] { "long" };

        _methodName2 = "deleteRecord";

        _methodParameterTypes2 = new String[] { "long" };

        _methodName3 = "deleteRecord";

        _methodParameterTypes3 = new String[] { "io.gatling.liferay.model.Record" };

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

        _methodName10 = "fetchRecord";

        _methodParameterTypes10 = new String[] { "long" };

        _methodName11 = "getRecord";

        _methodParameterTypes11 = new String[] { "long" };

        _methodName12 = "getPersistedModel";

        _methodParameterTypes12 = new String[] { "java.io.Serializable" };

        _methodName13 = "getRecords";

        _methodParameterTypes13 = new String[] { "int", "int" };

        _methodName14 = "getRecordsCount";

        _methodParameterTypes14 = new String[] {  };

        _methodName15 = "updateRecord";

        _methodParameterTypes15 = new String[] { "io.gatling.liferay.model.Record" };

        _methodName76 = "getBeanIdentifier";

        _methodParameterTypes76 = new String[] {  };

        _methodName77 = "setBeanIdentifier";

        _methodParameterTypes77 = new String[] { "java.lang.String" };

        _methodName82 = "findByProcessId";

        _methodParameterTypes82 = new String[] { "long" };

        _methodName83 = "findByPortletId";

        _methodParameterTypes83 = new String[] { "java.lang.String" };

        _methodName84 = "findByName";

        _methodParameterTypes84 = new String[] { "java.lang.String" };

        _methodName85 = "countByPortletId";

        _methodParameterTypes85 = new String[] { "java.lang.String" };

        _methodName86 = "update";

        _methodParameterTypes86 = new String[] { "long", "java.lang.String" };

        _methodName87 = "save";

        _methodParameterTypes87 = new String[] {
                "java.lang.String", "java.lang.String", "java.lang.String"
            };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName0.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
            return RecordLocalServiceUtil.addRecord((io.gatling.liferay.model.Record) arguments[0]);
        }

        if (_methodName1.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
            return RecordLocalServiceUtil.createRecord(((Long) arguments[0]).longValue());
        }

        if (_methodName2.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
            return RecordLocalServiceUtil.deleteRecord(((Long) arguments[0]).longValue());
        }

        if (_methodName3.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
            return RecordLocalServiceUtil.deleteRecord((io.gatling.liferay.model.Record) arguments[0]);
        }

        if (_methodName4.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
            return RecordLocalServiceUtil.dynamicQuery();
        }

        if (_methodName5.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
            return RecordLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0]);
        }

        if (_methodName6.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
            return RecordLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue());
        }

        if (_methodName7.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
            return RecordLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue(),
                (com.liferay.portal.kernel.util.OrderByComparator) arguments[3]);
        }

        if (_methodName8.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
            return RecordLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0]);
        }

        if (_methodName9.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
            return RecordLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                (com.liferay.portal.kernel.dao.orm.Projection) arguments[1]);
        }

        if (_methodName10.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
            return RecordLocalServiceUtil.fetchRecord(((Long) arguments[0]).longValue());
        }

        if (_methodName11.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
            return RecordLocalServiceUtil.getRecord(((Long) arguments[0]).longValue());
        }

        if (_methodName12.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
            return RecordLocalServiceUtil.getPersistedModel((java.io.Serializable) arguments[0]);
        }

        if (_methodName13.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
            return RecordLocalServiceUtil.getRecords(((Integer) arguments[0]).intValue(),
                ((Integer) arguments[1]).intValue());
        }

        if (_methodName14.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
            return RecordLocalServiceUtil.getRecordsCount();
        }

        if (_methodName15.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
            return RecordLocalServiceUtil.updateRecord((io.gatling.liferay.model.Record) arguments[0]);
        }

        if (_methodName76.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes76, parameterTypes)) {
            return RecordLocalServiceUtil.getBeanIdentifier();
        }

        if (_methodName77.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes77, parameterTypes)) {
            RecordLocalServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);

            return null;
        }

        if (_methodName82.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes82, parameterTypes)) {
            return RecordLocalServiceUtil.findByProcessId(((Long) arguments[0]).longValue());
        }

        if (_methodName83.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes83, parameterTypes)) {
            return RecordLocalServiceUtil.findByPortletId((java.lang.String) arguments[0]);
        }

        if (_methodName84.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes84, parameterTypes)) {
            return RecordLocalServiceUtil.findByName((java.lang.String) arguments[0]);
        }

        if (_methodName85.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes85, parameterTypes)) {
            return RecordLocalServiceUtil.countByPortletId((java.lang.String) arguments[0]);
        }

        if (_methodName86.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes86, parameterTypes)) {
            RecordLocalServiceUtil.update(((Long) arguments[0]).longValue(),
                (java.lang.String) arguments[1]);

            return null;
        }

        if (_methodName87.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes87, parameterTypes)) {
            return RecordLocalServiceUtil.save((java.lang.String) arguments[0],
                (java.lang.String) arguments[1], (java.lang.String) arguments[2]);
        }

        throw new UnsupportedOperationException();
    }
}
