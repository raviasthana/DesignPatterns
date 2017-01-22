package solid.dip.pass;

/*
 * Adapter Pattern	
 * 
 * Adapter Pattern is a design pattern that allows us to use a class via an 
 * interface it does not derive from. It is implemented in two variations 
 * – class adapter (using inheritance) and object adapter (using composition). 
 * Example below shows the use  of the object variation. 
 * 
 * Adapter pattern can be used to invert a dependency on a class that is not 
 * under our control e.g. comes from an external library. In such case, we make 
 * the adapter derive from our abstraction and call the desired class.
 */

/*
 * We want to use SpringWeatherApi in our aggregator, but we can’t make it implement
 * WeatherSource directly. What we can do, is create an adapter that implements
 * WeatherSource and internally uses SpringWeatherApi. Here’s the code:
 */
public class SpringWeatherApiAdapter implements WeatherSource {
	
    private SpringWeatherApi weatherApi;
 
    public SpringWeatherApiAdapter(SpringWeatherApi weatherApi) {
        this.weatherApi = weatherApi;
    }
 
    @Override
    public double getTemperatureCelcius() {
        return toCelcius(weatherApi.getTemperatureFahrenheit());
    }
 
    private double toCelcius(double temperatureFahrenheit) {
        return (temperatureFahrenheit - 32) / 1.8f;
    }
}