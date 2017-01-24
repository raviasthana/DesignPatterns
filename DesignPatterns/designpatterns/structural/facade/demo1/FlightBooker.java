package structural.facade.demo1;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FlightBooker{  
	public List<Flight> getFlightsFor(Date from, Date to)   {      
		//returns flights available in the particular date range
		return new ArrayList<Flight>();
	}
}