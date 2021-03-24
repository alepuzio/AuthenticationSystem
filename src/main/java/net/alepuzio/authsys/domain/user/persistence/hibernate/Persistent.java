package net.alepuzio.authsys.domain.user.persistence.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * @FEATURE_ORM@ draft to using Spring Data as ORM
 */
@Entity
@Table(name="user",
uniqueConstraints = { @UniqueConstraint(columnNames = { "VATIN" }) }
)
public class Persistent {

	    
	    @Column(name = "NAME", length = 50, nullable = false)
	    private String name;
	    @Column(name = "SURNAME", length = 50, nullable = false)
	    private String surname;
	    @Id
	    @Column(name = "VATIN", length = 50, nullable = false)
	    private String vatin;
	    @Column(name = "cryptedPassword", length = 50, nullable = false)
	    private String cryptedPassword;
	    @Column(name = "USERNAME", length = 50, nullable = false)
	    private String username;
	    
	    /*
	     * TODO add datetiem signup and last successfull login
	     * */

	    public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}

		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getSurname() {
			return surname;
		}
		public void setSurname(String surname) {
			this.surname = surname;
		}
		public String getVatin() {
			return vatin;
		}
		public void setVatin(String vatin) {
			this.vatin = vatin;
		}
		public String getCryptedPassword() {
			return cryptedPassword;
		}
		@Override
		public String toString() {
			return String.format("Persistent [%s,%s,%s,%s,%s]",  name , surname ,vatin, username, cryptedPassword );
		}
		
		public void setCryptedPassword(String cryptedPassword) {
			this.cryptedPassword = cryptedPassword;
		}
	    
	    
}
