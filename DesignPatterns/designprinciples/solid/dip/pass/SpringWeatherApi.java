package solid.dip.pass;

/*
 * Imagine that SpringWeatherApi comes from an external library named Spring 
 * Weather and provides the temperature in Fahrenheits.
 */
public class SpringWeatherApi {

    public double getTemperatureFahrenheit() {
        return (32 * 1.8) + 32;
    }
}
