package com.indefsystems.dp.dao;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public enum JPAPersistenceManager {
	INSTANCE;
	
	private EntityManagerFactory emFactory;
	
	private JPAPersistenceManager() {
		
		Thread.currentThread().setContextClassLoader(new ClassLoader() {

			@Override
			public Enumeration<URL> getResources(String name) throws IOException {
				
				if(name.endsWith("META-INF/persistence.xml")){
					return Collections.
							enumeration(Arrays.asList(new File("designpatterns/com/indefsystems/dp/dao/resources/META-INF/persistence.xml").
							toURI().toURL()));
				}
				
				return super.getResources(name);
			}
		});
		
		// "jpa-example" was the value of the name attribute of the 
		// the persistence-unit element.
		emFactory = Persistence.createEntityManagerFactory("jpa-example");
	}
	
	public EntityManager getEntityManager(){
		return emFactory.createEntityManager();
	}
	
	public void close(){
		emFactory.close();
	}
}
