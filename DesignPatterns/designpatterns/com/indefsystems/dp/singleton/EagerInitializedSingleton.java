package com.indefsystems.dp.singleton;

/**
 * This is a simple implementation of singleton pattern.
 * However, the drawback in this implementation is that the singleton
 * instance is already created whether client application uses it or not.
 * 
 * If singleton class in NOT using lot of resources then this implementation
 * can be used. However, if singleton class uses memory intensive resource
 * then we should avoid instantiation until the client really calls the 
 * getInstance method, which would mean a lazy initialization.
 * 
 * Another drawback is that this method does not provide an option for 
 * exception handling.
 * 
 * @author RAsthana
 *
 */
public class EagerInitializedSingleton implements Cloneable { 
	//A singleton should NOT implement Cloneable interface, but just for demonstration
	//purposes, if for any reason Cloneable is implemented by the singleton
	//then override clone method to throw CloneNotSupportedException

	
	private static EagerInitializedSingleton instance = new EagerInitializedSingleton();
	
	//private constructor to disable instantiation
	//outside the class 
	private EagerInitializedSingleton(){}
	
	//global access point for singleton instance to outer world
	public static EagerInitializedSingleton getInstance(){
		return instance;
	}
	
	@Override
	//As this is a singleton, protect against breaking the singleton
	//by cloning by throwing CloneNotSupportedException
	protected Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException("Cloning of a singleton is not permitted");
	}
}
