package net.alepuzio.authsys.domain.user.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import net.alepuzio.authsys.config.MariaDBConfig;
import net.alepuzio.authsys.domain.user.Generic;
import net.alepuzio.authsys.domain.user.UserRepository;

public class JDBCRepository implements UserRepository {

	private Logger logger = Logger.getLogger(this.getClass());
	
	@Autowired
	private MariaDBConfig mariaDBConfig;
	
	@Override
	public Persistent save(Generic user1) throws Exception {
		Connection conn = null;
		PreparedStatement stmt = null;
		Persistent result  = new Persistent();
		try {
			Class.forName(mariaDBConfig.getDriver());
			// STEP 3: Open a connection
			logger.debug("Connecting to a selected database...");
			conn = DriverManager.getConnection(mariaDBConfig.getUrl(), mariaDBConfig.getUsername(), mariaDBConfig.getPassword());
			logger.debug("Connected database successfully...");
			// STEP 4: Execute a query

			String sql = "INSERT INTO USER(NAME, SURNAME, VATIN, USERNAME, PASSWORD) VALUES(?,?,?,?,?)";
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, user1.getAnagraphicData().getName());
			stmt.setString(2, user1.getAnagraphicData().getSurname());
			stmt.setString(3, user1.getAnagraphicData().getVatIn());
			
			stmt.setString(4, user1.getSecurityData().getUsername());
			stmt.setString(5, user1.getSecurityData().getPassword().crypto());
			if (stmt.execute()){
//				result.setCryptedPassword(user1.getSecurityData().getPassword().crypto());
//				result.setName(user1.getAnagraphicData().getName());
//				result.setVatin(user1.getAnagraphicData().getVatIn());
//				result.setUsername(user1.getSecurityData().getUsername());
//				result.setSurname(user1.getAnagraphicData().getSurname());
			}
		} catch (Exception e) {
			e.printStackTrace();
			result = new Persistent();
		} finally {
			// finally block used to close resources
				if (stmt != null) {
					conn.close();
				}
				if (conn != null) {
					conn.close();
				}
		}
		return result ;
	}

}
