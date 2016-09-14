package com.indefsystems.dp.singleton;

/**
 * Prior to Java 5, java memory model had a lot of issues and other
 * approaches used to fail in certain scenarios where too many threads
 * try to get the instance of the Singleton class simultaneously.
 * 
 * Bill Pugh came up with a different approach to create the Singleton
 * class using "inner static class". This class demonstrates Bill Pugh's
 * Singleton implementation.
 * 
 * This is a widely used approach for Singleton class as it does NOT
 * require synchronization.
 * 
 * JLS guarantees that a class is only loaded when its used for the first time
 * (making the singleton initialization lazy), and that the class loading is 
 * thread-safe (making the getInstance method thread-safe as well) 
 * 
 * @author RAsthana
 *
 */
public class BillPughSingleton {

	//private constructor to disable instantiation
	//outside the class	
	private BillPughSingleton(){}
	
	/*
	 * 'private static inner class' contains the instance of the singleton
	 * class. When the singleton class(BillPughSingleton) is loaded, the
	 * static inner class(SingletonHelper) is NOT automatically loaded into memory.
	 * 
	 * static inner class(SingletonHelper) is loaded into memory ONLY when
	 * getInstance() method is called and its then that singleton class
	 * instance gets created.
	 */
	private static class SingletonHelper{
		private static final BillPughSingleton INSTANCE = new BillPughSingleton();
	}
	
	/*
	 * JVM holds the holder class when getInstance is called for the first time.
	 * If another thread calls getInstance() concurrently, JVM will not load the
	 * holder class second time. It will wait for the first thread to have 
	 * completed the class loading, and at the end of the loading and initialization
	 * of the holder class, both threads will see the holder class properly
	 * initialized and thus containing the unique singleton instance.
	 */
	public static BillPughSingleton getInstance(){
		return SingletonHelper.INSTANCE;
	}
}
