package net.alepuzio.authsys.domain.user;

import net.alepuzio.authsys.domain.MandatoryData;
import net.alepuzio.authsys.domain.User;
import net.alepuzio.authsys.domain.data.AnagraphicData;
import net.alepuzio.authsys.domain.data.SecurityData;

public class Generic implements User {

	private MandatoryData anagraphicData = null;
	private MandatoryData securityData = null;

	public MandatoryData getSecurityData() {
		return securityData;
	}

	public MandatoryData getAnagraphicData() {
		return anagraphicData;
	}

	public Generic(AnagraphicData anagraphicData, SecurityData securityData) {
		super();
		this.anagraphicData = anagraphicData;
		this.securityData = securityData;
	}

	public boolean recorded(){
		return false;
	}
	
	@Override
	public boolean valid() {
		return (this.anagraphicData.valid() && this.securityData.valid());
	}

}
