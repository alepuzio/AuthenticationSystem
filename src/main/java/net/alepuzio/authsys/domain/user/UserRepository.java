package net.alepuzio.authsys.domain.user;

import net.alepuzio.authsys.domain.user.persistence.Persistent;

//import org.springframework.data.repository.CrudRepository;


public interface UserRepository /*extends CrudRepository<Persistent, Integer>*/{
	//public List<Persistent> findByLastName(String lastName);
	
	//public Persistent save(Generic user1);
	public Persistent save(Generic user1) throws Exception ;
}