package solid.dip.pass;

public class WeatherApi1 implements WeatherSource {
	
	@Override
	public double getTemperatureCelcius(){
		return 32;
	}
}
