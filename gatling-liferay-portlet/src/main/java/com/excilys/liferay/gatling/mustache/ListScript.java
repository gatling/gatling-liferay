/**
 * Copyright 2015 eBusiness Information, Groupe Excilys (www.ebusinessinformation.fr)
 */
package com.excilys.liferay.gatling.mustache;

import java.util.List;

import com.excilys.liferay.gatling.model.Record;
import com.excilys.liferay.gatling.service.RecordLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;

public class ListScript {

	public static String[][] getList(String portletId) throws SystemException {
		
		int numberOfRecords = RecordLocalServiceUtil.countByPortletId(portletId);
		String[][] availableScripts = null;
		
		if("19".equals(portletId.split("_")[0])) {
			numberOfRecords += 3;
			availableScripts = new String[numberOfRecords][];
			availableScripts[0] = new String[]{"Sample (only GETs)", "1", "true"};
			availableScripts[1] = new String[]{"Sample (POSTs & GETs)", "2", "true"};
			availableScripts[2] = new String[]{"Sample (Complex one)", "3", "true"};

			List<Record> listRecords = RecordLocalServiceUtil.findByPortletId(portletId);
			for (int i = 3; i < numberOfRecords; i++) {
				availableScripts[i] = new String[]{listRecords.get(i-3).getName(), Long.toString(listRecords.get(i-3).getRecordId()), "false"};
			}
			return availableScripts;
		} else if("54".equals(portletId.split("_")[0])) {
			numberOfRecords += 3;
			availableScripts = new String[numberOfRecords][];
			availableScripts[0] = new String[]{"Sample (only GETs)", "1", "true"};
			availableScripts[1] = new String[]{"Sample (POSTs & GETs)", "2", "true"};
			availableScripts[2] = new String[]{"Sample (Complex one)", "3", "true"};
			List<Record> listRecords = RecordLocalServiceUtil.findByPortletId(portletId);
			for (int i = 3; i < numberOfRecords; i++) {
				availableScripts[i] = new String[]{listRecords.get(i-3).getName(), Long.toString(listRecords.get(i-3).getRecordId()), "false"};
			}
			return availableScripts;
		} else if("101".equals(portletId.split("_")[0])) {
			numberOfRecords += 3;
			availableScripts = new String[numberOfRecords][];
			availableScripts[0] = new String[]{"Sample (only GETs)", "1", "true"};
			availableScripts[1] = new String[]{"Sample (POSTs & GETs)", "2", "true"};
			availableScripts[2] = new String[]{"Sample (Complex one)", "3", "true"};
			List<Record> listRecords = RecordLocalServiceUtil.findByPortletId(portletId);
			for (int i = 3; i < numberOfRecords; i++) {
				availableScripts[i] = new String[]{listRecords.get(i-3).getName(), Long.toString(listRecords.get(i-3).getRecordId()), "false"};
			}
			return availableScripts;
		} else {			
			availableScripts = new String[numberOfRecords][];
			List<Record> listRecords = RecordLocalServiceUtil.findByPortletId(portletId);
			for (int i = 0; i < numberOfRecords; i++) {
				availableScripts[i] = new String[]{listRecords.get(i).getName(), Long.toString(listRecords.get(i).getRecordId()), "false"};
			}
			return availableScripts;

		}
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


