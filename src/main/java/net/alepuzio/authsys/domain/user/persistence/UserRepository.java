package net.alepuzio.authsys.domain.user.persistence;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import net.alepuzio.authsys.domain.user.Generic;

/**
 * @FEATURE_ORM@ draft to using Spring Data as ORM
 */
@Component
@Repository
public interface UserRepository extends CrudRepository {
	
	public Generic save(Generic user) throws Exception ;
	
	public Generic user(Generic user) throws Exception ;

}