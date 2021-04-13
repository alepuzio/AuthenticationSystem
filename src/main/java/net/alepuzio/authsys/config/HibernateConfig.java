package net.alepuzio.authsys.config;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("spring-jpa")
public class HibernateConfig {

	private Logger logger = Logger.getLogger(this.getClass());

	@PostConstruct
	public void init() {
		logger.info("caricato");
	}

	@Value("${spring.jpa.properties.hibernate.generate_statistics}")
	private String generateStatistics;
	@Value("${logging.level.org.hibernate.type}")
	private String type;
	@Value("${logging.level.org.hibernate.stat}")
	private String stat;

	@Value("${spring.jpa.ddl}")
	private String ddl;
	@Value("${spring.jpa.show.sql}")
	private String showSql;

	@Value("${hibernate.current_session_context_class}")
	private String currentSessionContextClass;
	@Value("${hibernate.jdbc.lob.non_contextual_creation}")
	private String jdbcLobNonContextualCreation;
	@Value("${hibernate.format_sql}")
	private String format_Sql;

	@Value("${spring.jpa.hibernate.dialect}")
	private String springDialect;

	public Logger getLogger() {
		return logger;
	}

	public String getGenerateStatistics() {
		return generateStatistics;
	}

	public String getType() {
		return type;
	}

	public String getStat() {
		return stat;
	}

	public String getDdl() {
		return ddl;
	}

	public String getShowSql() {
		return showSql;
	}

	public String getCurrentSessionContextClass() {
		return currentSessionContextClass;
	}

	public String getJdbcLobNonContextualCreation() {
		return jdbcLobNonContextualCreation;
	}

	public String getFormat_Sql() {
		return format_Sql;
	}

	public String getSpringDialect() {
		return springDialect;
	}

}
