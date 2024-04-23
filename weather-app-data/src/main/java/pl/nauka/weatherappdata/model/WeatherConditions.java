package pl.nauka.weatherappdata.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor

@Entity
public class WeatherConditions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;
    private double temperature;
    private String description;
    private LocalDateTime date;

//    public WeatherConditions() {
//    }
//
    public WeatherConditions( double temperature, double humidity, double pressure, String description) {

        this.temperature = temperature;
        this.description = description;
    }

//    public long getId() {
//        return id;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }
//
//    public City getCity() {
//        return city;
//    }
//
//    public void setCity(City city) {
//        this.city = city;
//    }
//
//    public double getTemperature() {
//        return temperature;
//    }
//
//    public void setTemperature(double temperature) {
//        this.temperature = temperature;
//    }
//
//    public double getHumidity() {
//        return humidity;
//    }
//
//    public void setHumidity(double humidity) {
//        this.humidity = humidity;
//    }
//
//    public double getPressure() {
//        return pressure;
//    }
//
//    public void setPressure(double pressure) {
//        this.pressure = pressure;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
}
