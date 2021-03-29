package net.alepuzio.authsys.domain.user.persistence.hibernate;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.stereotype.Component;

import net.alepuzio.authsys.config.HibernateConfig;
import net.alepuzio.authsys.config.SQLDBConfig;

@Component
@PropertySources({
	@PropertySource("classpath:database/config/${spring.profiles.active}/PersistentAnagraphical.hbm.xml")
	,@PropertySource("classpath:database/config/${spring.profiles.active}/PersistentSecurity.hbm.xml")
	,@PropertySource("classpath:database/config/${spring.profiles.active}/PersistentSingleFactor.hbm.xml")
})

public class SessionBuilder {

	private SessionFactory sessionFactory = buildSessionFactory();
	
    private SessionFactory buildSessionFactory() {
    	
	        Configuration cfg = new Configuration()
	        		.addClass(PersistentSecurity.class)
	        		.addClass(PersistentAnagraphical.class)
	        		.addClass(PersistentSingleFactor.class)
	        		.addProperties(new HibernateConfig().settings())
	        		.configure();
	
	        ServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();
	        return  cfg.buildSessionFactory(sr);
    }


    
    public SessionFactory getSessionFactory() {
    	if(null == sessionFactory){
    		sessionFactory = buildSessionFactory();
    	}
        return sessionFactory;
    }
}