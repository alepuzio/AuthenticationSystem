package net.alepuzio.authsys.config;

import org.slf4j.Logger;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * @overview: it manages the configuation of our application
 */
@Configuration
@EnableWebMvc
@ComponentScan({ "net.alepuzio.mss" })
public class WebApplicationContextConfig implements WebMvcConfigurer {

	private Logger logger = org.slf4j.LoggerFactory.getLogger(this.getClass());

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		logger.info(">configureDefaultServletHandling");
		configurer.enable();
		logger.info("<configureDefaultServletHandling");
	}

	/**
	 * Bean that configures the Resolver cerca le pagine in jsp nella cartella
	 * WEB-INF/view
	 */
	@Bean
	public InternalResourceViewResolver getInternalResourceViewResolver() {
		logger.info(">getInternalResourceViewResolver");
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setViewClass(JstlView.class);
		resolver.setPrefix("/templates/");
		resolver.setSuffix(".html");
		logger.info("<getInternalResourceViewResolver");
		return resolver;
	}

	@Bean
	WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> enableDefaultServlet() {
		logger.info(">enableDefaultServlet");
		return (factory) -> factory.setRegisterDefaultServlet(true);
	}
}
