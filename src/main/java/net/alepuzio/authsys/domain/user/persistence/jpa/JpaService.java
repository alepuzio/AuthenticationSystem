package net.alepuzio.authsys.domain.user.persistence.jpa;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;

import net.alepuzio.authsys.domain.user.Generic;
import net.alepuzio.authsys.domain.user.elementary.AnagraphicData;
import net.alepuzio.authsys.domain.user.elementary.SecurityData;
import net.alepuzio.authsys.domain.user.elementary.cripto.banal.Banal;
import net.alepuzio.authsys.domain.user.elementary.cripto.desede.Desede;
import net.alepuzio.authsys.domain.user.persistence.UserOnDatabase;
import net.alepuzio.authsys.domain.user.persistence.jpa.anagraphic.UserAnagraphic;
import net.alepuzio.authsys.domain.user.persistence.jpa.anagraphic.UserAnagraphicRepository;
import net.alepuzio.authsys.domain.user.persistence.jpa.security.UserSecurity;
import net.alepuzio.authsys.domain.user.persistence.jpa.security.UserSecurityRepository;

@Component
@Profile("spring-jpa")
public class JpaService implements UserOnDatabase {
	
	private Logger logger = Logger.getLogger(this.getClass());

	@Autowired
	private UserAnagraphicRepository userAnagraphicRepository;
	
	@Autowired
	private UserSecurityRepository userSecurityRepository;
	
	@Override
	public Generic save(Generic user) throws Exception {
		final String encryptedVatin  =user.getAnagraphicData().getVatIn().encrypt(); 
		logger.info(String.format(">save(%s)",  encryptedVatin) );
		UserAnagraphic anagraphic = new UserAnagraphic(
				user.getAnagraphicData().getName().encrypt()
				, user.getAnagraphicData().getSurname().encrypt()
				,  encryptedVatin
				);
		userAnagraphicRepository.save(anagraphic);
		logger.info(String.format("<save(%s)",  encryptedVatin) );		
		return user;
	}

	@Override
	public Generic user(Generic user) throws Exception {
		final String encryptedUsername  = user.getSecurityData().getUsername();//.encrypt();
		final String encryptedCrypto  = user.getSecurityData().getPassword().crypto();//.encrypt();
		logger.info(String.format(">user(%s,%s)",  encryptedUsername, encryptedCrypto) );
		UserSecurity userSecurity = userSecurityRepository.findByUsernameAndByPassword(encryptedUsername, encryptedCrypto);	
		UserAnagraphic anagraphic = userAnagraphicRepository.findByVatin(userSecurity.getVatin());
		logger.info(String.format("<user(%s,%s)",  encryptedUsername, encryptedCrypto) );
		return  new Generic(
				new AnagraphicData(
					new Desede(new Banal(anagraphic.getName() ) )
					, new Desede(new Banal(anagraphic.getSurname() ) )
					, new Desede(new Banal(anagraphic.getVatin() ) )
					)
				, new SecurityData(
					userSecurity.getUsername(), 
					userSecurity.getPassword()
					)
				);
	}
	
	@Bean(name="entityManagerFactory")
	public LocalSessionFactoryBean sessionFactory() {
	    LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
	    HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
	    vendorAdapter.setDatabase(Database.MYSQL);
	    vendorAdapter.setGenerateDdl(true);
	    vendorAdapter.setShowSql(true);

	    LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
	    factory.setJpaVendorAdapter(vendorAdapter);
	    factory.setPackagesToScan("net.alepuzio.authsys.domain.user.persistence");
	    //factory.setDataSource(dataSource());
	    factory.setJpaProperties(jpaProperties());
	    return sessionFactory;
	} 
	
	 private Properties jpaProperties() {
		    Properties properties = new Properties();
		    properties.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
		    properties.put("hibernate.show_sql", "true");
		    return properties;
		  }
		  @Bean
		  public PlatformTransactionManager transactionManager() {
		    JpaTransactionManager txManager = new JpaTransactionManager();
		    txManager.setEntityManagerFactory(sessionFactory().getObject());
		    return txManager;
		  }
}
