package creational.abstractfactory.demo1;

//ConcreteProductA1
public class MSWindow implements Window {
	@Override
	public void setTitle(String title) {
		// MS Windows specific behaviour
	}
	
	@Override
	public void repaint() {
		// MS Windows specific behaviour
	}
}
