package net.alepuzio.authsys.domain.user;


//import org.springframework.data.repository.CrudRepository;


public interface UserRepository /*extends CrudRepository<Persistent, Integer>*/{
	//public List<Persistent> findByLastName(String lastName);
	
	//public Persistent save(Generic user1);
	public Generic save(Generic user) throws Exception ;
	
	public Generic user(Generic user) throws Exception ;

}