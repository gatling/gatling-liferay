package com.excilys.liferay.gatling.util;

import com.germinus.easyconf.ComponentProperties;

import java.util.Properties;

/**
 * <a href="PortletProps.java.html"><b><i>View Source</i></b></a>
 *
 * @author Scott Lee
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

//	public static ComponentProperties getComponentProperties() {
//		return com.liferay.util.portlet.PortletProps.getComponentProperties();
//	}

//	private static ExtPropertiesLoader _getInstance() {
//		return ExtPropertiesLoader.getInstance("mail-portlet");
//	}

}