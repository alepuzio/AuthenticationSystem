package net.alepuzio.authsys.domain.user.persistence.hibernate;



import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.criteria.CriteriaBuilder;

import org.apache.log4j.Logger;
import org.hibernate.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import net.alepuzio.authsys.crypto.TrippleDes;
import net.alepuzio.authsys.domain.user.Generic;
import net.alepuzio.authsys.domain.user.elementary.SecurityData;
import net.alepuzio.authsys.domain.user.persistence.UserRepository;

@Component
@Profile("hibernate")
public class HibernateRepository implements UserRepository {

    @PersistenceContext(type = PersistenceContextType.EXTENDED)
	private EntityManager entityManager;
	
	private Logger logger = Logger.getLogger(this.getClass());
	
	@Autowired
	private SessionBuilder sessionBuilder;
	
	@Override
	public Generic save(Generic user) throws Exception {
		entityManager.persist(user);
        logger.info(String.format("Successfully created %s",user.toString()));
        return user;
	}

	//@Override
	public Generic us3er(Generic user) throws Exception {
		logger.info(String.format(">user(%s)",user.toString()));
		try{
			logger.info("entityManager: "+ entityManager);
/*
			CriteriaBuilder criteriaBuilder = this.entityManager.getCriteriaBuilder();
		         CriteriaQuery<Generic> criteria = criteriaBuilder.createQuery(user.getClass());
		         criteria.from(user.getClass());
		         //criteria.

		         TypedQuery<User> query = entityManager.createQuery(criteria);
		         Generic result = query.getSingleResult();*/
		}catch(Exception e){
			logger.error(e);
			throw e;
		}        return user;   
		     }
	
	@Override
	public Generic user(Generic user) throws Exception {
		logger.info(String.format(">user(%s)",user.toString()));
		try{
			logger.info("entityManager: "+ entityManager);
			PersistentSecurity persistent = new PersistentSecurity();
			PersistentSingleFactor factor = new PersistentSingleFactor();
			factor.setPassword(new TrippleDes().encrypt(user.getSecurityData().getPassword().crypto()));
			factor.setUsername(new TrippleDes().encrypt(user.getSecurityData().getUsername()));
			persistent.setId(factor);	
			
			//final Session session = (Session) entityManager.getDelegate();
			final Session session = sessionBuilder.buildSessionFactory().getCurrentSession();
			//CriteriaBuilder builder = entityManager.getCriteriaBuilder();

		    
		    PersistentSecurity a = (PersistentSecurity) session
		    		.createNativeQuery("select * from PersistentSecurity where username = ? and password = ? ")
		    		.addEntity(PersistentSecurity.class)
		    		.setParameter(1, new TrippleDes().encrypt(persistent.getId().getUsername()))
		    		.setParameter(2, new TrippleDes().encrypt(persistent.getId().getPassword()))
		    		.list()
		    		.get(0);
		    
			logger.info("5");
			/*Generic result = new Generic(
					new AnagraphicData(
							found.getName(), 
							found.getSurname(), 
							found.getVatin()
							),
					new SecurityData(
							found.getSingleFactor().getUsername(), found.getSingleFactor().getPassword())
					);*/
			logger.info("risultato: "+ a);
			Generic result = new Generic(null, new SecurityData(a));
			logger.info("6");
			session.close();
			return result;
		}catch(Exception e){
			logger.error(e);
			throw e;
		}
	}

}