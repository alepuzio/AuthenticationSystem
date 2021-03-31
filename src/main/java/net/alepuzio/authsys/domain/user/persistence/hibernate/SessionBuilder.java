package net.alepuzio.authsys.domain.user.persistence.hibernate;


import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.stereotype.Component;

import net.alepuzio.authsys.config.database.HibernateSettings;

@Component
/*
 * @PropertySources({
	@PropertySource("classpath:database/config/${spring.profiles.active}/PersistentAnagraphical.hbm.xml")
	,@PropertySource("classpath:database/config/${spring.profiles.active}/PersistentSecurity.hbm.xml")
	,@PropertySource("classpath:database/config/${spring.profiles.active}/PersistentSingleFactor.hbm.xml")
	
})
*/
public class SessionBuilder {

	private SessionFactory sessionFactory = getSessionFactory();
	
    private SessionFactory buildSessionFactory() {
    	    Configuration cfg = new Configuration()
	        		.addAnnotatedClass(PersistentSecurity.class)
	        		//.addClass(PersistentAnagraphical.class)
	        		.addAnnotatedClass(PersistentSingleFactor.class)
	        		.addProperties(new HibernateSettings().settings())
	        		
	        		.configure();
	        ServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();
	        //sessionFactory.setPackagesToScan("com.baeldung.hibernate.bootstrap.model" );
	        return  cfg.buildSessionFactory(sr);
    }


    
    public SessionFactory getSessionFactory() {
    	if(null == sessionFactory){
    		sessionFactory = buildSessionFactory();
    	}
        return sessionFactory;
    }
}