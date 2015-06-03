package subjectobserver;

public class CurrentConditionsDisplay implements Observer, DisplayElement {

    private WeatherData weatherData;
    
    public CurrentConditionsDisplay(WeatherData weatherData){
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }
    
    public void unregister(){
        weatherData.unregisterObserver(this);
    }
    
    public void display() {
        String displayData = "CurrentConditions[temp=" + temp + ", humidity=" + humidity + ", pressure="
                + pressure + "]";
        System.out.println(displayData);
    }

    private float temp;
    private float humidity;
    private float pressure;
    public void update(float temp, float humidity, float pressure) {
        this.temp = temp;
        this.humidity = humidity;
        this.pressure = pressure;
        display();
    }

}
