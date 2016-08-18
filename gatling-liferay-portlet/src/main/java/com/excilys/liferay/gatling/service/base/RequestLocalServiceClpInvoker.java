package com.excilys.liferay.gatling.service.base;

import com.excilys.liferay.gatling.service.RequestLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class RequestLocalServiceClpInvoker {
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
    private String _methodName72;
    private String[] _methodParameterTypes72;
    private String _methodName73;
    private String[] _methodParameterTypes73;
    private String _methodName74;
    private String[] _methodParameterTypes74;
    private String _methodName75;
    private String[] _methodParameterTypes75;
    private String _methodName76;
    private String[] _methodParameterTypes76;
    private String _methodName77;
    private String[] _methodParameterTypes77;
    private String _methodName78;
    private String[] _methodParameterTypes78;
    private String _methodName79;
    private String[] _methodParameterTypes79;
    private String _methodName80;
    private String[] _methodParameterTypes80;
    private String _methodName81;
    private String[] _methodParameterTypes81;
    private String _methodName82;
    private String[] _methodParameterTypes82;
    private String _methodName83;
    private String[] _methodParameterTypes83;
    private String _methodName84;
    private String[] _methodParameterTypes84;
    private String _methodName85;
    private String[] _methodParameterTypes85;

    public RequestLocalServiceClpInvoker() {
        _methodName0 = "addRequest";

        _methodParameterTypes0 = new String[] {
                "com.excilys.liferay.gatling.model.Request"
            };

        _methodName1 = "createRequest";

        _methodParameterTypes1 = new String[] { "long" };

        _methodName2 = "deleteRequest";

        _methodParameterTypes2 = new String[] { "long" };

        _methodName3 = "deleteRequest";

        _methodParameterTypes3 = new String[] {
                "com.excilys.liferay.gatling.model.Request"
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

        _methodName10 = "fetchRequest";

        _methodParameterTypes10 = new String[] { "long" };

        _methodName11 = "getRequest";

        _methodParameterTypes11 = new String[] { "long" };

        _methodName12 = "getPersistedModel";

        _methodParameterTypes12 = new String[] { "java.io.Serializable" };

        _methodName13 = "getRequests";

        _methodParameterTypes13 = new String[] { "int", "int" };

        _methodName14 = "getRequestsCount";

        _methodParameterTypes14 = new String[] {  };

        _methodName15 = "updateRequest";

        _methodParameterTypes15 = new String[] {
                "com.excilys.liferay.gatling.model.Request"
            };

        _methodName64 = "getBeanIdentifier";

        _methodParameterTypes64 = new String[] {  };

        _methodName65 = "setBeanIdentifier";

        _methodParameterTypes65 = new String[] { "java.lang.String" };

        _methodName70 = "findByParentPlid";

        _methodParameterTypes70 = new String[] { "long" };

        _methodName71 = "countByParentPlid";

        _methodParameterTypes71 = new String[] { "long" };

        _methodName72 = "findByParentPlidAndScenario";

        _methodParameterTypes72 = new String[] { "long", "long" };

        _methodName73 = "countByParentPlidAndScenario";

        _methodParameterTypes73 = new String[] { "long", "long" };

        _methodName74 = "findByParentPlidAndScenarioAndPositif";

        _methodParameterTypes74 = new String[] { "long", "long" };

        _methodName75 = "countByParentPlidAndScenarioAndPositif";

        _methodParameterTypes75 = new String[] { "long", "long" };

        _methodName76 = "findByScenarioId";

        _methodParameterTypes76 = new String[] { "long" };

        _methodName77 = "countByScenarioId";

        _methodParameterTypes77 = new String[] { "long" };

        _methodName78 = "findByScenarioIdAndUsed";

        _methodParameterTypes78 = new String[] { "long" };

        _methodName79 = "countByScenarioIdAndUsed";

        _methodParameterTypes79 = new String[] { "long" };

        _methodName80 = "removeByScenarioId";

        _methodParameterTypes80 = new String[] { "long" };

        _methodName81 = "findByScenarioIdAndIsNotPortlet";

        _methodParameterTypes81 = new String[] { "long" };

        _methodName82 = "countByScenarioIdAndIsNotPortlet";

        _methodParameterTypes82 = new String[] { "long" };

        _methodName83 = "findByScenarioIdAndUsedAndIsNotPortlet";

        _methodParameterTypes83 = new String[] { "long" };

        _methodName84 = "countByScenarioIdAndUsedAndIsNotPortlet";

        _methodParameterTypes84 = new String[] { "long" };

        _methodName85 = "addRequestFromDisplayItem";

        _methodParameterTypes85 = new String[] {
                "java.lang.Object", "double", "long"
            };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName0.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
            return RequestLocalServiceUtil.addRequest((com.excilys.liferay.gatling.model.Request) arguments[0]);
        }

        if (_methodName1.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
            return RequestLocalServiceUtil.createRequest(((Long) arguments[0]).longValue());
        }

        if (_methodName2.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
            return RequestLocalServiceUtil.deleteRequest(((Long) arguments[0]).longValue());
        }

        if (_methodName3.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
            return RequestLocalServiceUtil.deleteRequest((com.excilys.liferay.gatling.model.Request) arguments[0]);
        }

        if (_methodName4.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
            return RequestLocalServiceUtil.dynamicQuery();
        }

        if (_methodName5.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
            return RequestLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0]);
        }

        if (_methodName6.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
            return RequestLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue());
        }

        if (_methodName7.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
            return RequestLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue(),
                (com.liferay.portal.kernel.util.OrderByComparator) arguments[3]);
        }

        if (_methodName8.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
            return RequestLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0]);
        }

        if (_methodName9.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
            return RequestLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                (com.liferay.portal.kernel.dao.orm.Projection) arguments[1]);
        }

        if (_methodName10.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
            return RequestLocalServiceUtil.fetchRequest(((Long) arguments[0]).longValue());
        }

        if (_methodName11.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
            return RequestLocalServiceUtil.getRequest(((Long) arguments[0]).longValue());
        }

        if (_methodName12.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
            return RequestLocalServiceUtil.getPersistedModel((java.io.Serializable) arguments[0]);
        }

        if (_methodName13.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
            return RequestLocalServiceUtil.getRequests(((Integer) arguments[0]).intValue(),
                ((Integer) arguments[1]).intValue());
        }

        if (_methodName14.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
            return RequestLocalServiceUtil.getRequestsCount();
        }

        if (_methodName15.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
            return RequestLocalServiceUtil.updateRequest((com.excilys.liferay.gatling.model.Request) arguments[0]);
        }

        if (_methodName64.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes64, parameterTypes)) {
            return RequestLocalServiceUtil.getBeanIdentifier();
        }

        if (_methodName65.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes65, parameterTypes)) {
            RequestLocalServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);

            return null;
        }

        if (_methodName70.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes70, parameterTypes)) {
            return RequestLocalServiceUtil.findByParentPlid(((Long) arguments[0]).longValue());
        }

        if (_methodName71.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes71, parameterTypes)) {
            return RequestLocalServiceUtil.countByParentPlid(((Long) arguments[0]).longValue());
        }

        if (_methodName72.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes72, parameterTypes)) {
            return RequestLocalServiceUtil.findByParentPlidAndScenario(((Long) arguments[0]).longValue(),
                ((Long) arguments[1]).longValue());
        }

        if (_methodName73.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes73, parameterTypes)) {
            return RequestLocalServiceUtil.countByParentPlidAndScenario(((Long) arguments[0]).longValue(),
                ((Long) arguments[1]).longValue());
        }

        if (_methodName74.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes74, parameterTypes)) {
            return RequestLocalServiceUtil.findByParentPlidAndScenarioAndPositif(((Long) arguments[0]).longValue(),
                ((Long) arguments[1]).longValue());
        }

        if (_methodName75.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes75, parameterTypes)) {
            return RequestLocalServiceUtil.countByParentPlidAndScenarioAndPositif(((Long) arguments[0]).longValue(),
                ((Long) arguments[1]).longValue());
        }

        if (_methodName76.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes76, parameterTypes)) {
            return RequestLocalServiceUtil.findByScenarioId(((Long) arguments[0]).longValue());
        }

        if (_methodName77.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes77, parameterTypes)) {
            return RequestLocalServiceUtil.countByScenarioId(((Long) arguments[0]).longValue());
        }

        if (_methodName78.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes78, parameterTypes)) {
            return RequestLocalServiceUtil.findByScenarioIdAndUsed(((Long) arguments[0]).longValue());
        }

        if (_methodName79.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes79, parameterTypes)) {
            return RequestLocalServiceUtil.countByScenarioIdAndUsed(((Long) arguments[0]).longValue());
        }

        if (_methodName80.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes80, parameterTypes)) {
            RequestLocalServiceUtil.removeByScenarioId(((Long) arguments[0]).longValue());

            return null;
        }

        if (_methodName81.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes81, parameterTypes)) {
            return RequestLocalServiceUtil.findByScenarioIdAndIsNotPortlet(((Long) arguments[0]).longValue());
        }

        if (_methodName82.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes82, parameterTypes)) {
            return RequestLocalServiceUtil.countByScenarioIdAndIsNotPortlet(((Long) arguments[0]).longValue());
        }

        if (_methodName83.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes83, parameterTypes)) {
            return RequestLocalServiceUtil.findByScenarioIdAndUsedAndIsNotPortlet(((Long) arguments[0]).longValue());
        }

        if (_methodName84.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes84, parameterTypes)) {
            return RequestLocalServiceUtil.countByScenarioIdAndUsedAndIsNotPortlet(((Long) arguments[0]).longValue());
        }

        if (_methodName85.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes85, parameterTypes)) {
            RequestLocalServiceUtil.addRequestFromDisplayItem((java.lang.Object) arguments[0],
                ((Double) arguments[1]).doubleValue(),
                ((Long) arguments[2]).longValue());

            return null;
        }

        throw new UnsupportedOperationException();
    }
}
