package pl.nauka.weatherappclient.weatherClient.contract.clients;

import org.springframework.stereotype.Component;
import pl.nauka.weatherappclient.weatherClient.contract.city.CityDto;
import pl.nauka.weatherappclient.weatherClient.contract.conditions.ConditionsDto;
import pl.nauka.weatherappclient.weatherClient.contract.forecast.DailyForecastDto;

@Component
public interface IWeatherClient {
    CityDto getCityInfo(String cityName);
    ConditionsDto getCurrentWeather(String cityKey);

    DailyForecastDto getWeatherForecast(String cityKey);



}
