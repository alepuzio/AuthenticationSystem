package net.alepuzio.authsys.domain;

/**
 * @overview this class show the behaviour of the mandatory data of the recored use
 * @deprecated VERIFY IF MERGE WITH uNDERSTANDABLE 
 * */
public interface MandatoryData {

	/**
	 * @return true if all of the elementary data are not null and not empty
	 * */
	public boolean valid();
}
