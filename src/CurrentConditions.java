/*
 * CurrentConditions.java
 * Author: [Ricky G]
 * -----------------------------
 * A class that implements Display and displays current temperature, humidity, and pressure.
 */

public class CurrentConditions implements Display {
    private WeatherStation weatherStation;
    private float temperature;
    private float humidity;
    private float pressure;

    /*
     * Constructs a CurrentConditions object that receives updates from a WeatherStation.
     */
    public CurrentConditions(WeatherStation weatherStation) {
        this.weatherStation = weatherStation;
        this.weatherStation.registerDisplay(this);
    }

    /*
     * Updates the current temperature, humidity, and pressure and calls display().
     */
    public void update() {
        temperature = weatherStation.getTemperature();
        humidity = weatherStation.getHumidity();
        pressure = weatherStation.getPressure();
        display();
    }

    /*
     * Prints out the current temperature, humidity, and pressure in a well formatted message.
     */
    public void display() {
        System.out.println("Current conditions: Temperature = " + temperature + ", Humidity = " + humidity + ", Pressure = " + pressure);
    }
}

