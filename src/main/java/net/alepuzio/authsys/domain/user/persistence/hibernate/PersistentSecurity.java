package net.alepuzio.authsys.domain.user.persistence.hibernate;


import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Table;


/**
 * @FEATURE_ORM@ draft to using Spring Data as ORM
 */
//@Entity
@Table(name="security_user")
/*,uniqueConstraints = { @UniqueConstraint(columnNames = { "password","username" }) }*/
public class PersistentSecurity {

		@EmbeddedId
		   @AttributeOverride(name="username", column=@Column(name="username"))
		   @AttributeOverride(name="password", column=@Column(name="password"))
		private PersistentSingleFactor id;
		
/*	    
	    @JoinColumn(name = "vatin")
	    @OneToOne(mappedBy = "vatin", cascade = CascadeType.ALL)
	    private AnagraphicData anagraphicData;
	*/    
	    /*
	     * TODO add datetiem signup and last successfull login
	     * */
		@Override
		public String toString() {
			return String.format("PersistentSecurity [%s,%s]", id, id);
		}
		
		public PersistentSingleFactor getId() {
			return id;
		}

		public void setId(PersistentSingleFactor singleFactor) {
			this.id = singleFactor;
		}
/*
		public AnagraphicData getAnagraphicData() {
			return anagraphicData;
		}

		public void setAnagraphicData(AnagraphicData anagraphicData) {
			this.anagraphicData = anagraphicData;
		}

	*/    
	    
}
