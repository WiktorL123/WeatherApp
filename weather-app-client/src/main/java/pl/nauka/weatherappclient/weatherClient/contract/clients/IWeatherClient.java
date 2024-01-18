package pl.nauka.weatherappclient.weatherClient.contract.clients;

import pl.nauka.weatherappclient.weatherClient.contract.CityInfoDto;
import pl.nauka.weatherappclient.weatherClient.contract.ConditionsDto;
import pl.nauka.weatherappclient.weatherClient.contract.ForecastDto;

import java.util.List;


public interface IWeatherClient {
    List<CityInfoDto>getCityInfo(String cityName);
    List<ConditionsDto> getCurrentWeather(String cityKey, String cityName);

    ForecastDto getWeatherForecast(String cityKey, String cityName);



}
