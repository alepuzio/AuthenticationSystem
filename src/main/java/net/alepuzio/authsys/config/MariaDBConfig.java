package net.alepuzio.authsys.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
/**
 * @overview: this class incapsulate the connection data to the database
 * */
@Component
public class MariaDBConfig {
	
	@Value( "${spring.datasource.url}" )
	private String url;
	@Value( "${spring.datasource.username}" )
	private String username;
	@Value( "${spring.datasource.password}" )
	private String password;
	@Value( "${spring.datasource.driver-class-name}" )
	private String driver;


	public String getUrl() {
		return url;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getDriver() {
		return driver;
	}


}
