package com.apple.hibernatedao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.apple.beans.Country;
import com.apple.beans.TopicData;
import com.apple.controller.CountryController;
import com.apple.hibernateutility.HibernateUtility;

@Repository
public class CountryDaoImpl implements CountryDao {

	static Logger log = Logger.getLogger(CountryController.class.getName());

	
	
	@Override
	public void addCountry(List<Country> list) {
		log.info("calling addCountry method");
		SessionFactory factory=HibernateUtility.getInstance();
	     Session session =factory.openSession();
	     Transaction tx =session.beginTransaction();
	     Iterator<Country> it =list.iterator();
	     while(it.hasNext()){
	    	 session.save(it.next());
	    	 }
	      tx.commit();
	     session.close();
	     
	
	}

	@Override
	public Country updateCountry(int id, Country c) {
		log.info("calling updateCountry method");
		SessionFactory factory=HibernateUtility.getInstance();
	     Session session =factory.openSession();
	     Transaction tx =session.beginTransaction();
	     Country country =(Country)session.get(Country.class, id);
	     country .setCountryName(c.getCountryName());
	     tx.commit();
	     session.close();
	     log.info("returns  updatedcountry name");
	return country;
	}

	@Override
	public List<Country> listCountries() {
		log.info("calling listCountries method");
		SessionFactory factory=HibernateUtility.getInstance();
	     Session session =factory.openSession();
	     List<Country> countryList = session.createQuery("from Country c").list();
			session.close();
			  log.info("returns list of countries");
			return countryList;
	     
		
	
	}

	@Override
	public Country getCountryById(int id) {
		log.info("calling getCountryById");
		SessionFactory factory=HibernateUtility.getInstance();
	     Session session =factory.getCurrentSession();
	     Country country =(Country)session.load(Country.class, id);
	    session.close();
	    log.info("returns country name");
	     return country;
	}

	@Override
	public void removeCountry(int id) {
		System.out.println(id);
		log.info("calling removeCountry");
		SessionFactory factory=HibernateUtility.getInstance();
	     Session session =factory.openSession();
	     
	     Transaction tx =session.beginTransaction();
	     Country country =(Country)session.load(Country.class, id);
	     
	     session.delete(country);
	     tx.commit();
	     log.info("deletes particular country");
	     session.close();
	     log.info("country has been closed");
	}

	
	public Country getSchedulerById(int id) {
		log.info("calling getSchedulerById");
		SessionFactory factory=HibernateUtility.getInstance();
	     Session session =factory.getCurrentSession();
	     Country country =(Country)session.load(Country.class, id);
	    session.close();
	    log.info("returns country name");
	     return country;
	}

	
public List<TopicData> getTopicData(int id){
		
		
	
	log.info("calling TOPIC DATA method");
	SessionFactory factory=HibernateUtility.getInstance();
    Session session =factory.openSession();
     List<TopicData> topicList = session.createQuery("select T.TOPIC_ID,T.TOPIC_NM,T.APP_ID, from T.GNV_TOPIC Where T.TOPIC_ID=?"+id).list();
		session.close();
		  log.info("returns list of topics");
		
		return topicList;
	}
		
		
	}
	

