package net.alepuzio.authsys.domain.user.persistence;

import java.sql.Connection;
import java.sql.DriverManager;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.alepuzio.authsys.config.MariaDBConfig;
import net.alepuzio.authsys.crypto.exception.MyException;
/**
 *  @FEATURE_ORM@ change the JDBC component using Spring Data as ORM
 */
@Component
public class ConnectionFactory {

	@Autowired
	private MariaDBConfig mariaDBConfig;

	private Logger logger = Logger.getLogger(this.getClass());

	public Connection instance() throws Exception {
		Connection result = null;
		try {
			Class.forName(this.mariaDBConfig.getDriver());
			result = DriverManager.getConnection( this.mariaDBConfig.getUrl() ,
					 this.mariaDBConfig.getUsername() ,
					 this.mariaDBConfig.getPassword()) ;
			logger.debug("Connected database successfully...");
		} catch (Exception e) {
			new MyException(e, logger).error().exception();
		}
		return result;
	}

}
