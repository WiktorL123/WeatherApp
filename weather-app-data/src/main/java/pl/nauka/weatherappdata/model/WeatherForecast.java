package pl.nauka.weatherappdata.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class WeatherForecast {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;
    private LocalDateTime dateTime;
    private double maxTemperature;
    private double minTemperature;
    private String description;

    public WeatherForecast() {
    }

    public WeatherForecast(long id, City city, LocalDateTime dateTime, double maxTemperature, double minTemperature, String description) {
        this.id = id;
        this.city = city;
        this.dateTime = dateTime;
        this.maxTemperature = maxTemperature;
        this.minTemperature = minTemperature;
        this.description = description;
    }

}
