package net.alepuzio.authsys.domain.user.elementary;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import net.alepuzio.authsys.domain.MandatoryData;
import net.alepuzio.authsys.domain.user.elementary.password.Password;
import net.alepuzio.authsys.domain.user.persistence.hibernate.PersistentSecurity;
/**
 * @overview: this class contains the user data about security 
 * */
public class SecurityData implements MandatoryData {

	private String username = null;
	private Password password = null;
	
	public SecurityData(String username, String password) {
		super();
		this.username = username;
		this.password = new Password(password);
	}
	
	public SecurityData(PersistentSecurity persistentSecurity) {
		super();
		System.out.println("costru security");
		System.out.println("costru security1:"+persistentSecurity);
		this.username = persistentSecurity.getSingleFactor().getUsername();
		System.out.println("costru security 2");
		this.password = new Password(persistentSecurity.getSingleFactor().getPassword());
	}

	
	public SecurityData(Map<String, String> body) {
		this(body.get("username"),body.get("password"));
	}
	public SecurityData(ResultSet rs) throws SQLException {
		this( rs.getString("USERNAME"),rs.getString("PASSWORD"));
	}

	public String getUsername() {
		return username;
	}
	public Password getPassword() {
		return password;
	}

	/**
	 * @return true if username and password are both not null and not empty
	 * */
	@Override
	public boolean valid() {
		return StringUtils.isNotEmpty(this.username)
				&& StringUtils.isNotEmpty(this.password.getValue()) 
				;
	}
	
	@Override
	public String toString() {
		return "SecurityData [username=" + username + ", password=" + password + "]";
	}

	
	
}
