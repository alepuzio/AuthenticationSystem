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
	public Generic save(Generic user1) throws Exception {
		logger.info("jdbc.save("+user1+")");
		Connection conn = null;
		PreparedStatement stmt = null;
		Generic result = null;
		try {
			Class.forName(this.mariaDBConfig.getDriver());
			conn = DriverManager.getConnection(mariaDBConfig.getUrl(), mariaDBConfig.getUsername(),
					mariaDBConfig.getPassword());
			logger.info("Connected database successfully...");
			String sql = "INSERT INTO USER(NAME, SURNAME, VATIN, USERNAME, PASSWORD) VALUES(?,?,?,?,?)";
			stmt = conn.prepareStatement(sql);

			stmt.setString(1, user1.getAnagraphicData().getName());
			stmt.setString(2, user1.getAnagraphicData().getSurname());
			stmt.setString(3, user1.getAnagraphicData().getVatIn());

			stmt.setString(4, user1.getSecurityData().getUsername());
			stmt.setString(5, user1.getSecurityData().getPassword().crypto());
			if (stmt.execute()) {
				// result.setCryptedPassword(user1.getSecurityData().getPassword().crypto());
				// result.setName(user1.getAnagraphicData().getName());
				// result.setVatin(user1.getAnagraphicData().getVatIn());
				// result.setUsername(user1.getSecurityData().getUsername());
				// result.setSurname(user1.getAnagraphicData().getSurname());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			close(conn, stmt);
		}
		return result;
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
