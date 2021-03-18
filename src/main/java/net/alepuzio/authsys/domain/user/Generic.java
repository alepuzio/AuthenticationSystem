package net.alepuzio.authsys.domain.user;

import net.alepuzio.authsys.domain.User;
import net.alepuzio.authsys.domain.user.elementary.AnagraphicData;
import net.alepuzio.authsys.domain.user.elementary.SecurityData;
/**
 * @overview: this class represent a generic user 
 * */
public class Generic implements User {

	@Override
	public String toString() {
		return "Generic [anagraphicData=" + anagraphicData + ", securityData=" + securityData + "]";
	}

	private AnagraphicData anagraphicData = null;
	private SecurityData securityData = null;

	public SecurityData getSecurityData() {
		return securityData;
	}

	public AnagraphicData getAnagraphicData() {
		return anagraphicData;
	}

	public Generic(AnagraphicData anagraphicData, SecurityData securityData) {
		super();
		this.anagraphicData = anagraphicData;
		this.securityData = securityData;
	}

	public Generic( SecurityData securityData) {
		this(null,	securityData);	
	}
	
	public boolean recorded(){
		return false;
	}
	
	@Override
	public boolean valid() {
		return (this.anagraphicData.valid() && this.securityData.valid());
	}

}
