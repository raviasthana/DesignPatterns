package solid.dip.pass;

/*
 * This is the high level abstraction used by WeatherAggregator. 
 * This abstraction will sit b/w high level and low level classes. 
 * High level class will use this abstraction and low level class
 * will implement this abstraction. 
 */
public interface WeatherSource {
	double getTemperatureCelcius();
}
