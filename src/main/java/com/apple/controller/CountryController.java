
package com.apple.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.apple.beans.Country;
import com.apple.beans.TopicData;
import com.apple.hibernatedao.CountryDao;
import com.apple.service.CountryService;

@RestController
public class CountryController {

	@Autowired(required=true)
	private CountryDao countrydao;
	
	@Autowired(required=true)
	private CountryService countryService;
	
	
	static Logger log = Logger.getLogger(CountryController.class.getName());
    
	@RequestMapping(value = "/countries", method = RequestMethod.GET, headers = "Accept=application/json")
	
	public List<Country> getCountries() {
		
//		countryService.SchedulerTime();
		
		log.info("entered into getCountries method");
		List<Country>	countriesList=countrydao.listCountries();
		log.info("fetching response for all countries name");
//		List<Country> listOfCountries = new ArrayList<Country>();
//		listOfCountries = createCountryList();
		log.info("returning all countries name");
		return countriesList;
	}

	@RequestMapping(value = "/country/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public Country getCountryById(@PathVariable int id) {
		//List<Country> listOfCountries = new ArrayList<Country>();
		List<Country>listOfCountries=countrydao.listCountries();
       try{
		for (Country country : listOfCountries) 
			if (country.getId() == id){
				log.info("country id exits in the DB");
				return country;	
			}else{
				log.info("Country Id doesnt exits in DB");
			}
       }catch(Exception e){
			
			log.error("Exception occured with in fetching country");
			}
      
       return null;
	}
	
	
	@RequestMapping(value = "/updatecountry/{id}", method = RequestMethod.PUT,consumes=MediaType.APPLICATION_JSON_VALUE)
	public Country updateCountryById(@PathVariable int id,@RequestBody Country country) {
		log.info("Calling updatecountry method ");
		log.info(country.toString());
		Country con=countrydao.updateCountry(id,country);
		
		log.info(" returning updated country");
		      return con;
	}
	
	@RequestMapping(value = "/addcountry", method = RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody
	   void   addCountry(@RequestBody List<Country> list) {
		log.info("Calling addcountry method ");
		countrydao.addCountry(list); 
		log.info("new country is added ");
		
	}
	
	@RequestMapping(value = "/deletecountry/{id}", method = RequestMethod.DELETE)
	public List<Country> deleteById(@PathVariable int id){
		countrydao.removeCountry(id);
		
			 List<Country> listOfCountries=countrydao.listCountries();
				
	       return listOfCountries;
	}
	
	
	@RequestMapping(value = "/topicdata/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public TopicData getTopicById(@PathVariable int id) {
		//List<Country> listOfCountries = new ArrayList<Country>();
		
		
		
		List<TopicData>listOftopics=countrydao.getTopicData(id);
       try{
		for (TopicData data : listOftopics) 
			if (data.TOPIC_ID == id){
				log.info("topic id exits in the DB");
				return data;	
			}else{
				log.info("topic Id doesnt exits in DB");
			}
       }catch(Exception e){
			
			log.error("Exception occured with in fetching country");
			}
      
       return null;
	
	
	}




}
