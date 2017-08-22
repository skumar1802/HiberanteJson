package com.apple.hibernatedao;

import org.apache.log4j.Logger;

public class CountryDaoFactory {
	
	static Logger log = Logger.getLogger(CountryDaoFactory.class.getName());
	
	
	public static CountryDao getFactory(){
		
		log.info("entered into getFactory method");
		
		return new CountryDaoImpl();
	}

}
