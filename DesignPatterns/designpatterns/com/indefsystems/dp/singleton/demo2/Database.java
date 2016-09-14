package com.indefsystems.dp.singleton.demo2;

/**
 * As of java 5, enums are the preferred way to create singleton pattern
 * as java ENSURES that any enum variable is instantiated once and only once.
 * 
 * Enum provides safety against reflection and cloning hacks
 * 
 * However, down side is that this implementation does not allow
 * lazy initialisation.
 * 
 * @author RAsthana
 *
 */
public enum Database {
	INSTANCE;
	
	public void connect(){
		System.out.println("Connected to database!");
	}
	
	public void disconnect(){
		System.out.println("Disconnected!");
	}
}
