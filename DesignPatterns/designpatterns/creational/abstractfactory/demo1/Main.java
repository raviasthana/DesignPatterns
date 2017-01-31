package creational.abstractfactory.demo1;

public class Main {
	public static void main(String[] args) {
		GUIBuilder builder = new GUIBuilder();
		AbstractWidgetFactory widgetFactory = null;
		// check what platform we're on
		if (System.getProperty("os.name") == "MACOSX") {
			widgetFactory = new MacOSXWidgetFactory();
		} else {
			widgetFactory = new MsWindowsWidgetFactory();
		}
		builder.buildWindow(widgetFactory);
	}
}
