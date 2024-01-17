package pl.nauka.weatherappupdater.mapers;

import org.springframework.stereotype.Component;
import pl.nauka.weatherappclient.weatherClient.contract.CityDto;
import pl.nauka.weatherappclient.weatherClient.contract.ConditionsDto;
import pl.nauka.weatherappdata.model.WeatherConditions;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
@Component
public class WeatherConditionsMapper implements IMapEntity<WeatherConditions, ConditionsDto> {
    CityMapper cityMapper;
    CityDto cityDto;


    @Override
    public WeatherConditions map(ConditionsDto conditionsDto) {
        return map(conditionsDto, new WeatherConditions());
    }

    @Override
    public WeatherConditions map(ConditionsDto dto, WeatherConditions conditions) {
        var city=cityMapper.map(cityDto);
        conditions.setDescription(dto.getWeatherText());
        conditions.setCity(city);
        conditions.setTemperature(dto.getTemperature().getMetric().getValue());
        conditions.setDate(parseToLocalDateTime(dto.getLocalObservationDateTime()));
        return conditions;
    }
    private static LocalDateTime parseToLocalDateTime(String dateTimeString) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-ddHH:mm:ssXXX");

        return LocalDateTime.parse(dateTimeString.replace("T", ""), formatter);
    }
}
