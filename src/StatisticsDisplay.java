/*
 * StatisticsDisplay.java
 * Author: [Ricky G]
 * -----------------------------
 * A class that implements Display and displays minimum, maximum, and average temperature values.
 */

public class StatisticsDisplay implements Display {
    private WeatherStation weatherStation;
    private float temperatureMin;
    private float temperatureMax;
    private float temperatureTotal;
    private int numReadings;

    /*
     * Constructs a StatisticsDisplay object that receives updates from a WeatherStation.
     */
    public StatisticsDisplay(WeatherStation weatherStation) {
        this.weatherStation = weatherStation;
        this.weatherStation.registerDisplay(this);
    }

    /*
     * Updates the minimum, maximum, and average temperature values.
     */
    public void update() {
        float temperature = weatherStation.getTemperature();
        if (numReadings == 0) {
            temperatureMin = temperature;
            temperatureMax = temperature;
        } else {
            if (temperature < temperatureMin) temperatureMin = temperature;
            if (temperature > temperatureMax) temperatureMax = temperature;
        }
        temperatureTotal += temperature;
        numReadings++;
        display();
    }

    /*
     * Prints out the minimum, maximum, and average temperature values in a well formatted message.
     */
    public void display() {
        System.out.println("Temperature Statistics: Min = " + temperatureMin + ", Max = " + temperatureMax + ", Average = " + (temperatureTotal/numReadings));
    }
}

