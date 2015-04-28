/**
 * Copyright 2015 eBusiness Information, Groupe Excilys (www.ebusinessinformation.fr)
 */
package com.excilys.liferay.gatling.mustache.util;

public class MessageBoard {
	
	private String url = null;
	private String nameVariable = null;
	
	public MessageBoard(String url, String nameVariable) {
		this.url = url;
		this.nameVariable = nameVariable;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getNameVariable() {
		return nameVariable;
	}

	public void setNameVariable(String nameVariable) {
		this.nameVariable = nameVariable;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nameVariable == null) ? 0 : nameVariable.hashCode());
		result = prime * result + ((url == null) ? 0 : url.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MessageBoard other = (MessageBoard) obj;
		if (nameVariable == null) {
			if (other.nameVariable != null)
				return false;
		} else if (!nameVariable.equals(other.nameVariable))
			return false;
		if (url == null) {
			if (other.url != null)
				return false;
		} else if (!url.equals(other.url))
			return false;
		return true;
	}
	
	
	
}
