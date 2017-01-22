package solid.dip.fail;

/*
 * Why this is a FAIL?
 * 
 * This solution has serious design flaws. Firstly, our weather aggregator 
 * knows about concrete APIs it uses e.g. it has to deal with the fact that 
 * WeatherApi2 returns temperature in Fahrenheits. This means that our 
 * high-level aggregating policy is dependent on details of low-level data sources.
 * 
 * Secondly, our aggregator creates concrete objects by itself. It both rises the 
 * level of coupling and violates Single Responsibility Principle.
 * 
 * Thirdly, each new API requires us to change WeatherAggregator class. 
 * This is an Open-Closed Principle violation.
 */
public class WeatherAggregator {
	
    private WeatherApi1 weatherApi1 = new WeatherApi1();
    private WeatherApi2 weatherApi2 = new WeatherApi2();

    public double getTemperature() {
        return (weatherApi1.getTemperatureCelcius() + toCelcius(weatherApi2.getTemperatureFahrenheit())) / 2;
    }

    private double toCelcius(double temperatureFahrenheit) {
        return (temperatureFahrenheit - 32) / 1.8f;
    }
}
