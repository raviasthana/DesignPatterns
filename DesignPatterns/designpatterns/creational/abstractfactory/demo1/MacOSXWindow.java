package creational.abstractfactory.demo1;

//ConcreteProductA2
public class MacOSXWindow implements Window {
	@Override
	public void setTitle(String title) {
		// Mac OSX specific behaviour
	}

	@Override
	public void repaint() {
		// Mac OSX specific behaviour
	}
}