package io.gatling.liferay.model.AST.resource.data;

public class SiteMapDataAST {
	
	private String friendlyURL;
	private String url;
	private int weight;
	
	public SiteMapDataAST(String friendlyUrl, String url, int weight) {
		this.friendlyURL = friendlyUrl;
		this.url = url;
		this.weight = weight;
	}

	public String getFriendlyUrl() {
		return friendlyURL;
	}

	public String getUrl() {
		return url;
	}

	public int getWeight() {
		return weight;
	}

	@Override
	public String toString() {
		return "SiteMapDataAST friendlyUrl=" + friendlyURL + ", url=" + url + ", weight="
				+ weight + "]";
	}

	@Override
	public int hashCode() {
		return url.hashCode() + friendlyURL.hashCode() * 31;
	}
	
}
