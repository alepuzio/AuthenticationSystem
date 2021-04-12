package net.alepuzio.authsys;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages ={"net.alepuzio.authsys"})
@ComponentScan({"net.alepuzio.authsys"})
@EntityScan({
	"net.alepuzio.authsys.domain.user.persistence"
	//, "net.alepuzio.authsys.domain.user.persistence.jpa"
})

@EnableJpaRepositories({
	"net.alepuzio.authsys.domain.user.persistence"
	//,  , "net.alepuzio.authsys.domain.user.persistence.jpa"
})
@PropertySources({
			@PropertySource("classpath:application.properties")
			,@PropertySource("classpath:database/config/${spring.profiles.active}/db.properties")
})
public class AuthSysApplication extends SpringBootServletInitializer {
	public static void main(String[] args) {
		SpringApplication.run(AuthSysApplication.class, args);
	}
	
}
