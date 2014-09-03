package com.excilys.liferay.gatling.mustache.util;

import java.util.ArrayList;
import java.util.List;

public class RecoderGet {
	
	private List<NameAndUrl> listGet = new ArrayList<NameAndUrl>();
	
	public RecoderGet(String name, String url) {
		this.listGet.add(new NameAndUrl(name, url));
	}

	public RecoderGet(List<NameAndUrl> listGet) {
		this.listGet = listGet;
	}

	public List<NameAndUrl> getListGet() {
		return listGet;
	}

	public void setListGet(List<NameAndUrl> listGet) {
		this.listGet = listGet;
	}
}
