package singleton;

/**
 * Enum singleton overcomes the danger of breaking the singleton pattern
 * using reflection or serialization.
 * It can-not be broken by cloning as clone method is not visible for
 * an enum. if you make it implement Cloneable interface then also
 * you can-not override the clone method as it is declared final.
 * 
 * However, the drawback is that enum type is somewhat inflexible; 
 * for example, it does not allow lazy initialization.
 * 
 * @author RAsthana
 *
 */
public enum EnumSingleton{ //Enums are inherently serialized so no need to implement serializable
	INSTANCE;
	
	public static void doSomething(){
		//do something here
	}
	
}
