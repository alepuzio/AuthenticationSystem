package net.alepuzio.authsys.domain.user.persistence.jpa.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;

@Profile("spring-jpa")
@Configuration
@EnableJpaRepositories(basePackages = "net.alepuzio.authsys.domain.user.persistence.jpa.security")
public interface UserSecurityRepository extends CrudRepository<UserSecurity, Long> {

	UserSecurity findByUsernameAndByPassword(String username, String password);
	
}