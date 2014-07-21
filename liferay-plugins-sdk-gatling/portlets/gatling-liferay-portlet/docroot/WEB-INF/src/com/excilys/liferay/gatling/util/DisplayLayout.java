package com.excilys.liferay.gatling.util;

import com.liferay.portal.model.Layout;
import com.liferay.sample.model.Request;

public class DisplayLayout {
	
	private static final String INDENT = "&#8213;"; //big hyphen
	
	public enum RequestState {
		OLD_REQUEST, DEFAULT, NEW_REQUEST;
	}
	// field for comparaison
	private RequestState state;

	// field for space
	private int numberOfSpace;
	
	// field of Request table
	private boolean checked;
	private boolean privatePage;
	private long requestId;
	private long scenarioId;
	private String name;
	private String url;
	private double weight;
	private long layoutId;
	private long parentLayoutId;
	
	// Common initialization
	{
		state = RequestState.DEFAULT;
		numberOfSpace=0;
	}
	
	public DisplayLayout(Layout layout) {
		
		layoutId = layout.getLayoutId();
		parentLayoutId = layout.getParentLayoutId();
		name = layout.getName();
		checked=false;
		privatePage=layout.isPrivateLayout();
		url = layout.getFriendlyURL();
		weight=0.0;
	}
	
	public DisplayLayout(Request request){
		layoutId = request.getLayoutId();
		requestId = request.getRequest_id();
		parentLayoutId = request.getParentLayoutId();
		checked=request.isChecked();
		privatePage=request.isPrivatePage();
		name = request.getName();
		url = request.getUrl();
		weight = request.getWeight();
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (layoutId ^ (layoutId >>> 32));
		result = prime * result + (privatePage ? 1231 : 1237);
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
		if (privatePage != other.privatePage)
			return false;
		if (url == null) {
			if (other.url != null)
				return false;
		} else if (!url.equals(other.url))
			return false;
		return true;
	}
	
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
	public boolean isPrivatePage() {
		return privatePage;
	}
	public void setPrivatePage(boolean privatePage) {
		this.privatePage = privatePage;
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

	public long getLayoutId() {
		return layoutId;
	}

	public void setLayoutId(long layoutId) {
		this.layoutId = layoutId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
	
