package net.alepuzio.authsys.domain.user.persistence.hibernate;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import net.alepuzio.authsys.config.database.MariaDBConfig;

@Configuration
//@	EnableTransactionManagement
public class DataSourceBean {
	@Autowired
	private MariaDBConfig mariaDBConfig;

	private Logger logger = Logger.getLogger(this.getClass());

		//TODO verify if delete
	    private final Properties hibernateProperties() {
	        Properties hibernateProperties = new Properties();
	        hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "create-drop");
	        hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
	        return hibernateProperties;
	    }

	    @Bean
    public DataSource dataSource() {
    	logger.debug(">getDataSource");
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName(mariaDBConfig.driver());
        dataSourceBuilder.url(mariaDBConfig.url());
        dataSourceBuilder.username(mariaDBConfig.username());
        dataSourceBuilder.password(mariaDBConfig.password());
        DataSource dataSource = dataSourceBuilder.build();
        logger.debug("getDataSource");
        return dataSource;
    }
    
    
}