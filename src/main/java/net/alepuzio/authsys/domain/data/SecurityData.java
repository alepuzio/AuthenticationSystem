package net.alepuzio.authsys.domain.data;

import org.apache.commons.lang3.StringUtils;

import net.alepuzio.authsys.domain.MandatoryData;

public class SecurityData implements MandatoryData {
	
	private String username = null;
	private String password = null;
	
	public SecurityData(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}

	@Override
	public boolean valid() {
		return StringUtils.isNotEmpty(this.username)
				&& StringUtils.isNotEmpty(this.password) 
				;
	
	}

	
	
}
