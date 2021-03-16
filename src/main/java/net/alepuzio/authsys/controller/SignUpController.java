package net.alepuzio.authsys.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import net.alepuzio.authsys.domain.user.Generic;
import net.alepuzio.authsys.domain.user.UserService;
import net.alepuzio.authsys.domain.user.elementary.AnagraphicData;
import net.alepuzio.authsys.domain.user.elementary.SecurityData;

@Controller
public class SignUpController {

	@Autowired
	private UserService service;

	private Logger logger = org.slf4j.LoggerFactory.getLogger(this.getClass());

	@RequestMapping(value = "/record", method = RequestMethod.POST)
	public ModelAndView record(@RequestParam Map<String,String >body) {
		Generic userToRecord = new Generic(new AnagraphicData(body), new SecurityData(body));
		logger.info(String.format(">record(%s)", userToRecord.getAnagraphicData().toString()));
		ModelAndView mav = new ModelAndView();
		
		/**
		 * TODO verify it's not recorded already
		 * */
		/**
		 * TODO verify the param are valid
		 * */
		/**
		 * TODO record in mariadb
		 * */
		try {
			Generic persistent = service.save(userToRecord);
			mav.addObject("persistent", persistent);
			mav.setViewName("signup-ok");
		} catch (Exception e) {
			logger.error(e.getMessage());
			mav.addObject("errors", e.getMessage());
			mav.setViewName("signup");
		}
		return mav;
	}

}
