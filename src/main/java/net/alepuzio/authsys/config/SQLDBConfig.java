package net.alepuzio.authsys.config;

public interface SQLDBConfig {

	public String url() ;

	public String username();

	public String password() ;

	public String driver();
	
	public String dialect();
	public String showSQL();
	public String thread();
	
	

}
