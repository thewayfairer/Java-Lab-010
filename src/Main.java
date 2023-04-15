import java.io.IOException;

/**
 * Main class to test the WeatherStation and display classes.
 *
 * Author: [Ricky G]
 */
public class Main {

    /**
     * Main method that creates instances of WeatherStation and the three display classes,
     * registers the displays with the WeatherStation, and simulates a change in weather
     * conditions to trigger the update and display methods of each display.
     *
     * @param args command-line arguments (unused)
     */
    public static void main(String[] args) throws IOException {
        WeatherStation weatherStation = new WeatherStation();

        CurrentConditions currentConditions = new CurrentConditions(weatherStation);
        StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherStation);
        ForecastDisplay forecastDisplay = new ForecastDisplay(weatherStation);

        weatherStation.registerDisplay(currentConditions);
        weatherStation.registerDisplay(statisticsDisplay);
        weatherStation.registerDisplay(forecastDisplay);

        // Simulate a change in weather conditions
        weatherStation.measure();
    }
}
