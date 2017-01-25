package behavioural.chainofresponsibility.demo1;

public class EmailProcessor{
	//maintain a reference to the previous handler so we can add the next one
	private EmailHandler firstHandler;
	private EmailHandler prevHandler;
	
	public void addHandler(EmailHandler handler){
		if(prevHandler != null){
			prevHandler.setNext(handler);
		}else{
			//first handler in the chain
			firstHandler = handler;
		}
		
		prevHandler = handler;		
	}
	
	public void handleRequest(Email email){
		firstHandler.handleRequest(email);
	}
}
