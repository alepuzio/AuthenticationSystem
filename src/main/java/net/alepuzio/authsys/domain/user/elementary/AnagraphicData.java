package net.alepuzio.authsys.domain.user.elementary;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import net.alepuzio.authsys.domain.MandatoryData;

public class AnagraphicData implements MandatoryData {
	private String name = null;
	private String surname = null;
	private String vatIn = null;
	
	public AnagraphicData(String name, String surname, String vatIn) {
		super();
		this.name = name;
		this.surname = surname;
		this.vatIn = vatIn;
	}

	public AnagraphicData(Map<String, String> body) {
		this(body.get("name"),body.get("surname"), body.get("vatin"));
	}

	public AnagraphicData(ResultSet rs) throws SQLException {
		this(rs.getString("NAME"),rs.getString("SURNAME"), rs.getString("VATIN"));
	}

	@Override
	public String toString() {
		return "AnagraphicData [name=" + name + ", surname=" + surname + ", vatIn=" + vatIn + "]";
	}
	public String getName() {
		return name;
	}
	public String getSurname() {
		return surname;
	}
	public String getVatIn() {
		return  vatIn;
	}
	@Override
	public boolean valid() {
		return StringUtils.isNotEmpty(this.name)
				&& StringUtils.isNotEmpty(this.surname) 
				&& StringUtils.isNotEmpty(this.vatIn)
				;
	}

}
