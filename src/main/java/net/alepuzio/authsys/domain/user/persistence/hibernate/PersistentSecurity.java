package net.alepuzio.authsys.domain.user.persistence.hibernate;


import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * @FEATURE_ORM@ draft to using Spring Data as ORM
 */
@Entity
@Table(name="security_user",
uniqueConstraints = { @UniqueConstraint(columnNames = { "password","username" }) }
)
public class PersistentSecurity {

		@Embedded
		@Id
		private PersistentSingleFactor singleFactor;
		
	    @Column(name = "VATIN", length = 50, nullable = false)
	    private String vatin;
	    
	    /*
	     * TODO add datetiem signup and last successfull login
	     * */
		@Override
		public String toString() {
			return String.format("Persistent [%s,%s]", vatin, singleFactor);
		}
		
		public PersistentSingleFactor getSingleFactor() {
			return singleFactor;
		}

		public void setSingleFactor(PersistentSingleFactor singleFactor) {
			this.singleFactor = singleFactor;
		}

		public String getVatin() {
			return vatin;
		}
		public void setVatin(String vatin) {
			this.vatin = vatin;
		}
	    
	    
}
