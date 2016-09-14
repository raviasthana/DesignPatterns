package com.indefsystems.dp.singleton;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;

public class EnumSingletonTest {
	
	public static void main(String[] args) 
		throws FileNotFoundException, ClassNotFoundException, IOException {
		//test to prove that Enum singleton cannot be broken by reflection
		runEnumSingletonReflectionTest();
		//test to prove that Enum singleton cannot be broken by serialization
		runEnumSingletonSerializationTest();
	}
	
	private static void runEnumSingletonReflectionTest(){
		
		EnumSingleton instanceOne = EnumSingleton.INSTANCE;
		EnumSingleton instanceTwo = null;
		
		try{
			Constructor[] constructors = EnumSingleton.class.getDeclaredConstructors();
			for(Constructor constructor : constructors){
				constructor.setAccessible(true);
				instanceTwo = (EnumSingleton)constructor.newInstance();
				break;
			}
		}catch(Exception ex){
			if(ex instanceof IllegalArgumentException){
				if(ex.getMessage().indexOf("Cannot reflectively create enum objects") > -1){
					System.out.println("EnumSingleton is NOT BROKEN by reflection.");
				}
			}
		}
		
		if(instanceTwo != null && (instanceOne.hashCode() != instanceTwo.hashCode())){
			System.out.println("EnumSingleton is NOT BROKEN by reflection.");
		}		
	}
	
	private static void runEnumSingletonSerializationTest() 
		throws FileNotFoundException, IOException, ClassNotFoundException{
		
		EnumSingleton instanceOne = EnumSingleton.INSTANCE;
		EnumSingleton instanceTwo = null;
		
		ObjectOutput out = new ObjectOutputStream(new FileOutputStream("enumSerialized.ser"));
		out.writeObject(instanceOne);
		out.close();
		
		//deserialize from file to object
		ObjectInput in = new ObjectInputStream(new FileInputStream("enumSerialized.ser"));
		instanceTwo = (EnumSingleton)in.readObject();
		in.close();

		System.out.println("instanceOne hashCode=" + instanceOne.hashCode());
		System.out.println("instanceTwo hashCode=" + instanceTwo.hashCode());
		if(instanceOne.hashCode() == instanceTwo.hashCode()){
			System.out.println("EnumSingleton NOT BROKEN by SERIALIZATION!!!");
		}else{
			System.out.println("ALERT!ALERT! - EnumSingleton BROKEN by SERIALIZATION!!!");
		}
	}
	
	private static void runEnumSingletonCloneTest(){
		EnumSingleton instanceOne = EnumSingleton.INSTANCE;
	}
}
