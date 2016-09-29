package io.gatling.liferay.dto;


/**
 * ProcessDTO regroups all the Data needed to
 * draw process boxes in the scenarios and the library
 * in the view.jsp
 */
public class ProcessDTO implements Comparable<ProcessDTO>{

	/**
	 * The name of the process
	 */
	private String name;
	
	/**
	 * The id of the div that will represent the box
	 */
	private String cssId;
	
	/**
	 * The css class of the div that will represent the box
	 */
	private String cssClass;
	
	/**
	 * The process type
	 */
	private String type;
	
	/**
	 * The pause that will be performed after the process
	 */
	private int pause;
	
	
	
	
	public ProcessDTO() {}
	
	public ProcessDTO(String name, String cssId, String cssClass, String type) {
		this.name = name;
		this.cssId = cssId;
		this.cssClass = cssClass;
		this.type = type;
	}

	public ProcessDTO(String name, String cssId, String cssClass, String type, int pause) {
		this(name,cssId, cssClass, type);
		this.pause = pause;
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCssId() {
		return cssId;
	}

	public void setCssId(String cssId) {
		this.cssId = cssId;
	}
	
	public String getType() {
		return type;
	}
	
	public String getCssClass() {
		return cssClass;
	}

	public void setCssClass(String cssClass) {
		this.cssClass = cssClass;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean isPause(){
		return this.type.equals("PAUSE");
	}
	
	public int compareTo(ProcessDTO other) {
		return this.type.compareTo(other.type);
	}

	/* Can't have a pause by default */
	public int getPause() {
		return pause;
	}

	@Override
	public String toString() {
		return "ProcessDTO [name=" + name + ", cssId=" + cssId + ", cssClass="
				+ cssClass + ", type=" + type + "]";
	}
	
}
