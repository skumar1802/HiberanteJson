package com.apple.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.apple.beans.Country;
import com.apple.controller.CountryController;
import com.apple.hibernatedao.CountryDao;

@Service
public class CountryService {

	
	@Autowired(required=true)
	private CountryDao countrydao;
	
	static Logger log = Logger.getLogger(CountryService.class.getName());
	
//	@Scheduled(cron = "0/10 * * * * ?")
	public void SchedulerTime(){
		
		countrydao.listCountries();
		
     System.out.println("in the scheduler");
	}
}