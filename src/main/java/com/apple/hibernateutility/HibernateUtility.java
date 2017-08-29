package com.apple.hibernateutility;


import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtility {
	
	static Logger log = Logger.getLogger(HibernateUtility.class.getName());
	
	private static SessionFactory factory=null;
	
	private HibernateUtility (){}
	
	@SuppressWarnings("deprecation")
	public static SessionFactory  getInstance(){
		
		log.info("Creating session factory object from utility ");
		try{
		if (factory==null){
			log.info("BuildSessionFactory is a created using hiberante4.x method ");
			Configuration conf= new Configuration();
			   conf.configure("./Hibernate.cfg.xml");
			   log.info("StandardService class is loaded for registry");
			 StandardServiceRegistryBuilder register= new StandardServiceRegistryBuilder();
			   register.applySettings(conf.getProperties());
			   ServiceRegistry registry=register.build();
			
			factory=conf.buildSessionFactory(registry);
			log.info("Return factory call for session factory");
			
//			factory=new Configuration().configure("com/apple/configuration/Hibernate.cfg.xml").buildSessionFactory();
		
		}return factory;
	}catch(Exception e){
		log.error("Exception in session factory ");
	}return factory;
		
	}

}
