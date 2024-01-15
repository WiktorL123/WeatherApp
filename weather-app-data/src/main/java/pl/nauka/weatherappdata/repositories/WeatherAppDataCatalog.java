package pl.nauka.weatherappdata.repositories;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
@Getter
public class WeatherAppDataCatalog implements ICatalogData{
    private final WeatherForecastRepository weatherForecastRepository;
    private final WeatherConditionsRepository weatherConditionsRepository;
    private final CityRespository cityRespository;

    @Override
    public CityRespository getCities() {
        return cityRespository;
    }

    @Override
    public WeatherConditionsRepository getWeatherConditions() {
        return weatherConditionsRepository;
    }

    @Override
    public WeatherForecastRepository getWeatherForecast() {
        return weatherForecastRepository;
    }


}
