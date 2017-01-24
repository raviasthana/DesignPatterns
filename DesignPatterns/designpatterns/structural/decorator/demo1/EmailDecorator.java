package structural.decorator.demo1;

public abstract class EmailDecorator implements IEmail {

	//wrapped component   
	IEmail originalEmail; 
}
