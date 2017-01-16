package singleton;

public class CloningSingletonTest {

	public static void main(String[] args) {
		
		EagerInitializedSingleton instanceOne = EagerInitializedSingleton.getInstance();
		EagerInitializedSingleton instanceTwo = null;
		
		try{
			instanceTwo = (EagerInitializedSingleton)instanceOne.clone();
		}catch(CloneNotSupportedException ex){
			System.out.println("Singleton protected against cloning.");
		}
		
	}
}
