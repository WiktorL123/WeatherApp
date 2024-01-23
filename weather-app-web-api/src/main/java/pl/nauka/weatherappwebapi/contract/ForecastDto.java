package pl.nauka.weatherappwebapi.contract;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
@AllArgsConstructor
public class ForecastDto {
    private String cityName;


    private LocalDateTime dateTime;


    private double maxTemperature;


    private double minTemperature;


    private String description;
}
