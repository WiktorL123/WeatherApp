package pl.nauka.weatherappupdater.mapers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.nauka.weatherappclient.weatherClient.contract.CityInfoDto;
import pl.nauka.weatherappclient.weatherClient.contract.ForecastDto;
import pl.nauka.weatherappclient.weatherClient.contract.clients.WeatherClient;
import pl.nauka.weatherappdata.model.WeatherForecast;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component

public class ForecastMapper  {
    CityMapper cityMapper;
    WeatherClient client;

@Autowired
    public ForecastMapper(CityMapper cityMapper, WeatherClient client) {
        this.cityMapper = cityMapper;
        this.client=client;

    }


    public WeatherForecast map(ForecastDto forecastDto, CityInfoDto cityDto) {
        return map(forecastDto, new WeatherForecast(), cityDto);
    }


    public WeatherForecast map(ForecastDto forecastDto, WeatherForecast weatherForecast, CityInfoDto cityDto) {
        var city=cityMapper.map(cityDto);
        weatherForecast.setDateTime(parseToLocalDateTime(forecastDto.getHeadline().getEffectiveDate()));
        weatherForecast.setMaxTemperature(forecastDto.getDailyForecasts().get(0).getTemperature().getMaximum().getValue());
        weatherForecast.setMinTemperature(forecastDto.getDailyForecasts().get(0).getTemperature().getMinimum().getValue());
        weatherForecast.setDescription(forecastDto.getHeadline().getText());
        weatherForecast.setCity(city);
        System.out.println(weatherForecast.getCity().getCityKey());
        return weatherForecast;
    }

    private static LocalDateTime parseToLocalDateTime(String dateTimeString) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-ddHH:mm:ssXXX");

        return LocalDateTime.parse(dateTimeString.replace("T", ""), formatter);
    }
}


