package pl.nauka.weatherappupdater.mapers;

import org.springframework.stereotype.Component;
import pl.nauka.weatherappclient.weatherClient.contract.city.CityDto;
import pl.nauka.weatherappclient.weatherClient.contract.conditions.ConditionsDto;
import pl.nauka.weatherappclient.weatherClient.contract.forecast.ForecastDto;
import pl.nauka.weatherappdata.model.City;
import pl.nauka.weatherappdata.model.WeatherConditions;
import pl.nauka.weatherappdata.model.WeatherForecast;
@Component
public interface ICatalogMappers {
    IMapEntity <City, CityDto> forCity();
    IMapEntity<WeatherForecast, ForecastDto> forForecast();
    IMapEntity <WeatherConditions, ConditionsDto> forConditions();
}
