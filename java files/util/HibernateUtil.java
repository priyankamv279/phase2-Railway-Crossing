package com.example.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {

	static StandardServiceRegistry ssr=null;

	static Metadata md=null;
	static SessionFactory sf=null;
	static Session s=null;
	public static Session dbConn() {
		//loads the hibernate.cfg.xml file
		ssr=new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		//in the file start reading the tags 		
		md=new MetadataSources(ssr).getMetadataBuilder().build();	
		//go to session factory and read the tags 		
		sf=md.getSessionFactoryBuilder().build();
		//all the crud operations need to be done in session
		return sf.openSession();

	}
}