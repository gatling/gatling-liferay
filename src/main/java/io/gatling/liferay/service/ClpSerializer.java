/**
 * Copyright 2011-2016 GatlingCorp (http://gatling.io)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * 		http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.gatling.liferay.service;

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

import io.gatling.liferay.model.FormParamClp;
import io.gatling.liferay.model.LoginClp;
import io.gatling.liferay.model.ProcessClp;
import io.gatling.liferay.model.ProcessScenarioLinkClp;
import io.gatling.liferay.model.RecordClp;
import io.gatling.liferay.model.ScenarioClp;
import io.gatling.liferay.model.SimulationClp;
import io.gatling.liferay.model.SiteMapClp;
import io.gatling.liferay.model.UrlRecordClp;
import io.gatling.liferay.model.UrlSiteMapClp;

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

        if (oldModelClassName.equals(LoginClp.class.getName())) {
            return translateInputLogin(oldModel);
        }

        if (oldModelClassName.equals(ProcessClp.class.getName())) {
            return translateInputProcess(oldModel);
        }

        if (oldModelClassName.equals(ProcessScenarioLinkClp.class.getName())) {
            return translateInputProcessScenarioLink(oldModel);
        }

        if (oldModelClassName.equals(RecordClp.class.getName())) {
            return translateInputRecord(oldModel);
        }

        if (oldModelClassName.equals(ScenarioClp.class.getName())) {
            return translateInputScenario(oldModel);
        }

        if (oldModelClassName.equals(SimulationClp.class.getName())) {
            return translateInputSimulation(oldModel);
        }

        if (oldModelClassName.equals(SiteMapClp.class.getName())) {
            return translateInputSiteMap(oldModel);
        }

        if (oldModelClassName.equals(UrlRecordClp.class.getName())) {
            return translateInputUrlRecord(oldModel);
        }

        if (oldModelClassName.equals(UrlSiteMapClp.class.getName())) {
            return translateInputUrlSiteMap(oldModel);
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

    public static Object translateInputLogin(BaseModel<?> oldModel) {
        LoginClp oldClpModel = (LoginClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getLoginRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputProcess(BaseModel<?> oldModel) {
        ProcessClp oldClpModel = (ProcessClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getProcessRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputProcessScenarioLink(
        BaseModel<?> oldModel) {
        ProcessScenarioLinkClp oldClpModel = (ProcessScenarioLinkClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getProcessScenarioLinkRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputRecord(BaseModel<?> oldModel) {
        RecordClp oldClpModel = (RecordClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getRecordRemoteModel();

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

    public static Object translateInputSiteMap(BaseModel<?> oldModel) {
        SiteMapClp oldClpModel = (SiteMapClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getSiteMapRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputUrlRecord(BaseModel<?> oldModel) {
        UrlRecordClp oldClpModel = (UrlRecordClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getUrlRecordRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputUrlSiteMap(BaseModel<?> oldModel) {
        UrlSiteMapClp oldClpModel = (UrlSiteMapClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getUrlSiteMapRemoteModel();

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
                    "io.gatling.liferay.model.impl.FormParamImpl")) {
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

        if (oldModelClassName.equals("io.gatling.liferay.model.impl.LoginImpl")) {
            return translateOutputLogin(oldModel);
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
                    "io.gatling.liferay.model.impl.ProcessImpl")) {
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
                    "io.gatling.liferay.model.impl.ProcessScenarioLinkImpl")) {
            return translateOutputProcessScenarioLink(oldModel);
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

        if (oldModelClassName.equals("io.gatling.liferay.model.impl.RecordImpl")) {
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
                    "io.gatling.liferay.model.impl.ScenarioImpl")) {
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
                    "io.gatling.liferay.model.impl.SimulationImpl")) {
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
                    "io.gatling.liferay.model.impl.SiteMapImpl")) {
            return translateOutputSiteMap(oldModel);
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
                    "io.gatling.liferay.model.impl.UrlRecordImpl")) {
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

        if (oldModelClassName.equals(
                    "io.gatling.liferay.model.impl.UrlSiteMapImpl")) {
            return translateOutputUrlSiteMap(oldModel);
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

        if (className.equals("io.gatling.liferay.NoSuchFormParamException")) {
            return new io.gatling.liferay.NoSuchFormParamException();
        }

        if (className.equals("io.gatling.liferay.NoSuchLoginException")) {
            return new io.gatling.liferay.NoSuchLoginException();
        }

        if (className.equals("io.gatling.liferay.NoSuchProcessException")) {
            return new io.gatling.liferay.NoSuchProcessException();
        }

        if (className.equals(
                    "io.gatling.liferay.NoSuchProcessScenarioLinkException")) {
            return new io.gatling.liferay.NoSuchProcessScenarioLinkException();
        }

        if (className.equals("io.gatling.liferay.NoSuchRecordException")) {
            return new io.gatling.liferay.NoSuchRecordException();
        }

        if (className.equals("io.gatling.liferay.NoSuchScenarioException")) {
            return new io.gatling.liferay.NoSuchScenarioException();
        }

        if (className.equals("io.gatling.liferay.NoSuchSimulationException")) {
            return new io.gatling.liferay.NoSuchSimulationException();
        }

        if (className.equals("io.gatling.liferay.NoSuchSiteMapException")) {
            return new io.gatling.liferay.NoSuchSiteMapException();
        }

        if (className.equals("io.gatling.liferay.NoSuchUrlRecordException")) {
            return new io.gatling.liferay.NoSuchUrlRecordException();
        }

        if (className.equals("io.gatling.liferay.NoSuchUrlSiteMapException")) {
            return new io.gatling.liferay.NoSuchUrlSiteMapException();
        }

        return throwable;
    }

    public static Object translateOutputFormParam(BaseModel<?> oldModel) {
        FormParamClp newModel = new FormParamClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setFormParamRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputLogin(BaseModel<?> oldModel) {
        LoginClp newModel = new LoginClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setLoginRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputProcess(BaseModel<?> oldModel) {
        ProcessClp newModel = new ProcessClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setProcessRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputProcessScenarioLink(
        BaseModel<?> oldModel) {
        ProcessScenarioLinkClp newModel = new ProcessScenarioLinkClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setProcessScenarioLinkRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputRecord(BaseModel<?> oldModel) {
        RecordClp newModel = new RecordClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setRecordRemoteModel(oldModel);

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

    public static Object translateOutputSiteMap(BaseModel<?> oldModel) {
        SiteMapClp newModel = new SiteMapClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setSiteMapRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputUrlRecord(BaseModel<?> oldModel) {
        UrlRecordClp newModel = new UrlRecordClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setUrlRecordRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputUrlSiteMap(BaseModel<?> oldModel) {
        UrlSiteMapClp newModel = new UrlSiteMapClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setUrlSiteMapRemoteModel(oldModel);

        return newModel;
    }
}
