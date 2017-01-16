package singleton;

/**
 * This implementation works fine in case of single threaded environment.
 * 
 * However, this is not thread-safe and hence should not be used in 
 * multi-threaded environment as two threads might simultaneously check
 * if instance is null or not and may end-up creating two instances of
 * the singleton.
 * 
 * 
 * @author RAsthana
 *
 */
public class LazyInitializedSingleton {

	//NOT instantiated
	private static LazyInitializedSingleton instance;
	
	//private constructor to disable instantiation
	//outside the class
	private LazyInitializedSingleton(){}
	
	public static LazyInitializedSingleton getInstance(){
		if(instance == null){
			instance = new LazyInitializedSingleton();
		}
		return instance;
	}
}
