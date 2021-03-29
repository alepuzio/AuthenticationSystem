package net.alepuzio.authsys.domain.user.persistence.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.alepuzio.authsys.config.MariaDBConfig;
import net.alepuzio.authsys.config.SQLDBConfig;
import net.alepuzio.authsys.crypto.exception.MyException;
/**
 *  @FEATURE_ORM@ change the JDBC component using Spring Data as ORM
 */
@Component
public class ConnectionFactory {

	@Autowired
	private SQLDBConfig dbConfig;

	private Logger logger = Logger.getLogger(this.getClass());

	public Connection instance() throws Exception {
		Connection result = null;
		try {
			Class.forName(this.dbConfig.driver());
			result = DriverManager.getConnection( this.dbConfig.url() ,
					 this.dbConfig.username() ,
					 this.dbConfig.password()) ;
			logger.debug("Connected database successfully...");
		} catch (Exception e) {
			new MyException(e, logger).error().exception();
		}
		return result;
	}

}
