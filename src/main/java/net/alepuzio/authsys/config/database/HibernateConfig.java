package net.alepuzio.authsys.config.database;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import net.alepuzio.authsys.config.SQLDBConfig;

@Component
public class HibernateConfig implements SQLDBConfig {

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
	public String thread() {
		return thread;
	}
	@Override
	public String showSQL() {
		return showSQL;
	}
	@Override
	public String dialect() {
		return dialect;
	}
	@Value( "${spring.jpa.hibernate.dialect}" )
	private String dialect;


}
