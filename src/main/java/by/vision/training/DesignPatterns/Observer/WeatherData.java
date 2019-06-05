package by.vision.training.DesignPatterns.Observer;

import java.util.Observable;

public class WeatherData extends Observable {

    float temperature;
    float humidity;
    float pressure;

    public void measurementChanged(){
        setChanged();
        notifyObservers();
    }

    public  void setMeasurements(float temperature, float pressure, float humidity){
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        measurementChanged();
    }

    public float getTemperature() {
        return temperature;
    }

    public float getPressure() {
        return pressure;
    }

    public float getHumidity() {
        return humidity;
    }
}
