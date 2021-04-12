package net.alepuzio.authsys.domain.user.persistence;

import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import net.alepuzio.authsys.domain.user.Generic;
import net.alepuzio.authsys.domain.user.UserRepository;

@Component
@Profile("spring-jpa")
public interface SpringJPARepository extends JpaRepository<Generic, Long>  {

	@Override
	public Generic save(Generic user)  ;

	public Generic user(Generic user) throws Exception ;

}
