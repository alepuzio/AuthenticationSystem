package net.alepuzio.authsys.domain.user.persistence.hibernate;


import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import net.alepuzio.authsys.domain.user.elementary.AnagraphicData;


/**
 * @FEATURE_ORM@ draft to using Spring Data as ORM
 */
@Entity
@Table(name="security_user",
uniqueConstraints = { @UniqueConstraint(columnNames = { "password","username" }) }
)
public class PersistentSecurity {

		@EmbeddedId
		private PersistentSingleFactor singleFactor;
		
	  //  @Column(name = "vatin", length = 50, nullable = false)
	    
	    //@OneToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "vatin")
	    @OneToOne(mappedBy = "vatin", cascade = CascadeType.ALL)
	    private AnagraphicData anagraphicData;
	    
	    /*
	     * TODO add datetiem signup and last successfull login
	     * */
		@Override
		public String toString() {
			return String.format("PersistentSecurity [%s,%s]", anagraphicData, singleFactor);
		}
		
		public PersistentSingleFactor getSingleFactor() {
			return singleFactor;
		}

		public void setSingleFactor(PersistentSingleFactor singleFactor) {
			this.singleFactor = singleFactor;
		}

		public AnagraphicData getAnagraphicData() {
			return anagraphicData;
		}

		public void setAnagraphicData(AnagraphicData anagraphicData) {
			this.anagraphicData = anagraphicData;
		}

	    
	    
}
