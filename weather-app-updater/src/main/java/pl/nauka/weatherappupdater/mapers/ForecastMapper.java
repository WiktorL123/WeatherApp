package pl.nauka.weatherappupdater.mapers;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Component;
import pl.nauka.weatherappclient.weatherClient.contract.CityInfoDto;
import pl.nauka.weatherappclient.weatherClient.contract.ForecastDto;
import pl.nauka.weatherappdata.model.City;
import pl.nauka.weatherappdata.model.WeatherForecast;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
@RequiredArgsConstructor
public class ForecastMapper  {
   private final CityMapper cityMapper;





    public WeatherForecast map(ForecastDto forecastDto, City city) {
        return map(forecastDto, new WeatherForecast(), city);
    }


    public WeatherForecast map(ForecastDto forecastDto, WeatherForecast weatherForecast, City city) {
        //var city=cityMapper.map(cityDto);
        weatherForecast.setDateTime(parseToLocalDateTime(forecastDto.getHeadline().getEffectiveDate()));
        weatherForecast.setMaxTemperature(forecastDto.getDailyForecasts().get(0).getTemperature().getMaximum().getValue());
        weatherForecast.setMinTemperature(forecastDto.getDailyForecasts().get(0).getTemperature().getMinimum().getValue());
        weatherForecast.setDescription(forecastDto.getHeadline().getText());
        weatherForecast.setCity(city);
       // System.out.println(weatherForecast.getCity().getCityKey());
        return weatherForecast;
    }

    private static LocalDateTime parseToLocalDateTime(String dateTimeString) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-ddHH:mm:ssXXX");

        return LocalDateTime.parse(dateTimeString.replace("T", ""), formatter);
    }
}


