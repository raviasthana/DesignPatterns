package solid.dip.pass;

public class WeatherApi2 implements WeatherSource {
	
    @Override
    public double getTemperatureCelcius() {
        return toCelcius(getTemperatureFahrenheit());
    }
 
    private double getTemperatureFahrenheit() {
        return (32 * 1.8) + 32;
    }
 
    private double toCelcius(double temperatureFahrenheit) {
        return (temperatureFahrenheit - 32) / 1.8f;
    }
}