/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.excilys.liferay.gatling.service;

import com.excilys.liferay.gatling.model.LinkUsecaseRequestClp;
import com.excilys.liferay.gatling.model.RecordPortletClp;
import com.excilys.liferay.gatling.model.RequestClp;
import com.excilys.liferay.gatling.model.ScenarioClp;
import com.excilys.liferay.gatling.model.SimulationClp;
import com.excilys.liferay.gatling.model.UrlUsecaseClp;
import com.excilys.liferay.gatling.model.UsecaseClp;

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

/**
 * @author Brian Wing Shun Chan
 */
public class ClpSerializer {
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

				String portletPropsServletContextName = (String)getMethod.invoke(null,
						"gatling-liferay-portlet-deployment-context");

				if (Validator.isNotNull(portletPropsServletContextName)) {
					_servletContextName = portletPropsServletContextName;
				}
			}
			catch (Throwable t) {
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
				}
				catch (Throwable t) {
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

		if (oldModelClassName.equals(LinkUsecaseRequestClp.class.getName())) {
			return translateInputLinkUsecaseRequest(oldModel);
		}

		if (oldModelClassName.equals(RecordPortletClp.class.getName())) {
			return translateInputRecordPortlet(oldModel);
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

		if (oldModelClassName.equals(UrlUsecaseClp.class.getName())) {
			return translateInputUrlUsecase(oldModel);
		}

		if (oldModelClassName.equals(UsecaseClp.class.getName())) {
			return translateInputUsecase(oldModel);
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

	public static Object translateInputLinkUsecaseRequest(BaseModel<?> oldModel) {
		LinkUsecaseRequestClp oldClpModel = (LinkUsecaseRequestClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getLinkUsecaseRequestRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputRecordPortlet(BaseModel<?> oldModel) {
		RecordPortletClp oldClpModel = (RecordPortletClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getRecordPortletRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputRequest(BaseModel<?> oldModel) {
		RequestClp oldClpModel = (RequestClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getRequestRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputScenario(BaseModel<?> oldModel) {
		ScenarioClp oldClpModel = (ScenarioClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getScenarioRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputSimulation(BaseModel<?> oldModel) {
		SimulationClp oldClpModel = (SimulationClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getSimulationRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputUrlUsecase(BaseModel<?> oldModel) {
		UrlUsecaseClp oldClpModel = (UrlUsecaseClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getUrlUsecaseRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputUsecase(BaseModel<?> oldModel) {
		UsecaseClp oldClpModel = (UsecaseClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getUsecaseRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateInput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateInput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Object translateOutput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(
					"com.excilys.liferay.gatling.model.impl.LinkUsecaseRequestImpl")) {
			return translateOutputLinkUsecaseRequest(oldModel);
		}

		if (oldModelClassName.equals(
					"com.excilys.liferay.gatling.model.impl.RecordPortletImpl")) {
			return translateOutputRecordPortlet(oldModel);
		}

		if (oldModelClassName.equals(
					"com.excilys.liferay.gatling.model.impl.RequestImpl")) {
			return translateOutputRequest(oldModel);
		}

		if (oldModelClassName.equals(
					"com.excilys.liferay.gatling.model.impl.ScenarioImpl")) {
			return translateOutputScenario(oldModel);
		}

		if (oldModelClassName.equals(
					"com.excilys.liferay.gatling.model.impl.SimulationImpl")) {
			return translateOutputSimulation(oldModel);
		}

		if (oldModelClassName.equals(
					"com.excilys.liferay.gatling.model.impl.UrlUsecaseImpl")) {
			return translateOutputUrlUsecase(oldModel);
		}

		if (oldModelClassName.equals(
					"com.excilys.liferay.gatling.model.impl.UsecaseImpl")) {
			return translateOutputUsecase(oldModel);
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
			return translateOutput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateOutput((List<Object>)obj);
		}
		else {
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

				throwable = (Throwable)objectInputStream.readObject();

				objectInputStream.close();

				return throwable;
			}
			catch (SecurityException se) {
				if (_log.isInfoEnabled()) {
					_log.info("Do not use reflection to translate throwable");
				}

				_useReflectionToTranslateThrowable = false;
			}
			catch (Throwable throwable2) {
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
					"com.excilys.liferay.gatling.NoSuchLinkUsecaseRequestException")) {
			return new com.excilys.liferay.gatling.NoSuchLinkUsecaseRequestException();
		}

		if (className.equals(
					"com.excilys.liferay.gatling.NoSuchRecordPortletException")) {
			return new com.excilys.liferay.gatling.NoSuchRecordPortletException();
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
					"com.excilys.liferay.gatling.NoSuchUrlUsecaseException")) {
			return new com.excilys.liferay.gatling.NoSuchUrlUsecaseException();
		}

		if (className.equals(
					"com.excilys.liferay.gatling.NoSuchUsecaseException")) {
			return new com.excilys.liferay.gatling.NoSuchUsecaseException();
		}

		return throwable;
	}

	public static Object translateOutputLinkUsecaseRequest(
		BaseModel<?> oldModel) {
		LinkUsecaseRequestClp newModel = new LinkUsecaseRequestClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setLinkUsecaseRequestRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputRecordPortlet(BaseModel<?> oldModel) {
		RecordPortletClp newModel = new RecordPortletClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setRecordPortletRemoteModel(oldModel);

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

	public static Object translateOutputUrlUsecase(BaseModel<?> oldModel) {
		UrlUsecaseClp newModel = new UrlUsecaseClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setUrlUsecaseRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputUsecase(BaseModel<?> oldModel) {
		UsecaseClp newModel = new UsecaseClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setUsecaseRemoteModel(oldModel);

		return newModel;
	}

	private static Log _log = LogFactoryUtil.getLog(ClpSerializer.class);
	private static String _servletContextName;
	private static boolean _useReflectionToTranslateThrowable = true;
}