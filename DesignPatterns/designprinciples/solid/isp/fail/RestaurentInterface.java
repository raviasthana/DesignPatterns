package solid.isp.fail;

/*
 * A FAT interface violating ISP principle of 
 * SOLID design principle guidelines
 * 
 * This interface also breaks SRP principle as
 * order and payment are two separate responsibilities
 * and should be kept in separate interfaces
 */
public interface RestaurentInterface {
	
	void acceptOnlineOrder();
	void takeTelephonOrder();
	void walkInCustomerOrder();
	void payOnline();
	void payInPerson();
}
