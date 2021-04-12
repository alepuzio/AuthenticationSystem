package net.alepuzio.authsys.domain.user.elementary;

import java.sql.ResultSet;
import java.util.Map;

import net.alepuzio.authsys.domain.user.elementary.cripto.banal.Banal;
import net.alepuzio.authsys.domain.user.elementary.cripto.desede.Desede;

public class FactoryAnagraphicData {
	
	private String name;
	private String surname;
	private String vatin;
	public  FactoryAnagraphicData(){
		this.name = "name";
		this.surname = "surname";
		this.vatin = "vatin";
		
	}

	public AnagraphicData map (Map<String, String> body) throws Exception{
		return new AnagraphicData(
				new Desede(new Banal(body.get(this.name))),
				new Desede(new Banal(body.get(this.surname))),
				new Desede(new Banal(body.get(this.vatin)))
				);
	}
	
	public AnagraphicData resultSet(ResultSet rs) throws Exception {
		return new AnagraphicData(
				new Desede(new Banal(rs.getString(this.name.toUpperCase()))),
				new Desede(new Banal(rs.getString(this.surname.toUpperCase()))),
				new Desede(new Banal(rs.getString(this.vatin.toUpperCase())))
				);
		
	}



}
