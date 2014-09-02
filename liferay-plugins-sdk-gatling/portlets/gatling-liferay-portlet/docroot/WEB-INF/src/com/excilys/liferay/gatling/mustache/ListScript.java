package com.excilys.liferay.gatling.mustache;

import com.excilys.liferay.gatling.model.Record;
import com.excilys.liferay.gatling.service.RecordLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;

import java.util.List;

public class ListScript {

	public static String getList() {
		
		return "sansParam";
	}

	public static List<Record> getList(String idPortlet) throws SystemException {

		// get list of sample and records
		List<Record> recordList = RecordLocalServiceUtil.findByPortletAndRequest(idPortlet.split("_")[0]) ;
		return recordList;
	}
	
	public class Details {
		String label = "";
		String value = "";
		
		Details(String lab, String val) {
			label = lab;
			value = val;
		}
		public String getLabel() {
			return label;
		}
		public void setLabel(String label) {
			this.label = label;
		}
		public String getValue() {
			return value;
		}
		public void setValue(String value) {
			this.value = value;
		}
		
	}

}


