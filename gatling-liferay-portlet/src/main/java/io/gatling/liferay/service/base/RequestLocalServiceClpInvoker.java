package io.gatling.liferay.service.base;

import io.gatling.liferay.service.RequestLocalServiceUtil;

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
    private String _methodName88;
    private String[] _methodParameterTypes88;
    private String _methodName89;
    private String[] _methodParameterTypes89;
    private String _methodName90;
    private String[] _methodParameterTypes90;
    private String _methodName91;
    private String[] _methodParameterTypes91;
    private String _methodName92;
    private String[] _methodParameterTypes92;
    private String _methodName93;
    private String[] _methodParameterTypes93;
    private String _methodName94;
    private String[] _methodParameterTypes94;
    private String _methodName95;
    private String[] _methodParameterTypes95;
    private String _methodName96;
    private String[] _methodParameterTypes96;
    private String _methodName97;
    private String[] _methodParameterTypes97;

    public RequestLocalServiceClpInvoker() {
        _methodName0 = "addRequest";

        _methodParameterTypes0 = new String[] { "io.gatling.liferay.model.Request" };

        _methodName1 = "createRequest";

        _methodParameterTypes1 = new String[] { "long" };

        _methodName2 = "deleteRequest";

        _methodParameterTypes2 = new String[] { "long" };

        _methodName3 = "deleteRequest";

        _methodParameterTypes3 = new String[] { "io.gatling.liferay.model.Request" };

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
                "io.gatling.liferay.model.Request"
            };

        _methodName76 = "getBeanIdentifier";

        _methodParameterTypes76 = new String[] {  };

        _methodName77 = "setBeanIdentifier";

        _methodParameterTypes77 = new String[] { "java.lang.String" };

        _methodName82 = "findByParentPlid";

        _methodParameterTypes82 = new String[] { "long" };

        _methodName83 = "countByParentPlid";

        _methodParameterTypes83 = new String[] { "long" };

        _methodName84 = "findByParentPlidAndScenario";

        _methodParameterTypes84 = new String[] { "long", "long" };

        _methodName85 = "countByParentPlidAndScenario";

        _methodParameterTypes85 = new String[] { "long", "long" };

        _methodName86 = "findByParentPlidAndScenarioAndPositif";

        _methodParameterTypes86 = new String[] { "long", "long" };

        _methodName87 = "countByParentPlidAndScenarioAndPositif";

        _methodParameterTypes87 = new String[] { "long", "long" };

        _methodName88 = "findByScenarioId";

        _methodParameterTypes88 = new String[] { "long" };

        _methodName89 = "countByScenarioId";

        _methodParameterTypes89 = new String[] { "long" };

        _methodName90 = "findByScenarioIdAndUsed";

        _methodParameterTypes90 = new String[] { "long" };

        _methodName91 = "countByScenarioIdAndUsed";

        _methodParameterTypes91 = new String[] { "long" };

        _methodName92 = "removeByScenarioId";

        _methodParameterTypes92 = new String[] { "long" };

        _methodName93 = "findByScenarioIdAndIsNotPortlet";

        _methodParameterTypes93 = new String[] { "long" };

        _methodName94 = "countByScenarioIdAndIsNotPortlet";

        _methodParameterTypes94 = new String[] { "long" };

        _methodName95 = "findByScenarioIdAndUsedAndIsNotPortlet";

        _methodParameterTypes95 = new String[] { "long" };

        _methodName96 = "countByScenarioIdAndUsedAndIsNotPortlet";

        _methodParameterTypes96 = new String[] { "long" };

        _methodName97 = "addRequestFromDisplayItem";

        _methodParameterTypes97 = new String[] {
                "java.lang.Object", "double", "long"
            };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName0.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
            return RequestLocalServiceUtil.addRequest((io.gatling.liferay.model.Request) arguments[0]);
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
            return RequestLocalServiceUtil.deleteRequest((io.gatling.liferay.model.Request) arguments[0]);
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
            return RequestLocalServiceUtil.updateRequest((io.gatling.liferay.model.Request) arguments[0]);
        }

        if (_methodName76.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes76, parameterTypes)) {
            return RequestLocalServiceUtil.getBeanIdentifier();
        }

        if (_methodName77.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes77, parameterTypes)) {
            RequestLocalServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);

            return null;
        }

        if (_methodName82.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes82, parameterTypes)) {
            return RequestLocalServiceUtil.findByParentPlid(((Long) arguments[0]).longValue());
        }

        if (_methodName83.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes83, parameterTypes)) {
            return RequestLocalServiceUtil.countByParentPlid(((Long) arguments[0]).longValue());
        }

        if (_methodName84.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes84, parameterTypes)) {
            return RequestLocalServiceUtil.findByParentPlidAndScenario(((Long) arguments[0]).longValue(),
                ((Long) arguments[1]).longValue());
        }

        if (_methodName85.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes85, parameterTypes)) {
            return RequestLocalServiceUtil.countByParentPlidAndScenario(((Long) arguments[0]).longValue(),
                ((Long) arguments[1]).longValue());
        }

        if (_methodName86.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes86, parameterTypes)) {
            return RequestLocalServiceUtil.findByParentPlidAndScenarioAndPositif(((Long) arguments[0]).longValue(),
                ((Long) arguments[1]).longValue());
        }

        if (_methodName87.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes87, parameterTypes)) {
            return RequestLocalServiceUtil.countByParentPlidAndScenarioAndPositif(((Long) arguments[0]).longValue(),
                ((Long) arguments[1]).longValue());
        }

        if (_methodName88.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes88, parameterTypes)) {
            return RequestLocalServiceUtil.findByScenarioId(((Long) arguments[0]).longValue());
        }

        if (_methodName89.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes89, parameterTypes)) {
            return RequestLocalServiceUtil.countByScenarioId(((Long) arguments[0]).longValue());
        }

        if (_methodName90.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes90, parameterTypes)) {
            return RequestLocalServiceUtil.findByScenarioIdAndUsed(((Long) arguments[0]).longValue());
        }

        if (_methodName91.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes91, parameterTypes)) {
            return RequestLocalServiceUtil.countByScenarioIdAndUsed(((Long) arguments[0]).longValue());
        }

        if (_methodName92.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes92, parameterTypes)) {
            RequestLocalServiceUtil.removeByScenarioId(((Long) arguments[0]).longValue());

            return null;
        }

        if (_methodName93.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes93, parameterTypes)) {
            return RequestLocalServiceUtil.findByScenarioIdAndIsNotPortlet(((Long) arguments[0]).longValue());
        }

        if (_methodName94.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes94, parameterTypes)) {
            return RequestLocalServiceUtil.countByScenarioIdAndIsNotPortlet(((Long) arguments[0]).longValue());
        }

        if (_methodName95.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes95, parameterTypes)) {
            return RequestLocalServiceUtil.findByScenarioIdAndUsedAndIsNotPortlet(((Long) arguments[0]).longValue());
        }

        if (_methodName96.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes96, parameterTypes)) {
            return RequestLocalServiceUtil.countByScenarioIdAndUsedAndIsNotPortlet(((Long) arguments[0]).longValue());
        }

        if (_methodName97.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes97, parameterTypes)) {
            RequestLocalServiceUtil.addRequestFromDisplayItem((java.lang.Object) arguments[0],
                ((Double) arguments[1]).doubleValue(),
                ((Long) arguments[2]).longValue());

            return null;
        }

        throw new UnsupportedOperationException();
    }
}
