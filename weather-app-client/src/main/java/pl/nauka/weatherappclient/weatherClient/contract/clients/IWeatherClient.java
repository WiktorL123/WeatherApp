package pl.nauka.weatherappclient.weatherClient.contract.clients;

import pl.nauka.weatherappclient.weatherClient.contract.CityDto;
import pl.nauka.weatherappclient.weatherClient.contract.ConditionsDto;
import pl.nauka.weatherappclient.weatherClient.contract.DailyForecastDto;
import pl.nauka.weatherappclient.weatherClient.contract.ForecastDto;

import java.util.List;


public interface IWeatherClient {
    List<CityDto>getCityInfo(String cityName);
    List<ConditionsDto> getCurrentWeather(String cityKey);

    ForecastDto getWeatherForecast(String cityKey);



}
