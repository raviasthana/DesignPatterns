package com.indefsystems.dp.singleton;

/**
 * Enum singleton overcomes the danger of breaking the singleton pattern
 * using reflection.
 * 
 * However, the drawback is that enum type is somewhat inflexible; 
 * for example, it does not allow lazy initialization.
 * 
 * @author RAsthana
 *
 */
public enum EnumSingleton {
	INSTANCE;
	
	public static void doSomething(){
		//do something here
	}
}
