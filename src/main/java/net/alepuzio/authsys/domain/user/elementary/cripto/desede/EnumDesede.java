package net.alepuzio.authsys.domain.user.elementary.cripto.desede;

public enum EnumDesede {
	
	UNICODE_FORMAT("UTF8"),
	DESEDE_ENCRYPTION_SCHEME ("DESede"),
	PWD("ThisIsSpartaThisIsSparta");

	private String value;
	private EnumDesede(String newValue){
		this.value = newValue;
	}
	
	public String value(){
		return this.value;
	}
}

