package com.indefsystems.dp.singleton;

import java.io.Serializable;

public class SerializedSingleton implements Serializable{

	private static final long serialVersionUID = 1L;

	//private constructor to disable instantiation
	//outside the class 
	private SerializedSingleton(){}
	
	private static class SingletonHelper{
		private static final SerializedSingleton INSTANCE = new SerializedSingleton();
	}
	
	public static SerializedSingleton getInstance(){
		return SingletonHelper.INSTANCE;
	}
}
