package net.alepuzio.authsys.domain.user.persistence;

import java.sql.Connection;
import java.sql.DriverManager;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.alepuzio.authsys.config.MariaDBConfig;
import net.alepuzio.authsys.crypto.TrippleDes;
import net.alepuzio.authsys.crypto.exception.MyException;

@Component
public class ConnectionFactory {

	@Autowired
	private MariaDBConfig mariaDBConfig;

	private Logger logger = Logger.getLogger(this.getClass());

	public Connection instance() throws Exception {
		Connection result = null;
		try {
			Class.forName(this.mariaDBConfig.getDriver());
			/*TODO correggere errore javax.crypto.IllegalBlockSizeException: Input length must be multiple of 16 when decrypting with padded cipher*/
			result = DriverManager.getConnection(/* new TrippleDes().decrypt( */this.mariaDBConfig.getUrl()/* ) */,
					/* new TrippleDes().decrypt( */this.mariaDBConfig.getUsername()/* ) */,
					/* new TrippleDes().decrypt( */this.mariaDBConfig.getPassword())/* ) */;
			logger.debug("Connected database successfully...");
		} catch (Exception e) {
			new MyException(e, logger).error().exception();
		}
		return result;
	}

}
