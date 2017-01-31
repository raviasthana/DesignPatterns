package creational.abstractfactory.demo1;

//ConcreteFactory2
public class MacOSXWidgetFactory implements AbstractWidgetFactory {

	@Override
	// create a MacOSXWindow
	public Window createWindow() {
		MacOSXWindow window = new MacOSXWindow();
		return window;
	}
}
