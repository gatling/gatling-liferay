package io.gatling.liferay.service.base;

import io.gatling.liferay.service.SiteMapLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class SiteMapLocalServiceClpInvoker {
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

    public SiteMapLocalServiceClpInvoker() {
        _methodName0 = "addSiteMap";

        _methodParameterTypes0 = new String[] { "io.gatling.liferay.model.SiteMap" };

        _methodName1 = "createSiteMap";

        _methodParameterTypes1 = new String[] { "long" };

        _methodName2 = "deleteSiteMap";

        _methodParameterTypes2 = new String[] { "long" };

        _methodName3 = "deleteSiteMap";

        _methodParameterTypes3 = new String[] { "io.gatling.liferay.model.SiteMap" };

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

        _methodName10 = "fetchSiteMap";

        _methodParameterTypes10 = new String[] { "long" };

        _methodName11 = "getSiteMap";

        _methodParameterTypes11 = new String[] { "long" };

        _methodName12 = "getPersistedModel";

        _methodParameterTypes12 = new String[] { "java.io.Serializable" };

        _methodName13 = "getSiteMaps";

        _methodParameterTypes13 = new String[] { "int", "int" };

        _methodName14 = "getSiteMapsCount";

        _methodParameterTypes14 = new String[] {  };

        _methodName15 = "updateSiteMap";

        _methodParameterTypes15 = new String[] {
                "io.gatling.liferay.model.SiteMap"
            };

        _methodName76 = "getBeanIdentifier";

        _methodParameterTypes76 = new String[] {  };

        _methodName77 = "setBeanIdentifier";

        _methodParameterTypes77 = new String[] { "java.lang.String" };

        _methodName82 = "siteMapCreation";

        _methodParameterTypes82 = new String[] {
                "com.liferay.portal.theme.ThemeDisplay", "long",
                "java.lang.String"
            };

        _methodName83 = "createSiteMap";

        _methodParameterTypes83 = new String[] { "java.lang.String" };

        _methodName84 = "findByProcessId";

        _methodParameterTypes84 = new String[] { "long" };

        _methodName85 = "findByName";

        _methodParameterTypes85 = new String[] { "java.lang.String" };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName0.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
            return SiteMapLocalServiceUtil.addSiteMap((io.gatling.liferay.model.SiteMap) arguments[0]);
        }

        if (_methodName1.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
            return SiteMapLocalServiceUtil.createSiteMap(((Long) arguments[0]).longValue());
        }

        if (_methodName2.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
            return SiteMapLocalServiceUtil.deleteSiteMap(((Long) arguments[0]).longValue());
        }

        if (_methodName3.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
            return SiteMapLocalServiceUtil.deleteSiteMap((io.gatling.liferay.model.SiteMap) arguments[0]);
        }

        if (_methodName4.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
            return SiteMapLocalServiceUtil.dynamicQuery();
        }

        if (_methodName5.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
            return SiteMapLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0]);
        }

        if (_methodName6.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
            return SiteMapLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue());
        }

        if (_methodName7.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
            return SiteMapLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue(),
                (com.liferay.portal.kernel.util.OrderByComparator) arguments[3]);
        }

        if (_methodName8.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
            return SiteMapLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0]);
        }

        if (_methodName9.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
            return SiteMapLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                (com.liferay.portal.kernel.dao.orm.Projection) arguments[1]);
        }

        if (_methodName10.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
            return SiteMapLocalServiceUtil.fetchSiteMap(((Long) arguments[0]).longValue());
        }

        if (_methodName11.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
            return SiteMapLocalServiceUtil.getSiteMap(((Long) arguments[0]).longValue());
        }

        if (_methodName12.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
            return SiteMapLocalServiceUtil.getPersistedModel((java.io.Serializable) arguments[0]);
        }

        if (_methodName13.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
            return SiteMapLocalServiceUtil.getSiteMaps(((Integer) arguments[0]).intValue(),
                ((Integer) arguments[1]).intValue());
        }

        if (_methodName14.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
            return SiteMapLocalServiceUtil.getSiteMapsCount();
        }

        if (_methodName15.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
            return SiteMapLocalServiceUtil.updateSiteMap((io.gatling.liferay.model.SiteMap) arguments[0]);
        }

        if (_methodName76.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes76, parameterTypes)) {
            return SiteMapLocalServiceUtil.getBeanIdentifier();
        }

        if (_methodName77.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes77, parameterTypes)) {
            SiteMapLocalServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);

            return null;
        }

        if (_methodName82.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes82, parameterTypes)) {
            return SiteMapLocalServiceUtil.siteMapCreation((com.liferay.portal.theme.ThemeDisplay) arguments[0],
                ((Long) arguments[1]).longValue(),
                (java.lang.String) arguments[2]);
        }

        if (_methodName83.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes83, parameterTypes)) {
            return SiteMapLocalServiceUtil.createSiteMap((java.lang.String) arguments[0]);
        }

        if (_methodName84.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes84, parameterTypes)) {
            return SiteMapLocalServiceUtil.findByProcessId(((Long) arguments[0]).longValue());
        }

        if (_methodName85.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes85, parameterTypes)) {
            return SiteMapLocalServiceUtil.findByName((java.lang.String) arguments[0]);
        }

        throw new UnsupportedOperationException();
    }
}
