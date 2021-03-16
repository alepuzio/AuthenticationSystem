package net.alepuzio.authsys.domain.user.elementary.password;

public class Password {

	public String getValue() {
		return value;
	}

	public Password(String value) {
		super();
		this.value = value;
	}

	private String value = null;
	
	public String crypto(){
		return this.value;
	}
	
}
