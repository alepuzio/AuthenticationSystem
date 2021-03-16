package net.alepuzio.authsys.controller;

import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SignUpController {

	private Logger logger = org.slf4j.LoggerFactory.getLogger(this.getClass());

	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public ModelAndView signup(@RequestParam String number) {
		ModelAndView mav = new ModelAndView();
		logger.info(String.format(">signup(%s)", number));
		return mav;
	}

}
