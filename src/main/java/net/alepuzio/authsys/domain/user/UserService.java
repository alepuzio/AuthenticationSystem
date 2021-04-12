package net.alepuzio.authsys.domain.user;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;




/**
 * @overview: this class shows the methods to manage the data in the database,
 * abstracting for the engine (JDBC, ORM, etc)*/
@Component
public class UserService {

	private Logger logger = Logger.getLogger(this.getClass());
	@Autowired
	private UserRepository jdbcRepository;
	
	/**
	 * @return the data of the Generic instance. This instance was not existing in database before calling this method
	 * */
	public Generic save(Generic genericToSave) throws Exception{
		logger.info("save:"+genericToSave);
		logger.info("jdbcrepository:"+jdbcRepository);

		return jdbcRepository.save(genericToSave);
	}
	
	/**
	 * @return the data of the saved Generic. This instance exists in database before calling this method
	 * */	
	public Generic recordedData(Generic genericToRead) throws Exception {
		logger.info("recordedData:"+genericToRead);
		logger.info("jdbcrepository:"+jdbcRepository);
		return jdbcRepository.user(genericToRead);
	}

}
