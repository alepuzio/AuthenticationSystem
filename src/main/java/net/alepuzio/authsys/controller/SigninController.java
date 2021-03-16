package net.alepuzio.authsys.controller;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import net.alepuzio.authsys.domain.user.Generic;
import net.alepuzio.authsys.domain.user.UserService;
import net.alepuzio.authsys.domain.user.elementary.SecurityData;

@Controller
public class SigninController {

	@Autowired
	private UserService service;
	
		private Logger logger = org.slf4j.LoggerFactory.getLogger(this.getClass());

		@RequestMapping(value = "/", method = RequestMethod.GET)
		public ModelAndView home() {
			logger.info("In the application...forward to signin page");
			ModelAndView mav = new ModelAndView();
			mav.setViewName("signin");
			return mav;
		}

		@RequestMapping(value = "/signin", method = RequestMethod.GET)
		public ModelAndView signin(@RequestParam  String username, @RequestParam String password) {
			logger.info(">signin("+username+","+password+")");
			String viewName = "home";
			Generic userToRead = new Generic(new SecurityData(username,password));
			Generic found = null;
			ModelAndView mav = new ModelAndView();
			String error = null;
			try {
				found = service.recordedData(userToRead);
				mav.addObject("name", found.getAnagraphicData().getName());
			} catch (Exception e) {
				error = e.getMessage();
				logger.error("errors: "+error);
				viewName = "signin";
			}
			mav.addObject("errors", error );
			mav.setViewName(viewName);
			logger.info("<signin("+found+")");
			return mav;
		}

		@RequestMapping(value = "/signup", method = RequestMethod.GET)
		public ModelAndView signup(){
			logger.info(">signup");
			ModelAndView mav = new ModelAndView();
			mav.setViewName("signup");
			logger.info("<signup");
			return mav;
		}

}
