package com.excilys.liferay.gatling.util;

import com.excilys.liferay.gatling.model.Request;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.model.Layout;

public class DisplayLayout {
	
	private static final String INDENT = "&emsp;&emsp;"; //tab
	
	public enum RequestState {
		OLD_REQUEST, DEFAULT, NEW_REQUEST;
	}
	// displayLayoutId
	private IdDisplayLayout displayLayoutId;

	// field for comparaison
	private RequestState state;

	// field for space
	private int numberOfSpace;
	
	// field of Request table
	private boolean checked;
	private long requestId;
	private long scenarioId;
	private String name;
	private String url;
	private double weight;
	private long parentLayoutId;
	private boolean privateLayout;
	
	// Common initialization
	{
		state = RequestState.DEFAULT;
		numberOfSpace=0;
	}
	
	/**
	 * create DisplayLayout from a liferay Layout
	 * @param layout
	 */
	public DisplayLayout(Layout layout) {
		
		displayLayoutId = new IdDisplayLayout(layout.isPrivateLayout(), layout.getLayoutId());
		parentLayoutId = layout.getParentLayoutId();
		name = layout.getName(LocaleUtil.getDefault());
		url = layout.getFriendlyURL();
		weight=0.0;
		setPrivateLayout(layout.isPrivateLayout());
	}
	
	/**
	 * create DisplayLayout from a scenario request
	 * @param request
	 */
	public DisplayLayout(Request request){
		displayLayoutId = new IdDisplayLayout(request.isPrivatePage(), request.getLayoutId());
		requestId = request.getRequest_id();
		parentLayoutId = request.getParentLayoutId();
		name = request.getName();
		url = request.getUrl();
		weight = request.getWeight();
		setPrivateLayout(request.isPrivatePage());
	}
	
	public boolean isUsed() {
		return (weight > 0);
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((displayLayoutId == null) ? 0 : displayLayoutId.hashCode());
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
		DisplayLayout other = (DisplayLayout) obj;
		if (displayLayoutId == null) {
			if (other.displayLayoutId != null)
				return false;
		} else if (!displayLayoutId.equals(other.displayLayoutId))
			return false;
		if (url == null) {
			if (other.url != null)
				return false;
		} else if (!url.equals(other.url))
			return false;
		return true;
	}

	/**
	 * 
	 * @return the name of page with adequat indent if hierarchy
	 */
	public String showName() {
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i< numberOfSpace; i++) {
			sb.append(INDENT);
		}
		sb.append(" ").append(name);
		return sb.toString();
	}

	/*
	 * Getters and Setters
	 */
	
	public IdDisplayLayout getDisplayLayoutId() {
		return displayLayoutId;
	}

	public void setDisplayLayoutId(IdDisplayLayout displayLayoutId) {
		this.displayLayoutId = displayLayoutId;
	}
	
	public RequestState getState() {
		return state;
	}
	public void setState(RequestState state) {
		this.state = state;
	}
	public boolean isChecked() {
		return checked;
	}
	public void setChecked(boolean checked) {
		this.checked = checked;
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
	public int getNumberOfSpace() {
		return numberOfSpace;
	}
	public void setNumberOfSpace(int numberOfSpace) {
		this.numberOfSpace = numberOfSpace;
	}

	public long getParentLayoutId() {
		return parentLayoutId;
	}

	public void setParentLayoutId(long parentLayoutId) {
		this.parentLayoutId = parentLayoutId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isPrivateLayout() {
		return privateLayout;
	}

	public void setPrivateLayout(boolean privateLayout) {
		this.privateLayout = privateLayout;
	}
}
	
