package com.indefsystems.dp.singleton;

/**
 * This implementation is thread-safe. However, this implementation
 * reduces performance due to cost associated with synchronized method.
 * Moreover, synchornization is really needed for the first few threads
 * that might create multiple instances.
 * 
 * To avoid this performance hit, "double checked locking" principle
 * can be used.
 *  
 * @author RAsthana
 *
 */
public class ThreadSafeLazyInitializedSingleton {

	private static ThreadSafeLazyInitializedSingleton instance;
	
	//private constructor to disable instantiation
	//outside the class
	private ThreadSafeLazyInitializedSingleton(){}
	
	public static synchronized ThreadSafeLazyInitializedSingleton getInstance(){
		if(instance == null){
			instance = new ThreadSafeLazyInitializedSingleton();
		}
		return instance;
	}
	
	/**
	 * This method takes care of reduced performance issue related with thread-safe
	 * getter method to get singleton instance.
	 * 
	 * First check if the instance is null (two or more threads might be checking this
	 * at the same time and might find that instance is null). If instance is null then
	 * proceed further, however, in that case further code block is synchronized so
	 * only one thread would be able to proceed further. Now again thread checks if the
	 * instance is null, if the instance is null then a new stance would be created.
	 * However, when the second thread passes through the synchronized block and checks
	 * again if the instance is null or not then it will find the instance already exists 
	 * and will NOT create another instance. 
	 * 
	 * Any further/future threads will at the first check itself will find that instance
	 * already exists so will not have to go through synchronized block and therefore
	 * there will be no further performance cost associated with executing a sychronized
	 * block of code. 
	 * 
	 * 
	 * @return
	 */
	public static ThreadSafeLazyInitializedSingleton getInstanceUsingDoubleCheckedPrinciple(){
		if(instance == null){
			synchronized (ThreadSafeLazyInitializedSingleton.class) {
				if(instance == null){
					instance = new ThreadSafeLazyInitializedSingleton();
				}
			}
		}
		return instance;
	}
}
