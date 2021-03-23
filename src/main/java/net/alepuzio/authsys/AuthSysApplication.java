package net.alepuzio.authsys;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@SpringBootApplication
@PropertySources({
			@PropertySource("classpath:application.properties")
			,@PropertySource("classpath:database/config/${spring.profiles.active}/db.properties")
})
public class AuthSysApplication extends SpringBootServletInitializer {
	public static void main(String[] args) {
		SpringApplication.run(AuthSysApplication.class, args);
	}

}
