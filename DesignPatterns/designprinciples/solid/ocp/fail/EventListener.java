package solid.ocp.fail;


/*
 * FAIL - NOT CLOSED for modification
 */
public class EventListener {
	
	private NewUserService newUserService;
	private DeleteUserService deleteUserService;
	
	public EventListener(NewUserService newUserService, DeleteUserService deleteUserService){
		this.newUserService = newUserService;
		this.deleteUserService = deleteUserService;
	}
	
	//FAIL - this method will need to be modified if new event
	//needs to be added. So this class is not Closed for modification
	public void receive(Event event) throws Exception{
		if(event instanceof DeleteUserEvent){
			deleteUserService.deleteUser((DeleteUserEvent)event);
		}else if(event instanceof NewUserEvent){
			newUserService.createUser((NewUserEvent)event);
		}else{
			throw new UnhandledEventException();
		}
	}
}
