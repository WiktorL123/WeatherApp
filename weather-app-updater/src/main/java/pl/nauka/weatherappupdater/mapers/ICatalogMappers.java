package pl.nauka.weatherappupdater.mapers;

import org.springframework.stereotype.Component;
import pl.nauka.weatherappclient.weatherClient.contract.CityDto;
import pl.nauka.weatherappclient.weatherClient.contract.ConditionsDto;
import pl.nauka.weatherappclient.weatherClient.contract.ForecastDto;
import pl.nauka.weatherappdata.model.City;
import pl.nauka.weatherappdata.model.WeatherConditions;
import pl.nauka.weatherappdata.model.WeatherForecast;
@Component
public interface ICatalogMappers {
    IMapEntity <City, CityDto> forCity();
    IMapEntity<WeatherForecast, ForecastDto> forForecast();
    IMapEntity <WeatherConditions, ConditionsDto> forConditions();
}
