/**
 * Copyright 2011-2014 eBusiness Information, Groupe Excilys (www.ebusinessinformation.fr)
 */
package com.excilys.liferay.gatling.util;

/**
 * Id of a {@link DisplayItem}
 * Used to compare DisplayLayouts
 *
 */
public class IdDisplayItem {
	private boolean privatePage;
	private long layoutId;
	
	public IdDisplayItem(boolean privatePage, long layoutId) {
		this.privatePage = privatePage;
		this.layoutId = layoutId;
	}
	
	@Override
	public String toString() {
		int p = privatePage ? 1 : 0;
		StringBuilder sb = new StringBuilder();
		sb.append(this.getClass().getSimpleName()).append("_").append(p).append("_").append(layoutId);
		return sb.toString();
	}

	/*
	 * Getters/Setters, Hash And Equals
	 */
	public boolean isPrivatePage() {
		return privatePage;
	}
	public void setPrivatePage(boolean privatePage) {
		this.privatePage = privatePage;
	}
	public long getLayoutId() {
		return layoutId;
	}
	public void setLayoutId(long layoutId) {
		this.layoutId = layoutId;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (layoutId ^ (layoutId >>> 32));
		result = prime * result + (privatePage ? 1231 : 1237);
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
		IdDisplayItem other = (IdDisplayItem) obj;
		if (layoutId != other.layoutId)
			return false;
		if (privatePage != other.privatePage)
			return false;
		return true;
	}
}