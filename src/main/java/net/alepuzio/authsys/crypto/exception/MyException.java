package net.alepuzio.authsys.crypto.exception;

import org.apache.log4j.Logger;
/**
 * @overview: this class concentrate the logic of logging and throw Exception
 * */
public class MyException {

	private Exception e;
	private Logger logger;
	
	public MyException(Exception newException,  Logger newLogger) {
		super();
		this.e = newException;
		this.logger = newLogger;
	}
	
	public MyException error(){
		logger.error(String.format("Exception: %s",  e.getMessage()));
		return this;
	}
	
	public void exception() throws Exception {
		throw e;
	}
	
}
