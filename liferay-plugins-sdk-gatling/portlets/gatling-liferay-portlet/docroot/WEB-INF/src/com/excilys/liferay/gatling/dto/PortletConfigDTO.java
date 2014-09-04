package com.excilys.liferay.gatling.dto;

import java.util.List;


public class PortletConfigDTO {
	
	/**
	 * Portlet ID in Liferay
	 */
	private String portletId;
	/**
	 * Portlet name in Liferay
	 */
	private String portletName;
	/**
	 * GroupId of the website's portlet
	 */
	private long groupId;
	/**
	 * PlId
	 */
	private long plId;
	/**
	 * RequestId in DB
	 */
	private long requestId;
	/**
	 * List of used name for this portlet (record)
	 */
	private String listRecordsNameJS;
	/**
	 * LineId in JSP
	 */
	private long lineId;
	/**
	 * List of available Script/Record (select)
	 */
	private String[][] availableScript;
	/**
	 * DTO of table rows
	 */
	private List<LinkUsecaseRequestDTO> linkDTO;
	/**
	 * Next state of the recorder
	 */
	private String nextRecordState;
	
	public static class PortletConfigDTOBuilder {
		PortletConfigDTO config = new PortletConfigDTO();
		
		public PortletConfigDTOBuilder portletId(String portletId) {
			config.setPortletId(portletId);
			return this;
		}
		public PortletConfigDTOBuilder portletName(String portletName) {
			config.setPortletName(portletName);
			return this;
		}
		public PortletConfigDTOBuilder groupId(long groupId) {
			config.setGroupId(groupId);
			return this;
		}
		public PortletConfigDTOBuilder plId(long plId) {
			config.setPlId(plId);
			return this;
		}
		public PortletConfigDTOBuilder requestId(long requestId) {
			config.setRequestId(requestId);
			return this;
		}
		public PortletConfigDTOBuilder listRecordNameJS(String listRecordsNameJS) {
			config.setListRecordsNameJS(listRecordsNameJS);
			return this;
		}
		public PortletConfigDTOBuilder lineId(long lineId) {
			config.setLineId(lineId);
			return this;
		}
		public PortletConfigDTOBuilder availableScript(String[][] availableScript) {
			config.setAvailableScript(availableScript);
			return this;
		}
		public PortletConfigDTOBuilder linkDTO(List<LinkUsecaseRequestDTO> linkDTO) {
			config.setLinkDTO(linkDTO);
			return this;
		}
		public PortletConfigDTOBuilder nextStateRecord(String nextRecordState) {
			config.setNextRecordState(nextRecordState);
			return this;
		}
		public PortletConfigDTO build() {
			return config;
		}
	}
	
	/*
	 * Getters/Setters
	 */
	public String getPortletId() {
		return portletId;
	}
	public void setPortletId(String portletId) {
		this.portletId = portletId;
	}
	public String getPortletName() {
		return portletName;
	}
	public void setPortletName(String portletName) {
		this.portletName = portletName;
	}
	public long getGroupId() {
		return groupId;
	}
	public void setGroupId(long groupId) {
		this.groupId = groupId;
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
	public String getListRecordsNameJS() {
		return listRecordsNameJS;
	}
	public void setListRecordsNameJS(String listRecordsNameJS) {
		this.listRecordsNameJS = listRecordsNameJS;
	}
	public long getLineId() {
		return lineId;
	}
	public void setLineId(long lineId) {
		this.lineId = lineId;
	}
	public String[][] getAvailableScript() {
		return availableScript;
	}
	public void setAvailableScript(String[][] availableScript) {
		this.availableScript = availableScript;
	}
	public List<LinkUsecaseRequestDTO> getLinkDTO() {
		return linkDTO;
	}
	public void setLinkDTO(List<LinkUsecaseRequestDTO> linkDTO) {
		this.linkDTO = linkDTO;
	}
	public String getNextRecordState() {
		return nextRecordState;
	}
	public void setNextRecordState(String nextRecordState) {
		this.nextRecordState = nextRecordState;
	}
	

	
}
