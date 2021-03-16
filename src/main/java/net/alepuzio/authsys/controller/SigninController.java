package net.alepuzio.authsys.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SigninController {
		
		private Logger logger = org.slf4j.LoggerFactory.getLogger(this.getClass());

		@RequestMapping(value = "/", method = RequestMethod.GET)
		public ModelAndView home() {
			logger.info("In the application...forward to login.html");
			ModelAndView mav = new ModelAndView();
			mav.setViewName("signin");
			return mav;
		}

		@RequestMapping(value = "/signin", method = RequestMethod.GET)
		public ModelAndView signin() {
			logger.info(">signin");
			ModelAndView mav = new ModelAndView();
			mav.setViewName("signin");
			logger.info("<signin");
			return mav;
		}
		
}
