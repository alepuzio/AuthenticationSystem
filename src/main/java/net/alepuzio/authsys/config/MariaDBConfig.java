package net.alepuzio.authsys.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
/**
 * @overview: this class incapsulate the connection data to the database
 * */
@Component
public class MariaDBConfig implements SQLDBConfig {
	
	@Value( "${spring.datasource.url}" )
	private String url;
	@Value( "${spring.datasource.username}" )
	private String username;
	@Value( "${spring.datasource.password}" )
	private String password;
	@Value( "${spring.datasource.driver-class-name}" )
	private String driver;

	@Value( "${spring.jpa.hibernate.thread}" )
	private String thread;

	@Value( "${spring.jpa.hibernate.show_sql}" )
	private String showSQL;

	@Value( "${spring.jpa.hibernate.dialect}" )
	private String dialect;

	@Override
	public String url() {
		return url;
	}

	@Override
	public String username() {
		return username;
	}

	@Override
	public String password() {
		return password;
	}

	@Override
	public String driver() {
		return driver;
	}

	@Override
	public String dialect() {
		return dialect;
	}

	@Override
	public String showSQL() {
		return showSQL;
	}

	@Override
	public String thread() {
		return thread;
	}


}
