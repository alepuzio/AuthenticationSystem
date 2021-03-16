package net.alepuzio.authsys.domain.user.elementary;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import net.alepuzio.authsys.domain.MandatoryData;
import net.alepuzio.authsys.domain.user.elementary.password.Password;

public class SecurityData implements MandatoryData {
	
	private String username = null;
	private Password password = null;
	
	public SecurityData(String username, String password) {
		super();
		this.username = username;
		this.password = new Password(password);
	}

	public SecurityData(Map<String, String> body) {
		this(body.get("username"),body.get("password"));
	}

	public String getUsername() {
		return username;
	}
	public Password getPassword() {
		return password;
	}

	@Override
	public boolean valid() {
		return StringUtils.isNotEmpty(this.username)
				&& StringUtils.isNotEmpty(this.password.getValue()) 
				;
	
	}

	
	
}
