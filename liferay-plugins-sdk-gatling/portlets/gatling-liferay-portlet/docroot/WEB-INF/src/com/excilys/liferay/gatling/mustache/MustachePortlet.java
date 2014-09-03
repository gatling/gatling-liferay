package com.excilys.liferay.gatling.mustache;

import java.util.ArrayList;
import java.util.List;

import com.excilys.liferay.gatling.mustache.util.NameAndUrl;
import com.excilys.liferay.gatling.mustache.util.NameUrlAndPlid;

public class MustachePortlet {
	
	private String name, url;
	private double pourcentage;
	private boolean last;
	private List<NameAndUrl> assetPublisherSimple, messageBoardsimple;
	private List<NameUrlAndPlid> wikiDisplaySimple;

	public MustachePortlet(String name, String url, double pourcentage, boolean last) {
		this.name = name;
		this.url = url;
		this.pourcentage = pourcentage;
		this.last = last;
	}
	
	{
		assetPublisherSimple = new ArrayList<NameAndUrl>();
		messageBoardsimple = new ArrayList<NameAndUrl>();
		wikiDisplaySimple = new ArrayList<NameUrlAndPlid>();
	}
	
	/* --- Asset Publisher --- */

	public void addAssetPublisherSimple(NameAndUrl assetPublisherSimple) {
		this.assetPublisherSimple.add(assetPublisherSimple);
	}
	
	public List<NameAndUrl> getAssetPublisherSimple() {
		return assetPublisherSimple;
	}

	public void setAssetPublisherSimple(List<NameAndUrl> assetPublisherSimple) {
		this.assetPublisherSimple = assetPublisherSimple;
	}
	
	/* --- Message Board --- */

	public void addMessageBoardSimple(NameAndUrl messageBoardsimple) {
		this.messageBoardsimple.add(messageBoardsimple);
	}


	public List<NameAndUrl> getMessageBoardSimple() {
		return messageBoardsimple;
	}

	public void setMessageBoardSimple(List<NameAndUrl> messageBoardsimple) {
		this.messageBoardsimple = messageBoardsimple;
	}
	
	/* --- Wiki Display --- */

	public List<NameUrlAndPlid> getWikiDisplaySimple() {
		return wikiDisplaySimple;
	}

	public void addWikiDisplaySimple(NameUrlAndPlid wikiDisplaySimple) {
		this.wikiDisplaySimple.add(wikiDisplaySimple);
	}

	public void setWikiDisplaySimple(List<NameUrlAndPlid> wikiDisplaySimple) {
		this.wikiDisplaySimple = wikiDisplaySimple;
	}

	
	/* --- getter setter generic --- */
	

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

	public double getPourcentage() {
		return pourcentage;
	}

	public MustachePortlet setPourcentage(double pourcentage) {
		this.pourcentage = pourcentage;
		return this;
	}

	public boolean isLast() {
		return last;
	}

	public MustachePortlet setLast(boolean last) {
		this.last = last;
		return this;
	}	
	
}
