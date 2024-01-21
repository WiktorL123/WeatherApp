package pl.nauka.weatherappupdater.mapers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.nauka.weatherappclient.weatherClient.contract.CityInfoDto;
import pl.nauka.weatherappclient.weatherClient.contract.ConditionsDto;

import pl.nauka.weatherappdata.model.City;
import pl.nauka.weatherappdata.model.WeatherConditions;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
@Component
@RequiredArgsConstructor
public class WeatherConditionsMapper {

    private  final CityMapper cityMapper;





    public WeatherConditions map(ConditionsDto conditionsDto, City city) {
        return map(conditionsDto, new WeatherConditions(), city);
    }


    public WeatherConditions map(ConditionsDto dto, WeatherConditions conditions, City city) {
      //  var city=cityMapper.map(cityDto);
        conditions.setDescription(dto.getWeatherText());
        conditions.setTemperature(dto.getTemperature().getMetric().getValue());
        conditions.setDate(parseToLocalDateTime(dto.getLocalObservationDateTime()));
        conditions.setCity(city);
        System.out.println(conditions.getCity().getCityKey());
        return conditions;
    }
    private static LocalDateTime parseToLocalDateTime(String dateTimeString) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-ddHH:mm:ssXXX");

        return LocalDateTime.parse(dateTimeString.replace("T", ""), formatter);
    }
}
