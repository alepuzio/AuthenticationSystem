package net.alepuzio.authsys.domain.user.persistence.hibernate;

import javax.persistence.Column;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class PersistentSingleFactor implements Serializable {
	@Column(name = "password", length = 50, nullable = false)
    private String password;
    @Column(name = "USERNAME", length = 50, nullable = false)
    private String username;
    private static final long serialVersionUID = 1L;
	
		
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Override
	public String toString() {
//		return String.format("PersistentSingleFactor [password=%s, username=%s]", password, username);
		return "PersistentSingleFactor [password=, username=]";
	}

    
}
