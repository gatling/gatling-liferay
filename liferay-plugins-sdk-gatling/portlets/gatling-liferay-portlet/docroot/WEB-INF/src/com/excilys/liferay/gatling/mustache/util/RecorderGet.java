package com.excilys.liferay.gatling.mustache.util;

import java.util.ArrayList;
import java.util.List;

public class RecorderGet {
	private String name;
	private List<NameUrlType> listGet = new ArrayList<NameUrlType>();
	
	public RecorderGet(String nameVariable, List<NameUrlType> listGet) {
		this.name = nameVariable;
		this.listGet = listGet;
	}

	public List<NameUrlType> getListGet() {
		return listGet;
	}

	public void setListGet(List<NameUrlType> listGet) {
		this.listGet = listGet;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
