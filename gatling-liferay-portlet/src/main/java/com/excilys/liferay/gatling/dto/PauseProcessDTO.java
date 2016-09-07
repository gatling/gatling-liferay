package com.excilys.liferay.gatling.dto;

public class PauseProcessDTO extends ProcessDTO {

	private int pause;

	public PauseProcessDTO(String cssId, int pause) {
		//The identifier is not needed by pauses
		super("Pause", cssId, "Pause", "Pause");
		this.pause = pause;
	}

	@Override
	public int getPause() {
		return pause;
	}

	public void setPause(int pause) {
		this.pause = pause;
	}

	@Override
	public boolean isPause() {
		return true;
	}	
	
}
