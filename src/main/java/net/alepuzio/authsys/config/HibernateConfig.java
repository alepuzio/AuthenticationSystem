package net.alepuzio.authsys.config;

import java.util.Properties;

import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HibernateConfig {
    
	@Autowired
	private SQLDBConfig dbConfig;

    public Properties settings(){
    	Properties settings = new Properties();
        settings.put(Environment.DRIVER, dbConfig.driver());
        settings.put(Environment.URL, dbConfig.url());
        settings.put(Environment.USER, dbConfig.username());
        settings.put(Environment.PASS, dbConfig.password());
        settings.put(Environment.DIALECT, dbConfig.dialect());
        settings.put(Environment.SHOW_SQL, dbConfig.showSQL());
        settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, dbConfig.thread());
        settings.put(Environment.HBM2DDL_AUTO, "create-drop");//TODO fix new variable
        settings.put("hibernate.dbcp.initialSize", 5);
        settings.put("hibernate.dbcp.maxTotal",20);
        settings.put("hibernate.dbcp.maxIdle",10);
        settings.put("hibernate.dbcp.minIdle",5);
        settings.put("hibernate.dbcp.maxWaitMillis",-1);
        return settings;
    }
}
