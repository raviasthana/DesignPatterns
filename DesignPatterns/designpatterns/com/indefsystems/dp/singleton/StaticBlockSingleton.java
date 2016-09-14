package com.indefsystems.dp.singleton;

/**
 * This implementation is similar to eager initialization, except that instance
 * of class is created in the static block that provides option for exception handling.
 * 
 * @author RAsthana
 *
 */
public class StaticBlockSingleton {

	private static StaticBlockSingleton instance;
	
	//static block initialization for exception handling
	static{
		try{
			instance = new StaticBlockSingleton();
		}catch(Exception ex){
			throw new RuntimeException("Exception occurred in creating singleton instance");
		}
	}
	
	//private constructor to disable instantiation
	//outside the class 
	private StaticBlockSingleton(){}
	
	public static StaticBlockSingleton getInstance(){
		return instance;
	}
}
