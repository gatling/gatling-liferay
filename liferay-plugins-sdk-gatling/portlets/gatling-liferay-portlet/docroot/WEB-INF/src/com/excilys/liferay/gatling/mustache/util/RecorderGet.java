package com.excilys.liferay.gatling.mustache.util;

import java.util.ArrayList;
import java.util.List;

import com.excilys.liferay.gatling.mustache.MustacheUrl;

public class RecorderGet {
	private String name;
	private List<MustacheUrl> listUrl = new ArrayList<MustacheUrl>();
	
	public RecorderGet(String nameVariable, List<MustacheUrl> listGet) {
		this.name = nameVariable;
		this.listUrl = listGet;
	}

	public List<MustacheUrl> getListGet() {
		return listUrl;
	}

	public void setListGet(List<MustacheUrl> listGet) {
		this.listUrl = listGet;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
