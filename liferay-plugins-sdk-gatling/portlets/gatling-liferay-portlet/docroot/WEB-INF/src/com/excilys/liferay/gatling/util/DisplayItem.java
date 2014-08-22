/**
 * Copyright 2011-2014 eBusiness Information, Groupe Excilys (www.ebusinessinformation.fr)
 */
package com.excilys.liferay.gatling.util;

import java.util.ArrayList;
import java.util.List;
import com.excilys.liferay.gatling.model.Request;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.model.Layout;
import com.liferay.portal.model.PortletPreferences;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.service.PortletLocalServiceUtil;

/**
 * DisplayLayout is used in editScenario.jsp to display both layout and request
 * 
 * use of {@link IdDisplayItem} as field for identity
 *
 */
public class DisplayItem {
	
	private static final Log LOG = LogFactoryUtil.getLog(DisplayItem.class.getName());
	
	public enum RequestState {
		OLD_REQUEST, DEFAULT, NEW_REQUEST;
	}
	
	
	// field for comparison
	private RequestState state;

	// field for depth
	private int depth;
	
	// field of Request table
	// plId
	private long plId;
	private long requestId;
	private long scenarioId;
	private String name;
	private String url;
	private double weight;
	private long parentPlId;
	private boolean privateItem;
	private long layoutId;
	private boolean portlet;
	
	// List of it direct subnodes id
	private List<Long> subNodes;
	// List of page portlet id
	private List<Long> pagePortlet;
	// Common initialization
	{
		portlet = false;
		state = RequestState.DEFAULT;
		subNodes = new ArrayList<Long>();
		setPagePortlet(new ArrayList<Long>());
	}
	
	/**
	 * create DisplayLayout from a liferay Layout
	 * @param layout
	 */
	public DisplayItem(PortletPreferences portletPreferences) {
		parentPlId = portletPreferences.getPlid();
		plId = portletPreferences.getPortletPreferencesId();
		name = PortletLocalServiceUtil.getPortletById(portletPreferences.getPortletId()).getDisplayName();
		portlet = true;
		try {
			Layout parent = LayoutLocalServiceUtil.getLayout(portletPreferences.getPlid());
			url = parent.getFriendlyURL() /* + url portlet*/;
		} catch (PortalException | SystemException e) {
			new RuntimeException("fuck you DB! give me my portlet url");
		}
	}
	
	/**
	 * create DisplayLayout from a liferay Layout
	 * @param layout
	 */
	public DisplayItem(Layout layout) {
		
		plId = layout.getPlid();
		privateItem = layout.isPrivateLayout();
		try {
			parentPlId = layout.getParentPlid();
		} catch (PortalException | SystemException e) {
			LOG.info(e.getMessage());
		}
		name = layout.getName(LocaleUtil.getDefault());
		url = layout.getFriendlyURL();
	}
	
	/**
	 * create DisplayLayout from a scenario request
	 * @param request
	 */
	public DisplayItem(Request request){
		plId = request.getPlId();
		privateItem = request.isPrivatePage();
		requestId = request.getRequest_id();
		parentPlId = request.getParentPlId();
		name = request.getName();
		url = request.getUrl();
		weight = request.getWeight();
	}

	public boolean isUsed() {
		return (weight > 0);
	}

	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (plId ^ (plId >>> 32));
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
		DisplayItem other = (DisplayItem) obj;
		if (plId != other.plId)
			return false;
		return true;
	}

	/*
	 * Getters/Setters
	 */
	public RequestState getState() {
		return state;
	}

	public void setState(RequestState state) {
		this.state = state;
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	public long getPlId() {
		return plId;
	}

	public void setPlId(long plId) {
		this.plId = plId;
	}

	public long getRequestId() {
		return requestId;
	}

	public void setRequestId(long requestId) {
		this.requestId = requestId;
	}

	public long getScenarioId() {
		return scenarioId;
	}

	public void setScenarioId(long scenarioId) {
		this.scenarioId = scenarioId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public long getParentPlId() {
		return parentPlId;
	}

	public void setParentPlId(long parentPlId) {
		this.parentPlId = parentPlId;
	}

	public boolean isPrivateItem() {
		return privateItem;
	}

	public void setPrivateItem(boolean privateItem) {
		this.privateItem = privateItem;
	}

	public boolean isPortlet() {
		return portlet;
	}

	public void setPortlet(boolean portlet) {
		this.portlet = portlet;
	}

	public List<Long> getSubNodes() {
		return subNodes;
	}

	public void setSubNodes(List<Long> subNodes) {
		this.subNodes = subNodes;
	}

	public long getLayoutId() {
		return layoutId;
	}

	public void setLayoutId(long layoutId) {
		this.layoutId = layoutId;
	}

	public List<Long> getPagePortlet() {
		return pagePortlet;
	}

	public void setPagePortlet(List<Long> pagePortlet) {
		this.pagePortlet = pagePortlet;
	}
}
