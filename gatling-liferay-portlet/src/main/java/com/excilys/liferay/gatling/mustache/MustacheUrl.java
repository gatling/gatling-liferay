/**
 * Copyright 2015 Altendis, Groupe Excilys (www.altendis.fr)
 */
package com.excilys.liferay.gatling.mustache;

public class MustacheUrl {
	final private String nameN, url, typeRequest, namespace;
	private long plid;
	private boolean form, version, pauth;
	
	public MustacheUrl(String name,String url,String typeRequest, String namespace, long plid) {
		this.nameN = name;
		this.url = url;
		this.typeRequest = typeRequest;
		this.namespace = "_"+namespace+"_";
		this.plid = plid;
	}
	
	public long getPlid() {
		return plid;
	}

	public void setPlid(long plid) {
		this.plid = plid;
	}

	public String getNameN() {
		return nameN;
	}

	public String getUrl() {
		return url;
	}

	public String getTypeRequest() {
		return typeRequest;
	}

	public boolean isForm() {
		return form;
	}

	public void setForm(boolean form) {
		this.form = form;
	}

	public String getNamespace() {
		return namespace;
	}

	public boolean isVersion() {
		return version;
	}

	public void setVersion(boolean version) {
		this.version = version;
	}

	public boolean isPauth() {
		return pauth;
	}

	public void setPauth(boolean pauth) {
		this.pauth = pauth;
	}
	
}