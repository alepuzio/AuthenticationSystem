package net.alepuzio.authsys.domain.user.persistence.hibernate;


import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.stereotype.Component;

import net.alepuzio.authsys.config.database.HibernateSettings;

@Component
public class SessionBuilder {

//	private SessionFactory sessionFactory = getSessionFactory();//from singleton to cache
	
	@Autowired
	private HibernateSettings hibernateSettings;
	
    public SessionFactory buildSessionFactory() {
    	System.out.println(">buildSessionFactory");
    	    Configuration cfg = new Configuration()
	        		.addAnnotatedClass(PersistentSecurity.class)
	        		//.addClass(PersistentAnagraphical.class)
	        		.addAnnotatedClass(PersistentSingleFactor.class)
	        		//.addProperties(this.hibernateSettings.settings())
	        		.setProperties(this.hibernateSettings.settings())
	        		.configure();
    	    System.out.println("1");
	        ServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();
	        //sessionFactory.setPackagesToScan("com.baeldung.hibernate.bootstrap.model" );
	        System.out.println("<buildSessionFactory");
	        return  cfg.buildSessionFactory(sr);
    }


  /*  
    public SessionFactory getSessionFactory() {
    	if(null == sessionFactory){
    		sessionFactory = buildSessionFactory();
    	}
        return sessionFactory;
    }*/
}