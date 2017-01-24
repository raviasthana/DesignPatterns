package structural.decorator.demo1;

//concrete component 
public class Email implements IEmail{
	
	private String content;      
	public Email(String content){
		this.content = content;   
	}
	
	@Override   
	public String getContents()   {
	    //return email content
		return content;   
	}	
}
