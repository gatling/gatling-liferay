package com.excilys.liferay.gatling.mustache.util;


public class WikiDisplay {

	private String nameVariable = null;
	private String url = null;
	private String portletId = null;
	private String column = null;
	private String nbColumn = null;


	public WikiDisplay(String url, String nameVariable, String plid, String column) {
		this.setUrl(url);
		this.nameVariable = nameVariable;
		this.portletId = plid.substring(0, plid.length()-1);
		this.column = column;
//		int groupId = 11005;
//		try {
//			List<WikiNode> wikiNodes = WikiNodeServiceUtil.getNodes(groupId);
//
//			WikiPageResourceLocalServiceUtil.getWikiPageResources(0, 1);
//			
//			for (WikiNode wikiNode : wikiNodes) {
//				List<WikiPage> wikiPages = WikiPageServiceUtil.getNodePages(wikiNode.getNodeId(), 0);	
//			}
//		} catch (SystemException e) {
//
//		} catch (PortalException e) {
//
//		}
	}

	public String getPlid() {
		return portletId;
	}


	public void setPlid(String plid) {
		this.portletId = plid;
	}


	public String getColumn() {
		return column;
	}


	public void setColumn(String column) {
		this.column = column;
	}


	public String getNbColumn() {
		return nbColumn;
	}


	public void setNbColumn(String nbColumn) {
		this.nbColumn = nbColumn;
	}

	public String getNameVariable() {
		return nameVariable;
	}


	public void setNameVariable(String nameVariable) {
		this.nameVariable = nameVariable;
	}


	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((column == null) ? 0 : column.hashCode());
		result = prime * result + ((nameVariable == null) ? 0 : nameVariable.hashCode());
		result = prime * result + ((nbColumn == null) ? 0 : nbColumn.hashCode());
		result = prime * result + ((portletId == null) ? 0 : portletId.hashCode());
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
		WikiDisplay other = (WikiDisplay) obj;
		if (column == null) {
			if (other.column != null)
				return false;
		} else if (!column.equals(other.column))
			return false;
		if (nameVariable == null) {
			if (other.nameVariable != null)
				return false;
		} else if (!nameVariable.equals(other.nameVariable))
			return false;
		if (nbColumn == null) {
			if (other.nbColumn != null)
				return false;
		} else if (!nbColumn.equals(other.nbColumn))
			return false;
		if (portletId == null) {
			if (other.portletId != null)
				return false;
		} else if (!portletId.equals(other.portletId))
			return false;
		if (url == null) {
			if (other.url != null)
				return false;
		} else if (!url.equals(other.url))
			return false;
		return true;
	}



}
