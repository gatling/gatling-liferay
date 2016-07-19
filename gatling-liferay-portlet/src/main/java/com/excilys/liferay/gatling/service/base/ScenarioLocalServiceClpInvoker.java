package com.excilys.liferay.gatling.service.base;

import com.excilys.liferay.gatling.service.ScenarioLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ScenarioLocalServiceClpInvoker {
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
    private String _methodName56;
    private String[] _methodParameterTypes56;
    private String _methodName57;
    private String[] _methodParameterTypes57;
    private String _methodName62;
    private String[] _methodParameterTypes62;
    private String _methodName63;
    private String[] _methodParameterTypes63;
    private String _methodName64;
    private String[] _methodParameterTypes64;
    private String _methodName65;
    private String[] _methodParameterTypes65;
    private String _methodName66;
    private String[] _methodParameterTypes66;
    private String _methodName67;
    private String[] _methodParameterTypes67;
    private String _methodName68;
    private String[] _methodParameterTypes68;
    private String _methodName69;
    private String[] _methodParameterTypes69;
    private String _methodName70;
    private String[] _methodParameterTypes70;

    public ScenarioLocalServiceClpInvoker() {
        _methodName0 = "addScenario";

        _methodParameterTypes0 = new String[] {
                "com.excilys.liferay.gatling.model.Scenario"
            };

        _methodName1 = "createScenario";

        _methodParameterTypes1 = new String[] { "long" };

        _methodName2 = "deleteScenario";

        _methodParameterTypes2 = new String[] { "long" };

        _methodName3 = "deleteScenario";

        _methodParameterTypes3 = new String[] {
                "com.excilys.liferay.gatling.model.Scenario"
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

        _methodName10 = "fetchScenario";

        _methodParameterTypes10 = new String[] { "long" };

        _methodName11 = "getScenario";

        _methodParameterTypes11 = new String[] { "long" };

        _methodName12 = "getPersistedModel";

        _methodParameterTypes12 = new String[] { "java.io.Serializable" };

        _methodName13 = "getScenarios";

        _methodParameterTypes13 = new String[] { "int", "int" };

        _methodName14 = "getScenariosCount";

        _methodParameterTypes14 = new String[] {  };

        _methodName15 = "updateScenario";

        _methodParameterTypes15 = new String[] {
                "com.excilys.liferay.gatling.model.Scenario"
            };

        _methodName56 = "getBeanIdentifier";

        _methodParameterTypes56 = new String[] {  };

        _methodName57 = "setBeanIdentifier";

        _methodParameterTypes57 = new String[] { "java.lang.String" };

        _methodName62 = "countBySimulationId";

        _methodParameterTypes62 = new String[] { "long" };

        _methodName63 = "findBySimulationId";

        _methodParameterTypes63 = new String[] { "long" };

        _methodName64 = "removeBySimulationIdCascade";

        _methodParameterTypes64 = new String[] { "long" };

        _methodName65 = "removeByIdCascade";

        _methodParameterTypes65 = new String[] { "long" };

        _methodName66 = "isNameUnique";

        _methodParameterTypes66 = new String[] { "java.lang.String", "long" };

        _methodName67 = "countByVariableName";

        _methodParameterTypes67 = new String[] { "java.lang.String", "long" };

        _methodName68 = "findByVariableName";

        _methodParameterTypes68 = new String[] { "java.lang.String", "long" };

        _methodName69 = "addScenarioFromRequest";

        _methodParameterTypes69 = new String[] { "javax.portlet.ActionRequest" };

        _methodName70 = "editScenarioFromRequest";

        _methodParameterTypes70 = new String[] { "javax.portlet.ActionRequest" };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName0.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
            return ScenarioLocalServiceUtil.addScenario((com.excilys.liferay.gatling.model.Scenario) arguments[0]);
        }

        if (_methodName1.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
            return ScenarioLocalServiceUtil.createScenario(((Long) arguments[0]).longValue());
        }

        if (_methodName2.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
            return ScenarioLocalServiceUtil.deleteScenario(((Long) arguments[0]).longValue());
        }

        if (_methodName3.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
            return ScenarioLocalServiceUtil.deleteScenario((com.excilys.liferay.gatling.model.Scenario) arguments[0]);
        }

        if (_methodName4.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
            return ScenarioLocalServiceUtil.dynamicQuery();
        }

        if (_methodName5.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
            return ScenarioLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0]);
        }

        if (_methodName6.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
            return ScenarioLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue());
        }

        if (_methodName7.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
            return ScenarioLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue(),
                (com.liferay.portal.kernel.util.OrderByComparator) arguments[3]);
        }

        if (_methodName8.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
            return ScenarioLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0]);
        }

        if (_methodName9.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
            return ScenarioLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                (com.liferay.portal.kernel.dao.orm.Projection) arguments[1]);
        }

        if (_methodName10.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
            return ScenarioLocalServiceUtil.fetchScenario(((Long) arguments[0]).longValue());
        }

        if (_methodName11.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
            return ScenarioLocalServiceUtil.getScenario(((Long) arguments[0]).longValue());
        }

        if (_methodName12.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
            return ScenarioLocalServiceUtil.getPersistedModel((java.io.Serializable) arguments[0]);
        }

        if (_methodName13.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
            return ScenarioLocalServiceUtil.getScenarios(((Integer) arguments[0]).intValue(),
                ((Integer) arguments[1]).intValue());
        }

        if (_methodName14.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
            return ScenarioLocalServiceUtil.getScenariosCount();
        }

        if (_methodName15.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
            return ScenarioLocalServiceUtil.updateScenario((com.excilys.liferay.gatling.model.Scenario) arguments[0]);
        }

        if (_methodName56.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes56, parameterTypes)) {
            return ScenarioLocalServiceUtil.getBeanIdentifier();
        }

        if (_methodName57.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes57, parameterTypes)) {
            ScenarioLocalServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);

            return null;
        }

        if (_methodName62.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes62, parameterTypes)) {
            return ScenarioLocalServiceUtil.countBySimulationId(((Long) arguments[0]).longValue());
        }

        if (_methodName63.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes63, parameterTypes)) {
            return ScenarioLocalServiceUtil.findBySimulationId(((Long) arguments[0]).longValue());
        }

        if (_methodName64.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes64, parameterTypes)) {
            ScenarioLocalServiceUtil.removeBySimulationIdCascade(((Long) arguments[0]).longValue());

            return null;
        }

        if (_methodName65.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes65, parameterTypes)) {
            ScenarioLocalServiceUtil.removeByIdCascade(((Long) arguments[0]).longValue());

            return null;
        }

        if (_methodName66.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes66, parameterTypes)) {
            return ScenarioLocalServiceUtil.isNameUnique((java.lang.String) arguments[0],
                ((Long) arguments[1]).longValue());
        }

        if (_methodName67.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes67, parameterTypes)) {
            return ScenarioLocalServiceUtil.countByVariableName((java.lang.String) arguments[0],
                ((Long) arguments[1]).longValue());
        }

        if (_methodName68.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes68, parameterTypes)) {
            return ScenarioLocalServiceUtil.findByVariableName((java.lang.String) arguments[0],
                ((Long) arguments[1]).longValue());
        }

        if (_methodName69.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes69, parameterTypes)) {
            return ScenarioLocalServiceUtil.addScenarioFromRequest((javax.portlet.ActionRequest) arguments[0]);
        }

        if (_methodName70.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes70, parameterTypes)) {
            return ScenarioLocalServiceUtil.editScenarioFromRequest((javax.portlet.ActionRequest) arguments[0]);
        }

        throw new UnsupportedOperationException();
    }
}
