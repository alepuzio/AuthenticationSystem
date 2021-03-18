package net.alepuzio.authsys.controller;

import java.sql.SQLException;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import net.alepuzio.authsys.crypto.TrippleDes;
import net.alepuzio.authsys.crypto.exception.MyException;
import net.alepuzio.authsys.domain.user.Generic;
import net.alepuzio.authsys.domain.user.UserService;
import net.alepuzio.authsys.domain.user.elementary.AnagraphicData;
import net.alepuzio.authsys.domain.user.elementary.SecurityData;

/**
 * @overview: class the manage the signup/registration of a new user
 * */
@Controller
public class SignUpController {

	@Autowired
	private UserService service;

	private Logger logger = Logger.getLogger(this.getClass());

	/**
	 * @return ModelAndView of the record of the data of a new user
	 * */
	@RequestMapping(value = "/record", method = RequestMethod.POST)
	public ModelAndView record(@RequestParam Map<String,String >body) {
		ModelAndView mav = new ModelAndView();
		Generic userToRecord = null;
		try {
			logger.info(String.format(">record(%s)", new TrippleDes().encrypt(body.toString())));
			validation(body);
			userToRecord = new Generic(new AnagraphicData(body), new SecurityData(body));
			Generic persistent = service.save(userToRecord);
			mav.addObject("username", persistent.getSecurityData().getUsername());			
			mav.addObject("name", persistent.getAnagraphicData().getName());
			mav.addObject("surname", persistent.getAnagraphicData().getSurname());
			mav.addObject("vatin", persistent.getAnagraphicData().getVatIn());
			mav.setViewName("home");
			logger.info(String.format("<record(%s)", new TrippleDes().encrypt(body.toString())));
		} catch (SQLException sqlException){
			String msg = null;
			if ( sqlException.getMessage().contains("Duplicate entry") ) {
				msg = String.format("The VAT IN of the user [%s] is already recorded, you can't record more than one user",userToRecord.getSecurityData().getUsername());
			} else {
				msg = sqlException.getMessage();
			}
			new MyException(sqlException,logger).error();
			mav.addObject("errors", msg);
			mav.setViewName("signup");
		} catch (Exception e) {
			new MyException(e,logger).error();
			mav.addObject("errors", e.getMessage());
			mav.setViewName("signup");
		}
		return mav;
	}
	/**
	 * @overview: this method controls the data
	 * */
	private void validation(Map<String, String> body) throws Exception {
		final String password = body.get("password");
		final String repeatPassword = body.get("repeatedPassword");
		if(StringUtils.isEmpty(password) ||StringUtils.isEmpty(repeatPassword)){
			throw new Exception("Please fill both the password's fields");
		}  else if ( !password.trim().equals(repeatPassword.trim()) ){
			throw new Exception(String.format("The password [%s] and [%s] don't match", password, repeatPassword));
		}
	}

}
