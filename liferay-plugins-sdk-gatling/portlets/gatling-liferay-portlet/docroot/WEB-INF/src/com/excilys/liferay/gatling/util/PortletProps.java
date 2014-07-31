package com.excilys.liferay.gatling.util;

import java.util.Properties;

/**
 *class used to add proprties file in resources
 *
 */
public class PortletProps {

	public static boolean containsKey(String key) {
		return com.liferay.util.portlet.PortletProps.contains(key);
	}

	public static String get(String key) {
		return com.liferay.util.portlet.PortletProps.get(key);
	}

	public static void set(String key, String value) {
		com.liferay.util.portlet.PortletProps.set(key, value);
	}

	public static String[] getArray(String key) {
		return com.liferay.util.portlet.PortletProps.getArray(key);
	}

	public static Properties getProperties() {
		return com.liferay.util.portlet.PortletProps.getProperties();
	}
}