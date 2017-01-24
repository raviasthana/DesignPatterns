package structural.facade.demo1;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HotelBooker{  
	public List<Hotel> getHotelsFor(Date from, Date to)   {      
		//returns hotels available in the particular date range
		return new ArrayList<Hotel>(); 
	}
}
