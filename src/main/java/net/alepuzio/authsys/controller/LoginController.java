package net.alepuzio.authsys.controller;

import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
		
		private Logger logger = org.slf4j.LoggerFactory.getLogger(this.getClass());

		@RequestMapping(value = "/", method = RequestMethod.GET)
		public ModelAndView home() {
			logger.info("In the application...forward to login.html");
			ModelAndView mav = new ModelAndView();
			mav.setViewName("index");
			return mav;
		}

}
