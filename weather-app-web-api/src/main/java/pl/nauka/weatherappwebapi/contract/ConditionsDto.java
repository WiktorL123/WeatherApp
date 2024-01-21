package pl.nauka.weatherappwebapi.contract;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class ConditionsDto {
    private CityDto city;
    private double temperature;
    private String description;
    private LocalDateTime date;
}
