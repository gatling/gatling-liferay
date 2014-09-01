package com.excilys.liferay.gatling.mustache;

public class ListScript {

	public static String getList() {
		
		return "sansParam";
	}

	public static String[][] getList(String idPortlet) {

		if("54".equals(idPortlet)) {
			return new String[][] {{"Simple (only GETs)", "1"}, {"Simple (only POSTs)", "2"}, {"Simple (POSTs and GETs)", "3"}};
		} else if("56".equals(idPortlet)) {
			return new String[][] {{"Simple (only GETs)", "1"}, {"Simple (only POSTs)", "2"}, {"Simple (POSTs and GETs)", "3"}};
		} 
		return new String[][] {{}};
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


