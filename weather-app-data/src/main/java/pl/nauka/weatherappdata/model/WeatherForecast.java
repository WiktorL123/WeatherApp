package pl.nauka.weatherappdata.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public double getMaxTemperature() {
        return maxTemperature;
    }

    public void setMaxTemperature(double maxTemperature) {
        this.maxTemperature = maxTemperature;
    }

    public double getMinTemperature() {
        return minTemperature;
    }

    public void setMinTemperature(double minTemperature) {
        this.minTemperature = minTemperature;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
