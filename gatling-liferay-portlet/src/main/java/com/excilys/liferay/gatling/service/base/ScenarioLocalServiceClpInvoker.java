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

        _methodName76 = "getBeanIdentifier";

        _methodParameterTypes76 = new String[] {  };

        _methodName77 = "setBeanIdentifier";

        _methodParameterTypes77 = new String[] { "java.lang.String" };

        _methodName82 = "createDefaultScenario";

        _methodParameterTypes82 = new String[] {
                "com.excilys.liferay.gatling.model.Simulation"
            };

        _methodName83 = "createScenario";

        _methodParameterTypes83 = new String[] {
                "java.lang.String", "long", "java.lang.String", "int", "int"
            };

        _methodName84 = "addProcess";

        _methodParameterTypes84 = new String[] { "long", "long", "int", "int" };

        _methodName85 = "countBySimulationId";

        _methodParameterTypes85 = new String[] { "long" };

        _methodName86 = "findBySimulationId";

        _methodParameterTypes86 = new String[] { "long" };

        _methodName87 = "removeBySimulationIdCascade";

        _methodParameterTypes87 = new String[] { "long" };

        _methodName88 = "removeByIdCascade";

        _methodParameterTypes88 = new String[] { "long" };

        _methodName89 = "isNameUnique";

        _methodParameterTypes89 = new String[] { "java.lang.String", "long" };

        _methodName90 = "countByVariableName";

        _methodParameterTypes90 = new String[] { "java.lang.String", "long" };

        _methodName91 = "findByVariableName";

        _methodParameterTypes91 = new String[] { "java.lang.String", "long" };

        _methodName92 = "addScenarioFromRequest";

        _methodParameterTypes92 = new String[] { "javax.portlet.ActionRequest" };

        _methodName93 = "editScenarioFromRequest";

        _methodParameterTypes93 = new String[] { "javax.portlet.ActionRequest" };
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

        if (_methodName76.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes76, parameterTypes)) {
            return ScenarioLocalServiceUtil.getBeanIdentifier();
        }

        if (_methodName77.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes77, parameterTypes)) {
            ScenarioLocalServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);

            return null;
        }

        if (_methodName82.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes82, parameterTypes)) {
            return ScenarioLocalServiceUtil.createDefaultScenario((com.excilys.liferay.gatling.model.Simulation) arguments[0]);
        }

        if (_methodName83.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes83, parameterTypes)) {
            return ScenarioLocalServiceUtil.createScenario((java.lang.String) arguments[0],
                ((Long) arguments[1]).longValue(),
                (java.lang.String) arguments[2],
                ((Integer) arguments[3]).intValue(),
                ((Integer) arguments[4]).intValue());
        }

        if (_methodName84.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes84, parameterTypes)) {
            ScenarioLocalServiceUtil.addProcess(((Long) arguments[0]).longValue(),
                ((Long) arguments[1]).longValue(),
                ((Integer) arguments[2]).intValue(),
                ((Integer) arguments[3]).intValue());

            return null;
        }

        if (_methodName85.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes85, parameterTypes)) {
            return ScenarioLocalServiceUtil.countBySimulationId(((Long) arguments[0]).longValue());
        }

        if (_methodName86.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes86, parameterTypes)) {
            return ScenarioLocalServiceUtil.findBySimulationId(((Long) arguments[0]).longValue());
        }

        if (_methodName87.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes87, parameterTypes)) {
            ScenarioLocalServiceUtil.removeBySimulationIdCascade(((Long) arguments[0]).longValue());

            return null;
        }

        if (_methodName88.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes88, parameterTypes)) {
            ScenarioLocalServiceUtil.removeByIdCascade(((Long) arguments[0]).longValue());

            return null;
        }

        if (_methodName89.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes89, parameterTypes)) {
            return ScenarioLocalServiceUtil.isNameUnique((java.lang.String) arguments[0],
                ((Long) arguments[1]).longValue());
        }

        if (_methodName90.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes90, parameterTypes)) {
            return ScenarioLocalServiceUtil.countByVariableName((java.lang.String) arguments[0],
                ((Long) arguments[1]).longValue());
        }

        if (_methodName91.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes91, parameterTypes)) {
            return ScenarioLocalServiceUtil.findByVariableName((java.lang.String) arguments[0],
                ((Long) arguments[1]).longValue());
        }

        if (_methodName92.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes92, parameterTypes)) {
            return ScenarioLocalServiceUtil.addScenarioFromRequest((javax.portlet.ActionRequest) arguments[0]);
        }

        if (_methodName93.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes93, parameterTypes)) {
            return ScenarioLocalServiceUtil.editScenarioFromRequest((javax.portlet.ActionRequest) arguments[0]);
        }

        throw new UnsupportedOperationException();
    }
}
