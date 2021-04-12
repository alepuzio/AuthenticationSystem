package net.alepuzio.authsys.domain.user.persistence.jpa.anagraphic;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;

@Configuration
@EnableJpaRepositories(basePackages = "net.alepuzio.authsys.domain.user.persistence.jpa.anagraphic")
@Profile("spring-jpa")
public interface UserAnagraphicRepository extends CrudRepository<UserAnagraphic, Long>  {

	@SuppressWarnings("unchecked")
	@Override
	public UserAnagraphic save(UserAnagraphic user) ;

	public UserAnagraphic user(UserAnagraphic user) throws Exception ;

	public UserAnagraphic findByVatin(String vatin) throws Exception ;
	
}
