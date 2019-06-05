package by.vision.training.DesignPatterns.Observer;

import java.util.Observable;
import java.util.Observer;

public class CurrentConditionsDisplay implements Observer, DisplayElement {
    Observable o;
    float temperature;
    float humidity;

    public CurrentConditionsDisplay(Observable o) {
        this.o = o;
        o.addObserver(this);
    }

    @Override
    public void display() {

        System.out.println("Temperature: "+temperature+". humidity: "+humidity);

    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof WeatherData){
            WeatherData weatherData = (WeatherData) o;
            this.temperature = weatherData.getTemperature();
            this.humidity = weatherData.getHumidity();
            display();
        }
    }
}
