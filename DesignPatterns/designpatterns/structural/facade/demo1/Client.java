package structural.facade.demo1;

import java.util.Date;

public class Client{   
	public static void main(String[] args){
		//Client needs to deal only with the facade
		TravelFacade facade = new TravelFacade();
		Date from = new Date();
		Date to = new Date();
		
		facade.getFlightsAndHotels(from, to);   
	}
}
