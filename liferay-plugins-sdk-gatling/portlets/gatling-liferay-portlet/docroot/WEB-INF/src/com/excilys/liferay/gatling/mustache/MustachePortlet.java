package com.excilys.liferay.gatling.mustache;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.excilys.liferay.gatling.model.Record;
import com.excilys.liferay.gatling.model.UrlRecord;
import com.excilys.liferay.gatling.mustache.util.RecorderGet;
import com.excilys.liferay.gatling.service.UrlRecordLocalServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.HtmlUtil;

public class MustachePortlet {
	
	private static final Log LOG = LogFactoryUtil.getLog(MustachePortlet.class);

	private String name, url, ppid;
	private double pourcentage;
	private boolean last, isJournal;
	private MustacheUrl assetPublisherSimple, messageBoardSimple, messageBoardPost, wikiDisplaySimple;
	private List<RecorderGet> recorderGet;
	private List<MustacheScript> scripts;

	public MustachePortlet(String name, String url, String portletId, double pourcentage, boolean last) {
		this.name = name;
		this.url = url;
		this.pourcentage = pourcentage;
		this.last = last;
		this.ppid = portletId;
	}

	{
		scripts = new ArrayList<MustacheScript>();
		recorderGet = new ArrayList<RecorderGet>();
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

	public MustacheUrl getAssetPublisherSimple() {
		return assetPublisherSimple;
	}

	public void setAssetPublisherSimple(String name, String url, double weight) {
		addScript(new MustacheScript(name, weight));
		this.assetPublisherSimple = new MustacheUrl(name , url, "", "", 0L);
	}

	/* --- Message Board --- */

	public MustacheUrl getMessageBoardSimple() {
		return messageBoardSimple;
	}

	public void setMessageBoardSimple(String name, String url, double weight) {
		addScript(new MustacheScript(name, weight));
		this.messageBoardSimple = new MustacheUrl(name , url, "", "", 0L);
	}

	public MustacheUrl getMessageBoardPost() {
		return messageBoardPost;
	}

	public void setMessageBoardPost(String name, String url, double weight) {
		addScript(new MustacheScript(name, weight));
		this.messageBoardPost = new MustacheUrl(name , url, "", "", 0L);
	}

	/* --- Wiki Display --- */

	public MustacheUrl getWikiDisplaySimple() {
		return wikiDisplaySimple;
	}

	public void setWikiDisplaySimple(String name, String url, long plid, double weight) {
		addScript(new MustacheScript(name, weight));
		this.wikiDisplaySimple = new MustacheUrl(name, url, "", "", plid);
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
		String nameVariable = "record_" + record.getName().replace(" ", "");
		addScript(new MustacheScript(nameVariable, weight));
		List<MustacheUrl> listNameUrlType = new ArrayList<MustacheUrl>();
		List<UrlRecord> listUrlRecord = UrlRecordLocalServiceUtil.findByRecordId(record.getRecordId());
		for (int i = 0; i < listUrlRecord.size(); i++) {
			UrlRecord URLrecord = listUrlRecord.get(i);
			String url = URLrecord.getUrl();
			String namespace = record.getPortletId();
			/*
			 * Replace ppid if it is different from the portlet
			 */
			Pattern ppid = Pattern.compile("p_p_id=(.+?)&");
			Matcher m = ppid.matcher(url);
			if(m.find()) {
				String ppidUrl = m.group(1).split("_")[0];
				if(!record.getPortletId().equals(ppidUrl)) {
					namespace = ppidUrl;
				}
			}
			//if post -> last request was a form
			if(listUrlRecord.get(i).getType().equalsIgnoreCase("post")) {


				if(i > 0) {
					listNameUrlType.get(i-1).setForm(true);
					/*
					 * If form contains version replace in url
					 */
					ppid = Pattern.compile("(.+?)_version=.+?&");
					m = ppid.matcher(url);
					if(m.find()) {
						listNameUrlType.get(i-1).setVersion(true);
						url = url.replaceFirst("_"+namespace+"_version=.+?&", "_"+namespace+"_version=\\${versionEdit1}.\\${versionEdit2}&");
					}
					
					/* pauth */
					ppid = Pattern.compile("&p_auth=.+?&");
					m = ppid.matcher(url);
					if(m.find()) {
						listNameUrlType.get(i-1).setPauth(true);
						url = url.replaceFirst("&p_auth=.+?&", "&p_auth=\\${pauth}&");
					}
				}
				//Remove redirect call
				if(i < listUrlRecord.size()-1 && listUrlRecord.get(i+1).getType().equalsIgnoreCase("get")) {
					i++;
				}
				//journal edit case
				if(namespace.equals("15")) {
					isJournal = true;
				}
				
				/* replace with runtime formDate */
				url = url.replaceFirst("&_"+namespace+"_formDate=.+?&", "&_"+namespace+"_formDate=\\${formDatePortlet}&");
				url = url.replaceFirst("&p_p_auth=.+?&", "&p_p_auth=\\${portletAuth}&");
				
				url = HtmlUtil.replaceNewLine(url);

			}
			listNameUrlType.add(new MustacheUrl(nameVariable+i, beginningUrl+url, URLrecord.getType().toLowerCase(), namespace, 0L));
		}
		this.recorderGet.add(new RecorderGet(nameVariable, listNameUrlType));
	}

	public String getPpid() {
		return ppid;
	}

	public void setPpid(String ppid) {
		this.ppid = ppid;
	}

	public boolean isJournal() {
		return isJournal;
	}

	public void setJournal(boolean isJournal) {
		this.isJournal = isJournal;
	}

}
