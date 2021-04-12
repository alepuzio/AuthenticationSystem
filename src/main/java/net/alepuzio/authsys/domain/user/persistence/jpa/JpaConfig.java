package net.alepuzio.authsys.domain.user.persistence.jpa;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaSessionFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;

import net.alepuzio.authsys.config.MariaDBConfig;

@Component
@Profile("spring-jpa")
public class JpaConfig {

/*	@PersistenceUnit
	private EntityManagerFactory emf;
*/
	@Autowired
	private MariaDBConfig mariaDBConfig;

	private Logger logger = Logger.getLogger(this.getClass());

	@Bean
	public DataSource dataSource() {
		EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
		return builder.setType(EmbeddedDatabaseType.HSQL).build();
	}

	@Bean(name = "entityManagerFactory")
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		vendorAdapter.setDatabase(Database.MYSQL);
		vendorAdapter.setGenerateDdl(Boolean.getBoolean(mariaDBConfig.getDdl()));
		vendorAdapter.setShowSql(Boolean.getBoolean(mariaDBConfig.getShowSql()));

		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		factory.setJpaVendorAdapter(vendorAdapter);
		factory.setPackagesToScan("net.alepuzio.authsys.domain.user.persistence");
		// factory.setDataSource(dataSource());
		factory.setJpaProperties(jpaProperties());
		return sessionFactory;
	}

	private Properties jpaProperties() {
		Properties properties = new Properties();
		properties.put("spring.jpa.hibernate.dialect", mariaDBConfig.getSpringDialect());
		properties.put("spring.jpa.show.sql", Boolean.getBoolean(mariaDBConfig.getShowSql()));
		properties.put("hibernate.dialect", mariaDBConfig.getSpringDialect());
		return properties;
	}

//	@Bean
//	public PlatformTransactionManager transactionManager() {
//		JpaTransactionManager txManager = new JpaTransactionManager();
//		txManager.setEntityManagerFactory(sessionFactory().getObject());
//		return txManager;
//	}

//	@Bean
//	public HibernateJpaSessionFactoryBean sessionFactory(EntityManagerFactory emf) {
//		HibernateJpaSessionFactoryBean factory = new HibernateJpaSessionFactoryBean();
//		factory.setEntityManagerFactory(emf);
//		return factory;
//	}

	// protected SessionFactory getSessionFactory() {
	// return emf.unwrap(SessionFactory.class);
	// }
}
