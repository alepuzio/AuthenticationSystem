package net.alepuzio.authsys.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import net.alepuzio.authsys.domain.user.Generic;
import net.alepuzio.authsys.domain.user.UserService;
import net.alepuzio.authsys.domain.user.elementary.AnagraphicData;
import net.alepuzio.authsys.domain.user.elementary.SecurityData;
import net.alepuzio.authsys.domain.user.persistence.Persistent;

@Controller
public class SignUpController {

	private Logger logger = org.slf4j.LoggerFactory.getLogger(this.getClass());

	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public ModelAndView signup(@RequestParam /*Generic userToRecord*/Map<String,String >body) {
		ModelAndView mav = new ModelAndView();
		Generic userToRecord = new Generic(new AnagraphicData(body), new SecurityData(body));
		logger.info(String.format(">signup(%s)", userToRecord.getAnagraphicData().toString()));
		/**
		 * TODO verify it's not recorded already
		 * */
		/**
		 * TODO verify the param are valid
		 * */
		/**
		 * TODO record in mariadb
		 * */
		UserService service = new UserService();
		try {
			Persistent persistent = service.save(userToRecord);
		} catch (Exception e) {
			logger.error(e.getMessage());
			
		}
		/*Persistent persistent = new Persistent();
		persistent.setName(userToRecord.getAnagraphicData().getName());
		persistent.setSurname(userToRecord.getAnagraphicData().getSurname());
		persistent.setVatin(userToRecord.getAnagraphicData().getVatIn());
		persistent.setUsername(userToRecord.getSecurityData().getUsername());
		persistent.setCryptedPassword(userToRecord.getSecurityData().getPassword().crypto());
		*/
		return mav;
	}

}
