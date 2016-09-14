package com.indefsystems.dp.singleton;

import java.io.Serializable;

public class SerializedSingletonFixed implements Serializable{

	private static final long serialVersionUID = 1L;

	//private constructor to disable instantiation
	//outside the class 
	private SerializedSingletonFixed(){}
	
	private static class SingletonHelper{
		private static final SerializedSingletonFixed INSTANCE = new SerializedSingletonFixed();
	}
	
	public static SerializedSingletonFixed getInstance(){
		return SingletonHelper.INSTANCE;
	}
	
	protected Object readResolve() {
	    return getInstance();
	}
}
