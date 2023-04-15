/*
 * ForecastDisplay.java
 * Author: [Ricky G]
 * -----------------------------
 * A class that implements Display and displays a weather forecast.
 */

public class ForecastDisplay implements Display {
    private WeatherStation weatherStation;
    private float lastPressure;
    private float currentPressure;

    /*
     * Constructs a ForecastDisplay object that receives updates from a WeatherStation.
     */
    public ForecastDisplay(WeatherStation weatherStation) {
        this.weatherStation = weatherStation;
        this.weatherStation.registerDisplay(this);
        lastPressure = weatherStation.getPressure();
    }

    /*
     * Updates the last and current pressure values.
     */
    public void update() {
        lastPressure = currentPressure;
        currentPressure = weatherStation.getPressure();
        display();
    }

    /*
     * Prints out a weather forecast based on the last and current pressure values.
     */
    public void display() {
        System.out.print("Forecast: ");
        if (currentPressure > lastPressure) {
            System.out.println("Improving weather on the way!");
        } else if (currentPressure == lastPressure) {
            System.out.println("More of the same");
        } else if (currentPressure < lastPressure) {
            System.out.println("Watch out for cooler, rainy weather");
        }
    }
}
