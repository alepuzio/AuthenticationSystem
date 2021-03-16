package net.alepuzio.authsys.domain;

public interface MandatoryData {

	
	/**
	 * @return true if all of the elementary data are not null and not empty
	 * */
	public boolean valid();
}
