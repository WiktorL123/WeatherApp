package pl.nauka.weatherappupdater.mapers;

import org.springframework.stereotype.Component;
import pl.nauka.weatherappclient.weatherClient.contract.CityInfoDto;
import pl.nauka.weatherappclient.weatherClient.contract.ConditionsDto;

import pl.nauka.weatherappdata.model.WeatherConditions;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
@Component
public class WeatherConditionsMapper {

    CityMapper cityMapper;


    public WeatherConditionsMapper(CityMapper cityMapper) {
        this.cityMapper = cityMapper;
    }


    public WeatherConditions map(ConditionsDto conditionsDto, CityInfoDto cityDto) {
        return map(conditionsDto, new WeatherConditions(), cityDto);
    }


    public WeatherConditions map(ConditionsDto dto, WeatherConditions conditions, CityInfoDto cityDto) {
        var city=cityMapper.map(cityDto);
        conditions.setDescription(dto.getWeatherText());
        conditions.setCity(city);
        conditions.setTemperature(dto.getTemperature().getMetric().getValue());
        conditions.setDate(parseToLocalDateTime(dto.getLocalObservationDateTime()));
        conditions.setCity(city);
        System.out.println(conditions.getCity().getCityName());
        return conditions;
    }
    private static LocalDateTime parseToLocalDateTime(String dateTimeString) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-ddHH:mm:ssXXX");

        return LocalDateTime.parse(dateTimeString.replace("T", ""), formatter);
    }
}
