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

    @ManyToOne(cascade = CascadeType.ALL)
    //@JoinColumn(name = "city_key")
    @JoinColumn(name = "city_id")
    private City city;

    @Column(name = "date")
    private LocalDateTime dateTime;

    @Column(name = "max_temperature")
    private double maxTemperature;

     @Column(name = "min_temperature")
    private double minTemperature;

    @Column(name = "description")
    private String description;

    public WeatherForecast() {
    }

    public WeatherForecast(LocalDateTime dateTime, double maxTemperature, double minTemperature, String description) {


        this.dateTime = dateTime;
        this.maxTemperature = maxTemperature;
        this.minTemperature = minTemperature;
        this.description = description;
    }

}
