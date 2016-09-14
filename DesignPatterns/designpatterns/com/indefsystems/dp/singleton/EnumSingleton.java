package com.indefsystems.dp.singleton;

/**
 * Enum singleton overcomes the danger of breaking the singleton pattern
 * using reflection or serialization.
 * 
 * However, the drawback is that enum type is somewhat inflexible; 
 * for example, it does not allow lazy initialization.
 * 
 * @author RAsthana
 *
 */
public enum EnumSingleton { //Enums are inherently serialized so no need to implement serializable
	INSTANCE;
	
	public static void doSomething(){
		//do something here
	}
}
