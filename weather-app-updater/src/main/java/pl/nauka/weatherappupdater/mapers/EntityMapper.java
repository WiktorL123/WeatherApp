package pl.nauka.weatherappupdater.mapers;

import lombok.AllArgsConstructor;
import pl.nauka.weatherappclient.weatherClient.contract.city.CityDto;
import pl.nauka.weatherappclient.weatherClient.contract.conditions.ConditionsDto;
import pl.nauka.weatherappclient.weatherClient.contract.forecast.ForecastDto;
import pl.nauka.weatherappdata.model.City;
import pl.nauka.weatherappdata.model.WeatherConditions;
import pl.nauka.weatherappdata.model.WeatherForecast;
@AllArgsConstructor
public class EntityMapper implements ICatalogMappers{
    IMapEntity<City, CityDto> forCity;
    IMapEntity<WeatherConditions, ConditionsDto> forConditions;
    IMapEntity<WeatherForecast, ForecastDto> forForecast;
    @Override
    public IMapEntity<City, CityDto> forCity() {
        return forCity;
    }

    @Override
    public IMapEntity<WeatherForecast, ForecastDto> forForecast() {
        return forForecast;
    }

    @Override
    public IMapEntity<WeatherConditions, ConditionsDto> forConditions() {
        return forConditions;
    }
}
