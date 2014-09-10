package com.excilys.liferay.gatling.mustache;

import java.util.ArrayList;
import java.util.List;

import com.excilys.liferay.gatling.model.Record;
import com.excilys.liferay.gatling.model.UrlRecord;
import com.excilys.liferay.gatling.mustache.util.NameAndUrl;
import com.excilys.liferay.gatling.mustache.util.NameUrlAndPlid;
import com.excilys.liferay.gatling.mustache.util.NameUrlType;
import com.excilys.liferay.gatling.mustache.util.RecorderGet;
import com.excilys.liferay.gatling.service.UrlRecordLocalServiceUtil;

public class MustachePortlet {
	
	private String name, url;
	private double pourcentage;
	private boolean last;
	private List<MustacheScript> scripts;
	private List<NameAndUrl> assetPublisherSimple, messageBoardSimple;
	private List<NameUrlAndPlid> wikiDisplaySimple;
	private List<RecorderGet> recorderGet;

	public MustachePortlet(String name, String url, double pourcentage, boolean last) {
		this.name = name;
		this.url = url;
		this.pourcentage = pourcentage;
		this.last = last;
	}
	
	{
		scripts = new ArrayList<MustacheScript>();
		assetPublisherSimple = new ArrayList<NameAndUrl>();
		messageBoardSimple = new ArrayList<NameAndUrl>();
		recorderGet = new ArrayList<RecorderGet>();
		wikiDisplaySimple = new ArrayList<NameUrlAndPlid>();
	}
	
	/*--- Scripts ---*/
	
	public void addScript(MustacheScript script) {
		this.scripts.add(script);
	}
	
	public List<MustacheScript> getScripts() {
		return scripts;
	}

	public void setScripts(List<MustacheScript> scripts) {
		this.scripts = scripts;
	}
	
	/**
	 * remove the comma for the last one
	 * transform weight to percentage
	 */
	public void setLastScript() {
		double total = 0;
		double subTotal = 0;
		double inter = 0;
		for(MustacheScript mustacheScript: scripts){
			total += mustacheScript.getPourcentage();
		}
		for(MustacheScript mustacheScript: scripts){
			inter = (double) ((int) ((int)mustacheScript.getPourcentage()*10000/total))/100;
			subTotal += inter;
			mustacheScript.setPourcentage(inter);
		}
		scripts.get(scripts.size()-1).setPourcentage((double)((int)((inter+subTotal-100)*100))/100);
		
	}
	
	/* --- Asset Publisher --- */

	public void addAssetPublisherSimple(NameAndUrl assetPublisherSimple, double weight) {
		
		addScript(new MustacheScript(assetPublisherSimple.getName(), weight));
		this.assetPublisherSimple.add(assetPublisherSimple);
	}
	
	public List<NameAndUrl> getAssetPublisherSimple() {
		return assetPublisherSimple;
	}

	public void setAssetPublisherSimple(List<NameAndUrl> assetPublisherSimple) {
		this.assetPublisherSimple = assetPublisherSimple;
	}
	
	/* --- Message Board --- */

	public void addMessageBoardSimple(NameAndUrl messageBoardSimple, double weight) {
		addScript(new MustacheScript(messageBoardSimple.getName(), weight));
		this.messageBoardSimple.add(messageBoardSimple);
	}


	public List<NameAndUrl> getMessageBoardSimple() {
		return messageBoardSimple;
	}

	public void setMessageBoardSimple(List<NameAndUrl> messageBoardsimple) {
		this.messageBoardSimple = messageBoardsimple;
	}
	
	
	/* --- Wiki Display --- */

	public void addWikiDisplaySimple(NameUrlAndPlid wikiDisplaySimple, double weight) {
		addScript(new MustacheScript(wikiDisplaySimple.getName(), weight));
		this.wikiDisplaySimple.add(wikiDisplaySimple);
	}

	public List<NameUrlAndPlid> getWikiDisplaySimple() {
		return wikiDisplaySimple;
	}

	public void setWikiDisplaySimple(List<NameUrlAndPlid> wikiDisplaySimple) {
		this.wikiDisplaySimple = wikiDisplaySimple;
	}
	
	/* --- Recorder Url --- */

	public void addRecorderGet(RecorderGet recorderUrl) {
		this.recorderGet.add(recorderUrl);
	}

	public List<RecorderGet> getRecorderGet() {
		return recorderGet;
	}

	public void setRecorderGet(List<RecorderGet> recorderUrl) {
		this.recorderGet = recorderUrl;
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

	public void addRecorder(Record record, double weight, String beginningUrl) throws Exception{
		String nameVariable = "record_" + record.getName();
		addScript(new MustacheScript(nameVariable, weight));
		List<NameUrlType> listNameUrlType = new ArrayList<NameUrlType>();
		List<UrlRecord> listUrlRecord = UrlRecordLocalServiceUtil.findByRecordId(record.getRecordId());
		for (int i = 0; i < listUrlRecord.size(); i++) {
			listNameUrlType.add(new NameUrlType("record"+nameVariable.replace(" ", "")+i, beginningUrl+listUrlRecord.get(i).getUrl(), listUrlRecord.get(i).getType().toLowerCase()));
		}
		this.recorderGet.add(new RecorderGet(nameVariable, listNameUrlType));
	}	
	
}
