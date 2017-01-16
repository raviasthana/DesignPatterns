package singleton;

import java.lang.reflect.Constructor;

public class ReflectionSingletonTest {

	public static void main(String[] args) {
		
		EagerInitializedSingleton instanceOne = EagerInitializedSingleton.
															getInstance();
		EagerInitializedSingleton instanceTwo = null;
		try{
			Constructor[] constructors = EagerInitializedSingleton.class.
												getDeclaredConstructors(); 
			for(Constructor constructor : constructors){
				//below code destroys the singleton pattern
				constructor.setAccessible(true);
				instanceTwo = (EagerInitializedSingleton)constructor.newInstance();
				break;
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		System.out.println("instanceOne hashCode=" + instanceOne.hashCode());
		System.out.println("instanceTwo hashCode=" + instanceTwo.hashCode());
		if(instanceOne.hashCode() != instanceTwo.hashCode()){
			System.out.println("ALERT!ALERT! - Singleton BROKEN by REFLECTION!!!");
		}
	}
}
