package net.alepuzio.authsys.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import net.alepuzio.authsys.config.HibernateConfig;
import net.alepuzio.authsys.config.MariaDBConfig;

@Component
@Profile("spring-jpa")
@EnableTransactionManagement
public class JpaConfig {

	@PersistenceUnit
	private EntityManagerFactory entityManagerFactory;

	@Autowired
	private MariaDBConfig mariaDBConfig;
	
	@Autowired
	private HibernateConfig hibernateConfig;

	private Logger logger = Logger.getLogger(this.getClass());


	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		factory.setJpaVendorAdapter(vendorAdapter());
		factory.setPackagesToScan("net.alepuzio.authsys.domain.user.persistence.jpa");
		factory.setDataSource(dataSource());
		factory.setJpaProperties(jpaProperties());
		return factory;
	}



	@Bean
	public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(emf);
		return transactionManager;
	}

	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}

	
	private HibernateJpaVendorAdapter vendorAdapter() {
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		logger.info("hibernateConfig e' caricato? "+ (null != hibernateConfig));
		vendorAdapter.setDatabase(Database.MYSQL);
		if(null != hibernateConfig){
			logger.info(Boolean.getBoolean(hibernateConfig.getDdl()));
			vendorAdapter.setGenerateDdl(Boolean.getBoolean(hibernateConfig.getDdl()));
			logger.info(hibernateConfig.getShowSql());
			vendorAdapter.setShowSql(Boolean.getBoolean(hibernateConfig.getShowSql()));
		}
		return vendorAdapter;
	}

	private Properties jpaProperties() {
		Properties properties = new Properties();
		properties.put("spring.jpa.hibernate.dialect", hibernateConfig.getSpringDialect());
		properties.put("spring.jpa.show.sql", Boolean.getBoolean(hibernateConfig.getShowSql()));
		properties.put("hibernate.dialect", hibernateConfig.getSpringDialect());
		properties.put("spring.jpa.properties.hibernate.generate_statistics", hibernateConfig.getGenerateStatistics());
		properties.put("logging.level.org.hibernate.type", hibernateConfig.getType());
		properties.put("logging.level.org.hibernate.stat", hibernateConfig.getStat());
		properties.put("hibernate.hbm2ddl.auto", Boolean.getBoolean(hibernateConfig.getDdl()));
		properties.put("hibernate.current_session_context_class", hibernateConfig.getCurrentSessionContextClass());
		properties.put("hibernate.jdbc.lob.non_contextual_creation", hibernateConfig.getJdbcLobNonContextualCreation());
		properties.put("hibernate.format_sql", Boolean.getBoolean(hibernateConfig.getFormat_Sql()));
		return properties;
	}


	
	@Bean
	public DataSource dataSource(){
	    DriverManagerDataSource dataSource = new DriverManagerDataSource();
	    dataSource.setDriverClassName(mariaDBConfig.getDriver());
	    dataSource.setUrl(mariaDBConfig.getUrl());
	    dataSource.setUsername( mariaDBConfig.getUsername());
	    dataSource.setPassword( mariaDBConfig.getPassword());
	    return dataSource;
	}
	

	
	
}
