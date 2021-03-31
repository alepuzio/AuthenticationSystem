package net.alepuzio.authsys.domain.user.persistence.hibernate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * @FEATURE_ORM@ draft to using Spring Data as ORM
 */
/*@Entity
@Table(name="anagraphical_user",
uniqueConstraints = { @UniqueConstraint(columnNames = { "VATIN" }) }
)*/
public class PersistentAnagraphical {

	    
	    @Column(name = "name", length = 50, nullable = false)
	    private String name;
	    @Column(name = "surname", length = 50, nullable = false)
	    private String surname;
	    @Id
	    @OneToOne(mappedBy = "security_user"
		, cascade = CascadeType.ALL
		, fetch = FetchType.LAZY
		, optional = false)
	    //@Column(name = "vatin", length = 50, nullable = false)
	    private String vatin;
	    
	    /*
	     * TODO add datetiem signup and last successfull login
	     * */

		
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

		@Override
		public String toString() {
			return String.format("PersistentAnagraphical [%s,%s,%s]",  name , surname ,vatin );
		}

	    
}
