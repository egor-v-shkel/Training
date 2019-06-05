package by.vision.training.DesignPatterns.Observer;

public class Main {

    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        weatherData.addObserver(new CurrentConditionsDisplay());
        weatherData.setMeasurements(28.1f, 80.0f, 90.0f);

    }

}
