package pl.nauka.weatherappupdater.mapers;

import org.springframework.stereotype.Component;
import pl.nauka.weatherappclient.weatherClient.contract.city.CityDto;
import pl.nauka.weatherappclient.weatherClient.contract.forecast.DailyForecastDto;
import pl.nauka.weatherappdata.model.WeatherForecast;
@Component
public class ForecastMapper implements IMapEntity<WeatherForecast, DailyForecastDto> {
    CityMapper cityMapper;
    CityDto cityDto;

    @Override
    public WeatherForecast map(DailyForecastDto forecastDto) {
        return map(forecastDto, new WeatherForecast());
    }

    @Override
    public WeatherForecast map(DailyForecastDto dto, WeatherForecast weatherForecast) {

        var city = cityMapper.map(cityDto);
        weatherForecast.setCity(city);
        weatherForecast.setMaxTemperature(dto.getTemperature().getMaximum().getValue());
        weatherForecast.setMinTemperature(dto.getTemperature().getMinimum().getValue());


        return weatherForecast;
    }
}


