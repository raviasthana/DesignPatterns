package behavioural.chainofresponsibility.demo1;

public class Email {
	
	private String from;
	private String to;
	
	public Email(String from, String to) {
		this.from = from;
		this.to = to;
	}
	
	public String getFrom() {
		return from;
	}

	public String getTo() {
		return to;
	}	
}
