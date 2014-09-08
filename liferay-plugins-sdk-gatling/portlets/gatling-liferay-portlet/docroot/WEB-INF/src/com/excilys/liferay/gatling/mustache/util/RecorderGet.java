package com.excilys.liferay.gatling.mustache.util;

import java.util.ArrayList;
import java.util.List;

public class RecorderGet {
	private String name;
	private List<NameAndUrl> listGet = new ArrayList<NameAndUrl>();
	
	public RecorderGet(String nameVariable, List<NameAndUrl> listGet) {
		this.name = nameVariable;
		System.out.println(listGet.size());
		this.listGet = listGet;
	}

	public List<NameAndUrl> getListGet() {
		return listGet;
	}

	public void setListGet(List<NameAndUrl> listGet) {
		this.listGet = listGet;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
