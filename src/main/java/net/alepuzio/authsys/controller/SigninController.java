package net.alepuzio.authsys.controller;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import net.alepuzio.authsys.crypto.TrippleDes;
import net.alepuzio.authsys.domain.user.Generic;
import net.alepuzio.authsys.domain.user.UserService;
import net.alepuzio.authsys.domain.user.elementary.SecurityData;
/**
 * @return ModelAndView of the record of the data of a new user
 * */

@Controller
public class SigninController {

	@Autowired
	private UserService service;

	private Logger logger = org.slf4j.LoggerFactory.getLogger(this.getClass());
	/**
	 * @return forward to the initial page
	 * */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home() {
		logger.info("In the application...forward to signin page");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("signin");
		return mav;
	}

	/**
	 * @return ModelAndView of the record of the data of an exiting user
	 * */
	@RequestMapping(value = "/signin", method = RequestMethod.GET)
	public ModelAndView signin(@RequestParam String username, @RequestParam String password) {
		Generic found = null;
		ModelAndView mav = new ModelAndView();
		String error = null;
		String viewName = "home";
		Generic userToRead = new Generic(new SecurityData(username, password));
		try {
			logger.info(String.format(">signin(%s,%s)", new TrippleDes().encrypt(username),
					new TrippleDes().encrypt(password)));
			logger.info("service:"+service);
			found = service.recordedData(userToRead);
			mav.addObject("name", new TrippleDes().decrypt(found.getAnagraphicData().getName()));
			mav.addObject("surname", new TrippleDes().decrypt(found.getAnagraphicData().getSurname()));
			mav.addObject("vatin", new TrippleDes().decrypt(found.getAnagraphicData().getVatIn()));
			mav.addObject("username", new TrippleDes().decrypt(found.getSecurityData().getUsername()));
			logger.info(String.format("<signin(%s,%s)", new TrippleDes().encrypt(username),
					new TrippleDes().encrypt(password)));
		} catch (Exception e) {
			error = e.getMessage();
			logger.error("errors: " + error);
			viewName = "signin";
		}
		mav.addObject("errors", error);
		mav.setViewName(viewName);
		return mav;
	}
	
	/**
	 * @return forward to the signup page 
	 * */
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public ModelAndView signup() {
		logger.info(">signup");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("signup");
		logger.info("<signup");
		return mav;
	}

}
