package pl.nauka.weatherappdata.repositories;

import org.springframework.stereotype.Component;

@Component
public interface ICatalogData {
    CityRespository getCities();
    WeatherConditionsRepository getWeatherConditions();
    WeatherForecastRepository getWeatherForecast();
}
