package behavioural.chainofresponsibility.demo1;

//Handler
public interface EmailHandler{
	//reference to the next handler in the chain
	public void setNext(EmailHandler handler);
	//handle request
	public void handleRequest(Email email);
}