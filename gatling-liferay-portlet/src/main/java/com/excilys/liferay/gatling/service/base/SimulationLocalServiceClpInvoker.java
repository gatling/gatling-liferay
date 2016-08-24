package com.excilys.liferay.gatling.service.base;

import com.excilys.liferay.gatling.service.SimulationLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class SimulationLocalServiceClpInvoker {
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
    private String _methodName72;
    private String[] _methodParameterTypes72;
    private String _methodName73;
    private String[] _methodParameterTypes73;
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

    public SimulationLocalServiceClpInvoker() {
        _methodName0 = "addSimulation";

        _methodParameterTypes0 = new String[] {
                "com.excilys.liferay.gatling.model.Simulation"
            };

        _methodName1 = "createSimulation";

        _methodParameterTypes1 = new String[] { "long" };

        _methodName2 = "deleteSimulation";

        _methodParameterTypes2 = new String[] { "long" };

        _methodName3 = "deleteSimulation";

        _methodParameterTypes3 = new String[] {
                "com.excilys.liferay.gatling.model.Simulation"
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

        _methodName10 = "fetchSimulation";

        _methodParameterTypes10 = new String[] { "long" };

        _methodName11 = "getSimulation";

        _methodParameterTypes11 = new String[] { "long" };

        _methodName12 = "getPersistedModel";

        _methodParameterTypes12 = new String[] { "java.io.Serializable" };

        _methodName13 = "getSimulations";

        _methodParameterTypes13 = new String[] { "int", "int" };

        _methodName14 = "getSimulationsCount";

        _methodParameterTypes14 = new String[] {  };

        _methodName15 = "updateSimulation";

        _methodParameterTypes15 = new String[] {
                "com.excilys.liferay.gatling.model.Simulation"
            };

        _methodName72 = "getBeanIdentifier";

        _methodParameterTypes72 = new String[] {  };

        _methodName73 = "setBeanIdentifier";

        _methodParameterTypes73 = new String[] { "java.lang.String" };

        _methodName78 = "removeSimulationCascade";

        _methodParameterTypes78 = new String[] { "java.lang.Long" };

        _methodName79 = "getByName";

        _methodParameterTypes79 = new String[] { "java.lang.String" };

        _methodName80 = "isNameUnique";

        _methodParameterTypes80 = new String[] { "java.lang.String" };

        _methodName81 = "addSimulationFromRequest";

        _methodParameterTypes81 = new String[] { "javax.portlet.ActionRequest" };

        _methodName82 = "containsPrivatePage";

        _methodParameterTypes82 = new String[] { "long" };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName0.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
            return SimulationLocalServiceUtil.addSimulation((com.excilys.liferay.gatling.model.Simulation) arguments[0]);
        }

        if (_methodName1.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
            return SimulationLocalServiceUtil.createSimulation(((Long) arguments[0]).longValue());
        }

        if (_methodName2.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
            return SimulationLocalServiceUtil.deleteSimulation(((Long) arguments[0]).longValue());
        }

        if (_methodName3.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
            return SimulationLocalServiceUtil.deleteSimulation((com.excilys.liferay.gatling.model.Simulation) arguments[0]);
        }

        if (_methodName4.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
            return SimulationLocalServiceUtil.dynamicQuery();
        }

        if (_methodName5.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
            return SimulationLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0]);
        }

        if (_methodName6.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
            return SimulationLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue());
        }

        if (_methodName7.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
            return SimulationLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue(),
                (com.liferay.portal.kernel.util.OrderByComparator) arguments[3]);
        }

        if (_methodName8.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
            return SimulationLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0]);
        }

        if (_methodName9.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
            return SimulationLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                (com.liferay.portal.kernel.dao.orm.Projection) arguments[1]);
        }

        if (_methodName10.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
            return SimulationLocalServiceUtil.fetchSimulation(((Long) arguments[0]).longValue());
        }

        if (_methodName11.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
            return SimulationLocalServiceUtil.getSimulation(((Long) arguments[0]).longValue());
        }

        if (_methodName12.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
            return SimulationLocalServiceUtil.getPersistedModel((java.io.Serializable) arguments[0]);
        }

        if (_methodName13.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
            return SimulationLocalServiceUtil.getSimulations(((Integer) arguments[0]).intValue(),
                ((Integer) arguments[1]).intValue());
        }

        if (_methodName14.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
            return SimulationLocalServiceUtil.getSimulationsCount();
        }

        if (_methodName15.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
            return SimulationLocalServiceUtil.updateSimulation((com.excilys.liferay.gatling.model.Simulation) arguments[0]);
        }

        if (_methodName72.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes72, parameterTypes)) {
            return SimulationLocalServiceUtil.getBeanIdentifier();
        }

        if (_methodName73.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes73, parameterTypes)) {
            SimulationLocalServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);

            return null;
        }

        if (_methodName78.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes78, parameterTypes)) {
            SimulationLocalServiceUtil.removeSimulationCascade((java.lang.Long) arguments[0]);

            return null;
        }

        if (_methodName79.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes79, parameterTypes)) {
            return SimulationLocalServiceUtil.getByName((java.lang.String) arguments[0]);
        }

        if (_methodName80.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes80, parameterTypes)) {
            return SimulationLocalServiceUtil.isNameUnique((java.lang.String) arguments[0]);
        }

        if (_methodName81.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes81, parameterTypes)) {
            return SimulationLocalServiceUtil.addSimulationFromRequest((javax.portlet.ActionRequest) arguments[0]);
        }

        if (_methodName82.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes82, parameterTypes)) {
            return SimulationLocalServiceUtil.containsPrivatePage(((Long) arguments[0]).longValue());
        }

        throw new UnsupportedOperationException();
    }
}
