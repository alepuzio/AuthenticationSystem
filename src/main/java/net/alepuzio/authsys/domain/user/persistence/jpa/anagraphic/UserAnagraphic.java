package net.alepuzio.authsys.domain.user.persistence.jpa.anagraphic;

import javax.persistence.Entity;

@Entity
public class UserAnagraphic {

	private String name;
	private String surname;
	private String vatin;
	
	public UserAnagraphic(String name, String surname, String vatin){
		this.name = name;
		this.surname = surname;
		this.vatin = vatin;
	}
	
	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getVatin() {
		return vatin;
	}
	public void setVatin(String vatin) {
		this.vatin = vatin;
	}
	
}
