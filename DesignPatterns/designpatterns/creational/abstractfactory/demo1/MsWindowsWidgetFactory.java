package creational.abstractfactory.demo1;

//ConcreteFactory1
public class MsWindowsWidgetFactory implements AbstractWidgetFactory {
	// create an MSWindow
	@Override
	public Window createWindow() {
		MSWindow window = new MSWindow();
		return window;
	}
}