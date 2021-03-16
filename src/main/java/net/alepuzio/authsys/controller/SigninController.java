package net.alepuzio.authsys.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import net.alepuzio.authsys.domain.user.UserService;

@Controller
public class SigninController {
		
		private Logger logger = org.slf4j.LoggerFactory.getLogger(this.getClass());

		@RequestMapping(value = "/", method = RequestMethod.GET)
		public ModelAndView home() {
			logger.info("In the application...forward to signin.html");
			ModelAndView mav = new ModelAndView();
			mav.setViewName("signin");
			return mav;
		}

		@RequestMapping(value = "/signin", method = RequestMethod.GET)
		public ModelAndView signin(@RequestParam  String username, @RequestParam String password) {
			logger.info(">signin("+username+","+password+")");
			UserService service = new UserService();
			
			ModelAndView mav = new ModelAndView();
			mav.setViewName("signin");
			logger.info("<signin");
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
