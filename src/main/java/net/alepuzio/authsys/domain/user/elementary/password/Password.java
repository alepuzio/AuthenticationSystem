package net.alepuzio.authsys.domain.user.elementary.password;
/**
 * @overview: this class incapsulate the password data
 * */

public class Password {

	public String getValue() {
		return this.value;
	}

	@Override
	public String toString() {
		return String.format("Password [value=%s]", value);
	}

	public Password(String value) {
		super();
		this.value = value;
	}

	private String value = null;
	
	/**
	 * @deprecated now it's a duplicate of getValue(9, in the future I can incapsulate the encrypt() mechanism
	 * */
	public String crypto(){
		return this.value;
	}
	
}
