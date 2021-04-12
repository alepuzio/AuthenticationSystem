package net.alepuzio.authsys.domain.user.persistence.jpa.security;

import javax.persistence.Entity;

@Entity
public class UserSecurity {

	private String username;
	private String password;
	private String vatin;
	
	
	
	public UserSecurity(String username, String password, String vatin) {
		super();
		this.username = username;
		this.password = password;
		this.vatin = vatin;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getVatin() {
		return vatin;
	}
	public void setVatin(String vatin) {
		this.vatin = vatin;
	}
	
	
	
}
