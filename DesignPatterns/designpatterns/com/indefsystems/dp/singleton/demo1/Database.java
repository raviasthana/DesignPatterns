package com.indefsystems.dp.singleton.demo1;

public class Database {

	private static Database instance = new Database();
	
	private Database(){
	}
	
	public static Database getInstance(){
		return instance;
	}
	
	public void connect(){
		System.out.println("Connected to database");
	}
	
	public void disconnect(){
		System.out.println("Disconnected");
	}
	
	/*
	 * Old way of using singleton
	 * This is not a thread-safe way to use singleton
	 * it is possible that two threads access the getInstanceOld()
	 * method at the same time and might find instanceOld to be null
	 * and both of them will end up creation and instance of database.
	 * Which will result in two instance of the database object and not one. 
	 
	 ** to make it thread safe of-course you can use synchronized keyword
	 *	in the method declaration 
	 *	i.e. public static synchronized Database getInstanceOld(){}
	 *	however this is not very performing implementation
	 ** use double checked locking implementation for better performance 
	 
	private static Database instanceOld;
	public static Database getInstanceOld(){
		if(instanceOld == null){
			instanceOld = new Database();
		}
		return instanceOld;
	}*/
}
