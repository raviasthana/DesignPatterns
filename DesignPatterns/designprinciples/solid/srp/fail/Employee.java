package solid.srp.fail;

import java.util.Date;

public class Employee {
	
	private String employeeId;
	private String name;
	private String address;
	private Date dateOfJoining;
	
	/*
	* FAIL - this is not Employee class responsibility
	* 
	* This logic belongs in class which deals with HR policy specific implementation
	*/
	public boolean isPromotionDueThisYear(){
		//Promotion logic implementation
		return true;
	}

	/*
	* FAIL - this is not Employee class responsibility
	* 
	* This logic belongs in class which deals with Finance Department's 
	* task specific implementation
	*/
	public Double calcIncomeTaxForCurrentYear(){
		//Income tax calculation logic here
		return new Double(0.0);
	}
	
	//Getters/Setters for private attributes??
}
