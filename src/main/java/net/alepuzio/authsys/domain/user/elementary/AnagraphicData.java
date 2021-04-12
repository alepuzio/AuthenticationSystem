package net.alepuzio.authsys.domain.user.elementary;

import org.apache.commons.lang3.StringUtils;

import net.alepuzio.authsys.domain.MandatoryData;
import net.alepuzio.authsys.domain.user.elementary.cripto.Understandable;
/**
 * @overview: this class represent the anagraphic data of an user
 * */
public class AnagraphicData implements MandatoryData {

	private Understandable name = null;
	private Understandable surname = null;
	private Understandable vatIn = null;//fiscal code in English
	

public AnagraphicData(Understandable name,
			Understandable surname, 
			Understandable vatIn) {
		super();
		this.name = name;
		this.surname = surname;
		this.vatIn = vatIn;
	}

	@Override
	public String toString() {
		return "AnagraphicData [name=" + name + ", surname=" + surname + ", vatIn=" + vatIn + "]";
	}
	public Understandable getName() {
		return name;
	}
	public Understandable getSurname() {
		return surname;
	}
	public Understandable getVatIn() {
		return  vatIn;
	}
	@Override
	public boolean valid() {
		return StringUtils.isNotEmpty(this.name.decrypt())
				&& StringUtils.isNotEmpty(this.surname.decrypt()) 
				&& StringUtils.isNotEmpty(this.vatIn.decrypt())
				;
	}

}
