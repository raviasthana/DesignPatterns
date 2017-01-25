package behavioural.chainofresponsibility.demo1;

public class BusinessMailHandler implements EmailHandler{
	
	private EmailHandler next;
	
	@Override
	public void setNext(EmailHandler handler){
		next = handler;
	}
	
	@Override
	public void handleRequest(Email email){
		
		if(!email.getFrom().endsWith("@businessaddress.com")){
			next.handleRequest(email);}
		else{    
				//handle request (move to correct folder)
		}
	}
}