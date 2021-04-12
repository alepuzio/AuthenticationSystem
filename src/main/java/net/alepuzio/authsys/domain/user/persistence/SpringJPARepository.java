package net.alepuzio.authsys.domain.user.persistence;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import net.alepuzio.authsys.domain.user.Generic;
import net.alepuzio.authsys.domain.user.UserRepository;

@Component
@Profile("spring-jpa")
public class SpringJPARepository implements UserRepository {

	@Override
	public Generic save(Generic user) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Generic user(Generic user) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
