package net.alepuzio.authsys.domain;

import net.alepuzio.authsys.domain.data.AnagraphicData;
import net.alepuzio.authsys.domain.data.SecurityData;

public class User {

	private MandatoryData anagraphicData = null;
	private MandatoryData securityData = null;

	public MandatoryData getSecurityData() {
		return securityData;
	}

	public MandatoryData getAnagraphicData() {
		return anagraphicData;
	}

	public User(AnagraphicData anagraphicData, SecurityData securityData) {
		super();
		this.anagraphicData = anagraphicData;
		this.securityData = securityData;
	}

	public boolean recorded(){
		return false;
	}
	
	public boolean readyToRecord(){
		return (this.anagraphicData.valid() && this.securityData.valid());
	}

}
