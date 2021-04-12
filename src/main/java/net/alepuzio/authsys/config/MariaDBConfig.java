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

	
	@Value( "${spring.jpa.ddl}" )
	private String ddl;
	@Value( "${spring.jpa.show.sql}" )
	private String showSql;
	
	@Value( "${spring.jpa.hibernate.dialect}" )
	private String springDialect;
	
//	@Value( "${hibernate.dialect}" )
//	private String dialect;
	
	
//	public String getDialect() {
//		return dialect;
//	}
	
	public String getSpringDialect() {
		return springDialect;
	}

	public String getDdl() {
		return ddl;
	}

	public String getShowSql() {
		return showSql;
	}

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
