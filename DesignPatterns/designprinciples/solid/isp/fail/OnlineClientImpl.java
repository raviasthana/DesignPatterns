package solid.isp.fail;

/*
 * This class is specific to online clients only. However, it is still
 * implementing methods for other type of clients. 
 * - This is inefficient as online client specific class shoudln't have
 *   to refer to methods of different client types.
 * - Any changes to RestaurentInterface will be propagated to all implementing
 *   classes. Maintenance of code then starts becoming cumbersome and regression
 *   effects of changes will keep increasing.      
 */
public class OnlineClientImpl implements RestaurentInterface {

	@Override
	public void acceptOnlineOrder() {
		//logic for taking order online
	}

	@Override
	public void takeTelephonOrder() {
		//Not applicable for Online Order
		throw new UnsupportedOperationException();
	}

	@Override
	public void walkInCustomerOrder() {
		//Not applicable for Online Order
		throw new UnsupportedOperationException();
	}

	@Override
	public void payOnline() {
		//login for paying online
	}

	@Override
	public void payInPerson() {
		//Not applicable for Online Order
		throw new UnsupportedOperationException();
	}

}
