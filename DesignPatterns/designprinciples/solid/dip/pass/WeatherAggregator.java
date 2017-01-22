package solid.dip.pass;

import java.util.List;

/*
 * Why this is a PASS?
 * 
 * Take a look at the imports(classes used by Aggregator in this case) 
 * – concrete APIs are gone. Now it’s the WeatherSource interface that all
 * classes are pointing towards. 
 * WeatherAggregator is dependent on an abstraction that fits it’s needs and 
 * all the APIs have to implement it. It’s the low-level API classes that are
 * dependent on the high-level policy of returning temperature.
 * 
 * 
 */
public class WeatherAggregator {
	
	List<WeatherSource> weatherSources;

    //Use Dependency Injection pattern to inject WeatherSource(s)
    //this moves the responsibility of creating WeatherSource instances outside the object 
    public WeatherAggregator(List<WeatherSource> weatherSources) {
    	weatherSources = this.weatherSources;
	}
    
    public double getTemperature(){
    	return weatherSources
    			.stream()
    			.mapToDouble(WeatherSource::getTemperatureCelcius)
    			.average()
    			.getAsDouble();
    }
    
}
