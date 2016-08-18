package com.excilys.liferay.gatling.service.base;

import com.excilys.liferay.gatling.service.LinkUsecaseRequestLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class LinkUsecaseRequestLocalServiceClpInvoker {
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

    public LinkUsecaseRequestLocalServiceClpInvoker() {
        _methodName0 = "addLinkUsecaseRequest";

        _methodParameterTypes0 = new String[] {
                "com.excilys.liferay.gatling.model.LinkUsecaseRequest"
            };

        _methodName1 = "createLinkUsecaseRequest";

        _methodParameterTypes1 = new String[] { "long" };

        _methodName2 = "deleteLinkUsecaseRequest";

        _methodParameterTypes2 = new String[] { "long" };

        _methodName3 = "deleteLinkUsecaseRequest";

        _methodParameterTypes3 = new String[] {
                "com.excilys.liferay.gatling.model.LinkUsecaseRequest"
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

        _methodName10 = "fetchLinkUsecaseRequest";

        _methodParameterTypes10 = new String[] { "long" };

        _methodName11 = "getLinkUsecaseRequest";

        _methodParameterTypes11 = new String[] { "long" };

        _methodName12 = "getPersistedModel";

        _methodParameterTypes12 = new String[] { "java.io.Serializable" };

        _methodName13 = "getLinkUsecaseRequests";

        _methodParameterTypes13 = new String[] { "int", "int" };

        _methodName14 = "getLinkUsecaseRequestsCount";

        _methodParameterTypes14 = new String[] {  };

        _methodName15 = "updateLinkUsecaseRequest";

        _methodParameterTypes15 = new String[] {
                "com.excilys.liferay.gatling.model.LinkUsecaseRequest"
            };

        _methodName64 = "getBeanIdentifier";

        _methodParameterTypes64 = new String[] {  };

        _methodName65 = "setBeanIdentifier";

        _methodParameterTypes65 = new String[] { "java.lang.String" };

        _methodName70 = "saveLinkUseCase";

        _methodParameterTypes70 = new String[] {
                "long", "long", "long", "double", "boolean"
            };

        _methodName71 = "findByRecordAndRequest";

        _methodParameterTypes71 = new String[] { "long", "long" };

        _methodName72 = "countByRequestIdAndUsed";

        _methodParameterTypes72 = new String[] { "long" };

        _methodName73 = "findByRequestIdAndUsed";

        _methodParameterTypes73 = new String[] { "long" };

        _methodName74 = "countByRequestId";

        _methodParameterTypes74 = new String[] { "long" };

        _methodName75 = "findByRequestId";

        _methodParameterTypes75 = new String[] { "long" };

        _methodName76 = "removeByRequestId";

        _methodParameterTypes76 = new String[] { "long" };

        _methodName77 = "removeByRecordId";

        _methodParameterTypes77 = new String[] { "long" };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName0.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
            return LinkUsecaseRequestLocalServiceUtil.addLinkUsecaseRequest((com.excilys.liferay.gatling.model.LinkUsecaseRequest) arguments[0]);
        }

        if (_methodName1.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
            return LinkUsecaseRequestLocalServiceUtil.createLinkUsecaseRequest(((Long) arguments[0]).longValue());
        }

        if (_methodName2.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
            return LinkUsecaseRequestLocalServiceUtil.deleteLinkUsecaseRequest(((Long) arguments[0]).longValue());
        }

        if (_methodName3.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
            return LinkUsecaseRequestLocalServiceUtil.deleteLinkUsecaseRequest((com.excilys.liferay.gatling.model.LinkUsecaseRequest) arguments[0]);
        }

        if (_methodName4.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
            return LinkUsecaseRequestLocalServiceUtil.dynamicQuery();
        }

        if (_methodName5.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
            return LinkUsecaseRequestLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0]);
        }

        if (_methodName6.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
            return LinkUsecaseRequestLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue());
        }

        if (_methodName7.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
            return LinkUsecaseRequestLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue(),
                (com.liferay.portal.kernel.util.OrderByComparator) arguments[3]);
        }

        if (_methodName8.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
            return LinkUsecaseRequestLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0]);
        }

        if (_methodName9.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
            return LinkUsecaseRequestLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                (com.liferay.portal.kernel.dao.orm.Projection) arguments[1]);
        }

        if (_methodName10.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
            return LinkUsecaseRequestLocalServiceUtil.fetchLinkUsecaseRequest(((Long) arguments[0]).longValue());
        }

        if (_methodName11.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
            return LinkUsecaseRequestLocalServiceUtil.getLinkUsecaseRequest(((Long) arguments[0]).longValue());
        }

        if (_methodName12.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
            return LinkUsecaseRequestLocalServiceUtil.getPersistedModel((java.io.Serializable) arguments[0]);
        }

        if (_methodName13.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
            return LinkUsecaseRequestLocalServiceUtil.getLinkUsecaseRequests(((Integer) arguments[0]).intValue(),
                ((Integer) arguments[1]).intValue());
        }

        if (_methodName14.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
            return LinkUsecaseRequestLocalServiceUtil.getLinkUsecaseRequestsCount();
        }

        if (_methodName15.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
            return LinkUsecaseRequestLocalServiceUtil.updateLinkUsecaseRequest((com.excilys.liferay.gatling.model.LinkUsecaseRequest) arguments[0]);
        }

        if (_methodName64.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes64, parameterTypes)) {
            return LinkUsecaseRequestLocalServiceUtil.getBeanIdentifier();
        }

        if (_methodName65.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes65, parameterTypes)) {
            LinkUsecaseRequestLocalServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);

            return null;
        }

        if (_methodName70.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes70, parameterTypes)) {
            LinkUsecaseRequestLocalServiceUtil.saveLinkUseCase(((Long) arguments[0]).longValue(),
                ((Long) arguments[1]).longValue(),
                ((Long) arguments[2]).longValue(),
                ((Double) arguments[3]).doubleValue(),
                ((Boolean) arguments[4]).booleanValue());

            return null;
        }

        if (_methodName71.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes71, parameterTypes)) {
            return LinkUsecaseRequestLocalServiceUtil.findByRecordAndRequest(((Long) arguments[0]).longValue(),
                ((Long) arguments[1]).longValue());
        }

        if (_methodName72.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes72, parameterTypes)) {
            return LinkUsecaseRequestLocalServiceUtil.countByRequestIdAndUsed(((Long) arguments[0]).longValue());
        }

        if (_methodName73.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes73, parameterTypes)) {
            return LinkUsecaseRequestLocalServiceUtil.findByRequestIdAndUsed(((Long) arguments[0]).longValue());
        }

        if (_methodName74.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes74, parameterTypes)) {
            return LinkUsecaseRequestLocalServiceUtil.countByRequestId(((Long) arguments[0]).longValue());
        }

        if (_methodName75.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes75, parameterTypes)) {
            return LinkUsecaseRequestLocalServiceUtil.findByRequestId(((Long) arguments[0]).longValue());
        }

        if (_methodName76.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes76, parameterTypes)) {
            LinkUsecaseRequestLocalServiceUtil.removeByRequestId(((Long) arguments[0]).longValue());

            return null;
        }

        if (_methodName77.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes77, parameterTypes)) {
            LinkUsecaseRequestLocalServiceUtil.removeByRecordId(((Long) arguments[0]).longValue());

            return null;
        }

        throw new UnsupportedOperationException();
    }
}
