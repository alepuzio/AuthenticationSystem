package net.alepuzio.authsys.domain.user.elementary.cripto.banal;

import net.alepuzio.authsys.domain.user.elementary.cripto.Understandable;

public class Banal implements Understandable {

	
	private String value;
	
	public Banal(String newValue){
		this.value = newValue;
	}

	@Override
	public String decrypt() {
		return this.value();
	}

	@Override
	public String encrypt() {
		return this.value();
	}

	private String value(){
		return this.value;
	}
}
