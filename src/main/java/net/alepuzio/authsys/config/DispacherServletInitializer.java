package net.alepuzio.authsys.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

import org.springframework.stereotype.Controller;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

/**
 * @overview: this class represent the configuration of the Spring Boot
 * */
@Controller
public class DispacherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
	private TemplateEngine templateEngine;

	@Override
	protected Class<?>[] getRootConfigClasses() {
		logger.debug(">getRootConfigClasses");
		return null;
	}

	/**
	 * */
	@Override
	protected Class<?>[] getServletConfigClasses() {
		logger.debug(">getServletConfigClasses");
		return new Class[] { WebApplicationContextConfig.class };
	}

	/**
	 * 
	 * It manages the request to our application
	 */
	@Override
	protected String[] getServletMappings() {
		logger.debug(">getServletMappings");
		return new String[] { "/" };
	}

	/**
	 * It works as web.xml
	 */
	@Override
	public void onStartup(ServletContext servletContext) {
		logger.debug(">onStartup");
		// Load Spring web application configuration
		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
		context.register(WebApplicationContextConfig.class);
		// Create and register the DispatcherServlet
		ServletRegistration.Dynamic registration = servletContext.addServlet("authsys", new DispatcherServlet(context));
		registration.setLoadOnStartup(1);
		registration.addMapping("/authsys/*");

		this.templateEngine = new TemplateEngine();
		this.templateEngine.setTemplateResolver(templateResolver(servletContext));
	}

	public ServletContextTemplateResolver templateResolver(ServletContext servletContext) {
		ServletContextTemplateResolver templateResolver = new ServletContextTemplateResolver(servletContext);
		/*
		 * where is the directory with the files to render
		 * */
		templateResolver.setPrefix("/templates/");
		templateResolver.setSuffix(".jsp");
		templateResolver.setTemplateMode(TemplateMode.HTML);
		templateResolver.setCharacterEncoding("UTF-8");
		/* this is important. This way spring
		 boot will listen to both places 0 and 1*/
		templateResolver.setOrder(0); 
		templateResolver.setCheckExistence(true);
		templateResolver.setCacheTTLMs(Long.valueOf(3600000L));

		/* Cache is set to true by default. Set to false if you want templates
		 to be automatically updated when modified.*/
		templateResolver.setCacheable(false);
		
		return templateResolver;
	}

}
