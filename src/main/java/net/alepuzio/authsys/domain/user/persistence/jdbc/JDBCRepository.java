package net.alepuzio.authsys.domain.user.persistence.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import net.alepuzio.authsys.crypto.TrippleDes;
import net.alepuzio.authsys.crypto.exception.MyException;
import net.alepuzio.authsys.domain.user.Generic;
import net.alepuzio.authsys.domain.user.elementary.AnagraphicData;
import net.alepuzio.authsys.domain.user.elementary.SecurityData;
import net.alepuzio.authsys.domain.user.persistence.UserRepository;
/**
 * @FEATURE_ORM@ change the JDBC component using Spring Data as ORM
 */

@Component
@Profile("jdbc")
public class JDBCRepository implements UserRepository {

	private Logger logger = Logger.getLogger(this.getClass());


	@Autowired
	private ConnectionFactory connectionFactory;
	
	@Override
	public Generic save(Generic userToSave) throws Exception {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			logger.info(String.format(">save(%s)" ,new TrippleDes().encrypt(userToSave.getAnagraphicData().getVatIn()) ));
			conn = connectionFactory.instance();
			String sql = "INSERT INTO USER(NAME, SURNAME, VATIN, USERNAME, PASSWORD) VALUES(?,?,?,?,?)";
			stmt = conn.prepareStatement(sql);

			stmt.setString(1, new TrippleDes().encrypt(userToSave.getAnagraphicData().getName()));
			stmt.setString(2, new TrippleDes().encrypt(userToSave.getAnagraphicData().getSurname()));
			stmt.setString(3, new TrippleDes().encrypt(userToSave.getAnagraphicData().getVatIn()));

			stmt.setString(4, new TrippleDes().encrypt(userToSave.getSecurityData().getUsername()));
			stmt.setString(5, new TrippleDes().encrypt(userToSave.getSecurityData().getPassword().crypto()));
			final int numberRows = stmt.executeUpdate();
			if (1!= numberRows){
				throw new Exception(String.format("Insert with [%d] rows", numberRows));
			}				
			logger.info(String.format("<save(%s)" ,new TrippleDes().encrypt(userToSave.getAnagraphicData().getVatIn()) ));
		} catch (Exception e) {
			new MyException(e,logger).error().exception();;
		} finally {
			close(conn, stmt);
		}
		return userToSave;
	}

	private void close(Connection conn, PreparedStatement stmt) throws SQLException {
		if (stmt != null) {
			conn.close();
		}
		if (conn != null) {
			conn.close();
		}
	}

	@Override
	public Generic user(Generic userToFind) throws Exception {
		logger.info(String.format(">user(%s)" ,new TrippleDes().encrypt(userToFind.getSecurityData().getUsername())));
		Connection conn = null;
		PreparedStatement stmt = null;
		Generic result = null;
		try {
			conn = connectionFactory.instance();
			stmt = conn.prepareStatement("SELECT NAME, SURNAME, VATIN, USERNAME, PASSWORD FROM  USER WHERE USERNAME = ? AND PASSWORD=?");
			stmt.setString(1, new TrippleDes().encrypt(userToFind.getSecurityData().getUsername()));
			stmt.setString(2, new TrippleDes().encrypt(userToFind.getSecurityData().getPassword().crypto()));
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				result = new Generic(new AnagraphicData(rs), new SecurityData(rs));
			} else { 
				throw new Exception(String.format("Username [%s] not found ", new TrippleDes().encrypt(userToFind.getSecurityData().getUsername())));
			}
			if (rs.next()){
				throw new Exception(String.format("Double record for user [%s] ",new TrippleDes().encrypt(userToFind.getSecurityData().getUsername())));
			}
			logger.info(String.format("<user(%s)" ,new TrippleDes().encrypt(userToFind.getSecurityData().getUsername())));
		} catch (Exception e) {
			new MyException(e,logger).error().exception();
		} finally {
			close(conn, stmt);
		}
		return result;

	}
}

