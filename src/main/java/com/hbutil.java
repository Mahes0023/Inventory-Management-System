package com;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class hbutil {

	private static StandardServiceRegistry registry;
	private static SessionFactory sesFactory;
	
	public static SessionFactory getSessionFactory() {
		registry=new StandardServiceRegistryBuilder().configure("hiber.cfg.xml").build();
		Metadata md=new MetadataSources(registry).getMetadataBuilder().build();
		sesFactory=md.buildSessionFactory();
		return sesFactory;
	}
	
}
