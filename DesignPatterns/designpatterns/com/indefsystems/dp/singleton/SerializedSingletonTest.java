package com.indefsystems.dp.singleton;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

public class SerializedSingletonTest {

	public static void main(String[] args) 
			throws FileNotFoundException, IOException, ClassNotFoundException {
		
		//singleton BROKEN by serialization 
		runBrokenSerializedSingletonTest();
		//singleton FIXED even when serialized
		runFixedSerializedSingletonTest();
	}
	
	private static void runBrokenSerializedSingletonTest()
		throws FileNotFoundException, IOException, ClassNotFoundException {
		
		SerializedSingleton instanceOne = SerializedSingleton.getInstance();
		ObjectOutput out = new ObjectOutputStream(new FileOutputStream("filename.ser"));
		
		out.writeObject(instanceOne);
		out.close();
		
		//deserialize from file to object
		ObjectInput in = new ObjectInputStream(new FileInputStream("filename.ser"));
		SerializedSingleton instanceTwo = (SerializedSingleton)in.readObject();
		in.close();
		
		System.out.println("instanceOne hashCode=" + instanceOne.hashCode());
		System.out.println("instanceTwo hashCode=" + instanceTwo.hashCode());
		if(instanceOne.hashCode() != instanceTwo.hashCode()){
			System.out.println("ALERT!ALERT! - SerializedSingleton BROKEN by SERIALIZATION!!!");
		}		
	}
	
	private static void runFixedSerializedSingletonTest()
			throws FileNotFoundException, IOException, ClassNotFoundException {
			
			SerializedSingletonFixed instanceOne = SerializedSingletonFixed.getInstance();
			ObjectOutput out = new ObjectOutputStream(new FileOutputStream("filename2.ser"));
			
			out.writeObject(instanceOne);
			out.close();
			
			//deserialize from file to object
			ObjectInput in = new ObjectInputStream(new FileInputStream("filename2.ser"));
			SerializedSingletonFixed instanceTwo = (SerializedSingletonFixed)in.readObject();
			in.close();
			
			System.out.println("instanceOne hashCode=" + instanceOne.hashCode());
			System.out.println("instanceTwo hashCode=" + instanceTwo.hashCode());
			if(instanceOne.hashCode() == instanceTwo.hashCode()){
				System.out.println("SerializedSingletonFixed NOT BROKEN!!!");
			}
		}
	
}
