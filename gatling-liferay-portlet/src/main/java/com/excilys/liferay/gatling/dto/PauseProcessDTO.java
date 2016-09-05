package com.excilys.liferay.gatling.dto;

public class PauseProcessDTO extends ProcessDTO {

	private int pause;

	public PauseProcessDTO(int pause) {
		//The identifier is not needed by pauses
		super("Pause", -42, "Pause");
		this.pause = pause;
	}

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
