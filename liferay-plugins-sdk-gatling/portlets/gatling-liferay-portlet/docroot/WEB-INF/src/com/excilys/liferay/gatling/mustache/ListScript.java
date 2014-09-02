package com.excilys.liferay.gatling.mustache;

import com.excilys.liferay.gatling.model.Record;
import com.excilys.liferay.gatling.service.RecordLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;

import java.util.ArrayList;
import java.util.List;

public class ListScript {

	public static String getList() {
		
		return "sansParam";
	}

	public static List<Record> getList(String idPortlet) throws SystemException {

		// get list of sample and records
		List<Record> recordList = new ArrayList<Record>();
		List<Record> recordListPortletType = RecordLocalServiceUtil.findByPortletAndRequest(idPortlet.split("_INSTANCE_")[0]) ;
		List<Record> recordListInstance = RecordLocalServiceUtil.findByPortletAndRequest(idPortlet) ;
		recordList.addAll(recordListInstance);
		recordList.addAll(recordListPortletType);
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


