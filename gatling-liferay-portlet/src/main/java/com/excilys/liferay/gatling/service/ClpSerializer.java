package com.excilys.liferay.gatling.service;

import com.excilys.liferay.gatling.model.FormParamClp;
import com.excilys.liferay.gatling.model.LinkProcessRecordClp;
import com.excilys.liferay.gatling.model.LinkUsecaseRequestClp;
import com.excilys.liferay.gatling.model.ProcessClp;
import com.excilys.liferay.gatling.model.RecordClp;
import com.excilys.liferay.gatling.model.RequestClp;
import com.excilys.liferay.gatling.model.ScenarioClp;
import com.excilys.liferay.gatling.model.SimulationClp;
import com.excilys.liferay.gatling.model.UrlRecordClp;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayInputStream;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayOutputStream;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ClassLoaderObjectInputStream;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.BaseModel;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.lang.reflect.Method;

import java.util.ArrayList;
import java.util.List;


public class ClpSerializer {
    private static Log _log = LogFactoryUtil.getLog(ClpSerializer.class);
    private static String _servletContextName;
    private static boolean _useReflectionToTranslateThrowable = true;

    public static String getServletContextName() {
        if (Validator.isNotNull(_servletContextName)) {
            return _servletContextName;
        }

        synchronized (ClpSerializer.class) {
            if (Validator.isNotNull(_servletContextName)) {
                return _servletContextName;
            }

            try {
                ClassLoader classLoader = ClpSerializer.class.getClassLoader();

                Class<?> portletPropsClass = classLoader.loadClass(
                        "com.liferay.util.portlet.PortletProps");

                Method getMethod = portletPropsClass.getMethod("get",
                        new Class<?>[] { String.class });

                String portletPropsServletContextName = (String) getMethod.invoke(null,
                        "gatling-liferay-portlet-deployment-context");

                if (Validator.isNotNull(portletPropsServletContextName)) {
                    _servletContextName = portletPropsServletContextName;
                }
            } catch (Throwable t) {
                if (_log.isInfoEnabled()) {
                    _log.info(
                        "Unable to locate deployment context from portlet properties");
                }
            }

            if (Validator.isNull(_servletContextName)) {
                try {
                    String propsUtilServletContextName = PropsUtil.get(
                            "gatling-liferay-portlet-deployment-context");

                    if (Validator.isNotNull(propsUtilServletContextName)) {
                        _servletContextName = propsUtilServletContextName;
                    }
                } catch (Throwable t) {
                    if (_log.isInfoEnabled()) {
                        _log.info(
                            "Unable to locate deployment context from portal properties");
                    }
                }
            }

            if (Validator.isNull(_servletContextName)) {
                _servletContextName = "gatling-liferay-portlet";
            }

            return _servletContextName;
        }
    }

    public static Object translateInput(BaseModel<?> oldModel) {
        Class<?> oldModelClass = oldModel.getClass();

        String oldModelClassName = oldModelClass.getName();

        if (oldModelClassName.equals(FormParamClp.class.getName())) {
            return translateInputFormParam(oldModel);
        }

        if (oldModelClassName.equals(LinkProcessRecordClp.class.getName())) {
            return translateInputLinkProcessRecord(oldModel);
        }

        if (oldModelClassName.equals(LinkUsecaseRequestClp.class.getName())) {
            return translateInputLinkUsecaseRequest(oldModel);
        }

        if (oldModelClassName.equals(ProcessClp.class.getName())) {
            return translateInputProcess(oldModel);
        }

        if (oldModelClassName.equals(RecordClp.class.getName())) {
            return translateInputRecord(oldModel);
        }

        if (oldModelClassName.equals(RequestClp.class.getName())) {
            return translateInputRequest(oldModel);
        }

        if (oldModelClassName.equals(ScenarioClp.class.getName())) {
            return translateInputScenario(oldModel);
        }

        if (oldModelClassName.equals(SimulationClp.class.getName())) {
            return translateInputSimulation(oldModel);
        }

        if (oldModelClassName.equals(UrlRecordClp.class.getName())) {
            return translateInputUrlRecord(oldModel);
        }

        return oldModel;
    }

    public static Object translateInput(List<Object> oldList) {
        List<Object> newList = new ArrayList<Object>(oldList.size());

        for (int i = 0; i < oldList.size(); i++) {
            Object curObj = oldList.get(i);

            newList.add(translateInput(curObj));
        }

        return newList;
    }

    public static Object translateInputFormParam(BaseModel<?> oldModel) {
        FormParamClp oldClpModel = (FormParamClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getFormParamRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputLinkProcessRecord(BaseModel<?> oldModel) {
        LinkProcessRecordClp oldClpModel = (LinkProcessRecordClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getLinkProcessRecordRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputLinkUsecaseRequest(BaseModel<?> oldModel) {
        LinkUsecaseRequestClp oldClpModel = (LinkUsecaseRequestClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getLinkUsecaseRequestRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputProcess(BaseModel<?> oldModel) {
        ProcessClp oldClpModel = (ProcessClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getProcessRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputRecord(BaseModel<?> oldModel) {
        RecordClp oldClpModel = (RecordClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getRecordRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputRequest(BaseModel<?> oldModel) {
        RequestClp oldClpModel = (RequestClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getRequestRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputScenario(BaseModel<?> oldModel) {
        ScenarioClp oldClpModel = (ScenarioClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getScenarioRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputSimulation(BaseModel<?> oldModel) {
        SimulationClp oldClpModel = (SimulationClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getSimulationRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputUrlRecord(BaseModel<?> oldModel) {
        UrlRecordClp oldClpModel = (UrlRecordClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getUrlRecordRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInput(Object obj) {
        if (obj instanceof BaseModel<?>) {
            return translateInput((BaseModel<?>) obj);
        } else if (obj instanceof List<?>) {
            return translateInput((List<Object>) obj);
        } else {
            return obj;
        }
    }

    public static Object translateOutput(BaseModel<?> oldModel) {
        Class<?> oldModelClass = oldModel.getClass();

        String oldModelClassName = oldModelClass.getName();

        if (oldModelClassName.equals(
                    "com.excilys.liferay.gatling.model.impl.FormParamImpl")) {
            return translateOutputFormParam(oldModel);
        } else if (oldModelClassName.endsWith("Clp")) {
            try {
                ClassLoader classLoader = ClpSerializer.class.getClassLoader();

                Method getClpSerializerClassMethod = oldModelClass.getMethod(
                        "getClpSerializerClass");

                Class<?> oldClpSerializerClass = (Class<?>) getClpSerializerClassMethod.invoke(oldModel);

                Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

                Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
                        BaseModel.class);

                Class<?> oldModelModelClass = oldModel.getModelClass();

                Method getRemoteModelMethod = oldModelClass.getMethod("get" +
                        oldModelModelClass.getSimpleName() + "RemoteModel");

                Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

                BaseModel<?> newModel = (BaseModel<?>) translateOutputMethod.invoke(null,
                        oldRemoteModel);

                return newModel;
            } catch (Throwable t) {
                if (_log.isInfoEnabled()) {
                    _log.info("Unable to translate " + oldModelClassName, t);
                }
            }
        }

        if (oldModelClassName.equals(
                    "com.excilys.liferay.gatling.model.impl.LinkProcessRecordImpl")) {
            return translateOutputLinkProcessRecord(oldModel);
        } else if (oldModelClassName.endsWith("Clp")) {
            try {
                ClassLoader classLoader = ClpSerializer.class.getClassLoader();

                Method getClpSerializerClassMethod = oldModelClass.getMethod(
                        "getClpSerializerClass");

                Class<?> oldClpSerializerClass = (Class<?>) getClpSerializerClassMethod.invoke(oldModel);

                Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

                Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
                        BaseModel.class);

                Class<?> oldModelModelClass = oldModel.getModelClass();

                Method getRemoteModelMethod = oldModelClass.getMethod("get" +
                        oldModelModelClass.getSimpleName() + "RemoteModel");

                Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

                BaseModel<?> newModel = (BaseModel<?>) translateOutputMethod.invoke(null,
                        oldRemoteModel);

                return newModel;
            } catch (Throwable t) {
                if (_log.isInfoEnabled()) {
                    _log.info("Unable to translate " + oldModelClassName, t);
                }
            }
        }

        if (oldModelClassName.equals(
                    "com.excilys.liferay.gatling.model.impl.LinkUsecaseRequestImpl")) {
            return translateOutputLinkUsecaseRequest(oldModel);
        } else if (oldModelClassName.endsWith("Clp")) {
            try {
                ClassLoader classLoader = ClpSerializer.class.getClassLoader();

                Method getClpSerializerClassMethod = oldModelClass.getMethod(
                        "getClpSerializerClass");

                Class<?> oldClpSerializerClass = (Class<?>) getClpSerializerClassMethod.invoke(oldModel);

                Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

                Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
                        BaseModel.class);

                Class<?> oldModelModelClass = oldModel.getModelClass();

                Method getRemoteModelMethod = oldModelClass.getMethod("get" +
                        oldModelModelClass.getSimpleName() + "RemoteModel");

                Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

                BaseModel<?> newModel = (BaseModel<?>) translateOutputMethod.invoke(null,
                        oldRemoteModel);

                return newModel;
            } catch (Throwable t) {
                if (_log.isInfoEnabled()) {
                    _log.info("Unable to translate " + oldModelClassName, t);
                }
            }
        }

        if (oldModelClassName.equals(
                    "com.excilys.liferay.gatling.model.impl.ProcessImpl")) {
            return translateOutputProcess(oldModel);
        } else if (oldModelClassName.endsWith("Clp")) {
            try {
                ClassLoader classLoader = ClpSerializer.class.getClassLoader();

                Method getClpSerializerClassMethod = oldModelClass.getMethod(
                        "getClpSerializerClass");

                Class<?> oldClpSerializerClass = (Class<?>) getClpSerializerClassMethod.invoke(oldModel);

                Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

                Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
                        BaseModel.class);

                Class<?> oldModelModelClass = oldModel.getModelClass();

                Method getRemoteModelMethod = oldModelClass.getMethod("get" +
                        oldModelModelClass.getSimpleName() + "RemoteModel");

                Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

                BaseModel<?> newModel = (BaseModel<?>) translateOutputMethod.invoke(null,
                        oldRemoteModel);

                return newModel;
            } catch (Throwable t) {
                if (_log.isInfoEnabled()) {
                    _log.info("Unable to translate " + oldModelClassName, t);
                }
            }
        }

        if (oldModelClassName.equals(
                    "com.excilys.liferay.gatling.model.impl.RecordImpl")) {
            return translateOutputRecord(oldModel);
        } else if (oldModelClassName.endsWith("Clp")) {
            try {
                ClassLoader classLoader = ClpSerializer.class.getClassLoader();

                Method getClpSerializerClassMethod = oldModelClass.getMethod(
                        "getClpSerializerClass");

                Class<?> oldClpSerializerClass = (Class<?>) getClpSerializerClassMethod.invoke(oldModel);

                Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

                Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
                        BaseModel.class);

                Class<?> oldModelModelClass = oldModel.getModelClass();

                Method getRemoteModelMethod = oldModelClass.getMethod("get" +
                        oldModelModelClass.getSimpleName() + "RemoteModel");

                Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

                BaseModel<?> newModel = (BaseModel<?>) translateOutputMethod.invoke(null,
                        oldRemoteModel);

                return newModel;
            } catch (Throwable t) {
                if (_log.isInfoEnabled()) {
                    _log.info("Unable to translate " + oldModelClassName, t);
                }
            }
        }

        if (oldModelClassName.equals(
                    "com.excilys.liferay.gatling.model.impl.RequestImpl")) {
            return translateOutputRequest(oldModel);
        } else if (oldModelClassName.endsWith("Clp")) {
            try {
                ClassLoader classLoader = ClpSerializer.class.getClassLoader();

                Method getClpSerializerClassMethod = oldModelClass.getMethod(
                        "getClpSerializerClass");

                Class<?> oldClpSerializerClass = (Class<?>) getClpSerializerClassMethod.invoke(oldModel);

                Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

                Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
                        BaseModel.class);

                Class<?> oldModelModelClass = oldModel.getModelClass();

                Method getRemoteModelMethod = oldModelClass.getMethod("get" +
                        oldModelModelClass.getSimpleName() + "RemoteModel");

                Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

                BaseModel<?> newModel = (BaseModel<?>) translateOutputMethod.invoke(null,
                        oldRemoteModel);

                return newModel;
            } catch (Throwable t) {
                if (_log.isInfoEnabled()) {
                    _log.info("Unable to translate " + oldModelClassName, t);
                }
            }
        }

        if (oldModelClassName.equals(
                    "com.excilys.liferay.gatling.model.impl.ScenarioImpl")) {
            return translateOutputScenario(oldModel);
        } else if (oldModelClassName.endsWith("Clp")) {
            try {
                ClassLoader classLoader = ClpSerializer.class.getClassLoader();

                Method getClpSerializerClassMethod = oldModelClass.getMethod(
                        "getClpSerializerClass");

                Class<?> oldClpSerializerClass = (Class<?>) getClpSerializerClassMethod.invoke(oldModel);

                Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

                Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
                        BaseModel.class);

                Class<?> oldModelModelClass = oldModel.getModelClass();

                Method getRemoteModelMethod = oldModelClass.getMethod("get" +
                        oldModelModelClass.getSimpleName() + "RemoteModel");

                Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

                BaseModel<?> newModel = (BaseModel<?>) translateOutputMethod.invoke(null,
                        oldRemoteModel);

                return newModel;
            } catch (Throwable t) {
                if (_log.isInfoEnabled()) {
                    _log.info("Unable to translate " + oldModelClassName, t);
                }
            }
        }

        if (oldModelClassName.equals(
                    "com.excilys.liferay.gatling.model.impl.SimulationImpl")) {
            return translateOutputSimulation(oldModel);
        } else if (oldModelClassName.endsWith("Clp")) {
            try {
                ClassLoader classLoader = ClpSerializer.class.getClassLoader();

                Method getClpSerializerClassMethod = oldModelClass.getMethod(
                        "getClpSerializerClass");

                Class<?> oldClpSerializerClass = (Class<?>) getClpSerializerClassMethod.invoke(oldModel);

                Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

                Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
                        BaseModel.class);

                Class<?> oldModelModelClass = oldModel.getModelClass();

                Method getRemoteModelMethod = oldModelClass.getMethod("get" +
                        oldModelModelClass.getSimpleName() + "RemoteModel");

                Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

                BaseModel<?> newModel = (BaseModel<?>) translateOutputMethod.invoke(null,
                        oldRemoteModel);

                return newModel;
            } catch (Throwable t) {
                if (_log.isInfoEnabled()) {
                    _log.info("Unable to translate " + oldModelClassName, t);
                }
            }
        }

        if (oldModelClassName.equals(
                    "com.excilys.liferay.gatling.model.impl.UrlRecordImpl")) {
            return translateOutputUrlRecord(oldModel);
        } else if (oldModelClassName.endsWith("Clp")) {
            try {
                ClassLoader classLoader = ClpSerializer.class.getClassLoader();

                Method getClpSerializerClassMethod = oldModelClass.getMethod(
                        "getClpSerializerClass");

                Class<?> oldClpSerializerClass = (Class<?>) getClpSerializerClassMethod.invoke(oldModel);

                Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

                Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
                        BaseModel.class);

                Class<?> oldModelModelClass = oldModel.getModelClass();

                Method getRemoteModelMethod = oldModelClass.getMethod("get" +
                        oldModelModelClass.getSimpleName() + "RemoteModel");

                Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

                BaseModel<?> newModel = (BaseModel<?>) translateOutputMethod.invoke(null,
                        oldRemoteModel);

                return newModel;
            } catch (Throwable t) {
                if (_log.isInfoEnabled()) {
                    _log.info("Unable to translate " + oldModelClassName, t);
                }
            }
        }

        return oldModel;
    }

    public static Object translateOutput(List<Object> oldList) {
        List<Object> newList = new ArrayList<Object>(oldList.size());

        for (int i = 0; i < oldList.size(); i++) {
            Object curObj = oldList.get(i);

            newList.add(translateOutput(curObj));
        }

        return newList;
    }

    public static Object translateOutput(Object obj) {
        if (obj instanceof BaseModel<?>) {
            return translateOutput((BaseModel<?>) obj);
        } else if (obj instanceof List<?>) {
            return translateOutput((List<Object>) obj);
        } else {
            return obj;
        }
    }

    public static Throwable translateThrowable(Throwable throwable) {
        if (_useReflectionToTranslateThrowable) {
            try {
                UnsyncByteArrayOutputStream unsyncByteArrayOutputStream = new UnsyncByteArrayOutputStream();
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(unsyncByteArrayOutputStream);

                objectOutputStream.writeObject(throwable);

                objectOutputStream.flush();
                objectOutputStream.close();

                UnsyncByteArrayInputStream unsyncByteArrayInputStream = new UnsyncByteArrayInputStream(unsyncByteArrayOutputStream.unsafeGetByteArray(),
                        0, unsyncByteArrayOutputStream.size());

                Thread currentThread = Thread.currentThread();

                ClassLoader contextClassLoader = currentThread.getContextClassLoader();

                ObjectInputStream objectInputStream = new ClassLoaderObjectInputStream(unsyncByteArrayInputStream,
                        contextClassLoader);

                throwable = (Throwable) objectInputStream.readObject();

                objectInputStream.close();

                return throwable;
            } catch (SecurityException se) {
                if (_log.isInfoEnabled()) {
                    _log.info("Do not use reflection to translate throwable");
                }

                _useReflectionToTranslateThrowable = false;
            } catch (Throwable throwable2) {
                _log.error(throwable2, throwable2);

                return throwable2;
            }
        }

        Class<?> clazz = throwable.getClass();

        String className = clazz.getName();

        if (className.equals(PortalException.class.getName())) {
            return new PortalException();
        }

        if (className.equals(SystemException.class.getName())) {
            return new SystemException();
        }

        if (className.equals(
                    "com.excilys.liferay.gatling.NoSuchFormParamException")) {
            return new com.excilys.liferay.gatling.NoSuchFormParamException();
        }

        if (className.equals(
                    "com.excilys.liferay.gatling.NoSuchLinkProcessRecordException")) {
            return new com.excilys.liferay.gatling.NoSuchLinkProcessRecordException();
        }

        if (className.equals(
                    "com.excilys.liferay.gatling.NoSuchLinkUsecaseRequestException")) {
            return new com.excilys.liferay.gatling.NoSuchLinkUsecaseRequestException();
        }

        if (className.equals(
                    "com.excilys.liferay.gatling.NoSuchProcessException")) {
            return new com.excilys.liferay.gatling.NoSuchProcessException();
        }

        if (className.equals(
                    "com.excilys.liferay.gatling.NoSuchRecordException")) {
            return new com.excilys.liferay.gatling.NoSuchRecordException();
        }

        if (className.equals(
                    "com.excilys.liferay.gatling.NoSuchRequestException")) {
            return new com.excilys.liferay.gatling.NoSuchRequestException();
        }

        if (className.equals(
                    "com.excilys.liferay.gatling.NoSuchScenarioException")) {
            return new com.excilys.liferay.gatling.NoSuchScenarioException();
        }

        if (className.equals(
                    "com.excilys.liferay.gatling.NoSuchSimulationException")) {
            return new com.excilys.liferay.gatling.NoSuchSimulationException();
        }

        if (className.equals(
                    "com.excilys.liferay.gatling.NoSuchUrlRecordException")) {
            return new com.excilys.liferay.gatling.NoSuchUrlRecordException();
        }

        return throwable;
    }

    public static Object translateOutputFormParam(BaseModel<?> oldModel) {
        FormParamClp newModel = new FormParamClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setFormParamRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputLinkProcessRecord(BaseModel<?> oldModel) {
        LinkProcessRecordClp newModel = new LinkProcessRecordClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setLinkProcessRecordRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputLinkUsecaseRequest(
        BaseModel<?> oldModel) {
        LinkUsecaseRequestClp newModel = new LinkUsecaseRequestClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setLinkUsecaseRequestRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputProcess(BaseModel<?> oldModel) {
        ProcessClp newModel = new ProcessClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setProcessRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputRecord(BaseModel<?> oldModel) {
        RecordClp newModel = new RecordClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setRecordRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputRequest(BaseModel<?> oldModel) {
        RequestClp newModel = new RequestClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setRequestRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputScenario(BaseModel<?> oldModel) {
        ScenarioClp newModel = new ScenarioClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setScenarioRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputSimulation(BaseModel<?> oldModel) {
        SimulationClp newModel = new SimulationClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setSimulationRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputUrlRecord(BaseModel<?> oldModel) {
        UrlRecordClp newModel = new UrlRecordClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setUrlRecordRemoteModel(oldModel);

        return newModel;
    }
}
