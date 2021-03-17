package net.alepuzio.authsys.domain.user.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.alepuzio.authsys.config.MariaDBConfig;
import net.alepuzio.authsys.domain.user.Generic;
import net.alepuzio.authsys.domain.user.UserRepository;
import net.alepuzio.authsys.domain.user.elementary.AnagraphicData;
import net.alepuzio.authsys.domain.user.elementary.SecurityData;

@Component
public class JDBCRepository implements UserRepository {

	private Logger logger = Logger.getLogger(this.getClass());

	@Autowired
	private MariaDBConfig mariaDBConfig;

	@Override
	public Generic save(Generic userToSave) throws Exception {
		logger.info("jdbc.save("+userToSave+")");
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			Class.forName(this.mariaDBConfig.getDriver());
			conn = DriverManager.getConnection(mariaDBConfig.getUrl(), mariaDBConfig.getUsername(),
					mariaDBConfig.getPassword());
			logger.info("Connected database successfully...");
			String sql = "INSERT INTO USER(NAME, SURNAME, VATIN, USERNAME, PASSWORD) VALUES(?,?,?,?,?)";
			stmt = conn.prepareStatement(sql);

			stmt.setString(1, userToSave.getAnagraphicData().getName());
			stmt.setString(2, userToSave.getAnagraphicData().getSurname());
			stmt.setString(3, userToSave.getAnagraphicData().getVatIn());

			stmt.setString(4, userToSave.getSecurityData().getUsername());
			stmt.setString(5, userToSave.getSecurityData().getPassword().crypto());
			final int numberRows = stmt.executeUpdate();
			if (1!= numberRows){
				throw new Exception(String.format("Insert with [%d] rows", numberRows));
			}				
		} catch (Exception e) {
			logger.error("Exception " + e.getMessage());
			throw e;
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
		logger.info(String.format(">user(%s)", userToFind));
		Connection conn = null;
		PreparedStatement stmt = null;
		Generic result = null;
		try {
			Class.forName(this.mariaDBConfig.getDriver());
			conn = DriverManager.getConnection(mariaDBConfig.getUrl(), mariaDBConfig.getUsername(),
					mariaDBConfig.getPassword());
			logger.info("Connected database successfully...");
			stmt = conn.prepareStatement("SELECT * FROM  USER WHERE USERNAME = ? AND PASSWORD=?");
			stmt.setString(1, userToFind.getSecurityData().getUsername());
			stmt.setString(2, userToFind.getSecurityData().getPassword().crypto());
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				AnagraphicData anagraphicData = new AnagraphicData(rs.getString("NAME"),
						rs.getString("SURNAME"),
						rs.getString("VATIN"));
				SecurityData securityData = new SecurityData(rs.getString("USERNAME"),
						rs.getString("PASSWORD"));
				result = new Generic(anagraphicData, securityData);
			} else { 
				throw new Exception(String.format("Username [%s] not found ", userToFind.getSecurityData().getUsername()));
			}
			if (rs.next()){
				throw new Exception(String.format("Double username and password for user [%s] ",userToFind));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			close(conn, stmt);
		}
		return result;

	}
}

class ConnectionFactory {

	public ConnectionFactory( MariaDBConfig mariaDBConfig) {
		super();
		this.mariaDBConfig = mariaDBConfig;
	}

	public Connection instance() {
		try {
			Class.forName(this.mariaDBConfig.getDriver());
			return DriverManager.getConnection(mariaDBConfig.getUrl(), mariaDBConfig.getUsername(),
					mariaDBConfig.getPassword());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	private final MariaDBConfig mariaDBConfig;
}
