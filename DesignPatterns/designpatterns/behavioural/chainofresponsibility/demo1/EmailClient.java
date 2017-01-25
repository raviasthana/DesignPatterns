package behavioural.chainofresponsibility.demo1;

//email client 
public class EmailClient{
	
	private EmailProcessor processor;
	
	public EmailClient(){
		createProcessor();
	}
	
	private void createProcessor(){
		processor = new EmailProcessor();
		processor.addHandler(new BusinessMailHandler());
		processor.addHandler(new GMailHandler());
	}
	
	public void addRule(EmailHandler handler){   
		processor.addHandler(handler);
	}
	
	public void handleEmail(Email email){
		processor.handleRequest(email);
	}
	
	public static void main(String[] args){
		EmailClient client = new EmailClient();
		Email email = new Email("someone", "somewhere");
		client.handleEmail(email);
	}
}
