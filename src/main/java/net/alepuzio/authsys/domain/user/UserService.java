package net.alepuzio.authsys.domain.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.alepuzio.authsys.domain.user.persistence.UserRepository;
/**
 * @overview: this class shows the methods to manage the data in the database,
 * abstracting for the engine (JDBC, ORM, etc)*/
@Component
public class UserService {

	@Autowired
	private UserRepository jdbcRepository;
	
	/**
	 * @return the data of the Generic instance. This instance was not existing in database before calling this method
	 * */
	public Generic save(Generic genericToSave) throws Exception{
		return jdbcRepository.save(genericToSave);
	}
	
	/**
	 * @return the data of the saved Generic. This instance exists in database before calling this method
	 * */	
	public Generic recordedData(Generic genericToRead) throws Exception {
		return jdbcRepository.user(genericToRead);
	}

}
