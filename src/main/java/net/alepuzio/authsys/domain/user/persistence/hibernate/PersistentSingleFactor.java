package net.alepuzio.authsys.domain.user.persistence.hibernate;

import javax.persistence.Column;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class PersistentSingleFactor implements Serializable {
	
	@Column(name = "password", length = 50, nullable = false)
    private String password;
    @Column(name = "username", length = 50, nullable = false)
    private String username;
    private static final long serialVersionUID = 1L;
	
		
    public PersistentSingleFactor() {}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PersistentSingleFactor other = (PersistentSingleFactor) obj;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
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
